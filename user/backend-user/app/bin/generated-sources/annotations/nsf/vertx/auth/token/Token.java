package nsf.vertx.auth.token;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.Var;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
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
 * Immutable implementation of {@link BaseToken}.
 * <p>
 * Use the builder to create immutable instances:
 * {@code Token.builder()}.
 * Use the static factory method to create immutable instances:
 * {@code Token.of()}.
 */
@Generated(from = "BaseToken", generator = "Immutables")
@SuppressWarnings({"all"})
@ParametersAreNonnullByDefault
@javax.annotation.processing.Generated("org.immutables.processor.ProxyProcessor")
@Immutable
@CheckReturnValue
public final class Token extends BaseToken {
  private final String encoded;
  private final Jws<Claims> decoded;
  @SuppressWarnings("Immutable")
  private transient int hashCode; // hashCode lazily computed

  private Token(String encoded, Jws<Claims> decoded) {
    this.encoded = Objects.requireNonNull(encoded, "encoded");
    this.decoded = Objects.requireNonNull(decoded, "decoded");
  }

  private Token(Token.Builder builder) {
    this.encoded = builder.encoded;
    this.decoded = builder.decoded;
  }

  /**
   * @return The value of the {@code encoded} attribute
   */
  @JsonProperty("encoded")
  @Override
  public String encoded() {
    return encoded;
  }

  /**
   * @return The value of the {@code decoded} attribute
   */
  @JsonProperty("decoded")
  @Override
  public Jws<Claims> decoded() {
    return decoded;
  }

  /**
   * This instance is equal to all instances of {@code Token} that have equal attribute values.
   * @return {@code true} if {@code this} is equal to {@code another} instance
   */
  @Override
  public boolean equals(@Nullable Object another) {
    if (this == another) return true;
    return another instanceof Token
        && equalTo(0, (Token) another);
  }

  private boolean equalTo(int synthetic, Token another) {
    if (hashCode != 0 && another.hashCode != 0 && hashCode != another.hashCode) return false;
    return encoded.equals(another.encoded)
        && decoded.equals(another.decoded);
  }

  /**
   * Returns a lazily computed hash code from attributes: {@code encoded}, {@code decoded}.
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
    h += (h << 5) + encoded.hashCode();
    h += (h << 5) + decoded.hashCode();
    return h;
  }

  /**
   * Prints the immutable value {@code Token} with attribute values.
   * @return A string representation of the value
   */
  @Override
  public String toString() {
    return MoreObjects.toStringHelper("Token")
        .omitNullValues()
        .add("encoded", encoded)
        .add("decoded", decoded)
        .toString();
  }

  /**
   * Utility type used to correctly read immutable object from JSON representation.
   * @deprecated Do not use this type directly, it exists only for the <em>Jackson</em>-binding infrastructure
   */
  @Generated(from = "BaseToken", generator = "Immutables")
  @Deprecated
  @SuppressWarnings("Immutable")
  @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.NONE)
  static final class Json extends BaseToken {
    @Nullable String encoded;
    @Nullable Jws<Claims> decoded;
    @JsonProperty("encoded")
    public void setEncoded(String encoded) {
      this.encoded = encoded;
    }
    @JsonProperty("decoded")
    public void setDecoded(Jws<Claims> decoded) {
      this.decoded = decoded;
    }
    @Override
    public String encoded() { throw new UnsupportedOperationException(); }
    @Override
    public Jws<Claims> decoded() { throw new UnsupportedOperationException(); }
  }

  /**
   * @param json A JSON-bindable data structure
   * @return An immutable value type
   * @deprecated Do not use this method directly, it exists only for the <em>Jackson</em>-binding infrastructure
   */
  @Deprecated
  @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
  static Token fromJson(Json json) {
    Token.Builder builder = Token.builder();
    if (json.encoded != null) {
      builder.encoded(json.encoded);
    }
    if (json.decoded != null) {
      builder.decoded(json.decoded);
    }
    return builder.build();
  }

  /**
   * Construct a new immutable {@code Token} instance.
   * @param encoded The value for the {@code encoded} attribute
   * @param decoded The value for the {@code decoded} attribute
   * @return An immutable Token instance
   */
  public static Token of(String encoded, Jws<Claims> decoded) {
    return new Token(encoded, decoded);
  }

  /**
   * Creates a builder for {@link Token Token}.
   * <pre>
   * Token.builder()
   *    .encoded(String) // required {@link Token#encoded() encoded}
   *    .decoded(io.jsonwebtoken.Jws&amp;lt;io.jsonwebtoken.Claims&amp;gt;) // required {@link Token#decoded() decoded}
   *    .build();
   * </pre>
   * @return A new Token builder
   */
  public static Token.Builder builder() {
    return new Token.Builder();
  }

  /**
   * Builds instances of type {@link Token Token}.
   * Initialize attributes and then invoke the {@link #build()} method to create an
   * immutable instance.
   * <p><em>{@code Builder} is not thread-safe and generally should not be stored in a field or collection,
   * but instead used immediately to create instances.</em>
   */
  @Generated(from = "BaseToken", generator = "Immutables")
  @NotThreadSafe
  public static final class Builder {
    private static final long INIT_BIT_ENCODED = 0x1L;
    private static final long INIT_BIT_DECODED = 0x2L;
    private long initBits = 0x3L;

    private @Nullable String encoded;
    private @Nullable Jws<Claims> decoded;

    private Builder() {
    }

    /**
     * Initializes the value for the {@link Token#encoded() encoded} attribute.
     * @param encoded The value for encoded 
     * @return {@code this} builder for use in a chained invocation
     */
    @CanIgnoreReturnValue 
    public final Builder encoded(String encoded) {
      checkNotIsSet(encodedIsSet(), "encoded");
      this.encoded = Objects.requireNonNull(encoded, "encoded");
      initBits &= ~INIT_BIT_ENCODED;
      return this;
    }

    /**
     * Initializes the value for the {@link Token#decoded() decoded} attribute.
     * @param decoded The value for decoded 
     * @return {@code this} builder for use in a chained invocation
     */
    @CanIgnoreReturnValue 
    public final Builder decoded(Jws<Claims> decoded) {
      checkNotIsSet(decodedIsSet(), "decoded");
      this.decoded = Objects.requireNonNull(decoded, "decoded");
      initBits &= ~INIT_BIT_DECODED;
      return this;
    }

    /**
     * Builds a new {@link Token Token}.
     * @return An immutable instance of Token
     * @throws java.lang.IllegalStateException if any required attributes are missing
     */
    public Token build() {
      checkRequiredAttributes();
      return new Token(this);
    }

    private boolean encodedIsSet() {
      return (initBits & INIT_BIT_ENCODED) == 0;
    }

    private boolean decodedIsSet() {
      return (initBits & INIT_BIT_DECODED) == 0;
    }

    private static void checkNotIsSet(boolean isSet, String name) {
      if (isSet) throw new IllegalStateException("Builder of Token is strict, attribute is already set: ".concat(name));
    }

    private void checkRequiredAttributes() {
      if (initBits != 0) {
        throw new IllegalStateException(formatRequiredAttributesMessage());
      }
    }

    private String formatRequiredAttributesMessage() {
      List<String> attributes = new ArrayList<>();
      if (!encodedIsSet()) attributes.add("encoded");
      if (!decodedIsSet()) attributes.add("decoded");
      return "Cannot build Token, some of required attributes are not set " + attributes;
    }
  }
}
