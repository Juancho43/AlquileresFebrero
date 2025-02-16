package Model.Factory;

import Model.Entities.Rents.ClothingRent;
import Model.Entities.Rents.IRentable;

/**
 * A concrete factory for creating `ClothingRent` objects.
 * This class extends the `RentFactory` abstract class and implements the
 * `createRent()` method to produce instances of `ClothingRent`.  It is
 * responsible for creating the specific type of `IRentable` object when
 * a clothing rent is required.
 */
public class RentClothingFactory extends RentFactory {

    /**
     * Creates a new `ClothingRent` object.
     * This method overrides the abstract `createRent()` method from the
     * `RentFactory` class. It returns a new instance of the `ClothingRent`
     * class, representing a rental transaction specifically for clothing items.
     *
     * @return A new `ClothingRent` object.
     */
    @Override
    public IRentable createRent() {
        return new ClothingRent();
    }
}