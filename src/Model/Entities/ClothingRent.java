package Model.Entities;

public class ClothingRent implements IRentable<Clothing>{
    private Clothing object;
    private Rent rent;

    @Override
    public double getPricePerDay() {
        return this.object.pricePerDay;
    }

    @Override
    public String getDescription() {
        return null;
    }

    @Override
    public double getEarning() {
        return this.object.getPriceMethod().calculate();
    }

    @Override
    public Rent generateRent(int days) {
        this.rent = new Rent(days);
        return this.rent;
    }

    @Override
    public void setRentableObject(Clothing object) {
        this.object = object;
    }

}
