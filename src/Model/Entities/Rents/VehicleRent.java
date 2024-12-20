package Model.Entities.Rents;

import Model.Entities.RentableObjects.Vehicle;

public class VehicleRent extends ObjectRent implements IRentable<Vehicle>{

    Vehicle vehicle;

    @Override
    public double getPricePerDay() {
        return this.vehicle.getPricePerDay();
    }

    @Override
    public String getDescription() {
        return vehicle.toString() + " " + rent;
    }

    @Override
    public double getEarning() {
        return this.priceMethod.calculate(this.client.getType(),this.rent,this.vehicle);
    }

    @Override
    public Rent generateRent(int days) {
        this.rent = new Rent(days);
        return rent;
    }
    @Override
    public void setRentableObject(Vehicle object) {
        this.vehicle = object;
    }
}
