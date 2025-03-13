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
 * Immutable implementation of {@link BaseDataService}.
 * <p>
 * Use the builder to create immutable instances:
 * {@code DataService.builder()}.
 */
@Generated(from = "BaseDataService", generator = "Immutables")
@SuppressWarnings({"all"})
@ParametersAreNonnullByDefault
@javax.annotation.processing.Generated("org.immutables.processor.ProxyProcessor")
@Immutable
@CheckReturnValue
public final class DataService extends BaseDataService {
  private final MongoClient client;
  @SuppressWarnings("Immutable")
  private transient int hashCode; // hashCode lazily computed

  private DataService(DataService.Builder builder) {
    this.client = builder.client;
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
   * This instance is equal to all instances of {@code DataService} that have equal attribute values.
   * @return {@code true} if {@code this} is equal to {@code another} instance
   */
  @Override
  public boolean equals(@Nullable Object another) {
    if (this == another) return true;
    return another instanceof DataService
        && equalTo(0, (DataService) another);
  }

  private boolean equalTo(int synthetic, DataService another) {
    if (hashCode != 0 && another.hashCode != 0 && hashCode != another.hashCode) return false;
    return client.equals(another.client);
  }

  /**
   * Returns a lazily computed hash code from attributes: {@code client}.
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
    h += (h << 5) + client.hashCode();
    return h;
  }

  /**
   * Prints the immutable value {@code DataService} with attribute values.
   * @return A string representation of the value
   */
  @Override
  public String toString() {
    return MoreObjects.toStringHelper("DataService")
        .omitNullValues()
        .add("client", client)
        .toString();
  }

  /**
   * Utility type used to correctly read immutable object from JSON representation.
   * @deprecated Do not use this type directly, it exists only for the <em>Jackson</em>-binding infrastructure
   */
  @Generated(from = "BaseDataService", generator = "Immutables")
  @Deprecated
  @SuppressWarnings("Immutable")
  @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.NONE)
  static final class Json extends BaseDataService {
    @Nullable MongoClient client;
    @JsonProperty("client")
    public void setClient(MongoClient client) {
      this.client = client;
    }
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
  static DataService fromJson(Json json) {
    DataService.Builder builder = DataService.builder();
    if (json.client != null) {
      builder.client(json.client);
    }
    return builder.build();
  }

  /**
   * Creates a builder for {@link DataService DataService}.
   * <pre>
   * DataService.builder()
   *    .client(io.vertx.ext.mongo.MongoClient) // required {@link BaseDataService#client() client}
   *    .build();
   * </pre>
   * @return A new DataService builder
   */
  public static DataService.Builder builder() {
    return new DataService.Builder();
  }

  /**
   * Builds instances of type {@link DataService DataService}.
   * Initialize attributes and then invoke the {@link #build()} method to create an
   * immutable instance.
   * <p><em>{@code Builder} is not thread-safe and generally should not be stored in a field or collection,
   * but instead used immediately to create instances.</em>
   */
  @Generated(from = "BaseDataService", generator = "Immutables")
  @NotThreadSafe
  public static final class Builder {
    private static final long INIT_BIT_CLIENT = 0x1L;
    private long initBits = 0x1L;

    private @Nullable MongoClient client;

    private Builder() {
    }

    /**
     * Initializes the value for the {@link BaseDataService#client() client} attribute.
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
     * Builds a new {@link DataService DataService}.
     * @return An immutable instance of DataService
     * @throws java.lang.IllegalStateException if any required attributes are missing
     */
    public DataService build() {
      checkRequiredAttributes();
      return new DataService(this);
    }

    private boolean clientIsSet() {
      return (initBits & INIT_BIT_CLIENT) == 0;
    }

    private static void checkNotIsSet(boolean isSet, String name) {
      if (isSet) throw new IllegalStateException("Builder of DataService is strict, attribute is already set: ".concat(name));
    }

    private void checkRequiredAttributes() {
      if (initBits != 0) {
        throw new IllegalStateException(formatRequiredAttributesMessage());
      }
    }

    private String formatRequiredAttributesMessage() {
      List<String> attributes = new ArrayList<>();
      if (!clientIsSet()) attributes.add("client");
      return "Cannot build DataService, some of required attributes are not set " + attributes;
    }
  }
}
