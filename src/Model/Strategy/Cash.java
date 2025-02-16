package Model.Strategy;

import Model.Entities.Clients.ClientType;
import Model.Entities.RentableObjects.IRentableObject;
import Model.Entities.Rents.Rent;
import Model.Entities.Rents.RentState;

/**
 * A payment strategy for cash payments.
 * This class implements the `IPayment` interface and provides a concrete
 * implementation for calculating rental prices when paying with cash.  It
 * calculates the base price, adds any overdue penalties, and then applies
 * any discounts based on the client type.
 */
public class Cash implements IPayment {

    /**
     * Calculates the final price of a rental when paying with cash.
     * This method calculates the base price of the rental, adds a 10% daily
     * penalty for overdue rentals, and then applies any discounts based on
     * the client's type.
     *
     * @param type   The `ClientType` of the client.
     * @param rent   The `Rent` object representing the rental period.
     * @param object The `IRentableObject` being rented.
     * @return The final price of the rental.
     */
    @Override
    public double calculate(ClientType type, Rent rent, IRentableObject object) {
        double finalPrice = object.getObject().getPricePerDay() * rent.calculateDuration();

        if (rent.getState() == RentState.OUTDATED) {
            // If the rent is overdue, add a 10% daily penalty.
            finalPrice += rent.calculateDelayDays() * object.getObject().getPricePerDay() * 0.1;
        }

        finalPrice -= type.getDiscount() * finalPrice; // Apply the client type discount.

        return finalPrice;
    }

    /**
     * Returns a string representation of the cash payment strategy.
     *
     * @return "Cash".
     */
    @Override
    public String toString() {
        return "Cash";
    }

    /**
     * Returns the hash code of this cash payment strategy.
     * This implementation returns a constant value.  In a more complex scenario,
     * you might want to generate a hash code based on relevant properties.
     *
     * @return 1.
     */
    @Override
    public int hashCode() {
        return 1;
    }

    /**
     * Checks if this cash payment strategy is equal to another object.
     * This implementation checks if the other object is also a `Cash` instance.
     *
     * @param obj The object to compare with this cash payment strategy.
     * @return {@code true} if the specified object is a `Cash` object, {@code false} otherwise.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        return true; // All Cash objects are considered equal in this implementation.
    }
}
