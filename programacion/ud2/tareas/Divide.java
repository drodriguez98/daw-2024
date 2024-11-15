/*
    Escribir un programa que solicite dous numeros enteiros e visualice o cociente de dividir o primeiro entre o segundo e o seu resto sen facer uso dos operadores / ou %

    Se debe comprobar que os valores introducidos na entrada son correctos.
*/

import java.util.Scanner;
import java.util.InputMismatchException;

public class Divide {

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in); // Inicializamos el Scanner

        try {

            int signo = 1;

            // Pedimos datos
            
            System.out.print("Dividendo: ");
            int dividendo = teclado.nextInt();
            System.out.print("Divisor: ");
            int divisor = teclado.nextInt();

            if (divisor == 0) throw new InputMismatchException("Non se pode dividir por 0");

            System.out.print(dividendo + "/" + divisor + "=");

            // Axustamos signo.

            // Si o dividendo é negativo, o pasamos a positivo e o signo é negativo
            if (dividendo < 0) {

                signo = -1;
                dividendo = -dividendo;

            }

            if (divisor < 0) {

                signo = signo * -1;
                divisor = -divisor;

            }

            // Calculamos división

            int cociente = 0;

            while (dividendo >= divisor) {

                dividendo -= divisor;
                cociente = cociente + 1;

            }

            cociente = cociente * signo; // Poñemos signo ao resultado

            System.out.println(cociente); // Visualizamos

        } catch (InputMismatchException e) {

            System.out.println("Entrada de datos errónea");
            String message = e.getMessage();

            if (message != null) System.out.println(message);

        } finally { teclado.close(); } // Pechar o Scanner para evitar fugas de recursos

    }

}