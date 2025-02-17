package Model.Validators;

import Model.Exceptions.IllegalEmailException;

/**
 * Utility class for validating email addresses.
 */
public class EmailValidator {

    /**
     * Validates an email address.
     * Throws an {@link IllegalEmailException} if the email is invalid.
     *
     * @param email The email address to validate.
     * @throws IllegalEmailException If the email is invalid.
     * @throws NullPointerException If the email is null.
     */
    public static void validateEmail(String email) {
        if (!isValidEmail(email)) {
            throw new IllegalEmailException("The email is not valid.");
        }
    }

    /**
     * Checks if an email address is valid.
     * This method is private and should only be used internally by the class.
     *
     * @param email The email address to validate.
     * @return {@code true} if the email is valid, {@code false} otherwise.
     */
    private static boolean isValidEmail(String email) {
        String emailRegex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$";
        return email != null && email.matches(emailRegex);
    }
}