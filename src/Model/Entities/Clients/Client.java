package Model.Entities.Clients;

import Model.Entities.ICloneable;
import Model.Validators.DNIValidator;
import Model.Validators.EmailValidator;
import Model.Validators.StringValidator;

import Model.Factory.IdFactory;
import Model.Strategy.IPayment;

/**
 * Represents a client in the system.
 * This class stores information about a client, including their name, email, DNI,
 * client type, and preferred payment method.  It also includes validation logic
 * for email and DNI.
 * It also implements the {@code ICloneable} interface for cloning.
 */
public class Client implements ICloneable<Client> {

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
        this.setName(name);
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
        StringValidator.validateString(name);
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
     */
    public void setEmail(String email) {
        EmailValidator.validateEmail(email);
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
     */
    public void setDni(String dni) {
        DNIValidator.validateDNI(dni);
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



    /**
     * Returns a string representation of the client.
     *
     * @return A string representation of the client (name, type, and payment method).
     */
    @Override
    public String toString() {
        return name + ' ' + type + " " + favoriteMethod;
    }

    /**
     * Creates and returns a deep copy of this {@code Client} object.
     * This method creates a new, independent copy of this {@code Client} instance,
     * including a deep copy of its composite object (the `type` field, which
     * represents the client's type). This ensures that modifications to the
     * cloned {@code Client} do not affect the original, and vice-versa.  It is
     * crucial for maintaining data integrity and preventing unintended side effects.
     *
     * @return A deep clone of this {@code Client} object.
     * @throws RuntimeException If an error occurs during the cloning process. This
     *                          exception wraps any underlying {@code CloneNotSupportedException}
     *                          and provides a more informative error message, including
     *                          the original exception's message.
     */
    @Override
    public Client clone() {
        try {
            Client clonedClient = (Client) super.clone(); // Shallow clone first
            // Deep clone the mutable objects:
            clonedClient.type = this.type.clone(); // Clone the ClientType object
            return clonedClient;
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("Error cloning Client object: " + e.getMessage(), e); // More informative message
        }
    }
}