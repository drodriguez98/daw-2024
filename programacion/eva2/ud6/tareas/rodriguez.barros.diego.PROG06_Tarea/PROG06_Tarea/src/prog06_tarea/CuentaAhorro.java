/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package prog06_tarea;

/**
 *
 * @author diego
 */

// Clase CuentaAhorro que hereda de CuentaBancaria y representa una cuenta de ahorro con un tipo de interés anual.
public class CuentaAhorro extends CuentaBancaria {
    private double tipoInteresAnual; // Tipo de interés anual aplicado a la cuenta

    // Constructor que inicializa los atributos heredados y el tipo de interés
    public CuentaAhorro(Persona titular, double saldo, String iban, double tipoInteresAnual) {
        super(titular, saldo, iban);
        this.tipoInteresAnual = tipoInteresAnual;
    }

    // Método para realizar un ingreso en la cuenta
    @Override
    public boolean ingreso(double cantidad) {
        if (cantidad > 0) { // Verifica que la cantidad sea positiva
            saldo += cantidad; // Suma el importe al saldo
            return true;
        }
        return false; // Retorna false si la cantidad no es válida
    }

    // Método para retirar dinero de la cuenta
    @Override
    public boolean retirada(double cantidad) {
        if (cantidad > 0 && cantidad <= saldo) { // Verifica que la cantidad sea válida y no supere el saldo
            saldo -= cantidad; // Resta el importe al saldo
            return true;
        }
        return false; // Retorna false si no se cumplen las condiciones
    }

    // Método para obtener el saldo actual de la cuenta
    @Override
    public double obtenerSaldo() {
        return saldo; // Retorna el saldo actual
    }
}