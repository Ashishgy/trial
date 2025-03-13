package nsf.pda.data;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.Var;
import java.util.Objects;
import java.util.Optional;
import java.util.OptionalInt;
import javax.annotation.CheckReturnValue;
import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;
import javax.annotation.concurrent.Immutable;
import javax.annotation.concurrent.NotThreadSafe;
import org.immutables.value.Generated;

/**
 * Immutable implementation of {@link BaseGetOptions}.
 * <p>
 * Use the builder to create immutable instances:
 * {@code GetOptions.builder()}.
 */
@Generated(from = "BaseGetOptions", generator = "Immutables")
@SuppressWarnings({"all"})
@ParametersAreNonnullByDefault
@javax.annotation.processing.Generated("org.immutables.processor.ProxyProcessor")
@Immutable
@CheckReturnValue
public final class GetOptions extends BaseGetOptions {
  private final @Nullable String orderBy;
  private final @Nullable Ordering ordering;
  private final @Nullable Integer take;
  private final @Nullable Integer skip;
  @SuppressWarnings("Immutable")
  private transient int hashCode; // hashCode lazily computed

  private GetOptions(GetOptions.Builder builder) {
    this.orderBy = builder.orderBy;
    this.ordering = builder.ordering;
    this.take = builder.take;
    this.skip = builder.skip;
  }

  /**
   * @return The value of the {@code orderBy} attribute
   */
  @JsonProperty("orderBy")
  @Override
  public Optional<String> orderBy() {
    return Optional.ofNullable(orderBy);
  }

  /**
   * @return The value of the {@code ordering} attribute
   */
  @JsonProperty("ordering")
  @Override
  public Optional<Ordering> ordering() {
    return Optional.ofNullable(ordering);
  }

  /**
   * @return The value of the {@code take} attribute
   */
  @JsonProperty("take")
  @Override
  public OptionalInt take() {
    return take != null
        ? OptionalInt.of(take)
        : OptionalInt.empty();
  }

  /**
   * @return The value of the {@code skip} attribute
   */
  @JsonProperty("skip")
  @Override
  public OptionalInt skip() {
    return skip != null
        ? OptionalInt.of(skip)
        : OptionalInt.empty();
  }

  /**
   * This instance is equal to all instances of {@code GetOptions} that have equal attribute values.
   * @return {@code true} if {@code this} is equal to {@code another} instance
   */
  @Override
  public boolean equals(@Nullable Object another) {
    if (this == another) return true;
    return another instanceof GetOptions
        && equalTo(0, (GetOptions) another);
  }

  private boolean equalTo(int synthetic, GetOptions another) {
    if (hashCode != 0 && another.hashCode != 0 && hashCode != another.hashCode) return false;
    return Objects.equals(orderBy, another.orderBy)
        && Objects.equals(ordering, another.ordering)
        && Objects.equals(take, another.take)
        && Objects.equals(skip, another.skip);
  }

  /**
   * Returns a lazily computed hash code from attributes: {@code orderBy}, {@code ordering}, {@code take}, {@code skip}.
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
    h += (h << 5) + Objects.hashCode(orderBy);
    h += (h << 5) + Objects.hashCode(ordering);
    h += (h << 5) + Objects.hashCode(take);
    h += (h << 5) + Objects.hashCode(skip);
    return h;
  }

  /**
   * Prints the immutable value {@code GetOptions} with attribute values.
   * @return A string representation of the value
   */
  @Override
  public String toString() {
    return MoreObjects.toStringHelper("GetOptions")
        .omitNullValues()
        .add("orderBy", orderBy)
        .add("ordering", ordering)
        .add("take", take)
        .add("skip", skip)
        .toString();
  }

  /**
   * Utility type used to correctly read immutable object from JSON representation.
   * @deprecated Do not use this type directly, it exists only for the <em>Jackson</em>-binding infrastructure
   */
  @Generated(from = "BaseGetOptions", generator = "Immutables")
  @Deprecated
  @SuppressWarnings("Immutable")
  @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.NONE)
  static final class Json extends BaseGetOptions {
    @Nullable Optional<String> orderBy = Optional.empty();
    boolean orderByIsSet;
    @Nullable Optional<Ordering> ordering = Optional.empty();
    boolean orderingIsSet;
    @Nullable OptionalInt take = OptionalInt.empty();
    boolean takeIsSet;
    @Nullable OptionalInt skip = OptionalInt.empty();
    boolean skipIsSet;
    @JsonProperty("orderBy")
    public void setOrderBy(Optional<String> orderBy) {
      this.orderBy = orderBy;
      this.orderByIsSet = true;
    }
    @JsonProperty("ordering")
    public void setOrdering(Optional<Ordering> ordering) {
      this.ordering = ordering;
      this.orderingIsSet = true;
    }
    @JsonProperty("take")
    public void setTake(OptionalInt take) {
      this.take = take;
      this.takeIsSet = true;
    }
    @JsonProperty("skip")
    public void setSkip(OptionalInt skip) {
      this.skip = skip;
      this.skipIsSet = true;
    }
    @Override
    public Optional<String> orderBy() { throw new UnsupportedOperationException(); }
    @Override
    public Optional<Ordering> ordering() { throw new UnsupportedOperationException(); }
    @Override
    public OptionalInt take() { throw new UnsupportedOperationException(); }
    @Override
    public OptionalInt skip() { throw new UnsupportedOperationException(); }
  }

  /**
   * @param json A JSON-bindable data structure
   * @return An immutable value type
   * @deprecated Do not use this method directly, it exists only for the <em>Jackson</em>-binding infrastructure
   */
  @Deprecated
  @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
  static GetOptions fromJson(Json json) {
    GetOptions.Builder builder = GetOptions.builder();
    if (json.orderByIsSet) {
      builder.orderBy(json.orderBy);
    }
    if (json.orderingIsSet) {
      builder.ordering(json.ordering);
    }
    if (json.takeIsSet) {
      builder.take(json.take);
    }
    if (json.skipIsSet) {
      builder.skip(json.skip);
    }
    return builder.build();
  }

  private static GetOptions validate(GetOptions instance) {
    instance.check();
    return instance;
  }

  /**
   * Creates a builder for {@link GetOptions GetOptions}.
   * <pre>
   * GetOptions.builder()
   *    .orderBy(String) // optional {@link GetOptions#orderBy() orderBy}
   *    .ordering(nsf.pda.data.Ordering) // optional {@link GetOptions#ordering() ordering}
   *    .take(int) // optional {@link GetOptions#take() take}
   *    .skip(int) // optional {@link GetOptions#skip() skip}
   *    .build();
   * </pre>
   * @return A new GetOptions builder
   */
  public static GetOptions.Builder builder() {
    return new GetOptions.Builder();
  }

  /**
   * Builds instances of type {@link GetOptions GetOptions}.
   * Initialize attributes and then invoke the {@link #build()} method to create an
   * immutable instance.
   * <p><em>{@code Builder} is not thread-safe and generally should not be stored in a field or collection,
   * but instead used immediately to create instances.</em>
   */
  @Generated(from = "BaseGetOptions", generator = "Immutables")
  @NotThreadSafe
  public static final class Builder {
    private static final long OPT_BIT_ORDER_BY = 0x1L;
    private static final long OPT_BIT_ORDERING = 0x2L;
    private static final long OPT_BIT_TAKE = 0x4L;
    private static final long OPT_BIT_SKIP = 0x8L;
    private long optBits;

    private @Nullable String orderBy;
    private @Nullable Ordering ordering;
    private @Nullable Integer take;
    private @Nullable Integer skip;

    private Builder() {
    }

    /**
     * Initializes the optional value {@link GetOptions#orderBy() orderBy} to orderBy.
     * @param orderBy The value for orderBy
     * @return {@code this} builder for chained invocation
     */
    @CanIgnoreReturnValue 
    public final Builder orderBy(String orderBy) {
      checkNotIsSet(orderByIsSet(), "orderBy");
      this.orderBy = Objects.requireNonNull(orderBy, "orderBy");
      optBits |= OPT_BIT_ORDER_BY;
      return this;
    }

    /**
     * Initializes the optional value {@link GetOptions#orderBy() orderBy} to orderBy.
     * @param orderBy The value for orderBy
     * @return {@code this} builder for use in a chained invocation
     */
    @CanIgnoreReturnValue 
    public final Builder orderBy(Optional<String> orderBy) {
      checkNotIsSet(orderByIsSet(), "orderBy");
      this.orderBy = orderBy.orElse(null);
      optBits |= OPT_BIT_ORDER_BY;
      return this;
    }

    /**
     * Initializes the optional value {@link GetOptions#ordering() ordering} to ordering.
     * @param ordering The value for ordering
     * @return {@code this} builder for chained invocation
     */
    @CanIgnoreReturnValue 
    public final Builder ordering(Ordering ordering) {
      checkNotIsSet(orderingIsSet(), "ordering");
      this.ordering = Objects.requireNonNull(ordering, "ordering");
      optBits |= OPT_BIT_ORDERING;
      return this;
    }

    /**
     * Initializes the optional value {@link GetOptions#ordering() ordering} to ordering.
     * @param ordering The value for ordering
     * @return {@code this} builder for use in a chained invocation
     */
    @CanIgnoreReturnValue 
    public final Builder ordering(Optional<? extends Ordering> ordering) {
      checkNotIsSet(orderingIsSet(), "ordering");
      this.ordering = ordering.orElse(null);
      optBits |= OPT_BIT_ORDERING;
      return this;
    }

    /**
     * Initializes the optional value {@link GetOptions#take() take} to take.
     * @param take The value for take
     * @return {@code this} builder for chained invocation
     */
    @CanIgnoreReturnValue 
    public final Builder take(int take) {
      checkNotIsSet(takeIsSet(), "take");
      this.take = take;
      optBits |= OPT_BIT_TAKE;
      return this;
    }

    /**
     * Initializes the optional value {@link GetOptions#take() take} to take.
     * @param take The value for take
     * @return {@code this} builder for use in a chained invocation
     */
    @CanIgnoreReturnValue 
    public final Builder take(OptionalInt take) {
      checkNotIsSet(takeIsSet(), "take");
      this.take = take.isPresent() ? take.getAsInt() : null;
      optBits |= OPT_BIT_TAKE;
      return this;
    }

    /**
     * Initializes the optional value {@link GetOptions#skip() skip} to skip.
     * @param skip The value for skip
     * @return {@code this} builder for chained invocation
     */
    @CanIgnoreReturnValue 
    public final Builder skip(int skip) {
      checkNotIsSet(skipIsSet(), "skip");
      this.skip = skip;
      optBits |= OPT_BIT_SKIP;
      return this;
    }

    /**
     * Initializes the optional value {@link GetOptions#skip() skip} to skip.
     * @param skip The value for skip
     * @return {@code this} builder for use in a chained invocation
     */
    @CanIgnoreReturnValue 
    public final Builder skip(OptionalInt skip) {
      checkNotIsSet(skipIsSet(), "skip");
      this.skip = skip.isPresent() ? skip.getAsInt() : null;
      optBits |= OPT_BIT_SKIP;
      return this;
    }

    /**
     * Builds a new {@link GetOptions GetOptions}.
     * @return An immutable instance of GetOptions
     * @throws java.lang.IllegalStateException if any required attributes are missing
     */
    public GetOptions build() {
      return GetOptions.validate(new GetOptions(this));
    }

    private boolean orderByIsSet() {
      return (optBits & OPT_BIT_ORDER_BY) != 0;
    }

    private boolean orderingIsSet() {
      return (optBits & OPT_BIT_ORDERING) != 0;
    }

    private boolean takeIsSet() {
      return (optBits & OPT_BIT_TAKE) != 0;
    }

    private boolean skipIsSet() {
      return (optBits & OPT_BIT_SKIP) != 0;
    }

    private static void checkNotIsSet(boolean isSet, String name) {
      if (isSet) throw new IllegalStateException("Builder of GetOptions is strict, attribute is already set: ".concat(name));
    }
  }
}
