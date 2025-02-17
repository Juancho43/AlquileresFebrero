package Model.Entities.RentableObjects;

import Model.Entities.ICloneable;
import Model.Exceptions.OutOfRangeNumberException;
import Model.Validators.PriceValidator;
import Model.Validators.StringValidator;

/**
 * Represents a generic rentable object.
 * This class stores information common to all rentable items, such as their name,
 * description, price per day, and availability.  It serves as a base class or
 * a common type for more specific rentable objects (e.g., Vehicle, Clothing).
 * It also implements the {@code ICloneable} interface for cloning.
 */
public class RentableObject implements ICloneable<RentableObject> {

    private String name; // The name of the rentable object.
    private String description; // A description of the rentable object.
    private double pricePerDay; // The price per day for renting the object.
    private boolean available; // Indicates whether the object is currently available for rent.

    /**
     * Constructor for creating a new RentableObject.
     *
     * @param name        The name of the rentable object.
     * @param description A description of the rentable object.
     * @param pricePerDay The price per day for renting the object.
     */
    public RentableObject(String name, String description, double pricePerDay) {
        this.setName(name);
        this.setDescription(description);
        this.setPricePerDay(pricePerDay);
        this.available = true; // Initially, all objects are assumed to be available.
    }

    /**
     * Gets the name of the rentable object.
     *
     * @return The name of the rentable object.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the rentable object.
     *
     * @param name The name of the rentable object.
     */
    public void setName(String name) {
        StringValidator.validateString(name);
        this.name = name;
    }

    /**
     * Gets the description of the rentable object.
     *
     * @return The description of the rentable object.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the description of the rentable object.
     *
     * @param description The description of the rentable object.
     */
    public void setDescription(String description) {
        StringValidator.validateString(description);
        this.description = description;
    }

    /**
     * Gets the price per day for renting the object.
     *
     * @return The price per day.
     */
    public double getPricePerDay() {
        return pricePerDay;
    }

    /**
     * Sets the price per day for renting the object.
     *
     * This method allows assigning a new price per day for renting the object. Before assigning the value,
     * it checks if the price is valid using the `isValidPrice` method. If the price is not valid,
     * an `OutOfRangeNumberException` is thrown with a message indicating that the price must be greater than 0.
     *
     * @param pricePerDay The price per day to be assigned. It must be a positive number greater than 0.
     */
    public void setPricePerDay(double pricePerDay) {
        PriceValidator.validatePrice(pricePerDay);
        this.pricePerDay = pricePerDay;
    }

    /**
     * Checks if the object is currently available for rent.
     *
     * @return `true` if the object is available, `false` otherwise.
     */
    public boolean isAvailable() {
        return available;
    }

    /**
     * Sets the availability of the object.
     *
     * @param available `true` if the object is available, `false` otherwise.
     */
    public void setAvailable(boolean available) {
        this.available = available;
    }




    /**
     * Creates and returns a shallow copy of this {@code RentableObject}.
     * <p>
     * Because {@code RentableObject} appears to only contain primitive types or
     * immutable objects (like Strings), a shallow copy is sufficient.  If, in the
     * future, {@code RentableObject} contains references to mutable objects, this
     * method *must* be updated to perform a deep copy to prevent unintended side
     * effects.  Modifications to the cloned object would then not affect the
     * original object, and vice versa.
     *
     * @return A shallow clone of this {@code RentableObject}.
     * @throws RuntimeException If an error occurs during the cloning process. This
     *                          exception wraps any underlying {@code CloneNotSupportedException}
     *                          and provides a more informative error message.
     */
    @Override
    public RentableObject clone() {
        try {
            return (RentableObject) super.clone(); // Shallow clone is sufficient (for now).
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("Error cloning RentableObject: " + e.getMessage(), e); // More informative message
        }
    }
}