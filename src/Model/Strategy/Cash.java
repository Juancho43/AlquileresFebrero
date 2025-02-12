package Model.Strategy;

import Model.Entities.ClientType;
import Model.Entities.RentableObjects.IRentableObject;
import Model.Entities.RentableObjects.RentableObject;
import Model.Entities.Rents.Rent;
import Model.Enums.RentState;

public class Cash implements IPayment {

    @Override
    public double calculate(ClientType type, Rent rent, IRentableObject object) {
        double finalPrice = object.getObject().getPricePerDay() * rent.calculateDuration();

        if(rent.getState() == RentState.OUTOFDATE){
            //En el caso de que haya un retraso en el alquiler, se le asigna una penalizacion de 10% por dia
            finalPrice += rent.calculateDelayDays() * object.getObject().getPricePerDay() * 0.1;
        }

        finalPrice -= type.getDiscount() * finalPrice;

        return finalPrice;
    }

    @Override
    public String toString() {
        return "Cash";
    }

    @Override
    public int hashCode() {
        return 1;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        return true;
    }
}
