/* 

    a) Escribir un programa que calcule o número e cunha resolución a elexir polo usuario. A resolución indicará o número de términos que se teñen que utilizar para o cálculo, xa que se calculará utilizando a sucesión de Mac Laurin:

        e=1+1/1!+1/2!+1/3!+1/4!....

    Se aconsella desenvolver un método estático long factorial(int n); que retorne o factorial de n.

    b) Escribir un método estático double calcula_e(int precision); que retorna o valor de e coa precisión indicada. Solucionar o apartado a) facendo uso deste método.

    Se debe comprobar que a entrada de usuario é correcta

*/

import java.util.Scanner;

public class exercicio9 {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Crear un obxecto Scanner para ler a entrada do usuario
        int precision = 0; // Variable para almacenar a precisión

        // Ler a precisión e comprobar que sexa un número enteiro positivo
        while (true) {
            System.out.print("Introduce o numero de termos para calcular e: "); // Solicitar a precisión ao usuario
            if (scanner.hasNextInt()) { // Verificar se a entrada é un número enteiro
                precision = scanner.nextInt(); // Ler a precisión
                if (precision > 0) { // Comprobar que a precisión sexa positiva
                    break; // Saír do bucle se a entrada é válida
                } else {
                    System.out.println("Error: A precision debe ser un numero enteiro positivo."); // Mensaxe de erro se a precisión non é positiva
                }
            } else {
                System.out.println("Error: Introduce un valor numerico valido."); // Mensaxe de erro se a entrada non é un número
                scanner.next(); // Limpar o valor de entrada invalido
            }
        }

        // Calcular o valor de e utilizando o método calcula_e
        double e = calcula_e(precision); // Chamar ao método coa precisión indicada

        // Mostrar o resultado
        System.out.printf("O valor de e calculado cunha precision de %d termos e: %.10f\n", precision, e); // Imprimir o valor de e

        scanner.close(); // Cerrar o obxecto Scanner para liberar recursos
    }

    // Método para calcular o factorial de n
    public static long factorial(int n) {
        long result = 1; // Variable para almacenar o resultado do factorial
        for (int i = 2; i <= n; i++) { // Calcular o factorial de forma iterativa
            result *= i; // Multiplicar o resultado por i
        }
        return result; // Retornar o resultado do factorial
    }

    // Método para calcular o valor de e coa precisión indicada
    public static double calcula_e(int precision) {
        double e = 1.0; // Variable para almacenar o valor de e
        for (int i = 1; i < precision; i++) { // Iterar desde 1 ata a precisión
            e += 1.0 / factorial(i); // Sumar o termo da serie a e
        }
        return e; // Retornar o valor de e
    }
}