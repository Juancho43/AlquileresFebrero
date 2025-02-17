package Model.Entities.Mocks;

import Controller.RentableObjects.VehicleController;

public class VehicleMocks {

    private static final VehicleController vehicleController = new VehicleController();
    public static void add(){
        vehicleController.addVehicle("Auto", "Electrico", 10.3,"Audi","A8",2010);
        vehicleController.addVehicle("Auto", "Electrico", 11.3,"Fiat","A8",2010);
        vehicleController.addVehicle("Auto", "Mixto", 12.3,"Audi","B",2010);
        vehicleController.addVehicle("Auto", "Mixto", 13.3,"Fiat","1",2010);
    }
}
