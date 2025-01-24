package Model.Entities.Rents;

import Model.Entities.RentableObjects.Vehicle;
import Model.Strategy.IPayment;

public class VehicleRent extends ObjectRent implements IRentable<Vehicle>{

    Vehicle vehicle;

    @Override
    public double getPricePerDay() {
        return this.vehicle.getPricePerDay();
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
        openRent(days);
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

}
