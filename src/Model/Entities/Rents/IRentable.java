package Model.Entities.Rents;

import Model.Entities.Clients.Client;
import Model.Strategy.IPayment;

import java.time.LocalDate;

/**
 * An interface defining the contract for rentable objects.
 * This interface specifies the methods that must be implemented by any class
 * that represents a rentable object (e.g., Vehicle, Clothing). It provides
 * methods for managing rent generation, closing, pricing, and associating
 * the rentable object with a rent, client, and payment method.
 *
 * @param <E> The type of the rentable object (e.g., Vehicle, Clothing).  This allows
 *            for type safety when working with different kinds of rentable items.
 */
public interface IRentable<E extends Object> {

    /**
     * Gets the price per day for renting the object.
     *
     * @return The price per day.
     */
    double getPricePerDay();

    /**
     * Gets a description of the rental transaction.
     *
     * @return A description of the rental transaction.
     */
    String getDescription();

    /**
     * Calculates the total earnings for the rent.
     *
     * @return The total earnings.
     */
    double getEarning();

    /**
     * Generates a new rent for the object.
     *
     * @param days The number of days the object is rented for.
     */
    void generateRent(int days);

    /**
     * Closes the rent for the object.
     *
     * @param date The date the rent was closed.
     */
    void closeRent(LocalDate date);

    /**
     * Sets the rentable object.
     *
     * @param object The rentable object.
     */
    void setRentableObject(E object);

    /**
     * Sets the client associated with the rent.
     *
     * @param client The client.
     */
    void setClient(Client client);

    /**
     * Sets the payment method used for the rent.
     *
     * @param method The payment method.
     */
    void setPriceMethod(IPayment method);

    /**
     * Gets the Rent object associated with the rental.
     *
     * @return The Rent object.
     */
    Rent getRent();

    /**
     * Gets the payment method used for the rent.
     *
     * @return The payment method.
     */
    IPayment getMethod();

    /**
     * Gets the rentable object.
     *
     * @return The rentable object.
     */
    E getRentableObject();

    /**
     * Gets the client associated with the rent.
     *
     * @return The client.
     */
    Client getClient();

    /**
     * Gets the ID of the rental transaction.
     *
     * @return The ID.
     */
    long getId();

    /**
     * Generates a unique ID for the rental transaction.
     */
    void generateId();
}