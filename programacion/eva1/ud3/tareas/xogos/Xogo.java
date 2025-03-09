package programacion.ud3.Exercicios.xogos;

// Clase abstracta que representa un xogo de mesa xeral
public abstract class Xogo {
    protected Taboleiro taboleiro;       // O taboleiro onde se xoga
    protected Xogador xogador1;          // Primeiro xogador
    protected Xogador xogador2;          // Segundo xogador
    protected Xogador xogadorActual;     // Xogador que realiza o movemento actual

    // Constructor que inicializa o xogo cos xogadores e o tamaño do taboleiro
    public Xogo(int filas, int columnas, Xogador xogador1, Xogador xogador2) {
        this.taboleiro = new Taboleiro(filas, columnas);
        this.xogador1 = xogador1;
        this.xogador2 = xogador2;
        this.xogadorActual = xogador1;
    }

    // Método abstracto para validar se un movemento é válido
    public abstract boolean validarMovemento(Movemento movemento);

    // Método abstracto para verificar o estado do xogo
    public abstract boolean verificarEstadoXogo();

    // Método para realizar un movemento no xogo
    public void facerMovemento(Movemento movemento) throws IllegalArgumentException {
        if (!validarMovemento(movemento)) {
            throw new IllegalArgumentException("Movemento non válido.");
        }

        taboleiro.colocarPieza(movemento.obterFila(), movemento.obterColumna(), movemento.obterXogador().obterPieza());

        if (verificarEstadoXogo()) {
            System.out.println("O xogador " + xogadorActual.obterNome() + " gañou o xogo!");
        } else if (taboleiro.completo()) {
            System.out.println("O xogo remata en empate.");
        } else {
            xogadorActual = xogadorActual == xogador1 ? xogador2 : xogador1;
        }
    }
}
