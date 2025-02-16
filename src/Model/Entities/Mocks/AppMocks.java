package Model.Entities.Mocks;

import Controller.ClientController;
import Controller.RentableObjects.ClothingController;
import Controller.RentableObjects.VehicleController;
import Controller.Rents.RentController;
import Model.Entities.Clients.Client;
import Model.Entities.RentableObjects.Clothing;
import Model.Entities.RentableObjects.Vehicle;
import Model.Factory.RentClothingFactory;
import Model.Factory.RentVehicleFactory;

import java.time.LocalDate;
import java.util.List;

/**
 * Provides mock application data for testing and demonstration purposes.
 * This class orchestrates the creation of mock data for various entities
 * in the application, including vehicles, clothing items, client types, clients,
 * and rents. It utilizes other mock classes and controllers to generate
 * and persist this data.  It also creates sample rental transactions.
 */
public class AppMocks {

    /**
     * Adds initial mock data to the application.
     * This method calls the `add()` methods of other mock classes
     * (`VehicleMocks`, `ClothingMocks`, `ClientTypeMocks`, `ClientMocks`)
     * to populate the system with basic mock data. This is typically the first
     * step in setting up the application for testing or demonstration.
     */
    public static void add() {
        VehicleMocks.add();
        ClothingMocks.add();
        ClientTypeMocks.add();
        ClientMocks.add();
    }

    /**
     * Creates and persists mock rental transactions.
     * This method retrieves existing mock data (vehicles, clothing, clients)
     * using the respective controllers. It then creates several mock rental
     * transactions, associating clients with rentable objects (vehicles or
     * clothing) and setting the rental duration. It also demonstrates how to
     * close rents and calculate earnings.  It uses the appropriate factories
     * to create the correct type of rent.
     */
    public static void data() {
        // Controllers
        VehicleController v = new VehicleController();
        ClothingController c = new ClothingController();
        ClientController clientController = new ClientController();
        RentController rentController = new RentController();

        // Obtain the mock objects from the database.
        List<Client> clients = clientController.getDao().getAll();
        List<Vehicle> vehicleList = v.getDao().getAll();
        List<Clothing> clothingList = c.getDao().getAll();

        // Create mock rent transactions.
        rentController.setRentFactory(new RentVehicleFactory()); // Set the factory for vehicle rents.
        rentController.newRent(2, vehicleList.get(1), clients.get(0)); // Create a vehicle rent.
        rentController.newRent(3, vehicleList.get(2), clients.get(1)); // Create another vehicle rent.
        rentController.setRentFactory(new RentClothingFactory()); // Set the factory for clothing rents.
        rentController.newRent(3, clothingList.get(0), clients.get(3)); // Create a clothing rent.
        rentController.newRent(3, clothingList.get(2), clients.get(2)); // Create another clothing rent.

        // Close some of the rents.
        rentController.getDao().getAll().get(0).closeRent(LocalDate.now().plusDays(2));
        rentController.getDao().getAll().get(1).closeRent(LocalDate.now().plusDays(6));
        rentController.getDao().getAll().get(2).closeRent(LocalDate.now().plusDays(10));

        // The commented-out code below demonstrates how to access rental information
        // such as description, duration, delay days, status, and earnings.  It's left
        // commented out so that the `data()` method focuses on creating the mock data.
        // If you want to test those aspects, uncomment the code.

//        System.out.println(rentController.getDao().getAll().get(0).getDescription());
//        System.out.println(rentController.getDao().getAll().get(0).getRent().calculateFirstDuration());
//        System.out.println(rentController.getDao().getAll().get(0).getRent().calculateDuration());
//        System.out.println(rentController.getDao().getAll().get(0).getRent().calculateDelayDays());
//        System.out.println(rentController.getDao().getAll().get(0).getRent().checkStatus());
//        System.out.println("Ganancia: " + rentController.getDao().getAll().get(0).getEarning());
//        for (IRentable renta: rentController.getDao().getAll()) {
//            System.out.println(renta.getDescription());
//        }

    }

    /**
     * A combined method to add and then create rental data.  Convenient for testing.
     */
    public static void test() {
        add();
        data();
    }
}