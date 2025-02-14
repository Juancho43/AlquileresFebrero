package Controller.Rents;

import Controller.IControllable;
import DAO.MemoryRentDAO;
import DAO.DAO;
import Model.Entities.Clients.Client;
import Model.Entities.RentableObjects.IRentableObject;
import Model.Entities.Rents.IRentable;
import Model.Enums.RentState;
import Model.Factory.RentFactory;

import java.util.List;
import java.util.stream.Collectors;


public class RentController implements IControllable {

    private DAO<IRentable> dao = MemoryRentDAO.getInstance();
    private double totalEarnings;
    private RentFactory rentFactory;

    public void newRent(int days, IRentableObject object, Client client) {
        this.dao.save(rentFactory.rentObject(days, object, client));
    }

    public List<IRentable> getAllStartedRents(){
        return  getDao().getAll().stream().filter(rent -> rent.getRent().getState() == RentState.STARTED).collect(Collectors.toList());
    }
    public List<IRentable> getAllCloseRents(){
        return  getDao().getAll().stream().filter(rent -> rent.getRent().getState() == RentState.CANCELED).collect(Collectors.toList());
    }
    public List<IRentable> getAllOutOfDateRents(){
        return  getDao().getAll().stream().filter(rent -> rent.getRent().getState() == RentState.OUTOFDATE).collect(Collectors.toList());
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
