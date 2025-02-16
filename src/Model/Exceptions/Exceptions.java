package Model.Exceptions;

/**
 * A collection of custom exceptions used in the application.
 * This class defines several custom exception classes that are used to indicate
 * specific error conditions within the application.  Grouping them within
 * a single class like this can help with organization.  Note that some of these
 * are checked exceptions (extending `Exception`), while others are unchecked
 * exceptions (extending `RuntimeException` or `IllegalArgumentException`).
 */
public class Exceptions {

    /**
     * Exception thrown when no object is selected.
     * This exception is a checked exception, meaning it must be either caught
     * or declared in the `throws` clause of the method that might throw it.
     */
    public static class NoObjectSelectedException extends Exception {
        /**
         * Constructs a new `NoObjectSelectedException` with the specified message.
         *
         * @param message The detail message.
         */
        public NoObjectSelectedException(String message) {
            super(message);
        }
    }

    /**
     * Exception thrown when an email is invalid.
     * This exception is an unchecked exception, extending `IllegalArgumentException`.
     * It indicates that an email address provided is not in a valid format.
     */
    public static class IllegalEmailException extends IllegalArgumentException {
        /**
         * Constructs a new `IllegalEmailException` with the specified message.
         *
         * @param message The detail message.
         */
        public IllegalEmailException(String message) {
            super(message);
        }
    }

    /**
     * Exception thrown when a DNI (National Identity Document) is invalid.
     * This exception is an unchecked exception, extending `IllegalArgumentException`.
     * It indicates that a DNI provided is not in a valid format.
     */
    public static class IllegalDNIException extends IllegalArgumentException {
        /**
         * Constructs a new `IllegalDNIException` with the specified message.
         *
         * @param message The detail message.
         */
        public IllegalDNIException(String message) {
            super(message);
        }
    }

    public static class IllegalSizeException extends IllegalArgumentException {
        public IllegalSizeException(String message) {super(message);
        }
    }

    public static class IllegalYearException extends IllegalArgumentException {
        public IllegalYearException(String message) {super(message);
        }
    }

    public static class OutOfRangeNumberException extends IllegalArgumentException {
        public OutOfRangeNumberException(String message) {super(message);
        }
    }


    /**
     * Exception thrown when an object is not found.
     * This exception is an unchecked exception, extending `RuntimeException`.
     * It indicates that an attempt was made to access an object that does not exist.
     */
    public static class ObjectNotFoundException extends RuntimeException {
        /**
         * Constructs a new `ObjectNotFoundException` with the specified message.
         *
         * @param message The detail message.
         */
        public ObjectNotFoundException(String message) {
            super(message);
        }
    }

    /**
     * Exception thrown when a duplicate object is encountered.
     * This exception is an unchecked exception, extending `RuntimeException`.
     * It indicates that an attempt was made to create or store an object that
     * already exists (e.g., a duplicate DNI or ID).
     */
    public static class DuplicateObjectException extends RuntimeException {
        /**
         * Constructs a new `DuplicateObjectException` with the specified message.
         *
         * @param message The detail message.
         */
        public DuplicateObjectException(String message) {
            super(message);
        }
    }
}