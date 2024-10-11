/*

    a) Escribir un programa que solicite unha cadea de texto e retorne a mesma cadea pero transformando a primeira letra en maiúscula.

    b) Escribir un programa que solicite tres cadeas de texto e retorne unha nova cadea na que na primeira cadea se substitúe o segundo texto polo terceiro:

    Cadea 1: Isto é unha proba tonta

    Cadea 2: to

    Cadea 3: TO

    Resultado: IsTO é unha proba TOnta

*/

import java.util.Scanner;

public class exercicio10_b {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Crear un objeto Scanner para ler a entrada do usuario

        // Solicitar a primeira cadea
        System.out.print("Introduce a primeira cadea: "); 
        String cadea1 = scanner.nextLine(); // Ler a primeira cadea

        // Solicitar a segunda cadea (texto a sustituir)
        System.out.print("Introduce a segunda cadea (texto a sustituir): "); 
        String cadea2 = scanner.nextLine(); // Ler a segunda cadea

        // Solicitar a terceira cadea (texto substitutivo)
        System.out.print("Introduce a terceira cadea (texto substitutivo): "); 
        String cadea3 = scanner.nextLine(); // Ler a terceira cadea

        // Chamar ao método para substituír a segunda cadea pola terceira na primeira
        String resultado = substitueTexto(cadea1, cadea2, cadea3); 
        System.out.println("Resultado: " + resultado); // Mostrar o resultado

        scanner.close(); // Cerrar o obxecto Scanner para liberar recursos
    }

    // Método para substituír un texto por outro dentro dunha cadea
    public static String substitueTexto(String cadea1, String cadea2, String cadea3) {
        return cadea1.replace(cadea2, cadea3); // Retornar a cadea resultante da substitución
    }
}