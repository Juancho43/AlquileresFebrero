package Model.Exceptions;

/**
 * Exception thrown when an object is not found.
 * This exception is an unchecked exception, extending `RuntimeException`.
 * It indicates that an attempt was made to access an object that does not exist.
 */
public class ObjectNotFoundException extends RuntimeException {
    /**
     * Constructs a new `ObjectNotFoundException` with the specified message.
     *
     * @param message The detail message.
     */
    public ObjectNotFoundException(String message) {
        super(message);
    }
}