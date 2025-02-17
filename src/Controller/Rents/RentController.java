package Controller.Rents;

import Controller.IControllable;
import Model.DAO.MemoryClosedRentsDAO;
import Model.DAO.MemoryRentDAO;
import Model.DAO.DAO;
import Model.Entities.Clients.Client;
import Model.Entities.RentableObjects.IRentableObject;
import Model.Entities.Rents.IRentable;
import Model.Entities.Rents.RentState;
import Model.Factory.RentFactory;

import java.util.List;
import java.util.stream.Collectors;

/**
 * A controller for managing `IRentable` entities (rents).
 * This class provides methods for creating new rents, retrieving rents
 * based on their state (started, closed, overdue), and calculating total
 * earnings. It interacts with the `MemoryRentDAO` to persist and retrieve
 * rent data. It also uses a `RentFactory` to create the appropriate
 * type of `IRentable` object.
 */
public class RentController implements IControllable {

    private DAO<IRentable> dao = MemoryRentDAO.getInstance(); // Data access object for IRentable.



    private DAO<IRentable> closedRentDao = MemoryClosedRentsDAO.getInstance();
    private double totalEarnings = 0; // Stores the total earnings from closed rents.
    private RentFactory rentFactory; // Factory for creating different types of rents.

    /**
     * Creates a new rent.
     * This method uses the provided `RentFactory` to create a new `IRentable`
     * object, sets the rental duration, associates it with the rentable object
     * and client, and then persists it using the DAO.
     *
     * @param days   The number of days the object is rented for.
     * @param object The `IRentableObject` being rented.
     * @param client The `Client` renting the object.
     */
    public void newRent(int days, IRentableObject object, Client client) {
        this.dao.save(rentFactory.rentObject(days, object, client));
    }

    /**
     * Retrieves all started rents.
     *
     * @return A list of all `IRentable` objects that are currently in the `STARTED` state.
     */
    public List<IRentable> getAllStartedRents() {
        return getDao().getAll().stream()
                .filter(rent -> rent.getRent().getState() == RentState.STARTED)
                .collect(Collectors.toList());
    }

    /**
     * Retrieves all closed rents.
     *
     * @return A list of all `IRentable` objects that are currently in the `CANCELED` state.
     */
    public List<IRentable> getAllCloseRents() {
        return getDao().getAll().stream()
                .filter(rent -> rent.getRent().getState() == RentState.CANCELED)
                .collect(Collectors.toList());
    }

    /**
     * Retrieves all overdue rents.
     *
     * @return A list of all `IRentable` objects that are currently in the `OUTDATED` state.
     */
    public List<IRentable> getAllOutOfDateRents() {
        return getDao().getAll().stream()
                .filter(rent -> rent.getRent().getState() == RentState.OUTDATED)
                .collect(Collectors.toList());
    }

    /**
     * Calculates the total earnings from all closed rents.
     *
     * @return The total earnings.
     */
    public double getTotalEarnings() {
        totalEarnings = 0; // Reset earnings before recalculating.
        for (IRentable rent : getAllCloseRents()) {
            totalEarnings += rent.getRent().getEarning();
        }
        return totalEarnings;
    }

    /**
     * Gets the DAO for `IRentable` entities.
     *
     * @return The `IRentable` DAO.
     */
    public DAO<IRentable> getDao() {
        return dao;
    }


    public DAO<IRentable> getClosedRentDao() {
        return closedRentDao;
    }
    /**
     * Gets the `RentFactory`.
     *
     * @return The `RentFactory`.
     */
    public RentFactory getRentFactory() {
        return rentFactory;
    }

    /**
     * Sets the `RentFactory`.
     *
     * @param rentFactory The `RentFactory` to set.
     */
    public void setRentFactory(RentFactory rentFactory) {
        this.rentFactory = rentFactory;
    }
}