package programacion.ud3.Exercicios.restaurante;

public class Reserva {

    // Atributos

    private int id; // Identificación única da reserva
    private String data; // Data da reserva
    private String hora; // Hora da reserva
    private int numeroPersoas; // Número de persoas para a reserva
    private Cliente cliente; // Cliente asociado á reserva

    // Construtor

    public Reserva(int id, String data, String hora, int numeroPersoas, Cliente cliente) {

        this.id = id;
        this.data = data;
        this.hora = hora;
        this.numeroPersoas = numeroPersoas;
        this.cliente = cliente;

    }

    // Métodos

    // Obter a identificación da reserva

    public int getId() { return id; }

    // Obter a data da reserva

    public String getData() { return data; }

    // Obter a hora da reserva

    public String getHora() { return hora; }

    // Obter o número de persoas

    public int getNumeroPersoas() { return numeroPersoas; }

    // Obter o cliente asociado á reserva

    public Cliente getCliente() { return cliente; }

}