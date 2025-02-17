package Model.Validators;

import Model.Exceptions.IllegalSizeException; // Create this custom exception

/**
 * Utility class for validating clothing sizes.
 */
public class SizeValidator {

    /**
     * Validates a clothing size.
     * Throws an {@link IllegalSizeException()} if the size is not valid (i.e., not s, m, l, xl, xxl, or xxxl).
     *
     * @param size The clothing size to validate.
     * @throws IllegalSizeException() If the size is invalid.
     * @throws NullPointerException If the size is null.
     */
    public static void validateSize(String size) {
        if (size == null || !isValidSize(size)) { // Check for null explicitly
            throw new IllegalSizeException("Invalid clothing size.  Valid sizes are s, m, l, xl, xxl, and xxxl.");
        }
    }

    /**
     * Checks if the given clothing size is valid.
     * Valid sizes are s, m, l, xl, xxl, and xxxl.
     *
     * @param size The clothing size to validate.
     * @return true if the size is valid, false otherwise.
     */
    private static boolean isValidSize(String size) {
        String sizeRegex = "^(s|m|l|x{1,3}l)$"; // s, m, l, xl, xxl, xxxl
        return size.toLowerCase().matches(sizeRegex);
    }


}