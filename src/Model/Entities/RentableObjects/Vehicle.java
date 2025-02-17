package Model.Entities.RentableObjects;

import Model.Entities.ICloneable;
import Model.Exceptions.IllegalYearException;
import Model.Factory.IdFactory;

import java.time.Year;

/**
 * Represents a rentable vehicle.
 * This class stores information about a specific vehicle, including its ID,
 * associated `RentableObject` details (name, description, price), brand, model,
 * and year. It implements the `IRentableObject` interface to provide access
 * to the underlying `RentableObject`.
 * It also implements the {@code ICloneable} interface for cloning.
 */
public class Vehicle implements IRentableObject, ICloneable<Vehicle> {

    private long id; // The unique ID of the vehicle.
    private RentableObject object; // The RentableObject associated with this vehicle.
    private String brand; // The brand of the vehicle.
    private String model; // The model of the vehicle.
    private int year; // The year the vehicle was manufactured.

    /**
     * Default constructor. Used by frameworks like Hibernate.
     */
    public Vehicle() {
    }

    /**
     * Constructor for creating a new Vehicle.
     *
     * @param name        The name of the vehicle (e.g., "Toyota Camry").
     * @param description A description of the vehicle.
     * @param pricePerDay The price per day for renting the vehicle.
     * @param brand       The brand of the vehicle.
     * @param model       The model of the vehicle.
     * @param year        The year the vehicle was manufactured.
     */
    public Vehicle(String name, String description, double pricePerDay, String brand, String model, int year) {
        this.id = IdFactory.generateUniqueId(); // Generate a unique ID using a factory.
        this.object = new RentableObject(name, description, pricePerDay); // Create and associate a RentableObject.
        this.brand = brand;
        this.model = model;
        this.setYear(year);
    }

    /**
     * Gets the brand of the vehicle.
     *
     * @return The brand of the vehicle.
     */
    public String getBrand() {
        return brand;
    }

    /**
     * Sets the brand of the vehicle.
     *
     * @param brand The brand of the vehicle.
     */
    public void setBrand(String brand) {
        this.brand = brand;
    }

    /**
     * Gets the model of the vehicle.
     *
     * @return The model of the vehicle.
     */
    public String getModel() {
        return model;
    }

    /**
     * Sets the model of the vehicle.
     *
     * @param model The model of the vehicle.
     */
    public void setModel(String model) {
        this.model = model;
    }

    /**
     * Gets the year the vehicle was manufactured.
     *
     * @return The year the vehicle was manufactured.
     */
    public int getYear() {
        return year;
    }

    /**
     * Sets the year for the object.
     *
     * This method allows assigning a new year to the object. Before assigning the value,
     * it checks if the year is valid using the `isValidYear` method. If the year is not valid,
     * an `IllegalYearException` is thrown with a message indicating the valid range of years.
     *
     * @param year The new year to be assigned. It must be within the range of 2000 to 2025 (inclusive).
     * @throws IllegalYearException If the provided year is not within the valid range.
     */
    public void setYear(int year) {
        if(!isValidYear(year)){
            throw new IllegalYearException("El valor debe estar en el rango de 2000 a 2025"); // Return false if the year is not valid
        }
        this.year = year;
    }

    /**
     * Gets the ID of the vehicle.
     *
     * @return The ID of the vehicle.
     */
    public long getId() {
        return id;
    }

    /**
     * Sets the ID of the vehicle.  Typically used by persistence frameworks.
     *
     * @param id The ID of the vehicle.
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * Gets the `RentableObject` associated with this vehicle.
     *
     * @return The `RentableObject`.
     */
    @Override
    public RentableObject getObject() {
        return this.object;
    }

    /**
     * Sets the `RentableObject` associated with this vehicle.
     *
     * @param object The `RentableObject` to associate with this vehicle.
     */
    @Override
    public void setObject(RentableObject object) {
        this.object = object;
    }

    /**
     * Returns a string representation of the vehicle.
     *
     * @return A string representation of the vehicle, including name, description, brand, model, year, and price.
     */
    @Override
    public String toString() {
        return object.getName() + " " + object.getDescription() + " " + brand + " " + model + " " + year + " $" + object.getPricePerDay() + "/day";
    }

    /**
     * Validates if the provided year is within an acceptable range.
     *
     * @param year The year to validate.
     * @return true if the year is valid (between 2000 and the current year), false otherwise.
     */
    public boolean isValidYear(int year){
        // Get the current year
        int currentYear = Year.now().getValue();
        // Define the oldest acceptable year
        int oldestAcceptableYear = 2000;
        // Check if the year is within the valid range
        return year >= oldestAcceptableYear && year <= currentYear;
    }
    /**
     * Creates and returns a deep copy of this {@code Vehicle} object.
     * This method creates a new, independent copy of this {@code Vehicle} instance,
     * including a deep copy of its composite object. This ensures that modifications
     * to the cloned {@code Vehicle} do not affect the original, and vice-versa.  It is
     * crucial for maintaining data integrity and preventing unintended side effects.
     *
     * @return A deep clone of this {@code Vehicle} object.
     * @throws RuntimeException If an error occurs during the cloning process. This
     *                          exception wraps any underlying {@code CloneNotSupportedException}
     *                          and provides a more informative error message, including
     *                          the original exception's message.
     */
    @Override
    public Vehicle clone() {
        try {
            Vehicle clonedVehicle = (Vehicle) super.clone(); // Shallow clone first
            // Deep clone the mutable objects:
            clonedVehicle.object = this.object.clone(); // Clone the 'object' (VehicleDetails or similar)
            return clonedVehicle;
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("Error cloning Vehicle object: " + e.getMessage(), e); // More informative message
        }

    }
}