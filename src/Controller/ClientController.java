package Controller;

import DAO.DAO;
import DAO.MemoryClientDAO;
import Model.Entities.Client;
import Model.Entities.ClientType;
import Model.Strategy.IPayment;

public class ClientController{

    private final DAO dao = MemoryClientDAO.getInstance();

    public void newClient(String name, String email, String dni, ClientType type, IPayment method){
        this.dao.save(new Client(name, email, dni,type,method));
    }

    public DAO getDao() {
        return dao;
    }
}
