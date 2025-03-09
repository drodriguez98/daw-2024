package database;

// Clase Cliente que implementa la interfaz Storable, permitiendo ser almacenada en la base de datos.
public class Cliente implements Storable<String> {
    
    // Atributos de la clase Cliente: DNI (clave única) y nombre.
    private final String dni;
    private String nome;

    // Constructor que recibe el DNI y el nombre del cliente.
    public Cliente(String dni, String nome) {
        this.dni = dni;
        this.nome = nome;
    }

    @Override
    public String getKey() {
        // Retorna el DNI como clave única.
        return dni;
    }

    // Getter para el nombre del cliente.
    public String getNome() {
        return nome;
    }

    // Setter para el nombre del cliente.
    public void setNome(String nome) {
        this.nome = nome;
    }

    // Método toString para representar al cliente como un string.
    @Override
    public String toString() {
        return "Cliente{DNI='" + dni + "', Nome='" + nome + "'}";
    }
}
