package Model.Entities;

import Model.Strategy.IPriceMethod;

public class Vehicle extends RentableObject{

    public Vehicle(String name, String description, double pricePerDay) {
        super(name, description, pricePerDay);
    }
}
