/*
*
*       Escribir un programa que solicite un numero do 1 ao 9 e visualice a súa Taboa de multiplicar.
*
*       Se debe comprobar que os valores introducidos na entrada son correctos.
*
*/

import java.util.Scanner;

public class Multiplicador {

    public static int inputInteger(String title, int min, int max) throws InterruptedException {

        Scanner teclado = new Scanner(System.in);
        boolean ok = false;
        String line = null;
        int num = 0;

        do {

            try {

                System.out.print(title + " (s para cancelar): ");
                line = teclado.nextLine();  // Si definimos aquí line, solo existe en el bloque {} y no podemos usarla en el catch
                num = Integer.parseInt(line);  // Puede darse la "situación excepcional" de que el usuario no escriba un int... (NumberFormatException)

                if (num >= min && num <= max) ok = true;  // Ya tenemos la información correcta

            } catch (NumberFormatException e) {

                // Necesitamos saber si pulsó "s"

                if (line.equals("s")) throw new InterruptedException();

                // ok sigue siendo false, no necesitamos hacer nada

            } finally { teclado.close(); } // Pechar o Scanner para evitar fugas de recursos

        } while (!ok);

        return num;

    }

    public static void main(String[] args) {

        try {

            int numero = inputInteger("Introduce un numero entre 1 e 9", 1, 9);
            System.out.printf("Tabla do %d\n-----------\n", numero);

            for (int valor = 1; valor <= 10; valor = valor + 1)
                System.out.printf("%d * %d = %d\n", numero, valor, numero * valor);
        
        } catch (InterruptedException e) { System.out.println("Operación cancelada"); } 

    }
    
}