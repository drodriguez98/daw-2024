/*

    Escribir un programa que solicite un numero > 0 e visualice o seu factorial. O factorial dun numero natural n (enteiro  > 0) se define como o producto de todos os numeros dende 1 ata n.

    Se debe comprobar que os valores introducidos na entrada son correctos.

*/

import java.util.Scanner;

public class Factorial {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Crear un obxecto Scanner para ler a entrada do usuario
        
        // Solicitar un numero maior que 0 utilizando un método separado
        int numero = pedirNumeroMaiorQueCero(scanner, "Introduce un numero enteiro maior que 0 (ou 'q' para sair): ");
        
        // Calcular o factorial
        long factorial = calcularFactorial(numero);

        // Mostrar o resultado
        System.out.printf("O factorial de %d e %d\n", numero, factorial); // Imprimir o resultado

        scanner.close(); // Cerrar o obxecto Scanner para liberar recursos
    }

    // Método para pedir un numero entero maior que cero
    public static int pedirNumeroMaiorQueCero(Scanner scanner, String mensaxe) {
        int numero = -1; // Inicializar a variable a un valor inválido
        while (numero <= 0) {
            System.out.print(mensaxe);
            if (scanner.hasNext("q") || scanner.hasNext("Q")) {
                System.out.println("Saindo do programa...");
                System.exit(0);
            }
            if (scanner.hasNextInt()) {
                numero = scanner.nextInt();
                if (numero <= 0) {
                    System.out.println("Error: O numero debe ser maior que 0."); // mensaxe de error
                }
            } else {
                System.out.println("Error: Introduce un valor numerico valido."); // mensaxe de error
                scanner.next(); // Limpiar la entrada no válida
            }
        }
        return numero; // Devolver o numero válido
    }

    // Método para calcular o factorial
    public static long calcularFactorial(int numero) {
        long factorial = 1; // Variable para almacenar o factorial
        for (int i = 1; i <= numero; i++) { // Bucle dende 1 ata o numero
            factorial *= i; // Multiplicar o factorial polo numero actual
        }
        return factorial; // Devolver o resultado
    }
}