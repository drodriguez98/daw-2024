/*
* Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
* Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
*/

package iterable;  // Paquete onde se atopa a clase IterableString

/**
 * Clase que implementa a interface Iterable para iterar sobre un String carácter a carácter.
* @author diego
*/

import java.util.Iterator;  // Importa a interface Iterator

public class IterableString implements Iterable<Character> {
    private String str;  // Almacena o String sobre o que se vai iterar

    // Constructor que inicializa o atributo 'str'
    public IterableString(String str) {
        this.str = str;
    }

    // Implementa o método iterator() para retornar un Iterator que percorre o String
    @Override
    public Iterator<Character> iterator() {
        return new Iterator<Character>() {
            private int index = 0;  // Controla a posición no String

            // Verifica se hai máis caracteres
            @Override
            public boolean hasNext() {
                return index < str.length();
            }

            // Retorna o seguinte carácter
            @Override
            public Character next() {
                if (hasNext()) {
                    return str.charAt(index++);  // Retorna o carácter actual
                }
                throw new IllegalStateException("No more characters.");
            }
        };
    }

    // Método main para probar a clase IterableString
    public static void main(String[] args) {
        IterableString str = new IterableString("Moitas Letras");  // Instancia de IterableString

        // Usamos o ciclo for-each para iterar sobre o String
        for (Character c : str) {
            System.out.println(c);  // Imprime cada carácter
        }
    }
}