package nsf.stress;

import com.google.errorprone.annotations.CanIgnoreReturnValue;
import io.vertx.core.json.JsonObject;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.ParametersAreNonnullByDefault;
import javax.annotation.concurrent.NotThreadSafe;
import org.immutables.value.Generated;

/**
 * {@code HealthRecordJsonBuilder} collects parameters and invokes the static factory method:
 * {@code nsf.stress.HealthRecords.healthRecordJson(..)}.
 * Call the {@link #build()} method to get a result of type {@code io.vertx.core.json.JsonObject}.
 * <p><em>{@code HealthRecordJsonBuilder} is not thread-safe and generally should not be stored in a field or collection,
 * but instead used immediately to create instances.</em>
 */
@Generated(from = "HealthRecords.healthRecordJson", generator = "Immutables")
@SuppressWarnings({"OptionalUsedAsFieldOrParameterType", "all"})
@ParametersAreNonnullByDefault
@javax.annotation.processing.Generated("org.immutables.processor.ProxyProcessor")
@NotThreadSafe
public final class HealthRecordJsonBuilder {
  private static final long OPT_BIT_ACTIVE_DURATION = 0x1L;
  private static final long OPT_BIT_AVERAGE_SPEED_IN_KILOMETERS_PER_HOUR = 0x2L;
  private static final long OPT_BIT_EXPENDITURE_IN_KILOCALORIES = 0x4L;
  private static final long OPT_BIT_HEART_RATES_IN_BEATS_PER_MINUTE = 0x8L;
  private static final long OPT_BIT_SLEEP_DURATION = 0x10L;
  private static final long OPT_BIT_STEP_COUNT = 0x20L;
  private long optBits;

  private Optional<Object> activeDuration = Optional.empty();
  private Optional<Object> averageSpeedInKilometersPerHour = Optional.empty();
  private Optional<Object> expenditureInKilocalories = Optional.empty();
  private Optional<Object> heartRatesInBeatsPerMinute = Optional.empty();
  private Optional<Object> sleepDuration = Optional.empty();
  private Optional<Object> stepCount = Optional.empty();

  private HealthRecordJsonBuilder() {
  }

  /**
   * Creates a {@code HealthRecordJsonBuilder} factory builder.
   * @return A new builder
   */
  public static HealthRecordJsonBuilder create() {
    return new HealthRecordJsonBuilder();
  }

  /**
   * Initializes the optional value {@code activeDuration} to activeDuration.
   * @param activeDuration The value for activeDuration
   * @return {@code this} builder for chained invocation
   */
  @CanIgnoreReturnValue 
  public final HealthRecordJsonBuilder activeDuration(Object activeDuration) {
    checkNotIsSet(activeDurationIsSet(), "activeDuration");
    this.activeDuration = Optional.of(activeDuration);
    optBits |= OPT_BIT_ACTIVE_DURATION;
    return this;
  }

  /**
   * Initializes the optional value {@code activeDuration} to activeDuration.
   * @param activeDuration The value for activeDuration
   * @return {@code this} builder for use in a chained invocation
   */
  @SuppressWarnings("unchecked") // safe covariant cast
  @CanIgnoreReturnValue 
  public final HealthRecordJsonBuilder activeDuration(Optional<? extends Object> activeDuration) {
    checkNotIsSet(activeDurationIsSet(), "activeDuration");
    this.activeDuration = (Optional<Object>) Objects.requireNonNull(activeDuration, "activeDuration");
    optBits |= OPT_BIT_ACTIVE_DURATION;
    return this;
  }

  /**
   * Initializes the optional value {@code averageSpeedInKilometersPerHour} to averageSpeedInKilometersPerHour.
   * @param averageSpeedInKilometersPerHour The value for averageSpeedInKilometersPerHour
   * @return {@code this} builder for chained invocation
   */
  @CanIgnoreReturnValue 
  public final HealthRecordJsonBuilder averageSpeedInKilometersPerHour(Object averageSpeedInKilometersPerHour) {
    checkNotIsSet(averageSpeedInKilometersPerHourIsSet(), "averageSpeedInKilometersPerHour");
    this.averageSpeedInKilometersPerHour = Optional.of(averageSpeedInKilometersPerHour);
    optBits |= OPT_BIT_AVERAGE_SPEED_IN_KILOMETERS_PER_HOUR;
    return this;
  }

  /**
   * Initializes the optional value {@code averageSpeedInKilometersPerHour} to averageSpeedInKilometersPerHour.
   * @param averageSpeedInKilometersPerHour The value for averageSpeedInKilometersPerHour
   * @return {@code this} builder for use in a chained invocation
   */
  @SuppressWarnings("unchecked") // safe covariant cast
  @CanIgnoreReturnValue 
  public final HealthRecordJsonBuilder averageSpeedInKilometersPerHour(Optional<? extends Object> averageSpeedInKilometersPerHour) {
    checkNotIsSet(averageSpeedInKilometersPerHourIsSet(), "averageSpeedInKilometersPerHour");
    this.averageSpeedInKilometersPerHour = (Optional<Object>) Objects.requireNonNull(averageSpeedInKilometersPerHour, "averageSpeedInKilometersPerHour");
    optBits |= OPT_BIT_AVERAGE_SPEED_IN_KILOMETERS_PER_HOUR;
    return this;
  }

  /**
   * Initializes the optional value {@code expenditureInKilocalories} to expenditureInKilocalories.
   * @param expenditureInKilocalories The value for expenditureInKilocalories
   * @return {@code this} builder for chained invocation
   */
  @CanIgnoreReturnValue 
  public final HealthRecordJsonBuilder expenditureInKilocalories(Object expenditureInKilocalories) {
    checkNotIsSet(expenditureInKilocaloriesIsSet(), "expenditureInKilocalories");
    this.expenditureInKilocalories = Optional.of(expenditureInKilocalories);
    optBits |= OPT_BIT_EXPENDITURE_IN_KILOCALORIES;
    return this;
  }

  /**
   * Initializes the optional value {@code expenditureInKilocalories} to expenditureInKilocalories.
   * @param expenditureInKilocalories The value for expenditureInKilocalories
   * @return {@code this} builder for use in a chained invocation
   */
  @SuppressWarnings("unchecked") // safe covariant cast
  @CanIgnoreReturnValue 
  public final HealthRecordJsonBuilder expenditureInKilocalories(Optional<? extends Object> expenditureInKilocalories) {
    checkNotIsSet(expenditureInKilocaloriesIsSet(), "expenditureInKilocalories");
    this.expenditureInKilocalories = (Optional<Object>) Objects.requireNonNull(expenditureInKilocalories, "expenditureInKilocalories");
    optBits |= OPT_BIT_EXPENDITURE_IN_KILOCALORIES;
    return this;
  }

  /**
   * Initializes the optional value {@code heartRatesInBeatsPerMinute} to heartRatesInBeatsPerMinute.
   * @param heartRatesInBeatsPerMinute The value for heartRatesInBeatsPerMinute
   * @return {@code this} builder for chained invocation
   */
  @CanIgnoreReturnValue 
  public final HealthRecordJsonBuilder heartRatesInBeatsPerMinute(Object heartRatesInBeatsPerMinute) {
    checkNotIsSet(heartRatesInBeatsPerMinuteIsSet(), "heartRatesInBeatsPerMinute");
    this.heartRatesInBeatsPerMinute = Optional.of(heartRatesInBeatsPerMinute);
    optBits |= OPT_BIT_HEART_RATES_IN_BEATS_PER_MINUTE;
    return this;
  }

  /**
   * Initializes the optional value {@code heartRatesInBeatsPerMinute} to heartRatesInBeatsPerMinute.
   * @param heartRatesInBeatsPerMinute The value for heartRatesInBeatsPerMinute
   * @return {@code this} builder for use in a chained invocation
   */
  @SuppressWarnings("unchecked") // safe covariant cast
  @CanIgnoreReturnValue 
  public final HealthRecordJsonBuilder heartRatesInBeatsPerMinute(Optional<? extends Object> heartRatesInBeatsPerMinute) {
    checkNotIsSet(heartRatesInBeatsPerMinuteIsSet(), "heartRatesInBeatsPerMinute");
    this.heartRatesInBeatsPerMinute = (Optional<Object>) Objects.requireNonNull(heartRatesInBeatsPerMinute, "heartRatesInBeatsPerMinute");
    optBits |= OPT_BIT_HEART_RATES_IN_BEATS_PER_MINUTE;
    return this;
  }

  /**
   * Initializes the optional value {@code sleepDuration} to sleepDuration.
   * @param sleepDuration The value for sleepDuration
   * @return {@code this} builder for chained invocation
   */
  @CanIgnoreReturnValue 
  public final HealthRecordJsonBuilder sleepDuration(Object sleepDuration) {
    checkNotIsSet(sleepDurationIsSet(), "sleepDuration");
    this.sleepDuration = Optional.of(sleepDuration);
    optBits |= OPT_BIT_SLEEP_DURATION;
    return this;
  }

  /**
   * Initializes the optional value {@code sleepDuration} to sleepDuration.
   * @param sleepDuration The value for sleepDuration
   * @return {@code this} builder for use in a chained invocation
   */
  @SuppressWarnings("unchecked") // safe covariant cast
  @CanIgnoreReturnValue 
  public final HealthRecordJsonBuilder sleepDuration(Optional<? extends Object> sleepDuration) {
    checkNotIsSet(sleepDurationIsSet(), "sleepDuration");
    this.sleepDuration = (Optional<Object>) Objects.requireNonNull(sleepDuration, "sleepDuration");
    optBits |= OPT_BIT_SLEEP_DURATION;
    return this;
  }

  /**
   * Initializes the optional value {@code stepCount} to stepCount.
   * @param stepCount The value for stepCount
   * @return {@code this} builder for chained invocation
   */
  @CanIgnoreReturnValue 
  public final HealthRecordJsonBuilder stepCount(Object stepCount) {
    checkNotIsSet(stepCountIsSet(), "stepCount");
    this.stepCount = Optional.of(stepCount);
    optBits |= OPT_BIT_STEP_COUNT;
    return this;
  }

  /**
   * Initializes the optional value {@code stepCount} to stepCount.
   * @param stepCount The value for stepCount
   * @return {@code this} builder for use in a chained invocation
   */
  @SuppressWarnings("unchecked") // safe covariant cast
  @CanIgnoreReturnValue 
  public final HealthRecordJsonBuilder stepCount(Optional<? extends Object> stepCount) {
    checkNotIsSet(stepCountIsSet(), "stepCount");
    this.stepCount = (Optional<Object>) Objects.requireNonNull(stepCount, "stepCount");
    optBits |= OPT_BIT_STEP_COUNT;
    return this;
  }

  /**
   * Invokes {@code nsf.stress.HealthRecords.healthRecordJson(..)} using the collected parameters and returns the result of the invocation
   * @return A result of type {@code io.vertx.core.json.JsonObject}
   * @throws java.lang.IllegalStateException if any required attributes are missing
   */
  public JsonObject build() {
    return HealthRecords.healthRecordJson(activeDuration,
        averageSpeedInKilometersPerHour,
        expenditureInKilocalories,
        heartRatesInBeatsPerMinute,
        sleepDuration,
        stepCount);
  }

  private boolean activeDurationIsSet() {
    return (optBits & OPT_BIT_ACTIVE_DURATION) != 0;
  }

  private boolean averageSpeedInKilometersPerHourIsSet() {
    return (optBits & OPT_BIT_AVERAGE_SPEED_IN_KILOMETERS_PER_HOUR) != 0;
  }

  private boolean expenditureInKilocaloriesIsSet() {
    return (optBits & OPT_BIT_EXPENDITURE_IN_KILOCALORIES) != 0;
  }

  private boolean heartRatesInBeatsPerMinuteIsSet() {
    return (optBits & OPT_BIT_HEART_RATES_IN_BEATS_PER_MINUTE) != 0;
  }

  private boolean sleepDurationIsSet() {
    return (optBits & OPT_BIT_SLEEP_DURATION) != 0;
  }

  private boolean stepCountIsSet() {
    return (optBits & OPT_BIT_STEP_COUNT) != 0;
  }

  private static void checkNotIsSet(boolean isSet, String name) {
    if (isSet) throw new IllegalStateException("Builder of healthRecordJson is strict, attribute is already set: ".concat(name));
  }
}
