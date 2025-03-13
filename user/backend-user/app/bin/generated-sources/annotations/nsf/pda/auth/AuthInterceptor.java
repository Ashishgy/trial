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
 * Immutable implementation of {@link BaseAuthInterceptor}.
 * <p>
 * Use the builder to create immutable instances:
 * {@code AuthInterceptor.builder()}.
 * Use the static factory method to create immutable instances:
 * {@code AuthInterceptor.of()}.
 */
@Generated(from = "BaseAuthInterceptor", generator = "Immutables")
@SuppressWarnings({"all"})
@ParametersAreNonnullByDefault
@javax.annotation.processing.Generated("org.immutables.processor.ProxyProcessor")
@Immutable
@CheckReturnValue
public final class AuthInterceptor extends BaseAuthInterceptor {
  private final TokenService tokenService;
  @SuppressWarnings("Immutable")
  private transient int hashCode; // hashCode lazily computed

  private AuthInterceptor(TokenService tokenService) {
    this.tokenService = Objects.requireNonNull(tokenService, "tokenService");
  }

  private AuthInterceptor(AuthInterceptor.Builder builder) {
    this.tokenService = builder.tokenService;
  }

  /**
   * @return The value of the {@code tokenService} attribute
   */
  @JsonProperty("tokenService")
  @Override
  public TokenService tokenService() {
    return tokenService;
  }

  /**
   * This instance is equal to all instances of {@code AuthInterceptor} that have equal attribute values.
   * @return {@code true} if {@code this} is equal to {@code another} instance
   */
  @Override
  public boolean equals(@Nullable Object another) {
    if (this == another) return true;
    return another instanceof AuthInterceptor
        && equalTo(0, (AuthInterceptor) another);
  }

  private boolean equalTo(int synthetic, AuthInterceptor another) {
    if (hashCode != 0 && another.hashCode != 0 && hashCode != another.hashCode) return false;
    return tokenService.equals(another.tokenService);
  }

  /**
   * Returns a lazily computed hash code from attributes: {@code tokenService}.
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
    h += (h << 5) + tokenService.hashCode();
    return h;
  }

  /**
   * Prints the immutable value {@code AuthInterceptor} with attribute values.
   * @return A string representation of the value
   */
  @Override
  public String toString() {
    return MoreObjects.toStringHelper("AuthInterceptor")
        .omitNullValues()
        .add("tokenService", tokenService)
        .toString();
  }

  /**
   * Utility type used to correctly read immutable object from JSON representation.
   * @deprecated Do not use this type directly, it exists only for the <em>Jackson</em>-binding infrastructure
   */
  @Generated(from = "BaseAuthInterceptor", generator = "Immutables")
  @Deprecated
  @SuppressWarnings("Immutable")
  @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.NONE)
  static final class Json extends BaseAuthInterceptor {
    @Nullable TokenService tokenService;
    @JsonProperty("tokenService")
    public void setTokenService(TokenService tokenService) {
      this.tokenService = tokenService;
    }
    @Override
    public TokenService tokenService() { throw new UnsupportedOperationException(); }
  }

  /**
   * @param json A JSON-bindable data structure
   * @return An immutable value type
   * @deprecated Do not use this method directly, it exists only for the <em>Jackson</em>-binding infrastructure
   */
  @Deprecated
  @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
  static AuthInterceptor fromJson(Json json) {
    AuthInterceptor.Builder builder = AuthInterceptor.builder();
    if (json.tokenService != null) {
      builder.tokenService(json.tokenService);
    }
    return builder.build();
  }

  /**
   * Construct a new immutable {@code AuthInterceptor} instance.
   * @param tokenService The value for the {@code tokenService} attribute
   * @return An immutable AuthInterceptor instance
   */
  public static AuthInterceptor of(TokenService tokenService) {
    return new AuthInterceptor(tokenService);
  }

  /**
   * Creates a builder for {@link AuthInterceptor AuthInterceptor}.
   * <pre>
   * AuthInterceptor.builder()
   *    .tokenService(nsf.pda.auth.TokenService) // required {@link AuthInterceptor#tokenService() tokenService}
   *    .build();
   * </pre>
   * @return A new AuthInterceptor builder
   */
  public static AuthInterceptor.Builder builder() {
    return new AuthInterceptor.Builder();
  }

  /**
   * Builds instances of type {@link AuthInterceptor AuthInterceptor}.
   * Initialize attributes and then invoke the {@link #build()} method to create an
   * immutable instance.
   * <p><em>{@code Builder} is not thread-safe and generally should not be stored in a field or collection,
   * but instead used immediately to create instances.</em>
   */
  @Generated(from = "BaseAuthInterceptor", generator = "Immutables")
  @NotThreadSafe
  public static final class Builder {
    private static final long INIT_BIT_TOKEN_SERVICE = 0x1L;
    private long initBits = 0x1L;

    private @Nullable TokenService tokenService;

    private Builder() {
    }

    /**
     * Initializes the value for the {@link AuthInterceptor#tokenService() tokenService} attribute.
     * @param tokenService The value for tokenService 
     * @return {@code this} builder for use in a chained invocation
     */
    @CanIgnoreReturnValue 
    public final Builder tokenService(TokenService tokenService) {
      checkNotIsSet(tokenServiceIsSet(), "tokenService");
      this.tokenService = Objects.requireNonNull(tokenService, "tokenService");
      initBits &= ~INIT_BIT_TOKEN_SERVICE;
      return this;
    }

    /**
     * Builds a new {@link AuthInterceptor AuthInterceptor}.
     * @return An immutable instance of AuthInterceptor
     * @throws java.lang.IllegalStateException if any required attributes are missing
     */
    public AuthInterceptor build() {
      checkRequiredAttributes();
      return new AuthInterceptor(this);
    }

    private boolean tokenServiceIsSet() {
      return (initBits & INIT_BIT_TOKEN_SERVICE) == 0;
    }

    private static void checkNotIsSet(boolean isSet, String name) {
      if (isSet) throw new IllegalStateException("Builder of AuthInterceptor is strict, attribute is already set: ".concat(name));
    }

    private void checkRequiredAttributes() {
      if (initBits != 0) {
        throw new IllegalStateException(formatRequiredAttributesMessage());
      }
    }

    private String formatRequiredAttributesMessage() {
      List<String> attributes = new ArrayList<>();
      if (!tokenServiceIsSet()) attributes.add("tokenService");
      return "Cannot build AuthInterceptor, some of required attributes are not set " + attributes;
    }
  }
}
