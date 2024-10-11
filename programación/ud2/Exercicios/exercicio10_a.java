/*

    a) Escribir un programa que solicite unha cadea de texto e retorne a mesma cadea pero transformando a primeira letra en maiúscula.

    b) Escribir un programa que solicite tres cadeas de texto e retorne unha nova cadea na que na primeira cadea se substitúe o segundo texto polo terceiro:

    Cadea 1: Isto é unha proba tonta

    Cadea 2: to

    Cadea 3: TO

    Resultado: IsTO é unha proba TOnta

*/

import java.util.Scanner;

public class exercicio10_a {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Crear un objeto Scanner para ler a entrada do usuario

        // Solicitar unha cadea de texto
        System.out.print("Introduce unha cadea de texto: "); 
        String cadea = scanner.nextLine(); // Ler a cadea

        // Chamar ao método para transformar a primeira letra
        String cadeaMaiuscula = primeiraMaiuscula(cadea); 
        System.out.println("Cadea transformada: " + cadeaMaiuscula); // Mostrar a cadea transformada

        scanner.close(); // Cerrar o obxecto Scanner para liberar recursos
    }

    // Método para transformar a primeira letra en maiúscula
    public static String primeiraMaiuscula(String cadea) {
        if (cadea == null || cadea.isEmpty()) { // Comprobar se a cadea é nula ou está baleira
            return cadea; // Retornar a cadea sen cambios
        }
        return cadea.substring(0, 1).toUpperCase() + cadea.substring(1); // Retornar a cadea con a primeira letra en maiúscula
    }
}