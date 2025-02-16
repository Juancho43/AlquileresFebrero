package Model.DAO;

import java.util.List;

/**
 * An interface defining the contract for Data Access Objects (DAOs).
 * This interface specifies the common operations that a DAO must implement
 * for interacting with a data source (e.g., a database, a list in memory).
 * It provides methods for retrieving, saving, updating, and deleting
 * entities of a specific type.
 *
 * @param <E> The type of entity the DAO manages.
 */
public interface DAO<E extends Object> {

    /**
     * Retrieves all entities.
     *
     * @return A list of all entities.
     */
    List<E> getAll();

    /**
     * Retrieves an entity by its ID.
     *
     * @param id The ID of the entity to retrieve.
     * @return The entity with the specified ID, or `null` if not found.
     */
    E getById(long id);

    /**
     * Saves a new entity.
     *
     * @param object The entity to save.
     * @return The saved entity (often with an updated ID or other properties).
     */
    E save(E object);

    /**
     * Updates an existing entity by its ID.
     *
     * @param id     The ID of the entity to update.
     * @param object The updated entity data.
     * @return The updated entity.
     */
    E updateById(long id, E object);

    /**
     * Deletes an entity by its ID.
     *
     * @param id The ID of the entity to delete.
     * @return `true` if the entity was deleted, `false` otherwise.
     */
    boolean deleteById(long id);
}