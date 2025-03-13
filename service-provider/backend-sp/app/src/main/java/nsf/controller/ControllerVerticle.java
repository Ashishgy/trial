package nsf.controller;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;
import io.vertx.core.Promise;
import io.vertx.core.http.HttpMethod;
import io.vertx.core.http.HttpServerOptions; //add
import io.vertx.core.json.Json;
import io.vertx.core.json.JsonArray;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.mongo.MongoClient;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.RoutingContext;
import io.vertx.ext.web.handler.BodyHandler;
import org.hyperledger.acy_py.generated.model.InvitationRecord;
import org.hyperledger.acy_py.generated.model.SendMessage;
import org.hyperledger.aries.AriesClient;
import org.hyperledger.aries.api.connection.ConnectionFilter;
import org.hyperledger.aries.api.out_of_band.CreateInvitationFilter;
import org.hyperledger.aries.api.out_of_band.InvitationCreateRequest;
import org.hyperledger.aries.api.present_proof.PresentProofRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import io.vertx.ext.web.FileUpload;
import io.vertx.core.buffer.Buffer;
import io.vertx.core.json.DecodeException; // Assuming the exception is related to JSON decoding
import io.vertx.ext.web.client.WebClient;
import io.vertx.ext.web.client.WebClientOptions;
import java.io.IOException;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.*;
import java.lang.Thread;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Supplier;
import io.vertx.core.buffer.Buffer;
import io.vertx.core.file.FileSystem;
import java.util.HashMap;
import java.util.Map;
import nsf.util.JwtUtil;


public class ControllerVerticle extends AbstractVerticle {
    private static final Logger logger = LoggerFactory.getLogger(ControllerVerticle.class);
    public static JsonObject computationLog = new JsonObject();
    // TODO DI
    private final MongoClient loginMongoClient;
    private  MongoClient mongoClient;
    private final String INVITATIONS_COLLECTION = "invitations";
    private final String PARTICIPANTS_COLLECTION = "participants";
    private final String SHARED_DATA_ITEMS_COLLECTION = "shared_data_items";
    private final String DATA_MENU_SETTINGS_COLLECTION = "data_menu_settings";
    private final AriesClient ariesClient;
    private String addParticipantSPID;
    private ConcurrentHashMap<String, ConcurrentHashMap<Integer, String>> dataParts = new ConcurrentHashMap<>();
    Random random = new Random();
    private String currentSPID; 

    private Boolean isUsingCredentials;


    public ControllerVerticle(MongoClient mongoClient, AriesClient ariesClient) {
        this.loginMongoClient = mongoClient;
        this.ariesClient = ariesClient;
    }

    @Override
    public void start(Promise<Void> promise) {
        Router router = Router.router(vertx);
//        router.route().handler(CorsHandler.create("*")
//            .allowedMethod(HttpMethod.GET)
//            .allowedMethod(HttpMethod.POST)
//            .allowedMethod(HttpMethod.OPTIONS)
//            .allowedMethod(HttpMethod.DELETE)
//            .allowedMethod(HttpMethod.PATCH)
//            .allowedMethod(HttpMethod.PUT)
//            .allowCredentials(true)
//            .allowedHeader("Access-Control-Allow-Headers")
//            .allowedHeader("Authorization")
//            .allowedHeader("Access-Control-Allow-Method")
//            .allowedHeader("Access-Control-Allow-Origin")
//            .allowedHeader("Access-Control-Allow-Credentials")
//            .allowedHeader("Content-Type"));
        //BodyHandler bodyHandler = BodyHandler.create().setBodyLimit(-1);

        // BodyHandler bodyHandler = BodyHandler.create().setBodyLimit(300L * 1024 * 1024); // for 300MB

        router.route().handler(BodyHandler.create());

        router.route().handler(ctx -> {
            ctx.response()
                    .putHeader("Access-Control-Allow-Origin", "*")
                    .putHeader("Access-Control-Allow-Methods", "GET, POST, OPTIONS, DELETE, PATCH, PUT")
                    .putHeader("Access-Control-Allow-Headers", "Content-Type, Authorization, userId, X-Custom-Header, Another-Header") // Allow all necessary headers
                    .putHeader("Access-Control-Allow-Credentials", "true");

            if (ctx.request().method() == HttpMethod.OPTIONS) {
                ctx.response().setStatusCode(200).end();
            } else {
                ctx.next();
            }
        });

        router.get("/participants").handler(this::listParticipants);

        router.get("/invitations").handler(this::listInvitations);
        router.post("/invitations").handler(this::createInvitation);
        router.delete("/invitations/:invitationId").handler(this::deleteInvitation);


        router.get("/data-menu-settings").handler(this::getDataMenuSettingsHandler);
        router.put("/data-menu-settings").handler(this::setDataMenuSettings);

        router.post("/pull-data").handler(this::pullDataHandler);

        router.get("/collected-data").handler(this::getCollectedData);

        router.post("/train").handler(this::trainHandler);
        router.get("/compute").handler(this::computeHandler);
        router.get("/get-logs").handler(this::computeLogHandler);

        router.post("/webhook/topic/basicmessages").handler(this::BasicMessageHandler);
        router.post("/webhook/topic/connections").handler(this::connectionsUpdateHandler);
        router.post("/webhook/topic/out_of_band").handler(this::outOfBandHandler);
        router.post("/webhook/topic/present_proof").handler(this::presentProofUpdate);
        router.post("/auth/login").handler(this::loginHandler);
        router.post("/auth/signup").handler(this::signupHandler);
        router.get("/api/secure-data").handler(this::authenticateJwt).handler(this::handleSecureData);

        int port = Integer.parseInt(System.getenv().getOrDefault("PORT", "9081"));
        HttpServerOptions options = new HttpServerOptions().setMaxFormAttributeSize(-1);
        vertx.createHttpServer(options)
                .requestHandler(router)
                .listen(port)
                .onSuccess(server -> {
                    // TODO LOGGING
                    logger.info(String.format("server running! (Should be listening at port %s)", port));
                    promise.complete();
                })
                .onFailure(promise::fail);


        isUsingCredentials = !Boolean.parseBoolean(System.getenv().get("SKIP_VERIFICATION"));
        logger.info("Using credentials: " + isUsingCredentials);
    }

    /// For the scenario of service provider we need to make sure that all the individual service providers have individual dbs
    /// But there has to be only one centralized sb for all the acoount managements
    /// we need to have both centralized and decetralized storage while creating new invitation(participants) the centralized one can be used to return which servide provider the user is actually connected to and decentralized one would be used to just pass compute requests to those participants rather than goin through all the users

    private MongoClient createServiceProviderMongoClient(String sid){
        String dbname = sid+"_db";
        JsonObject mongoConfig = new JsonObject().put("connection_string", "mongodb://host.docker.internal:27018").put("db_name",dbname);
        return MongoClient.createShared(vertx,mongoConfig,dbname);
    }

    private void getCollectedData(RoutingContext ctx){
        JsonObject allQuery = new JsonObject();
        mongoClient.find(SHARED_DATA_ITEMS_COLLECTION, allQuery, h -> {
            if (h.succeeded()){
                JsonArray response = new JsonArray(h.result());
                ctx.response().setStatusCode(200).end(response.encode());
            }
            else{
                ctx.response().setStatusCode(500).end();
            }
        });
    }

    private void loginHandler(RoutingContext context) {
        JsonObject jsonBody = context.body().asJsonObject();
        String username = jsonBody.getString("username");
        String password = jsonBody.getString("password");
        authenticateServiceProvider(username, password).onComplete(ar -> {
          if (ar.succeeded()) {
              boolean isAuthenticated = ar.result();
              if (isAuthenticated) {
                  // User is authenticated
                  String accessToken = JwtUtil.generateAccessToken(username);
    
                  JsonObject responseBody = new JsonObject()
                          .put("accessToken", accessToken);
    
                  context.response()
                        .putHeader("Content-Type", "application/json")
                        .end(responseBody.encode());
              } else {
                  // Authentication failed
                  context.response().setStatusCode(401).end("Invalid credentials");
              }
          } else {
              // Handle the error
              logger.info("Promise failed"+ar.cause());
              context.response().setStatusCode(500).end("Promise failed");
          }
      });
    }

    private Future<Boolean> authenticateServiceProvider(String username, String  password){
        Promise<Boolean> promise  = Promise.promise();
        JsonObject spQuery = new JsonObject().put("Username",username);
        try{
            loginMongoClient.findOne("service_providers", spQuery,null, findAr->{
                if(findAr.succeeded()){
                    JsonObject doc = findAr.result();
                    if(doc!=null){
                        String fetchedUsername = doc.getString("Username");
                        String fetchedPassword = doc.getString("Password");
                        if(fetchedPassword.equals(password) && fetchedUsername.equals(username)){
                            logger.info("Provided correct credentials logging the user in ");
                            promise.complete(true);
                        }
                        else{
                            logger.info("Provided credentials do not match please provide the correct credentials");
                            promise.complete(false);
                        }   
                    }
                    else{
                        logger.info("No service provider exists with the provided username");
                        promise.complete(false);
                    }
                }
                else{
                    logger.info("Error while trying to fetch the existing service provider");
                    promise.fail(findAr.cause());
                }
            });
            return promise.future();

        }
        catch(Exception e){
            logger.info("There was an error while trying to log in. Please try again later");
            promise.fail(e.toString());
            return promise.future();
        }
    }

    private void signupHandler(RoutingContext context){
        JsonObject body  = context.body().asJsonObject();
        String username  = body.getString("username");
        String password = body.getString("password");
        JsonObject signupQuery = new JsonObject().put("Username", username);
        try{
            loginMongoClient.find("service_providers",signupQuery, findAr->{
                if(findAr.succeeded()){
                    List<JsonObject> docs = findAr.result();
                    if(docs.isEmpty() || docs.size()==0 ){
                        JsonObject newSP = new JsonObject().put("Username", username).put("Password",password);
                        loginMongoClient.insert("service_providers",newSP, addAr ->{
                            if(addAr.succeeded()){
                                logger.info("New service provider has been created and added successfully to the db");
                                context.response().setStatusCode(200).end("New service provider has been successfully created and added to the database");
                            }
                            else{
                                logger.info("Failed to add new service provider please try again ");
                                context.response().setStatusCode(500).end("Failed to add new service provider, please try again later");
                            }

                        });
                    }
                    else{
                        logger.info("Service provider already exists with the given username please choose a different name");
                        context.response().setStatusCode(500).end("Service procider already exists with the given username please select a unique username");
                    }

                }
                else{
                    logger.info("There was an error while trying to fetch the existing service providers");
                    context.response().setStatusCode(500).end("There was an error while trying to fetch the existing service providers");
                }
            });
        }
        catch(Exception e){
            logger.info("There was an error while trying to create a new service provider");
            context.response().setStatusCode(500).end("There was an error while creating a new service provider");

        }
    }

    private void authenticateJwt(RoutingContext context) {
        String authHeader = context.request().getHeader("Authorization");
    
        logger.info("Received Authorization Header: {}", authHeader); // Log the received header
    
        if (authHeader != null && authHeader.startsWith("Bearer ")) {
            String token = authHeader.substring(7);  // Remove "Bearer " prefix
            logger.info("Extracted Token: {}", token); // Log the extracted token
    
            if (JwtUtil.validateToken(token)) {
              currentSPID = JwtUtil.getSPIdFromToken1(token); // Extract user ID and store it
              context.put("SP Id", currentSPID); // Store userId in the context for further use
              logger.info("SP ID extracted: {}", currentSPID); // Log the extracted user ID
              mongoClient = createServiceProviderMongoClient(currentSPID);
              context.next();  // Proceed to the next handler
            } else {
                logger.warn("Invalid or expired token provided."); // Log warning for invalid token
                context.response().setStatusCode(401).end("Invalid or expired token");
            }
        } else {
            logger.warn("Authorization header is missing or invalid."); // Log warning for missing header
            context.response().setStatusCode(401).end("Authorization header missing or invalid");
        }
    }
    
      private void handleSecureData(RoutingContext context) {
        context.response().putHeader("Content-Type", "application/json")
               .end("{\"message\":\"This is protected data.\"}");
      }

    private void setDataMenuSettings(RoutingContext ctx){
        var newDataMenuSettings = ctx.body().asJsonObject();

        JsonObject dataMenuDoc = new JsonObject()
            .put("_id", "data_menu_settings")
            .put("data", newDataMenuSettings);

        mongoClient.save(DATA_MENU_SETTINGS_COLLECTION, dataMenuDoc, h -> {
            if (h.succeeded()){
                ctx.response().setStatusCode(200).end();
            }
            else{
                ctx.response().setStatusCode(500).end();
            }
        });
    }

    private void getDataMenuSettingsHandler(RoutingContext ctx){
        getDataMenuSettings()
            .onSuccess(dataMenuSettings -> {
                ctx.response().end(dataMenuSettings.encode());
            })
            .onFailure(e -> {
                ctx.response().setStatusCode(500).end();
            });
    }

    private Future<JsonObject> getDataMenuSettings(){
        JsonObject query = new JsonObject()
            .put("_id", "data_menu_settings");
        return mongoClient.find(DATA_MENU_SETTINGS_COLLECTION, query)
            .compose(queryResults -> {
                Promise<JsonObject> promise = Promise.promise();

                if (queryResults.size() > 0){
                    promise.complete(queryResults.get(0).getJsonObject("data"));
                }
                else{
                    promise.complete(new JsonObject("""
                        {
                          "spotify": {
                            "name": "Spotify",
                            "items": {
                              "fav-artist": {
                                "name": "Most Played Artist"
                              },
                              "fav-song": {
                                "name": "Most Played Track"
                              },
                              "following-artists-count": {
                                "name": "Following Artists Count"
                              },
                              "spotify-subscription-level": {
                                "name": "Spotify Subscription Level"
                              },
                              "demo-item": {
                                "name": "Other Item (For Demo)"
                              }
                            }
                          },
                          "test-example": {
                            "name": "Test Example Data Source",
                            "items": {
                              "example": {
                                "name": "Example Data Item"
                              }
                            }
                          }
                        }
                        """));
                }

                return promise.future();
            });
    }

    /**
     * Gets the filtered user data menu view, based on what items are selected.
     */
    private Future<JsonObject> getUserDataMenu(){
        return getDataMenuSettings()
            .compose(dataMenuSettings -> {
                Promise<JsonObject> promise = Promise.promise();
                JsonObject userDataMenu = new JsonObject();

                try{
                    for (String dataSourceKey : dataMenuSettings.fieldNames()) {
                        JsonObject dataSource = dataMenuSettings.getJsonObject(dataSourceKey);
                        JsonObject dataSourceItems = dataSource.getJsonObject("items");

                        for (String dataItemKey : dataSourceItems.fieldNames()) {
                            JsonObject dataItem = dataSourceItems.getJsonObject(dataItemKey);
                            boolean selected = dataItem.getBoolean("selected", false);

                            // If selected, then add to the user data menu view:
                            if (selected){
                                // If the data source frame isn't there yet, then add it:
                                if (!userDataMenu.containsKey(dataSourceKey)){
                                    userDataMenu.put(dataSourceKey,
                                        new JsonObject()
                                            .put("name", dataSource.getString("name"))
                                            .put("items", new JsonObject())
                                    );
                                }

                                JsonObject userDataMenuSourceItems = userDataMenu
                                    .getJsonObject(dataSourceKey)
                                    .getJsonObject("items");
                                userDataMenuSourceItems.put(dataItemKey, dataItem);
                            }
                        }
                    }
                }
                catch (Exception e){
                    logger.error(e.toString());
                }

                promise.complete(userDataMenu);
                return promise.future();
            });
    }


    private void presentProofUpdate(RoutingContext ctx){
        try{
            JsonObject message = ctx.body().asJsonObject();

            logger.info("present_proof updated: " + message.encodePrettily());

            String userConnectionId = message.getString("connection_id");
            String state = message.getString("state");
            String initiator = message.getString("initiator");

            if (isUsingCredentials){
                if (initiator.equals("self") && state.equals("verified")){
                    addParticipant(userConnectionId);
                    sendBasicMessage(userConnectionId, "VERIFY_RESPONSE", true, null);
                }
            }
//            else{
//                if (initiator.equals("self")){
//                    addParticipant(userConnectionId, invitationKey);
//                }
//            }

            ctx.response().setStatusCode(200).end();
        }
        catch(Exception e){
            ctx.response().setStatusCode(500).end();
        }
    }

    /**
     * Adds a verified participant.
     */
    private Future<String> addParticipant(String userConnectionId) throws IOException {
        var connectionOptional = ariesClient.connectionsGetById(userConnectionId);
        var connection = connectionOptional.orElseThrow();
        var invitationKey = connection.getInvitationKey();
        addParticipantSPID = "";
        Promise<String> promise = Promise.promise();
        JsonObject document = new JsonObject()
            .put("_id", userConnectionId)
            .put("connId", userConnectionId)
            .put("createdAt", Instant.now().getEpochSecond())
            .put("invitationKey", invitationKey);
        
        FindSPID(invitationKey).onComplete(ar->{
            if(ar.succeeded()){
                String serviceProvID = ar.result();
                addParticipantSPID = serviceProvID;
                MongoClient mClient = createServiceProviderMongoClient(serviceProvID);
                mClient.save(PARTICIPANTS_COLLECTION, document, h->{
                    if(h.succeeded()){
                        logger.info("added participant: " + userConnectionId+ "For sp "+ serviceProvID);
                        mClient.close();
                        promise.complete(addParticipantSPID);
                    }
                    else{
                        logger.info("Failed to add participant "+h.cause());
                        mClient.close();
                        promise.fail(h.cause());
                    }
                });                
            }
            else{
                logger.info("Promise failed"+ar.cause());
                promise.fail(ar.cause());
            }

        });
        return promise.future();    

    }

    //used to find the service provider id from the inivitation key which is used to query the centralized invites database
    private Future<String> FindSPID(String id){
        Promise<String> promise = Promise.promise();
        JsonObject existingInvite = new JsonObject().put("invitationKey", id);
        loginMongoClient.findOne("centralized_invitations", existingInvite, null, findAr -> {
            if(findAr.succeeded()){
                JsonObject inviteData = findAr.result();
                promise.complete(inviteData.getString("spID"));

            }
            else{
                logger.info("Failed while trying to fetch the existing SP detailes"+ findAr.cause());
                promise.fail(findAr.cause());
            }

        });
        return promise.future();

    }

    private void connectionsUpdateHandler(RoutingContext ctx){
        try{
            JsonObject message = ctx.body().asJsonObject();

            // Docs: https://aca-py.org/latest/features/AdminAPI/#pairwise-connection-record-updated-connections
            String userConnectionId = message.getString("connection_id");
            String state = message.getString("state");

            logger.info("connection updated: " + userConnectionId + ", " + state + " - " + message.encodePrettily());

            // TODO respond with details like name, description, access requests, etc.
            if (state.equals("active")){
                logger.info("connection completed, requesting present_proof: " + userConnectionId);


                ariesClient.presentProofSendRequest(PresentProofRequest.builder()
                    .connectionId(userConnectionId)
                    .autoVerify(true)
                    .proofRequest(PresentProofRequest.ProofRequest.builder()
                        .name("demo service provider")
                        .requestedAttributes(Map.of(
                            "DL_number_referent",
                            PresentProofRequest.ProofRequest.ProofRequestedAttributes.builder()
                                .name("DL_number")
                                .clearRestrictions() // E.g. Could set to UTyGiqDxFVe5dyboi87kp2:3:CL:439783:issuer-kit-demo
                                .build()))
                        .build())
                    .build());

                if (isUsingCredentials){
                    JsonObject serverBannerData = new JsonObject()
                    .put("name", addParticipantSPID)
                    .put("desc", "Example service provider for M.S. project prototype implementation demo. Requires demo credential to connect.");
                    logger.info("Getting executed first");
                    sendBasicMessage(userConnectionId, "CONN_RESPONSE",
                        new JsonObject()
                            .put("bannerData", serverBannerData)
                            .put("requiresCredential", isUsingCredentials),
                        null);

                }
                else{
                    //changed the add participant method to return a promise containing the latest service provider as it is required to send back SP name
                    addParticipant(userConnectionId).onComplete(ar ->{
                        if(ar.succeeded()){
                            addParticipantSPID = ar.result();
                            logger.info("Getting executed after sending message");
                            JsonObject serverBannerData = new JsonObject()
                            .put("name", addParticipantSPID)
                            .put("desc", "Example service provider for M.S. project prototype implementation demo. Requires demo credential to connect.");
                            logger.info("Getting executed first");
                            sendBasicMessage(userConnectionId, "CONN_RESPONSE",
                                new JsonObject()
                                    .put("bannerData", serverBannerData)
                                    .put("requiresCredential", isUsingCredentials),
                                null);
                        }
                        else{
                            logger.info("Partcipant could not get added");
                            addParticipantSPID = "";
                        }
                    });
                }

                

            }

            ctx.response().setStatusCode(200).end();
        }
        catch(Exception e){
            ctx.response().setStatusCode(500).end();
        }
    }

    private void outOfBandHandler(RoutingContext ctx){
        try{
            JsonObject message = ctx.body().asJsonObject();

            String user_connection_id = message.getString("connection_id");
            String invitation_message_id = message.getString("invi_msg_id");

            logger.info("out of band webhook: " + user_connection_id + ", " + invitation_message_id);

            ctx.response().setStatusCode(200).end();
        }
        catch(Exception e){
            ctx.response().setStatusCode(500).end();
        }
    }

    private void listParticipants(RoutingContext ctx){
        JsonObject query = new JsonObject();
        mongoClient.find(PARTICIPANTS_COLLECTION, query)
                .onSuccess(participants -> {

//                    // Append the name of the invitation that the participant used to connect, for each participant:
//                    for (var participant : participants){
//                        String invitationName = "";
//
//                        mongoClient.find(PARTICIPANTS_COLLECTION, query).onSuccess(participants -> {
//
//                        });
//
//                        participant.put("invitationName", invitationName);
//                    }

                    ctx.response().send(new JsonArray(participants).encode());
                })
                .onFailure(e -> {
                    ctx.response().setStatusCode(500).end();
                });
    }

    private void listInvitations(RoutingContext ctx){
//        try{
////            Optional<List<ConnectionRecord>> invitationsOptional = ariesClient.connections(ConnectionFilter.builder().state(ConnectionState.INVITATION).build());
////            List<ConnectionRecord> invitations = invitationsOptional.orElse(List.of());
////
////            JsonArray invitationsJson = new JsonArray();
////            invitations.forEach(record -> {
////                invitationsJson.add(new JsonObject().put("invKey", record.getInvitationKey()));
////            });
//        }
//        catch(Exception e){
//            ctx.response().setStatusCode(500).end();
//        }

        JsonObject query = new JsonObject();
        mongoClient.find(INVITATIONS_COLLECTION, query)
            .onSuccess(invitations -> {
                ctx.response().send(new JsonArray(invitations).encode());
            })
            .onFailure(e -> {
                ctx.response().setStatusCode(500).end();
            });
    }

    private void deleteInvitation(RoutingContext ctx){
        String invitationConnectionId = ctx.pathParam("invitationId");

        JsonObject query = new JsonObject()
                .put("_id", invitationConnectionId);
        logger.info("deleting invitation id: "+invitationConnectionId);
        loginMongoClient.removeDocument("centralized_invitations",query);
        mongoClient.removeDocument(INVITATIONS_COLLECTION, query)
                .onSuccess(invitations -> {
                    try {
                        ariesClient.connectionsRemove(invitationConnectionId);
                        ctx.response().setStatusCode(200).end();
                    } catch (IOException e) {
                        ctx.response().setStatusCode(500).end();
                    }
                })
                .onFailure(e -> {
                    ctx.response().setStatusCode(500).end();
                });
    }

    private void createInvitation(RoutingContext ctx){
        try{
            String name = ctx.body().asJsonObject().getString("name");

            String temporaryKey = LocalDateTime.now().toString();
            var invitationRecord = createAriesInvitation(temporaryKey);
            String url = invitationRecord.getInvitationUrl();

            // Some relevant fields are only in the ConnectionRecord and not the InvitationRecord, so we get the ConnectionRecord:
            var invitationConnectionQuery = ariesClient.connections(ConnectionFilter.builder().alias(temporaryKey).build());
            if (invitationConnectionQuery.isEmpty() || invitationConnectionQuery.get().size() != 1){
                logger.error("failed to find the invitation connection record.");
                ctx.response().setStatusCode(500).end();
                return;
            }

            var invitationConnection = invitationConnectionQuery.get().get(0);

            JsonObject document = new JsonObject()
                    .put("_id", invitationConnection.getInvitationKey())
                    .put("invitationKey", invitationConnection.getInvitationKey())
                    .put("invitationConnId", invitationConnection.getConnectionId())
                    .put("invitationMsgId", invitationRecord.getInviMsgId())
                    .put("name", name)
                    .put("createdAt", Instant.now().getEpochSecond())
                    .put("url", url)
                    .put("spID", currentSPID); // Add userId field with an empty string

            loginMongoClient.save("centralized_invitations",document);
            mongoClient.save(INVITATIONS_COLLECTION, document, h -> {
                if (h.succeeded()){
                    ctx.response().send(document.encode());
                }
                else{
                    ctx.response().setStatusCode(500).end();
                }
            });
        }
        catch(Exception e){
            ctx.response().setStatusCode(500).end();
        }
    }

    /**
     * Handles post request for establishing a connection to a service provider given an invitation message JSON from
     * that service provider in the post body. This tells the ACA-Py agent that we have "received" the invitation
     * message, and progresses the state of the connection.
     *
     * The tracking ID is for identifying/distinguishing between different invitations.
     */
    private InvitationRecord createAriesInvitation(String alias){
        InvitationCreateRequest invitationCreateRequest = InvitationCreateRequest.builder()
                .accept(Arrays.asList("didcomm/aip1", "didcomm/aip2;env=rfc19"))
//                            .alias("Barry")
                .handshakeProtocols(Arrays.asList("did:sov:BzCbsNYhMrjHiqZDTUASHg;spec/didexchange/1.0"))
                .metadata(new JsonObject())
                .protocolVersion("1.1")
                .usePublicDid(false)
                .alias(alias) // Alias seems to not be in the invite, but stored locally. Docs say it's "a local alias for the connection record".
                .build();
        try {
            Optional<InvitationRecord> optionalInvitationRecord = ariesClient.outOfBandCreateInvitation(
                    invitationCreateRequest,
                    CreateInvitationFilter.builder()
                            .autoAccept(true)
                            .multiUse(true) // multiple users can use this invitation.
                            .build()
            );
            InvitationRecord invitationRecord = optionalInvitationRecord.orElseThrow(() -> new IOException("Did not initiate " +
                    "ACA-Py connection."));
            return invitationRecord;

        } catch (IOException e) {
            logger.error("Failed to generate invitation.", e);
            throw new RuntimeException(e);
        }
    }

    private void pullDataHandler(RoutingContext ctx) {

    }
    private void computeLogHandler(RoutingContext ctx){
            
            ctx.response().setStatusCode(200).putHeader("Content-Type", "application/json")
            .end(computationLog.encode());
            return;
    }
    private void computeHandler(RoutingContext ctx) {
            logger.info("handler1");
                var jsonData = new JsonObject();
                mongoClient.find(PARTICIPANTS_COLLECTION, new JsonObject())
                        .onSuccess(participantResults -> {
                            if (participantResults.size() > 0){
                                computationLog = new JsonObject();
                                for(var participant : participantResults){
                                    var connId = participant.getString("connId");
                                    logger.info("computeHandler in sp backend: " );
                                    logger.info("Compute called for connID"+connId);
                                    sendBasicMessage(connId, "COMPUTE", new JsonObject(), null);
                                }
                                ctx.response().setStatusCode(200).end();
                                return;
                            }
                            else{
                                ctx.response().setStatusCode(500).end();
                                logger.info("Compute handler: User entry doesn’t exist (e.g., the user might not have verified) - rejecting shared data.");
                                return;
                            }
                        });
        }

    
    private void trainHandler(RoutingContext ctx) {
    //     try{
    //        Optional<List<ConnectionRecord>> invitationsOptional = ariesClient.connections(ConnectionFilter.builder().state(ConnectionState.INVITATION).build());
    //        List<ConnectionRecord> invitations = invitationsOptional.orElse(List.of());

    //        JsonArray invitationsJson = new JsonArray();
    //        invitations.forEach(record -> {
    //            invitationsJson.add(new JsonObject().put("invKey", record.getInvitationKey()));
    //        });
    //    }
    //    catch(Exception e){
    //        ctx.response().setStatusCode(500).end();
    //    }
     logger.info("handler");
    
        JsonObject jsonObject;
            try {
                jsonObject = ctx.getBodyAsJson();
                String jsonString = jsonObject.encodePrettily();  // Or use .encode() for compact format
                  // Attempt to parse JSON
                logger.info(Integer.toString(jsonString.length()));
            } catch (DecodeException e) {
                logger.error("Invalid JSON format");
                return;
            }
     logger.info("handler1");
            var query = new JsonObject();
            mongoClient.find(PARTICIPANTS_COLLECTION, query)
                    .onSuccess(participantResults -> {
                        if (participantResults.size() > 0){
                            for(var participant : participantResults){
                                final var connId = participant.getString("connId");
                                final String[] divided = divideString(jsonObject.encode());
                                logger.info(Integer.toString(divided[0].length()));
                                int length = jsonObject.encodePrettily().length();
                                final int pieces = length/350000; // Number of pieces to divide the string into
                                final int n = divided.length;
                                JsonObject data = (JsonObject) jsonObject.getJsonObject("data");

                                Thread thread = new Thread(() -> {
                                    for (int i = 0; i < n; i++) {
                                        final String divided_str = divided[i];   
                                        logger.info("CLient" + data.getString("client_id") + "Piece :" + Integer.toString(i));
                                        sendBasicMessage(connId, "TRAIN", new JsonObject().put("client_id",data.getString("client_id")).put("id",i).put("total",pieces).put("value",divided_str), null);
                                
                                    }
                                });
                                    thread.start();
                            }
                        }
                        else{
                            logger.warn("User entry doesn't exist (e.g., the user might not have verified) - rejecting shared data.");
                        }
                    });
        ctx.response().setStatusCode(200).end();
        return;
    }

//    private void sendMessageToConnection(JsonObject jsonData, String connId){
//        // Build the ACA-Py Basic Message to send:
//        SendMessage basicMessageResponse = SendMessage.builder()
//                .content(jsonData.toString())
//                .build();
//
//        // Send the Basic Message via ACA-Py client:
//        try {
//            ariesClient.connectionsSendMessage(connId, basicMessageResponse);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//    }

    private Future<JsonObject> getInfoData(){
        return getUserDataMenu()
            .compose(userDataMenu -> {
                Promise<JsonObject> promise = Promise.promise();
                promise.complete(new JsonObject()
                    .put("dataMenu", userDataMenu));
                return promise.future();
            });
    }
    public  String[] divideString(String input) {
        // Check if input string is null or empty
        if (input == null || input.isEmpty()) {
            return new String[0];
        }
        
        int length = input.length();
        int pieces = length/350000; // Number of pieces to divide the string into
        int pieceSize = length / pieces; // Size of each piece
        int remainder = length % pieces; // Remainder if string length is not divisible by pieces
        
        String[] divided = new String[pieces];
        
        // Divide the string into pieces
        int startIndex = 0;
        for (int i = 0; i < pieces; i++) {
            int endIndex = startIndex + pieceSize + (i < remainder ? 1 : 0);
            divided[i] = input.substring(startIndex, endIndex);
            startIndex = endIndex;
        }
        
        return divided;
    }
    private String generateMsgId(String connId){
        return connId + "-" + String.valueOf(random.nextInt());
    }
    private void sendBasicMessage(String connId, String messageTypeId, Object dataPayload, String messageId){
        if (messageId == null){
            messageId = generateMsgId(connId);
        }

        JsonObject packagedJsonObj = new JsonObject()
            .put("uniqueMessageId", messageId + "-" + String.valueOf(random.nextInt()))
            .put("messageId", messageId)
            .put("messageTypeId", messageTypeId)
            .put("payload", dataPayload);

        SendMessage basicMessageResponse = SendMessage.builder()
            .content(packagedJsonObj.encode())
            .build();

        try {
            ariesClient.connectionsSendMessage(connId, basicMessageResponse);
        } catch (IOException e) {
            logger.error("Failed to send info response to " + connId + ": " + e.toString());
        }
    }

    private void saveSharedData(String connId, JsonArray dataSharePayload, String messageId){
        logger.info("Received shared data: ");

        JsonObject query = new JsonObject()
            .put("_id", connId);
        mongoClient.find(PARTICIPANTS_COLLECTION, query)
            .onSuccess(participantResults -> {
                if (participantResults.size() > 0){
                    for (Object dataItemShareObject : dataSharePayload){
                        JsonObject dataItemShare = (JsonObject)dataItemShareObject;
                        JsonObject sharedDataItemDoc = new JsonObject()
                            .put("participantId", connId)
                            .put("epoch_seconds", Instant.now().getEpochSecond())
                            .put("dataSourceId", dataItemShare.getString("dataSourceId"))
                            .put("dataItemId", dataItemShare.getString("dataItemId"))
                            .put("data", dataItemShare.getValue("data"));
                        mongoClient.save(SHARED_DATA_ITEMS_COLLECTION, sharedDataItemDoc);
                    }
                    logger.info("Accepted shared data.");
                    sendBasicMessage(connId, "SHARED_DATA_ACK", dataSharePayload.size(), messageId);
                }
                else{
                    logger.warn("User not verified - rejecting shared data.");
                    sendBasicMessage(connId, "SHARED_DATA_ACK", -1, messageId);
                }
            });
    }

    HashSet<String> uniqueMessagesMap = new HashSet<>();

    /**
     * Handles receival of DIDComm basic message and sends the message to the required destination.
     */
    private void BasicMessageHandler(RoutingContext webhookCtx){
        JsonObject message = webhookCtx.body().asJsonObject();

        String connId = message.getString("connection_id");
        JsonObject basicMessagePackage = new JsonObject(message.getString("content"));

        String uniqueMessageId = basicMessagePackage.getString("uniqueMessageId");
        if (uniqueMessagesMap.contains(uniqueMessageId)){
            logger.warn("Duplicate message: " + message.encodePrettily());
            return;
        }
        uniqueMessagesMap.add(uniqueMessageId);

//        String threadNonceId = basicMessagePackage.getString("threadNonceId");
        String messageId = basicMessagePackage.getString("messageId");
        String messageTypeId = basicMessagePackage.getString("messageTypeId");

//        logger.info("Received basic message: " + message.encodePrettily());
        logger.info("Received basic message: " + messageTypeId);

        switch (messageTypeId){
            case "ESTABLISH_DATA_CONN_REQUEST": // a user wants to establish a connection with us.
                break;
            case "INFO_REQUEST": // a user wants to get the current data menu info, etc.
                getInfoData()
                    .onSuccess(infoData -> {
                        sendBasicMessage(connId, "INFO_RESPONSE", infoData, messageId);
                    });
                break;
            case "SHARED_DATA": // a user shared data to us.
                JsonArray payloadData = basicMessagePackage.getJsonArray("payload");
                saveSharedData(connId, payloadData, messageId);
                break;
            case "TRAIN_RESPONSE":
                {
                    JsonObject payloadResponseData = (JsonObject)basicMessagePackage.getJsonObject("payload");
                    int id = payloadResponseData.getInteger("id");
                    logger.info("Received segment ID: " + id);

                    int total = payloadResponseData.getInteger("total");
                    String content = payloadResponseData.getString("value");

                    // Get or create a map for storing segments for this specific connection
                    ConcurrentHashMap<Integer, String> segments = dataParts.computeIfAbsent(connId, k -> new ConcurrentHashMap<>());
                    
                    // Store the current segment
                    segments.put(id, content);

                    // Check if all segments from 0 to total-1 are present
                    if (segments.size() == total && segments.keySet().stream().sorted().reduce((a, b) -> a + 1 == b ? b : -1).orElse(-1) + 1 == total) {
                        StringBuilder fullContent = new StringBuilder();
                        for (int i = 0; i < total; i++) {
                            fullContent.append(segments.get(i));
                        }
                        
                        // Log that we are sending the complete payload
                        logger.info("Sending full payload");
                        JsonObject completeData = new JsonObject().put("completeData", fullContent.toString());

                        WebClient webClient = WebClient.create(vertx, new WebClientOptions().setSsl(false));
                        webClient.post(4500, "flserver", "/response") 
                            .sendJsonObject(completeData)
                            .onSuccess(res -> logger.info("Payload sent successfully"))
                            .onFailure(err -> logger.error("Failed to send payload: " + err.getMessage()));

                        // Clear the segments map for this connection to free up memory
                        dataParts.remove(connId);
                    } else {
                        // Log waiting for more segments
                        logger.info("Waiting for more segments. Current count: " + segments.size() + "/" + total);
                    }
                }
                
                break;
            case "COMPUTE_RESPONSE":
                {

                    JsonObject computeResponseData = (JsonObject)basicMessagePackage.getJsonObject("payload");
                    logger.info(computeResponseData.toString());
                    computeResponseData.getMap().forEach((key, value) -> {
                        computationLog.put(key, value);
                    });
                    //computationLog = computeResponseData.copy();
                    // return computeResponseData;
                }
            break;
            case "ABANDONED_DATA_CONN": // a user left / closed a connection with us.
                break;
            default:
                logger.error("basic message did not match a message type: " + messageTypeId);
                break;
        }

        webhookCtx.response().setStatusCode(200).end();

//        String stress_score_date_timestamp = pushed_data.getJsonObject("stress-score-data").getString("timestamp");
//
//        // TODO REMOVE BELOW:
//        JsonObject json_body_to_send = new JsonObject()
//            .put("connection_id", user_connection_id)
//            .put("date_time", stress_score_date_timestamp)
//            .put("data", pushed_data);
//         logger.info("Sending stress score to backend..." + json_body_to_send.toString());
//        // TODO: handle message: https://vertx.io/docs/vertx-core/java/#_writing_request_headers
//        // Get an async object to control the completion of the test
//        //HttpClient client = vertx.createHttpClient();
//        WebClient client = WebClient.create(vertx);
//        int port = Integer.parseInt(System.getenv().getOrDefault("BACKEND_API_PORT", "8000"));
//        String host = System.getenv().getOrDefault("BACKEND_API_HOST", "localhost");
//        client.post(port, host, "/api/stress_score/")
//            .expect(ResponsePredicate.JSON)
//            .sendJsonObject(json_body_to_send)
//            .onSuccess(res -> {
//                 logger.info("Received response with status code " + res.statusCode());
//                 logger.info("Received response: " + res.bodyAsString());
//            })
//            .onFailure(err -> {
//                 logger.info("ERROR SENDING TO BACKEND " + err.getMessage());
//            });



//         response -> {
//                    HttpClientRequest request = response.result();
//                    request.response().onSuccess(final_response -> {
//                         logger.info("Received response with status code " + final_response.statusCode());
//                    });
//                    request.putHeader("Content-Type", "application/json");
//                    request.end(json_body_to_send.encode());
//                }
    }
}
