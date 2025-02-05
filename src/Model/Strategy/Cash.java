package Model.Strategy;

import Model.Entities.RentableObjects.RentableObject;
import Model.Entities.Rents.Rent;
import Model.Enums.ClientTypes;
import Model.Enums.RentState;

import java.util.Map;

public class Cash implements IPayment {

    //Map que contiene los tipos de clientes y sus strategy de descuentos, que se usan en Cash
    private final Map<ClientTypes, IDiscount> discountStrategies = Map.of(
            ClientTypes.COMMON, new CommonClientDiscount(),
            ClientTypes.VIP, new VipClientDiscount()
    );
    @Override
    public double calculate(ClientTypes clientTypes, Rent rent, RentableObject object) {
        double finalPrice = object.getPricePerDay() * rent.calculateDuration();

        if(rent.getState() == RentState.OUTOFDATE){
            //En el caso de que haya un retraso en el alquiler, se le asigna una penalizacion de 10% por dia
            finalPrice += rent.calculateDelayDays() * object.getPricePerDay() * 0.1;
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
        return "Cash";
    }
}
