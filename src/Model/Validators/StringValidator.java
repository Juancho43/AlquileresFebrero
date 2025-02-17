package Model.Validators;

/**
 * Utility class for validating strings.
 * Provides methods to check if a string contains only letters, numbers, and spaces,
 * and to throw an exception if the string does not meet this criteria.
 */
public class StringValidator {

    /**
     * Validates a string.
     * Throws an {@link IllegalArgumentException} if the string is invalid.
     * A valid string contains only letters, numbers, and spaces.
     *
     * @param str The string to validate.
     * @throws IllegalArgumentException If the string is invalid.
     * @throws NullPointerException If the string is null.
     */
    public static void validateString(String str) {
        if (!isValidString(str)) {
            throw new IllegalArgumentException("The name cannot contain special characters.");
        }
    }

    /**
     * Checks if a string is valid.
     * A valid string contains only letters, numbers, and spaces.
     * This method is private and should only be used internally by the class.
     *
     * @param str The string to validate.
     * @return {@code true} if the string is valid, {@code false} otherwise.
     */
    private static boolean isValidString(String str) {
        // Regular expression to allow only letters, numbers, and spaces
        String regex = "^[a-zA-Z0-9\\s]*$";

        return str != null && str.matches(regex); // Simplified using matches() directly
    }
}