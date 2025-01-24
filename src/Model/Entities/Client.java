package Model.Entities;

import Model.Factory.IdFactory;
import Model.Strategy.IPayment;
import Model.Enums.ClientTypes;
public class Client {

    private long id;
    private String name;
    private String email;
    private String dni;
    private ClientTypes type;
    private IPayment favoritedMethod;


    public Client(){

    }

    public Client(String name, String email, String dni, ClientTypes type, IPayment paymentMethod) {
        this.id = IdFactory.generateUniqueId();
        this.name = name;
        this.email = email;
        this.dni = dni;
        this.type = type;
        this.favoritedMethod = paymentMethod;
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

    public ClientTypes getType() {
        return type.getType();
    }

    public void setType(ClientTypes type) {
        this.type = type;
    }

    public IPayment getPaymentMethod() {
        return favoritedMethod;
    }

    public void setPaymentMethod(IPayment paymentMethod) {
        this.favoritedMethod = paymentMethod;
    }

    @Override
    public String toString() {
        return "Cliente: " +
                name + ' ' + type + " " + favoritedMethod ;
    }
}
