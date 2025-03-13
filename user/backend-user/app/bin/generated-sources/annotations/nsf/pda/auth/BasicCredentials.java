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
 * Immutable implementation of {@link BaseBasicCredentials}.
 * <p>
 * Use the builder to create immutable instances:
 * {@code BasicCredentials.builder()}.
 * Use the static factory method to create immutable instances:
 * {@code BasicCredentials.of()}.
 */
@Generated(from = "BaseBasicCredentials", generator = "Immutables")
@SuppressWarnings({"all"})
@ParametersAreNonnullByDefault
@javax.annotation.processing.Generated("org.immutables.processor.ProxyProcessor")
@Immutable
@CheckReturnValue
public final class BasicCredentials implements BaseBasicCredentials {
  private final String username;
  private final String password;
  @SuppressWarnings("Immutable")
  private transient int hashCode; // hashCode lazily computed

  private BasicCredentials(String username, String password) {
    this.username = Objects.requireNonNull(username, "username");
    this.password = Objects.requireNonNull(password, "password");
  }

  private BasicCredentials(BasicCredentials.Builder builder) {
    this.username = builder.username;
    this.password = builder.password;
  }

  /**
   * @return The value of the {@code username} attribute
   */
  @JsonProperty("username")
  @Override
  public String username() {
    return username;
  }

  /**
   * @return The value of the {@code password} attribute
   */
  @JsonProperty("password")
  @Override
  public String password() {
    return password;
  }

  /**
   * This instance is equal to all instances of {@code BasicCredentials} that have equal attribute values.
   * @return {@code true} if {@code this} is equal to {@code another} instance
   */
  @Override
  public boolean equals(@Nullable Object another) {
    if (this == another) return true;
    return another instanceof BasicCredentials
        && equalTo(0, (BasicCredentials) another);
  }

  private boolean equalTo(int synthetic, BasicCredentials another) {
    if (hashCode != 0 && another.hashCode != 0 && hashCode != another.hashCode) return false;
    return username.equals(another.username)
        && password.equals(another.password);
  }

  /**
   * Returns a lazily computed hash code from attributes: {@code username}, {@code password}.
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
    h += (h << 5) + username.hashCode();
    h += (h << 5) + password.hashCode();
    return h;
  }

  /**
   * Prints the immutable value {@code BasicCredentials} with attribute values.
   * @return A string representation of the value
   */
  @Override
  public String toString() {
    return MoreObjects.toStringHelper("BasicCredentials")
        .omitNullValues()
        .add("username", username)
        .toString();
  }

  /**
   * Utility type used to correctly read immutable object from JSON representation.
   * @deprecated Do not use this type directly, it exists only for the <em>Jackson</em>-binding infrastructure
   */
  @Generated(from = "BaseBasicCredentials", generator = "Immutables")
  @Deprecated
  @SuppressWarnings("Immutable")
  @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.NONE)
  static final class Json implements BaseBasicCredentials {
    @Nullable String username;
    @Nullable String password;
    @JsonProperty("username")
    public void setUsername(String username) {
      this.username = username;
    }
    @JsonProperty("password")
    public void setPassword(String password) {
      this.password = password;
    }
    @Override
    public String username() { throw new UnsupportedOperationException(); }
    @Override
    public String password() { throw new UnsupportedOperationException(); }
  }

  /**
   * @param json A JSON-bindable data structure
   * @return An immutable value type
   * @deprecated Do not use this method directly, it exists only for the <em>Jackson</em>-binding infrastructure
   */
  @Deprecated
  @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
  static BasicCredentials fromJson(Json json) {
    BasicCredentials.Builder builder = BasicCredentials.builder();
    if (json.username != null) {
      builder.username(json.username);
    }
    if (json.password != null) {
      builder.password(json.password);
    }
    return builder.build();
  }

  /**
   * Construct a new immutable {@code BasicCredentials} instance.
   * @param username The value for the {@code username} attribute
   * @param password The value for the {@code password} attribute
   * @return An immutable BasicCredentials instance
   */
  public static BasicCredentials of(String username, String password) {
    return new BasicCredentials(username, password);
  }

  /**
   * Creates a builder for {@link BasicCredentials BasicCredentials}.
   * <pre>
   * BasicCredentials.builder()
   *    .username(String) // required {@link BasicCredentials#username() username}
   *    .password(String) // required {@link BasicCredentials#password() password}
   *    .build();
   * </pre>
   * @return A new BasicCredentials builder
   */
  public static BasicCredentials.Builder builder() {
    return new BasicCredentials.Builder();
  }

  /**
   * Builds instances of type {@link BasicCredentials BasicCredentials}.
   * Initialize attributes and then invoke the {@link #build()} method to create an
   * immutable instance.
   * <p><em>{@code Builder} is not thread-safe and generally should not be stored in a field or collection,
   * but instead used immediately to create instances.</em>
   */
  @Generated(from = "BaseBasicCredentials", generator = "Immutables")
  @NotThreadSafe
  public static final class Builder {
    private static final long INIT_BIT_USERNAME = 0x1L;
    private static final long INIT_BIT_PASSWORD = 0x2L;
    private long initBits = 0x3L;

    private @Nullable String username;
    private @Nullable String password;

    private Builder() {
    }

    /**
     * Initializes the value for the {@link BasicCredentials#username() username} attribute.
     * @param username The value for username 
     * @return {@code this} builder for use in a chained invocation
     */
    @CanIgnoreReturnValue 
    public final Builder username(String username) {
      checkNotIsSet(usernameIsSet(), "username");
      this.username = Objects.requireNonNull(username, "username");
      initBits &= ~INIT_BIT_USERNAME;
      return this;
    }

    /**
     * Initializes the value for the {@link BasicCredentials#password() password} attribute.
     * @param password The value for password 
     * @return {@code this} builder for use in a chained invocation
     */
    @CanIgnoreReturnValue 
    public final Builder password(String password) {
      checkNotIsSet(passwordIsSet(), "password");
      this.password = Objects.requireNonNull(password, "password");
      initBits &= ~INIT_BIT_PASSWORD;
      return this;
    }

    /**
     * Builds a new {@link BasicCredentials BasicCredentials}.
     * @return An immutable instance of BasicCredentials
     * @throws java.lang.IllegalStateException if any required attributes are missing
     */
    public BasicCredentials build() {
      checkRequiredAttributes();
      return new BasicCredentials(this);
    }

    private boolean usernameIsSet() {
      return (initBits & INIT_BIT_USERNAME) == 0;
    }

    private boolean passwordIsSet() {
      return (initBits & INIT_BIT_PASSWORD) == 0;
    }

    private static void checkNotIsSet(boolean isSet, String name) {
      if (isSet) throw new IllegalStateException("Builder of BasicCredentials is strict, attribute is already set: ".concat(name));
    }

    private void checkRequiredAttributes() {
      if (initBits != 0) {
        throw new IllegalStateException(formatRequiredAttributesMessage());
      }
    }

    private String formatRequiredAttributesMessage() {
      List<String> attributes = new ArrayList<>();
      if (!usernameIsSet()) attributes.add("username");
      if (!passwordIsSet()) attributes.add("password");
      return "Cannot build BasicCredentials, some of required attributes are not set " + attributes;
    }
  }
}
