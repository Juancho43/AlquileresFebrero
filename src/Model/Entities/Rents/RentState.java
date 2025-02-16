package Model.Entities.Rents;

/**
 * Enum representing the possible states of a rent.
 * This enum defines the different states a rent can be in throughout its lifecycle,
 * such as CANCELED, STARTED, and OUTDATED.  Using an enum provides type safety
 * and makes the code more readable by using named constants instead of raw values.
 */
public enum RentState {

    /**
     * The rent has been canceled.
     */
    CANCELED,

    /**
     * The rent has started.
     */
    STARTED,

    /**
     * The rent is overdue (the return date has passed).
     */
    OUTDATED
}