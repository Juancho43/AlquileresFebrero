package Model.Factory;

import Model.Entities.Rents.IRentable;
import Model.Entities.Rents.VehicleRent;

public class RentVehicleFactory extends RentFactory {
    @Override
    public IRentable createRent() {
        return new VehicleRent();
    }
}
