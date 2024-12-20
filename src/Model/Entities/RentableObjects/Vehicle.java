package Model.Entities.RentableObjects;

public class Vehicle extends RentableObject{

    private String brand;
    private String model;
    private int year;
    public Vehicle(String name, String description, double pricePerDay, String brand, String model, int year) {
        super(name, description, pricePerDay);
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

    @Override
    public String toString() {
        return "Vehiculo: " +
                name + " $" + pricePerDay + "/day";

    }
}
