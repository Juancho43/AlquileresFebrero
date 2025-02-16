package Model.Entities.RentableObjects;

import Model.Exceptions.Exceptions;
import Model.Factory.IdFactory;

/**
 * Represents a rentable clothing item.
 * This class stores information about a specific clothing item, including its ID,
 * associated `RentableObject` details (name, description, price), size, and color.
 * It implements the `IRentableObject` interface to provide access to the underlying
 * `RentableObject`.
 */
public class Clothing implements IRentableObject {

    private long id; // The unique ID of the clothing item.
    private RentableObject object; // The RentableObject associated with this clothing item.
    private String size; // The size of the clothing item (e.g., "S", "M", "L").
    private String color; // The color of the clothing item.

    /**
     * Default constructor. Used by frameworks like Hibernate.
     */
    public Clothing() {
    }

    /**
     * Constructor for creating a new Clothing item.
     *
     * @param name        The name of the clothing item (e.g., "T-shirt").
     * @param description A description of the clothing item.
     * @param pricePerDay The price per day for renting the clothing item.
     * @param size        The size of the clothing item.
     * @param color       The color of the clothing item.
     */
    public Clothing(String name, String description, double pricePerDay, String size, String color) {
        this.id = IdFactory.generateUniqueId(); // Generate a unique ID using a factory.
        this.object = new RentableObject(name, description, pricePerDay); // Create and associate a RentableObject.
        this.setSize(size);
        this.color = color;
    }

    /**
     * Gets the size of the clothing item.
     *
     * @return The size of the clothing item.
     */
    public String getSize() {
        return size;
    }


    public void setSize(String size) {
        if(!isValidSize(size)){
            throw new Exceptions.IllegalSizeException("Debe ingresar un talle (s, m, l, xl, xxl, xxxl") ; // Returns false if the size is not valid
        }
        this.size = size;
    }

    /**
     * Gets the color of the clothing item.
     *
     * @return The color of the clothing item.
     */
    public String getColor() {
        return color;
    }

    /**
     * Sets the color of the clothing item.
     *
     * @param color The color of the clothing item.
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * Gets the ID of the clothing item.
     *
     * @return The ID of the clothing item.
     */
    public long getId() {
        return id;
    }

    /**
     * Sets the ID of the clothing item.  Typically used by persistence frameworks.
     *
     * @param id The ID of the clothing item.
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * Gets the `RentableObject` associated with this clothing item.
     *
     * @return The `RentableObject`.
     */
    @Override
    public RentableObject getObject() {
        return object;
    }

    /**
     * Sets the `RentableObject` associated with this clothing item.
     *
     * @param object The `RentableObject` to associate with this clothing item.
     */
    @Override
    public void setObject(RentableObject object) {
        this.object = object;
    }

    /**
     * Returns a string representation of the clothing item.
     *
     * @return A string representation of the clothing item, including name, description, color, size, and price.
     */
    @Override
    public String toString() {
        return object.getName() + " " + object.getDescription() + " " + color + " (" + size + ") $" + object.getPricePerDay() + "/day";
    }

    /**
     * Validates if the provided size is valid.
     *
     * @param size The size to validate as a String.
     * @return true if the size is valid, false otherwise.
     */
    private boolean isValidSize(String size) {
        // Regular expression to validate clothing sizes
        String sizeRegex = "^(s|m|l|x{1,3}l)$"; // s, m, l, xl, xxl, xxxl
        // Converts the size to lowercase and checks if it matches the regular expression
        return size.toLowerCase().matches(sizeRegex);
    }

}