package Model.Factory;

import Model.Entities.Clients.Client;
import Model.Entities.RentableObjects.IRentableObject;
import Model.Entities.Rents.IRentable;

public abstract class RentFactory {

    public IRentable rentObject(int days, IRentableObject object, Client client){
        IRentable rentable = createRent();
        rentable.generateId();
        rentable.setRentableObject(object);
        rentable.setClient(client);
        rentable.setPriceMethod(client.getPaymentMethod());
        rentable.generateRent(days);
        return rentable;
    };

    public abstract IRentable createRent();

}
