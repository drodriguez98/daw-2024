/*

    Facer un programa que lea por teclado o radio dun circulo (un valor real) e imprima a súa Area, a lonxitude da circunferencia que o delimita, xunto co volume (4 pi * r^3 / 3) e a superficie (4 * pi r^2) da esfera dese radio. Os resultados deben amosarse con 4 decimais utilizando os modificadores de System.out.printf

    Se debe comprobar que os valores introducidos na entrada son correctos.

*/

import java.util.Scanner;

public class exercicio1_correxido {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Leer el valor del radio
        double radio = pedirDoublePositivo(scanner, "Introduce o radio do circulo/esfera (valor positivo) ou 'q' para sair: ");

        // Cálculos de las propiedades del círculo y la esfera
        double areaCirculo = calcularAreaCirculo(radio);
        double lonxitudeCircunferencia = calcularLonxitudeCircunferencia(radio);
        double volumeEsfera = calcularVolumeEsfera(radio);
        double superficieEsfera = calcularSuperficieEsfera(radio);

        // Mostrar resultados con 4 decimales
        System.out.printf("Area do circulo: %.4f\n", areaCirculo);
        System.out.printf("Lonxitude da circunferencia: %.4f\n", lonxitudeCircunferencia);
        System.out.printf("Volume da esfera: %.4f\n", volumeEsfera);
        System.out.printf("Superficie da esfera: %.4f\n", superficieEsfera);

        scanner.close();
    }

    // Método para pedir un número double positivo
    public static double pedirDoublePositivo(Scanner scanner, String mensaje) {
        double valor = -1;
        while (valor <= 0) {
            System.out.print(mensaje);
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
                System.out.println("Error: Introduce un valor numerico válido.");
                scanner.next(); // Limpiar la entrada inválida
            }
        }
        return valor;
    }

    // Método para calcular el área del círculo
    public static double calcularAreaCirculo(double radio) {
        return Math.PI * Math.pow(radio, 2);
    }

    // Método para calcular la longitud de la circunferencia
    public static double calcularLonxitudeCircunferencia(double radio) {
        return 2 * Math.PI * radio;
    }

    // Método para calcular el volumen de la esfera
    public static double calcularVolumeEsfera(double radio) {
        return (4.0 / 3.0) * Math.PI * Math.pow(radio, 3);
    }

    // Método para calcular la superficie de la esfera
    public static double calcularSuperficieEsfera(double radio) {
        return 4 * Math.PI * Math.pow(radio, 2);
    }
}
