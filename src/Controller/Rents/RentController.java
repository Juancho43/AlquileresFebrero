package Controller.Rents;

import Controller.IControllable;
import DAO.MemoryRentDAO;
import DAO.DAO;
import Model.Entities.Client;
import Model.Entities.RentableObjects.IRentableObject;
import Model.Entities.RentableObjects.RentableObject;
import Model.Entities.Rents.IRentable;
import Model.Entities.Rents.Rent;
import Model.Factory.RentFactory;

import java.util.ArrayList;
import java.util.List;


public class RentController implements IControllable {

    private DAO<IRentable> dao = MemoryRentDAO.getInstance();
    private double totalEarnings;
    private RentFactory rentFactory;

    public void newRent(int days, IRentableObject object, Client client) {
        this.dao.save(rentFactory.rentObject(days, object, client));
    }


    public void closeRent(long id){

    }



    public List<Rent> getAllCloseRents(){
        List<Rent> closeRents = new ArrayList<>();

        return closeRents;
    }

    public double getTotalEarnings() {
        return totalEarnings;
    }

    public DAO<IRentable> getDao() {
        return dao;
    }

    public RentFactory getRentFactory() {
        return rentFactory;
    }

    public void setRentFactory(RentFactory rentFactory) {
        this.rentFactory = rentFactory;
    }
}
