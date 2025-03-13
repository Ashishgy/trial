package nsf.controller;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.Var;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.CheckReturnValue;
import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;
import javax.annotation.concurrent.Immutable;
import javax.annotation.concurrent.NotThreadSafe;
import org.immutables.value.Generated;

/**
 * Immutable implementation of {@link BaseResponse}.
 * <p>
 * Use the builder to create immutable instances:
 * {@code Response.builder()}.
 */
@Generated(from = "BaseResponse", generator = "Immutables")
@SuppressWarnings({"all"})
@ParametersAreNonnullByDefault
@javax.annotation.processing.Generated("org.immutables.processor.ProxyProcessor")
@Immutable
@CheckReturnValue
public final class Response extends BaseResponse {
  private final @Nullable Data data;
  private final @Nullable Error error;
  @SuppressWarnings("Immutable")
  private transient int hashCode; // hashCode lazily computed

  private Response(Response.Builder builder) {
    this.data = builder.data;
    this.error = builder.error;
  }

  /**
   * @return The value of the {@code data} attribute
   */
  @JsonProperty("data")
  @Override
  public Optional<Data> data() {
    return Optional.ofNullable(data);
  }

  /**
   * @return The value of the {@code error} attribute
   */
  @JsonProperty("error")
  @Override
  public Optional<Error> error() {
    return Optional.ofNullable(error);
  }

  /**
   * This instance is equal to all instances of {@code Response} that have equal attribute values.
   * @return {@code true} if {@code this} is equal to {@code another} instance
   */
  @Override
  public boolean equals(@Nullable Object another) {
    if (this == another) return true;
    return another instanceof Response
        && equalTo(0, (Response) another);
  }

  private boolean equalTo(int synthetic, Response another) {
    if (hashCode != 0 && another.hashCode != 0 && hashCode != another.hashCode) return false;
    return Objects.equals(data, another.data)
        && Objects.equals(error, another.error);
  }

  /**
   * Returns a lazily computed hash code from attributes: {@code data}, {@code error}.
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
    h += (h << 5) + Objects.hashCode(data);
    h += (h << 5) + Objects.hashCode(error);
    return h;
  }

  /**
   * Prints the immutable value {@code Response} with attribute values.
   * @return A string representation of the value
   */
  @Override
  public String toString() {
    return MoreObjects.toStringHelper("Response")
        .omitNullValues()
        .add("data", data)
        .add("error", error)
        .toString();
  }

  /**
   * Utility type used to correctly read immutable object from JSON representation.
   * @deprecated Do not use this type directly, it exists only for the <em>Jackson</em>-binding infrastructure
   */
  @Generated(from = "BaseResponse", generator = "Immutables")
  @Deprecated
  @SuppressWarnings("Immutable")
  @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.NONE)
  static final class Json extends BaseResponse {
    @Nullable Optional<Data> data = Optional.empty();
    boolean dataIsSet;
    @Nullable Optional<Error> error = Optional.empty();
    boolean errorIsSet;
    @JsonProperty("data")
    public void setData(Optional<Data> data) {
      this.data = data;
      this.dataIsSet = true;
    }
    @JsonProperty("error")
    public void setError(Optional<Error> error) {
      this.error = error;
      this.errorIsSet = true;
    }
    @Override
    public Optional<Data> data() { throw new UnsupportedOperationException(); }
    @Override
    public Optional<Error> error() { throw new UnsupportedOperationException(); }
  }

  /**
   * @param json A JSON-bindable data structure
   * @return An immutable value type
   * @deprecated Do not use this method directly, it exists only for the <em>Jackson</em>-binding infrastructure
   */
  @Deprecated
  @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
  static Response fromJson(Json json) {
    Response.Builder builder = Response.builder();
    if (json.dataIsSet) {
      builder.data(json.data);
    }
    if (json.errorIsSet) {
      builder.error(json.error);
    }
    return builder.build();
  }

  private static Response validate(Response instance) {
    instance.check();
    return instance;
  }

  /**
   * Creates a builder for {@link Response Response}.
   * <pre>
   * Response.builder()
   *    .data(nsf.controller.Data) // optional {@link Response#data() data}
   *    .error(nsf.controller.Error) // optional {@link Response#error() error}
   *    .build();
   * </pre>
   * @return A new Response builder
   */
  public static Response.Builder builder() {
    return new Response.Builder();
  }

  /**
   * Builds instances of type {@link Response Response}.
   * Initialize attributes and then invoke the {@link #build()} method to create an
   * immutable instance.
   * <p><em>{@code Builder} is not thread-safe and generally should not be stored in a field or collection,
   * but instead used immediately to create instances.</em>
   */
  @Generated(from = "BaseResponse", generator = "Immutables")
  @NotThreadSafe
  public static final class Builder {
    private static final long OPT_BIT_DATA = 0x1L;
    private static final long OPT_BIT_ERROR = 0x2L;
    private long optBits;

    private @Nullable Data data;
    private @Nullable Error error;

    private Builder() {
    }

    /**
     * Initializes the optional value {@link Response#data() data} to data.
     * @param data The value for data
     * @return {@code this} builder for chained invocation
     */
    @CanIgnoreReturnValue 
    public final Builder data(Data data) {
      checkNotIsSet(dataIsSet(), "data");
      this.data = Objects.requireNonNull(data, "data");
      optBits |= OPT_BIT_DATA;
      return this;
    }

    /**
     * Initializes the optional value {@link Response#data() data} to data.
     * @param data The value for data
     * @return {@code this} builder for use in a chained invocation
     */
    @CanIgnoreReturnValue 
    public final Builder data(Optional<? extends Data> data) {
      checkNotIsSet(dataIsSet(), "data");
      this.data = data.orElse(null);
      optBits |= OPT_BIT_DATA;
      return this;
    }

    /**
     * Initializes the optional value {@link Response#error() error} to error.
     * @param error The value for error
     * @return {@code this} builder for chained invocation
     */
    @CanIgnoreReturnValue 
    public final Builder error(Error error) {
      checkNotIsSet(errorIsSet(), "error");
      this.error = Objects.requireNonNull(error, "error");
      optBits |= OPT_BIT_ERROR;
      return this;
    }

    /**
     * Initializes the optional value {@link Response#error() error} to error.
     * @param error The value for error
     * @return {@code this} builder for use in a chained invocation
     */
    @CanIgnoreReturnValue 
    public final Builder error(Optional<? extends Error> error) {
      checkNotIsSet(errorIsSet(), "error");
      this.error = error.orElse(null);
      optBits |= OPT_BIT_ERROR;
      return this;
    }

    /**
     * Builds a new {@link Response Response}.
     * @return An immutable instance of Response
     * @throws java.lang.IllegalStateException if any required attributes are missing
     */
    public Response build() {
      return Response.validate(new Response(this));
    }

    private boolean dataIsSet() {
      return (optBits & OPT_BIT_DATA) != 0;
    }

    private boolean errorIsSet() {
      return (optBits & OPT_BIT_ERROR) != 0;
    }

    private static void checkNotIsSet(boolean isSet, String name) {
      if (isSet) throw new IllegalStateException("Builder of Response is strict, attribute is already set: ".concat(name));
    }
  }
}
