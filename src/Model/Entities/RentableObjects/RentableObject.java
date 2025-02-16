package Model.Entities.RentableObjects;

import Model.Exceptions.OutOfRangeNumberException;

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
     * This method allows assigning a new price per day for renting the object. Before assigning the value,
     * it checks if the price is valid using the `isValidPrice` method. If the price is not valid,
     * an `OutOfRangeNumberException` is thrown with a message indicating that the price must be greater than 0.
     *
     * @param pricePerDay The price per day to be assigned. It must be a positive number greater than 0.
     * @throws OutOfRangeNumberException If the provided price is not greater than 0.
     */
    public void setPricePerDay(double pricePerDay) {
        if(!isValidPrice(pricePerDay)) {
            throw new OutOfRangeNumberException("El precio debe ser mayor a 0");
        }
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
     * Checks if the given price per day falls within the valid range.
     *
     * @param pricePerDay The price per day to validate.
     * @return true if the price is within the allowed range, false otherwise.
     */
    private boolean isWithRange(double pricePerDay){
        final double MIN_PRICE = 0.01;
        final double MAX_PRICE = 1000000.00;
        return pricePerDay >= MIN_PRICE && pricePerDay <= MAX_PRICE;
    }

    /**
     * Checks if the given price per day is a positive value.
     *
     * @param pricePerDay The price per day to validate.
     * @return true if the price is greater than zero, false otherwise.
     */
    private boolean isPositive(double pricePerDay){
        return pricePerDay > 0;
    }

    /**
     * Validates if the given price per day is both positive and within the allowed range.
     *
     * @param pricePerDay The price per day to validate.
     * @return true if the price meets both conditions, false otherwise.
     */
    private boolean isValidPrice(double pricePerDay){
        return isWithRange(pricePerDay) && isPositive(pricePerDay);
    }

}