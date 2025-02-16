package Model.Entities.Rents;

import Model.Factory.IdFactory;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/**
 * Represents a rental period.
 * This class manages information about a rent, including the start date, return date,
 * close date, and the current state of the rent.  It also provides methods for
 * calculating durations, checking status, and closing a rent.
 */
public class Rent {

    private long id;
    private LocalDate date; // The date the rent started.
    private LocalDate giveBackDate; // The date the item is expected to be returned.
    private LocalDate closeDate; // The date the rent was actually closed (returned or otherwise finalized).
    private RentState rentState; // The current state of the rent (e.g., STARTED, OUTOFDATE, CANCELED).

    /**
     * Constructor for creating a new rent.
     *
     * @param days The number of days the item is rented for.
     */
    public Rent(int days) {
        this.id = IdFactory.generateUniqueId(); // Generate a unique ID using a factory.
        this.date = LocalDate.now(); // Set the start date to the current date.
        this.giveBackDate = date.plusDays(days); // Calculate the expected return date.
        this.rentState = RentState.STARTED; // Set the initial state to STARTED.
    }

    /**
     * Gets the ID of the rent.
     *
     * @return The ID of the rent.
     */
    public long getId() {
        return id;
    }

    /**
     * Sets the ID of the rent.  Primarily used by persistence frameworks.
     *
     * @param id The ID of the rent.
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * Gets the close date of the rent.
     *
     * @return The close date of the rent.
     */
    public LocalDate getCloseDate() {
        return closeDate;
    }

    /**
     * Sets the close date of the rent.
     *
     * @param closeDate The close date of the rent.
     */
    public void setCloseDate(LocalDate closeDate) {
        this.closeDate = closeDate;
    }

    /**
     * Gets the current state of the rent.
     *
     * @return The current state of the rent.
     */
    public RentState getRentState() {
        return rentState;
    }

    /**
     * Sets the current state of the rent.
     *
     * @param rentState The current state of the rent.
     */
    public void setRentState(RentState rentState) {
        this.rentState = rentState;
    }

    /**
     * Gets the start date of the rent.
     *
     * @return The start date of the rent.
     */
    public LocalDate getDate() {
        return date;
    }

    /**
     * Sets the start date of the rent.
     *
     * @param date The start date of the rent.
     */
    public void setDate(LocalDate date) {
        this.date = date;
    }

    /**
     * Gets the expected return date of the rent.
     *
     * @return The expected return date of the rent.
     */
    public LocalDate getGiveBackDate() {
        return giveBackDate;
    }

    /**
     * Sets the expected return date of the rent.
     *
     * @param giveBackDate The expected return date of the rent.
     */
    public void setGiveBackDate(LocalDate giveBackDate) {
        this.giveBackDate = giveBackDate;
    }

    /**
     * Gets the current state of the rent (alias for getRentState()).
     *
     * @return The current state of the rent.
     */
    public RentState getState() {
        return rentState;
    }

    /**
     * Sets the current state of the rent (alias for setRentState()).
     *
     * @param rentState The current state of the rent.
     */
    public void setState(RentState rentState) {
        this.rentState = rentState;
    }

    /**
     * Calculates the initial duration of the rent (from start date to expected return date).
     *
     * @return The initial duration of the rent in days.
     */
    public long calculateFirstDuration() {
        return ChronoUnit.DAYS.between(this.date, this.giveBackDate);
    }

    /**
     * Calculates the actual duration of the rent (from start date to close date).
     *
     * @return The actual duration of the rent in days.
     */
    public long calculateDuration() {
        if (closeDate == null) { // Handle the case where the rent hasn't been closed yet.
            return 0; // Or throw an exception, depending on your needs.
        }
        return ChronoUnit.DAYS.between(this.date, this.closeDate);
    }

    /**
     * Checks the current status of the rent and updates it if necessary.
     * If the expected return date is in the past, the rent state is set to OUTOFDATE.
     *
     * @return The current state of the rent.
     */
    public RentState checkStatus() {
        if (giveBackDate.isBefore(LocalDate.now())) {
            this.setState(RentState.OUTDATED);
        }
        return this.rentState;
    }

    /**
     * Calculates the number of days the rent is overdue.
     *
     * @return The number of days the rent is overdue.
     */
    public long calculateDelayDays() {
        long delayDays = 0;
        if (!LocalDate.now().isBefore(giveBackDate)) delayDays =ChronoUnit.DAYS.between(this.giveBackDate, LocalDate.now());
        return delayDays;
    }

    /**
     * Closes the rent and sets the close date and state.
     *
     * @param date The date the rent was closed.
     * @return The updated state of the rent (CANCELED).
     */
    public RentState closeRent(LocalDate date) {
        this.closeDate = date;
        this.rentState = RentState.CANCELED; // Or another appropriate state like RETURNED
        return this.rentState;
    }

    /**
     * Returns a string representation of the rent.
     *
     * @return A string representation of the rent (start date, state, and expected return date).
     */
    @Override
    public String toString() {
        return date + " " + rentState + " " + giveBackDate;
    }
}