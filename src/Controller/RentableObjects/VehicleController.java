package Controller.RentableObjects;

import DAO.DAO;
import DAO.MemoryVehicleDAO;
import Model.Entities.RentableObjects.Vehicle;

public class VehicleController {
    private final DAO dao = MemoryVehicleDAO.getInstance();

    public DAO getDao() {
        return dao;
    }

    public void addVehicle(String name, String description, Double price, String brand, String model, int year){
        getDao().save(new Vehicle(name,description,price, brand, model, year));
    }
}
