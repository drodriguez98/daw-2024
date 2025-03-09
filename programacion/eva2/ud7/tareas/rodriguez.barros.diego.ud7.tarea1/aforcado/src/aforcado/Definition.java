/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aforcado;

/**
 *
 * @author diego
 */

import java.util.Set;

// Definition almacena unha palabra, a súa definición e un conxunto de sinónimos.
public class Definition {
    private String palabra;
    private String definicion;
    private Set<String> sinonimos;

    // Constructor para inicializar a definición
    public Definition(String palabra, String definicion, Set<String> sinonimos) {
        this.palabra = palabra;
        this.definicion = definicion;
        this.sinonimos = sinonimos;
    }

    // Métodos getters para acceder aos atributos
    public String getPalabra() {
        return palabra;
    }

    public String getDefinicion() {
        return definicion;
    }

    public Set<String> getSinonimos() {
        return sinonimos;
    }

    // Método toString para mostrar a información da definición
    @Override
    public String toString() {
        return "Palabra: " + palabra + ", Definición: " + definicion + ", Sinónimos: " + sinonimos;
    }
}
