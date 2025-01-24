package Controller.RentableObjects;

import Model.Entities.RentableObjects.Vehicle;

public class VehicleController extends RentableObjectController {

    public void addVehicle(String name, String description, Double price, String brand, String model, int year){
        getDao().save(new Vehicle(name,description,price, brand, model, year));
    }

//Revisar
    public void update(Vehicle newVehicle, Long id) {
//        Vehicle updatedVehicle = (Vehicle) getById(id);
//        updatedVehicle.setName(newVehicle.getName());
//        updatedVehicle.setBrand(newVehicle.getBrand());
//        updatedVehicle.setModel(newVehicle.getModel());
//        updatedVehicle.setYear(newVehicle.getYear());
//        updatedVehicle.setDescription(newVehicle.getDescription());
//        updatedVehicle.setPricePerDay(newVehicle.getPricePerDay());
//        return updatedVehicle;
    }

}
