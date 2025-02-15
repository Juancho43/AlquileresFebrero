package Model.Entities.Clients;

import Exceptions.Exceptions;
import Model.Factory.IdFactory;
import Model.Strategy.IPayment;

import java.util.Optional;

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
        this.setEmail(email);
        this.setDni(dni);
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
        if (!isValidEmail(email)) {
            throw new Exceptions.IllegalEmailException("El email no es válido.");
        }
        this.email = email;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        if (!isValidDNI(dni)) {
            throw new Exceptions.IllegalDNIException("El DNI debe tener 8 dígitos numéricos");
        }
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

    //Validaciones especificas

    private boolean isValidDNI(String dni) {
        // Expresión regular para validar el DNI
        String dniRegex = "^[0-9]{7,10}$";
        return dni != null && dni.matches(dniRegex);
    }

    private boolean isValidEmail(String email) {
        String emailRegex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$";
        return email.matches(emailRegex);
    }
}
