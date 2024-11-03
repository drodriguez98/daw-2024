import java.util.Scanner;

public class CapitalizarPrimeiraLetra {
    public static void main(String[] args) {
        Scanner scanner = null;
        try {
            scanner = new Scanner(System.in);

            // Solicitar unha cadea de texto
            System.out.print("Introduce unha cadea de texto: ");
            String texto = scanner.nextLine();

            // Transformar a primeira letra en maiúscula
            String resultado = capitalizarPrimeiraLetra(texto);

            // Amosar o resultado
            System.out.println("Cadea transformada: " + resultado);

        } catch (Exception e) {
            System.out.println("Produciuse un erro: " + e.getMessage());
        } finally {
            if (scanner != null) {
                scanner.close();
            }
        }
    }

    // Método para capitalizar a primeira letra da cadea
    public static String capitalizarPrimeiraLetra(String texto) {
        if (texto == null || texto.isEmpty()) {
            return texto; // Retornar a cadea tal cual se está vacía ou é nula
        }

        // Transformar a primeira letra en maiúscula
        return texto.substring(0, 1).toUpperCase() + texto.substring(1);
    }
}
