package Model.Entities.Rents;

import Model.Entities.Client;
import Model.Strategy.IPriceMethod;

public class ObjectRent {
    protected Rent rent;
    protected Client client;
    protected IPriceMethod priceMethod;

    public Rent getRent() {
        return rent;
    }

    public void setRent(Rent rent) {
        this.rent = rent;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public IPriceMethod getPriceMethod() {
        return priceMethod;
    }

    public void setPriceMethod(IPriceMethod priceMethod) {
        this.priceMethod = priceMethod;
    }
}
