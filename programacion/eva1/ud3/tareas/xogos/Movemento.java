package programacion.ud3.Exercicios.xogos;

// Clase que representa un movemento realizado por un xogador
public class Movemento {
    private final int fila;           // Fila do movemento
    private final int columna;        // Columna do movemento
    private final Xogador xogador;    // Xogador que realiza o movemento

    // Constructor que inicializa un movemento coa posición e xogador correspondente
    public Movemento(int fila, int columna, Xogador xogador) {
        this.fila = fila;
        this.columna = columna;
        this.xogador = xogador;
    }

    // Método para obter a fila do movemento
    public int obterFila() {
        return fila;
    }

    // Método para obter a columna do movemento
    public int obterColumna() {
        return columna;
    }

    // Método para obter o xogador que realiza o movemento
    public Xogador obterXogador() {
        return xogador;
    }
}
