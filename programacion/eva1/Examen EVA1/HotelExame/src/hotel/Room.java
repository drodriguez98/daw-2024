package hotel;

import utils.DinamicArray;

public class Room {

    private final int number;
    private final String name;
    private final int capacity;
    private final DinamicArray bookings;

    public Room(int number, String name, int capacity) {
        this.number = number;
        this.name = name;
        this.capacity = capacity;
        this.bookings = new DinamicArray(10);
    }

    public int getNumber() { return number; }

    public String getName() { return name; }

    public int getCapacity() { return capacity; }

    public DinamicArray getBookings() { return bookings; }

}