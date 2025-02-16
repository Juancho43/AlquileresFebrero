package Model.Factory;

import Model.Entities.Clients.Client;
import Model.Entities.RentableObjects.IRentableObject;
import Model.Entities.Rents.IRentable;

/**
 * An abstract factory for creating different types of rents.
 * This abstract class defines the common logic for creating rent objects,
 * including setting the rentable object, client, payment method, and rental
 * duration.  It leaves the actual creation of the specific `IRentable`
 * implementation to its concrete subclasses. This follows the Factory
 * Method design pattern.
 */
public abstract class RentFactory {

    /**
     * Creates and configures a rent object.
     * This method performs the common steps involved in creating a rent,
     * regardless of the specific type of rent (e.g., VehicleRent, ClothingRent).
     * It sets the rentable object, client, payment method, and generates the
     * rent for the specified number of days.
     *
     * @param days   The number of days the object is rented for.
     * @param object The `IRentableObject` being rented (e.g., a Vehicle or Clothing item).
     * @param client The `Client` renting the object.
     * @return The newly created and configured `IRentable` object.
     */
    public IRentable rentObject(int days, IRentableObject object, Client client) {
        IRentable rentable = createRent(); // Delegate the creation of the specific IRentable type to the subclass.
        rentable.generateId(); // Generate a unique ID for the rent.
        rentable.setRentableObject(object); // Set the rentable object.
        rentable.setClient(client); // Set the client.
        rentable.setPriceMethod(client.getPaymentMethod()); // Set the payment method from the client's preferred method.
        rentable.generateRent(days); // Generate the rent for the specified number of days.
        return rentable; // Return the created and configured rent object.
    }

    /**
     * Abstract method to create the specific type of rent.
     * This method must be implemented by concrete subclasses of `RentFactory`.
     * Each subclass will be responsible for creating an instance of the specific
     * `IRentable` implementation it is designed to produce (e.g., `VehicleRent`,
     * `ClothingRent`).
     *
     * @return A new instance of the specific `IRentable` implementation.
     */
    public abstract IRentable createRent();
}