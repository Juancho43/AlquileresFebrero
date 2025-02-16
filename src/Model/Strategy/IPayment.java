package Model.Strategy;

import Model.Entities.Clients.ClientType;
import Model.Entities.RentableObjects.IRentableObject;
import Model.Entities.Rents.Rent;

/**
 * An interface defining the contract for payment strategies.
 * This interface specifies the methods that must be implemented by any class
 * that represents a payment strategy.  It defines a method for calculating
 * the final price of a rental, taking into account the client type, rent details,
 * and the rentable object.  It also includes the `equals` and `hashCode`
 * methods, which are essential for proper use of these strategy objects in
 * collections or comparisons.
 */
public interface IPayment {

    /**
     * Calculates the final price of a rental.
     * This method calculates the total price of a rental based on the client type,
     * the rent details (duration, overdue status), and the rentable object's
     * price per day.  It applies any discounts based on the client type and
     * any penalties for overdue rentals.
     *
     * @param type   The `ClientType` of the client.
     * @param rent   The `Rent` object representing the rental period.
     * @param object The `IRentableObject` being rented.
     * @return The final price of the rental.
     */
    double calculate(ClientType type, Rent rent, IRentableObject object);

    /**
     * Checks if this payment strategy is equal to another object.
     *
     * @param obj The object to compare with this payment strategy.
     * @return {@code true} if this payment strategy is equal to the specified object, {@code false} otherwise.
     */
    @Override
    boolean equals(Object obj);

    /**
     * Returns the hash code of this payment strategy.
     *
     * @return The hash code of this payment strategy.
     */
    @Override
    int hashCode();
}
