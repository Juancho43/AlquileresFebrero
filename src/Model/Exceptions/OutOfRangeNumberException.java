package Model.Exceptions;

/**
 * Exception thrown when a number is out of range.
 * This exception is an unchecked exception, extending `IllegalArgumentException`.
 * It indicates that a number provided is not within the expected range.
 */
public class OutOfRangeNumberException extends IllegalArgumentException {
    /**
     * Constructs a new `OutOfRangeNumberException` with the specified message.
     *
     * @param message The detail message.
     */
    public OutOfRangeNumberException(String message) {
        super(message);
    }
}