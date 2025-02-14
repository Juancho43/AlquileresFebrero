package Model.Entities.Rents;

import Model.Entities.RentableObjects.Vehicle;
import Model.Factory.IdFactory;
import Model.Strategy.IPayment;

import java.time.LocalDate;

public class VehicleRent extends ObjectRent implements IRentable<Vehicle>{

    Vehicle vehicle;

    @Override
    public double getPricePerDay() {
        return this.vehicle.getObject().getPricePerDay();
    }

    @Override
    public String getDescription() {
        return vehicle + " " + rent + " " + client + " " + priceMethod;
    }

    @Override
    public double getEarning() {
        return this.priceMethod.calculate(this.client.getType(),this.rent,this.vehicle);
    }

    @Override
    public void generateRent(int days) {
        this.getRentableObject().getObject().setAvailable(false);
        openRent(days);
    }

    @Override
    public void closeRent(LocalDate date) {
        this.getRentableObject().getObject().setAvailable(true);
        this.getRent().closeRent(date);
    }


    @Override
    public void setRentableObject(Vehicle object) {
        this.vehicle = object;
    }

    @Override
    public IPayment getMethod() {
        return this.priceMethod;
    }

    @Override
    public Vehicle getRentableObject() {
        return this.vehicle;
    }

    @Override
    public void generateId() {
        setId(IdFactory.generateUniqueId());
    }

    @Override
    public String toString() {
        return rent + " " + client.getName();
    }
}
