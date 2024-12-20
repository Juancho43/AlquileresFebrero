package Model.Strategy;

import Model.Entities.PriceParameters;
import Model.Entities.RentableObjects.RentableObject;
import Model.Entities.Rents.Rent;
import Model.Enums.Client;

public interface IPriceMethod {
    double calculate(Client client, Rent rent,RentableObject object);

}
