/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package prog06_tarea;

/**
 *
 * @author diego
 */

import java.util.ArrayList;

// Clase que representa un banco que gestiona múltiples cuentas bancarias.
public class Banco {
    private ArrayList<CuentaBancaria> cuentas = new ArrayList<>();
    
    // Método para abrir una nueva cuenta en el banco. Si el banco tiene menos de 100 cuentas, la agrega.
    public boolean abrirCuenta(CuentaBancaria cuenta) {
        if (cuentas.size() < 100) {
            cuentas.add(cuenta);
            return true;
        }
        return false;
    }

    // Método que devuelve un listado de las cuentas bancarias en el banco como un array de strings.
    public String[] listadoCuentas() {
        String[] listado = new String[cuentas.size()];
        for (int i = 0; i < cuentas.size(); i++) {
            listado[i] = cuentas.get(i).devolverInfoString();
        }
        return listado;
    }

    // Método que devuelve la información de una cuenta bancaria a partir de su IBAN.
    public String informacionCuenta(String iban) {
        for (CuentaBancaria cuenta : cuentas) {
            if (cuenta.iban.equals(iban)) {
                return cuenta.devolverInfoString();
            }
        }
        return null;
    }

    // Método para realizar un ingreso en una cuenta bancaria identificada por su IBAN.
    public boolean ingresoCuenta(String iban, double cantidad) {
        for (CuentaBancaria cuenta : cuentas) {
            if (cuenta.iban.equals(iban)) {
                return cuenta.ingreso(cantidad);
            }
        }
        return false;
    }

    // Método para realizar una retirada de dinero de una cuenta bancaria identificada por su IBAN.
    public boolean retiradaCuenta(String iban, double cantidad) {
        for (CuentaBancaria cuenta : cuentas) {
            if (cuenta.iban.equals(iban)) {
                return cuenta.retirada(cantidad);
            }
        }
        return false;
    }

    // Método que obtiene el saldo de una cuenta bancaria a partir de su IBAN.
    public double obtenerSaldo(String iban) {
        for (CuentaBancaria cuenta : cuentas) {
            if (cuenta.iban.equals(iban)) {
                return cuenta.obtenerSaldo();
            }
        }
        return -1;
    }
}