/*

    Escribir un programa que solicite un numero do 1 ao 9 e visualice a súa Taboa de multiplicar.

    Se debe comprobar que os valores introducidos na entrada son correctos.

*/

import java.util.Scanner;

public class exercicio3_correxido {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Solicitar y validar que el número esté entre 1 y 9
        int numero = pedirNumeroEntre1e9(scanner, "Introduce un numero do 1 ao 9 (ou 'q' para sair): ");

        // Mostrar a táboa de multiplicar do número ingresado
        mostrarTaboaMultiplicar(numero);

        scanner.close(); // Cerrar o Scanner para liberar recursos
    }

    // Método para pedir un número entero entre 1 y 9
    public static int pedirNumeroEntre1e9(Scanner scanner, String mensaje) {
        int numero = -1;
        while (numero < 1 || numero > 9) {
            System.out.print(mensaje);
            if (scanner.hasNext("q") || scanner.hasNext("Q")) {
                System.out.println("Saindo do programa...");
                System.exit(0);
            }
            if (scanner.hasNextInt()) {
                numero = scanner.nextInt();
                if (numero < 1 || numero > 9) {
                    System.out.println("Error: O numero debe estar entre 1 e 9.");
                }
            } else {
                System.out.println("Error: Introduce un valor numerico valido.");
                scanner.next(); // Limpiar la entrada inválida
            }
        }
        return numero;
    }

    // Método para mostrar a táboa de multiplicar dun número dado
    public static void mostrarTaboaMultiplicar(int numero) {
        System.out.println("Taboa de multiplicar do " + numero + ":");
        for (int i = 1; i <= 10; i++) {
            int resultado = numero * i;
            System.out.printf("%d x %d = %d\n", numero, i, resultado);
        }
    }
}