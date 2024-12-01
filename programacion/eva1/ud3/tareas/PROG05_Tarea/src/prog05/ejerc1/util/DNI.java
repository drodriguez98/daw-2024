/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*
* @author
* 
*/

package prog05.ejerc1.util;

public class DNI {

    // Definición de constante con las letras asociadas a los NIFs.
    private static final String LETRAS_DNI = "TRWAGMYFPDXBNJZSQVHLCKE"; // Letras posibles para un NIF.

    /**
     * Calcula la letra del NIF a partir del número del DNI.
    * 
    * @param dni El número del DNI (sin la letra).
    * @return La letra correspondiente al número de DNI.
    */
    private static char calcularLetraNIF(int dni) {
        char letra;

        // Cálculo de la letra NIF usando la fórmula (dni % 23) para obtener el índice de la letra.
        letra = LETRAS_DNI.charAt(dni % 23);

        // Devolución de la letra calculada.
        return letra;
    }

    /**
     * Extrae la letra del NIF a partir de la cadena que lo representa.
    * 
    * @param nif La cadena que representa el NIF (que incluye tanto el número como la letra).
    * @return La letra del NIF.
    */
    private static char extraerLetraNIF(String nif) {
        // La letra se encuentra en la última posición de la cadena.
        char letra = nif.charAt(nif.length() - 1);

        return letra;
    }

    /**
     * Extrae el número del NIF (sin la letra) a partir de la cadena que lo representa.
    * 
    * @param nif La cadena que representa el NIF.
    * @return El número del NIF como un valor entero.
    */
    private static int extraerNumeroNIF(String nif) {
        // Extraemos el número del NIF como un entero, quitando la letra al final de la cadena.
        int numero = Integer.parseInt(nif.substring(0, nif.length() - 1));

        return numero;
    }

    /**
     * Valida un NIF comprobando que el número y la letra sean correctos.
    * 
    * @param nif El NIF a validar (como cadena de texto).
    * @return Un valor booleano que indica si el NIF es válido o no.
    * @throws Exception Si el NIF es inválido (letra incorrecta).
    */
    public static boolean validarNIF(String nif) throws Exception {

        boolean valido = true;  // Suponemos que el NIF es válido mientras no encontremos un error.

        char letraCalculada;  // Letra calculada a partir del número del DNI.
        char letraLeida;      // Letra extraída del NIF proporcionado.
        int dniLeido;         // Número del NIF extraído de la cadena.

        // Comprobamos que el NIF no sea nulo.
        if (nif == null) {
            valido = false;
        } else if (nif.length() < 8 || nif.length() > 9) { // El NIF debe tener entre 8 y 9 caracteres (7 dígitos + 1 letra, o 8 dígitos + 1 letra).
            valido = false;
        } else {

            // Extraemos la letra y el número del NIF.
            letraLeida = DNI.extraerLetraNIF(nif);
            dniLeido = DNI.extraerNumeroNIF(nif);

            // Calculamos la letra correspondiente al número del NIF.
            letraCalculada = DNI.calcularLetraNIF(dniLeido);

            // Comparamos la letra leída con la letra calculada. Si no coinciden, lanzamos una excepción.
            if (letraLeida != letraCalculada) {
                throw new Exception("DNI inválido: ");
            }
        }

        // Devolvemos si el NIF es válido o no.
        return valido;
    }
}