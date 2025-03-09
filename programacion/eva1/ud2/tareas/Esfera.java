/*
    Facer un programa que lea por teclado o radio dun circulo (un valor real) e imprima a súa Area, a lonxitude da circunferencia que o delimita, xunto co volume (4 pi * r^3 / 3) e a superficie (4 * pi r^2) da esfera dese radio. 

    Os resultados deben amosarse con 4 decimais utilizando os modificadores de System.out.printf

    Se debe comprobar que os valores introducidos na entrada son correctos.
*/

import java.util.Scanner;
import java.util.InputMismatchException;
import static java.lang.Math.PI; // Importamos a constante, debemos poñer static

public class Esfera {

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in); // Creamos o obxecto Scanner para ler datos de teclado

        // Variables para gardar os resultados

        double radio;
        double area;
        double lonxitude;
        double volume;
        double superficie;

        try {

            System.out.print("Radio: ");

            radio = teclado.nextDouble(); // Leemos o radio introducido polo usuario

            if (radio <= 0) throw new InputMismatchException();  // Comprobamos que o radio é válido

            // Facemos os cálculos

            area = 2 * PI * radio;
            lonxitude = PI * radio * radio;
            volume = 4 * PI * radio * radio * radio / 3;
            superficie = 4 * PI * radio * radio;

            // Visualizamos os resultados

            System.out.printf("O Area do círculo é %.4f\n", area);
            System.out.printf("A Lonxitude da circunferencia é %.4f\n", lonxitude);
            System.out.printf("O Volume da esfera é %.4f\n", volume);
            System.out.printf("A Superficie da esfera é %.4f\n", superficie);

        } catch (InputMismatchException e) {

            System.out.println("Debes introducir un valor numérico > 0 usando a coma decimal");

        } finally { teclado.close(); } // Pechar o Scanner para evitar fugas de recursos}

    }
    
}