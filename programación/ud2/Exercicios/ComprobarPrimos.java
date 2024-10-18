import java.util.Scanner;

public class ComprobarPrimos {
    public static void main(String[] args) {
        Scanner scanner = null;
        try {
            scanner = new Scanner(System.in);
            int cantidadNumeros = 5; // Cantidade de numeros a procesar

            // Procesar 5 numeros
            for (int i = 0; i < cantidadNumeros; i++) {
                System.out.print("Introduce un numero: ");
                int numero = scanner.nextInt();

                // Comprobar se e negativo
                if (numero < 0) {
                    System.out.println("O numero e negativo.");
                } else {
                    // Comprobar se e primo
                    if (esPrimo(numero)) {
                        System.out.println("O numero " + numero + " e primo.");
                    } else {
                        System.out.println("O numero " + numero + " non e primo.");
                    }
                }
            }

        } catch (Exception e) {
            System.out.println("Produciuse un erro: " + e.getMessage());
        } finally {
            if (scanner != null) {
                scanner.close();
            }
        }
    }

    // Metodo para comprobar se un numero e primo
    public static boolean esPrimo(int numero) {
        if (numero <= 1) {
            return false; // 0 e 1 non son primos
        }
        for (int i = 2; i <= Math.sqrt(numero); i++) {
            if (numero % i == 0) {
                return false; // Non e primo
            }
        }
        return true; // e primo
    }
}