package Model.DAO;

import Model.Entities.Rents.IRentable;

import java.util.ArrayList;
import java.util.List;

/**
 * A memory-based Data Access Object (DAO) for `IRentable` entities.
 * This class implements the `DAO` interface using an `ArrayList` to store
 * `IRentable` objects in memory. It provides methods for retrieving,
 * saving, updating, and deleting `IRentable` entities. It is a singleton.
 */
public class MemoryRentDAO implements DAO<IRentable> {

    private List<IRentable> objectRents = new ArrayList<>(); // List to store IRentable objects.

    private static MemoryRentDAO RentDAO; // Singleton instance.

    /**
     * Gets the singleton instance of the `MemoryRentDAO`.
     *
     * @return The singleton instance.
     */
    public static MemoryRentDAO getInstance() {
        if (RentDAO == null) {
            RentDAO = new MemoryRentDAO();
        }
        return RentDAO;
    }

    /**
     * Retrieves all `IRentable` entities.
     *
     * @return A list of all `IRentable` entities.
     */
    @Override
    public List<IRentable> getAll() {
        return objectRents;
    }

    /**
     * Retrieves an `IRentable` entity by its ID.
     *
     * @param id The ID of the `IRentable` entity to retrieve.
     * @return The `IRentable` entity with the specified ID, or `null` if not found.
     */
    @Override
    public IRentable getById(long id) {
        IRentable rentableObject = null;
        for (IRentable obj : objectRents) {
            if (obj.getId() == id) {
                rentableObject = obj;
                break; // Exit the loop once the object is found.  This is slightly more efficient.
            }
        }
        return rentableObject;
    }

    /**
     * Saves a new `IRentable` entity.
     *
     * @param object The `IRentable` entity to save.
     * @return The saved `IRentable` entity.
     */
    @Override
    public IRentable save(IRentable object) {
        objectRents.add(object);
        return object;
    }

    /**
     * Updates an existing `IRentable` entity by its ID.
     *
     * @param id     The ID of the `IRentable` entity to update.
     * @param object The updated `IRentable` entity data.
     * @return The updated `IRentable` entity.
     */
    @Override
    public IRentable updateById(long id, IRentable object) {
        IRentable existingRentable = getById(id);
        if (existingRentable != null) { //Check if the object exists
            existingRentable.setRentableObject(object.getRentableObject());
            existingRentable.setClient(object.getClient());
            existingRentable.setPriceMethod(object.getMethod());
            return existingRentable;
        }
        return null; // or throw an exception if you want to enforce that the object must exist.
    }

    /**
     * Deletes an `IRentable` entity by its ID.
     *
     * @param id The ID of the `IRentable` entity to delete.
     * @return `true` if the `IRentable` entity was deleted, `false` otherwise.
     */
    @Override
    public boolean deleteById(long id) {
        return objectRents.removeIf(obj -> obj.getId() == id);
    }
}