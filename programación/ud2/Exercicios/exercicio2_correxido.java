/*

    Facer un programa que pida o total de quilometros recorridos, o prezo da gasolina (por litro), os cartos gastados en gasolina na viaxe e o tempo que se tardou (en horas e minutos), e que calcule:

    * Consumo de gasolina (en litros e euros) por cada cen quilometros.
    * Consumo de gasolina (en litros e euros) por cada quilómetro.
    * Velocidade media (en km/h e m/s).

    Se debe comprobar que os valores introducidos na entrada son correctos.

*/

import java.util.Scanner;

public class exercicio2_correxido {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double totalQuilometros = pedirDoublePositivo(scanner, "Introduce o total de quilometros recorridos (ou 'q' para sair): ");
        double prezoGasolinaPorLitro = pedirDoublePositivo(scanner, "Introduce o prezo da gasolina (por litro) (ou 'q' para sair): ");
        double cartosGastadosEnGasolina = pedirDoubleNonNegativo(scanner, "Introduce os cartos gastados en gasolina na viaxe (ou 'q' para sair): ");
        int horas = pedirEnteroNonNegativo(scanner, "Introduce o tempo que se tardou (horas) (ou 'q' para sair): ");
        int minutos = pedirMinutos(scanner, "Introduce o tempo que se tardou (minutos) (ou 'q' para sair): ");

        // Cálculos
        double tempoTotalEnHoras = horas + (minutos / 60.0);
        double gasolinaConsumidaEnLitros = cartosGastadosEnGasolina / prezoGasolinaPorLitro;
        double consumoPor100km = (gasolinaConsumidaEnLitros / totalQuilometros) * 100;
        double consumoPorKm = gasolinaConsumidaEnLitros / totalQuilometros;
        double velocidadeMediaKmh = totalQuilometros / tempoTotalEnHoras;
        double velocidadeMediaMs = velocidadeMediaKmh / 3.6;

        // Mostrar resultados
        System.out.printf("Consumo de gasolina por cada 100 quilometros: %.4f litros\n", consumoPor100km);
        System.out.printf("Consumo de gasolina por cada quilometro: %.4f litros\n", consumoPorKm);
        System.out.printf("Velocidade media: %.2f km/h\n", velocidadeMediaKmh);
        System.out.printf("Velocidade media: %.2f m/s\n", velocidadeMediaMs);

        scanner.close();
    }

    // Método para ler un número double positivo
    public static double pedirDoublePositivo(Scanner scanner, String mensaxe) {
        double valor = -1;
        while (valor <= 0) {
            System.out.print(mensaxe);
            if (scanner.hasNext("q") || scanner.hasNext("Q")) {
                System.out.println("Saindo do programa...");
                System.exit(0);
            }
            if (scanner.hasNextDouble()) {
                valor = scanner.nextDouble();
                if (valor <= 0) {
                    System.out.println("Error: O valor debe ser positivo.");
                }
            } else {
                System.out.println("Error: Introduce un valor numerico valido.");
                scanner.next(); // Limpar a entrada inválida
            }
        }
        return valor;
    }

    // Método para ler un número double non negativo
    public static double pedirDoubleNonNegativo(Scanner scanner, String mensaxe) {
        double valor = -1;
        while (valor < 0) {
            System.out.print(mensaxe);
            if (scanner.hasNext("q") || scanner.hasNext("Q")) {
                System.out.println("Saindo do programa...");
                System.exit(0);
            }
            if (scanner.hasNextDouble()) {
                valor = scanner.nextDouble();
                if (valor < 0) {
                    System.out.println("Error: O valor debe ser non negativo.");
                }
            } else {
                System.out.println("Error: Introduce un valor numerico valido.");
                scanner.next(); // Limpar a entrada inválida
            }
        }
        return valor;
    }

    // Método para ler un número enteiro non negativo
    public static int pedirEnteroNonNegativo(Scanner scanner, String mensaxe) {
        int valor = -1;
        while (valor < 0) {
            System.out.print(mensaxe);
            if (scanner.hasNext("q") || scanner.hasNext("Q")) {
                System.out.println("Saindo do programa...");
                System.exit(0);
            }
            if (scanner.hasNextInt()) {
                valor = scanner.nextInt();
                if (valor < 0) {
                    System.out.println("Error: O valor debe ser non negativo.");
                }
            } else {
                System.out.println("Error: Introduce un valor numerico valido.");
                scanner.next(); // Limpar a entrada inválida
            }
        }
        return valor;
    }

    // Método para ler o valor dos minutos (entre 0 e 59)
    public static int pedirMinutos(Scanner scanner, String mensaxe) {
        int valor = -1;
        while (valor < 0 || valor >= 60) {
            System.out.print(mensaxe);
            if (scanner.hasNext("q") || scanner.hasNext("Q")) {
                System.out.println("Saindo do programa...");
                System.exit(0);
            }
            if (scanner.hasNextInt()) {
                valor = scanner.nextInt();
                if (valor < 0 || valor >= 60) {
                    System.out.println("Error: Os minutos deben estar entre 0 e 59.");
                }
            } else {
                System.out.println("Error: Introduce un valor numerico valido.");
                scanner.next(); // Limpar a entrada inválida
            }
        }
        return valor;
    }
}