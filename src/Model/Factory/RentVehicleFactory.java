package Model.Factory;

import Model.Entities.Rents.IRentable;
import Model.Entities.Rents.VehicleRent;

/**
 * A concrete factory for creating `VehicleRent` objects.
 * This class extends the `RentFactory` abstract class and implements the
 * `createRent()` method to produce instances of `VehicleRent`.  It is
 * responsible for creating the specific type of `IRentable` object when
 * a vehicle rent is required.
 */
public class RentVehicleFactory extends RentFactory {

    /**
     * Creates a new `VehicleRent` object.
     * This method overrides the abstract `createRent()` method from the
     * `RentFactory` class. It returns a new instance of the `VehicleRent`
     * class, which represents a rental transaction specifically for vehicles.
     *
     * @return A new `VehicleRent` object.
     */
    @Override
    public IRentable createRent() {
        return new VehicleRent();
    }
}
