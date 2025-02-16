package Model.Entities.RentableObjects;

/**
 * Represents a generic rentable object.
 * This class stores information common to all rentable items, such as their name,
 * description, price per day, and availability.  It serves as a base class or
 * a common type for more specific rentable objects (e.g., Vehicle, Clothing).
 */
public class RentableObject {

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
        this.name = name;
        this.description = description;
        this.pricePerDay = pricePerDay;
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
     * @param pricePerDay The price per day.
     */
    public void setPricePerDay(double pricePerDay) {
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
}