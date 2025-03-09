/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package aforcado;

/**
 *
 * @author diego
 */

// Filter é un obxecto que valida se un obxecto cumpre co criterio especificado.
public interface Filter<T> {
    // Método que determina se un obxecto é válido segundo o criterio
    boolean isValid(T object);
}
