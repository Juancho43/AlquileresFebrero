package Model.Strategy;

import Model.Entities.ClientType;
import Model.Entities.RentableObjects.IRentableObject;
import Model.Entities.RentableObjects.RentableObject;
import Model.Entities.Rents.Rent;

public interface IPayment {
    double calculate(ClientType type, Rent rent, IRentableObject object);

    @Override
    boolean equals(Object obj);

    @Override
    int hashCode();
}
