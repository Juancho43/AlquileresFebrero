package Model.Entities.Rents;

import Model.Entities.Client;
import Model.Strategy.IPayment;

import java.time.LocalDate;

public class ObjectRent {
    protected long id;
    protected Rent rent;
    protected Client client;
    protected IPayment priceMethod;

    public void openRent(int days){
        rent = new Rent(days);
    }

    public void closeRent(LocalDate date){
        rent.closeRent(date);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

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

    public IPayment getPriceMethod() {
        return priceMethod;
    }

    public void setPriceMethod(IPayment priceMethod) {
        this.priceMethod = priceMethod;
    }
}
