package Model.Validators;

import Model.Exceptions.OutOfRangeNumberException;

/**
 * Utility class for validating price per day values.
 */
public class PriceValidator {

    private static final double MIN_PRICE = 0.01;
    private static final double MAX_PRICE = 1000000.00;

    /**
     * Validates a price per day.
     * Throws an {@link OutOfRangeNumberException} if the price is not valid (i.e., not positive or outside the allowed range).
     *
     * @param pricePerDay The price per day to validate.
     * @throws OutOfRangeNumberException If the price is invalid.
     * @throws NullPointerException If the price is null (if you are receiving a Double object).
     */
    public static void validatePrice(double pricePerDay) {
        if (!isValidPrice(pricePerDay)) {
            throw new OutOfRangeNumberException("The price per day must be between " + MIN_PRICE + " and " + MAX_PRICE + ".");
        }
    }

    /**
     * Checks if the given price per day falls within the valid range.
     *
     * @param pricePerDay The price per day to validate.
     * @return true if the price is within the allowed range, false otherwise.
     */
    private static boolean isWithRange(double pricePerDay) {
        return pricePerDay >= MIN_PRICE && pricePerDay <= MAX_PRICE;
    }

    /**
     * Checks if the given price per day is a positive value.
     *
     * @param pricePerDay The price per day to validate.
     * @return true if the price is greater than zero, false otherwise.
     */
    private static boolean isPositive(double pricePerDay) {
        return pricePerDay > 0;
    }

    /**
     * Validates if the given price per day is both positive and within the allowed range.
     *
     * @param pricePerDay The price per day to validate.
     * @return true if the price meets both conditions, false otherwise.
     */
    private static boolean isValidPrice(double pricePerDay) {
        return isWithRange(pricePerDay) && isPositive(pricePerDay);
    }

}