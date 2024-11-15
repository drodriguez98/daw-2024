package programacion.ud3.Exercicios.restaurante;

import java.util.List;

public class Pedido {

    // Atributos

    private int id; // Identificación única do pedido
    private Reserva reserva; // Reserva asociada ao pedido
    private List<Prato> pratosSolicitados; // Lista de pratos solicitados

    // Construtor

    public Pedido(int id, Reserva reserva, List<Prato> pratosSolicitados) {

        this.id = id;
        this.reserva = reserva;
        this.pratosSolicitados = pratosSolicitados;

    }

    // Obter a identificación do pedido

    public int getId() { return id; }

    // Obter a reserva asociada

    public Reserva getReserva() { return reserva; }

    // Obter a lista de pratos solicitados

    public List<Prato> getPratosSolicitados() { return pratosSolicitados; }

    // Calcular o total do pedido

    public float calcularTotal() {
        float total = 0;
        for (Prato prato : pratosSolicitados) {
            total += prato.getPrezo(); // Sumar o prezo de cada prato solicitado
        }
        return total; 
    }

}