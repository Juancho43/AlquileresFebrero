package Model.Strategy;

import Model.Entities.ClientType;
import Model.Entities.RentableObjects.RentableObject;
import Model.Entities.Rents.Rent;
import Model.Enums.RentState;

public class CreditCard implements IPayment {



    @Override
    public double calculate(ClientType type, Rent rent, RentableObject object) {
        double finalPrice = object.getPricePerDay() * rent.calculateDuration() * ((double) 10 /100);

        if(rent.getState() == RentState.OUTOFDATE){
            //En el caso de que haya un retraso en el alquiler, se le asigna una penalizacion de 15% por dia
            finalPrice += rent.calculateDelayDays() * object.getPricePerDay() * 0.15;
        }

        finalPrice -= type.getDiscount() * finalPrice;

        return finalPrice;
    }

    @Override
    public String toString() {
        return "CreditCard";
    }
}
