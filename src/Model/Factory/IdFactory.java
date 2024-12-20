package Model.Factory;

import java.util.HashSet;
import java.util.Set;

public class IdFactory {
    private static final Set<Long> usedIds = new HashSet<>();
    public static long generateUniqueId() {
        long newId;
        do {
            newId = System.currentTimeMillis();
        } while (!usedIds.add(newId));
        return newId;
    }

}
