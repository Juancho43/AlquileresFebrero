package Model.Entities.RentableObjects;

import Model.Factory.IdFactory;

public class Vehicle implements IRentableObject {
    private long id;
    private RentableObject object;
    private String brand;
    private String model;
    private int year;
    public Vehicle(String name, String description, double pricePerDay, String brand, String model, int year) {
        this.id = IdFactory.generateUniqueId();
        this.object = new RentableObject(name,description,pricePerDay);
        this.brand = brand;
        this.model = model;
        this.year = year;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public RentableObject getObject() {
        return this.object;
    }

    @Override
    public void setObject(RentableObject object) {
        this.object = object;
    }

    @Override
    public String toString() {
        return "Vehiculo: " +
                object.getName() + " $" + object.getPricePerDay() + "/day";

    }

}
