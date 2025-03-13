package nsf.vertx.auth.token;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.Var;
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
 * Immutable implementation of {@link BaseFixedTokenStore}.
 * <p>
 * Use the builder to create immutable instances:
 * {@code FixedTokenStore.builder()}.
 */
@Generated(from = "BaseFixedTokenStore", generator = "Immutables")
@SuppressWarnings({"all"})
@ParametersAreNonnullByDefault
@javax.annotation.processing.Generated("org.immutables.processor.ProxyProcessor")
@Immutable
@CheckReturnValue
public final class FixedTokenStore extends BaseFixedTokenStore {
  private final String value;
  private final TokenDecoder decoder;
  @SuppressWarnings("Immutable")
  private transient int hashCode; // hashCode lazily computed

  private FixedTokenStore(FixedTokenStore.Builder builder) {
    this.value = builder.value;
    this.decoder = builder.decoder;
  }

  /**
   * @return The value of the {@code value} attribute
   */
  @JsonProperty("value")
  @Override
  public String value() {
    return value;
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
   * This instance is equal to all instances of {@code FixedTokenStore} that have equal attribute values.
   * @return {@code true} if {@code this} is equal to {@code another} instance
   */
  @Override
  public boolean equals(@Nullable Object another) {
    if (this == another) return true;
    return another instanceof FixedTokenStore
        && equalTo(0, (FixedTokenStore) another);
  }

  private boolean equalTo(int synthetic, FixedTokenStore another) {
    if (hashCode != 0 && another.hashCode != 0 && hashCode != another.hashCode) return false;
    return value.equals(another.value)
        && decoder.equals(another.decoder);
  }

  /**
   * Returns a lazily computed hash code from attributes: {@code value}, {@code decoder}.
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
    h += (h << 5) + value.hashCode();
    h += (h << 5) + decoder.hashCode();
    return h;
  }

  /**
   * Prints the immutable value {@code FixedTokenStore} with attribute values.
   * @return A string representation of the value
   */
  @Override
  public String toString() {
    return MoreObjects.toStringHelper("FixedTokenStore")
        .omitNullValues()
        .add("value", value)
        .add("decoder", decoder)
        .toString();
  }

  /**
   * Utility type used to correctly read immutable object from JSON representation.
   * @deprecated Do not use this type directly, it exists only for the <em>Jackson</em>-binding infrastructure
   */
  @Generated(from = "BaseFixedTokenStore", generator = "Immutables")
  @Deprecated
  @SuppressWarnings("Immutable")
  @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.NONE)
  static final class Json extends BaseFixedTokenStore {
    @Nullable String value;
    @Nullable TokenDecoder decoder;
    @JsonProperty("value")
    public void setValue(String value) {
      this.value = value;
    }
    @JsonProperty("decoder")
    public void setDecoder(TokenDecoder decoder) {
      this.decoder = decoder;
    }
    @Override
    public String value() { throw new UnsupportedOperationException(); }
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
  static FixedTokenStore fromJson(Json json) {
    FixedTokenStore.Builder builder = FixedTokenStore.builder();
    if (json.value != null) {
      builder.value(json.value);
    }
    if (json.decoder != null) {
      builder.decoder(json.decoder);
    }
    return builder.build();
  }

  /**
   * Creates a builder for {@link FixedTokenStore FixedTokenStore}.
   * <pre>
   * FixedTokenStore.builder()
   *    .value(String) // required {@link FixedTokenStore#value() value}
   *    .decoder(nsf.vertx.auth.token.TokenDecoder) // required {@link FixedTokenStore#decoder() decoder}
   *    .build();
   * </pre>
   * @return A new FixedTokenStore builder
   */
  public static FixedTokenStore.Builder builder() {
    return new FixedTokenStore.Builder();
  }

  /**
   * Builds instances of type {@link FixedTokenStore FixedTokenStore}.
   * Initialize attributes and then invoke the {@link #build()} method to create an
   * immutable instance.
   * <p><em>{@code Builder} is not thread-safe and generally should not be stored in a field or collection,
   * but instead used immediately to create instances.</em>
   */
  @Generated(from = "BaseFixedTokenStore", generator = "Immutables")
  @NotThreadSafe
  public static final class Builder {
    private static final long INIT_BIT_VALUE = 0x1L;
    private static final long INIT_BIT_DECODER = 0x2L;
    private long initBits = 0x3L;

    private @Nullable String value;
    private @Nullable TokenDecoder decoder;

    private Builder() {
    }

    /**
     * Initializes the value for the {@link FixedTokenStore#value() value} attribute.
     * @param value The value for value 
     * @return {@code this} builder for use in a chained invocation
     */
    @CanIgnoreReturnValue 
    public final Builder value(String value) {
      checkNotIsSet(valueIsSet(), "value");
      this.value = Objects.requireNonNull(value, "value");
      initBits &= ~INIT_BIT_VALUE;
      return this;
    }

    /**
     * Initializes the value for the {@link FixedTokenStore#decoder() decoder} attribute.
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
     * Builds a new {@link FixedTokenStore FixedTokenStore}.
     * @return An immutable instance of FixedTokenStore
     * @throws java.lang.IllegalStateException if any required attributes are missing
     */
    public FixedTokenStore build() {
      checkRequiredAttributes();
      return new FixedTokenStore(this);
    }

    private boolean valueIsSet() {
      return (initBits & INIT_BIT_VALUE) == 0;
    }

    private boolean decoderIsSet() {
      return (initBits & INIT_BIT_DECODER) == 0;
    }

    private static void checkNotIsSet(boolean isSet, String name) {
      if (isSet) throw new IllegalStateException("Builder of FixedTokenStore is strict, attribute is already set: ".concat(name));
    }

    private void checkRequiredAttributes() {
      if (initBits != 0) {
        throw new IllegalStateException(formatRequiredAttributesMessage());
      }
    }

    private String formatRequiredAttributesMessage() {
      List<String> attributes = new ArrayList<>();
      if (!valueIsSet()) attributes.add("value");
      if (!decoderIsSet()) attributes.add("decoder");
      return "Cannot build FixedTokenStore, some of required attributes are not set " + attributes;
    }
  }
}
