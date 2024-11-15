package programacion.ud3.Exercicios.restaurante;

public class Cliente {

    // Atributos 

    private int id; // Identificación única do cliente
    private String nome; // Nome do cliente
    private String telefono; // Número de teléfono do cliente

    // Construtor

    public Cliente(int id, String nome, String telefono) {

        this.id = id;
        this.nome = nome;
        this.telefono = telefono;
        
    }

    // Métodos

    // Obter a identificación do cliente

    public int getId() { return id; }

    // Obter o nome do cliente

    public String getNome() { return nome; }

    // Obter o número de teléfono do cliente

    public String getTelefono() { return telefono; }

}