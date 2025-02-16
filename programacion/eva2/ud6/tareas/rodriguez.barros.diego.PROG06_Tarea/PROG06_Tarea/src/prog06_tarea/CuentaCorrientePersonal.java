/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package prog06_tarea;

/**
 *
 * @author diego
 */

// Clase que representa una cuenta corriente personal, que hereda de CuentaBancaria. Esta clase incluye una comisión de mantenimiento.
public class CuentaCorrientePersonal extends CuentaBancaria {
    
    private double comisionMantenimiento; // Variable que almacena la comisión de mantenimiento de la cuenta.

    // Constructor de la clase CuentaCorrientePersonal. Inicializa los valores de titular, saldo, iban y comisión de mantenimiento.
    public CuentaCorrientePersonal(Persona titular, double saldo, String iban, double comisionMantenimiento) {
        super(titular, saldo, iban);
        this.comisionMantenimiento = comisionMantenimiento;
    }

    // Método para realizar un ingreso en la cuenta.
    @Override
    public boolean ingreso(double cantidad) {
        if (cantidad > 0) {
            saldo += cantidad;
            return true;
        }
        return false;
    }

    // Método para realizar una retirada de la cuenta.
    @Override
    public boolean retirada(double cantidad) {
        if (cantidad > 0 && cantidad <= saldo) {
            saldo -= cantidad;
            return true;
        }
        return false;
    }

    // Método para obtener el saldo actual de la cuenta, restando la comisión de mantenimiento.
    @Override
    public double obtenerSaldo() {
        return saldo - comisionMantenimiento;
    }
}