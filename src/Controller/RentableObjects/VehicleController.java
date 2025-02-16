package Controller.RentableObjects;

import Controller.IControllable;
import Controller.IFactory;
import Model.DAO.DAO;
import Model.DAO.MemoryVehicleDAO;
import Model.Entities.RentableObjects.Vehicle;
import Model.Factory.RentFactory;
import Model.Factory.RentVehicleFactory;

import java.util.List;
import java.util.stream.Collectors;

/**
 * A controller for managing `Vehicle` entities.
 * This class provides methods for adding new vehicles, retrieving available
 * vehicles, and interacting with the `MemoryVehicleDAO` to persist vehicle
 * data. It also implements the `IFactory` interface to provide a `RentFactory`
 * for creating `VehicleRent` objects.
 */
public class VehicleController implements IControllable, IFactory {

    private final DAO<Vehicle> dao = MemoryVehicleDAO.getInstance(); // Data access object for Vehicle.

    /**
     * Adds a new vehicle.
     * This method creates a new `Vehicle` object with the provided information
     * and persists it using the DAO.
     *
     * @param name        The name of the vehicle.
     * @param description A description of the vehicle.
     * @param price       The price per day for renting the vehicle.
     * @param brand       The brand of the vehicle.
     * @param model       The model of the vehicle.
     * @param year        The year the vehicle was manufactured.
     */
    public void addVehicle(String name, String description, Double price, String brand, String model, int year) {
        this.dao.save(new Vehicle(name, description, price, brand, model, year));
    }

    /**
     * Retrieves all available vehicles.
     *
     * @return A list of all `Vehicle` objects that are currently available for rent.
     */
    public List<Vehicle> getAllAvaliableVehicles() {
        return getDao().getAll().stream()
                .filter(vehicle -> vehicle.getObject().isAvailable())
                .collect(Collectors.toList());
    }

    /**
     * Gets the DAO for `Vehicle` entities.
     *
     * @return The `Vehicle` DAO.
     */
    @Override
    public DAO<Vehicle> getDao() {
        return dao;
    }

    /**
     * Gets the `RentFactory` for creating `VehicleRent` objects.
     *
     * @return A `RentVehicleFactory`.
     */
    @Override
    public RentFactory getFactory() {
        return new RentVehicleFactory();
    }

    /**
     * Returns a string representation of the vehicle controller.
     *
     * @return "Vehiculos".
     */
    @Override
    public String toString() {
        return "Vehiculos";
    }
}