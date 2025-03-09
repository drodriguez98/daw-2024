/*

    Facer un programa que pida o total de quilometros recorridos, o prezo da gasolina (por litro), os cartos gastados en gasolina na viaxe e o tempo que se tardou (en horas e minutos), e que calcule:

    * Consumo de gasolina (en litros e euros) por cada cen quilometros.
    * Consumo de gasolina (en litros e euros) por cada quilómetro.
    * Velocidade media (en km/h e m/s).

    Se debe comprobar que os valores introducidos na entrada son correctos.

*/

import java.util.Scanner;

public class Viaje {

    // Si o usuario pulsa 's' indicará que desexa abandonar a operación. Cambiamos a interrupción por outra máis axeitada, como InterruptedException.

    public static int inputInteger(String title, int min, int max) throws InterruptedException {

        Scanner teclado = new Scanner(System.in);
        boolean ok = false;
        String line = null;
        int num = 0;

        do {

            try {

                System.out.print(title + " (s para cancelar): ");

                line = teclado.nextLine(); // Si definimos aquí line, só existe no bloque {} e non podemos usala no catch
                num = Integer.parseInt(line); // Pode darse a "situación excepcional" de que o usuario non escriba un int

                if (num >= min && num <= max) ok = true; // Xa temos a info correcta

            } catch (NumberFormatException e) {

                // Necesitamos saber si pulsou "s"...

                if (line.equals("s")) throw new InterruptedException();

                // ok segue a ser false, non precisamos facer nada

            } finally { teclado.close(); } // Pechar o Scanner para evitar fugas de recursos

        } while (!ok);

        return num;

    }

    public static double inputDouble(String title, double min, double max) throws InterruptedException {

        boolean ok = false;
        Scanner teclado = new Scanner(System.in);
        String line = null;
        double num = 0.0;

        do {

            try {

                System.out.print(title + " (s para cancelar): ");
                line = teclado.nextLine();
                num = Double.parseDouble(line); // Pode darse a "situación excepcional" de que o usuario non escriba un double

                if (num >= min && num <= max) ok = true; // Xa temos a info correcta

            } catch (NumberFormatException e) {

                // Necesitamos saber si pulsou "s"

                if (line.equals("s")) throw new InterruptedException();

                // ok segue a ser false, non precisamos facer nada

            } finally { teclado.close(); } // Pechar o Scanner para evitar fugas de recursos
            
        } while (!ok);

        return num;

    }

    public static int inputTempo(String title) throws InterruptedException {

        System.out.println(title);

        int horas = inputInteger("\tHoras: ", 0, 23); // Si o dato introducido non é válido recibimos un sinal InputMismatchException
        int minutos = inputInteger("\tMinutos: ", 0, 59);

        return horas * 60 + minutos;
    }

    public static void main(String[] args) {

        try {

            int total_km = inputInteger("Introduce Total Km: ", 0, Integer.MAX_VALUE);
            double prezo_litro = inputDouble("Introduce prezo en € por litro: ", 0, Double.MAX_VALUE);
            double cartos_gastados = inputDouble("Introduce o gasto total en combustible en €: ", 0, Double.MAX_VALUE);
            int total_minutos = inputTempo("Introduce o tempo empregado: "); // O mellor é retornar o tempo en minutos, logo o podemos transformar como queiramos

            // Facemos os cálculos

            double consumo_euros_km = cartos_gastados / total_km;
            double consumo_litros_km = (cartos_gastados / prezo_litro) / total_km;
            double consumo_euros_100km = consumo_euros_km * 100;
            double consumo_litros_100km = consumo_litros_km * 100;
            double velocidade_km_minuto = (float) total_km / total_minutos;
            double velocidade_m_s = velocidade_km_minuto * 1000 / 60;
            double velocidade_km_h = velocidade_km_minuto * 60;

            // Visualizamos Resultados

            System.out.printf("Consumo por Km: %.4f l/km\n", consumo_litros_km);
            System.out.printf("Consumo cada 100 km: %.4f l aos 100 km\n", consumo_litros_100km);
            System.out.printf("O gasto por Km foi de %.4f €, e por 100 km de %.4f €\n", consumo_euros_km, consumo_euros_100km);
            System.out.printf("A velocidade media foi de %.4f km/h (%.4f m/s)\n", velocidade_km_h, velocidade_m_s);

        } catch (InterruptedException e) { System.out.println("Operación Cancelada. Execute de novo o programa si o desexa"); }

    }

}