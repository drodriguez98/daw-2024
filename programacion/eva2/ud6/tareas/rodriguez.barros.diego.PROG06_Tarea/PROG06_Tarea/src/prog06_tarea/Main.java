/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

package prog06_tarea;

/**
 *
 * @author diego
 */

import java.util.Scanner;

// Clase principal donde se maneja la interacción con el usuario
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); // Escáner para leer la entrada del usuario
        Banco banco = new Banco(); // Crear un nuevo objeto banco

        // Bucle infinito para mostrar el menú hasta que el usuario decida salir
        while (true) {
            System.out.println("\nMenú:"); // Menú de opciones para gestionar las cuentas
            System.out.println("1. Abrir nueva cuenta");
            System.out.println("2. Listado de cuentas");
            System.out.println("3. Ver información de cuenta");
            System.out.println("4. Ingreso en cuenta");
            System.out.println("5. Retirar dinero de cuenta");
            System.out.println("6. Ver saldo de cuenta");
            System.out.println("7. Salir");
            System.out.print("Elige una opción: ");
            int opcion = sc.nextInt(); // Leer la opción elegida
            sc.nextLine(); // Limpiar el buffer

            // Dependiendo de la opción elegida, se ejecutará una acción diferente
            switch (opcion) {
                case 1: // Opción para abrir una nueva cuenta
                    System.out.print("Nombre del titular: ");
                    String nombre = sc.nextLine();
                    System.out.print("Apellidos del titular: ");
                    String apellidos = sc.nextLine();
                    System.out.print("DNI del titular: ");
                    String dni = sc.nextLine();
                    Persona titular = new Persona(nombre, apellidos, dni); // Crear una nueva persona con los datos ingresados
                    
                    // Selección del tipo de cuenta
                    System.out.println("Selecciona el tipo de cuenta:");
                    System.out.println("1. Cuenta de Ahorro");
                    System.out.println("2. Cuenta Corriente Personal");
                    System.out.println("3. Cuenta Corriente Empresa");
                    int tipoCuenta = sc.nextInt();
                    sc.nextLine(); // Limpiar el buffer

                    // Dependiendo del tipo de cuenta, pedir los datos específicos y crear la cuenta correspondiente
                    if (tipoCuenta == 1) {
                        // Cuenta de ahorro
                        System.out.print("IBAN de la cuenta de ahorro: ");
                        String ibanAhorro = sc.nextLine();
                        System.out.print("Saldo inicial: ");
                        double saldoAhorro = sc.nextDouble();
                        System.out.print("Tipo de interés anual: ");
                        double interesAhorro = sc.nextDouble();
                        CuentaAhorro cuentaAhorro = new CuentaAhorro(titular, saldoAhorro, ibanAhorro, interesAhorro);
                        banco.abrirCuenta(cuentaAhorro); // Abrir la cuenta en el banco
                    } else if (tipoCuenta == 2) {
                        // Cuenta corriente personal
                        System.out.print("IBAN de la cuenta corriente personal: ");
                        String ibanCorrientePersonal = sc.nextLine();
                        System.out.print("Saldo inicial: ");
                        double saldoCorrientePersonal = sc.nextDouble();
                        System.out.print("Comisión de mantenimiento: ");
                        double comisionCorrientePersonal = sc.nextDouble();
                        CuentaCorrientePersonal cuentaCorrientePersonal = new CuentaCorrientePersonal(
                            titular, saldoCorrientePersonal, ibanCorrientePersonal, comisionCorrientePersonal);
                        banco.abrirCuenta(cuentaCorrientePersonal); // Abrir la cuenta
                    } else if (tipoCuenta == 3) {
                        // Cuenta corriente empresa
                        System.out.print("IBAN de la cuenta corriente empresa: ");
                        String ibanCorrienteEmpresa = sc.nextLine();
                        System.out.print("Saldo inicial: ");
                        double saldoCorrienteEmpresa = sc.nextDouble();
                        System.out.print("Tipo de interés de descubierto: ");
                        double interesDescubierto = sc.nextDouble();
                        System.out.print("Máximo descubierto permitido: ");
                        double maxDescubierto = sc.nextDouble();
                        System.out.print("Comisión de descubierto: ");
                        double comisionDescubierto = sc.nextDouble();
                        CuentaCorrienteEmpresa cuentaCorrienteEmpresa = new CuentaCorrienteEmpresa(
                            titular, saldoCorrienteEmpresa, ibanCorrienteEmpresa, interesDescubierto,
                            maxDescubierto, comisionDescubierto);
                        banco.abrirCuenta(cuentaCorrienteEmpresa); // Abrir la cuenta
                    }
                    break;

                case 2: // Listado de cuentas
                    String[] cuentas = banco.listadoCuentas(); // Obtener el listado de cuentas del banco
                    if (cuentas.length == 0) {
                        System.out.println("No hay cuentas abiertas.");
                    } else {
                        System.out.println("Listado de cuentas:");
                        for (String cuenta : cuentas) {
                            System.out.println(cuenta); // Mostrar las cuentas
                        }
                    }
                    break;

                case 3: // Ver información de una cuenta
                    System.out.print("Introduce el IBAN de la cuenta: ");
                    String iban = sc.nextLine();
                    String infoCuenta = banco.informacionCuenta(iban); // Buscar la cuenta por su IBAN
                    if (infoCuenta == null) {
                        System.out.println("Cuenta no encontrada.");
                    } else {
                        System.out.println("Información de la cuenta:");
                        System.out.println(infoCuenta); // Mostrar la información de la cuenta
                    }
                    break;

                case 4: // Ingreso en cuenta
                    System.out.print("Introduce el IBAN de la cuenta: ");
                    String ibanIngreso = sc.nextLine();
                    System.out.print("Introduce la cantidad a ingresar: ");
                    double cantidadIngreso = sc.nextDouble();
                    boolean ingresoExitoso = banco.ingresoCuenta(ibanIngreso, cantidadIngreso); // Realizar el ingreso
                    if (ingresoExitoso) {
                        System.out.println("Ingreso realizado con éxito.");
                    } else {
                        System.out.println("Ingreso fallido.");
                    }
                    break;

                case 5: // Retirar dinero de cuenta
                    System.out.print("Introduce el IBAN de la cuenta: ");
                    String ibanRetiro = sc.nextLine();
                    System.out.print("Introduce la cantidad a retirar: ");
                    double cantidadRetiro = sc.nextDouble();
                    boolean retiroExitoso = banco.retiradaCuenta(ibanRetiro, cantidadRetiro); // Realizar el retiro
                    if (retiroExitoso) {
                        System.out.println("Retiro realizado con éxito.");
                    } else {
                        System.out.println("Retiro fallido.");
                    }
                    break;

                case 6: // Ver saldo de cuenta
                    System.out.print("Introduce el IBAN de la cuenta: ");
                    String ibanSaldo = sc.nextLine();
                    double saldoCuenta = banco.obtenerSaldo(ibanSaldo); // Obtener el saldo de la cuenta
                    if (saldoCuenta == -1) {
                        System.out.println("Cuenta no encontrada.");
                    } else {
                        System.out.println("Saldo actual de la cuenta: " + saldoCuenta);
                    }
                    break;

                case 7: // Salir del programa
                    System.out.println("Saliendo del programa...");
                    sc.close(); // Cerrar el escáner
                    return; // Terminar el programa

                default:
                    System.out.println("Opción no válida.");
                    break;
            }
        }
    }
}