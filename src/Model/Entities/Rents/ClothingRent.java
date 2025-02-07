package Model.Entities.Rents;

import Model.Entities.RentableObjects.Clothing;
import Model.Strategy.IPayment;

public class ClothingRent extends ObjectRent implements IRentable<Clothing>{
    private Clothing clothing;
 
    @Override
    public double getPricePerDay() {
        return this.clothing.getObject().getPricePerDay();
    }

    @Override
    public String getDescription() {
        return clothing + " " + rent + " " + client + " " + priceMethod;
    }

    @Override
    public double getEarning() {
        return this.priceMethod.calculate(this.client.getType(),this.rent,this.clothing);
    }

    @Override
    public void generateRent(int days) {
        openRent(days);
    }
    @Override
    public void setRentableObject(Clothing object) {
        this.clothing = object;
    }

    @Override
    public IPayment getMethod() {
        return this.priceMethod;
    }

    @Override
    public Clothing getRentableObject() {
        return this.clothing;
    }

}
