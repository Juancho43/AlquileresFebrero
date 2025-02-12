package Model.Entities.Mocks;

import Controller.RentableObjects.VehicleController;

public class VehicleMocks {

    private static VehicleController c = new VehicleController();
    public static void add(){
        c.addVehicle("Auto", "Electrico", 10.3,"Audi","A8",2010);
        c.addVehicle("Auto", "Electrico", 11.3,"Fiat","A8",2010);
        c.addVehicle("Auto", "Mixto", 12.3,"Audi","B#",2010);
        c.addVehicle("Auto", "Mixto", 13.3,"Fiat","1",2010);
    }
}
