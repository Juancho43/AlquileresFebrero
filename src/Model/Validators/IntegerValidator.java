package Model.Validators;

import Model.Exceptions.OutOfRangeNumberException;

/**
 * Utility class for validating integers.
 * Provides methods to check if an integer is positive and has no decimals,
 * and to throw an exception if the number does not meet this criteria.
 */
public class IntegerValidator {

    /**
     * Validates an integer.
     * Throws an {@link OutOfRangeNumberException} if the number is invalid.
     * A valid integer is one that is greater than zero and has no decimals.
     *
     * @param number The integer to validate.
     * @throws OutOfRangeNumberException If the number is invalid.
     */
    public static void validateInteger(int number) {
        if (!isValidInteger(number)) {
            throw new OutOfRangeNumberException("The number must be a positive integer.");
        }
    }

    /**
     * Checks if the given number is a valid positive integer.
     * A valid positive integer is one that is greater than zero and has no decimals.
     *
     * @param number The number to validate.
     * @return {@code true} if the number is a valid positive integer, {@code false} otherwise.
     */
    private static boolean isValidInteger(int number) {
        return number > 0;
    }

}