package Model.Entities;

import Model.Factory.IdFactory;
import Model.Strategy.IPayment;

public class Client {

    private long id;
    private String name;
    private String email;
    private String dni;
    private ClientType type;
    private IPayment favoriteMethod;


    public Client(){

    }

    public Client(String name, String email, String dni, ClientType type, IPayment paymentMethod) {
        this.id = IdFactory.generateUniqueId();
        this.name = name;
        this.email = email;
        this.dni = dni;
        this.type = type;
        this.favoriteMethod = paymentMethod;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public ClientType getType() {
        return type;
    }

    public void setClientTypeId(ClientType clientTypeId) {
        this.type =clientTypeId ;
    }

    public IPayment getPaymentMethod() {
        return favoriteMethod;
    }

    public void setPaymentMethod(IPayment paymentMethod) {
        this.favoriteMethod = paymentMethod;
    }

    @Override
    public String toString() {
        return name + ' ' + type + " " + favoriteMethod;
    }
}
