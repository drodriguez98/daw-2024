package database;

import java.util.Arrays;

// Clase principal para probar el funcionamiento de la base de datos y las operaciones con clientes.
public class Main {
    public static void main(String[] args) {
        // Se crea una base de datos dinámica para almacenar objetos de tipo Cliente, donde la clave es String (DNI).
        Database<Cliente, String> db = new DynamicDatabase<>(Cliente.class);

        try {
            // Añadimos dos clientes a la base de datos.
            db.add(new Cliente("12345678A", "Juan"));
            db.add(new Cliente("98765432B", "María"));

            // Obtenemos todos los clientes almacenados.
            Cliente[] clientes = db.getAll();
            System.out.println("Clientes almacenados: " + Arrays.toString(clientes));

            // Buscamos un cliente por su DNI.
            System.out.println("Cliente con DNI 12345678A: " + db.get("12345678A"));

            // Filtramos clientes con el nombre "María".
            Cliente[] resultados = db.find(cliente -> cliente.getNome().equals("María"));
            System.out.println("Clientes filtrados: " + Arrays.toString(resultados));

            // Actualizamos el nombre de un cliente.
            Cliente cliente = db.get("12345678A");
            if (cliente != null) {
                cliente.setNome("Juan Actualizado");
                db.update(cliente);
            }

            // Mostramos todos los clientes después de la actualización.
            System.out.println("Clientes tras actualización: " + Arrays.toString(db.getAll()));

            // Eliminamos un cliente de la base de datos.
            db.del("98765432B");
            System.out.println("Clientes tras eliminación: " + Arrays.toString(db.getAll()));

        } catch (StorageException e) {
            // Si ocurre algún error durante las operaciones, lo mostramos.
            System.err.println("Erro: " + e.getMessage());
        }
    }
}
