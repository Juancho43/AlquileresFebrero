
package Model.DAO;

import Model.Exceptions.Exceptions;
import Model.Entities.Clients.ClientType;
import java.util.ArrayList;
import java.util.List;

/**
 * A memory-based Data Access Object (DAO) for `ClientType` entities.
 * This class implements the `DAO` interface using an `ArrayList` to store
 * `ClientType` objects in memory. It provides methods for retrieving,
 * saving, updating, and deleting `ClientType` entities.  It is a singleton.
 */
public class MemoryClientTypeDAO implements DAO<ClientType> {

    private final List<ClientType> typeList = new ArrayList<>(); // List to store ClientType objects.

    private static MemoryClientTypeDAO ClientMemoryDao; //Singleton instance.

    /**
     * Gets the singleton instance of the `MemoryClientTypeDAO`.
     *
     * @return The singleton instance.
     */
    public static MemoryClientTypeDAO getInstance() {
        if (ClientMemoryDao == null) {
            ClientMemoryDao = new MemoryClientTypeDAO();
        }
        return ClientMemoryDao;
    }

    /**
     * Retrieves all `ClientType` entities.
     *
     * @return A list of all `ClientType` entities.
     */
    @Override
    public List<ClientType> getAll() {
        return typeList;
    }

    /**
     * Retrieves a `ClientType` entity by its ID.
     *
     * @param id The ID of the `ClientType` entity to retrieve.
     * @return The `ClientType` entity with the specified ID, or `null` if not found.
     * @throws Exceptions.ObjectNotFoundException If no `ClientType` is found with the given ID.
     */
    @Override
    public ClientType getById(long id) {
        try {
            for (ClientType obj : typeList) {
                if (obj.getId() == id) {
                    return obj; // Return the object if found.
                }
            }
        } catch (Exception e) {
            throw new Exceptions.ObjectNotFoundException("ID de Tipo de Cliente no encontrado " + id); // Throw the custom exception.
        }
        return null; // Return null if not found after iterating through the whole list.
    }

    /**
     * Saves a new `ClientType` entity.
     *
     * @param type The `ClientType` entity to save.
     * @return The saved `ClientType` entity.
     */
    @Override
    public ClientType save(ClientType type) {
        typeList.add(type);
        return type;
    }

    /**
     * Updates an existing `ClientType` entity by its ID.
     *
     * @param id   The ID of the `ClientType` entity to update.
     * @param type The updated `ClientType` entity data.
     * @return The updated `ClientType` entity.
     * @throws Exceptions.ObjectNotFoundException If no `ClientType` is found with the given ID.
     */
    @Override
    public ClientType updateById(long id, ClientType type) {
        ClientType existingType = getById(id);
        if(existingType == null){
            throw new Exceptions.ObjectNotFoundException("ID de Tipo de Cliente no encontrado " + id);
        }
        existingType.setDiscount(type.getDiscount());
        existingType.setType(type.getType());
        return existingType;
    }

    /**
     * Deletes a `ClientType` entity by its ID.
     *
     * @param id The ID of the `ClientType` entity to delete.
     * @return `true` if the `ClientType` entity was deleted, `false` otherwise.
     */
    @Override
    public boolean deleteById(long id) {
        return typeList.removeIf(obj -> obj.getId() == id);
    }
}