package nsf.vertx.auth;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.Var;
import io.vertx.core.eventbus.MessageProducer;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicLong;
import javax.annotation.CheckReturnValue;
import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;
import javax.annotation.concurrent.Immutable;
import javax.annotation.concurrent.NotThreadSafe;
import nsf.vertx.auth.key.PublicKeyStore;
import nsf.vertx.auth.token.TokenStore;
import org.immutables.value.Generated;

/**
 * Immutable implementation of {@link BaseAuthService}.
 * <p>
 * Use the builder to create immutable instances:
 * {@code AuthService.builder()}.
 */
@Generated(from = "BaseAuthService", generator = "Immutables")
@SuppressWarnings({"all"})
@ParametersAreNonnullByDefault
@javax.annotation.processing.Generated("org.immutables.processor.ProxyProcessor")
@Immutable
@CheckReturnValue
public final class AuthService extends BaseAuthService {
  private final PublicKeyStore keyStore;
  private final TokenStore tokenStore;
  private transient final MessageProducer<String> publisher;
  private transient final AtomicLong timerId;
  @SuppressWarnings("Immutable")
  private transient int hashCode; // hashCode lazily computed

  private AuthService(AuthService.Builder builder) {
    this.keyStore = builder.keyStore;
    this.tokenStore = builder.tokenStore;
    this.publisher = initShim.publisher();
    this.timerId = initShim.timerId();
    this.initShim = null;
  }

  private static final byte STAGE_INITIALIZING = -1;
  private static final byte STAGE_UNINITIALIZED = 0;
  private static final byte STAGE_INITIALIZED = 1;
  @SuppressWarnings("Immutable")
  private transient volatile InitShim initShim = new InitShim();

  @Generated(from = "BaseAuthService", generator = "Immutables")
  private final class InitShim {
    private byte publisherBuildStage = STAGE_UNINITIALIZED;
    private MessageProducer<String> publisher;

    MessageProducer<String> publisher() {
      if (publisherBuildStage == STAGE_INITIALIZING) throw new IllegalStateException(formatInitCycleMessage());
      if (publisherBuildStage == STAGE_UNINITIALIZED) {
        publisherBuildStage = STAGE_INITIALIZING;
        this.publisher = Objects.requireNonNull(AuthService.super.publisher(), "publisher");
        publisherBuildStage = STAGE_INITIALIZED;
      }
      return this.publisher;
    }

    private byte timerIdBuildStage = STAGE_UNINITIALIZED;
    private AtomicLong timerId;

    AtomicLong timerId() {
      if (timerIdBuildStage == STAGE_INITIALIZING) throw new IllegalStateException(formatInitCycleMessage());
      if (timerIdBuildStage == STAGE_UNINITIALIZED) {
        timerIdBuildStage = STAGE_INITIALIZING;
        this.timerId = Objects.requireNonNull(AuthService.super.timerId(), "timerId");
        timerIdBuildStage = STAGE_INITIALIZED;
      }
      return this.timerId;
    }

    private String formatInitCycleMessage() {
      List<String> attributes = new ArrayList<>();
      if (publisherBuildStage == STAGE_INITIALIZING) attributes.add("publisher");
      if (timerIdBuildStage == STAGE_INITIALIZING) attributes.add("timerId");
      return "Cannot build AuthService, attribute initializers form cycle " + attributes;
    }
  }

  /**
   * @return The value of the {@code keyStore} attribute
   */
  @JsonProperty("keyStore")
  @Override
  public PublicKeyStore keyStore() {
    return keyStore;
  }

  /**
   * @return The value of the {@code tokenStore} attribute
   */
  @JsonProperty("tokenStore")
  @Override
  public TokenStore tokenStore() {
    return tokenStore;
  }

  /**
   * @return The computed-at-construction value of the {@code publisher} attribute
   */
  @JsonProperty("publisher")
  @Override
  public MessageProducer<String> publisher() {
    InitShim shim = this.initShim;
    return shim != null
        ? shim.publisher()
        : this.publisher;
  }

  /**
   * @return The computed-at-construction value of the {@code timerId} attribute
   */
  @JsonProperty("timerId")
  @Override
  public AtomicLong timerId() {
    InitShim shim = this.initShim;
    return shim != null
        ? shim.timerId()
        : this.timerId;
  }

  /**
   * This instance is equal to all instances of {@code AuthService} that have equal attribute values.
   * @return {@code true} if {@code this} is equal to {@code another} instance
   */
  @Override
  public boolean equals(@Nullable Object another) {
    if (this == another) return true;
    return another instanceof AuthService
        && equalTo(0, (AuthService) another);
  }

  private boolean equalTo(int synthetic, AuthService another) {
    if (hashCode != 0 && another.hashCode != 0 && hashCode != another.hashCode) return false;
    return keyStore.equals(another.keyStore)
        && tokenStore.equals(another.tokenStore)
        && publisher.equals(another.publisher)
        && timerId.equals(another.timerId);
  }

  /**
   * Returns a lazily computed hash code from attributes: {@code keyStore}, {@code tokenStore}, {@code publisher}, {@code timerId}.
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
    h += (h << 5) + keyStore.hashCode();
    h += (h << 5) + tokenStore.hashCode();
    h += (h << 5) + publisher.hashCode();
    h += (h << 5) + timerId.hashCode();
    return h;
  }

  /**
   * Prints the immutable value {@code AuthService} with attribute values.
   * @return A string representation of the value
   */
  @Override
  public String toString() {
    return MoreObjects.toStringHelper("AuthService")
        .omitNullValues()
        .add("keyStore", keyStore)
        .add("tokenStore", tokenStore)
        .add("publisher", publisher)
        .add("timerId", timerId)
        .toString();
  }

  /**
   * Utility type used to correctly read immutable object from JSON representation.
   * @deprecated Do not use this type directly, it exists only for the <em>Jackson</em>-binding infrastructure
   */
  @Generated(from = "BaseAuthService", generator = "Immutables")
  @Deprecated
  @SuppressWarnings("Immutable")
  @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.NONE)
  static final class Json extends BaseAuthService {
    @Nullable PublicKeyStore keyStore;
    @Nullable TokenStore tokenStore;
    @JsonProperty("keyStore")
    public void setKeyStore(PublicKeyStore keyStore) {
      this.keyStore = keyStore;
    }
    @JsonProperty("tokenStore")
    public void setTokenStore(TokenStore tokenStore) {
      this.tokenStore = tokenStore;
    }
    @Override
    public PublicKeyStore keyStore() { throw new UnsupportedOperationException(); }
    @Override
    public TokenStore tokenStore() { throw new UnsupportedOperationException(); }
    @JsonIgnore
    @Override
    public MessageProducer<String> publisher() { throw new UnsupportedOperationException(); }
    @JsonIgnore
    @Override
    public AtomicLong timerId() { throw new UnsupportedOperationException(); }
  }

  /**
   * @param json A JSON-bindable data structure
   * @return An immutable value type
   * @deprecated Do not use this method directly, it exists only for the <em>Jackson</em>-binding infrastructure
   */
  @Deprecated
  @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
  static AuthService fromJson(Json json) {
    AuthService.Builder builder = AuthService.builder();
    if (json.keyStore != null) {
      builder.keyStore(json.keyStore);
    }
    if (json.tokenStore != null) {
      builder.tokenStore(json.tokenStore);
    }
    return builder.build();
  }

  /**
   * Creates a builder for {@link AuthService AuthService}.
   * <pre>
   * AuthService.builder()
   *    .keyStore(nsf.vertx.auth.key.PublicKeyStore) // required {@link AuthService#keyStore() keyStore}
   *    .tokenStore(nsf.vertx.auth.token.TokenStore) // required {@link AuthService#tokenStore() tokenStore}
   *    .build();
   * </pre>
   * @return A new AuthService builder
   */
  public static AuthService.Builder builder() {
    return new AuthService.Builder();
  }

  /**
   * Builds instances of type {@link AuthService AuthService}.
   * Initialize attributes and then invoke the {@link #build()} method to create an
   * immutable instance.
   * <p><em>{@code Builder} is not thread-safe and generally should not be stored in a field or collection,
   * but instead used immediately to create instances.</em>
   */
  @Generated(from = "BaseAuthService", generator = "Immutables")
  @NotThreadSafe
  public static final class Builder {
    private static final long INIT_BIT_KEY_STORE = 0x1L;
    private static final long INIT_BIT_TOKEN_STORE = 0x2L;
    private long initBits = 0x3L;

    private @Nullable PublicKeyStore keyStore;
    private @Nullable TokenStore tokenStore;

    private Builder() {
    }

    /**
     * Initializes the value for the {@link AuthService#keyStore() keyStore} attribute.
     * @param keyStore The value for keyStore 
     * @return {@code this} builder for use in a chained invocation
     */
    @CanIgnoreReturnValue 
    public final Builder keyStore(PublicKeyStore keyStore) {
      checkNotIsSet(keyStoreIsSet(), "keyStore");
      this.keyStore = Objects.requireNonNull(keyStore, "keyStore");
      initBits &= ~INIT_BIT_KEY_STORE;
      return this;
    }

    /**
     * Initializes the value for the {@link AuthService#tokenStore() tokenStore} attribute.
     * @param tokenStore The value for tokenStore 
     * @return {@code this} builder for use in a chained invocation
     */
    @CanIgnoreReturnValue 
    public final Builder tokenStore(TokenStore tokenStore) {
      checkNotIsSet(tokenStoreIsSet(), "tokenStore");
      this.tokenStore = Objects.requireNonNull(tokenStore, "tokenStore");
      initBits &= ~INIT_BIT_TOKEN_STORE;
      return this;
    }

    /**
     * Builds a new {@link AuthService AuthService}.
     * @return An immutable instance of AuthService
     * @throws java.lang.IllegalStateException if any required attributes are missing
     */
    public AuthService build() {
      checkRequiredAttributes();
      return new AuthService(this);
    }

    private boolean keyStoreIsSet() {
      return (initBits & INIT_BIT_KEY_STORE) == 0;
    }

    private boolean tokenStoreIsSet() {
      return (initBits & INIT_BIT_TOKEN_STORE) == 0;
    }

    private static void checkNotIsSet(boolean isSet, String name) {
      if (isSet) throw new IllegalStateException("Builder of AuthService is strict, attribute is already set: ".concat(name));
    }

    private void checkRequiredAttributes() {
      if (initBits != 0) {
        throw new IllegalStateException(formatRequiredAttributesMessage());
      }
    }

    private String formatRequiredAttributesMessage() {
      List<String> attributes = new ArrayList<>();
      if (!keyStoreIsSet()) attributes.add("keyStore");
      if (!tokenStoreIsSet()) attributes.add("tokenStore");
      return "Cannot build AuthService, some of required attributes are not set " + attributes;
    }
  }
}
