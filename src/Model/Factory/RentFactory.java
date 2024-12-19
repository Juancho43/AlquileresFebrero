package Model.Factory;

import Model.Entities.IRentable;
import Model.Entities.Rent;

import java.time.LocalDate;

public abstract class RentFactory <E extends Object>{

    public IRentable rentObject(int days,E object){
        IRentable rentable = createRent();
        rentable.setRentableObject(object);
        rentable.generateRent(days);
        return rentable;
    };

    public abstract IRentable createRent();
}
