package programacion.ud3.Exercicios.restaurante;

public class Factura {

    // Atributos

    private int id; // Identificación única da factura
    private Pedido pedido; // Pedido asociado á factura
    private float total; // Total a pagar

    // Construtor

    public Factura(int id, Pedido pedido) {

        this.id = id;
        this.pedido = pedido;
        this.total = pedido.calcularTotal(); // Calcula o total a partir do pedido

    }

    // Método para obter a identificación da factura

    public int getId() { return id; }

    // Método para obter o pedido asociado

    public Pedido getPedido() { return pedido; }

    // Método para obter o total a pagar

    public float getTotal() { return total; }

    public String xerarFactura() {

        StringBuilder factura = new StringBuilder();
        factura.append("Factura ID: ").append(id).append("\n");
        factura.append("Total: ").append(total).append("\n");
        return factura.toString(); // Método para xerar un resumo da factura

    }

}