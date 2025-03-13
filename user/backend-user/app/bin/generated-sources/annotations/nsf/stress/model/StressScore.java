package nsf.stress.model;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;
import com.google.common.primitives.Doubles;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.Var;
import java.time.Instant;
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
 * Immutable implementation of {@link BaseStressScore}.
 * <p>
 * Use the builder to create immutable instances:
 * {@code StressScore.builder()}.
 */
@Generated(from = "BaseStressScore", generator = "Immutables")
@SuppressWarnings({"all"})
@ParametersAreNonnullByDefault
@javax.annotation.processing.Generated("org.immutables.processor.ProxyProcessor")
@Immutable
@CheckReturnValue
public final class StressScore extends BaseStressScore {
  private final Instant timestamp;
  private final double value;
  @SuppressWarnings("Immutable")
  private transient int hashCode; // hashCode lazily computed

  private StressScore(StressScore.Builder builder) {
    this.timestamp = builder.timestamp;
    this.value = builder.value;
  }

  /**
   * @return The value of the {@code timestamp} attribute
   */
  @JsonProperty("timestamp")
  @Override
  public Instant timestamp() {
    return timestamp;
  }

  /**
   * @return The value of the {@code value} attribute
   */
  @JsonProperty("value")
  @Override
  public double value() {
    return value;
  }

  /**
   * This instance is equal to all instances of {@code StressScore} that have equal attribute values.
   * @return {@code true} if {@code this} is equal to {@code another} instance
   */
  @Override
  public boolean equals(@Nullable Object another) {
    if (this == another) return true;
    return another instanceof StressScore
        && equalTo(0, (StressScore) another);
  }

  private boolean equalTo(int synthetic, StressScore another) {
    if (hashCode != 0 && another.hashCode != 0 && hashCode != another.hashCode) return false;
    return timestamp.equals(another.timestamp)
        && Double.doubleToLongBits(value) == Double.doubleToLongBits(another.value);
  }

  /**
   * Returns a lazily computed hash code from attributes: {@code timestamp}, {@code value}.
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
    h += (h << 5) + timestamp.hashCode();
    h += (h << 5) + Doubles.hashCode(value);
    return h;
  }

  /**
   * Prints the immutable value {@code StressScore} with attribute values.
   * @return A string representation of the value
   */
  @Override
  public String toString() {
    return MoreObjects.toStringHelper("StressScore")
        .omitNullValues()
        .add("timestamp", timestamp)
        .add("value", value)
        .toString();
  }

  /**
   * Utility type used to correctly read immutable object from JSON representation.
   * @deprecated Do not use this type directly, it exists only for the <em>Jackson</em>-binding infrastructure
   */
  @Generated(from = "BaseStressScore", generator = "Immutables")
  @Deprecated
  @SuppressWarnings("Immutable")
  @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.NONE)
  static final class Json extends BaseStressScore {
    @Nullable Instant timestamp;
    double value;
    boolean valueIsSet;
    @JsonProperty("timestamp")
    public void setTimestamp(Instant timestamp) {
      this.timestamp = timestamp;
    }
    @JsonProperty("value")
    public void setValue(double value) {
      this.value = value;
      this.valueIsSet = true;
    }
    @Override
    public Instant timestamp() { throw new UnsupportedOperationException(); }
    @Override
    public double value() { throw new UnsupportedOperationException(); }
  }

  /**
   * @param json A JSON-bindable data structure
   * @return An immutable value type
   * @deprecated Do not use this method directly, it exists only for the <em>Jackson</em>-binding infrastructure
   */
  @Deprecated
  @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
  static StressScore fromJson(Json json) {
    StressScore.Builder builder = StressScore.builder();
    if (json.timestamp != null) {
      builder.timestamp(json.timestamp);
    }
    if (json.valueIsSet) {
      builder.value(json.value);
    }
    return builder.build();
  }

  private static StressScore validate(StressScore instance) {
    instance.check();
    return instance;
  }

  /**
   * Creates a builder for {@link StressScore StressScore}.
   * <pre>
   * StressScore.builder()
   *    .timestamp(java.time.Instant) // required {@link StressScore#timestamp() timestamp}
   *    .value(double) // required {@link StressScore#value() value}
   *    .build();
   * </pre>
   * @return A new StressScore builder
   */
  public static StressScore.Builder builder() {
    return new StressScore.Builder();
  }

  /**
   * Builds instances of type {@link StressScore StressScore}.
   * Initialize attributes and then invoke the {@link #build()} method to create an
   * immutable instance.
   * <p><em>{@code Builder} is not thread-safe and generally should not be stored in a field or collection,
   * but instead used immediately to create instances.</em>
   */
  @Generated(from = "BaseStressScore", generator = "Immutables")
  @NotThreadSafe
  public static final class Builder {
    private static final long INIT_BIT_TIMESTAMP = 0x1L;
    private static final long INIT_BIT_VALUE = 0x2L;
    private long initBits = 0x3L;

    private @Nullable Instant timestamp;
    private double value;

    private Builder() {
    }

    /**
     * Initializes the value for the {@link StressScore#timestamp() timestamp} attribute.
     * @param timestamp The value for timestamp 
     * @return {@code this} builder for use in a chained invocation
     */
    @CanIgnoreReturnValue 
    public final Builder timestamp(Instant timestamp) {
      checkNotIsSet(timestampIsSet(), "timestamp");
      this.timestamp = Objects.requireNonNull(timestamp, "timestamp");
      initBits &= ~INIT_BIT_TIMESTAMP;
      return this;
    }

    /**
     * Initializes the value for the {@link StressScore#value() value} attribute.
     * @param value The value for value 
     * @return {@code this} builder for use in a chained invocation
     */
    @CanIgnoreReturnValue 
    public final Builder value(double value) {
      checkNotIsSet(valueIsSet(), "value");
      this.value = value;
      initBits &= ~INIT_BIT_VALUE;
      return this;
    }

    /**
     * Builds a new {@link StressScore StressScore}.
     * @return An immutable instance of StressScore
     * @throws java.lang.IllegalStateException if any required attributes are missing
     */
    public StressScore build() {
      checkRequiredAttributes();
      return StressScore.validate(new StressScore(this));
    }

    private boolean timestampIsSet() {
      return (initBits & INIT_BIT_TIMESTAMP) == 0;
    }

    private boolean valueIsSet() {
      return (initBits & INIT_BIT_VALUE) == 0;
    }

    private static void checkNotIsSet(boolean isSet, String name) {
      if (isSet) throw new IllegalStateException("Builder of StressScore is strict, attribute is already set: ".concat(name));
    }

    private void checkRequiredAttributes() {
      if (initBits != 0) {
        throw new IllegalStateException(formatRequiredAttributesMessage());
      }
    }

    private String formatRequiredAttributesMessage() {
      List<String> attributes = new ArrayList<>();
      if (!timestampIsSet()) attributes.add("timestamp");
      if (!valueIsSet()) attributes.add("value");
      return "Cannot build StressScore, some of required attributes are not set " + attributes;
    }
  }
}
