package Model.DAO;

import Model.Exceptions.Exceptions;
import Model.Entities.RentableObjects.Clothing;

import java.util.ArrayList;
import java.util.List;

/**
 * A memory-based Data Access Object (DAO) for `Clothing` entities.
 * This class implements the `DAO` interface using an `ArrayList` to store
 * `Clothing` objects in memory. It provides methods for retrieving,
 * saving, updating, and deleting `Clothing` entities. It is a singleton.
 */
public class MemoryClothingDAO implements DAO<Clothing> {

    private final List<Clothing> clothingList = new ArrayList<>(); // List to store Clothing objects.

    private static MemoryClothingDAO memoryClothingDAO; // Singleton instance.

    /**
     * Gets the singleton instance of the `MemoryClothingDAO`.
     *
     * @return The singleton instance.
     */
    public static MemoryClothingDAO getInstance() {
        if (memoryClothingDAO == null) {
            memoryClothingDAO = new MemoryClothingDAO();
        }
        return memoryClothingDAO;
    }

    /**
     * Retrieves all `Clothing` entities.
     *
     * @return A list of all `Clothing` entities.
     */
    @Override
    public List<Clothing> getAll() {
        return clothingList;
    }

    /**
     * Retrieves a `Clothing` entity by its ID.
     *
     * @param id The ID of the `Clothing` entity to retrieve.
     * @return The `Clothing` entity with the specified ID, or `null` if not found.
     * @throws Exceptions.ObjectNotFoundException If no `Clothing` is found with the given ID.
     */
    @Override
    public Clothing getById(long id) {
        try {
            for (Clothing obj : clothingList) {
                if (obj.getId() == id) {
                    return obj; // Return the object if found.
                }
            }
        } catch (Exception e) {
            throw new Exceptions.ObjectNotFoundException("ID de Ropa no encontrado " + id); // Throw the custom exception.
        }
        return null; // Return null if not found after iterating through the whole list.
    }

    /**
     * Saves a new `Clothing` entity.
     *
     * @param clothing The `Clothing` entity to save.
     * @return The saved `Clothing` entity.
     */
    @Override
    public Clothing save(Clothing clothing) {
        clothingList.add(clothing);
        return clothing;
    }

    /**
     * Updates an existing `Clothing` entity by its ID.
     *
     * @param id       The ID of the `Clothing` entity to update.
     * @param clothing The updated `Clothing` entity data.
     * @return The updated `Clothing` entity.
     * @throws Exceptions.ObjectNotFoundException If no `Clothing` is found with the given ID.
     */
    @Override
    public Clothing updateById(long id, Clothing clothing) {
        Clothing existingClothing = getById(id);
        if (existingClothing == null) {
            throw new Exceptions.ObjectNotFoundException("ID de Ropa no encontrado " + id);
        }
        existingClothing.setColor(clothing.getColor());
        existingClothing.setSize(clothing.getSize());
        existingClothing.setObject(clothing.getObject());
        return existingClothing;
    }

    /**
     * Deletes a `Clothing` entity by its ID.
     *
     * @param id The ID of the `Clothing` entity to delete.
     * @return `true` if the `Clothing` entity was deleted, `false` otherwise.
     */
    @Override
    public boolean deleteById(long id) {
        return clothingList.removeIf(obj -> obj.getId() == id);
    }
}