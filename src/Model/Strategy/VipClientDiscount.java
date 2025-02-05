package Model.Strategy;

public class VipClientDiscount implements IDiscount{
    @Override
    public double applyDiscount(double price) {
        return price * 0.25;
    }
}
