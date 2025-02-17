
package Model.Strategy;

import Model.Entities.Clients.ClientType;
import Model.Entities.RentableObjects.IRentableObject;
import Model.Entities.Rents.Rent;
import Model.Entities.Rents.RentState;

/**
 * A payment strategy for credit card payments.
 * This class implements the `IPayment` interface and provides a concrete
 * implementation for calculating rental prices when paying with a credit card.
 * It calculates the base price with a 10% surcharge, adds any overdue penalties,
 * and then applies any discounts based on the client type.
 */
public class CreditCard implements IPayment{

    /**
     * Calculates the final price of a rental when paying with a credit card.
     * This method calculates the base price of the rental with a 10% surcharge,
     * adds a 15% daily penalty for overdue rentals, and then applies any discounts
     * based on the client's type.
     *
     * @param type   The `ClientType` of the client.
     * @param rent   The `Rent` object representing the rental period.
     * @param object The `IRentableObject` being rented.
     * @return The final price of the rental.
     */
    @Override
    public double calculate(ClientType type, Rent rent, IRentableObject object) {
        double finalPrice = object.getObject().getPricePerDay() * rent.calculateDuration() * ((double) 110 / 100); // 10% surcharge

        if (rent.getState() == RentState.OUTDATED) {
            // If the rent is overdue, add a 15% daily penalty.
            finalPrice += rent.calculateDelayDays() * object.getObject().getPricePerDay() * 0.15;
        }

        finalPrice -= type.getDiscount() * finalPrice; // Apply the client type discount.

        return finalPrice;
    }

    /**
     * Returns a string representation of the credit card payment strategy.
     *
     * @return "CreditCard".
     */
    @Override
    public String toString() {
        return "CreditCard";
    }

    /**
     * Checks if this credit card payment strategy is equal to another object.
     * This implementation checks if the other object is also a `CreditCard` instance.
     *
     * @param obj The object to compare with this credit card payment strategy.
     * @return {@code true} if the specified object is a `CreditCard` object, {@code false} otherwise.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        return true; // All CreditCard objects are considered equal in this implementation.
    }

    /**
     * Returns the hash code of this credit card payment strategy.
     * This implementation returns a constant value. In a more complex scenario,
     * you might want to generate a hash code based on relevant properties.
     *
     * @return 2.
     */
    @Override
    public int hashCode() {
        return 2;
    }


}