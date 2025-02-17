package Model.Entities;

/**
 * The {@code Prototype} interface defines a contract for classes that support object cloning.
 * It utilizes the Prototype design pattern, allowing the creation of new objects by copying
 * an existing instance (the prototype) rather than creating them from scratch.  This interface
 * is generic, allowing it to be used with various entity types.
 *
 * @param <E> The type of object that can be cloned.  This type parameter extends {@code Object},
 *            ensuring that it is a class (and not a primitive type).
 */
public interface Prototype<E extends Object> extends Cloneable {

    /**
     * Creates and returns a copy of this object.  The specific type of copy (shallow or deep)
     * is implementation-dependent and should be documented by implementing classes.
     *
     * @return A clone of this object.  The returned object should be of type {@code E}.
     * @throws CloneNotSupportedException If the object cannot be cloned. While {@code Cloneable}
     *                                     is implemented, a specific implementation might
     *                                     throw this exception if cloning is not supported
     *                                     in certain circumstances.
     */
    E clone();
}