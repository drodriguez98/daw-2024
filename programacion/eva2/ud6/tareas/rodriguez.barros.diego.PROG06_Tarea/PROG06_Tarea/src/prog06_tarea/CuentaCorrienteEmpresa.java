/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package prog06_tarea;

/**
 *
 * @author diego
 */

// Clase que representa una cuenta corriente para empresas, que hereda de CuentaBancaria. Esta clase maneja un descubierto permitido con sus respectivas condiciones y comisiones.
public class CuentaCorrienteEmpresa extends CuentaBancaria {
    private double tipoInteresDescubierto;
    private double maxDescubiertoPermitido;
    private double comisionDescubierto;
    
    // Constructor de la clase CuentaCorrienteEmpresa. Inicializa las propiedades de la cuenta incluyendo los detalles sobre el descubierto y las comisiones.
    public CuentaCorrienteEmpresa(Persona titular, double saldo, String iban, double tipoInteresDescubierto, double maxDescubiertoPermitido, double comisionDescubierto) {
        super(titular, saldo, iban);
        this.tipoInteresDescubierto = tipoInteresDescubierto;
        this.maxDescubiertoPermitido = maxDescubiertoPermitido;
        this.comisionDescubierto = comisionDescubierto;
    }

    // Método para realizar un ingreso en la cuenta. Aumenta el saldo si la cantidad es positiva.
    @Override
    public boolean ingreso(double cantidad) {
        if (cantidad > 0) {
            saldo += cantidad;
            return true;
        }
        return false;
    }

    // Método para realizar una retirada de la cuenta. Permite el descubierto hasta el límite establecido.
    @Override
    public boolean retirada(double cantidad) {
        if (cantidad > 0 && saldo - cantidad >= -maxDescubiertoPermitido) {
            saldo -= cantidad;
            return true;
        }
        return false;
    }

    // Método que devuelve el saldo actual de la cuenta.
    @Override
    public double obtenerSaldo() {
        return saldo;
    }
}