package Model.Enums;

import Model.Strategy.Clothing.CostumeStrategy;
import Model.Strategy.IPriceMethod;
import Model.Strategy.IStrategyCategory;

//Implementa la interfaz que devuelve el costo
public enum ClothingStrategies implements IStrategyCategory {
    STANDARD(new StandardStrategy()),
    COSTUME(new CostumeStrategy()),
    FORMAL(new Model.Strategy.Clothing.FormalStrategy());

    private final IPriceMethod clothingCostCalculator;
    ClothingStrategies(IPriceMethod clothingCostCalculator) {
        this.clothingCostCalculator = clothingCostCalculator;
    }

    @Override
    public IPriceMethod getCostStrategy() {
        return clothingCostCalculator;
    }
}
