package Controller;

import DAO.DAO;
import DAO.MemoryClientDAO;
import Model.Entities.Client;
import Model.Entities.ClientType;
import Model.Strategy.IPayment;

import java.util.List;
import java.util.Optional;

public class ClientController{

    private final DAO<Client> dao = MemoryClientDAO.getInstance();

    public void newClient(String name, String email, String dni, ClientType type, IPayment method){
        this.dao.save(new Client(name, email, dni,type,method));
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

    public DAO getDao() {
        return dao;
    }
}
