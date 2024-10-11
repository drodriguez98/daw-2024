/*

    Escribir un programa que solicite dous numeros enteiros e visualice o cociente de dividir o primeiro entre o segundo e o seu resto sin facer uso dos operadores / ou %

    Se debe comprobar que os valores introducidos na entrada son correctos.

*/

import java.util.Scanner;

public class exercicio6_correxido {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Crear un obxecto Scanner para ler a entrada do usuario
        
        // Solicitar o dividendo e o divisor utilizando métodos separados
        int dividendo = pedirNumeroEntero(scanner, "Introduce o primeiro numero enteiro (dividendo): ");
        int divisor = pedirNumeroEnteroDistintoDeCero(scanner, "Introduce o segundo numero enteiro (divisor, distinto de 0): ");
        
        // Calcular o cociente e o resto sen usar / nin %
        int[] resultado = calcularCocienteEResto(dividendo, divisor);

        // Mostrar os resultados
        System.out.printf("Cociente de %d entre %d: %d\n", dividendo, divisor, resultado[0]); // Imprimir o cociente
        System.out.printf("Resto de %d entre %d: %d\n", dividendo, divisor, resultado[1]); // Imprimir o resto

        scanner.close(); // Cerrar o obxecto Scanner para liberar recursos
    }

    // Método para pedir un número entero
    public static int pedirNumeroEntero(Scanner scanner, String mensaje) {
        int numero = 0; // Inicializar a variable
        while (true) {
            System.out.print(mensaje);
            if (scanner.hasNext("q") || scanner.hasNext("Q")) {
                System.out.println("Saindo do programa...");
                System.exit(0);
            }
            if (scanner.hasNextInt()) {
                numero = scanner.nextInt();
                break; // Salir do bucle se a entrada é valida
            } else {
                System.out.println("Error: Introduce un valor numerico valido."); // Mensaxe de erro
                scanner.next(); // Limpar a entrada non válida
            }
        }
        return numero; // Devolver o número válido
    }

    // Método para pedir un número entero distinto de cero
    public static int pedirNumeroEnteroDistintoDeCero(Scanner scanner, String mensaje) {
        int numero = 0; // Inicializar a variable
        while (true) {
            System.out.print(mensaje);
            if (scanner.hasNext("q") || scanner.hasNext("Q")) {
                System.out.println("Saindo do programa...");
                System.exit(0);
            }
            if (scanner.hasNextInt()) {
                numero = scanner.nextInt();
                if (numero != 0) { // Comprobar que non sexa cero
                    break; // Salir do bucle se a entrada é valida
                } else {
                    System.out.println("Error: O divisor non pode ser 0."); // Mensaxe de erro
                }
            } else {
                System.out.println("Error: Introduce un valor numerico valido."); // Mensaxe de erro
                scanner.next(); // Limpar a entrada non válida
            }
        }
        return numero; // Devolver o número válido
    }

    // Método para calcular o cociente e o resto
    public static int[] calcularCocienteEResto(int dividendo, int divisor) {
        int cociente = 0; // Variable para almacenar o cociente
        int resto = dividendo; // Inicializar o resto como o dividendo

        // Restar o divisor do dividendo ata que o resto sexa menor que o divisor
        while (resto >= divisor) {
            resto -= divisor; // Restar o divisor do resto
            cociente++; // Aumentar o cociente
        }

        return new int[]{cociente, resto}; // Retornar o cociente e o resto como un array
    }
}