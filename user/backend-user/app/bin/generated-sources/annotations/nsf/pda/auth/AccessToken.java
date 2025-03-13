package nsf.pda.auth;

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
 * Immutable implementation of {@link BaseAccessToken}.
 * <p>
 * Use the builder to create immutable instances:
 * {@code AccessToken.builder()}.
 */
@Generated(from = "BaseAccessToken", generator = "Immutables")
@SuppressWarnings({"DefaultAnnotationParam", "all"})
@ParametersAreNonnullByDefault
@javax.annotation.processing.Generated("org.immutables.processor.ProxyProcessor")
@Immutable
@CheckReturnValue
public final class AccessToken implements BaseAccessToken {
  private final String value;
  private final String userId;

  private AccessToken(String value, String userId) {
    this.value = value;
    this.userId = userId;
  }

  /**
   * @return The value of the {@code value} attribute
   */
  @JsonProperty("accessToken")
  @Override
  public String value() {
    return value;
  }

  /**
   * @return The value of the {@code userId} attribute
   */
  @JsonProperty("userId")
  @Override
  public String userId() {
    return userId;
  }

  /**
   * Copy the current immutable object by setting a value for the {@link AccessToken#value() value} attribute.
   * An equals check used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for value
   * @return A modified copy of the {@code this} object
   */
  public final AccessToken withValue(String value) {
    String newValue = Objects.requireNonNull(value, "value");
    if (this.value.equals(newValue)) return this;
    return new AccessToken(newValue, this.userId);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link AccessToken#userId() userId} attribute.
   * An equals check used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for userId
   * @return A modified copy of the {@code this} object
   */
  public final AccessToken withUserId(String value) {
    String newValue = Objects.requireNonNull(value, "userId");
    if (this.userId.equals(newValue)) return this;
    return new AccessToken(this.value, newValue);
  }

  /**
   * This instance is equal to all instances of {@code AccessToken} that have equal attribute values.
   * @return {@code true} if {@code this} is equal to {@code another} instance
   */
  @Override
  public boolean equals(@Nullable Object another) {
    if (this == another) return true;
    return another instanceof AccessToken
        && equalTo(0, (AccessToken) another);
  }

  private boolean equalTo(int synthetic, AccessToken another) {
    return value.equals(another.value)
        && userId.equals(another.userId);
  }

  /**
   * Computes a hash code from attributes: {@code value}, {@code userId}.
   * @return hashCode value
   */
  @Override
  public int hashCode() {
    @Var int h = 5381;
    h += (h << 5) + value.hashCode();
    h += (h << 5) + userId.hashCode();
    return h;
  }

  /**
   * Prints the immutable value {@code AccessToken} with attribute values.
   * @return A string representation of the value
   */
  @Override
  public String toString() {
    return MoreObjects.toStringHelper("AccessToken")
        .omitNullValues()
        .add("userId", userId)
        .toString();
  }

  /**
   * Utility type used to correctly read immutable object from JSON representation.
   * @deprecated Do not use this type directly, it exists only for the <em>Jackson</em>-binding infrastructure
   */
  @Generated(from = "BaseAccessToken", generator = "Immutables")
  @Deprecated
  @SuppressWarnings("Immutable")
  @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.NONE)
  static final class Json implements BaseAccessToken {
    @Nullable String value;
    @Nullable String userId;
    @JsonProperty("accessToken")
    public void setValue(String value) {
      this.value = value;
    }
    @JsonProperty("userId")
    public void setUserId(String userId) {
      this.userId = userId;
    }
    @Override
    public String value() { throw new UnsupportedOperationException(); }
    @Override
    public String userId() { throw new UnsupportedOperationException(); }
  }

  /**
   * @param json A JSON-bindable data structure
   * @return An immutable value type
   * @deprecated Do not use this method directly, it exists only for the <em>Jackson</em>-binding infrastructure
   */
  @Deprecated
  @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
  static AccessToken fromJson(Json json) {
    AccessToken.Builder builder = AccessToken.builder();
    if (json.value != null) {
      builder.value(json.value);
    }
    if (json.userId != null) {
      builder.userId(json.userId);
    }
    return builder.build();
  }

  /**
   * Creates an immutable copy of a {@link BaseAccessToken} value.
   * Uses accessors to get values to initialize the new immutable instance.
   * If an instance is already immutable, it is returned as is.
   * @param instance The instance to copy
   * @return A copied immutable AccessToken instance
   */
  static AccessToken copyOf(BaseAccessToken instance) {
    if (instance instanceof AccessToken) {
      return (AccessToken) instance;
    }
    return AccessToken.builder()
        .value(instance.value())
        .userId(instance.userId())
        .build();
  }

  /**
   * Creates a builder for {@link AccessToken AccessToken}.
   * <pre>
   * AccessToken.builder()
   *    .value(String) // required {@link AccessToken#value() value}
   *    .userId(String) // required {@link AccessToken#userId() userId}
   *    .build();
   * </pre>
   * @return A new AccessToken builder
   */
  public static AccessToken.Builder builder() {
    return new AccessToken.Builder();
  }

  /**
   * Builds instances of type {@link AccessToken AccessToken}.
   * Initialize attributes and then invoke the {@link #build()} method to create an
   * immutable instance.
   * <p><em>{@code Builder} is not thread-safe and generally should not be stored in a field or collection,
   * but instead used immediately to create instances.</em>
   */
  @Generated(from = "BaseAccessToken", generator = "Immutables")
  @NotThreadSafe
  public static final class Builder {
    private static final long INIT_BIT_VALUE = 0x1L;
    private static final long INIT_BIT_USER_ID = 0x2L;
    private long initBits = 0x3L;

    private @Nullable String value;
    private @Nullable String userId;

    private Builder() {
    }

    /**
     * Initializes the value for the {@link AccessToken#value() value} attribute.
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
     * Initializes the value for the {@link AccessToken#userId() userId} attribute.
     * @param userId The value for userId 
     * @return {@code this} builder for use in a chained invocation
     */
    @CanIgnoreReturnValue 
    public final Builder userId(String userId) {
      checkNotIsSet(userIdIsSet(), "userId");
      this.userId = Objects.requireNonNull(userId, "userId");
      initBits &= ~INIT_BIT_USER_ID;
      return this;
    }

    /**
     * Builds a new {@link AccessToken AccessToken}.
     * @return An immutable instance of AccessToken
     * @throws java.lang.IllegalStateException if any required attributes are missing
     */
    public AccessToken build() {
      checkRequiredAttributes();
      return new AccessToken(value, userId);
    }

    private boolean valueIsSet() {
      return (initBits & INIT_BIT_VALUE) == 0;
    }

    private boolean userIdIsSet() {
      return (initBits & INIT_BIT_USER_ID) == 0;
    }

    private static void checkNotIsSet(boolean isSet, String name) {
      if (isSet) throw new IllegalStateException("Builder of AccessToken is strict, attribute is already set: ".concat(name));
    }

    private void checkRequiredAttributes() {
      if (initBits != 0) {
        throw new IllegalStateException(formatRequiredAttributesMessage());
      }
    }

    private String formatRequiredAttributesMessage() {
      List<String> attributes = new ArrayList<>();
      if (!valueIsSet()) attributes.add("value");
      if (!userIdIsSet()) attributes.add("userId");
      return "Cannot build AccessToken, some of required attributes are not set " + attributes;
    }
  }
}
