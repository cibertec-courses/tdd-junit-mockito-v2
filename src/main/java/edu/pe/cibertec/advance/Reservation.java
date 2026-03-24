package edu.pe.cibertec.advance;

public class Reservation {

    private Long id;
    private String guestName;
    private String roomNumber;
    private String checkInDate;

    public Reservation(Long id, String guestName, String roomNumber, String checkInDate) {
        this.id = id;
        this.guestName = guestName;
        this.roomNumber = roomNumber;
        this.checkInDate = checkInDate;
    }

    public Long getId() {
        return id;
    }

    public String getGuestName() {
        return guestName;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public String getCheckInDate() {
        return checkInDate;
    }
}
