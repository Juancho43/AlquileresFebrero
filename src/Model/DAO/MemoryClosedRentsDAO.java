package Model.DAO;

import Model.Entities.Rents.IRentable;
import Model.Exceptions.ObjectNotFoundException;

import java.util.ArrayList;
import java.util.List;

/**
 * The {@code MemoryClosedRentsDAO} class implements the {@code DAO} interface
 * for managing closed rental transactions in memory.  It uses a singleton
 * pattern to ensure only one instance of the DAO exists.  This class provides
 * basic CRUD (Create, Read, Update, Delete) operations for {@code IRentable} objects
 * representing closed rentals.
 */
public class MemoryClosedRentsDAO implements DAO<IRentable> {

    private List<IRentable> closedRents = new ArrayList<>(); // Stores the closed rents.

    private static MemoryClosedRentsDAO memoryClosedRentsDAO; // Singleton instance.

    /**
     * Gets the singleton instance of the {@code MemoryClosedRentsDAO}.
     *
     * @return The singleton instance.
     */
    public static MemoryClosedRentsDAO getInstance() {
        if (memoryClosedRentsDAO == null) {
            memoryClosedRentsDAO = new MemoryClosedRentsDAO();
        }
        return memoryClosedRentsDAO;
    }

    /**
     * Retrieves all closed rental transactions.
     *
     * @return A list of all {@code IRentable} objects representing closed rents.
     */
    @Override
    public List<IRentable> getAll() {
        return closedRents;
    }

    /**
     * Retrieves a closed rental transaction by its ID.
     *
     * @param id The ID of the closed rental transaction to retrieve.
     * @return The {@code IRentable} object representing the closed rent, or {@code null}
     *         if no such rent is found.
     * @throws ObjectNotFoundException If a rent with the specified ID is not found.
     */
    @Override
    public IRentable getById(long id) {
        for (IRentable obj : closedRents) {
            if (obj.getId() == id) {
                return obj; // Return the object if found.
            }
        }
        throw new ObjectNotFoundException("Rent ID not found: " + id); // Throw exception if not found.
    }

    /**
     * Saves a new closed rental transaction.
     *
     * @param object The {@code IRentable} object to save.
     * @return The saved {@code IRentable} object.
     */
    @Override
    public IRentable save(IRentable object) {
        closedRents.add(object);
        return object;
    }

    /**
     * Updates an existing closed rental transaction by its ID.  This operation
     * is currently not implemented and will throw an exception.
     *
     * @param id     The ID of the closed rental transaction to update.
     * @param object The updated {@code IRentable} object.
     * @return The updated {@code IRentable} object.
     * @throws UnsupportedOperationException This method is not yet implemented.
     */
    @Override
    public IRentable updateById(long id, IRentable object) {
        throw new UnsupportedOperationException("Update operation not available for closed rents.");
    }

    /**
     * Deletes a closed rental transaction by its ID.
     *
     * @param id The ID of the closed rental transaction to delete.
     * @return {@code true} if the closed rental transaction was successfully deleted,
     *         {@code false} otherwise.
     */
    @Override
    public boolean deleteById(long id) {
        return closedRents.removeIf(obj -> obj.getId() == id);
    }
}