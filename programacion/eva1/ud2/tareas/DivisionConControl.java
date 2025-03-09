import java.util.Scanner;

public class DivisionConControl {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int dividendo;
        int divisor;
        int contadorDivisiones = 0;

        while (true) {
            // Solicitar o dividendo
            System.out.print("Introduce o dividendo (-1 para sair): ");
            dividendo = scanner.nextInt();

            // Solicitar o divisor
            System.out.print("Introduce o divisor (-1 para sair): ");
            divisor = scanner.nextInt();

            // Comprobar se o usuario quere sair (ambos números son -1)
            if (dividendo == -1 && divisor == -1) {
                break; // Sair do bucle
            }

            contadorDivisiones++; // Incrementar o contador ao inicio

            try {
                // Intentar realizar a división
                int resultado = dividendo / divisor;
                System.out.println("Resultado da division: " + resultado);
            } catch (ArithmeticException e) {
                // Controlar a excepción de división entre cero
                System.out.println("Error: Non se pode dividir entre cero.");
                // No se incrementa o contador aquí, ya que o intento fue válido
            }
        }

        // Mostrar o número total de divisiones realizadas
        System.out.println("Numero total de divisions calculadas: " + contadorDivisiones);
        scanner.close(); // Cerrar o escáner
    }
}
