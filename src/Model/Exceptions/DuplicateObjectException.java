package Model.Exceptions;

/**
 * Exception thrown when a duplicate object is encountered.
 * This exception is an unchecked exception, extending `RuntimeException`.
 * It indicates that an attempt was made to create or store an object that
 * already exists (e.g., a duplicate DNI or ID).
 */
public class DuplicateObjectException extends RuntimeException {
    /**
     * Constructs a new `DuplicateObjectException` with the specified message.
     *
     * @param message The detail message.
     */
    public DuplicateObjectException(String message) {
        super(message);
    }
}