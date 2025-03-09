package programacion.ud3.Exercicios.restaurante;

import java.util.List;

public class Menu {

    // Atributos

    private int id; // Identificación única do menú
    private List<Prato> pratos; // Lista de pratos que compoñen o menúç

    // Construtor

    public Menu(int id, List<Prato> pratos) {

        this.id = id;
        this.pratos = pratos;
        
    }

    // Métodos

    // Obter a identificación do menú

    public int getId() { return id; }

    // Obter a lista de pratos

    public List<Prato> getPratos() { return pratos; }

    // Calcular o prezo total dos pratos no menú

    public float calcularPrezoTotal() {
        float total = 0;
        for (Prato prato : pratos) {
            total += prato.getPrezo(); // Sumar o prezo de cada prato
        }
        return total; 
    }

}