package Model.Entities;

public class Client {

    private long id;
    private String name;
    private String email;
    private String dni;
    private Client type;

    public Client(){

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

    public Model.Enums.Client getType() {
        return type;
    }

    public void setType(Client type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return email;
    }
}
