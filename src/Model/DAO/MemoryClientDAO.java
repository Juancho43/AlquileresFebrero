package Model.DAO;

import Model.Exceptions.Exceptions;
import Model.Entities.Clients.Client;

import java.util.ArrayList;
import java.util.List;

/**
 * A memory-based Data Access Object (DAO) for `Client` entities.
 * This class implements the `DAO` interface using an `ArrayList` to store
 * `Client` objects in memory. It provides methods for retrieving,
 * saving, updating, and deleting `Client` entities. It is a singleton.
 */
public class MemoryClientDAO implements DAO<Client> {

    private final List<Client> clientList = new ArrayList<>(); // List to store Client objects.

    private static MemoryClientDAO ClientMemoryDao; // Singleton instance.

    /**
     * Gets the singleton instance of the `MemoryClientDAO`.
     *
     * @return The singleton instance.
     */
    public static MemoryClientDAO getInstance() {
        if (ClientMemoryDao == null) {
            ClientMemoryDao = new MemoryClientDAO();
        }
        return ClientMemoryDao;
    }

    /**
     * Retrieves all `Client` entities.
     *
     * @return A list of all `Client` entities.
     */
    @Override
    public List<Client> getAll() {
        return clientList;
    }

    /**
     * Retrieves a `Client` entity by its ID.
     *
     * @param id The ID of the `Client` entity to retrieve.
     * @return The `Client` entity with the specified ID, or `null` if not found.
     * @throws Exceptions.ObjectNotFoundException If no `Client` is found with the given ID.
     */
    @Override
    public Client getById(long id) {
        try {
            for (Client obj : clientList) {
                if (obj.getId() == id) {
                    return obj; // Return the object if found.
                }
            }
        } catch (Exception e) {
            throw new Exceptions.ObjectNotFoundException("ID de Cliente no encontrado " + id); // Throw the custom exception.
        }
        return null; // Return null if not found after iterating through the whole list.
    }

    /**
     * Saves a new `Client` entity.
     *
     * @param client The `Client` entity to save.
     * @return The saved `Client` entity.
     * @throws Exceptions.DuplicateObjectException If a `Client` with the same DNI already exists.
     */
    @Override
    public Client save(Client client) {
        boolean exists = clientList.stream()
                .anyMatch(existingClient -> existingClient.getDni().equals(client.getDni()));
        if (exists) {
            throw new Exceptions.DuplicateObjectException("DNI " + client.getDni() + " ya existe."); //Throw Duplicate Exception.
        }
        clientList.add(client);
        return client;
    }

    /**
     * Updates an existing `Client` entity by its ID.
     *
     * @param id     The ID of the `Client` entity to update.
     * @param client The updated `Client` entity data.
     * @return The updated `Client` entity.
     * @throws Exceptions.ObjectNotFoundException If no `Client` is found with the given ID.
     */
    @Override
    public Client updateById(long id, Client client) {
        Client existingClient = getById(id);
        if(existingClient == null){
            throw new Exceptions.ObjectNotFoundException("ID de Cliente no encontrado " + id);
        }
        existingClient.setName(client.getName());
        existingClient.setEmail(client.getEmail());
        existingClient.setDni(client.getDni());
        existingClient.setClientType(client.getType());
        existingClient.setPaymentMethod(client.getPaymentMethod());
        return existingClient;

    }

    /**
     * Deletes a `Client` entity by its ID.
     *
     * @param id The ID of the `Client` entity to delete.
     * @return `true` if the `Client` entity was deleted, `false` otherwise.
     */
    @Override
    public boolean deleteById(long id) {
        return clientList.removeIf(obj -> obj.getId() == id);
    }
}