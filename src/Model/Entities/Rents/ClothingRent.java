package Model.Entities.Rents;

import Model.Entities.RentableObjects.Clothing;

public class ClothingRent extends ObjectRent implements IRentable<Clothing>{
    private Clothing object;
 
    @Override
    public double getPricePerDay() {
        return this.object.getPricePerDay();
    }

    @Override
    public String getDescription() {
        return object.toString() + " " + rent;
    }

    @Override
    public double getEarning() {
        return this.priceMethod.calculate(this.client.getType(),this.rent,this.object);
    }

    @Override
    public Rent generateRent(int days) {
        this.rent = new Rent(days);
        return rent;
    }
    @Override
    public void setRentableObject(Clothing object) {
        this.object = object;
    }

}
