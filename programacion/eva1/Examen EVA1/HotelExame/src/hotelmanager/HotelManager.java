package hotelmanager;

import hotel.Hotel;
import hotel.Room;

// javac -d build -sourcepath src -encoding UTF-8 src\hotelmanager\HotelManager.java
// java -cp build hotelmanager.HotelManager

import java.util.Scanner;

public class HotelManager {
    public static void main(String[] args) {
        Room[] rooms = {
            new Room(1, "Simple Room 1", 1),
            new Room(2, "Simple Room 2", 1),
            new Room(3, "Double Room 1", 2),
            new Room(4, "Double Room 2", 2),
            new Room(5, "Triple Room", 3)
        };

        Hotel hotel = new Hotel("Hotel Manager", rooms);

        Scanner scanner = new Scanner(System.in);
        int option;

        do {
            System.out.println("\n--- Hotel Manager ---");
            System.out.println("1. Consultar e dar de alta novos clientes");
            System.out.println("2. Facer Reservas");
            System.out.println("3. Facer o Check-In dunha Reserva");
            System.out.println("4. Facer o Check-Out dunha Reserva");
            System.out.println("5. Cancelar unha Reserva");
            System.out.println("6. Saír");
            System.out.print("Seleccione unha opción: ");

            option = scanner.nextInt();
            scanner.nextLine(); // Consumir salto de línea.

            switch (option) {
                case 1 -> System.out.println("Opción Consultar e dar de alta novos clientes en Desenvolvemento");
                case 2 -> System.out.println("Opción Facer Reservas en Desenvolvemento");
                case 3 -> System.out.println("Opción Facer o Check-In en Desenvolvemento");
                case 4 -> System.out.println("Opción Facer o Check-Out en Desenvolvemento");
                case 5 -> System.out.println("Opción Cancelar unha Reserva en Desenvolvemento");
                case 6 -> System.out.println("Saíndo...");
                default -> System.out.println("Opción inválida. Inténtao de novo.");
            }
        } while (option != 6);
    }
}
