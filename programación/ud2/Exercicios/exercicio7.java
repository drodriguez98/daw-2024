import java.util.Scanner;

public class exercicio7 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Crear un obxecto Scanner para ler a entrada do usuario
        int[] numeros = new int[7]; // Array para almacenar 7 numeros

        // Ler 7 numeros do usuario
        for (int i = 0; i < 7; i++) {
            while (true) {
                System.out.print("Introduce o numero " + (i + 1) + ": "); // Solicitar o numero ao usuario
                if (scanner.hasNextInt()) { // Verificar se a entrada é un numero enteiro
                    numeros[i] = scanner.nextInt(); // Almacenar o numero no array
                    break; // Salir do bucle se a entrada é valida
                } else {
                    System.out.println("Error: Introduce un valor numerico valido."); // Mensaxe de erro se a entrada non é un numero
                    scanner.next(); // Limpar o valor de entrada invalido
                }
            }
        }

        // Ordenar os numeros sen as clases Arrays ou Collections
        for (int i = 0; i < numeros.length - 1; i++) {
            for (int j = 0; j < numeros.length - 1 - i; j++) {
                // Comparar e cambiar os elementos se están na orde incorrecta
                if (numeros[j] > numeros[j + 1]) {
                    // Intercambiar os numeros
                    int temp = numeros[j];
                    numeros[j] = numeros[j + 1];
                    numeros[j + 1] = temp;
                }
            }
        }

        // Mostrar os numeros ordenados
        System.out.println("Numeros en orde:");
        for (int i = 0; i < numeros.length; i++) {
            System.out.println(numeros[i]); // Imprimir cada numero
        }

        scanner.close(); // Cerrar o obxecto Scanner para liberar recursos
    }
}