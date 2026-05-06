package com.example.BookMyShowLLD.Entity.Seat;

public class Seat {
    String seatId;
    SeatType seatType;

    // dedicated lock object
    private final Object lock = new Object();

    public Seat(String seatId, SeatType seatType) {
        this.seatId = seatId;
        this.seatType = seatType;
    }

    public String getSeatId() {
        return seatId;
    }

    public Object getLock() {
        return lock;
    }
}
