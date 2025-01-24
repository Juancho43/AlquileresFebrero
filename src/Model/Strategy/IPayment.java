package Model.Strategy;

import Model.Entities.RentableObjects.RentableObject;
import Model.Entities.Rents.Rent;
import Model.Enums.ClientTypes;

public interface IPayment {
    double calculate(ClientTypes clientTypes, Rent rent, RentableObject object);

}
