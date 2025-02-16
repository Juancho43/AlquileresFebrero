package Controller.RentableObjects;

import Controller.IControllable;
import Controller.IFactory;
import Model.DAO.DAO;
import Model.DAO.MemoryClothingDAO;
import Model.Entities.RentableObjects.Clothing;
import Model.Factory.RentClothingFactory;
import Model.Factory.RentFactory;

import java.util.List;
import java.util.stream.Collectors;

/**
 * A controller for managing `Clothing` entities.
 * This class provides methods for adding new clothing items, retrieving
 * available clothing, and interacting with the `MemoryClothingDAO` to persist
 * clothing data. It also implements the `IFactory` interface to provide
 * a `RentFactory` for creating `ClothingRent` objects.
 */
public class ClothingController implements IControllable, IFactory {

    private final DAO<Clothing> dao = MemoryClothingDAO.getInstance(); // Data access object for Clothing.

    /**
     * Adds a new clothing item.
     * This method creates a new `Clothing` object with the provided information
     * and persists it using the DAO.
     *
     * @param name        The name of the clothing item.
     * @param description A description of the clothing item.
     * @param price       The price per day for renting the clothing item.
     * @param size        The size of the clothing item.
     * @param color       The color of the clothing item.
     */
    public void newCloth(String name, String description, Double price, String size, String color) {
        getDao().save(new Clothing(name, description, price, size, color));
    }

    /**
     * Retrieves all available clothing items.
     *
     * @return A list of all `Clothing` objects that are currently available for rent.
     */
    public List<Clothing> getAllAvaliableCloth() {
        return getDao().getAll().stream()
                .filter(clothing -> clothing.getObject().isAvailable())
                .collect(Collectors.toList());
    }

    /**
     * Gets the DAO for `Clothing` entities.
     *
     * @return The `Clothing` DAO.
     */
    @Override
    public DAO<Clothing> getDao() {
        return dao;
    }

    /**
     * Gets the `RentFactory` for creating `ClothingRent` objects.
     *
     * @return A `RentClothingFactory`.
     */
    @Override
    public RentFactory getFactory() {
        return new RentClothingFactory();
    }

    /**
     * Returns a string representation of the clothing controller.
     *
     * @return "Ropa".
     */
    @Override
    public String toString() {
        return "Ropa";
    }
}