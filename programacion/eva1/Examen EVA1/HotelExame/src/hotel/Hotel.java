package hotel;

import utils.DinamicArray;

public class Hotel {
    
    private final String name;
    private final Room[] rooms;
    private final DinamicArray clients;

    public Hotel(String name, Room[] rooms) {
        this.name = name;
        this.rooms = rooms;
        this.clients = new DinamicArray(10);
    }

    public String getName() { return name; }

    public Room[] getRooms() { return rooms; }

    public DinamicArray getClients() { return clients; }

}