package Model.Validators;

import Model.Exceptions.OutOfRangeNumberException;

/**
 * Utility class for validating discount values.
 * Provides methods to check if a discount is within the valid range (0.0 to 1.0 inclusive)
 * and to throw an exception if the discount is not valid.
 */
public class DiscountValidator {

    /**
     * Validates a discount value.
     * Throws an {@link OutOfRangeNumberException} if the discount is not within the valid range (0.0 to 1.0 inclusive).
     *
     * @param discount The discount value to validate.
     * @throws OutOfRangeNumberException If the discount is outside the valid range.
     * @throws NullPointerException If the discount is null (though a double can't be null directly, this might be relevant in some usage scenarios).
     */
    public static void validateDiscount(double discount) {
        if (!isValidDiscount(discount)) {
            throw new OutOfRangeNumberException("The discount must be between 0.0 and 1.0 (inclusive).");
        }
    }

    /**
     * Checks if a discount value is valid.
     * A valid discount is between 0.0 and 1.0 (inclusive).
     * This method is private and should only be used internally by the class.
     *
     * @param discount The discount value to validate.
     * @return {@code true} if the discount is valid, {@code false} otherwise.
     */
    private static boolean isValidDiscount(double discount) {
        return discount >= 0.0 && discount <= 1.0;
    }
}
