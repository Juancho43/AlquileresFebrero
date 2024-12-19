package Model.Factory;

import Model.Entities.IRentable;
import Model.Entities.VehicleRent;

public class RentVehicle extends RentFactory <VehicleRent>{
    @Override
    public IRentable createRent() {
        return new VehicleRent();
    }
}
