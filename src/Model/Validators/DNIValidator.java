package Model.Validators;

import Model.Exceptions.IllegalDNIException;

/**
 * Utility class for validating DNI (Documento Nacional de Identidad - National Identity Document) numbers.
 */
public class DNIValidator {

    /**
     * Validates a DNI number.
     * Throws an {@link IllegalDNIException} if the DNI is invalid.
     * A valid DNI consists of 7 to 10 numeric digits.
     *
     * @param dni The DNI number to validate.
     * @throws IllegalDNIException If the DNI is invalid.
     * @throws NullPointerException If the DNI is null.
     */
    public static void validateDNI(String dni) {
        if (!isValidDNI(dni)) {
            throw new IllegalDNIException("The DNI must have between 7 and 10 numeric digits.");
        }
    }

    /**
     * Checks if a DNI number is valid.
     * This method is private and should only be used internally by the class.
     *
     * @param dni The DNI number to validate.
     * @return {@code true} if the DNI is valid, {@code false} otherwise.
     */
    private static boolean isValidDNI(String dni) {
        String dniRegex = "^[0-9]{7,10}$";
        return dni != null && dni.matches(dniRegex);
    }
}