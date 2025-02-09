/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package aforcado;

/**
 *
 * @author diego
 */

import java.util.Scanner;
import java.util.Set;

public class Aforcado {
    private Dictionary dictionary = new Dictionary();

    // Método principal, onde se executa o menú e as opcións
    public static void main(String[] args) {
        Aforcado aforcado = new Aforcado();
        Scanner scanner = new Scanner(System.in);
        
        // Bucle infinito para manter o menú activo ata que o xogador elixa saír
        while (true) {
            System.out.println("Escolle unha opción:");
            System.out.println("1. Engadir Definición");
            System.out.println("2. Xogar");
            System.out.println("3. Sair");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Limpar buffer

            // Procesar a opción seleccionada polo usuario
            switch (choice) {
                case 1:
                    aforcado.addDefinition(scanner);  // Chamar ao método para engadir unha definición
                    break;
                case 2:
                    aforcado.playGame(scanner);  // Chamar ao método para xogar
                    break;
                case 3:
                    System.out.println("Saíndo...");
                    return;  // Terminar o programa
            }
        }
    }

    // Método para engadir unha definición ao diccionario
    public void addDefinition(Scanner scanner) {
        System.out.print("Introduce a palabra: ");
        String palabra = scanner.nextLine();
        System.out.print("Introduce a definición: ");
        String definicion = scanner.nextLine();
        System.out.print("Introduce os sinónimos (separados por coma): ");
        String[] sinonimosArray = scanner.nextLine().split(",");  // Dividir os sinónimos por coma
        Set<String> sinonimos = Set.of(sinonimosArray);  // Crear o conxunto de sinónimos

        Definition definition = new Definition(palabra, definicion, sinonimos);
        if (dictionary.add(definition)) {  // Intentar engadir a definición
            System.out.println("Definición engadida correctamente.");
        } else {
            System.out.println("Xa existe esta palabra.");
        }
    }

    // Método para xogar ao xogo do aforcado
    public void playGame(Scanner scanner) {
        if (dictionary.list().length == 0) {
            System.out.println("Non hai definicións no diccionario.");
            return;
        }

        Definition definition = dictionary.getRandomDefinition();  // Obter unha definición aleatoria
        String palabra = definition.getPalabra();
        String actual = getHyphen(palabra);  // Inicializar con guións
        int intentos = 0;
        String palabraMostrar = getSpaceString(actual);  // Mostrar a palabra con espazos

        // Bucle para xogar ata que se adiviñe a palabra ou se esgoten os intentos
        while (intentos < 8 && !actual.equals(palabra)) {
            System.out.println("Palabra: " + palabraMostrar);
            System.out.print("Introduce unha letra: ");
            char letra = scanner.nextLine().charAt(0);
            String sustitucion = getSustitucion(palabra, letra, actual);  // Obter a substitución
            if (!sustitucion.equals(actual)) {
                actual = sustitucion;  // Actualizar a palabra
                palabraMostrar = getSpaceString(actual);  // Mostrar palabra con espazos
            } else {
                intentos++;  // Incrementar os intentos se a letra é incorrecta
                System.out.println("Intentos: " + getAforcado(intentos));  // Mostrar estado do aforcado
            }
        }

        // Comprobar se o xogador acerta ou perde
        if (actual.equals(palabra)) {
            System.out.println("Acertaches! A palabra era " + palabra + ". Definición: " + definition.getDefinicion());
        } else {
            System.out.println("Non acertaches. A palabra era " + palabra + ". Definición: " + definition.getDefinicion());
        }
    }

    // Convértese unha cadea no formato cun espazo entre caracteres
    public String getSpaceString(String str) {
        return String.join(" ", str.split(""));
    }

    // Crea unha cadea de guións coa mesma lonxitude que a palabra
    public String getHyphen(String str) {
        return "-".repeat(str.length());
    }

    // Substitúe as letras correctas na palabra
    public String getSustitucion(String str, char letra, String sustitucion) {
        char[] chars = sustitucion.toCharArray();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == letra) {
                chars[i] = letra;
            }
        }
        return new String(chars);
    }

    // Devolve o estado do aforcado segundo os intentos
    public String getAforcado(int intentos) {
        String[] estados = {"", "A", "AF", "AFO", "AFOR", "AFORC", "AFORCA", "AFORCAD", "AFORCADO"};
        return estados[intentos];
    }
}