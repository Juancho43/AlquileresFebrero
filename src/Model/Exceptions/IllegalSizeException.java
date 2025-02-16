package Model.Exceptions;

/**
 * Exception thrown when a size is invalid.
 * This exception is an unchecked exception, extending `IllegalArgumentException`.
 * It indicates that a size provided is not in a valid format.
 */
public class IllegalSizeException extends IllegalArgumentException {
    /**
     * Constructs a new `IllegalSizeException` with the specified message.
     *
     * @param message The detail message.
     */
    public IllegalSizeException(String message) {
        super(message);
    }
}