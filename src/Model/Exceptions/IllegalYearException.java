package Model.Exceptions;

/**
 * Exception thrown when a year is invalid.
 * This exception is an unchecked exception, extending `IllegalArgumentException`.
 * It indicates that a year provided is not in a valid range.
 */
public class IllegalYearException extends IllegalArgumentException {
    /**
     * Constructs a new `IllegalYearException` with the specified message.
     *
     * @param message The detail message.
     */
    public IllegalYearException(String message) {
        super(message);
    }
}