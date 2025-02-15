package Controller;

import DAO.DAO;
import DAO.MemoryClientDAO;
import Exceptions.Exceptions;
import Model.Entities.Clients.Client;
import Model.Entities.Clients.ClientType;
import Model.Strategy.IPayment;

import java.util.List;

public class ClientController implements IControllable{

    private final DAO<Client> dao = MemoryClientDAO.getInstance();

    public void newClient(String name, String email, String dni, ClientType type, IPayment method) throws Exceptions.DuplicateObjectException {
            this.dao.save(new Client(name, email, dni,type,method, null));
    }

    public List<Client> getAllClients() {
        return dao.getAll();
    }

    public Client getClientById(long id) {
        return dao.getById(id);
    }

    public Client updateClient(long id, Client updatedClient) {
        return dao.updateById(id, updatedClient);
    }

    public boolean deleteClient(long id) {
        return dao.deleteById(id);
    }

    public DAO<Client> getDao() {
        return dao;
    }
}
