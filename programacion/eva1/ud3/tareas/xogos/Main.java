package programacion.ud3.Exercicios.xogos;

// Clase principal para executar o xogo
public class Main {
    public static void main(String[] args) {
        Xogador xogador1 = new Xogador("Xogador 1", new Peza("X"));
        Xogador xogador2 = new Xogador("Xogador 2", new Peza("O"));

        TresEnRaia xogo = new TresEnRaia(xogador1, xogador2);

        // O xogador 1 coloca a súa peza ("X") na posición (0, 0)
        xogo.facerMovemento(new Movemento(0, 0, xogador1));

        // O xogador 2 coloca a súa peza ("O") na posición (1, 1)
        xogo.facerMovemento(new Movemento(1, 1, xogador2));

        // O xogador 1 coloca a súa peza ("X") na posición (0, 1)
        xogo.facerMovemento(new Movemento(0, 1, xogador1));

        // O xogador 2 coloca a súa peza ("O") na posición (1, 0)
        xogo.facerMovemento(new Movemento(1, 0, xogador2));

        // O xogador 1 coloca a súa peza ("X") na posición (0, 2)
        // Este movemento completa unha liña horizontal para o xogador 1, resultando nunha vitoria se as regras están ben configuradas.
        xogo.facerMovemento(new Movemento(0, 2, xogador1));

    }
}
