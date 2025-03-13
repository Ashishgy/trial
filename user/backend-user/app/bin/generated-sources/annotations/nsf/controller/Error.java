package nsf.controller;

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
 * Immutable implementation of {@link BaseError}.
 * <p>
 * Use the builder to create immutable instances:
 * {@code Error.builder()}.
 */
@Generated(from = "BaseError", generator = "Immutables")
@SuppressWarnings({"all"})
@ParametersAreNonnullByDefault
@javax.annotation.processing.Generated("org.immutables.processor.ProxyProcessor")
@Immutable
@CheckReturnValue
public final class Error extends BaseError {
  private final int code;
  private final String message;
  @SuppressWarnings("Immutable")
  private transient int hashCode; // hashCode lazily computed

  private Error(Error.Builder builder) {
    this.code = builder.code;
    this.message = builder.message;
  }

  /**
   * @return The value of the {@code code} attribute
   */
  @JsonProperty("code")
  @Override
  public int code() {
    return code;
  }

  /**
   * @return The value of the {@code message} attribute
   */
  @JsonProperty("message")
  @Override
  public String message() {
    return message;
  }

  /**
   * This instance is equal to all instances of {@code Error} that have equal attribute values.
   * @return {@code true} if {@code this} is equal to {@code another} instance
   */
  @Override
  public boolean equals(@Nullable Object another) {
    if (this == another) return true;
    return another instanceof Error
        && equalTo(0, (Error) another);
  }

  private boolean equalTo(int synthetic, Error another) {
    if (hashCode != 0 && another.hashCode != 0 && hashCode != another.hashCode) return false;
    return code == another.code
        && message.equals(another.message);
  }

  /**
   * Returns a lazily computed hash code from attributes: {@code code}, {@code message}.
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
    h += (h << 5) + code;
    h += (h << 5) + message.hashCode();
    return h;
  }

  /**
   * Prints the immutable value {@code Error} with attribute values.
   * @return A string representation of the value
   */
  @Override
  public String toString() {
    return MoreObjects.toStringHelper("Error")
        .omitNullValues()
        .add("code", code)
        .add("message", message)
        .toString();
  }

  /**
   * Utility type used to correctly read immutable object from JSON representation.
   * @deprecated Do not use this type directly, it exists only for the <em>Jackson</em>-binding infrastructure
   */
  @Generated(from = "BaseError", generator = "Immutables")
  @Deprecated
  @SuppressWarnings("Immutable")
  @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.NONE)
  static final class Json extends BaseError {
    int code;
    boolean codeIsSet;
    @Nullable String message;
    @JsonProperty("code")
    public void setCode(int code) {
      this.code = code;
      this.codeIsSet = true;
    }
    @JsonProperty("message")
    public void setMessage(String message) {
      this.message = message;
    }
    @Override
    public int code() { throw new UnsupportedOperationException(); }
    @Override
    public String message() { throw new UnsupportedOperationException(); }
  }

  /**
   * @param json A JSON-bindable data structure
   * @return An immutable value type
   * @deprecated Do not use this method directly, it exists only for the <em>Jackson</em>-binding infrastructure
   */
  @Deprecated
  @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
  static Error fromJson(Json json) {
    Error.Builder builder = Error.builder();
    if (json.codeIsSet) {
      builder.code(json.code);
    }
    if (json.message != null) {
      builder.message(json.message);
    }
    return builder.build();
  }

  /**
   * Creates a builder for {@link Error Error}.
   * <pre>
   * Error.builder()
   *    .code(int) // required {@link Error#code() code}
   *    .message(String) // required {@link Error#message() message}
   *    .build();
   * </pre>
   * @return A new Error builder
   */
  public static Error.Builder builder() {
    return new Error.Builder();
  }

  /**
   * Builds instances of type {@link Error Error}.
   * Initialize attributes and then invoke the {@link #build()} method to create an
   * immutable instance.
   * <p><em>{@code Builder} is not thread-safe and generally should not be stored in a field or collection,
   * but instead used immediately to create instances.</em>
   */
  @Generated(from = "BaseError", generator = "Immutables")
  @NotThreadSafe
  public static final class Builder {
    private static final long INIT_BIT_CODE = 0x1L;
    private static final long INIT_BIT_MESSAGE = 0x2L;
    private long initBits = 0x3L;

    private int code;
    private @Nullable String message;

    private Builder() {
    }

    /**
     * Initializes the value for the {@link Error#code() code} attribute.
     * @param code The value for code 
     * @return {@code this} builder for use in a chained invocation
     */
    @CanIgnoreReturnValue 
    public final Builder code(int code) {
      checkNotIsSet(codeIsSet(), "code");
      this.code = code;
      initBits &= ~INIT_BIT_CODE;
      return this;
    }

    /**
     * Initializes the value for the {@link Error#message() message} attribute.
     * @param message The value for message 
     * @return {@code this} builder for use in a chained invocation
     */
    @CanIgnoreReturnValue 
    public final Builder message(String message) {
      checkNotIsSet(messageIsSet(), "message");
      this.message = Objects.requireNonNull(message, "message");
      initBits &= ~INIT_BIT_MESSAGE;
      return this;
    }

    /**
     * Builds a new {@link Error Error}.
     * @return An immutable instance of Error
     * @throws java.lang.IllegalStateException if any required attributes are missing
     */
    public Error build() {
      checkRequiredAttributes();
      return new Error(this);
    }

    private boolean codeIsSet() {
      return (initBits & INIT_BIT_CODE) == 0;
    }

    private boolean messageIsSet() {
      return (initBits & INIT_BIT_MESSAGE) == 0;
    }

    private static void checkNotIsSet(boolean isSet, String name) {
      if (isSet) throw new IllegalStateException("Builder of Error is strict, attribute is already set: ".concat(name));
    }

    private void checkRequiredAttributes() {
      if (initBits != 0) {
        throw new IllegalStateException(formatRequiredAttributesMessage());
      }
    }

    private String formatRequiredAttributesMessage() {
      List<String> attributes = new ArrayList<>();
      if (!codeIsSet()) attributes.add("code");
      if (!messageIsSet()) attributes.add("message");
      return "Cannot build Error, some of required attributes are not set " + attributes;
    }
  }
}
