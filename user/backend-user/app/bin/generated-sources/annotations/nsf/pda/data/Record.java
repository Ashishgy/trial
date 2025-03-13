package nsf.pda.data;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;
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
 * Immutable implementation of {@link BaseRecord}.
 * <p>
 * Use the builder to create immutable instances:
 * {@code Record.builder()}.
 */
@Generated(from = "BaseRecord", generator = "Immutables")
@SuppressWarnings({"all"})
@ParametersAreNonnullByDefault
@javax.annotation.processing.Generated("org.immutables.processor.ProxyProcessor")
@Immutable
@CheckReturnValue
public final class Record extends BaseRecord {
  private final String endpoint;
  private final String recordId;
  private final JsonNode data;
  @SuppressWarnings("Immutable")
  private transient int hashCode; // hashCode lazily computed

  private Record(Record.Builder builder) {
    this.endpoint = builder.endpoint;
    this.recordId = builder.recordId;
    this.data = builder.data;
  }

  /**
   * @return The value of the {@code endpoint} attribute
   */
  @JsonProperty("endpoint")
  @Override
  public String endpoint() {
    return endpoint;
  }

  /**
   * @return The value of the {@code recordId} attribute
   */
  @JsonProperty("recordId")
  @Override
  public String recordId() {
    return recordId;
  }

  /**
   * @return The value of the {@code data} attribute
   */
  @JsonProperty("data")
  @Override
  public JsonNode data() {
    return data;
  }

  /**
   * This instance is equal to all instances of {@code Record} that have equal attribute values.
   * @return {@code true} if {@code this} is equal to {@code another} instance
   */
  @Override
  public boolean equals(@Nullable Object another) {
    if (this == another) return true;
    return another instanceof Record
        && equalTo(0, (Record) another);
  }

  private boolean equalTo(int synthetic, Record another) {
    if (hashCode != 0 && another.hashCode != 0 && hashCode != another.hashCode) return false;
    return endpoint.equals(another.endpoint)
        && recordId.equals(another.recordId)
        && data.equals(another.data);
  }

  /**
   * Returns a lazily computed hash code from attributes: {@code endpoint}, {@code recordId}, {@code data}.
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
    h += (h << 5) + endpoint.hashCode();
    h += (h << 5) + recordId.hashCode();
    h += (h << 5) + data.hashCode();
    return h;
  }

  /**
   * Prints the immutable value {@code Record} with attribute values.
   * @return A string representation of the value
   */
  @Override
  public String toString() {
    return MoreObjects.toStringHelper("Record")
        .omitNullValues()
        .add("endpoint", endpoint)
        .add("recordId", recordId)
        .add("data", data)
        .toString();
  }

  /**
   * Utility type used to correctly read immutable object from JSON representation.
   * @deprecated Do not use this type directly, it exists only for the <em>Jackson</em>-binding infrastructure
   */
  @Generated(from = "BaseRecord", generator = "Immutables")
  @Deprecated
  @SuppressWarnings("Immutable")
  @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.NONE)
  static final class Json extends BaseRecord {
    @Nullable String endpoint;
    @Nullable String recordId;
    @Nullable JsonNode data;
    @JsonProperty("endpoint")
    public void setEndpoint(String endpoint) {
      this.endpoint = endpoint;
    }
    @JsonProperty("recordId")
    public void setRecordId(String recordId) {
      this.recordId = recordId;
    }
    @JsonProperty("data")
    public void setData(JsonNode data) {
      this.data = data;
    }
    @Override
    public String endpoint() { throw new UnsupportedOperationException(); }
    @Override
    public String recordId() { throw new UnsupportedOperationException(); }
    @Override
    public JsonNode data() { throw new UnsupportedOperationException(); }
  }

  /**
   * @param json A JSON-bindable data structure
   * @return An immutable value type
   * @deprecated Do not use this method directly, it exists only for the <em>Jackson</em>-binding infrastructure
   */
  @Deprecated
  @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
  static Record fromJson(Json json) {
    Record.Builder builder = Record.builder();
    if (json.endpoint != null) {
      builder.endpoint(json.endpoint);
    }
    if (json.recordId != null) {
      builder.recordId(json.recordId);
    }
    if (json.data != null) {
      builder.data(json.data);
    }
    return builder.build();
  }

  /**
   * Creates a builder for {@link Record Record}.
   * <pre>
   * Record.builder()
   *    .endpoint(String) // required {@link BaseRecord#endpoint() endpoint}
   *    .recordId(String) // required {@link BaseRecord#recordId() recordId}
   *    .data(com.fasterxml.jackson.databind.JsonNode) // required {@link BaseRecord#data() data}
   *    .build();
   * </pre>
   * @return A new Record builder
   */
  public static Record.Builder builder() {
    return new Record.Builder();
  }

  /**
   * Builds instances of type {@link Record Record}.
   * Initialize attributes and then invoke the {@link #build()} method to create an
   * immutable instance.
   * <p><em>{@code Builder} is not thread-safe and generally should not be stored in a field or collection,
   * but instead used immediately to create instances.</em>
   */
  @Generated(from = "BaseRecord", generator = "Immutables")
  @NotThreadSafe
  public static final class Builder {
    private static final long INIT_BIT_ENDPOINT = 0x1L;
    private static final long INIT_BIT_RECORD_ID = 0x2L;
    private static final long INIT_BIT_DATA = 0x4L;
    private long initBits = 0x7L;

    private @Nullable String endpoint;
    private @Nullable String recordId;
    private @Nullable JsonNode data;

    private Builder() {
    }

    /**
     * Initializes the value for the {@link BaseRecord#endpoint() endpoint} attribute.
     * @param endpoint The value for endpoint 
     * @return {@code this} builder for use in a chained invocation
     */
    @CanIgnoreReturnValue 
    public final Builder endpoint(String endpoint) {
      checkNotIsSet(endpointIsSet(), "endpoint");
      this.endpoint = Objects.requireNonNull(endpoint, "endpoint");
      initBits &= ~INIT_BIT_ENDPOINT;
      return this;
    }

    /**
     * Initializes the value for the {@link BaseRecord#recordId() recordId} attribute.
     * @param recordId The value for recordId 
     * @return {@code this} builder for use in a chained invocation
     */
    @CanIgnoreReturnValue 
    public final Builder recordId(String recordId) {
      checkNotIsSet(recordIdIsSet(), "recordId");
      this.recordId = Objects.requireNonNull(recordId, "recordId");
      initBits &= ~INIT_BIT_RECORD_ID;
      return this;
    }

    /**
     * Initializes the value for the {@link BaseRecord#data() data} attribute.
     * @param data The value for data 
     * @return {@code this} builder for use in a chained invocation
     */
    @CanIgnoreReturnValue 
    public final Builder data(JsonNode data) {
      checkNotIsSet(dataIsSet(), "data");
      this.data = Objects.requireNonNull(data, "data");
      initBits &= ~INIT_BIT_DATA;
      return this;
    }

    /**
     * Builds a new {@link Record Record}.
     * @return An immutable instance of Record
     * @throws java.lang.IllegalStateException if any required attributes are missing
     */
    public Record build() {
      checkRequiredAttributes();
      return new Record(this);
    }

    private boolean endpointIsSet() {
      return (initBits & INIT_BIT_ENDPOINT) == 0;
    }

    private boolean recordIdIsSet() {
      return (initBits & INIT_BIT_RECORD_ID) == 0;
    }

    private boolean dataIsSet() {
      return (initBits & INIT_BIT_DATA) == 0;
    }

    private static void checkNotIsSet(boolean isSet, String name) {
      if (isSet) throw new IllegalStateException("Builder of Record is strict, attribute is already set: ".concat(name));
    }

    private void checkRequiredAttributes() {
      if (initBits != 0) {
        throw new IllegalStateException(formatRequiredAttributesMessage());
      }
    }

    private String formatRequiredAttributesMessage() {
      List<String> attributes = new ArrayList<>();
      if (!endpointIsSet()) attributes.add("endpoint");
      if (!recordIdIsSet()) attributes.add("recordId");
      if (!dataIsSet()) attributes.add("data");
      return "Cannot build Record, some of required attributes are not set " + attributes;
    }
  }
}
