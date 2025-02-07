package Controller;

import DAO.DAO;
import DAO.MemoryClientTypeDAO;
import Model.Entities.ClientType;

public class ClientTypeController {
    private final DAO dao = MemoryClientTypeDAO.getInstance();

    public void newType(String name, double discount){
        this.dao.save(new ClientType(name,discount));
    }

    public DAO<ClientType> getDao() {
        return dao;
    }
}
