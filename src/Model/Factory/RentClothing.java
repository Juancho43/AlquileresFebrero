package Model.Factory;

import Model.Entities.Clothing;
import Model.Entities.ClothingRent;
import Model.Entities.IRentable;

public class RentClothing extends RentFactory<Clothing>{

    @Override
    public IRentable createRent() {
        return new ClothingRent();
    }
}
