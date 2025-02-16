package Model.Factory;

import java.util.HashSet;
import java.util.Set;

/**
 * A factory for generating unique IDs.
 * This class provides a method for generating unique long IDs using
 * `System.currentTimeMillis()` as a base.  It ensures uniqueness by
 * keeping track of previously generated IDs and regenerating if a
 * collision occurs.
 */
public class IdFactory {

    private static final Set<Long> usedIds = new HashSet<>(); // Stores previously generated IDs to prevent duplicates.

    /**
     * Generates a unique long ID.
     * This method uses `System.currentTimeMillis()` to generate a new ID.
     * It then checks if the ID has already been used. If it has, a new ID is
     * generated and the process repeats until a unique ID is found.  This
     * approach is generally sufficient for most applications, but for very
     * high-volume ID generation, consider using a UUID or a database-generated
     * sequence.
     *
     * @return A unique long ID.
     */
    public static long generateUniqueId() {
        long newId;
        do {
            newId = System.currentTimeMillis(); // Generate a new ID based on current time.
        } while (!usedIds.add(newId)); // Check if the ID is already in use; if so, regenerate.
        return newId; // Return the unique ID.
    }
}