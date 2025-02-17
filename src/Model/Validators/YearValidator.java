package Model.Validators;

import Model.Exceptions.IllegalYearException;
import java.time.Year;

/**
 * Utility class for validating years.
 */
public class YearValidator {

    private static final int OLDEST_ACCEPTABLE_YEAR = 2000;

    /**
     * Validates a year.
     * Throws an {@link IllegalYearException()} if the year is not valid (i.e., before the oldest acceptable year or after the current year).
     *
     * @param year The year to validate.
     * @throws IllegalYearException() If the year is invalid.
     */
    public static void validateYear(int year) {
        if (!isValidYear(year)) {
            throw new IllegalYearException("Invalid year. Must be between " + OLDEST_ACCEPTABLE_YEAR + " and the current year.");
        }
    }

    /**
     * Checks if the given year is valid.
     * A valid year is between the oldest acceptable year and the current year (inclusive).
     *
     * @param year The year to validate.
     * @return true if the year is valid, false otherwise.
     */
    private static boolean isValidYear(int year) {
        int currentYear = Year.now().getValue();
        return year >= OLDEST_ACCEPTABLE_YEAR && year <= currentYear;
    }


}