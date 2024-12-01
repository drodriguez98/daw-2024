package programacion.ud3.Exercicios.xogos;

// Clase que implementa o xogo do Tres en Raia, herdando de Xogo
public class TresEnRaia extends Xogo {
    public TresEnRaia(Xogador xogador1, Xogador xogador2) {
        super(3, 3, xogador1, xogador2);
    }

    // Valida se o movemento é nunha posición válida e baleira do taboleiro
    @Override
    public boolean validarMovemento(Movemento movemento) {
        return taboleiro.posicionValida(movemento.obterFila(), movemento.obterColumna()) && 
               taboleiro.estaBaleira(movemento.obterFila(), movemento.obterColumna());
    }

    // Verifica se hai unha liña de tres fichas iguais
    @Override
    public boolean verificarEstadoXogo() {
        Peza[][] celas = new Peza[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                celas[i][j] = taboleiro.obterPieza(i, j);
            }
        }

        for (int i = 0; i < 3; i++) {
            if (celas[i][0] != null && celas[i][0] == celas[i][1] && celas[i][1] == celas[i][2]) return true;
            if (celas[0][i] != null && celas[0][i] == celas[1][i] && celas[1][i] == celas[2][i]) return true;
        }
        return celas[0][0] != null && celas[0][0] == celas[1][1] && celas[1][1] == celas[2][2] || 
               celas[0][2] != null && celas[0][2] == celas[1][1] && celas[1][1] == celas[2][0];
    }
}
