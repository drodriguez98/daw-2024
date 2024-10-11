/*

    a) Escribe un programa que solicite os coeficientes a, b e c dunha ecuacion de segundo grao ax²+bx+c=0 e a solucione ou indique que non ten solucions.

    b) Escribe un método estático double[] ec2g(double a, double b, double c) que recibe nos argumentos os coeficientes dunha ecuacion de segundo grao ax²+bx+c=0 e retorna no array as solucions ou null si a ecuacion non ten solucion. Escribir a solucion ao apartado a) facendo uso deste método.

*/

import java.util.Scanner;

public class exercicio8 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Crear un obxecto Scanner para ler a entrada do usuario
        double a = 0.0; // Coeficiente a
        double b = 0.0; // Coeficiente b
        double c = 0.0; // Coeficiente c

        // Ler os coeficientes a, b e c
        while (true) {
            System.out.print("Introduce o coeficiente a: "); // Solicitar coeficiente a
            if (scanner.hasNextDouble()) { // Verificar se a entrada é un numero decimal
                a = scanner.nextDouble(); // Ler coeficiente a
                break; // Saír do bucle se a entrada é valida
            } else {
                System.out.println("Error: Introduce un valor numerico valido."); // Mensaxe de erro se a entrada non é un numero
                scanner.next(); // Limpar o valor de entrada invalido
            }
        }

        while (true) {
            System.out.print("Introduce o coeficiente b: "); // Solicitar coeficiente b
            if (scanner.hasNextDouble()) { // Verificar se a entrada é un numero decimal
                b = scanner.nextDouble(); // Ler coeficiente b
                break; // Saír do bucle se a entrada é valida
            } else {
                System.out.println("Error: Introduce un valor numerico valido."); // Mensaxe de erro se a entrada non é un numero
                scanner.next(); // Limpar o valor de entrada invalido
            }
        }

        while (true) {
            System.out.print("Introduce o coeficiente c: "); // Solicitar coeficiente c
            if (scanner.hasNextDouble()) { // Verificar se a entrada é un numero decimal
                c = scanner.nextDouble(); // Ler coeficiente c
                break; // Saír do bucle se a entrada é valida
            } else {
                System.out.println("Error: Introduce un valor numerico valido."); // Mensaxe de erro se a entrada non é un numero
                scanner.next(); // Limpar o valor de entrada invalido
            }
        }

        // Resolver a ecuacion de segundo grao
        double[] solucions = ec2g(a, b, c); // Chamar ao método ec2g cos coeficientes

        // Mostrar os resultados
        if (solucions == null) { // Se non hai solucions
            System.out.println("A ecuacion non ten solucions reais.");
        } else if (solucions.length == 1) { // Unha solucion
            System.out.printf("A solucion é: %.2f\n", solucions[0]);
        } else { // Duas soluciones
            System.out.printf("As solucions son: %.2f e %.2f\n", solucions[0], solucions[1]);
        }

        scanner.close(); // Cerrar o obxecto Scanner para liberar recursos
    }

    // Método para resolver a ecuacion de segundo grao
    public static double[] ec2g(double a, double b, double c) {
        double discriminante = b * b - 4 * a * c; // Calcular o discriminante

        if (discriminante < 0) { // Se o discriminante é menor que 0, non hai solucions reais
            return null;
        } else if (discriminante == 0) { // Se o discriminante é igual a 0, hai unha solucion
            double solucion = -b / (2 * a); // Calcular a solucion
            return new double[]{solucion}; // Retornar o array coa solucion
        } else { // Se o discriminante é maior que 0, hai duas solucions
            double solucion1 = (-b + Math.sqrt(discriminante)) / (2 * a); // Primeira solucion
            double solucion2 = (-b - Math.sqrt(discriminante)) / (2 * a); // Segunda solucion
            return new double[]{solucion1, solucion2}; // Retornar o array coas solucions
        }
    }
}