package Model.Entities.RentableObjects;

public class Clothing extends RentableObject{

    private String size;
    private String color;
    public Clothing(String name, String description, double pricePerDay, String size, String color) {
        super(name, description, pricePerDay);
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

    @Override
    public String toString() {
        return "Ropa: " +
                name + " (" + size +") $" + pricePerDay +"/day";
    }
}

