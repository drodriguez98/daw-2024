/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*
* @author
* 
*/

package prog05.ejerc1;

import java.time.LocalDate; // Importación de la clase LocalDate para trabajar con fechas.
import java.time.Period; // Importación de la clase Period para calcular la diferencia entre fechas.

public class Vehiculo {

    // Atributos de la clase Vehiculo.
    private String marca; // Marca del vehículo.
    private String matricula; // Matrícula del vehículo.
    private int numKilometros; // Número de kilómetros recorridos por el vehículo.
    private LocalDate fecha; // Fecha de matriculación del vehículo.
    private String descripcion; // Descripción del vehículo.
    private int precio; // Precio del vehículo.
    private String propietario; // Nombre del propietario del vehículo.
    private String dniPropietario; // DNI del propietario del vehículo.

    /**
     * Constructor de la clase Vehiculo.
    * Este constructor inicializa todos los atributos del vehículo.
    * 
    * @param marca Marca del vehículo.
    * @param matricula Matrícula del vehículo.
    * @param numKilometros Kilómetros recorridos por el vehículo.
    * @param fecha Fecha de matriculación del vehículo.
    * @param descripcion Descripción del vehículo.
    * @param precio Precio del vehículo.
    * @param propietario Nombre del propietario del vehículo.
    * @param dniPropietario DNI del propietario del vehículo.
    */
    public Vehiculo(String marca, String matricula, int numKilometros, LocalDate fecha, String descripcion, int precio, String propietario, String dniPropietario) {
        this.marca = marca;
        this.matricula = matricula;
        this.numKilometros = numKilometros;
        this.fecha = fecha;
        this.descripcion = descripcion;
        this.precio = precio;
        this.propietario = propietario;
        this.dniPropietario = dniPropietario;
    }

    // Métodos getter y setter para cada uno de los atributos.
    
    public String getMarca() { return marca; } // Obtiene la marca del vehículo.
    public void setMarca(String marca) { this.marca = marca; } // Establece la marca del vehículo.

    public String getMatricula() { return matricula; } // Obtiene la matrícula del vehículo.
    public void setMatricula(String matricula) { this.matricula = matricula; } // Establece la matrícula del vehículo.

    public int getNumKilometros() { return numKilometros; } // Obtiene el número de kilómetros recorridos.
    public void setNumKilometros(int numKilometros) { this.numKilometros = numKilometros; } // Establece el número de kilómetros recorridos.

    public LocalDate getFecha() { return fecha; } // Obtiene la fecha de matriculación.
    public void setFecha(LocalDate fecha) { this.fecha = fecha; } // Establece la fecha de matriculación.

    public String getDescripcion() { return descripcion; } // Obtiene la descripción del vehículo.
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; } // Establece la descripción del vehículo.

    public float getPrecio() { return precio; } // Obtiene el precio del vehículo.
    public void setPrecio(int precio) { this.precio = precio; } // Establece el precio del vehículo.

    public String getPropietario() { return propietario; } // Obtiene el propietario del vehículo.
    public void setPropietario(String propietario) { this.propietario = propietario; } // Establece el propietario del vehículo.

    public String getDniPropietario() { return dniPropietario; } // Obtiene el DNI del propietario.
    public void setDniPropietario(String dniPropietario) { this.dniPropietario = dniPropietario; } // Establece el DNI del propietario.

    /**
     * Calcula la antigüedad del vehículo en años, en función de la fecha de matriculación.
    * 
    * @return El número de años de antigüedad del vehículo.
    */
    public int calcularAnios() {
        LocalDate hoy = LocalDate.now(); // Obtiene la fecha actual.
        return  (Period.between(this.fecha, hoy).getYears()); // Calcula y retorna la diferencia en años entre la fecha de matriculación y la fecha actual.
    }

    /**
     * Actualiza el número de kilómetros del vehículo.
    * 
    * @param nuevosKilometros El nuevo valor de kilómetros recorridos.
    */
    public void actualizarKilometros(int nuevosKilometros) {
        this.numKilometros = nuevosKilometros; // Establece el nuevo número de kilómetros.
    }
}