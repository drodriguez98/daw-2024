/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package prog06_tarea;

/**
 *
 * @author diego
 */

// Clase abstracta CuentaBancaria que representa una cuenta bancaria genérica. 
// Contiene atributos para almacenar los datos básicos de una cuenta bancaria como el titular, saldo e IBAN.
public abstract class CuentaBancaria implements Imprimible {
    protected Persona titular;
    protected double saldo;
    protected String iban;

    // Constructor que inicializa los atributos
    public CuentaBancaria(Persona titular, double saldo, String iban) {
        this.titular = titular;
        this.saldo = saldo;
        this.iban = iban;
    }

    // Métodos abstractos que deben ser implementados por las subclases
    public abstract boolean ingreso(double cantidad); // Método para realizar un ingreso
    public abstract boolean retirada(double cantidad); // Método para realizar una retirada
    public abstract double obtenerSaldo(); // Método para obtener el saldo actual

    // Implementación del método devolverInfoString de la interfaz Imprimible
    @Override
    public String devolverInfoString() {
        return "IBAN: " + iban + "\nTitular: " + titular + "\nSaldo: " + saldo;
    }
}