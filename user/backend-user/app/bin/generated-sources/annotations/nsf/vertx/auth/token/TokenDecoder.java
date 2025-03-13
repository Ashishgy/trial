package nsf.vertx.auth.token;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.Var;
import java.time.Clock;
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
 * Immutable implementation of {@link BaseTokenDecoder}.
 * <p>
 * Use the builder to create immutable instances:
 * {@code TokenDecoder.builder()}.
 */
@Generated(from = "BaseTokenDecoder", generator = "Immutables")
@SuppressWarnings({"all"})
@ParametersAreNonnullByDefault
@javax.annotation.processing.Generated("org.immutables.processor.ProxyProcessor")
@Immutable
@CheckReturnValue
public final class TokenDecoder extends BaseTokenDecoder {
  private final String host;
  private final Clock clock;
  @SuppressWarnings("Immutable")
  private transient int hashCode; // hashCode lazily computed

  private TokenDecoder(TokenDecoder.Builder builder) {
    this.host = builder.host;
    this.clock = builder.clock;
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
   * @return The value of the {@code clock} attribute
   */
  @JsonProperty("clock")
  @Override
  public Clock clock() {
    return clock;
  }

  /**
   * This instance is equal to all instances of {@code TokenDecoder} that have equal attribute values.
   * @return {@code true} if {@code this} is equal to {@code another} instance
   */
  @Override
  public boolean equals(@Nullable Object another) {
    if (this == another) return true;
    return another instanceof TokenDecoder
        && equalTo(0, (TokenDecoder) another);
  }

  private boolean equalTo(int synthetic, TokenDecoder another) {
    if (hashCode != 0 && another.hashCode != 0 && hashCode != another.hashCode) return false;
    return host.equals(another.host)
        && clock.equals(another.clock);
  }

  /**
   * Returns a lazily computed hash code from attributes: {@code host}, {@code clock}.
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
    h += (h << 5) + host.hashCode();
    h += (h << 5) + clock.hashCode();
    return h;
  }

  /**
   * Prints the immutable value {@code TokenDecoder} with attribute values.
   * @return A string representation of the value
   */
  @Override
  public String toString() {
    return MoreObjects.toStringHelper("TokenDecoder")
        .omitNullValues()
        .add("host", host)
        .add("clock", clock)
        .toString();
  }

  /**
   * Utility type used to correctly read immutable object from JSON representation.
   * @deprecated Do not use this type directly, it exists only for the <em>Jackson</em>-binding infrastructure
   */
  @Generated(from = "BaseTokenDecoder", generator = "Immutables")
  @Deprecated
  @SuppressWarnings("Immutable")
  @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.NONE)
  static final class Json extends BaseTokenDecoder {
    @Nullable String host;
    @Nullable Clock clock;
    @JsonProperty("host")
    public void setHost(String host) {
      this.host = host;
    }
    @JsonProperty("clock")
    public void setClock(Clock clock) {
      this.clock = clock;
    }
    @Override
    public String host() { throw new UnsupportedOperationException(); }
    @Override
    public Clock clock() { throw new UnsupportedOperationException(); }
  }

  /**
   * @param json A JSON-bindable data structure
   * @return An immutable value type
   * @deprecated Do not use this method directly, it exists only for the <em>Jackson</em>-binding infrastructure
   */
  @Deprecated
  @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
  static TokenDecoder fromJson(Json json) {
    TokenDecoder.Builder builder = TokenDecoder.builder();
    if (json.host != null) {
      builder.host(json.host);
    }
    if (json.clock != null) {
      builder.clock(json.clock);
    }
    return builder.build();
  }

  /**
   * Creates a builder for {@link TokenDecoder TokenDecoder}.
   * <pre>
   * TokenDecoder.builder()
   *    .host(String) // required {@link TokenDecoder#host() host}
   *    .clock(java.time.Clock) // required {@link TokenDecoder#clock() clock}
   *    .build();
   * </pre>
   * @return A new TokenDecoder builder
   */
  public static TokenDecoder.Builder builder() {
    return new TokenDecoder.Builder();
  }

  /**
   * Builds instances of type {@link TokenDecoder TokenDecoder}.
   * Initialize attributes and then invoke the {@link #build()} method to create an
   * immutable instance.
   * <p><em>{@code Builder} is not thread-safe and generally should not be stored in a field or collection,
   * but instead used immediately to create instances.</em>
   */
  @Generated(from = "BaseTokenDecoder", generator = "Immutables")
  @NotThreadSafe
  public static final class Builder {
    private static final long INIT_BIT_HOST = 0x1L;
    private static final long INIT_BIT_CLOCK = 0x2L;
    private long initBits = 0x3L;

    private @Nullable String host;
    private @Nullable Clock clock;

    private Builder() {
    }

    /**
     * Initializes the value for the {@link TokenDecoder#host() host} attribute.
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
     * Initializes the value for the {@link TokenDecoder#clock() clock} attribute.
     * @param clock The value for clock 
     * @return {@code this} builder for use in a chained invocation
     */
    @CanIgnoreReturnValue 
    public final Builder clock(Clock clock) {
      checkNotIsSet(clockIsSet(), "clock");
      this.clock = Objects.requireNonNull(clock, "clock");
      initBits &= ~INIT_BIT_CLOCK;
      return this;
    }

    /**
     * Builds a new {@link TokenDecoder TokenDecoder}.
     * @return An immutable instance of TokenDecoder
     * @throws java.lang.IllegalStateException if any required attributes are missing
     */
    public TokenDecoder build() {
      checkRequiredAttributes();
      return new TokenDecoder(this);
    }

    private boolean hostIsSet() {
      return (initBits & INIT_BIT_HOST) == 0;
    }

    private boolean clockIsSet() {
      return (initBits & INIT_BIT_CLOCK) == 0;
    }

    private static void checkNotIsSet(boolean isSet, String name) {
      if (isSet) throw new IllegalStateException("Builder of TokenDecoder is strict, attribute is already set: ".concat(name));
    }

    private void checkRequiredAttributes() {
      if (initBits != 0) {
        throw new IllegalStateException(formatRequiredAttributesMessage());
      }
    }

    private String formatRequiredAttributesMessage() {
      List<String> attributes = new ArrayList<>();
      if (!hostIsSet()) attributes.add("host");
      if (!clockIsSet()) attributes.add("clock");
      return "Cannot build TokenDecoder, some of required attributes are not set " + attributes;
    }
  }
}
