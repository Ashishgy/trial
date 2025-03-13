package nsf.stress.model;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;
import com.google.common.primitives.Doubles;
import com.google.common.primitives.Longs;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.Var;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.NavigableMap;
import java.util.Objects;
import javax.annotation.CheckReturnValue;
import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;
import javax.annotation.concurrent.Immutable;
import javax.annotation.concurrent.NotThreadSafe;
import org.immutables.value.Generated;

/**
 * Immutable implementation of {@link BaseHealthRecord}.
 * <p>
 * Use the builder to create immutable instances:
 * {@code HealthRecord.builder()}.
 */
@Generated(from = "BaseHealthRecord", generator = "Immutables")
@SuppressWarnings({"all"})
@ParametersAreNonnullByDefault
@javax.annotation.processing.Generated("org.immutables.processor.ProxyProcessor")
@Immutable
@CheckReturnValue
public final class HealthRecord extends BaseHealthRecord {
  private final Duration activeDuration;
  private final double averageSpeedInKilometersPerHour;
  private final double expenditureInKilocalories;
  private final NavigableMap<Instant, Integer> heartRatesInBeatsPerMinute;
  private final Duration sleepDuration;
  private final long stepCount;
  private transient final double averageHeartRate;
  private transient final double averageHeartRateReserve;
  private transient final int maxHeartRateInBeatsPerMinute;
  @SuppressWarnings("Immutable")
  private transient int hashCode; // hashCode lazily computed

  private HealthRecord(HealthRecord.Builder builder) {
    this.activeDuration = builder.activeDuration;
    this.averageSpeedInKilometersPerHour = builder.averageSpeedInKilometersPerHour;
    this.expenditureInKilocalories = builder.expenditureInKilocalories;
    this.heartRatesInBeatsPerMinute = builder.heartRatesInBeatsPerMinute;
    this.sleepDuration = builder.sleepDuration;
    this.stepCount = builder.stepCount;
    this.averageHeartRate = initShim.averageHeartRate();
    this.averageHeartRateReserve = initShim.averageHeartRateReserve();
    this.maxHeartRateInBeatsPerMinute = initShim.maxHeartRateInBeatsPerMinute();
    this.initShim = null;
  }

  private static final byte STAGE_INITIALIZING = -1;
  private static final byte STAGE_UNINITIALIZED = 0;
  private static final byte STAGE_INITIALIZED = 1;
  @SuppressWarnings("Immutable")
  private transient volatile InitShim initShim = new InitShim();

  @Generated(from = "BaseHealthRecord", generator = "Immutables")
  private final class InitShim {
    private byte averageHeartRateBuildStage = STAGE_UNINITIALIZED;
    private double averageHeartRate;

    double averageHeartRate() {
      if (averageHeartRateBuildStage == STAGE_INITIALIZING) throw new IllegalStateException(formatInitCycleMessage());
      if (averageHeartRateBuildStage == STAGE_UNINITIALIZED) {
        averageHeartRateBuildStage = STAGE_INITIALIZING;
        this.averageHeartRate = HealthRecord.super.averageHeartRate();
        averageHeartRateBuildStage = STAGE_INITIALIZED;
      }
      return this.averageHeartRate;
    }

    private byte averageHeartRateReserveBuildStage = STAGE_UNINITIALIZED;
    private double averageHeartRateReserve;

    double averageHeartRateReserve() {
      if (averageHeartRateReserveBuildStage == STAGE_INITIALIZING) throw new IllegalStateException(formatInitCycleMessage());
      if (averageHeartRateReserveBuildStage == STAGE_UNINITIALIZED) {
        averageHeartRateReserveBuildStage = STAGE_INITIALIZING;
        this.averageHeartRateReserve = HealthRecord.super.averageHeartRateReserve();
        averageHeartRateReserveBuildStage = STAGE_INITIALIZED;
      }
      return this.averageHeartRateReserve;
    }

    private byte maxHeartRateInBeatsPerMinuteBuildStage = STAGE_UNINITIALIZED;
    private int maxHeartRateInBeatsPerMinute;

    int maxHeartRateInBeatsPerMinute() {
      if (maxHeartRateInBeatsPerMinuteBuildStage == STAGE_INITIALIZING) throw new IllegalStateException(formatInitCycleMessage());
      if (maxHeartRateInBeatsPerMinuteBuildStage == STAGE_UNINITIALIZED) {
        maxHeartRateInBeatsPerMinuteBuildStage = STAGE_INITIALIZING;
        this.maxHeartRateInBeatsPerMinute = HealthRecord.super.maxHeartRateInBeatsPerMinute();
        maxHeartRateInBeatsPerMinuteBuildStage = STAGE_INITIALIZED;
      }
      return this.maxHeartRateInBeatsPerMinute;
    }

    private String formatInitCycleMessage() {
      List<String> attributes = new ArrayList<>();
      if (averageHeartRateBuildStage == STAGE_INITIALIZING) attributes.add("averageHeartRate");
      if (averageHeartRateReserveBuildStage == STAGE_INITIALIZING) attributes.add("averageHeartRateReserve");
      if (maxHeartRateInBeatsPerMinuteBuildStage == STAGE_INITIALIZING) attributes.add("maxHeartRateInBeatsPerMinute");
      return "Cannot build HealthRecord, attribute initializers form cycle " + attributes;
    }
  }

  /**
   * @return The value of the {@code activeDuration} attribute
   */
  @JsonProperty("activeDuration")
  @Override
  public Duration activeDuration() {
    return activeDuration;
  }

  /**
   * @return The value of the {@code averageSpeedInKilometersPerHour} attribute
   */
  @JsonProperty("averageSpeedInKilometersPerHour")
  @Override
  public double averageSpeedInKilometersPerHour() {
    return averageSpeedInKilometersPerHour;
  }

  /**
   * @return The value of the {@code expenditureInKilocalories} attribute
   */
  @JsonProperty("expenditureInKilocalories")
  @Override
  public double expenditureInKilocalories() {
    return expenditureInKilocalories;
  }

  /**
   * @return The value of the {@code heartRatesInBeatsPerMinute} attribute
   */
  @JsonProperty("heartRatesInBeatsPerMinute")
  @Override
  public NavigableMap<Instant, Integer> heartRatesInBeatsPerMinute() {
    return heartRatesInBeatsPerMinute;
  }

  /**
   * @return The value of the {@code sleepDuration} attribute
   */
  @JsonProperty("sleepDuration")
  @Override
  public Duration sleepDuration() {
    return sleepDuration;
  }

  /**
   * @return The value of the {@code stepCount} attribute
   */
  @JsonProperty("stepCount")
  @Override
  public long stepCount() {
    return stepCount;
  }

  /**
   * @return The computed-at-construction value of the {@code averageHeartRate} attribute
   */
  @JsonProperty("averageHeartRate")
  @Override
  public double averageHeartRate() {
    InitShim shim = this.initShim;
    return shim != null
        ? shim.averageHeartRate()
        : this.averageHeartRate;
  }

  /**
   * @return The computed-at-construction value of the {@code averageHeartRateReserve} attribute
   */
  @JsonProperty("averageHeartRateReserve")
  @Override
  public double averageHeartRateReserve() {
    InitShim shim = this.initShim;
    return shim != null
        ? shim.averageHeartRateReserve()
        : this.averageHeartRateReserve;
  }

  /**
   * @return The computed-at-construction value of the {@code maxHeartRateInBeatsPerMinute} attribute
   */
  @JsonProperty("maxHeartRateInBeatsPerMinute")
  @Override
  public int maxHeartRateInBeatsPerMinute() {
    InitShim shim = this.initShim;
    return shim != null
        ? shim.maxHeartRateInBeatsPerMinute()
        : this.maxHeartRateInBeatsPerMinute;
  }

  /**
   * This instance is equal to all instances of {@code HealthRecord} that have equal attribute values.
   * @return {@code true} if {@code this} is equal to {@code another} instance
   */
  @Override
  public boolean equals(@Nullable Object another) {
    if (this == another) return true;
    return another instanceof HealthRecord
        && equalTo(0, (HealthRecord) another);
  }

  private boolean equalTo(int synthetic, HealthRecord another) {
    if (hashCode != 0 && another.hashCode != 0 && hashCode != another.hashCode) return false;
    return activeDuration.equals(another.activeDuration)
        && Double.doubleToLongBits(averageSpeedInKilometersPerHour) == Double.doubleToLongBits(another.averageSpeedInKilometersPerHour)
        && Double.doubleToLongBits(expenditureInKilocalories) == Double.doubleToLongBits(another.expenditureInKilocalories)
        && heartRatesInBeatsPerMinute.equals(another.heartRatesInBeatsPerMinute)
        && sleepDuration.equals(another.sleepDuration)
        && stepCount == another.stepCount
        && Double.doubleToLongBits(averageHeartRate) == Double.doubleToLongBits(another.averageHeartRate)
        && Double.doubleToLongBits(averageHeartRateReserve) == Double.doubleToLongBits(another.averageHeartRateReserve)
        && maxHeartRateInBeatsPerMinute == another.maxHeartRateInBeatsPerMinute;
  }

  /**
   * Returns a lazily computed hash code from attributes: {@code activeDuration}, {@code averageSpeedInKilometersPerHour}, {@code expenditureInKilocalories}, {@code heartRatesInBeatsPerMinute}, {@code sleepDuration}, {@code stepCount}, {@code averageHeartRate}, {@code averageHeartRateReserve}, {@code maxHeartRateInBeatsPerMinute}.
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
    h += (h << 5) + activeDuration.hashCode();
    h += (h << 5) + Doubles.hashCode(averageSpeedInKilometersPerHour);
    h += (h << 5) + Doubles.hashCode(expenditureInKilocalories);
    h += (h << 5) + heartRatesInBeatsPerMinute.hashCode();
    h += (h << 5) + sleepDuration.hashCode();
    h += (h << 5) + Longs.hashCode(stepCount);
    h += (h << 5) + Doubles.hashCode(averageHeartRate);
    h += (h << 5) + Doubles.hashCode(averageHeartRateReserve);
    h += (h << 5) + maxHeartRateInBeatsPerMinute;
    return h;
  }

  /**
   * Prints the immutable value {@code HealthRecord} with attribute values.
   * @return A string representation of the value
   */
  @Override
  public String toString() {
    return MoreObjects.toStringHelper("HealthRecord")
        .omitNullValues()
        .add("activeDuration", activeDuration)
        .add("averageSpeedInKilometersPerHour", averageSpeedInKilometersPerHour)
        .add("expenditureInKilocalories", expenditureInKilocalories)
        .add("heartRatesInBeatsPerMinute", heartRatesInBeatsPerMinute)
        .add("sleepDuration", sleepDuration)
        .add("stepCount", stepCount)
        .add("averageHeartRate", averageHeartRate)
        .add("averageHeartRateReserve", averageHeartRateReserve)
        .add("maxHeartRateInBeatsPerMinute", maxHeartRateInBeatsPerMinute)
        .toString();
  }

  /**
   * Utility type used to correctly read immutable object from JSON representation.
   * @deprecated Do not use this type directly, it exists only for the <em>Jackson</em>-binding infrastructure
   */
  @Generated(from = "BaseHealthRecord", generator = "Immutables")
  @Deprecated
  @SuppressWarnings("Immutable")
  @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.NONE)
  static final class Json extends BaseHealthRecord {
    @Nullable Duration activeDuration;
    double averageSpeedInKilometersPerHour;
    boolean averageSpeedInKilometersPerHourIsSet;
    double expenditureInKilocalories;
    boolean expenditureInKilocaloriesIsSet;
    @Nullable NavigableMap<Instant, Integer> heartRatesInBeatsPerMinute;
    @Nullable Duration sleepDuration;
    long stepCount;
    boolean stepCountIsSet;
    @JsonProperty("activeDuration")
    public void setActiveDuration(Duration activeDuration) {
      this.activeDuration = activeDuration;
    }
    @JsonProperty("averageSpeedInKilometersPerHour")
    public void setAverageSpeedInKilometersPerHour(double averageSpeedInKilometersPerHour) {
      this.averageSpeedInKilometersPerHour = averageSpeedInKilometersPerHour;
      this.averageSpeedInKilometersPerHourIsSet = true;
    }
    @JsonProperty("expenditureInKilocalories")
    public void setExpenditureInKilocalories(double expenditureInKilocalories) {
      this.expenditureInKilocalories = expenditureInKilocalories;
      this.expenditureInKilocaloriesIsSet = true;
    }
    @JsonProperty("heartRatesInBeatsPerMinute")
    public void setHeartRatesInBeatsPerMinute(NavigableMap<Instant, Integer> heartRatesInBeatsPerMinute) {
      this.heartRatesInBeatsPerMinute = heartRatesInBeatsPerMinute;
    }
    @JsonProperty("sleepDuration")
    public void setSleepDuration(Duration sleepDuration) {
      this.sleepDuration = sleepDuration;
    }
    @JsonProperty("stepCount")
    public void setStepCount(long stepCount) {
      this.stepCount = stepCount;
      this.stepCountIsSet = true;
    }
    @Override
    public Duration activeDuration() { throw new UnsupportedOperationException(); }
    @Override
    public double averageSpeedInKilometersPerHour() { throw new UnsupportedOperationException(); }
    @Override
    public double expenditureInKilocalories() { throw new UnsupportedOperationException(); }
    @Override
    public NavigableMap<Instant, Integer> heartRatesInBeatsPerMinute() { throw new UnsupportedOperationException(); }
    @Override
    public Duration sleepDuration() { throw new UnsupportedOperationException(); }
    @Override
    public long stepCount() { throw new UnsupportedOperationException(); }
    @JsonIgnore
    @Override
    public double averageHeartRate() { throw new UnsupportedOperationException(); }
    @JsonIgnore
    @Override
    public double averageHeartRateReserve() { throw new UnsupportedOperationException(); }
    @JsonIgnore
    @Override
    public int maxHeartRateInBeatsPerMinute() { throw new UnsupportedOperationException(); }
  }

  /**
   * @param json A JSON-bindable data structure
   * @return An immutable value type
   * @deprecated Do not use this method directly, it exists only for the <em>Jackson</em>-binding infrastructure
   */
  @Deprecated
  @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
  static HealthRecord fromJson(Json json) {
    HealthRecord.Builder builder = HealthRecord.builder();
    if (json.activeDuration != null) {
      builder.activeDuration(json.activeDuration);
    }
    if (json.averageSpeedInKilometersPerHourIsSet) {
      builder.averageSpeedInKilometersPerHour(json.averageSpeedInKilometersPerHour);
    }
    if (json.expenditureInKilocaloriesIsSet) {
      builder.expenditureInKilocalories(json.expenditureInKilocalories);
    }
    if (json.heartRatesInBeatsPerMinute != null) {
      builder.heartRatesInBeatsPerMinute(json.heartRatesInBeatsPerMinute);
    }
    if (json.sleepDuration != null) {
      builder.sleepDuration(json.sleepDuration);
    }
    if (json.stepCountIsSet) {
      builder.stepCount(json.stepCount);
    }
    return builder.build();
  }

  private static HealthRecord validate(HealthRecord instance) {
    instance.check();
    return instance;
  }

  /**
   * Creates a builder for {@link HealthRecord HealthRecord}.
   * <pre>
   * HealthRecord.builder()
   *    .activeDuration(java.time.Duration) // required {@link HealthRecord#activeDuration() activeDuration}
   *    .averageSpeedInKilometersPerHour(double) // required {@link HealthRecord#averageSpeedInKilometersPerHour() averageSpeedInKilometersPerHour}
   *    .expenditureInKilocalories(double) // required {@link HealthRecord#expenditureInKilocalories() expenditureInKilocalories}
   *    .heartRatesInBeatsPerMinute(NavigableMap&amp;lt;java.time.Instant, Integer&amp;gt;) // required {@link HealthRecord#heartRatesInBeatsPerMinute() heartRatesInBeatsPerMinute}
   *    .sleepDuration(java.time.Duration) // required {@link HealthRecord#sleepDuration() sleepDuration}
   *    .stepCount(long) // required {@link HealthRecord#stepCount() stepCount}
   *    .build();
   * </pre>
   * @return A new HealthRecord builder
   */
  public static HealthRecord.Builder builder() {
    return new HealthRecord.Builder();
  }

  /**
   * Builds instances of type {@link HealthRecord HealthRecord}.
   * Initialize attributes and then invoke the {@link #build()} method to create an
   * immutable instance.
   * <p><em>{@code Builder} is not thread-safe and generally should not be stored in a field or collection,
   * but instead used immediately to create instances.</em>
   */
  @Generated(from = "BaseHealthRecord", generator = "Immutables")
  @NotThreadSafe
  public static final class Builder {
    private static final long INIT_BIT_ACTIVE_DURATION = 0x1L;
    private static final long INIT_BIT_AVERAGE_SPEED_IN_KILOMETERS_PER_HOUR = 0x2L;
    private static final long INIT_BIT_EXPENDITURE_IN_KILOCALORIES = 0x4L;
    private static final long INIT_BIT_HEART_RATES_IN_BEATS_PER_MINUTE = 0x8L;
    private static final long INIT_BIT_SLEEP_DURATION = 0x10L;
    private static final long INIT_BIT_STEP_COUNT = 0x20L;
    private long initBits = 0x3fL;

    private @Nullable Duration activeDuration;
    private double averageSpeedInKilometersPerHour;
    private double expenditureInKilocalories;
    private @Nullable NavigableMap<Instant, Integer> heartRatesInBeatsPerMinute;
    private @Nullable Duration sleepDuration;
    private long stepCount;

    private Builder() {
    }

    /**
     * Initializes the value for the {@link HealthRecord#activeDuration() activeDuration} attribute.
     * @param activeDuration The value for activeDuration 
     * @return {@code this} builder for use in a chained invocation
     */
    @CanIgnoreReturnValue 
    public final Builder activeDuration(Duration activeDuration) {
      checkNotIsSet(activeDurationIsSet(), "activeDuration");
      this.activeDuration = Objects.requireNonNull(activeDuration, "activeDuration");
      initBits &= ~INIT_BIT_ACTIVE_DURATION;
      return this;
    }

    /**
     * Initializes the value for the {@link HealthRecord#averageSpeedInKilometersPerHour() averageSpeedInKilometersPerHour} attribute.
     * @param averageSpeedInKilometersPerHour The value for averageSpeedInKilometersPerHour 
     * @return {@code this} builder for use in a chained invocation
     */
    @CanIgnoreReturnValue 
    public final Builder averageSpeedInKilometersPerHour(double averageSpeedInKilometersPerHour) {
      checkNotIsSet(averageSpeedInKilometersPerHourIsSet(), "averageSpeedInKilometersPerHour");
      this.averageSpeedInKilometersPerHour = averageSpeedInKilometersPerHour;
      initBits &= ~INIT_BIT_AVERAGE_SPEED_IN_KILOMETERS_PER_HOUR;
      return this;
    }

    /**
     * Initializes the value for the {@link HealthRecord#expenditureInKilocalories() expenditureInKilocalories} attribute.
     * @param expenditureInKilocalories The value for expenditureInKilocalories 
     * @return {@code this} builder for use in a chained invocation
     */
    @CanIgnoreReturnValue 
    public final Builder expenditureInKilocalories(double expenditureInKilocalories) {
      checkNotIsSet(expenditureInKilocaloriesIsSet(), "expenditureInKilocalories");
      this.expenditureInKilocalories = expenditureInKilocalories;
      initBits &= ~INIT_BIT_EXPENDITURE_IN_KILOCALORIES;
      return this;
    }

    /**
     * Initializes the value for the {@link HealthRecord#heartRatesInBeatsPerMinute() heartRatesInBeatsPerMinute} attribute.
     * @param heartRatesInBeatsPerMinute The value for heartRatesInBeatsPerMinute 
     * @return {@code this} builder for use in a chained invocation
     */
    @CanIgnoreReturnValue 
    public final Builder heartRatesInBeatsPerMinute(NavigableMap<Instant, Integer> heartRatesInBeatsPerMinute) {
      checkNotIsSet(heartRatesInBeatsPerMinuteIsSet(), "heartRatesInBeatsPerMinute");
      this.heartRatesInBeatsPerMinute = Objects.requireNonNull(heartRatesInBeatsPerMinute, "heartRatesInBeatsPerMinute");
      initBits &= ~INIT_BIT_HEART_RATES_IN_BEATS_PER_MINUTE;
      return this;
    }

    /**
     * Initializes the value for the {@link HealthRecord#sleepDuration() sleepDuration} attribute.
     * @param sleepDuration The value for sleepDuration 
     * @return {@code this} builder for use in a chained invocation
     */
    @CanIgnoreReturnValue 
    public final Builder sleepDuration(Duration sleepDuration) {
      checkNotIsSet(sleepDurationIsSet(), "sleepDuration");
      this.sleepDuration = Objects.requireNonNull(sleepDuration, "sleepDuration");
      initBits &= ~INIT_BIT_SLEEP_DURATION;
      return this;
    }

    /**
     * Initializes the value for the {@link HealthRecord#stepCount() stepCount} attribute.
     * @param stepCount The value for stepCount 
     * @return {@code this} builder for use in a chained invocation
     */
    @CanIgnoreReturnValue 
    public final Builder stepCount(long stepCount) {
      checkNotIsSet(stepCountIsSet(), "stepCount");
      this.stepCount = stepCount;
      initBits &= ~INIT_BIT_STEP_COUNT;
      return this;
    }

    /**
     * Builds a new {@link HealthRecord HealthRecord}.
     * @return An immutable instance of HealthRecord
     * @throws java.lang.IllegalStateException if any required attributes are missing
     */
    public HealthRecord build() {
      checkRequiredAttributes();
      return HealthRecord.validate(new HealthRecord(this));
    }

    private boolean activeDurationIsSet() {
      return (initBits & INIT_BIT_ACTIVE_DURATION) == 0;
    }

    private boolean averageSpeedInKilometersPerHourIsSet() {
      return (initBits & INIT_BIT_AVERAGE_SPEED_IN_KILOMETERS_PER_HOUR) == 0;
    }

    private boolean expenditureInKilocaloriesIsSet() {
      return (initBits & INIT_BIT_EXPENDITURE_IN_KILOCALORIES) == 0;
    }

    private boolean heartRatesInBeatsPerMinuteIsSet() {
      return (initBits & INIT_BIT_HEART_RATES_IN_BEATS_PER_MINUTE) == 0;
    }

    private boolean sleepDurationIsSet() {
      return (initBits & INIT_BIT_SLEEP_DURATION) == 0;
    }

    private boolean stepCountIsSet() {
      return (initBits & INIT_BIT_STEP_COUNT) == 0;
    }

    private static void checkNotIsSet(boolean isSet, String name) {
      if (isSet) throw new IllegalStateException("Builder of HealthRecord is strict, attribute is already set: ".concat(name));
    }

    private void checkRequiredAttributes() {
      if (initBits != 0) {
        throw new IllegalStateException(formatRequiredAttributesMessage());
      }
    }

    private String formatRequiredAttributesMessage() {
      List<String> attributes = new ArrayList<>();
      if (!activeDurationIsSet()) attributes.add("activeDuration");
      if (!averageSpeedInKilometersPerHourIsSet()) attributes.add("averageSpeedInKilometersPerHour");
      if (!expenditureInKilocaloriesIsSet()) attributes.add("expenditureInKilocalories");
      if (!heartRatesInBeatsPerMinuteIsSet()) attributes.add("heartRatesInBeatsPerMinute");
      if (!sleepDurationIsSet()) attributes.add("sleepDuration");
      if (!stepCountIsSet()) attributes.add("stepCount");
      return "Cannot build HealthRecord, some of required attributes are not set " + attributes;
    }
  }
}
