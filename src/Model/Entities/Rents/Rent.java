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

    private long id; // Unique identifier for the rent.
    private LocalDate date; // The date the rent started.
    private LocalDate giveBackDate; // The date the item is expected to be returned.
    private LocalDate closeDate; // The date the rent was actually closed (returned or otherwise finalized).
    private RentState rentState; // The current state of the rent (e.g., STARTED, OUTOFDATE, CANCELED).
    private double earning; // The total earnings from this rent.

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

    // Getters and Setters for all fields

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDate getCloseDate() {
        return closeDate;
    }

    public void setCloseDate(LocalDate closeDate) {
        this.closeDate = closeDate;
    }

    public RentState getRentState() {
        return rentState;
    }

    public void setRentState(RentState rentState) {
        this.rentState = rentState;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalDate getGiveBackDate() {
        return giveBackDate;
    }

    public void setGiveBackDate(LocalDate giveBackDate) {
        this.giveBackDate = giveBackDate;
    }

    public RentState getState() { // Alias for getRentState()
        return rentState;
    }

    public void setState(RentState rentState) { // Alias for setRentState()
        this.rentState = rentState;
    }

    public double getEarning() {
        return earning;
    }

    public void setEarning(double earning) {
        this.earning = earning;
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
     * Returns 0 if the rent is not yet closed.
     *
     * @return The actual duration of the rent in days, or 0 if not closed.
     */
    public long calculateDuration() {
        if (closeDate == null) {
            return 0;
        }
        return ChronoUnit.DAYS.between(this.date, this.closeDate);
    }

    /**
     * Checks the current status of the rent and updates it if necessary.
     * If the expected return date is in the past, the rent state is set to OUTDATED.
     *
     * @return The current state of the rent.
     */
    public RentState checkStatus() {
        if (giveBackDate.isBefore(LocalDate.now())) {
            this.rentState = RentState.OUTDATED;
        }
        return this.rentState;
    }

    /**
     * Calculates the number of days the rent is overdue.  Returns 0 if not overdue.
     *
     * @return The number of days the rent is overdue, or 0 if not overdue.
     */
    public long calculateDelayDays() {
        long delayDays = 0;
        if (checkStatus() == RentState.OUTDATED) {
            delayDays = ChronoUnit.DAYS.between(this.giveBackDate, LocalDate.now());
        }
        return delayDays;
    }

    /**
     * Closes the rent and sets the close date and state.
     *
     * @param date The date the rent was closed.
     */
    public void closeRent(LocalDate date) {

        this.closeDate = date;
        this.rentState = RentState.CANCELED;
    }

    /**
     * Returns a string representation of the rent.
     *
     * @return A string representation of the rent (start date, state, and expected return date).
     */
    @Override
    public String toString() {
        return  date + " " + rentState +  " \n" + giveBackDate;
    }
}