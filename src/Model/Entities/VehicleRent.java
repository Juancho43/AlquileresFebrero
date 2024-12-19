package Model.Entities;

public class VehicleRent implements IRentable<Vehicle>{

    Vehicle vehicle;
    Rent rent;

    @Override
    public double getPricePerDay() {
        return this.vehicle.pricePerDay;
    }

    @Override
    public String getDescription() {
        return null;
    }

    @Override
    public double getEarning() {
        return this.vehicle.priceMethod.calculate();
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
