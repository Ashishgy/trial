package nsf.vertx.auth.key;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.Var;
import java.security.PublicKey;
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
 * Immutable implementation of {@link BaseFixedPublicKeyStore}.
 * <p>
 * Use the builder to create immutable instances:
 * {@code FixedPublicKeyStore.builder()}.
 */
@Generated(from = "BaseFixedPublicKeyStore", generator = "Immutables")
@SuppressWarnings({"all"})
@ParametersAreNonnullByDefault
@javax.annotation.processing.Generated("org.immutables.processor.ProxyProcessor")
@Immutable
@CheckReturnValue
public final class FixedPublicKeyStore extends BaseFixedPublicKeyStore {
  private final PublicKey value;
  @SuppressWarnings("Immutable")
  private transient int hashCode; // hashCode lazily computed

  private FixedPublicKeyStore(FixedPublicKeyStore.Builder builder) {
    this.value = builder.value;
  }

  /**
   * @return The value of the {@code value} attribute
   */
  @JsonProperty("value")
  @Override
  public PublicKey value() {
    return value;
  }

  /**
   * This instance is equal to all instances of {@code FixedPublicKeyStore} that have equal attribute values.
   * @return {@code true} if {@code this} is equal to {@code another} instance
   */
  @Override
  public boolean equals(@Nullable Object another) {
    if (this == another) return true;
    return another instanceof FixedPublicKeyStore
        && equalTo(0, (FixedPublicKeyStore) another);
  }

  private boolean equalTo(int synthetic, FixedPublicKeyStore another) {
    if (hashCode != 0 && another.hashCode != 0 && hashCode != another.hashCode) return false;
    return value.equals(another.value);
  }

  /**
   * Returns a lazily computed hash code from attributes: {@code value}.
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
    return h;
  }

  /**
   * Prints the immutable value {@code FixedPublicKeyStore} with attribute values.
   * @return A string representation of the value
   */
  @Override
  public String toString() {
    return MoreObjects.toStringHelper("FixedPublicKeyStore")
        .omitNullValues()
        .add("value", value)
        .toString();
  }

  /**
   * Utility type used to correctly read immutable object from JSON representation.
   * @deprecated Do not use this type directly, it exists only for the <em>Jackson</em>-binding infrastructure
   */
  @Generated(from = "BaseFixedPublicKeyStore", generator = "Immutables")
  @Deprecated
  @SuppressWarnings("Immutable")
  @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.NONE)
  static final class Json extends BaseFixedPublicKeyStore {
    @Nullable PublicKey value;
    @JsonProperty("value")
    public void setValue(PublicKey value) {
      this.value = value;
    }
    @Override
    public PublicKey value() { throw new UnsupportedOperationException(); }
  }

  /**
   * @param json A JSON-bindable data structure
   * @return An immutable value type
   * @deprecated Do not use this method directly, it exists only for the <em>Jackson</em>-binding infrastructure
   */
  @Deprecated
  @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
  static FixedPublicKeyStore fromJson(Json json) {
    FixedPublicKeyStore.Builder builder = FixedPublicKeyStore.builder();
    if (json.value != null) {
      builder.value(json.value);
    }
    return builder.build();
  }

  /**
   * Creates a builder for {@link FixedPublicKeyStore FixedPublicKeyStore}.
   * <pre>
   * FixedPublicKeyStore.builder()
   *    .value(java.security.PublicKey) // required {@link FixedPublicKeyStore#value() value}
   *    .build();
   * </pre>
   * @return A new FixedPublicKeyStore builder
   */
  public static FixedPublicKeyStore.Builder builder() {
    return new FixedPublicKeyStore.Builder();
  }

  /**
   * Builds instances of type {@link FixedPublicKeyStore FixedPublicKeyStore}.
   * Initialize attributes and then invoke the {@link #build()} method to create an
   * immutable instance.
   * <p><em>{@code Builder} is not thread-safe and generally should not be stored in a field or collection,
   * but instead used immediately to create instances.</em>
   */
  @Generated(from = "BaseFixedPublicKeyStore", generator = "Immutables")
  @NotThreadSafe
  public static final class Builder {
    private static final long INIT_BIT_VALUE = 0x1L;
    private long initBits = 0x1L;

    private @Nullable PublicKey value;

    private Builder() {
    }

    /**
     * Initializes the value for the {@link FixedPublicKeyStore#value() value} attribute.
     * @param value The value for value 
     * @return {@code this} builder for use in a chained invocation
     */
    @CanIgnoreReturnValue 
    public final Builder value(PublicKey value) {
      checkNotIsSet(valueIsSet(), "value");
      this.value = Objects.requireNonNull(value, "value");
      initBits &= ~INIT_BIT_VALUE;
      return this;
    }

    /**
     * Builds a new {@link FixedPublicKeyStore FixedPublicKeyStore}.
     * @return An immutable instance of FixedPublicKeyStore
     * @throws java.lang.IllegalStateException if any required attributes are missing
     */
    public FixedPublicKeyStore build() {
      checkRequiredAttributes();
      return new FixedPublicKeyStore(this);
    }

    private boolean valueIsSet() {
      return (initBits & INIT_BIT_VALUE) == 0;
    }

    private static void checkNotIsSet(boolean isSet, String name) {
      if (isSet) throw new IllegalStateException("Builder of FixedPublicKeyStore is strict, attribute is already set: ".concat(name));
    }

    private void checkRequiredAttributes() {
      if (initBits != 0) {
        throw new IllegalStateException(formatRequiredAttributesMessage());
      }
    }

    private String formatRequiredAttributesMessage() {
      List<String> attributes = new ArrayList<>();
      if (!valueIsSet()) attributes.add("value");
      return "Cannot build FixedPublicKeyStore, some of required attributes are not set " + attributes;
    }
  }
}
