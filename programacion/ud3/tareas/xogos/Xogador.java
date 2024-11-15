package programacion.ud3.Exercicios.xogos;

// Clase que representa un xogador no xogo
public class Xogador {
    private final String nome;  // Nome do xogador
    private final Peza peza;    // Peza que o xogador usa no xogo

    // Constructor que inicializa o xogador co seu nome e peza
    public Xogador(String nome, Peza peza) {
        this.nome = nome;
        this.peza = peza;
    }

    // Método para obter o nome do xogador
    public String obterNome() {
        return nome;
    }

    // Método para obter a peza do xogador
    public Peza obterPieza() {
        return peza;
    }
}
