package Model.Entities.Rents;

import Model.Entities.Clients.Client;
import Model.Strategy.IPayment;

/**
 * Represents a rental transaction, linking a rent, a client, and a payment method.
 * This class encapsulates the relationship between a `Rent` object, a `Client` object,
 * and the payment method used for the rental. It also provides a method to initiate
 * a new rent.
 */
public class ObjectRent {

    protected long id; // The ID of the rental transaction.
    protected Rent rent; // The Rent object associated with this transaction.
    protected Client client; // The Client object associated with this transaction.
    protected IPayment priceMethod; // The payment method used for this transaction.

    /**
     * Opens a new rent for this rental transaction.  Creates a new `Rent` object
     * and associates it with this `ObjectRent`.
     *
     * @param days The number of days the item is rented for.
     */
    public void openRent(int days) {
        rent = new Rent(days);
    }

    /**
     * Gets the ID of the rental transaction.
     *
     * @return The ID of the rental transaction.
     */
    public long getId() {
        return id;
    }

    /**
     * Sets the ID of the rental transaction.  Typically used by persistence frameworks.
     *
     * @param id The ID of the rental transaction.
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * Gets the Rent object associated with this rental transaction.
     *
     * @return The Rent object associated with this rental transaction.
     */
    public Rent getRent() {
        return rent;
    }

    /**
     * Sets the Rent object associated with this rental transaction.
     *
     * @param rent The Rent object to associate with this rental transaction.
     */
    public void setRent(Rent rent) {
        this.rent = rent;
    }

    /**
     * Gets the Client object associated with this rental transaction.
     *
     * @return The Client object associated with this rental transaction.
     */
    public Client getClient() {
        return client;
    }

    /**
     * Sets the Client object associated with this rental transaction.
     *
     * @param client The Client object to associate with this rental transaction.
     */
    public void setClient(Client client) {
        this.client = client;
    }

    /**
     * Gets the payment method used for this rental transaction.
     *
     * @return The payment method used for this rental transaction.
     */
    public IPayment getPriceMethod() {
        return priceMethod;
    }

    /**
     * Sets the payment method used for this rental transaction.
     *
     * @param priceMethod The payment method to use for this rental transaction.
     */
    public void setPriceMethod(IPayment priceMethod) {
        this.priceMethod = priceMethod;
    }
}