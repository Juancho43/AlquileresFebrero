package Model.Factory;

import Model.Entities.RentableObjects.RentableObject;
import Model.Entities.Rents.IRentable;

public abstract class RentFactory {

    public IRentable rentObject(int days, RentableObject object){
        IRentable rentable = createRent();
        rentable.setRentableObject(object);
        rentable.generateRent(days);
        return rentable;
    };

    public abstract IRentable createRent();

}
