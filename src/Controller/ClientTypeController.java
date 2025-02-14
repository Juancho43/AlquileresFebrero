package Controller;

import DAO.DAO;
import DAO.MemoryClientTypeDAO;
import Model.Entities.Client;
import Model.Entities.ClientType;

import java.util.List;

public class ClientTypeController implements IControllable{
    private final DAO<ClientType>dao = MemoryClientTypeDAO.getInstance();

    public void newType(String name, double discount){
        this.dao.save(new ClientType(name,discount));
    }

    public List<ClientType> getAllClientsTypes() {
        return dao.getAll();
    }

    public ClientType getClientTypeById(long id) {
        return dao.getById(id);
    }

    public ClientType updateClientType(long id, ClientType updatedClientType) {
        return dao.updateById(id, updatedClientType);
    }

    public boolean deleteClientType(long id) {
        return dao.deleteById(id);
    }

    public DAO<ClientType> getDao() {
        return dao;
    }
}
