package Model.Exceptions;

public class Exceptions {

    public static class NoObjectSelectedException extends Exception{
        public NoObjectSelectedException(String message){
            super(message);
        }
    }

    public static class IllegalEmailException extends IllegalArgumentException {
        public IllegalEmailException(String message){
            super(message);
        }
    }


    public static class IllegalDNIException extends IllegalArgumentException {
        public IllegalDNIException(String message) {
            super(message);
        }
    }

    public static class ObjectNotFoundException extends RuntimeException {
        public ObjectNotFoundException(String message) {
            super(message);
        }
    }

    public static class DuplicateObjectException extends RuntimeException {
        public DuplicateObjectException(String message) {
            super(message);
        }
    }

}
