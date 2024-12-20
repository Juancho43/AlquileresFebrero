package Model.Entities;

public class PriceParameters {
    private int duration;
    private boolean discount;
    private double discountAmount;
    private double multiplier;
    private boolean highDemand;
    private double highDemandAmount;

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public boolean isDiscount() {
        return discount;
    }

    public void setDiscount(boolean discount) {
        this.discount = discount;
    }

    public double getDiscountAmount() {
        return discountAmount;
    }

    public void setDiscountAmount(double discountAmount) {
        this.discountAmount = discountAmount;
    }

    public double getMultiplier() {
        return multiplier;
    }

    public void setMultiplier(double multiplier) {
        this.multiplier = multiplier;
    }

    public boolean isHighDemand() {
        return highDemand;
    }

    public void setHighDemand(boolean highDemand) {
        this.highDemand = highDemand;
    }

    public double getHighDemandAmount() {
        return highDemandAmount;
    }

    public void setHighDemandAmount(double highDemandAmount) {
        this.highDemandAmount = highDemandAmount;
    }
}
