package Controller;

import Model.DAO.DAO;

/**
 * An interface defining the contract for controllers.
 * This interface specifies that all controller classes must provide a method
 * for accessing their associated Data Access Object (DAO).  This allows
 * other parts of the application to interact with the controller and,
 * indirectly, with the data layer.
 */
public interface IControllable {

    /**
     * Gets the Data Access Object (DAO) associated with this controller.
     *
     * @return The DAO object.
     */
    public DAO getDao();
}