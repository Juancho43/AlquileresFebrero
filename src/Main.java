import Model.Entities.RentableObjects.Clothing;
import Model.Entities.RentableObjects.Vehicle;
import Model.Entities.Rents.IRentable;
import Model.Factory.RentClothingFactory;
import Model.Factory.RentFactory;
import Model.Factory.RentVehicleFactory;

public class Main {
    public static void main(String[] args) {
        Vehicle vehicle = new Vehicle("Auto ", "Electrico", 12.3,"Audi","A8",2010);
        RentFactory rentFactory = new RentVehicleFactory();
        rentFactory.rentObject(2,vehicle);
        IRentable vehicleRent = rentFactory.rentObject(3,vehicle);
        System.out.println(vehicleRent.getDescription());
        rentFactory = new RentClothingFactory();
        Clothing clothing = new Clothing("Disfraz de barni","Version original",3.2,"xl","rosa");
        IRentable clothingRent = rentFactory.rentObject(3,clothing);
        System.out.println(clothingRent.getDescription());

    }
}