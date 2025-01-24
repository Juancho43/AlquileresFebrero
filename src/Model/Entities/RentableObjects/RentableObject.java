package Model.Entities.RentableObjects;

import Model.Factory.IdFactory;

public abstract class RentableObject {
    protected long id;
    protected String name;
    protected String description;
    protected double pricePerDay;
    protected boolean avalible;

    public RentableObject(String name, String description, double pricePerDay) {
        this.id = IdFactory.generateUniqueId();
        this.name = name;
        this.description = description;
        this.pricePerDay = pricePerDay;
        this.avalible = true;
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

    public boolean isAvalible() {
        return avalible;
    }

    public void setAvalible(boolean avalible) {
        this.avalible = avalible;
    }
}
