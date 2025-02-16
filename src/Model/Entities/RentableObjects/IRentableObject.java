package Model.Entities.RentableObjects;

/**
 * An interface defining the contract for objects that can be rented.
 * This interface provides methods for accessing and setting the underlying
 * `RentableObject` associated with a specific rentable item (e.g., a specific
 * instance of a Vehicle or Clothing).  It acts as a bridge between the
 * concrete rentable item and its generic representation.
 */
public interface IRentableObject {

    /**
     * Gets the `RentableObject` associated with this rentable item.
     *
     * @return The `RentableObject`.
     */
    RentableObject getObject();

    /**
     * Sets the `RentableObject` associated with this rentable item.
     *
     * @param object The `RentableObject` to set.
     */
    void setObject(RentableObject object);
}