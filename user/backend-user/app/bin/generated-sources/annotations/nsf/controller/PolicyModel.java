package nsf.controller;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.Var;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import javax.annotation.CheckReturnValue;
import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;
import javax.annotation.concurrent.Immutable;
import javax.annotation.concurrent.NotThreadSafe;
import nsf.access.Operation;
import org.immutables.value.Generated;

/**
 * Request model for a Service Provider access control policy. (used as request body deserialized object).
 */
@Generated(from = "BasePolicyModel", generator = "Immutables")
@SuppressWarnings({"all"})
@ParametersAreNonnullByDefault
@javax.annotation.processing.Generated("org.immutables.processor.ProxyProcessor")
@Immutable
@CheckReturnValue
public final class PolicyModel extends BasePolicyModel {
  private final LinkedList<Operation> operations;
  private final LinkedList<String> resources;
  @SuppressWarnings("Immutable")
  private transient int hashCode; // hashCode lazily computed

  private PolicyModel(PolicyModel.Builder builder) {
    this.operations = builder.operations;
    this.resources = builder.resources;
  }

  /**
   * @return The value of the {@code operations} attribute
   */
  @JsonProperty("operations")
  @Override
  public LinkedList<Operation> operations() {
    return operations;
  }

  /**
   * @return The value of the {@code resources} attribute
   */
  @JsonProperty("resources")
  @Override
  public LinkedList<String> resources() {
    return resources;
  }

  /**
   * This instance is equal to all instances of {@code PolicyModel} that have equal attribute values.
   * @return {@code true} if {@code this} is equal to {@code another} instance
   */
  @Override
  public boolean equals(@Nullable Object another) {
    if (this == another) return true;
    return another instanceof PolicyModel
        && equalTo(0, (PolicyModel) another);
  }

  private boolean equalTo(int synthetic, PolicyModel another) {
    if (hashCode != 0 && another.hashCode != 0 && hashCode != another.hashCode) return false;
    return operations.equals(another.operations)
        && resources.equals(another.resources);
  }

  /**
   * Returns a lazily computed hash code from attributes: {@code operations}, {@code resources}.
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
    h += (h << 5) + operations.hashCode();
    h += (h << 5) + resources.hashCode();
    return h;
  }

  /**
   * Prints the immutable value {@code PolicyModel} with attribute values.
   * @return A string representation of the value
   */
  @Override
  public String toString() {
    return MoreObjects.toStringHelper("PolicyModel")
        .omitNullValues()
        .add("operations", operations)
        .add("resources", resources)
        .toString();
  }

  /**
   * Utility type used to correctly read immutable object from JSON representation.
   * @deprecated Do not use this type directly, it exists only for the <em>Jackson</em>-binding infrastructure
   */
  @Generated(from = "BasePolicyModel", generator = "Immutables")
  @Deprecated
  @SuppressWarnings("Immutable")
  @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.NONE)
  static final class Json extends BasePolicyModel {
    @Nullable LinkedList<Operation> operations;
    @Nullable LinkedList<String> resources;
    @JsonProperty("operations")
    public void setOperations(LinkedList<Operation> operations) {
      this.operations = operations;
    }
    @JsonProperty("resources")
    public void setResources(LinkedList<String> resources) {
      this.resources = resources;
    }
    @Override
    public LinkedList<Operation> operations() { throw new UnsupportedOperationException(); }
    @Override
    public LinkedList<String> resources() { throw new UnsupportedOperationException(); }
  }

  /**
   * @param json A JSON-bindable data structure
   * @return An immutable value type
   * @deprecated Do not use this method directly, it exists only for the <em>Jackson</em>-binding infrastructure
   */
  @Deprecated
  @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
  static PolicyModel fromJson(Json json) {
    PolicyModel.Builder builder = PolicyModel.builder();
    if (json.operations != null) {
      builder.operations(json.operations);
    }
    if (json.resources != null) {
      builder.resources(json.resources);
    }
    return builder.build();
  }

  /**
   * Creates a builder for {@link PolicyModel PolicyModel}.
   * <pre>
   * PolicyModel.builder()
   *    .operations(LinkedList&amp;lt;nsf.access.Operation&amp;gt;) // required {@link BasePolicyModel#operations() operations}
   *    .resources(LinkedList&amp;lt;String&amp;gt;) // required {@link BasePolicyModel#resources() resources}
   *    .build();
   * </pre>
   * @return A new PolicyModel builder
   */
  public static PolicyModel.Builder builder() {
    return new PolicyModel.Builder();
  }

  /**
   * Builds instances of type {@link PolicyModel PolicyModel}.
   * Initialize attributes and then invoke the {@link #build()} method to create an
   * immutable instance.
   * <p><em>{@code Builder} is not thread-safe and generally should not be stored in a field or collection,
   * but instead used immediately to create instances.</em>
   */
  @Generated(from = "BasePolicyModel", generator = "Immutables")
  @NotThreadSafe
  public static final class Builder {
    private static final long INIT_BIT_OPERATIONS = 0x1L;
    private static final long INIT_BIT_RESOURCES = 0x2L;
    private long initBits = 0x3L;

    private @Nullable LinkedList<Operation> operations;
    private @Nullable LinkedList<String> resources;

    private Builder() {
    }

    /**
     * Initializes the value for the {@link BasePolicyModel#operations() operations} attribute.
     * @param operations The value for operations 
     * @return {@code this} builder for use in a chained invocation
     */
    @CanIgnoreReturnValue 
    public final Builder operations(LinkedList<Operation> operations) {
      checkNotIsSet(operationsIsSet(), "operations");
      this.operations = Objects.requireNonNull(operations, "operations");
      initBits &= ~INIT_BIT_OPERATIONS;
      return this;
    }

    /**
     * Initializes the value for the {@link BasePolicyModel#resources() resources} attribute.
     * @param resources The value for resources 
     * @return {@code this} builder for use in a chained invocation
     */
    @CanIgnoreReturnValue 
    public final Builder resources(LinkedList<String> resources) {
      checkNotIsSet(resourcesIsSet(), "resources");
      this.resources = Objects.requireNonNull(resources, "resources");
      initBits &= ~INIT_BIT_RESOURCES;
      return this;
    }

    /**
     * Builds a new {@link PolicyModel PolicyModel}.
     * @return An immutable instance of PolicyModel
     * @throws java.lang.IllegalStateException if any required attributes are missing
     */
    public PolicyModel build() {
      checkRequiredAttributes();
      return new PolicyModel(this);
    }

    private boolean operationsIsSet() {
      return (initBits & INIT_BIT_OPERATIONS) == 0;
    }

    private boolean resourcesIsSet() {
      return (initBits & INIT_BIT_RESOURCES) == 0;
    }

    private static void checkNotIsSet(boolean isSet, String name) {
      if (isSet) throw new IllegalStateException("Builder of PolicyModel is strict, attribute is already set: ".concat(name));
    }

    private void checkRequiredAttributes() {
      if (initBits != 0) {
        throw new IllegalStateException(formatRequiredAttributesMessage());
      }
    }

    private String formatRequiredAttributesMessage() {
      List<String> attributes = new ArrayList<>();
      if (!operationsIsSet()) attributes.add("operations");
      if (!resourcesIsSet()) attributes.add("resources");
      return "Cannot build PolicyModel, some of required attributes are not set " + attributes;
    }
  }
}
