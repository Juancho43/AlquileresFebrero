package Controller.RentableObjects;

import Controller.IControllable;
import Controller.IFactory;
import Model.DAO.DAO;
import Model.DAO.MemoryVehicleDAO;
import Model.Entities.RentableObjects.Vehicle;
import Model.Factory.RentFactory;
import Model.Factory.RentVehicleFactory;

import java.util.List;
import java.util.stream.Collectors;

public class VehicleController implements IControllable, IFactory {
    private final DAO<Vehicle> dao = MemoryVehicleDAO.getInstance();

    public void addVehicle(String name, String description, Double price, String brand, String model, int year){
        this.dao.save(new Vehicle(name,description,price, brand, model, year));
    }
    public List<Vehicle> getAllAvaliableVehicles(){
        return  getDao().getAll().stream().filter(cloth -> cloth.getObject().isAvailable()).collect(Collectors.toList());
    }
    public List<Vehicle> getAllVehicles() {
        return this.dao.getAll();
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

    public DAO<Vehicle> getDao() {
        return dao;
    }

    @Override
    public RentFactory getFactory() {
        return new RentVehicleFactory();
    }

    @Override
    public String toString() {
        return "Vehiculos";
    }
}
