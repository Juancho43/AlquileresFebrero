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

    public void newClient(String name,
                          String email,
                          String dni,
                          ClientType type,
                          IPayment method) throws Exceptions.DuplicateObjectException,
            Exceptions.IllegalDNIException, Exceptions.IllegalEmailException{
            this.dao.save(new Client(name, email, dni,type,method));
    }


    public DAO<Client> getDao() {
        return dao;
    }
}
