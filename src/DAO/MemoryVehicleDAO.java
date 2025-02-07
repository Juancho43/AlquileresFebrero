package DAO;

import Model.Entities.RentableObjects.Vehicle;

import java.util.ArrayList;
import java.util.List;

public class MemoryVehicleDAO implements DAO<Vehicle>{


    private final List<Vehicle> vehicleList = new ArrayList<>();

    private static MemoryVehicleDAO MemoryVehicleDao;
    public static MemoryVehicleDAO getInstance(){
        if(MemoryVehicleDao == null){
            MemoryVehicleDao = new MemoryVehicleDAO();
        }
        return MemoryVehicleDao;
    }

    @Override
    public List<Vehicle> getAll() {
        return vehicleList;
    }

    @Override
    public Vehicle getById(long id) {
        Vehicle vehicle = null;
        try{
            for (Vehicle obj : vehicleList) {
                if (obj.getId() == id) {
                    vehicle = obj;
                }
            }
        } catch (Exception e) {
            System.out.println("Id no encontrado" + e);
        }
        return vehicle;
    }

    @Override
    public Vehicle save(Vehicle object) {
        vehicleList.add(object);
        return object;
    }

    @Override
    public Vehicle updateById(long id, Vehicle object) {
        getById(id).setBrand(object.getBrand());
        getById(id).setModel(object.getModel());
        getById(id).setYear(object.getYear());
        getById(id).setObject(object.getObject());
        return getById(id);
    }

    @Override
    public boolean deleteById(long id) {
        return vehicleList.removeIf(obj -> obj.getId() == id);
    }
}
