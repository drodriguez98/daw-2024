package hotel;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Booking {
    
    private static int nextBookingNumber = 1;

    private final int number;
    private final LocalDateTime startDate;
    private final LocalDateTime endDate;
    private final Client guest;
    private final Room room;
    private final boolean checkin;

    public Booking(LocalDate startDate, LocalDate endDate, Client guest, Room room) {
        this.number = nextBookingNumber++;
        this.startDate = startDate.atTime(12, 0);
        this.endDate = endDate.atTime(12, 0);
        this.guest = guest;
        this.room = room;
        this.checkin = false;
    }

    public int getNumber() { return number; }

    public LocalDateTime getStartDate() { return startDate; }

    public LocalDateTime getEndDate() { return endDate; }

    public Client getGuest() { return guest; }

    public Room getRoom() { return room; }

    public boolean isCheckin() { return checkin; }

}