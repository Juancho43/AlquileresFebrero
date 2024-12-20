package Model.Enums;

import Model.Strategy.IPriceMethod;
import Model.Strategy.IStrategyCategory;
import Model.Strategy.Vehicle.CarStrategy;
import Model.Strategy.Vehicle.MotorcicleStrategy;
import Model.Strategy.Vehicle.TruckStrategy;

//Implementa que la interfaz que devuelve el costo
public enum VehicleStrategies implements IStrategyCategory {
    STANDARD(new StandardStrategy()),
    CAR(new CarStrategy()),
    MOTORCYCLE(new MotorcicleStrategy()),
    TRUCK(new TruckStrategy());

    private final IPriceMethod vehicleCostCalculator;
    VehicleStrategies(IPriceMethod vehicleCostCalculator){
        this.vehicleCostCalculator = vehicleCostCalculator;
    }

    @Override
    public IPriceMethod getCostStrategy() {
        return vehicleCostCalculator;
    }
}
