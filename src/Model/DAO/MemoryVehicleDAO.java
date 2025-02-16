package Model.DAO;

import Model.Entities.RentableObjects.Vehicle;
import Model.Exceptions.ObjectNotFoundException;

import java.util.ArrayList;
import java.util.List;

/**
 * A memory-based Data Access Object (DAO) for `Vehicle` entities.
 * This class implements the `DAO` interface using an `ArrayList` to store
 * `Vehicle` objects in memory. It provides methods for retrieving,
 * saving, updating, and deleting `Vehicle` entities. It is a singleton.
 */
public class MemoryVehicleDAO implements DAO<Vehicle> {

    private final List<Vehicle> vehicleList = new ArrayList<>(); // List to store Vehicle objects.

    private static MemoryVehicleDAO MemoryVehicleDao; // Singleton instance.

    /**
     * Gets the singleton instance of the `MemoryVehicleDAO`.
     *
     * @return The singleton instance.
     */
    public static MemoryVehicleDAO getInstance() {
        if (MemoryVehicleDao == null) {
            MemoryVehicleDao = new MemoryVehicleDAO();
        }
        return MemoryVehicleDao;
    }

    /**
     * Retrieves all `Vehicle` entities.
     *
     * @return A list of all `Vehicle` entities.
     */
    @Override
    public List<Vehicle> getAll() {
        return vehicleList;
    }

    /**
     * Retrieves a `Vehicle` entity by its ID.
     *
     * @param id The ID of the `Vehicle` entity to retrieve.
     * @return The `Vehicle` entity with the specified ID, or `null` if not found.
     * @throws ObjectNotFoundException If no `Vehicle` is found with the given ID.
     */
    @Override
    public Vehicle getById(long id) {
        try {
            for (Vehicle obj : vehicleList) {
                if (obj.getId() == id) {
                    return obj; // Return the object if found.
                }
            }
        } catch (Exception e) {
            throw new ObjectNotFoundException("ID de Vehiculo no encontrado " + id); // Throw the custom exception.
        }
        return null; // Return null if not found after iterating through the whole list.
    }

    /**
     * Saves a new `Vehicle` entity.
     *
     * @param object The `Vehicle` entity to save.
     * @return The saved `Vehicle` entity.
     */
    @Override
    public Vehicle save(Vehicle object) {
        vehicleList.add(object);
        return object;
    }

    /**
     * Updates an existing `Vehicle` entity by its ID.
     *
     * @param id     The ID of the `Vehicle` entity to update.
     * @param object The updated `Vehicle` entity data.
     * @return The updated `Vehicle` entity.
     * @throws ObjectNotFoundException If no `Vehicle` is found with the given ID.
     */
    @Override
    public Vehicle updateById(long id, Vehicle object) {
        Vehicle existingVehicle = getById(id);
        if (existingVehicle == null) {
            throw new ObjectNotFoundException("ID de Vehiculo no encontrado " + id);
        }
        existingVehicle.setBrand(object.getBrand());
        existingVehicle.setModel(object.getModel());
        existingVehicle.setYear(object.getYear());
        existingVehicle.setObject(object.getObject());
        return existingVehicle;
    }

    /**
     * Deletes a `Vehicle` entity by its ID.
     *
     * @param id The ID of the `Vehicle` entity to delete.
     * @return `true` if the `Vehicle` entity was deleted, `false` otherwise.
     */
    @Override
    public boolean deleteById(long id) {
        return vehicleList.removeIf(obj -> obj.getId() == id);
    }
}