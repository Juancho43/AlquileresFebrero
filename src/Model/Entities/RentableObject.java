package Model.Entities;
import Model.Strategy.IPriceMethod;

public class RentableObject{

    protected long id;
    protected String name;
    protected String description;
    protected double pricePerDay;
    protected IPriceMethod priceMethod;

    public RentableObject(String name, String description, double pricePerDay) {
        this.name = name;
        this.description = description;
        this.pricePerDay = pricePerDay;
//        this.priceMethod = priceMethod;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public IPriceMethod getPriceMethod() {
        return priceMethod;
    }

    public void setPriceMethod(IPriceMethod priceMethod) {
        this.priceMethod = priceMethod;
    }
}
