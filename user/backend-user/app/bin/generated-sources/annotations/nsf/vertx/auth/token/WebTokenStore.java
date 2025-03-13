package nsf.vertx.auth.token;

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
 * Immutable implementation of {@link BaseWebTokenStore}.
 * <p>
 * Use the builder to create immutable instances:
 * {@code WebTokenStore.builder()}.
 */
@Generated(from = "BaseWebTokenStore", generator = "Immutables")
@SuppressWarnings({"all"})
@ParametersAreNonnullByDefault
@javax.annotation.processing.Generated("org.immutables.processor.ProxyProcessor")
@Immutable
@CheckReturnValue
public final class WebTokenStore extends BaseWebTokenStore {
  private final WebClient client;
  private final String host;
  private final TokenDecoder decoder;
  @SuppressWarnings("Immutable")
  private transient int hashCode; // hashCode lazily computed

  private WebTokenStore(WebTokenStore.Builder builder) {
    this.client = builder.client;
    this.host = builder.host;
    this.decoder = builder.decoder;
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
   * @return The value of the {@code decoder} attribute
   */
  @JsonProperty("decoder")
  @Override
  public TokenDecoder decoder() {
    return decoder;
  }

  /**
   * This instance is equal to all instances of {@code WebTokenStore} that have equal attribute values.
   * @return {@code true} if {@code this} is equal to {@code another} instance
   */
  @Override
  public boolean equals(@Nullable Object another) {
    if (this == another) return true;
    return another instanceof WebTokenStore
        && equalTo(0, (WebTokenStore) another);
  }

  private boolean equalTo(int synthetic, WebTokenStore another) {
    if (hashCode != 0 && another.hashCode != 0 && hashCode != another.hashCode) return false;
    return client.equals(another.client)
        && host.equals(another.host)
        && decoder.equals(another.decoder);
  }

  /**
   * Returns a lazily computed hash code from attributes: {@code client}, {@code host}, {@code decoder}.
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
    h += (h << 5) + decoder.hashCode();
    return h;
  }

  /**
   * Prints the immutable value {@code WebTokenStore} with attribute values.
   * @return A string representation of the value
   */
  @Override
  public String toString() {
    return MoreObjects.toStringHelper("WebTokenStore")
        .omitNullValues()
        .add("client", client)
        .add("host", host)
        .add("decoder", decoder)
        .toString();
  }

  /**
   * Utility type used to correctly read immutable object from JSON representation.
   * @deprecated Do not use this type directly, it exists only for the <em>Jackson</em>-binding infrastructure
   */
  @Generated(from = "BaseWebTokenStore", generator = "Immutables")
  @Deprecated
  @SuppressWarnings("Immutable")
  @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.NONE)
  static final class Json extends BaseWebTokenStore {
    @Nullable WebClient client;
    @Nullable String host;
    @Nullable TokenDecoder decoder;
    @JsonProperty("client")
    public void setClient(WebClient client) {
      this.client = client;
    }
    @JsonProperty("host")
    public void setHost(String host) {
      this.host = host;
    }
    @JsonProperty("decoder")
    public void setDecoder(TokenDecoder decoder) {
      this.decoder = decoder;
    }
    @Override
    public WebClient client() { throw new UnsupportedOperationException(); }
    @Override
    public String host() { throw new UnsupportedOperationException(); }
    @Override
    public TokenDecoder decoder() { throw new UnsupportedOperationException(); }
  }

  /**
   * @param json A JSON-bindable data structure
   * @return An immutable value type
   * @deprecated Do not use this method directly, it exists only for the <em>Jackson</em>-binding infrastructure
   */
  @Deprecated
  @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
  static WebTokenStore fromJson(Json json) {
    WebTokenStore.Builder builder = WebTokenStore.builder();
    if (json.client != null) {
      builder.client(json.client);
    }
    if (json.host != null) {
      builder.host(json.host);
    }
    if (json.decoder != null) {
      builder.decoder(json.decoder);
    }
    return builder.build();
  }

  /**
   * Creates a builder for {@link WebTokenStore WebTokenStore}.
   * <pre>
   * WebTokenStore.builder()
   *    .client(io.vertx.ext.web.client.WebClient) // required {@link WebTokenStore#client() client}
   *    .host(String) // required {@link WebTokenStore#host() host}
   *    .decoder(nsf.vertx.auth.token.TokenDecoder) // required {@link WebTokenStore#decoder() decoder}
   *    .build();
   * </pre>
   * @return A new WebTokenStore builder
   */
  public static WebTokenStore.Builder builder() {
    return new WebTokenStore.Builder();
  }

  /**
   * Builds instances of type {@link WebTokenStore WebTokenStore}.
   * Initialize attributes and then invoke the {@link #build()} method to create an
   * immutable instance.
   * <p><em>{@code Builder} is not thread-safe and generally should not be stored in a field or collection,
   * but instead used immediately to create instances.</em>
   */
  @Generated(from = "BaseWebTokenStore", generator = "Immutables")
  @NotThreadSafe
  public static final class Builder {
    private static final long INIT_BIT_CLIENT = 0x1L;
    private static final long INIT_BIT_HOST = 0x2L;
    private static final long INIT_BIT_DECODER = 0x4L;
    private long initBits = 0x7L;

    private @Nullable WebClient client;
    private @Nullable String host;
    private @Nullable TokenDecoder decoder;

    private Builder() {
    }

    /**
     * Initializes the value for the {@link WebTokenStore#client() client} attribute.
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
     * Initializes the value for the {@link WebTokenStore#host() host} attribute.
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
     * Initializes the value for the {@link WebTokenStore#decoder() decoder} attribute.
     * @param decoder The value for decoder 
     * @return {@code this} builder for use in a chained invocation
     */
    @CanIgnoreReturnValue 
    public final Builder decoder(TokenDecoder decoder) {
      checkNotIsSet(decoderIsSet(), "decoder");
      this.decoder = Objects.requireNonNull(decoder, "decoder");
      initBits &= ~INIT_BIT_DECODER;
      return this;
    }

    /**
     * Builds a new {@link WebTokenStore WebTokenStore}.
     * @return An immutable instance of WebTokenStore
     * @throws java.lang.IllegalStateException if any required attributes are missing
     */
    public WebTokenStore build() {
      checkRequiredAttributes();
      return new WebTokenStore(this);
    }

    private boolean clientIsSet() {
      return (initBits & INIT_BIT_CLIENT) == 0;
    }

    private boolean hostIsSet() {
      return (initBits & INIT_BIT_HOST) == 0;
    }

    private boolean decoderIsSet() {
      return (initBits & INIT_BIT_DECODER) == 0;
    }

    private static void checkNotIsSet(boolean isSet, String name) {
      if (isSet) throw new IllegalStateException("Builder of WebTokenStore is strict, attribute is already set: ".concat(name));
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
      if (!decoderIsSet()) attributes.add("decoder");
      return "Cannot build WebTokenStore, some of required attributes are not set " + attributes;
    }
  }
}
