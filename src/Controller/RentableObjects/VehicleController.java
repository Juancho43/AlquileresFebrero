package Controller.RentableObjects;

import DAO.DAO;
import DAO.MemoryVehicleDAO;
import Model.Entities.RentableObjects.Vehicle;

import java.util.List;

public class VehicleController {
    private final DAO<Vehicle> dao = MemoryVehicleDAO.getInstance();

    public void addVehicle(String name, String description, Double price, String brand, String model, int year){
        getDao().save(new Vehicle(name,description,price, brand, model, year));
    }

    public List<Vehicle> getAllVehicles() {
        return dao.getAll();
    }

    public Vehicle getVehicleById(long id) {
        return dao.getById(id);
    }

    public Vehicle updateVehicle(long id, Vehicle updatedVehicle) {
        return dao.updateById(id, updatedVehicle);
    }

    public boolean deleteVehicle(long id) {
        return dao.deleteById(id);
    }

    public DAO getDao() {
        return dao;
    }
}
