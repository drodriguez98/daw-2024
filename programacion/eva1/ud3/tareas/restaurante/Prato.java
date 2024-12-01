package programacion.ud3.Exercicios.restaurante;

public class Prato {

    // Atributos

    private int id; // Identificación única do prato
    private String nome; // Nome do prato
    private float prezo; // Prezo do prato

    // Construtor

    public Prato(int id, String nome, float prezo) {

        this.id = id;
        this.nome = nome;
        this.prezo = prezo;

    }

    // Métodos

    // Obter a identificación do prato

    public int getId() { return id; }

    // Obter o nome do prato
    
    public String getNome() { return nome; }

    // Obter o prezo do prato

    public float getPrezo() { return prezo; }

}