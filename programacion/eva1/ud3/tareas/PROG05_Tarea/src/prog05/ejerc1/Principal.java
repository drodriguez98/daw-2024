/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*
* @author
* 
*/

package prog05.ejerc1;

import prog05.ejerc1.util.Validar; // Importación de la clase Validar para validar entradas.
import java.time.LocalDate; // Importación de la clase LocalDate para trabajar con fechas.
import java.util.ArrayList; // Importación de la clase ArrayList para gestionar una lista de vehículos.
import java.util.List; // Importación de la clase List para definir la lista de vehículos.
import java.util.Scanner; // Importación de la clase scannernner para leer la entrada del usuario.

public class Principal {

    static Scanner scanner = new Scanner(System.in); // scannernner para capturar la entrada del usuario.
    static List<Vehiculo> listaVehiculos = new ArrayList<>(); // Lista que almacena los vehículos creados.

    /**
     * Método principal que ejecuta el programa.
    * 
    * @param args Parámetros de entrada para el programa (no utilizados en este caso).
    */

    public static void main(String args[]) {
        int option; // Variable para almacenar la opción seleccionada por el usuario.
        do {
            option = mostrarMenuInicial(); // Muestra el menú principal y obtiene la opción seleccionada.
            switch (option) {
                // Caso 1: Crear un nuevo vehículo
                case 1:
                    crearNuevoVehiculo(); // Llama al método para crear un nuevo vehículo.
                    break;
                // Caso 2: Ver los vehículos existentes
                case 2:
                    if (listaVehiculos.isEmpty()) { // Verifica si no hay vehículos registrados.
                        System.out.println("No existen vehículos.");
                    } else {
                        Vehiculo vehiculo = mostrarYSeleccionarVehiculo(); // Permite al usuario seleccionar un vehículo.
                        if (vehiculo != null) {
                            mostrarMenuVehiculo(vehiculo); // Llama al menú específico del vehículo seleccionado.
                        }
                    }
                    break;
                default:
                    System.out.println("Opción no válida."); // Mensaje en caso de que la opción no sea válida.
            }
        } while (option != 3); // El bucle sigue hasta que el usuario selecciona "Salir" (opción 3).
    }   

    /**
     * Muestra el menú inicial de opciones para la gestión de vehículos.
    * 
    * @return Opción seleccionada por el usuario.
    */

    public static int mostrarMenuInicial() {
        System.out.println("GESTIÓN DE VEHÍCULOS");
        System.out.println("1. Nuevo Vehículo");
        System.out.println("2. Ver Vehículos Existentes");
        System.out.println("3. Salir");
    
        int option = scanner.nextInt(); // Lee la opción seleccionada por el usuario.
        scanner.nextLine(); // Consumir el salto de línea.
        return option; // Retorna la opción seleccionada.
    }

    /**
     * Método para crear un nuevo vehículo. Realiza las validaciones necesarias antes de añadirlo a la lista.
    */

    public static void crearNuevoVehiculo() {
        // Declaración de variables necesarias para crear un vehículo.
        String marca, matricula, descripcion, propietario, dniPropietario;
        int numKilometros, precio;
        int dia, mes, anio;
        LocalDate fecha;

        // Solicitud de información al usuario sobre el vehículo.
        System.out.println("Introduce la marca del vehículo");
        marca = scanner.nextLine();
        System.out.println("Introduce la matrícula del vehículo");
        matricula = scanner.nextLine();
        System.out.println("Introduce la descripción del vehículo");
        descripcion = scanner.nextLine();
        System.out.println("Introduce el número de kilómetros del vehículo");
        numKilometros = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de línea.
        System.out.println("Introduce el precio del vehículo");
        precio = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de línea.
        System.out.println("Introduce el propietario del vehículo");
        propietario = scanner.nextLine();
        System.out.println("Introduce el DNI del propietario del vehículo");
        dniPropietario = scanner.nextLine();
        System.out.println("Introduce el día de matriculación");
        dia = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de línea.
        System.out.println("Introduce el mes de matriculación");
        mes = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de línea.
        System.out.println("Introduce el año de matriculación");
        anio = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de línea.

        fecha = LocalDate.of(anio, mes, dia); // Crear la fecha de matriculación.

        // Validación de la fecha de matriculación.
        if (!Validar.comparaFecha(fecha)) {
            System.out.println("Los datos de la fecha de matriculación son incorrectos o la fecha no es anterior a la actual");
            return;
        }

        // Validación del número de kilómetros.
        if (numKilometros <= 0) {
            System.out.println("El número de kilómetros es incorrecto");
            return;
        }

        // Validación del formato del DNI.
        try {
            Validar.validaDNI(dniPropietario);
        } catch (Exception e) {
            System.out.println("El formato del DNI no es correcto");
            return;
        }

        // Si las validaciones son correctas, instanciamos el vehículo y lo añadimos a la lista.
        Vehiculo nuevoVehiculo = new Vehiculo(marca, matricula, numKilometros, fecha, descripcion, precio, propietario, dniPropietario);
        listaVehiculos.add(nuevoVehiculo); // Añadir el vehículo a la lista.
        System.out.println("El vehículo ha sido creado");
    }

    /**
     * Muestra la lista de vehículos registrados y permite al usuario seleccionar uno.
     * 
     * @return Vehículo seleccionado por el usuario, o null si la opción es inválida.
     */

    public static Vehiculo mostrarYSeleccionarVehiculo() {
        if (listaVehiculos.isEmpty()) {  // Verifica si la lista está vacía.
            System.out.println("No hay vehículos registrados.");
            return null;
        }

        // Muestra la lista de vehículos registrados.
        System.out.println("Listado de vehículos:");
        for (int i = 0; i < listaVehiculos.size(); i++) {
            System.out.println((i + 1) + ". " + listaVehiculos.get(i).getMarca() + " - Matrícula: " + listaVehiculos.get(i).getMatricula());
        }

        // Solicita al usuario seleccionar un vehículo.
        System.out.println("Seleccione el número del vehículo:");
        int opcion = scanner.nextInt();
        scanner.nextLine();  // Consumir el salto de línea.

        // Verifica si la opción seleccionada es válida.
        if (opcion < 1 || opcion > listaVehiculos.size()) {
            System.out.println("Opción no válida.");
            return null;  // Si la opción es inválida, retorna null.
        }

        // Retorna el vehículo seleccionado.
        return listaVehiculos.get(opcion - 1);
    }

    /**
     * Muestra el menú de opciones para un vehículo específico y realiza las acciones según la opción seleccionada.
    * 
    * @param vehiculo El vehículo sobre el cual se realizarán las acciones.
    */
    
    public static void mostrarMenuVehiculo(Vehiculo vehiculo) {
        int option; // Variable para almacenar la opción seleccionada.
        do {
            // Muestra las opciones disponibles para un vehículo específico.
            System.out.println("Opciones del Vehículo:");
            System.out.println("1. Ver Matrícula");
            System.out.println("2. Ver Kilómetros");
            System.out.println("3. Actualizar Kilómetros");
            System.out.println("4. Ver años de antigüedad");
            System.out.println("5. Mostrar Propietario");
            System.out.println("6. Mostrar Descripción");
            System.out.println("7. Mostrar Precio");
            System.out.println("8. Volver");

            option = scanner.nextInt(); // Lee la opción seleccionada por el usuario.
            scanner.nextLine(); // Consumir el salto de línea.
            
            // Realiza las acciones correspondientes según la opción seleccionada.
            switch (option) {
                case 1:
                    System.out.println("La matrícula del vehículo es: " + vehiculo.getMatricula());
                    break;
                case 2:
                    System.out.println("El número de kilómetros del vehículo es: " + vehiculo.getNumKilometros());
                    break;
                case 3:
                    System.out.println("Introduce el nuevo número de kilómetros");
                    int nuevosKilometros = scanner.nextInt(); // Lee el nuevo número de kilómetros.
                    scanner.nextLine(); // Consumir el salto de línea.
                    if (nuevosKilometros > 0) {
                        vehiculo.actualizarKilometros(nuevosKilometros); // Actualiza los kilómetros del vehículo.
                        System.out.println("Kilómetros actualizados.");
                    }
                    break;
                case 4:
                    System.out.println("El vehículo tiene " + vehiculo.calcularAnios() + " años de antigüedad.");
                    break;
                case 5:
                    System.out.println("El propietario del vehículo es: " + vehiculo.getPropietario() + ", con DNI " + vehiculo.getDniPropietario());
                    break;
                case 6:
                    System.out.println("La descripción del vehículo es: " + vehiculo.getDescripcion());
                    break;
                case 7:
                    System.out.println("El precio del vehículo es: " + vehiculo.getPrecio() + "€");
                    break;
                case 8:
                    System.out.println("Volviendo al menú principal...");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (option != 8); // El bucle sigue hasta que el usuario selecciona "Volver".
    }     
}