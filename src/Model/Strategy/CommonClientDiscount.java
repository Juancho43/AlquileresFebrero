package Model.Strategy;

public class CommonClientDiscount implements IDiscount{
    @Override
    public double applyDiscount(double price) {
        return price * 0.03;
    }
}
