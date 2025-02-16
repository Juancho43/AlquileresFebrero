package Controller;

import Model.DAO.DAO;
import Model.DAO.MemoryClientDAO;
import Model.Exceptions.Exceptions;
import Model.Entities.Clients.Client;
import Model.Entities.Clients.ClientType;
import Model.Strategy.IPayment;

/**
 * A controller for managing `Client` entities.
 * This class provides methods for creating new clients and interacting with
 * the `MemoryClientDAO` to persist client data.  It handles potential exceptions
 * related to data integrity (duplicate DNIs) and data validity (illegal DNI or Email).
 */
public class ClientController implements IControllable {

    private final DAO<Client> dao = MemoryClientDAO.getInstance(); // Data access object for Client.

    /**
     * Creates a new client.
     * This method creates a new `Client` object with the provided information
     * (name, email, DNI, client type, and payment method) and then persists it
     * using the DAO.  It performs validation to ensure data integrity and throws
     * exceptions for invalid or duplicate data.
     *
     * @param name   The client's name.
     * @param email  The client's email address.
     * @param dni    The client's DNI (National Identity Document).
     * @param type   The client's `ClientType`.
     * @param method The client's preferred `IPayment` method.
     * @throws Exceptions.DuplicateObjectException If a client with the given DNI already exists.
     * @throws Exceptions.IllegalDNIException      If the provided DNI is invalid.
     * @throws Exceptions.IllegalEmailException    If the provided email address is invalid.
     */
    public void newClient(String name, String email, String dni, ClientType type, IPayment method)
            throws Exceptions.DuplicateObjectException, Exceptions.IllegalDNIException, Exceptions.IllegalEmailException {

        this.dao.save(new Client(name, email, dni, type, method));
    }

    /**
     * Gets the DAO for `Client` entities.
     *
     * @return The `Client` DAO.
     */
    public DAO<Client> getDao() {
        return dao;
    }
}