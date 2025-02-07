package Model.Entities.RentableObjects;

import Model.Factory.IdFactory;

public class Clothing implements IRentableObject {

    private long id;
    private RentableObject object;
    private String size;
    private String color;
    public Clothing(String name, String description, double pricePerDay, String size, String color) {
        this.id = IdFactory.generateUniqueId();
        this.object = new RentableObject(name,description,pricePerDay);
        this.size = size;
        this.color = color;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
    @Override
    public String toString() {
        return "Ropa: " +
                object.getName() + " (" + size +") $" + object.getPricePerDay() +"/day";
    }

    @Override
    public RentableObject getObject() {
        return object;
    }

    @Override
    public void setObject(RentableObject object) {
        this.object = object;
    }
}

