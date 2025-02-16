package Model.Exceptions;
/**
 * Exception thrown when an email is invalid.
 * This exception is an unchecked exception, extending `IllegalArgumentException`.
 * It indicates that an email address provided is not in a valid format.
 */
public class IllegalEmailException extends IllegalArgumentException {
    /**
     * Constructs a new `IllegalEmailException` with the specified message.
     *
     * @param message The detail message.
     */
    public IllegalEmailException(String message) {
        super(message);
    }
}
