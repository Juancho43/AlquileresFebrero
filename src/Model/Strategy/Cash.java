package Model.Strategy;

import Model.Entities.RentableObjects.RentableObject;
import Model.Entities.Rents.Rent;
import Model.Enums.Client;
import Model.Enums.State;

public class Cash implements IPriceMethod{
    @Override
    public double calculate(Client client, Rent rent, RentableObject object) {
        double finalPrice = object.getPricePerDay() * rent.calculateDuration() ;
        finalPrice *= calculateDiscount(finalPrice,10);
        if(rent.getState() == State.OUTOFDATE){
            finalPrice *= rent.calculateDelayDays();
        }
        switch(client){
            case COMMON -> {
                finalPrice -= calculateDiscount(finalPrice,5);
            }
            case VIP -> {
                finalPrice -= calculateDiscount(finalPrice,35.0);
            }
        }

        return finalPrice;
    }

    private double calculateDiscount(double price, double discount){
        return price*(discount/100);
    }
}
