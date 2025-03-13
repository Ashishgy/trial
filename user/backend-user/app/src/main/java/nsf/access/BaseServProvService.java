package nsf.access;

import io.vertx.core.Future;
import io.vertx.core.Promise;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.mongo.MongoClient;
import io.vertx.ext.mongo.MongoClientDeleteResult;
import org.immutables.value.Value;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import io.vertx.core.json.JsonObject;

/**
 * Service/repository for mediating access to persistent Service Provider mappings between the controller and database.
 * "Service Provider mapping" refers to how we map custom given Service Provider IDs to corresponding ACA-Py
 * connection IDs. We may also want to store additional metadata for each service provider rather than just the
 * mapped connection ID.
 */
@Value.Immutable
public abstract class BaseServProvService {
    private static final Logger logger = LoggerFactory.getLogger(BaseServProvService.class);

    public abstract String collection();
    public abstract MongoClient client();

    // List all service providers
    public Future<List<JsonObject>> listServProvs() {
        JsonObject query = new JsonObject();
        return client().find(collection(), query);
    }

    // Get service provider connection ID
    public Future<String> getServProvConnId(String servProvId) {
        return getServProv(servProvId).compose(json -> {
            Promise<String> promise = Promise.promise();
            if (json.isPresent()) {
                promise.complete(json.get().getString("connId"));
            } else {
                promise.fail(new ServProvNotFoundException());
            }
            return promise.future();
        });
    }

    // Get service provider data
    public Future<JsonObject> getServProvData(String servProvId) {
        return getServProv(servProvId).compose(json -> {
            Promise<JsonObject> promise = Promise.promise();
            if (json.isPresent()) {
                promise.complete(json.get());
            } else {
                promise.fail(new ServProvNotFoundException());
            }
            return promise.future();
        });
    }

    // Fetch a specific service provider by ID
    public Future<Optional<JsonObject>> getServProv(String servProvId) {
        JsonObject query = new JsonObject().put("_id", servProvId);
        return client().findOne(collection(), query, null).compose(json -> {
            Promise<Optional<JsonObject>> promise = Promise.promise();
            promise.complete(Optional.ofNullable(json));
            return promise.future();
        });
    }

    // Delete a service provider connection mapping
    public Future<MongoClientDeleteResult> deleteServProvConnMapping(String servProvId) {
        JsonObject query = new JsonObject().put("_id", servProvId);
        return client().removeDocument(collection(), query);
    }

    // List service providers associated with a specific user ID
    public Future<List<JsonObject>> listServProvsByUserId(String userId) {
        // Log the incoming user ID
        logger.info("Fetching service providers for user ID: {}", userId);
    
        // Create a query to fetch service providers for the specified user ID
        JsonObject query = new JsonObject().put("userId", userId);
    
        // Use the MongoDB client to find the service providers
        return client().find(collection(), query)
            .map(result -> {
                // Log the number of service providers found
                logger.info("Number of service providers found for user ID {}: {}", userId, result.size());
                return result.stream().collect(Collectors.toList()); // Return the result as a list of JsonObjects
            });
    }
    
}
