package nsf.vertx.auth.key;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.Var;
import io.vertx.ext.web.client.WebClient;
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
 * Immutable implementation of {@link BaseWebPublicKeyStore}.
 * <p>
 * Use the builder to create immutable instances:
 * {@code WebPublicKeyStore.builder()}.
 */
@Generated(from = "BaseWebPublicKeyStore", generator = "Immutables")
@SuppressWarnings({"all"})
@ParametersAreNonnullByDefault
@javax.annotation.processing.Generated("org.immutables.processor.ProxyProcessor")
@Immutable
@CheckReturnValue
public final class WebPublicKeyStore extends BaseWebPublicKeyStore {
  private final WebClient client;
  private final String host;
  @SuppressWarnings("Immutable")
  private transient int hashCode; // hashCode lazily computed

  private WebPublicKeyStore(WebPublicKeyStore.Builder builder) {
    this.client = builder.client;
    this.host = builder.host;
  }

  /**
   * @return The value of the {@code client} attribute
   */
  @JsonProperty("client")
  @Override
  public WebClient client() {
    return client;
  }

  /**
   * @return The value of the {@code host} attribute
   */
  @JsonProperty("host")
  @Override
  public String host() {
    return host;
  }

  /**
   * This instance is equal to all instances of {@code WebPublicKeyStore} that have equal attribute values.
   * @return {@code true} if {@code this} is equal to {@code another} instance
   */
  @Override
  public boolean equals(@Nullable Object another) {
    if (this == another) return true;
    return another instanceof WebPublicKeyStore
        && equalTo(0, (WebPublicKeyStore) another);
  }

  private boolean equalTo(int synthetic, WebPublicKeyStore another) {
    if (hashCode != 0 && another.hashCode != 0 && hashCode != another.hashCode) return false;
    return client.equals(another.client)
        && host.equals(another.host);
  }

  /**
   * Returns a lazily computed hash code from attributes: {@code client}, {@code host}.
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
    h += (h << 5) + host.hashCode();
    return h;
  }

  /**
   * Prints the immutable value {@code WebPublicKeyStore} with attribute values.
   * @return A string representation of the value
   */
  @Override
  public String toString() {
    return MoreObjects.toStringHelper("WebPublicKeyStore")
        .omitNullValues()
        .add("client", client)
        .add("host", host)
        .toString();
  }

  /**
   * Utility type used to correctly read immutable object from JSON representation.
   * @deprecated Do not use this type directly, it exists only for the <em>Jackson</em>-binding infrastructure
   */
  @Generated(from = "BaseWebPublicKeyStore", generator = "Immutables")
  @Deprecated
  @SuppressWarnings("Immutable")
  @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.NONE)
  static final class Json extends BaseWebPublicKeyStore {
    @Nullable WebClient client;
    @Nullable String host;
    @JsonProperty("client")
    public void setClient(WebClient client) {
      this.client = client;
    }
    @JsonProperty("host")
    public void setHost(String host) {
      this.host = host;
    }
    @Override
    public WebClient client() { throw new UnsupportedOperationException(); }
    @Override
    public String host() { throw new UnsupportedOperationException(); }
  }

  /**
   * @param json A JSON-bindable data structure
   * @return An immutable value type
   * @deprecated Do not use this method directly, it exists only for the <em>Jackson</em>-binding infrastructure
   */
  @Deprecated
  @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
  static WebPublicKeyStore fromJson(Json json) {
    WebPublicKeyStore.Builder builder = WebPublicKeyStore.builder();
    if (json.client != null) {
      builder.client(json.client);
    }
    if (json.host != null) {
      builder.host(json.host);
    }
    return builder.build();
  }

  /**
   * Creates a builder for {@link WebPublicKeyStore WebPublicKeyStore}.
   * <pre>
   * WebPublicKeyStore.builder()
   *    .client(io.vertx.ext.web.client.WebClient) // required {@link WebPublicKeyStore#client() client}
   *    .host(String) // required {@link WebPublicKeyStore#host() host}
   *    .build();
   * </pre>
   * @return A new WebPublicKeyStore builder
   */
  public static WebPublicKeyStore.Builder builder() {
    return new WebPublicKeyStore.Builder();
  }

  /**
   * Builds instances of type {@link WebPublicKeyStore WebPublicKeyStore}.
   * Initialize attributes and then invoke the {@link #build()} method to create an
   * immutable instance.
   * <p><em>{@code Builder} is not thread-safe and generally should not be stored in a field or collection,
   * but instead used immediately to create instances.</em>
   */
  @Generated(from = "BaseWebPublicKeyStore", generator = "Immutables")
  @NotThreadSafe
  public static final class Builder {
    private static final long INIT_BIT_CLIENT = 0x1L;
    private static final long INIT_BIT_HOST = 0x2L;
    private long initBits = 0x3L;

    private @Nullable WebClient client;
    private @Nullable String host;

    private Builder() {
    }

    /**
     * Initializes the value for the {@link WebPublicKeyStore#client() client} attribute.
     * @param client The value for client 
     * @return {@code this} builder for use in a chained invocation
     */
    @CanIgnoreReturnValue 
    public final Builder client(WebClient client) {
      checkNotIsSet(clientIsSet(), "client");
      this.client = Objects.requireNonNull(client, "client");
      initBits &= ~INIT_BIT_CLIENT;
      return this;
    }

    /**
     * Initializes the value for the {@link WebPublicKeyStore#host() host} attribute.
     * @param host The value for host 
     * @return {@code this} builder for use in a chained invocation
     */
    @CanIgnoreReturnValue 
    public final Builder host(String host) {
      checkNotIsSet(hostIsSet(), "host");
      this.host = Objects.requireNonNull(host, "host");
      initBits &= ~INIT_BIT_HOST;
      return this;
    }

    /**
     * Builds a new {@link WebPublicKeyStore WebPublicKeyStore}.
     * @return An immutable instance of WebPublicKeyStore
     * @throws java.lang.IllegalStateException if any required attributes are missing
     */
    public WebPublicKeyStore build() {
      checkRequiredAttributes();
      return new WebPublicKeyStore(this);
    }

    private boolean clientIsSet() {
      return (initBits & INIT_BIT_CLIENT) == 0;
    }

    private boolean hostIsSet() {
      return (initBits & INIT_BIT_HOST) == 0;
    }

    private static void checkNotIsSet(boolean isSet, String name) {
      if (isSet) throw new IllegalStateException("Builder of WebPublicKeyStore is strict, attribute is already set: ".concat(name));
    }

    private void checkRequiredAttributes() {
      if (initBits != 0) {
        throw new IllegalStateException(formatRequiredAttributesMessage());
      }
    }

    private String formatRequiredAttributesMessage() {
      List<String> attributes = new ArrayList<>();
      if (!clientIsSet()) attributes.add("client");
      if (!hostIsSet()) attributes.add("host");
      return "Cannot build WebPublicKeyStore, some of required attributes are not set " + attributes;
    }
  }
}
