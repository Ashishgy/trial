package nsf.pda.auth;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.Var;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.atomic.AtomicReference;
import javax.annotation.CheckReturnValue;
import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;
import javax.annotation.concurrent.Immutable;
import javax.annotation.concurrent.NotThreadSafe;
import org.immutables.value.Generated;

/**
 * Immutable implementation of {@link BaseTokenService}.
 * <p>
 * Use the builder to create immutable instances:
 * {@code TokenService.builder()}.
 */
@Generated(from = "BaseTokenService", generator = "Immutables")
@SuppressWarnings({"all"})
@ParametersAreNonnullByDefault
@javax.annotation.processing.Generated("org.immutables.processor.ProxyProcessor")
@Immutable
@CheckReturnValue
public final class TokenService extends BaseTokenService {
  private final Credentials credentials;
  private final Authenticator authenticator;
  private final ScheduledExecutorService scheduler;
  private final Duration tokenTtl;
  private transient final AtomicReference<AccessToken> token;
  private transient final ScheduledFuture<?> scheduledFetchToken;
  @SuppressWarnings("Immutable")
  private transient int hashCode; // hashCode lazily computed

  private TokenService(TokenService.Builder builder) {
    this.credentials = builder.credentials;
    this.authenticator = builder.authenticator;
    if (builder.schedulerIsSet()) {
      initShim.scheduler(builder.scheduler);
    }
    if (builder.tokenTtlIsSet()) {
      initShim.tokenTtl(builder.tokenTtl);
    }
    this.scheduler = initShim.scheduler();
    this.tokenTtl = initShim.tokenTtl();
    this.token = initShim.token();
    this.scheduledFetchToken = initShim.scheduledFetchToken();
    this.initShim = null;
  }

  private static final byte STAGE_INITIALIZING = -1;
  private static final byte STAGE_UNINITIALIZED = 0;
  private static final byte STAGE_INITIALIZED = 1;
  @SuppressWarnings("Immutable")
  private transient volatile InitShim initShim = new InitShim();

  @Generated(from = "BaseTokenService", generator = "Immutables")
  private final class InitShim {
    private byte schedulerBuildStage = STAGE_UNINITIALIZED;
    private ScheduledExecutorService scheduler;

    ScheduledExecutorService scheduler() {
      if (schedulerBuildStage == STAGE_INITIALIZING) throw new IllegalStateException(formatInitCycleMessage());
      if (schedulerBuildStage == STAGE_UNINITIALIZED) {
        schedulerBuildStage = STAGE_INITIALIZING;
        this.scheduler = Objects.requireNonNull(TokenService.super.scheduler(), "scheduler");
        schedulerBuildStage = STAGE_INITIALIZED;
      }
      return this.scheduler;
    }

    void scheduler(ScheduledExecutorService scheduler) {
      this.scheduler = scheduler;
      schedulerBuildStage = STAGE_INITIALIZED;
    }

    private byte tokenTtlBuildStage = STAGE_UNINITIALIZED;
    private Duration tokenTtl;

    Duration tokenTtl() {
      if (tokenTtlBuildStage == STAGE_INITIALIZING) throw new IllegalStateException(formatInitCycleMessage());
      if (tokenTtlBuildStage == STAGE_UNINITIALIZED) {
        tokenTtlBuildStage = STAGE_INITIALIZING;
        this.tokenTtl = Objects.requireNonNull(TokenService.super.tokenTtl(), "tokenTtl");
        tokenTtlBuildStage = STAGE_INITIALIZED;
      }
      return this.tokenTtl;
    }

    void tokenTtl(Duration tokenTtl) {
      this.tokenTtl = tokenTtl;
      tokenTtlBuildStage = STAGE_INITIALIZED;
    }

    private byte tokenBuildStage = STAGE_UNINITIALIZED;
    private AtomicReference<AccessToken> token;

    AtomicReference<AccessToken> token() {
      if (tokenBuildStage == STAGE_INITIALIZING) throw new IllegalStateException(formatInitCycleMessage());
      if (tokenBuildStage == STAGE_UNINITIALIZED) {
        tokenBuildStage = STAGE_INITIALIZING;
        this.token = Objects.requireNonNull(TokenService.super.token(), "token");
        tokenBuildStage = STAGE_INITIALIZED;
      }
      return this.token;
    }

    private byte scheduledFetchTokenBuildStage = STAGE_UNINITIALIZED;
    private ScheduledFuture<?> scheduledFetchToken;

    ScheduledFuture<?> scheduledFetchToken() {
      if (scheduledFetchTokenBuildStage == STAGE_INITIALIZING) throw new IllegalStateException(formatInitCycleMessage());
      if (scheduledFetchTokenBuildStage == STAGE_UNINITIALIZED) {
        scheduledFetchTokenBuildStage = STAGE_INITIALIZING;
        this.scheduledFetchToken = Objects.requireNonNull(TokenService.super.scheduledFetchToken(), "scheduledFetchToken");
        scheduledFetchTokenBuildStage = STAGE_INITIALIZED;
      }
      return this.scheduledFetchToken;
    }

    private String formatInitCycleMessage() {
      List<String> attributes = new ArrayList<>();
      if (schedulerBuildStage == STAGE_INITIALIZING) attributes.add("scheduler");
      if (tokenTtlBuildStage == STAGE_INITIALIZING) attributes.add("tokenTtl");
      if (tokenBuildStage == STAGE_INITIALIZING) attributes.add("token");
      if (scheduledFetchTokenBuildStage == STAGE_INITIALIZING) attributes.add("scheduledFetchToken");
      return "Cannot build TokenService, attribute initializers form cycle " + attributes;
    }
  }

  /**
   * @return The value of the {@code credentials} attribute
   */
  @JsonProperty("credentials")
  @Override
  public Credentials credentials() {
    return credentials;
  }

  /**
   * @return The value of the {@code authenticator} attribute
   */
  @JsonProperty("authenticator")
  @Override
  public Authenticator authenticator() {
    return authenticator;
  }

  /**
   * @return The value of the {@code scheduler} attribute
   */
  @JsonProperty("scheduler")
  @Override
  public ScheduledExecutorService scheduler() {
    InitShim shim = this.initShim;
    return shim != null
        ? shim.scheduler()
        : this.scheduler;
  }

  /**
   * @return The value of the {@code tokenTtl} attribute
   */
  @JsonProperty("tokenTtl")
  @Override
  public Duration tokenTtl() {
    InitShim shim = this.initShim;
    return shim != null
        ? shim.tokenTtl()
        : this.tokenTtl;
  }

  /**
   * @return The computed-at-construction value of the {@code token} attribute
   */
  @JsonProperty("token")
  @Override
  public AtomicReference<AccessToken> token() {
    InitShim shim = this.initShim;
    return shim != null
        ? shim.token()
        : this.token;
  }

  /**
   * @return The computed-at-construction value of the {@code scheduledFetchToken} attribute
   */
  @JsonProperty("scheduledFetchToken")
  @Override
  public ScheduledFuture<?> scheduledFetchToken() {
    InitShim shim = this.initShim;
    return shim != null
        ? shim.scheduledFetchToken()
        : this.scheduledFetchToken;
  }

  /**
   * This instance is equal to all instances of {@code TokenService} that have equal attribute values.
   * @return {@code true} if {@code this} is equal to {@code another} instance
   */
  @Override
  public boolean equals(@Nullable Object another) {
    if (this == another) return true;
    return another instanceof TokenService
        && equalTo(0, (TokenService) another);
  }

  private boolean equalTo(int synthetic, TokenService another) {
    if (hashCode != 0 && another.hashCode != 0 && hashCode != another.hashCode) return false;
    return credentials.equals(another.credentials)
        && authenticator.equals(another.authenticator)
        && scheduler.equals(another.scheduler)
        && tokenTtl.equals(another.tokenTtl)
        && token.equals(another.token)
        && scheduledFetchToken.equals(another.scheduledFetchToken);
  }

  /**
   * Returns a lazily computed hash code from attributes: {@code credentials}, {@code authenticator}, {@code scheduler}, {@code tokenTtl}, {@code token}, {@code scheduledFetchToken}.
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
    h += (h << 5) + credentials.hashCode();
    h += (h << 5) + authenticator.hashCode();
    h += (h << 5) + scheduler.hashCode();
    h += (h << 5) + tokenTtl.hashCode();
    h += (h << 5) + token.hashCode();
    h += (h << 5) + scheduledFetchToken.hashCode();
    return h;
  }

  /**
   * Prints the immutable value {@code TokenService} with attribute values.
   * @return A string representation of the value
   */
  @Override
  public String toString() {
    return MoreObjects.toStringHelper("TokenService")
        .omitNullValues()
        .add("credentials", credentials)
        .add("authenticator", authenticator)
        .add("scheduler", scheduler)
        .add("tokenTtl", tokenTtl)
        .add("token", token)
        .add("scheduledFetchToken", scheduledFetchToken)
        .toString();
  }

  /**
   * Utility type used to correctly read immutable object from JSON representation.
   * @deprecated Do not use this type directly, it exists only for the <em>Jackson</em>-binding infrastructure
   */
  @Generated(from = "BaseTokenService", generator = "Immutables")
  @Deprecated
  @SuppressWarnings("Immutable")
  @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.NONE)
  static final class Json extends BaseTokenService {
    @Nullable Credentials credentials;
    @Nullable Authenticator authenticator;
    @Nullable ScheduledExecutorService scheduler;
    boolean schedulerIsSet;
    @Nullable Duration tokenTtl;
    boolean tokenTtlIsSet;
    @JsonProperty("credentials")
    public void setCredentials(Credentials credentials) {
      this.credentials = credentials;
    }
    @JsonProperty("authenticator")
    public void setAuthenticator(Authenticator authenticator) {
      this.authenticator = authenticator;
    }
    @JsonProperty("scheduler")
    public void setScheduler(ScheduledExecutorService scheduler) {
      this.scheduler = scheduler;
      this.schedulerIsSet = true;
    }
    @JsonProperty("tokenTtl")
    public void setTokenTtl(Duration tokenTtl) {
      this.tokenTtl = tokenTtl;
      this.tokenTtlIsSet = true;
    }
    @Override
    public Credentials credentials() { throw new UnsupportedOperationException(); }
    @Override
    public Authenticator authenticator() { throw new UnsupportedOperationException(); }
    @Override
    public ScheduledExecutorService scheduler() { throw new UnsupportedOperationException(); }
    @Override
    public Duration tokenTtl() { throw new UnsupportedOperationException(); }
    @JsonIgnore
    @Override
    public AtomicReference<AccessToken> token() { throw new UnsupportedOperationException(); }
    @JsonIgnore
    @Override
    public ScheduledFuture<?> scheduledFetchToken() { throw new UnsupportedOperationException(); }
  }

  /**
   * @param json A JSON-bindable data structure
   * @return An immutable value type
   * @deprecated Do not use this method directly, it exists only for the <em>Jackson</em>-binding infrastructure
   */
  @Deprecated
  @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
  static TokenService fromJson(Json json) {
    TokenService.Builder builder = TokenService.builder();
    if (json.credentials != null) {
      builder.credentials(json.credentials);
    }
    if (json.authenticator != null) {
      builder.authenticator(json.authenticator);
    }
    if (json.schedulerIsSet) {
      builder.scheduler(json.scheduler);
    }
    if (json.tokenTtlIsSet) {
      builder.tokenTtl(json.tokenTtl);
    }
    return builder.build();
  }

  /**
   * Creates a builder for {@link TokenService TokenService}.
   * <pre>
   * TokenService.builder()
   *    .credentials(nsf.pda.auth.Credentials) // required {@link TokenService#credentials() credentials}
   *    .authenticator(nsf.pda.auth.Authenticator) // required {@link TokenService#authenticator() authenticator}
   *    .scheduler(concurrent.ScheduledExecutorService) // optional {@link TokenService#scheduler() scheduler}
   *    .tokenTtl(java.time.Duration) // optional {@link TokenService#tokenTtl() tokenTtl}
   *    .build();
   * </pre>
   * @return A new TokenService builder
   */
  public static TokenService.Builder builder() {
    return new TokenService.Builder();
  }

  /**
   * Builds instances of type {@link TokenService TokenService}.
   * Initialize attributes and then invoke the {@link #build()} method to create an
   * immutable instance.
   * <p><em>{@code Builder} is not thread-safe and generally should not be stored in a field or collection,
   * but instead used immediately to create instances.</em>
   */
  @Generated(from = "BaseTokenService", generator = "Immutables")
  @NotThreadSafe
  public static final class Builder {
    private static final long INIT_BIT_CREDENTIALS = 0x1L;
    private static final long INIT_BIT_AUTHENTICATOR = 0x2L;
    private static final long OPT_BIT_SCHEDULER = 0x1L;
    private static final long OPT_BIT_TOKEN_TTL = 0x2L;
    private long initBits = 0x3L;
    private long optBits;

    private @Nullable Credentials credentials;
    private @Nullable Authenticator authenticator;
    private @Nullable ScheduledExecutorService scheduler;
    private @Nullable Duration tokenTtl;

    private Builder() {
    }

    /**
     * Initializes the value for the {@link TokenService#credentials() credentials} attribute.
     * @param credentials The value for credentials 
     * @return {@code this} builder for use in a chained invocation
     */
    @CanIgnoreReturnValue 
    public final Builder credentials(Credentials credentials) {
      checkNotIsSet(credentialsIsSet(), "credentials");
      this.credentials = Objects.requireNonNull(credentials, "credentials");
      initBits &= ~INIT_BIT_CREDENTIALS;
      return this;
    }

    /**
     * Initializes the value for the {@link TokenService#authenticator() authenticator} attribute.
     * @param authenticator The value for authenticator 
     * @return {@code this} builder for use in a chained invocation
     */
    @CanIgnoreReturnValue 
    public final Builder authenticator(Authenticator authenticator) {
      checkNotIsSet(authenticatorIsSet(), "authenticator");
      this.authenticator = Objects.requireNonNull(authenticator, "authenticator");
      initBits &= ~INIT_BIT_AUTHENTICATOR;
      return this;
    }

    /**
     * Initializes the value for the {@link TokenService#scheduler() scheduler} attribute.
     * <p><em>If not set, this attribute will have a default value as returned by the initializer of {@link TokenService#scheduler() scheduler}.</em>
     * @param scheduler The value for scheduler 
     * @return {@code this} builder for use in a chained invocation
     */
    @CanIgnoreReturnValue 
    public final Builder scheduler(ScheduledExecutorService scheduler) {
      checkNotIsSet(schedulerIsSet(), "scheduler");
      this.scheduler = Objects.requireNonNull(scheduler, "scheduler");
      optBits |= OPT_BIT_SCHEDULER;
      return this;
    }

    /**
     * Initializes the value for the {@link TokenService#tokenTtl() tokenTtl} attribute.
     * <p><em>If not set, this attribute will have a default value as returned by the initializer of {@link TokenService#tokenTtl() tokenTtl}.</em>
     * @param tokenTtl The value for tokenTtl 
     * @return {@code this} builder for use in a chained invocation
     */
    @CanIgnoreReturnValue 
    public final Builder tokenTtl(Duration tokenTtl) {
      checkNotIsSet(tokenTtlIsSet(), "tokenTtl");
      this.tokenTtl = Objects.requireNonNull(tokenTtl, "tokenTtl");
      optBits |= OPT_BIT_TOKEN_TTL;
      return this;
    }

    /**
     * Builds a new {@link TokenService TokenService}.
     * @return An immutable instance of TokenService
     * @throws java.lang.IllegalStateException if any required attributes are missing
     */
    public TokenService build() {
      checkRequiredAttributes();
      return new TokenService(this);
    }

    private boolean schedulerIsSet() {
      return (optBits & OPT_BIT_SCHEDULER) != 0;
    }

    private boolean tokenTtlIsSet() {
      return (optBits & OPT_BIT_TOKEN_TTL) != 0;
    }

    private boolean credentialsIsSet() {
      return (initBits & INIT_BIT_CREDENTIALS) == 0;
    }

    private boolean authenticatorIsSet() {
      return (initBits & INIT_BIT_AUTHENTICATOR) == 0;
    }

    private static void checkNotIsSet(boolean isSet, String name) {
      if (isSet) throw new IllegalStateException("Builder of TokenService is strict, attribute is already set: ".concat(name));
    }

    private void checkRequiredAttributes() {
      if (initBits != 0) {
        throw new IllegalStateException(formatRequiredAttributesMessage());
      }
    }

    private String formatRequiredAttributesMessage() {
      List<String> attributes = new ArrayList<>();
      if (!credentialsIsSet()) attributes.add("credentials");
      if (!authenticatorIsSet()) attributes.add("authenticator");
      return "Cannot build TokenService, some of required attributes are not set " + attributes;
    }
  }
}
