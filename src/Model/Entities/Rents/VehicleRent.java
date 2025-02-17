package Model.Entities.Rents;

import Model.Entities.ICloneable;
import Model.Entities.RentableObjects.Vehicle;
import Model.Factory.IdFactory;
import Model.Strategy.IPayment;

import java.time.LocalDate;

/**
 * Represents a rental transaction specifically for vehicles.
 * This class extends `ObjectRent` and implements the `IRentable` interface for `Vehicle` objects.
 * It manages the rental of a specific vehicle, including price calculation, rent generation,
 * rent closing, and associating the vehicle with the rent.
 * It also implements the {@code ICloneable} interface for cloning.
 */
public class VehicleRent extends ObjectRent implements IRentable<Vehicle>, ICloneable<IRentable> {

    private Vehicle vehicle; // The Vehicle object being rented.

    /**
     * Gets the price per day for renting the vehicle.
     *
     * @return The price per day for renting the vehicle.
     */
    @Override
    public double getPricePerDay() {
        return this.vehicle.getObject().getPricePerDay();
    }

    /**
     * Gets a description of the vehicle rent transaction.
     *
     * @return A description of the vehicle rent transaction, including vehicle, rent, client, and payment method information.
     */
    @Override
    public String getDescription() {
        return "Vehicle: " + vehicle + ", Rent: " + rent + ", Client: " + client + ", Payment Method: " + priceMethod; // Improved description
    }

    /**
     * Calculates the total earnings for the rent.
     *
     * @return The total earnings for the rent, calculated using the client type, rent duration, and vehicle information.
     */
    @Override
    public double getEarning() {
        return this.priceMethod.calculate(this.client.getType(), this.rent, this.vehicle);
    }

    /**
     * Generates a new rent for the vehicle.  Sets the vehicle's availability to false.
     *
     * @param days The number of days the vehicle is rented for.
     */
    @Override
    public void generateRent(int days) {
        this.vehicle.getObject().setAvailable(false); // Mark vehicle as unavailable.
        openRent(days); // Create the Rent object.
    }

    /**
     * Closes the rent for the vehicle. Sets the vehicle's availability to true.  Calculates and sets the final earning.
     *
     * @param date The date the rent was closed.
     * @return
     */
    @Override
    public IRentable closeRent(LocalDate date) {
        this.vehicle.getObject().setAvailable(true); // Mark vehicle as available.
        this.rent.closeRent(date); // Close the Rent object.
        this.rent.setEarning(this.getEarning()); // Calculate and set earnings *after* closing.
        return this.clone();
    }

    /**
     * Sets the rentable object (Vehicle) for this rental transaction.
     *
     * @param object The Vehicle object to be rented.
     */
    @Override
    public void setRentableObject(Vehicle object) {
        this.vehicle = object;
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
     * Gets the Vehicle object being rented.
     *
     * @return The Vehicle object being rented.
     */
    @Override
    public Vehicle getRentableObject() {
        return this.vehicle;
    }

    /**
     * Generates a unique ID for this rental transaction.
     */
    @Override
    public void generateId() {
        setId(IdFactory.generateUniqueId());
    }

    /**
     * Creates and returns a deep copy of this {@code VehicleRent} object.
     * This method ensures that all nested objects (rent, client, vehicle) are also
     * cloned, creating a completely independent copy.  It is crucial for maintaining
     * data integrity and preventing unintended side effects when modifying the cloned
     * object.
     *
     * @return A deep clone of this {@code VehicleRent} object.
     * @throws RuntimeException If an error occurs during the cloning process.  This
     *                          exception wraps any underlying {@code CloneNotSupportedException}
     *                          and provides a more informative error message.
     */
    @Override
    public IRentable clone() {
        try {
            VehicleRent clonedRent = (VehicleRent) super.clone(); // Shallow clone first

            // Deep clone the mutable objects:
            clonedRent.priceMethod = this.priceMethod; // Assuming IPayment implementations are immutable. If not, clone them too.
            clonedRent.rent = this.rent.clone();         // Clone the Rent object.
            clonedRent.client = this.client.clone();     // Clone the Client object.
            clonedRent.vehicle = this.vehicle.clone();   // Clone the Vehicle object.

            return clonedRent;
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("Error cloning VehicleRent object: " + e.getMessage(), e); // More informative message
        }
    }

    /**
     * Returns a string representation of the vehicle rent.
     *
     * @return A string representation of the vehicle rent (rent details and client name).
     */
    @Override
    public String toString() {
        return "Rent: " + rent + ", Client: " + client.getName(); // Improved toString()
    }
}