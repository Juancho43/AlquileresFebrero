package Model.Factory;

import Model.Entities.Rents.ClothingRent;
import Model.Entities.Rents.IRentable;

public class RentClothingFactory extends RentFactory {
    @Override
    public IRentable createRent() {
        return new ClothingRent();
    }
}
