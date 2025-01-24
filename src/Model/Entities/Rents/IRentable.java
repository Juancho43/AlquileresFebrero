package Model.Entities.Rents;

import Model.Entities.Client;
import Model.Strategy.IPayment;

public interface IRentable<E extends Object>{
    double getPricePerDay();
    String getDescription();
    double getEarning();

    void generateRent(int days);

    void setRentableObject(E object);
    void setClient(Client client);
    void setPriceMethod(IPayment method);

    Rent getRent();
    IPayment getMethod();
    E getRentableObject();
    Client getClient();
    long getId();
}
