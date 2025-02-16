package Model.Entities.RentableObjects;

import Model.Factory.IdFactory;

/**
 * Represents a rentable vehicle.
 * This class stores information about a specific vehicle, including its ID,
 * associated `RentableObject` details (name, description, price), brand, model,
 * and year. It implements the `IRentableObject` interface to provide access
 * to the underlying `RentableObject`.
 */
public class Vehicle implements IRentableObject {

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
        this.year = year;
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
     * Sets the year the vehicle was manufactured.
     *
     * @param year The year the vehicle was manufactured.
     */
    public void setYear(int year) {
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
}