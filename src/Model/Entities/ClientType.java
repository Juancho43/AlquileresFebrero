package Model.Entities;

import Model.Factory.IdFactory;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClientType type1 = (ClientType) o;
        return getId() == type1.getId() && Double.compare(type1.getDiscount(), getDiscount()) == 0 && Objects.equals(getType(), type1.getType());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getType(), getDiscount());
    }
}
