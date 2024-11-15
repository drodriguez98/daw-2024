package programacion.ud3.Exercicios.xogos;

// Clase que representa unha peza que se usa no xogo
public class Peza {
    private final String simbolo;  // Símbolo que representa a peza (por exemplo, "X" ou "O")

    // Constructor que inicializa a peza co seu símbolo
    public Peza(String simbolo) {
        this.simbolo = simbolo;
    }

    // Método para representar a peza como unha cadea de caracteres
    @Override
    public String toString() {
        return simbolo;
    }
}
