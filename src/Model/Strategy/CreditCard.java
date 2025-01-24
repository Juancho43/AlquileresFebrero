package Model.Strategy;

import Model.Entities.RentableObjects.RentableObject;
import Model.Entities.Rents.Rent;
import Model.Enums.ClientTypes;
import Model.Enums.RentState;

public class CreditCard implements IPayment {

    @Override
    public double calculate(ClientTypes clientTypes, Rent rent, RentableObject object) {
        double finalPrice = object.getPricePerDay() * rent.calculateDuration() * ((double) 10 /100);

        if(rent.getState() == RentState.OUTOFDATE){
            finalPrice *= rent.calculateDelayDays();
        }

        switch(clientTypes){
            case COMMON -> {
                finalPrice -= calculateDiscount(finalPrice,3);
            }
            case VIP -> {
                finalPrice -= calculateDiscount(finalPrice,25.0);
            }
        }

            return finalPrice;
    }

    private double calculateDiscount(double price, double discount){
        return price*(discount/100);
    }

    @Override
    public String toString() {
        return "CreditCard";
    }
}
