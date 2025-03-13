package nsf.vertx;

import io.vertx.core.Context;
import io.vertx.core.Vertx;
import nsf.controller.ControllerVerticle;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.hyperledger.aries.AriesClient;
import org.hyperledger.aries.api.credential_definition.CredentialDefinition;

import java.io.IOException;

public class App {

    public static void main(String[] args) {
        BasicConfigurator.configure();
        Logger.getRootLogger().setLevel(Level.INFO);

        Vertx vertx = Vertx.vertx();

        // TODO DI everything

        AriesClient ariesClient = AriesClient
                .builder()
                .url(System.getenv().getOrDefault("AGENT_URL", "http://host.docker.internal:9091"))
                //.apiKey("secret") // TODO AUTH (low priority)
                .build();

        Context context = vertx.getOrCreateContext();
        context.runOnContext(v -> {
            vertx.deployVerticle(new ControllerVerticle(ariesClient));
        });

    }
}