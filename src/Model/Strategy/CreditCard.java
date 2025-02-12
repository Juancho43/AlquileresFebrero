package Model.Strategy;

import Model.Entities.ClientType;
import Model.Entities.RentableObjects.IRentableObject;
import Model.Entities.RentableObjects.RentableObject;
import Model.Entities.Rents.Rent;
import Model.Enums.RentState;

import java.util.Objects;

public class CreditCard implements IPayment {
    private String company;

    public CreditCard() {
    }

    public CreditCard(String company) {
        this.company = company;
    }

    public String getCardNumber() {
        return company;
    }

    public void setCardNumber(String company) {
        this.company = company;
    }

    @Override
    public double calculate(ClientType type, Rent rent, IRentableObject object) {
        double finalPrice = object.getObject().getPricePerDay() * rent.calculateDuration() * ((double) 10 /100);

        if(rent.getState() == RentState.OUTOFDATE){
            //En el caso de que haya un retraso en el alquiler, se le asigna una penalizacion de 15% por dia
            finalPrice += rent.calculateDelayDays() * object.getObject().getPricePerDay() * 0.15;
        }

        finalPrice -= type.getDiscount() * finalPrice;

        return finalPrice;
    }

    @Override
    public String toString() {
        return "CreditCard: " + company;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        CreditCard that = (CreditCard) obj;
        return Objects.equals(this.company, that.company);
    }

    @Override
    public int hashCode() {
        return Objects.hash(company);
    }
}
