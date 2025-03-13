package nsf.controller;

import io.vertx.core.AbstractVerticle;
import io.vertx.ext.mongo.MongoClient;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.RoutingContext;
import io.vertx.ext.web.client.WebClient;
import io.vertx.core.json.JsonObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ControllerVerticle extends AbstractVerticle {
    private static final Logger logger = LoggerFactory.getLogger(ControllerVerticle.class);
    private MongoClient oauthMongoClient;
    private MongoClient locationMongoClient;
    private WebClient webClient;

    // OAuth credentials loaded from environment variables
    private String clientId = System.getenv("GOOGLE_CLIENT_ID");
    private String clientSecret = System.getenv("GOOGLE_CLIENT_SECRET");
    private String redirectUri = System.getenv("GOOGLE_REDIRECT_URI");
    private String tokenUrl = System.getenv("GOOGLE_TOKEN_URL");
    private String authUrl = System.getenv("GOOGLE_AUTH_URL");

    // Spotify credentials loaded from environment variables
    private String spotifyClientId = System.getenv("SPOTIFY_CLIENT_ID");
    private String spotifyClientSecret = System.getenv("SPOTIFY_CLIENT_SECRET");
    private String spotifyTokenUrl = System.getenv("SPOTIFY_TOKEN_URL");
    private String spotifyAuthUrl = System.getenv("SPOTIFY_AUTH_URL");
    private String spotifyRedirectUri = System.getenv("SPOTIFY_REDIRECT_URI");

    @Override
    public void start() {
        Router router = Router.router(vertx);
        webClient = WebClient.create(vertx);

        // MongoDB connections using environment variables
        oauthMongoClient = MongoClient.createShared(vertx, new JsonObject()
                .put("connection_string", System.getenv("MONGO_OAUTH_DB")));

        locationMongoClient = MongoClient.createShared(vertx, new JsonObject()
                .put("connection_string", System.getenv("MONGO_MAPS_DB")));

        // OAuth routes
        router.get("/auth/google/initiate").handler(this::initiateOAuth);
        router.get("/auth/google/callback").handler(this::handleOAuthCallback);
    }

    private void initiateOAuth(RoutingContext ctx) {
        String authorizationUri = authUrl + "?client_id=" + clientId +
                "&response_type=code" +
                "&scope=https://www.googleapis.com/auth/userinfo.email" +
                " https://www.googleapis.com/auth/userinfo.profile" +
                "&redirect_uri=" + redirectUri +
                "&access_type=offline&prompt=consent";
        ctx.response().putHeader("Location", authorizationUri).setStatusCode(302).end();
    }

    private void handleOAuthCallback(RoutingContext ctx) {
        ctx.response().setStatusCode(200).end("OAuth callback received");
    }
}
