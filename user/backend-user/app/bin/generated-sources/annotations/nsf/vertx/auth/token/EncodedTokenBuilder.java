package nsf.vertx.auth.token;

import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.security.PrivateKey;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;
import javax.annotation.concurrent.NotThreadSafe;
import org.immutables.value.Generated;

/**
 * {@code EncodedTokenBuilder} collects parameters and invokes the static factory method:
 * {@code nsf.vertx.auth.token.TokenFactories.encodedToken(..)}.
 * Call the {@link #build()} method to get a result of type {@code java.lang.String}.
 * <p><em>{@code EncodedTokenBuilder} is not thread-safe and generally should not be stored in a field or collection,
 * but instead used immediately to create instances.</em>
 */
@Generated(from = "TokenFactories.encodedToken", generator = "Immutables")
@SuppressWarnings({"OptionalUsedAsFieldOrParameterType", "all"})
@ParametersAreNonnullByDefault
@javax.annotation.processing.Generated("org.immutables.processor.ProxyProcessor")
@NotThreadSafe
public final class EncodedTokenBuilder {
  private static final long INIT_BIT_HOST = 0x1L;
  private static final long INIT_BIT_PRIVATE_KEY = 0x2L;
  private static final long OPT_BIT_ISSUED_AT = 0x1L;
  private static final long OPT_BIT_EXPIRES_AT = 0x2L;
  private static final long OPT_BIT_ADD_ISSUER = 0x4L;
  private static final long OPT_BIT_ADD_RESOURCE = 0x8L;
  private static final long OPT_BIT_ADD_ACCESS_SCOPE = 0x10L;
  private long initBits = 0x3L;
  private long optBits;

  private @Nullable String host;
  private @Nullable PrivateKey privateKey;
  private Optional<Instant> issuedAt = Optional.empty();
  private Optional<Instant> expiresAt = Optional.empty();
  private Optional<Boolean> addIssuer = Optional.empty();
  private Optional<Boolean> addResource = Optional.empty();
  private Optional<Boolean> addAccessScope = Optional.empty();

  private EncodedTokenBuilder() {
  }

  /**
   * Creates a {@code EncodedTokenBuilder} factory builder.
   * @return A new builder
   */
  public static EncodedTokenBuilder create() {
    return new EncodedTokenBuilder();
  }

  /**
   * Initializes the value for the {@code host} attribute.
   * @param host The value for host 
   * @return {@code this} builder for use in a chained invocation
   */
  @CanIgnoreReturnValue 
  public final EncodedTokenBuilder host(String host) {
    checkNotIsSet(hostIsSet(), "host");
    this.host = Objects.requireNonNull(host, "host");
    initBits &= ~INIT_BIT_HOST;
    return this;
  }

  /**
   * Initializes the value for the {@code privateKey} attribute.
   * @param privateKey The value for privateKey 
   * @return {@code this} builder for use in a chained invocation
   */
  @CanIgnoreReturnValue 
  public final EncodedTokenBuilder privateKey(PrivateKey privateKey) {
    checkNotIsSet(privateKeyIsSet(), "privateKey");
    this.privateKey = Objects.requireNonNull(privateKey, "privateKey");
    initBits &= ~INIT_BIT_PRIVATE_KEY;
    return this;
  }

  /**
   * Initializes the optional value {@code issuedAt} to issuedAt.
   * @param issuedAt The value for issuedAt
   * @return {@code this} builder for chained invocation
   */
  @CanIgnoreReturnValue 
  public final EncodedTokenBuilder issuedAt(Instant issuedAt) {
    checkNotIsSet(issuedAtIsSet(), "issuedAt");
    this.issuedAt = Optional.of(issuedAt);
    optBits |= OPT_BIT_ISSUED_AT;
    return this;
  }

  /**
   * Initializes the optional value {@code issuedAt} to issuedAt.
   * @param issuedAt The value for issuedAt
   * @return {@code this} builder for use in a chained invocation
   */
  @SuppressWarnings("unchecked") // safe covariant cast
  @CanIgnoreReturnValue 
  public final EncodedTokenBuilder issuedAt(Optional<? extends Instant> issuedAt) {
    checkNotIsSet(issuedAtIsSet(), "issuedAt");
    this.issuedAt = (Optional<Instant>) Objects.requireNonNull(issuedAt, "issuedAt");
    optBits |= OPT_BIT_ISSUED_AT;
    return this;
  }

  /**
   * Initializes the optional value {@code expiresAt} to expiresAt.
   * @param expiresAt The value for expiresAt
   * @return {@code this} builder for chained invocation
   */
  @CanIgnoreReturnValue 
  public final EncodedTokenBuilder expiresAt(Instant expiresAt) {
    checkNotIsSet(expiresAtIsSet(), "expiresAt");
    this.expiresAt = Optional.of(expiresAt);
    optBits |= OPT_BIT_EXPIRES_AT;
    return this;
  }

  /**
   * Initializes the optional value {@code expiresAt} to expiresAt.
   * @param expiresAt The value for expiresAt
   * @return {@code this} builder for use in a chained invocation
   */
  @SuppressWarnings("unchecked") // safe covariant cast
  @CanIgnoreReturnValue 
  public final EncodedTokenBuilder expiresAt(Optional<? extends Instant> expiresAt) {
    checkNotIsSet(expiresAtIsSet(), "expiresAt");
    this.expiresAt = (Optional<Instant>) Objects.requireNonNull(expiresAt, "expiresAt");
    optBits |= OPT_BIT_EXPIRES_AT;
    return this;
  }

  /**
   * Initializes the optional value {@code addIssuer} to addIssuer.
   * @param addIssuer The value for addIssuer
   * @return {@code this} builder for chained invocation
   */
  @CanIgnoreReturnValue 
  public final EncodedTokenBuilder addIssuer(boolean addIssuer) {
    checkNotIsSet(addIssuerIsSet(), "addIssuer");
    this.addIssuer = Optional.of(addIssuer);
    optBits |= OPT_BIT_ADD_ISSUER;
    return this;
  }

  /**
   * Initializes the optional value {@code addIssuer} to addIssuer.
   * @param addIssuer The value for addIssuer
   * @return {@code this} builder for use in a chained invocation
   */
  @CanIgnoreReturnValue 
  public final EncodedTokenBuilder addIssuer(Optional<Boolean> addIssuer) {
    checkNotIsSet(addIssuerIsSet(), "addIssuer");
    this.addIssuer = (Optional<Boolean>) Objects.requireNonNull(addIssuer, "addIssuer");
    optBits |= OPT_BIT_ADD_ISSUER;
    return this;
  }

  /**
   * Initializes the optional value {@code addResource} to addResource.
   * @param addResource The value for addResource
   * @return {@code this} builder for chained invocation
   */
  @CanIgnoreReturnValue 
  public final EncodedTokenBuilder addResource(boolean addResource) {
    checkNotIsSet(addResourceIsSet(), "addResource");
    this.addResource = Optional.of(addResource);
    optBits |= OPT_BIT_ADD_RESOURCE;
    return this;
  }

  /**
   * Initializes the optional value {@code addResource} to addResource.
   * @param addResource The value for addResource
   * @return {@code this} builder for use in a chained invocation
   */
  @CanIgnoreReturnValue 
  public final EncodedTokenBuilder addResource(Optional<Boolean> addResource) {
    checkNotIsSet(addResourceIsSet(), "addResource");
    this.addResource = (Optional<Boolean>) Objects.requireNonNull(addResource, "addResource");
    optBits |= OPT_BIT_ADD_RESOURCE;
    return this;
  }

  /**
   * Initializes the optional value {@code addAccessScope} to addAccessScope.
   * @param addAccessScope The value for addAccessScope
   * @return {@code this} builder for chained invocation
   */
  @CanIgnoreReturnValue 
  public final EncodedTokenBuilder addAccessScope(boolean addAccessScope) {
    checkNotIsSet(addAccessScopeIsSet(), "addAccessScope");
    this.addAccessScope = Optional.of(addAccessScope);
    optBits |= OPT_BIT_ADD_ACCESS_SCOPE;
    return this;
  }

  /**
   * Initializes the optional value {@code addAccessScope} to addAccessScope.
   * @param addAccessScope The value for addAccessScope
   * @return {@code this} builder for use in a chained invocation
   */
  @CanIgnoreReturnValue 
  public final EncodedTokenBuilder addAccessScope(Optional<Boolean> addAccessScope) {
    checkNotIsSet(addAccessScopeIsSet(), "addAccessScope");
    this.addAccessScope = (Optional<Boolean>) Objects.requireNonNull(addAccessScope, "addAccessScope");
    optBits |= OPT_BIT_ADD_ACCESS_SCOPE;
    return this;
  }

  /**
   * Invokes {@code nsf.vertx.auth.token.TokenFactories.encodedToken(..)} using the collected parameters and returns the result of the invocation
   * @return A result of type {@code java.lang.String}
   * @throws java.lang.IllegalStateException if any required attributes are missing
   */
  public String build() {
    checkRequiredAttributes();
    return TokenFactories.encodedToken(host, privateKey, issuedAt, expiresAt, addIssuer, addResource, addAccessScope);
  }

  private boolean issuedAtIsSet() {
    return (optBits & OPT_BIT_ISSUED_AT) != 0;
  }

  private boolean expiresAtIsSet() {
    return (optBits & OPT_BIT_EXPIRES_AT) != 0;
  }

  private boolean addIssuerIsSet() {
    return (optBits & OPT_BIT_ADD_ISSUER) != 0;
  }

  private boolean addResourceIsSet() {
    return (optBits & OPT_BIT_ADD_RESOURCE) != 0;
  }

  private boolean addAccessScopeIsSet() {
    return (optBits & OPT_BIT_ADD_ACCESS_SCOPE) != 0;
  }

  private boolean hostIsSet() {
    return (initBits & INIT_BIT_HOST) == 0;
  }

  private boolean privateKeyIsSet() {
    return (initBits & INIT_BIT_PRIVATE_KEY) == 0;
  }

  private static void checkNotIsSet(boolean isSet, String name) {
    if (isSet) throw new IllegalStateException("Builder of encodedToken is strict, attribute is already set: ".concat(name));
  }

  private void checkRequiredAttributes() {
    if (initBits != 0) {
      throw new IllegalStateException(formatRequiredAttributesMessage());
    }
  }

  private String formatRequiredAttributesMessage() {
    List<String> attributes = new ArrayList<>();
    if (!hostIsSet()) attributes.add("host");
    if (!privateKeyIsSet()) attributes.add("privateKey");
    return "Cannot build encodedToken, some of required attributes are not set " + attributes;
  }
}
