package Model.Strategy;

//Interfaz que devuelve el costo, aplicable a las estrategias
public interface IStrategyCategory {

    IPriceMethod getCostStrategy();

}
