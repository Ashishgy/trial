package nsf.access;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.Var;
import io.vertx.ext.mongo.MongoClient;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.annotation.CheckReturnValue;
import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;
import javax.annotation.concurrent.Immutable;
import javax.annotation.concurrent.NotThreadSafe;
import org.immutables.value.Generated;

/**
 * Service/repository for mediating access to persistent Service Provider mappings between the controller and database.
 * "Service Provider mapping" refers to how we map custom given Service Provider IDs to corresponding ACA-Py
 * connection IDs. We may also want to store additional metadata for each service provider rather than just the
 * mapped connection ID.
 */
@Generated(from = "BaseServProvService", generator = "Immutables")
@SuppressWarnings({"all"})
@ParametersAreNonnullByDefault
@javax.annotation.processing.Generated("org.immutables.processor.ProxyProcessor")
@Immutable
@CheckReturnValue
public final class ServProvService extends BaseServProvService {
  private final String collection;
  private final MongoClient client;
  @SuppressWarnings("Immutable")
  private transient int hashCode; // hashCode lazily computed

  private ServProvService(ServProvService.Builder builder) {
    this.collection = builder.collection;
    this.client = builder.client;
  }

  /**
   * @return The value of the {@code collection} attribute
   */
  @JsonProperty("collection")
  @Override
  public String collection() {
    return collection;
  }

  /**
   * @return The value of the {@code client} attribute
   */
  @JsonProperty("client")
  @Override
  public MongoClient client() {
    return client;
  }

  /**
   * This instance is equal to all instances of {@code ServProvService} that have equal attribute values.
   * @return {@code true} if {@code this} is equal to {@code another} instance
   */
  @Override
  public boolean equals(@Nullable Object another) {
    if (this == another) return true;
    return another instanceof ServProvService
        && equalTo(0, (ServProvService) another);
  }

  private boolean equalTo(int synthetic, ServProvService another) {
    if (hashCode != 0 && another.hashCode != 0 && hashCode != another.hashCode) return false;
    return collection.equals(another.collection)
        && client.equals(another.client);
  }

  /**
   * Returns a lazily computed hash code from attributes: {@code collection}, {@code client}.
   * @return hashCode value
   */
  @Override
  public int hashCode() {
    int h = this.hashCode;
    if (h == 0) {
      h = computeHashCode();
      this.hashCode = h;
    }
    return h;
  }

  private int computeHashCode() {
    @Var int h = 5381;
    h += (h << 5) + collection.hashCode();
    h += (h << 5) + client.hashCode();
    return h;
  }

  /**
   * Prints the immutable value {@code ServProvService} with attribute values.
   * @return A string representation of the value
   */
  @Override
  public String toString() {
    return MoreObjects.toStringHelper("ServProvService")
        .omitNullValues()
        .add("collection", collection)
        .add("client", client)
        .toString();
  }

  /**
   * Utility type used to correctly read immutable object from JSON representation.
   * @deprecated Do not use this type directly, it exists only for the <em>Jackson</em>-binding infrastructure
   */
  @Generated(from = "BaseServProvService", generator = "Immutables")
  @Deprecated
  @SuppressWarnings("Immutable")
  @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.NONE)
  static final class Json extends BaseServProvService {
    @Nullable String collection;
    @Nullable MongoClient client;
    @JsonProperty("collection")
    public void setCollection(String collection) {
      this.collection = collection;
    }
    @JsonProperty("client")
    public void setClient(MongoClient client) {
      this.client = client;
    }
    @Override
    public String collection() { throw new UnsupportedOperationException(); }
    @Override
    public MongoClient client() { throw new UnsupportedOperationException(); }
  }

  /**
   * @param json A JSON-bindable data structure
   * @return An immutable value type
   * @deprecated Do not use this method directly, it exists only for the <em>Jackson</em>-binding infrastructure
   */
  @Deprecated
  @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
  static ServProvService fromJson(Json json) {
    ServProvService.Builder builder = ServProvService.builder();
    if (json.collection != null) {
      builder.collection(json.collection);
    }
    if (json.client != null) {
      builder.client(json.client);
    }
    return builder.build();
  }

  /**
   * Creates a builder for {@link ServProvService ServProvService}.
   * <pre>
   * ServProvService.builder()
   *    .collection(String) // required {@link BaseServProvService#collection() collection}
   *    .client(io.vertx.ext.mongo.MongoClient) // required {@link BaseServProvService#client() client}
   *    .build();
   * </pre>
   * @return A new ServProvService builder
   */
  public static ServProvService.Builder builder() {
    return new ServProvService.Builder();
  }

  /**
   * Builds instances of type {@link ServProvService ServProvService}.
   * Initialize attributes and then invoke the {@link #build()} method to create an
   * immutable instance.
   * <p><em>{@code Builder} is not thread-safe and generally should not be stored in a field or collection,
   * but instead used immediately to create instances.</em>
   */
  @Generated(from = "BaseServProvService", generator = "Immutables")
  @NotThreadSafe
  public static final class Builder {
    private static final long INIT_BIT_COLLECTION = 0x1L;
    private static final long INIT_BIT_CLIENT = 0x2L;
    private long initBits = 0x3L;

    private @Nullable String collection;
    private @Nullable MongoClient client;

    private Builder() {
    }

    /**
     * Initializes the value for the {@link BaseServProvService#collection() collection} attribute.
     * @param collection The value for collection 
     * @return {@code this} builder for use in a chained invocation
     */
    @CanIgnoreReturnValue 
    public final Builder collection(String collection) {
      checkNotIsSet(collectionIsSet(), "collection");
      this.collection = Objects.requireNonNull(collection, "collection");
      initBits &= ~INIT_BIT_COLLECTION;
      return this;
    }

    /**
     * Initializes the value for the {@link BaseServProvService#client() client} attribute.
     * @param client The value for client 
     * @return {@code this} builder for use in a chained invocation
     */
    @CanIgnoreReturnValue 
    public final Builder client(MongoClient client) {
      checkNotIsSet(clientIsSet(), "client");
      this.client = Objects.requireNonNull(client, "client");
      initBits &= ~INIT_BIT_CLIENT;
      return this;
    }

    /**
     * Builds a new {@link ServProvService ServProvService}.
     * @return An immutable instance of ServProvService
     * @throws java.lang.IllegalStateException if any required attributes are missing
     */
    public ServProvService build() {
      checkRequiredAttributes();
      return new ServProvService(this);
    }

    private boolean collectionIsSet() {
      return (initBits & INIT_BIT_COLLECTION) == 0;
    }

    private boolean clientIsSet() {
      return (initBits & INIT_BIT_CLIENT) == 0;
    }

    private static void checkNotIsSet(boolean isSet, String name) {
      if (isSet) throw new IllegalStateException("Builder of ServProvService is strict, attribute is already set: ".concat(name));
    }

    private void checkRequiredAttributes() {
      if (initBits != 0) {
        throw new IllegalStateException(formatRequiredAttributesMessage());
      }
    }

    private String formatRequiredAttributesMessage() {
      List<String> attributes = new ArrayList<>();
      if (!collectionIsSet()) attributes.add("collection");
      if (!clientIsSet()) attributes.add("client");
      return "Cannot build ServProvService, some of required attributes are not set " + attributes;
    }
  }
}
