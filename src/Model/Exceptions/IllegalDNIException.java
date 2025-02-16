package Model.Exceptions;
/**
 * Exception thrown when a DNI (National Identity Document) is invalid.
 * This exception is an unchecked exception, extending `IllegalArgumentException`.
 * It indicates that a DNI provided is not in a valid format.
 */
public class IllegalDNIException extends IllegalArgumentException{
    /**
     * Constructs a new `IllegalDNIException` with the specified message.
     *
     * @param message The detail message.
     */
    public IllegalDNIException(String message) {
        super(message);
    }
}
