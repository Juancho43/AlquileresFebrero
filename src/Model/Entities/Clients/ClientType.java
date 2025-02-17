package Model.Entities.Clients;

import Model.Entities.ICloneable;
import Model.Factory.IdFactory;

import java.util.Objects;

/**
 * Represents the type of client, defining characteristics like discounts.
 * This class stores information about the client type, including its ID, name,
 * and associated discount.
 * It also implements the {@code ICloneable} interface for cloning.
 */
public class ClientType implements ICloneable<ClientType> {

    private long id;
    private String type;
    private double discount;

    /**
     * Constructor for creating a new client type.
     *
     * @param type     The name of the client type (e.g., "Regular", "Premium").
     * @param discount The discount associated with this client type (e.g., 0.0, 0.1).
     */
    public ClientType(String type, double discount) {
        this.id = IdFactory.generateUniqueId(); // Generate a unique ID using a factory.
        this.type = type;
        this.discount = discount;
    }

    /**
     * Default constructor.
     */
    public ClientType() {
    }


    /**
     * Gets the ID of the client type.
     *
     * @return The ID of the client type.
     */
    public long getId() {
        return id;
    }

    /**
     * Sets the ID of the client type. Primarily used by persistence frameworks.
     *
     * @param id The ID of the client type.
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * Gets the name of the client type.
     *
     * @return The name of the client type.
     */
    public String getType() {
        return type;
    }

    /**
     * Sets the name of the client type.
     *
     * @param type The name of the client type.
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * Gets the discount associated with this client type.
     *
     * @return The discount associated with this client type.
     */
    public double getDiscount() {
        return discount;
    }

    /**
     * Sets the discount associated with this client type.
     *
     * @param discount The discount associated with this client type.
     */
    public void setDiscount(double discount) {
        this.discount = discount;
    }

    /**
     * Returns a string representation of the client type.
     *
     * @return A string representation of the client type (type and discount).
     */
    @Override
    public String toString() {
        return type + ", descuento: " + discount;
    }

    /**
     * Checks if this client type is equal to another object.
     * Two ClientType objects are considered equal if they have the same ID, type, and discount.
     *
     * @param o The object to compare with this client type.
     * @return {@code true} if this client type is equal to the specified object, {@code false} otherwise.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClientType that = (ClientType) o;
        return id == that.id && Double.compare(that.discount, discount) == 0 && Objects.equals(type, that.type);
    }

    /**
     * Returns the hash code of this client type.
     * The hash code is generated based on the ID, type, and discount.
     *
     * @return The hash code of this client type.
     */
    @Override
    public int hashCode() {
        return Objects.hash(id, type, discount);
    }

    /**
     * Creates and returns a shallow copy of this {@code ClientType} object.
     * <p>
     * Because {@code ClientType} is assumed to only contain primitive types or
     * immutable objects (like Strings), a shallow copy is sufficient.  If, in the
     * future, {@code ClientType} contains references to mutable objects, this
     * method *must* be updated to perform a deep copy to prevent unintended side
     * effects.  Modifications to the cloned object would then not affect the
     * original object, and vice versa.
     *
     * @return A shallow clone of this {@code ClientType} object.
     * @throws RuntimeException If an error occurs during the cloning process. This
     *                          exception wraps any underlying {@code CloneNotSupportedException}
     *                          and provides a more informative error message.
     */
    @Override
    public ClientType clone() {
        try {
            return (ClientType) super.clone(); // Shallow clone is sufficient (for now).
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("Error cloning ClientType object: " + e.getMessage(), e); // More informative message
        }
    }
}