package nsf.vertx.auth.token;

import com.google.errorprone.annotations.CanIgnoreReturnValue;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import java.security.PublicKey;
import java.time.Clock;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;
import javax.annotation.concurrent.NotThreadSafe;
import org.immutables.value.Generated;

/**
 * {@code DecodedTokenBuilder} collects parameters and invokes the static factory method:
 * {@code nsf.vertx.auth.token.TokenFactories.decodedToken(..)}.
 * Call the {@link #build()} method to get a result of type {@code io.jsonwebtoken.Jws<io.jsonwebtoken.Claims>}.
 * <p><em>{@code DecodedTokenBuilder} is not thread-safe and generally should not be stored in a field or collection,
 * but instead used immediately to create instances.</em>
 */
@Generated(from = "TokenFactories.decodedToken", generator = "Immutables")
@SuppressWarnings({"OptionalUsedAsFieldOrParameterType", "all"})
@ParametersAreNonnullByDefault
@javax.annotation.processing.Generated("org.immutables.processor.ProxyProcessor")
@NotThreadSafe
public final class DecodedTokenBuilder {
  private static final long INIT_BIT_ENCODED = 0x1L;
  private static final long INIT_BIT_HOST = 0x2L;
  private static final long INIT_BIT_PUBLIC_KEY = 0x4L;
  private static final long INIT_BIT_CLOCK = 0x8L;
  private static final long OPT_BIT_STRICT = 0x1L;
  private long initBits = 0xfL;
  private long optBits;

  private @Nullable String encoded;
  private @Nullable String host;
  private @Nullable PublicKey publicKey;
  private @Nullable Clock clock;
  private Optional<Boolean> strict = Optional.empty();

  private DecodedTokenBuilder() {
  }

  /**
   * Creates a {@code DecodedTokenBuilder} factory builder.
   * @return A new builder
   */
  public static DecodedTokenBuilder create() {
    return new DecodedTokenBuilder();
  }

  /**
   * Initializes the value for the {@code encoded} attribute.
   * @param encoded The value for encoded 
   * @return {@code this} builder for use in a chained invocation
   */
  @CanIgnoreReturnValue 
  public final DecodedTokenBuilder encoded(String encoded) {
    checkNotIsSet(encodedIsSet(), "encoded");
    this.encoded = Objects.requireNonNull(encoded, "encoded");
    initBits &= ~INIT_BIT_ENCODED;
    return this;
  }

  /**
   * Initializes the value for the {@code host} attribute.
   * @param host The value for host 
   * @return {@code this} builder for use in a chained invocation
   */
  @CanIgnoreReturnValue 
  public final DecodedTokenBuilder host(String host) {
    checkNotIsSet(hostIsSet(), "host");
    this.host = Objects.requireNonNull(host, "host");
    initBits &= ~INIT_BIT_HOST;
    return this;
  }

  /**
   * Initializes the value for the {@code publicKey} attribute.
   * @param publicKey The value for publicKey 
   * @return {@code this} builder for use in a chained invocation
   */
  @CanIgnoreReturnValue 
  public final DecodedTokenBuilder publicKey(PublicKey publicKey) {
    checkNotIsSet(publicKeyIsSet(), "publicKey");
    this.publicKey = Objects.requireNonNull(publicKey, "publicKey");
    initBits &= ~INIT_BIT_PUBLIC_KEY;
    return this;
  }

  /**
   * Initializes the value for the {@code clock} attribute.
   * @param clock The value for clock 
   * @return {@code this} builder for use in a chained invocation
   */
  @CanIgnoreReturnValue 
  public final DecodedTokenBuilder clock(Clock clock) {
    checkNotIsSet(clockIsSet(), "clock");
    this.clock = Objects.requireNonNull(clock, "clock");
    initBits &= ~INIT_BIT_CLOCK;
    return this;
  }

  /**
   * Initializes the optional value {@code strict} to strict.
   * @param strict The value for strict
   * @return {@code this} builder for chained invocation
   */
  @CanIgnoreReturnValue 
  public final DecodedTokenBuilder strict(boolean strict) {
    checkNotIsSet(strictIsSet(), "strict");
    this.strict = Optional.of(strict);
    optBits |= OPT_BIT_STRICT;
    return this;
  }

  /**
   * Initializes the optional value {@code strict} to strict.
   * @param strict The value for strict
   * @return {@code this} builder for use in a chained invocation
   */
  @CanIgnoreReturnValue 
  public final DecodedTokenBuilder strict(Optional<Boolean> strict) {
    checkNotIsSet(strictIsSet(), "strict");
    this.strict = (Optional<Boolean>) Objects.requireNonNull(strict, "strict");
    optBits |= OPT_BIT_STRICT;
    return this;
  }

  /**
   * Invokes {@code nsf.vertx.auth.token.TokenFactories.decodedToken(..)} using the collected parameters and returns the result of the invocation
   * @return A result of type {@code io.jsonwebtoken.Jws<io.jsonwebtoken.Claims>}
   * @throws java.lang.IllegalStateException if any required attributes are missing
   */
  public Jws<Claims> build() {
    checkRequiredAttributes();
    return TokenFactories.decodedToken(encoded, host, publicKey, clock, strict);
  }

  private boolean strictIsSet() {
    return (optBits & OPT_BIT_STRICT) != 0;
  }

  private boolean encodedIsSet() {
    return (initBits & INIT_BIT_ENCODED) == 0;
  }

  private boolean hostIsSet() {
    return (initBits & INIT_BIT_HOST) == 0;
  }

  private boolean publicKeyIsSet() {
    return (initBits & INIT_BIT_PUBLIC_KEY) == 0;
  }

  private boolean clockIsSet() {
    return (initBits & INIT_BIT_CLOCK) == 0;
  }

  private static void checkNotIsSet(boolean isSet, String name) {
    if (isSet) throw new IllegalStateException("Builder of decodedToken is strict, attribute is already set: ".concat(name));
  }

  private void checkRequiredAttributes() {
    if (initBits != 0) {
      throw new IllegalStateException(formatRequiredAttributesMessage());
    }
  }

  private String formatRequiredAttributesMessage() {
    List<String> attributes = new ArrayList<>();
    if (!encodedIsSet()) attributes.add("encoded");
    if (!hostIsSet()) attributes.add("host");
    if (!publicKeyIsSet()) attributes.add("publicKey");
    if (!clockIsSet()) attributes.add("clock");
    return "Cannot build decodedToken, some of required attributes are not set " + attributes;
  }
}
