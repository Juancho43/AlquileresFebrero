package Model.Entities.Rents;

import Model.Entities.RentableObjects.Clothing;
import Model.Strategy.IPayment;

public class ClothingRent extends ObjectRent implements IRentable<Clothing>{
    private Clothing object;
 
    @Override
    public double getPricePerDay() {
        return this.object.getPricePerDay();
    }

    @Override
    public String getDescription() {
        return object + " " + rent + " " + client + " " + priceMethod;
    }

    @Override
    public double getEarning() {
        return this.priceMethod.calculate(this.client.getType(),this.rent,this.object);
    }

    @Override
    public void generateRent(int days) {
        openRent(days);
    }
    @Override
    public void setRentableObject(Clothing object) {
        this.object = object;
    }

    @Override
    public IPayment getMethod() {
        return this.priceMethod;
    }

    @Override
    public Clothing getRentableObject() {
        return this.object;
    }

}
