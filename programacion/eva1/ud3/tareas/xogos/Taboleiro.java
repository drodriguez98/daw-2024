package programacion.ud3.Exercicios.xogos;

// Clase que representa o taboleiro dun xogo
public class Taboleiro {
    private final int filas;            // Número de filas do taboleiro
    private final int columnas;         // Número de columnas do taboleiro
    private final Peza[][] taboleiro;   // Matriz bidimensional que almacena as pezas no taboleiro

    // Constructor para inicializar o taboleiro co tamaño especificado
    public Taboleiro(int filas, int columnas) {
        this.filas = filas;
        this.columnas = columnas;
        this.taboleiro = new Peza[filas][columnas];
    }

    // Método para comprobar se unha posición está dentro dos límites do taboleiro
    public boolean posicionValida(int fila, int columna) {
        return fila >= 0 && fila < filas && columna >= 0 && columna < columnas;
    }

    // Método para comprobar se unha posición específica do taboleiro está baleira
    public boolean estaBaleira(int fila, int columna) {
        return posicionValida(fila, columna) && taboleiro[fila][columna] == null;
    }

    // Método para colocar unha peza nunha posición dada do taboleiro
    public void colocarPieza(int fila, int columna, Peza peza) throws IllegalArgumentException {
        if (!estaBaleira(fila, columna)) {
            throw new IllegalArgumentException("A posición xa está ocupada.");
        }
        taboleiro[fila][columna] = peza;
    }

    // Método para obter a peza situada nunha posición dada do taboleiro
    public Peza obterPieza(int fila, int columna) {
        if (posicionValida(fila, columna)) {
            return taboleiro[fila][columna];
        }
        return null;
    }

    // Método para verificar se todas as posicións do taboleiro están ocupadas
    public boolean completo() {
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                if (taboleiro[i][j] == null) return false;
            }
        }
        return true;
    }
}
