package Model.Strategy;

import Model.Entities.RentableObjects.RentableObject;
import Model.Entities.Rents.Rent;
import Model.Enums.ClientTypes;
import Model.Enums.RentState;

public class Cash implements IPayment {
    @Override
    public double calculate(ClientTypes clientTypes, Rent rent, RentableObject object) {
        double finalPrice = object.getPricePerDay() * rent.calculateDuration() ;
        if(rent.getState() == RentState.OUTOFDATE){
            finalPrice *= rent.calculateDelayDays();
        }
        finalPrice -= calculateDiscount(finalPrice,10);
        switch(clientTypes){
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
    @Override
    public String toString() {
        return "Cash";
    }
}
