/*

    Escribir un programa que solicite dous numeros enteiros e visualice o resultado de elevar o primeiro numero ao segundo sen facer uso da clase Math.

    Se debe comprobar que os valores introducidos na entrada son correctos.

*/

import java.util.Scanner;

public class exercicio4_correxido {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Solicitar a base e o exponente utilizando métodos separados
        int base = pedirNumeroEnteiroPositivo(scanner, "Introduce o primeiro numero enteiro positivo (base ou 'q' para sair): ");
        int exponente = pedirNumeroEnteiroPositivo(scanner, "Introduce o segundo numero enteiro positivo (exponente ou 'q' para sair): ");

        // Calcular a potencia sen usar Math
        int resultado = calcularPotencia(base, exponente);

        // Mostrar o resultado
        System.out.printf("%d elevado a %d e igual a %d\n", base, exponente, resultado);

        scanner.close(); // Pechar o Scanner para liberar recursos
    }

    // Método para pedir un número enteiro positivo
    public static int pedirNumeroEnteiroPositivo(Scanner scanner, String mensaje) {
        int numero = -1;
        while (numero <= 0) {
            System.out.print(mensaje);
            if (scanner.hasNext("q") || scanner.hasNext("Q")) {
                System.out.println("Saindo do programa...");
                System.exit(0);
            }
            if (scanner.hasNextInt()) {
                numero = scanner.nextInt();
                if (numero <= 0) {
                    System.out.println("Error: O número debe ser enteiro positivo.");
                }
            } else {
                System.out.println("Error: Introduce un valor numerico valido.");
                scanner.next(); // Limpar a entrada non válida
            }
        }
        return numero;
    }

    // Método para calcular a potencia (base ^ exponente)
    public static int calcularPotencia(int base, int exponente) {
        int resultado = 1;
        for (int i = 0; i < exponente; i++) {
            resultado *= base;
        }
        return resultado;
    }
}