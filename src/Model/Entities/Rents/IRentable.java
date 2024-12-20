package Model.Entities.Rents;

public interface IRentable<E extends Object>{
    double getPricePerDay();
    String getDescription();
    double getEarning();
    Rent generateRent(int days);

    void setRentableObject(E object);


}
