/*

    Escribir un programa que solicite un numero > 0 e visualice o seu factorial. O factorial dun numero natural n (enteiro  > 0) se define como o producto de todos os numeros dende 1 ata n.

    Se debe comprobar que os valores introducidos na entrada son correctos.

*/

import java.util.Scanner;
import java.util.InputMismatchException;

public class Factorial {

    /* O cálculo do factorial é unha operación útil que non existe na libraría de java Math, de modo que, aínda que é simple, facemos un método */

    /* Calcula o factorial dun número */
    /* @param numero Número do que desexamos o factorial */ 
    /* @return O factorial do número */

    public static long factorial(int numero) {

        // Implementación recursiva do cálculo do factorial

        if (numero == 0) return 1; // Caso base: 0! é 1
        return numero * factorial(numero - 1); // Caso recursivo

    }

    public static void main(String[] args) {

        try {

            // Pedir Datos

            Scanner teclado = new Scanner(System.in);

            System.out.print("Numero: ");
            int numero = teclado.nextInt();

            // Verificación de que o número sexa >= 0, calcular o factorial e imprimir o resultado

            if (numero < 0) throw new InputMismatchException();

            long resultado = factorial(numero);

            System.out.println(numero + "! = " + resultado);

        } catch (InputMismatchException e) {

            System.out.println("Debes introducir un número enteiro >= 0. Os números grandes darán valores erróneos.");

        } 

    }

}