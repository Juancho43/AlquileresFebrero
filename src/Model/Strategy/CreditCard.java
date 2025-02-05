package Model.Strategy;

import Model.Entities.RentableObjects.RentableObject;
import Model.Entities.Rents.Rent;
import Model.Enums.ClientTypes;
import Model.Enums.RentState;

import java.util.Map;

public class CreditCard implements IPayment {

    //Map que contiene los tipos de clientes y sus strategy de descuentos, que se usan en CreditCard
    private final Map<ClientTypes, IDiscount> discountStrategies = Map.of(
            ClientTypes.COMMON, new CommonClientDiscount(),
            ClientTypes.VIP, new VipClientDiscount()
    );

    @Override
    public double calculate(ClientTypes clientTypes, Rent rent, RentableObject object) {
        double finalPrice = object.getPricePerDay() * rent.calculateDuration() * ((double) 10 /100);

        if(rent.getState() == RentState.OUTOFDATE){
            //En el caso de que haya un retraso en el alquiler, se le asigna una penalizacion de 15% por dia
            finalPrice += rent.calculateDelayDays() * object.getPricePerDay() * 0.15;
        }

        //Busca la estrategia de descuento correspondiente en el Map
        //si el tipo de cliente tiene una estrategia de descuento, la aplica
        //si el tipo de cliente no esta en el Map, el descuento es 0
        IDiscount discountStrategy = discountStrategies.getOrDefault(clientTypes, price -> 0);
        finalPrice -= discountStrategy.applyDiscount(finalPrice);
        return finalPrice;
    }

    @Override
    public String toString() {
        return "CreditCard";
    }
}
