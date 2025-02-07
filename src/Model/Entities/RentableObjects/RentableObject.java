package Model.Entities.RentableObjects;

import Model.Factory.IdFactory;

public class RentableObject {

    private String name;
    private String description;
    private double pricePerDay;
    private boolean available;

    public RentableObject(String name, String description, double pricePerDay) {
        this.name = name;
        this.description = description;
        this.pricePerDay = pricePerDay;
        this.available = true;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPricePerDay() {
        return pricePerDay;
    }

    public void setPricePerDay(double pricePerDay) {
        this.pricePerDay = pricePerDay;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }
}
