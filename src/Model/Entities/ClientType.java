package Model.Entities;

import Model.Factory.IdFactory;

public class ClientType {

    private long id;
    private String type;
    private double discount;

    public ClientType( String type, double discount) {
        this.id = IdFactory.generateUniqueId();
        this.type = type;
        this.discount = discount;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    @Override
    public String toString() {
        return  type + ", descuento: " + discount ;
    }
}
