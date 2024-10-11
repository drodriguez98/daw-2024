/*
*   Escribir un programa que solicite dous números enteiros e visualice o resultado de elevar o primeiro número ao segundo sen facer uso da clase Math.
*
*   Se debe comprobar que os valores introducidos na entrada son correctos
*/

import java.util.Scanner;

public class Potencia {

    // Si o usuario pulsa 's' indicará que desexa abandonar a operación.  Cambiamos a interrupción por outra máis axeitada, como InterruptedException

    public static int inputInteger(String title, int min, int max) throws InterruptedException {
        
        Scanner teclado = new Scanner(System.in);
        boolean ok = false;
        String line = null;
        int num = 0;

        do {

            try {

                System.out.print(title + " (s para cancelar): ");

                line = teclado.nextLine();  // Si definimos aquí line, só existe no bloque {} e non podemos usala no catch
                num = Integer.parseInt(line);  // Pode darse a "situación excepcional" de que o usuario non escriba un int

                if (num >= min && num <= max) ok = true;  // Xa temos a info correcta

            } catch (NumberFormatException e) {

                if (line.equals("s")) throw new InterruptedException(); // Necesitamos saber si pulsou "s"

                // ok segue a ser false, non precisamos facer nada

            } finally { teclado.close(); } // Pechar o Scanner para evitar fugas de recursos

        } while (!ok);

        return num;

    }

    /* Imos contemplar a posibilidade de que o expoñente poda ser negativo. */

    public static void main(String[] args) {

        try {

            boolean negativo = false;

            // MIN_VALUE e MAX_VALUE son constantes que conteñen o mínimo e máximo valor integer posible

            int base = inputInteger("Introduce a base", Integer.MIN_VALUE, Integer.MAX_VALUE);
            int exp = inputInteger("Introduce o expoñente", Integer.MIN_VALUE, Integer.MAX_VALUE);

            System.out.printf("El resultado de %d^%d = ", base, exp);

            if (exp < 0) {

                negativo = true;
                exp = -exp;

            }

            double result = 1;

            // Solución alternativa

            while (exp > 0) {

                result = result * base;
                exp = exp - 1;

            }

            if (negativo) result = 1 / result;

            System.out.printf("%.8f\n", result);

        } catch (InterruptedException e) {

            System.out.println("Operación Cancelada");

        }

    }

}