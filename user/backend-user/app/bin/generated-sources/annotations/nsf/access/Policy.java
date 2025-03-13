package nsf.access;

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
import org.immutables.value.Generated;

/**
 * Immutable implementation of {@link BasePolicy}.
 * <p>
 * Use the builder to create immutable instances:
 * {@code Policy.builder()}.
 */
@Generated(from = "BasePolicy", generator = "Immutables")
@SuppressWarnings({"all"})
@ParametersAreNonnullByDefault
@javax.annotation.processing.Generated("org.immutables.processor.ProxyProcessor")
@Immutable
@CheckReturnValue
public final class Policy extends BasePolicy {
  private final String serviceProviderId;
  private final String version;
  private final LinkedList<Operation> operations;
  private final LinkedList<String> resources;
  @SuppressWarnings("Immutable")
  private transient int hashCode; // hashCode lazily computed

  private Policy(Policy.Builder builder) {
    this.serviceProviderId = builder.serviceProviderId;
    this.version = builder.version;
    this.operations = builder.operations;
    this.resources = builder.resources;
  }

  /**
   * @return The value of the {@code serviceProviderId} attribute
   */
  @JsonProperty("_id")
  @Override
  public String serviceProviderId() {
    return serviceProviderId;
  }

  /**
   * @return The value of the {@code version} attribute
   */
  @JsonProperty("version")
  @Override
  public String version() {
    return version;
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
   * This instance is equal to all instances of {@code Policy} that have equal attribute values.
   * @return {@code true} if {@code this} is equal to {@code another} instance
   */
  @Override
  public boolean equals(@Nullable Object another) {
    if (this == another) return true;
    return another instanceof Policy
        && equalTo(0, (Policy) another);
  }

  private boolean equalTo(int synthetic, Policy another) {
    if (hashCode != 0 && another.hashCode != 0 && hashCode != another.hashCode) return false;
    return serviceProviderId.equals(another.serviceProviderId)
        && version.equals(another.version)
        && operations.equals(another.operations)
        && resources.equals(another.resources);
  }

  /**
   * Returns a lazily computed hash code from attributes: {@code serviceProviderId}, {@code version}, {@code operations}, {@code resources}.
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
    h += (h << 5) + serviceProviderId.hashCode();
    h += (h << 5) + version.hashCode();
    h += (h << 5) + operations.hashCode();
    h += (h << 5) + resources.hashCode();
    return h;
  }

  /**
   * Prints the immutable value {@code Policy} with attribute values.
   * @return A string representation of the value
   */
  @Override
  public String toString() {
    return MoreObjects.toStringHelper("Policy")
        .omitNullValues()
        .add("serviceProviderId", serviceProviderId)
        .add("version", version)
        .add("operations", operations)
        .add("resources", resources)
        .toString();
  }

  /**
   * Utility type used to correctly read immutable object from JSON representation.
   * @deprecated Do not use this type directly, it exists only for the <em>Jackson</em>-binding infrastructure
   */
  @Generated(from = "BasePolicy", generator = "Immutables")
  @Deprecated
  @SuppressWarnings("Immutable")
  @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.NONE)
  static final class Json extends BasePolicy {
    @Nullable String serviceProviderId;
    @Nullable String version;
    @Nullable LinkedList<Operation> operations;
    @Nullable LinkedList<String> resources;
    @JsonProperty("_id")
    public void setServiceProviderId(String serviceProviderId) {
      this.serviceProviderId = serviceProviderId;
    }
    @JsonProperty("version")
    public void setVersion(String version) {
      this.version = version;
    }
    @JsonProperty("operations")
    public void setOperations(LinkedList<Operation> operations) {
      this.operations = operations;
    }
    @JsonProperty("resources")
    public void setResources(LinkedList<String> resources) {
      this.resources = resources;
    }
    @Override
    public String serviceProviderId() { throw new UnsupportedOperationException(); }
    @Override
    public String version() { throw new UnsupportedOperationException(); }
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
  static Policy fromJson(Json json) {
    Policy.Builder builder = Policy.builder();
    if (json.serviceProviderId != null) {
      builder.serviceProviderId(json.serviceProviderId);
    }
    if (json.version != null) {
      builder.version(json.version);
    }
    if (json.operations != null) {
      builder.operations(json.operations);
    }
    if (json.resources != null) {
      builder.resources(json.resources);
    }
    return builder.build();
  }

  /**
   * Creates a builder for {@link Policy Policy}.
   * <pre>
   * Policy.builder()
   *    .serviceProviderId(String) // required {@link BasePolicy#serviceProviderId() serviceProviderId}
   *    .version(String) // required {@link BasePolicy#version() version}
   *    .operations(LinkedList&amp;lt;nsf.access.Operation&amp;gt;) // required {@link BasePolicy#operations() operations}
   *    .resources(LinkedList&amp;lt;String&amp;gt;) // required {@link BasePolicy#resources() resources}
   *    .build();
   * </pre>
   * @return A new Policy builder
   */
  public static Policy.Builder builder() {
    return new Policy.Builder();
  }

  /**
   * Builds instances of type {@link Policy Policy}.
   * Initialize attributes and then invoke the {@link #build()} method to create an
   * immutable instance.
   * <p><em>{@code Builder} is not thread-safe and generally should not be stored in a field or collection,
   * but instead used immediately to create instances.</em>
   */
  @Generated(from = "BasePolicy", generator = "Immutables")
  @NotThreadSafe
  public static final class Builder {
    private static final long INIT_BIT_SERVICE_PROVIDER_ID = 0x1L;
    private static final long INIT_BIT_VERSION = 0x2L;
    private static final long INIT_BIT_OPERATIONS = 0x4L;
    private static final long INIT_BIT_RESOURCES = 0x8L;
    private long initBits = 0xfL;

    private @Nullable String serviceProviderId;
    private @Nullable String version;
    private @Nullable LinkedList<Operation> operations;
    private @Nullable LinkedList<String> resources;

    private Builder() {
    }

    /**
     * Initializes the value for the {@link BasePolicy#serviceProviderId() serviceProviderId} attribute.
     * @param serviceProviderId The value for serviceProviderId 
     * @return {@code this} builder for use in a chained invocation
     */
    @CanIgnoreReturnValue 
    public final Builder serviceProviderId(String serviceProviderId) {
      checkNotIsSet(serviceProviderIdIsSet(), "serviceProviderId");
      this.serviceProviderId = Objects.requireNonNull(serviceProviderId, "serviceProviderId");
      initBits &= ~INIT_BIT_SERVICE_PROVIDER_ID;
      return this;
    }

    /**
     * Initializes the value for the {@link BasePolicy#version() version} attribute.
     * @param version The value for version 
     * @return {@code this} builder for use in a chained invocation
     */
    @CanIgnoreReturnValue 
    public final Builder version(String version) {
      checkNotIsSet(versionIsSet(), "version");
      this.version = Objects.requireNonNull(version, "version");
      initBits &= ~INIT_BIT_VERSION;
      return this;
    }

    /**
     * Initializes the value for the {@link BasePolicy#operations() operations} attribute.
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
     * Initializes the value for the {@link BasePolicy#resources() resources} attribute.
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
     * Builds a new {@link Policy Policy}.
     * @return An immutable instance of Policy
     * @throws java.lang.IllegalStateException if any required attributes are missing
     */
    public Policy build() {
      checkRequiredAttributes();
      return new Policy(this);
    }

    private boolean serviceProviderIdIsSet() {
      return (initBits & INIT_BIT_SERVICE_PROVIDER_ID) == 0;
    }

    private boolean versionIsSet() {
      return (initBits & INIT_BIT_VERSION) == 0;
    }

    private boolean operationsIsSet() {
      return (initBits & INIT_BIT_OPERATIONS) == 0;
    }

    private boolean resourcesIsSet() {
      return (initBits & INIT_BIT_RESOURCES) == 0;
    }

    private static void checkNotIsSet(boolean isSet, String name) {
      if (isSet) throw new IllegalStateException("Builder of Policy is strict, attribute is already set: ".concat(name));
    }

    private void checkRequiredAttributes() {
      if (initBits != 0) {
        throw new IllegalStateException(formatRequiredAttributesMessage());
      }
    }

    private String formatRequiredAttributesMessage() {
      List<String> attributes = new ArrayList<>();
      if (!serviceProviderIdIsSet()) attributes.add("serviceProviderId");
      if (!versionIsSet()) attributes.add("version");
      if (!operationsIsSet()) attributes.add("operations");
      if (!resourcesIsSet()) attributes.add("resources");
      return "Cannot build Policy, some of required attributes are not set " + attributes;
    }
  }
}
