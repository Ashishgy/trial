package nsf.controller;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Promise;
import io.vertx.core.http.HttpMethod;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.RoutingContext;
import io.vertx.ext.web.handler.BodyHandler;
import org.hyperledger.acy_py.generated.model.InvitationRecord;
import org.hyperledger.aries.AriesClient;
import org.hyperledger.aries.api.credential_definition.CredentialDefinition;
import org.hyperledger.aries.api.credentials.CredentialAttributes;
import org.hyperledger.aries.api.credentials.CredentialPreview;
import org.hyperledger.aries.api.issue_credential_v1.V1CredentialOfferRequest;
import org.hyperledger.aries.api.out_of_band.CreateInvitationFilter;
import org.hyperledger.aries.api.out_of_band.InvitationCreateRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import io.vertx.ext.mail.MailClient;
import io.vertx.ext.mail.MailConfig;
import io.vertx.ext.mail.MailMessage;
import io.vertx.ext.mail.MailResult;

import java.io.IOException;
import java.util.*;

public class ControllerVerticle extends AbstractVerticle {
    private static final Logger logger = LoggerFactory.getLogger(ControllerVerticle.class);

    private final AriesClient ariesClient;

    Random random = new Random();

    MailClient mailClient;

    String credDefId;

    public ControllerVerticle(AriesClient ariesClient) {
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
        router.route().handler(BodyHandler.create());

        router.route().handler(ctx -> {
            ctx.response()
                    .putHeader("Access-Control-Allow-Origin", "*")
                    .putHeader("Access-Control-Allow-Methods", "GET, POST, OPTIONS, DELETE, PATCH, PUT")
                    .putHeader("Access-Control-Allow-Headers", "Content-Type, Authorization")
                    .putHeader("Access-Control-Allow-Credentials", "true");

            if (ctx.request().method() == HttpMethod.OPTIONS) {
                ctx.response().setStatusCode(200).end();
            } else {
                ctx.next();
            }
        });

        router.post("/send-email").handler(this::sendEmail);
        router.post("/webhook/topic/connections").handler(this::connectionsUpdateHandler);
        router.post("/webhook/topic/out_of_band").handler(this::outOfBandHandler);
        router.post("/webhook/topic/issue_credential").handler(this::issueCredentialUpdate);
        router.post("/verify/:verificationCode").handler(this::verify);

        int port = Integer.parseInt(System.getenv().getOrDefault("PORT", "9082"));
        vertx.createHttpServer()
                .requestHandler(router)
                .listen(port)
                .onSuccess(server -> {
                    // TODO LOGGING
                    logger.info(String.format("server running! (Should be listening at port %s)", port));
                    promise.complete();
                })
                .onFailure(promise::fail);



        MailConfig config = new MailConfig();
        config.setHostname("smtp.gmail.com");
        config.setPort(587);
        // https://stackoverflow.com/questions/62302054/smtp-error-535-5-7-8-username-and-password-not-accepted-for-gmail-in-go
        config.setUsername("bbmucha@gmail.com");
        config.setPassword("mwjw xiyz nzmc ilbx");
        config.setStarttls(io.vertx.ext.mail.StartTLSOptions.REQUIRED);

//        MailClient mailClient = MailClient.createNonShared(vertx, config);
        mailClient = MailClient.create(vertx, config);


        credDefId = System.getenv().getOrDefault("CRED_DEF_ID", "A9A3zmbBnPT6RcrKvTf9q7:3:CL:97:default2");
        logger.info("Using Cred Def ID: " + credDefId);
    }

    private HashMap<String, String> verificationCodes = new HashMap<>();

    private void verify(RoutingContext ctx){
        String verificationCode = ctx.pathParam("verificationCode");

        if (verificationCodes.containsKey(verificationCode)){
            String invitationUrl = verificationCodes.get(verificationCode);
            if (invitationUrl.equals("")){
                var invitationRecord = createAriesInvitation();
                String newInvitationUrl = invitationRecord.getInvitationUrl();
                verificationCodes.put(verificationCode, newInvitationUrl);
                logger.info("made new invitation.");
                ctx.response().setStatusCode(200).end(newInvitationUrl);
            }
            else{
                logger.info("reusing previous invitation.");
                ctx.response().setStatusCode(200).end(invitationUrl);
            }

        }
        else{
            ctx.response().setStatusCode(400).end("Bad verification code.");
        }
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
                logger.info("connection completed, sending credential offer: " + userConnectionId);

                var credential = new CredentialPreview();
                credential.setAttributes(List.of(
                        CredentialAttributes.builder().name("address").value("t").build(),
                        CredentialAttributes.builder().name("age").value("t").build(),
                        CredentialAttributes.builder().name("DL_number").value("t").build(),
                        CredentialAttributes.builder().name("expiry").value("t").build()
                        ));
                ariesClient.issueCredentialSendOffer(V1CredentialOfferRequest.builder()
                        .connectionId(userConnectionId)
                        .autoIssue(true)
                        .autoRemove(true)
                        .credentialDefinitionId(credDefId)
                        .credentialPreview(credential)
                        .comment("my email credential")
                        .build());
            }

            ctx.response().setStatusCode(200).end();
        }
        catch(Exception e){
            ctx.response().setStatusCode(500).end();
        }
    }

    private void issueCredentialUpdate(RoutingContext ctx){
        try{
            JsonObject message = ctx.body().asJsonObject();

            // Docs: https://aca-py.org/latest/features/AdminAPI/#pairwise-connection-record-updated-connections
            String userConnectionId = message.getString("connection_id");
            String state = message.getString("state");
            String credentialId = message.getString("credential_id");

            logger.info("issue_credential updated: " + userConnectionId + ", " + state + ", " + credentialId + " - " + message.encodePrettily());

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

    private void sendEmail(RoutingContext ctx){
        JsonObject body = ctx.body().asJsonObject();
        try{
//            try {
//                ariesClient.credentialDefinitionsCreate(CredentialDefinition.CredentialDefinitionRequest.builder()
//                    .schemaId("H8PQPzkm9fxLxPG6eEwJKL:2:Schema_DriversLicense_v2:1.0.1")
//                    .supportRevocation(false)
//                    .tag("default")
//                    .build());
//                logger.info("Created credential definition.");
//            } catch (Exception e) {
//                logger.error("Exception when creating cred definition: " + e.toString());
//            }

            String newVerificationCode = UUID.randomUUID().toString().substring(0, 10);

            MailMessage message = new MailMessage();
            message.setFrom("bbmucha@gmail.com");
            message.setTo(body.getString("email"));
            message.setSubject("Demo Verification Email");
            message.setText("Use this link to verify and get your credential: http://localhost:3009?verify_code=" + newVerificationCode);
            mailClient.sendMail(message, result -> {
                if (result.succeeded()) {
                    System.out.println("Mail sent successfully!");
                    MailResult mailResult = result.result();
                    System.out.println("Message ID: " + mailResult.getMessageID());

                    verificationCodes.put(newVerificationCode, "");
                    ctx.response().setStatusCode(200).end();
                } else {
                    System.out.println("Failed to send mail: " + result.cause().getMessage());
                    ctx.response().setStatusCode(500).end(result.cause().toString());
                }
            });


        }
        catch(Exception e){
            ctx.response().setStatusCode(500).end(e.toString());
        }
    }

    private InvitationRecord createAriesInvitation(){
        InvitationCreateRequest invitationCreateRequest = InvitationCreateRequest.builder()
                .accept(Arrays.asList("didcomm/aip1", "didcomm/aip2;env=rfc19"))
//                            .alias("Barry")
                .handshakeProtocols(Arrays.asList("did:sov:BzCbsNYhMrjHiqZDTUASHg;spec/didexchange/1.0"))
                .metadata(new JsonObject())
                .protocolVersion("1.1")
                .usePublicDid(false)
                .build();
        try {
            Optional<InvitationRecord> optionalInvitationRecord = ariesClient.outOfBandCreateInvitation(
                    invitationCreateRequest,
                    CreateInvitationFilter.builder()
                            .autoAccept(true)
                            .multiUse(false) // multiple users can use this invitation.
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
}
