package Controller;

import Model.DAO.DAO;
import Model.DAO.MemoryClientTypeDAO;
import Model.Entities.Clients.ClientType;

import java.util.List;

/**
 * A controller for managing `ClientType` entities.
 * This class provides methods for creating new client types and interacting
 * with the `MemoryClientTypeDAO` to persist client type data.
 */
public class ClientTypeController implements IControllable {

    private final DAO<ClientType> dao = MemoryClientTypeDAO.getInstance(); // Data access object for ClientType.

    /**
     * Creates a new client type.
     * This method creates a new `ClientType` object with the provided information
     * (name and discount rate) and then persists it using the DAO.
     *
     * @param name     The name of the client type.
     * @param discount The discount rate associated with this client type.
     */
    public void newType(String name, double discount) {
        this.dao.save(new ClientType(name, discount));
    }

    /**
     * Gets the DAO for `ClientType` entities.
     *
     * @return The `ClientType` DAO.
     */
    public DAO<ClientType> getDao() {
        return dao;
    }
}