/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package prog06_tarea;

/**
 *
 * @author diego
 */

public class Persona {
    // Atributos
    private String nombre;
    private String apellidos;
    private String dni;

    // Constructor que inicializa los atributos de la persona
    public Persona(String nombre, String apellidos, String dni) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.dni = dni;
    }

    // Getter para obtener el nombre
    public String getNombre() {
        return nombre;
    }

    // Getter para obtener los apellidos
    public String getApellidos() {
        return apellidos;
    }

    // Getter para obtener el DNI
    public String getDni() {
        return dni;
    }

    // Método toString para representar el objeto como una cadena de texto
    @Override
    public String toString() {
        return nombre + " " + apellidos + " (" + dni + ")";
    }
}