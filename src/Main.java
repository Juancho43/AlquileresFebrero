import Model.Entities.IRentable;
import Model.Entities.Vehicle;
import Model.Entities.VehicleRent;
import Model.Factory.RentFactory;
import Model.Factory.RentVehicle;
import Model.Strategy.IPriceMethod;

public class Main {
    public static void main(String[] args) {
        Vehicle vehicle = new Vehicle("asdas", "asdas", 12.3);
        RentFactory rentFactory = new RentVehicle();
        IRentable vehicleRent = rentFactory.rentObject(3,vehicle);
        vehicleRent.getDescription();
        System.out.println("Hello world!");
    }
}