package hotel;

import utils.DniValidator;

public class Client {
    
    private final String dni;
    private String firstname;
    private String lastname;
    private String email;
    private String phone;

    public Client(String dni, String firstname, String lastname) {
        if (!new DniValidator().isValid(dni)) {
            throw new IllegalArgumentException("DNI inválido.");
        }
        this.dni = dni;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = "";
        this.phone = "";
    }

    public Client(String dni, String firstname, String lastname, String email, String phone) {
        this(dni, firstname, lastname);
        this.email = email;
        this.phone = phone;
    }

    public String getDni() { return dni; }

    public String getFirstname() { return firstname; }

    public String getLastname() { return lastname; }

    public String getEmail() { return email; }

    public String getPhone() { return phone; }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Client client = (Client) obj;
        return dni.equals(client.dni);

    }

}