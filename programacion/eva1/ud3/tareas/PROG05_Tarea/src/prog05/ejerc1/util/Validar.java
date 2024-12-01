/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*
* @author
* 
*/

package prog05.ejerc1.util;
import java.time.LocalDate;

public class Validar {

    /**
     * Compara si la fecha de matriculación es anterior a la fecha actual.
    * 
    * @param fecha La fecha de matriculación a comparar.
    * @return `true` si la fecha de matriculación es anterior a la fecha actual, de lo contrario `false`.
    */
    public static boolean comparaFecha(LocalDate fecha) {
        // Compara si la fecha de matriculación es anterior a la fecha actual
        return fecha.isBefore(LocalDate.now());
    }

    /**
     * Valida el formato del DNI mediante la clase `DNI`.
    * 
    * @param dni El DNI a validar.
    * @throws Exception Si el DNI es inválido (formato incorrecto o letra no coincide con el número).
    */
    public static void validaDNI(String dni) throws Exception {
        // Valida el formato del DNI utilizando la clase DNI
        DNI.validarNIF(dni);
    }
}