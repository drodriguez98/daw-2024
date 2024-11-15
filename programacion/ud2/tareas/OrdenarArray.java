import java.util.Scanner;

public class OrdenarArray {
    public static void main(String[] args) {
        Scanner scanner = null;
        try {
            scanner = new Scanner(System.in);
            int[] numeros = new int[7];

            // Solicitar ao usuario que ingrese os numeros
            for (int indice = 0; indice < numeros.length; indice++) {
                System.out.print("Introduce o numero " + (indice + 1) + ": ");
                numeros[indice] = scanner.nextInt();
            }

            // Ordenar o array
            for (int pasada = 0; pasada < numeros.length - 1; pasada++) {
                for (int posicionActual = 0; posicionActual < numeros.length - 1 - pasada; posicionActual++) {
                    if (numeros[posicionActual] > numeros[posicionActual + 1]) {
                        // Intercambiar os numeros
                        int temporal = numeros[posicionActual];
                        numeros[posicionActual] = numeros[posicionActual + 1];
                        numeros[posicionActual + 1] = temporal;
                    }
                }
            }

            // Amosar os numeros ordenados
            for (int numero : numeros) {
                System.out.print(numero + " ");
            }
            System.out.println();

        } catch (Exception e) {
            System.out.println("Produciuse un erro: " + e.getMessage());
        } finally {
            if (scanner != null) {
                scanner.close();
            }
        }
    }
}
