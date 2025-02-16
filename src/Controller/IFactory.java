package Controller;

import Model.Factory.RentFactory;

/**
 * An interface defining the contract for controllers that use a factory.
 * This interface specifies that controller classes which utilize a `RentFactory`
 * to create objects must provide a method for accessing that factory.  This
 * allows other parts of the application to access the specific factory
 * being used by the controller.
 */
public interface IFactory {

    /**
     * Gets the `RentFactory` associated with this controller.
     *
     * @return The `RentFactory` object.
     */
    public RentFactory getFactory();
}