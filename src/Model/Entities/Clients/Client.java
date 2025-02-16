package Model.Entities.Clients;

import Model.Exceptions.Exceptions;
import Model.Factory.IdFactory;
import Model.Strategy.IPayment;

/**
 * Represents a client in the system.
 * This class stores information about a client, including their name, email, DNI,
 * client type, and preferred payment method.  It also includes validation logic
 * for email and DNI.
 */
public class Client {

    private long id;
    private String name;
    private String email;
    private String dni;
    private ClientType type;
    private IPayment favoriteMethod;

    /**
     * Default constructor.  Used for frameworks like Hibernate.
     */
    public Client(){

    }

    /**
     * Constructor for creating a new client.
     *
     * @param name          The client's name.
     * @param email         The client's email address.
     * @param dni           The client's DNI (National Identity Document).
     * @param type          The client's type (e.g., Regular, Premium).
     * @param paymentMethod The client's preferred payment method.
     */
    public Client(String name, String email, String dni, ClientType type, IPayment paymentMethod) {
        this.id = IdFactory.generateUniqueId(); // Assign a unique ID using a factory.
        this.name = name;
        this.setEmail(email); // Validate and set the email.
        this.setDni(dni);     // Validate and set the DNI.
        this.type = type;
        this.favoriteMethod = paymentMethod;
    }

    /**
     * Gets the client's ID.
     *
     * @return The client's ID.
     */
    public long getId() {
        return id;
    }

    /**
     * Sets the client's ID.  Generally used by persistence frameworks.
     *
     * @param id The client's ID.
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * Gets the client's name.
     *
     * @return The client's name.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the client's name.
     *
     * @param name The client's name.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the client's email address.
     *
     * @return The client's email address.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the client's email address.  Performs validation.
     *
     * @param email The client's email address.
     * @throws Exceptions.IllegalEmailException If the email is invalid.
     */
    public void setEmail(String email) {
        if (!isValidEmail(email)) {
            throw new Exceptions.IllegalEmailException("El email no es válido.");
        }
        this.email = email;
    }

    /**
     * Gets the client's DNI.
     *
     * @return The client's DNI.
     */
    public String getDni() {
        return dni;
    }

    /**
     * Sets the client's DNI.  Performs validation.
     *
     * @param dni The client's DNI.
     * @throws Exceptions.IllegalDNIException If the DNI is invalid.
     */
    public void setDni(String dni) {
        if (!isValidDNI(dni)) {
            throw new Exceptions.IllegalDNIException("El DNI debe tener 7 a 10 dígitos numéricos"); // Corrected error message
        }
        this.dni = dni;
    }

    /**
     * Gets the client's type.
     *
     * @return The client's type.
     */
    public ClientType getType() {
        return type;
    }

    /**
     * Sets the client's type.
     *
     * @param clientType The client's type.
     */
    public void setClientType(ClientType clientType) {
        this.type = clientType;
    }

    /**
     * Gets the client's preferred payment method.
     *
     * @return The client's preferred payment method.
     */
    public IPayment getPaymentMethod() {
        return favoriteMethod;
    }

    /**
     * Sets the client's preferred payment method.
     *
     * @param paymentMethod The client's preferred payment method.
     */
    public void setPaymentMethod(IPayment paymentMethod) {
        this.favoriteMethod = paymentMethod;
    }



    // Specific validations

    /**
     * Validates the DNI format.
     *
     * @param dni The DNI to validate.
     * @return True if the DNI is valid, false otherwise.
     */
    private boolean isValidDNI(String dni) {
        // Regular expression to validate the DNI (7 to 10 digits).
        String dniRegex = "^[0-9]{7,10}$"; // Corrected regex to allow 7 to 10 digits.
        return dni != null && dni.matches(dniRegex);
    }

    /**
     * Validates the email format.
     *
     * @param email The email to validate.
     * @return True if the email is valid, false otherwise.
     */
    private boolean isValidEmail(String email) {
        String emailRegex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$";
        return email != null && email.matches(emailRegex); // Added null check
    }


    /**
     * Returns a string representation of the client.
     *
     * @return A string representation of the client (name, type, and payment method).
     */
    @Override
    public String toString() {
        return name + ' ' + type + " " + favoriteMethod;
    }
}