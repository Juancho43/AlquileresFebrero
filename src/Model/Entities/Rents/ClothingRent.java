package Model.Entities.Rents;

import Model.Entities.ICloneable;
import Model.Entities.RentableObjects.Clothing;
import Model.Factory.IdFactory;
import Model.Strategy.IPayment;

import java.time.LocalDate;

/**
 * Represents a rental transaction specifically for clothing items.
 * This class extends `ObjectRent` and implements the `IRentable` interface for `Clothing` objects.
 * It manages the rental of a specific clothing item, including price calculation, rent generation,
 * rent closing, and associating the clothing item with the rent.
 * It also implements the {@code ICloneable} interface for cloning.
 */
public class ClothingRent extends ObjectRent implements IRentable<Clothing>, ICloneable<IRentable> {

    private Clothing clothing; // The Clothing object being rented.

    /**
     * Gets the price per day for renting the clothing item.
     *
     * @return The price per day for renting the clothing item.
     */
    @Override
    public double getPricePerDay() {
        return this.clothing.getObject().getPricePerDay();
    }

    /**
     * Gets a description of the clothing rent transaction.
     *
     * @return A description of the clothing rent transaction, including clothing item, rent, client, and payment method information.
     */
    @Override
    public String getDescription() {
        return "Clothing: " + clothing + ", Rent: " + rent + ", Client: " + client + ", Payment Method: " + priceMethod; // Improved description
    }

    /**
     * Calculates the total earnings for the rent.
     *
     * @return The total earnings for the rent, calculated using the client type, rent duration, and clothing item information.
     */
    @Override
    public double getEarning() {
        return this.priceMethod.calculate(this.client.getType(), this.rent, this.clothing);
    }

    /**
     * Generates a new rent for the clothing item. Sets the clothing item's availability to false.
     *
     * @param days The number of days the clothing item is rented for.
     */
    @Override
    public void generateRent(int days) {
        this.clothing.getObject().setAvailable(false); // Mark clothing as unavailable.
        openRent(days); // Create the Rent object.
    }

    /**
     * Closes the rent for the clothing item. Sets the clothing item's availability to true.  Calculates and sets the final earning.
     *
     * @param date The date the rent was closed.
     * @return
     */
    @Override
    public IRentable closeRent(LocalDate date) {
        this.clothing.getObject().setAvailable(true); // Mark clothing as available.
        this.rent.closeRent(date); // Close the Rent object.
        this.rent.setEarning(this.getEarning()); // Calculate and set earnings *after* closing.

        return this.clone();
    }

    /**
     * Sets the rentable object (Clothing) for this rental transaction.
     *
     * @param object The Clothing object to be rented.
     */
    @Override
    public void setRentableObject(Clothing object) {
        this.clothing = object;
    }

    /**
     * Gets the payment method used for this rental transaction.
     *
     * @return The payment method used for this rental transaction.
     */
    @Override
    public IPayment getMethod() {
        return this.priceMethod;
    }

    /**
     * Gets the Clothing object being rented.
     *
     * @return The Clothing object being rented.
     */
    @Override
    public Clothing getRentableObject() {
        return this.clothing;
    }

    /**
     * Generates a unique ID for this rental transaction.
     */
    @Override
    public void generateId() {
        setId(IdFactory.generateUniqueId());
    }

    /**
     * Returns a string representation of the clothing rent.
     *
     * @return A string representation of the clothing rent (rent details and client name).
     */
    @Override
    public String toString() {
        return "Rent: " + rent + ", Client: " + client.getName(); // Improved toString()
    }

    /**
     * Creates and returns a deep copy of this {@code ClothingRent} object.
     * This method creates a new, independent copy of this {@code ClothingRent} instance,
     * including deep copies of all its composite objects (rent, client, and clothing).
     * This ensures that modifications to the cloned object do not affect the original,
     * and vice-versa.  It is crucial for maintaining data integrity and preventing
     * unintended side effects.
     *
     * @return A deep clone of this {@code ClothingRent} object.
     * @throws RuntimeException If an error occurs during the cloning process. This
     *                          exception wraps any underlying {@code CloneNotSupportedException}
     *                          and provides a more informative error message, including
     *                          the original exception's message.
     */
    @Override
    public IRentable clone() {
        try {
            ClothingRent clonedRent = (ClothingRent) super.clone(); // Clone shallow parts.
            clonedRent.priceMethod = this.priceMethod;             // These are likely immutable.
            clonedRent.rent = this.rent.clone();                 // Clone Rent deeply.
            clonedRent.client = this.client.clone();             // Clone Client deeply.
            clonedRent.clothing = this.clothing.clone();         // Clone Clothing deeply.
            return clonedRent;
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("Error cloning ClothingRent object: " + e.getMessage(), e);
        }
    }
}