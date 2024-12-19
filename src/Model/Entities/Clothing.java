package Model.Entities;

import Model.Strategy.IPriceMethod;

public class Clothing extends RentableObject{
    public Clothing(String name, String description, double pricePerDay) {
        super(name, description, pricePerDay);
    }
}
