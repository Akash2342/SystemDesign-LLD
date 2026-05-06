package com.example.BookMyShowLLD.Entity;

import com.example.BookMyShowLLD.Entity.Payment.Payment;
import com.example.BookMyShowLLD.Entity.Seat.Seat;
import com.example.BookMyShowLLD.Entity.Show.Show;

import java.util.List;

public class Bookings {
    String bookingId;
    User user;
//    Movie movie;
//    Theatre theatre;
  //  Screen screen;
    List<Seat> seatList;
    Show show;
    int amount;
    Payment payment;

    public Bookings(String bookingId, User user, List<Seat>seatList, Show show, int amount) {
        this.bookingId = bookingId;
        this.user = user;
        this.seatList = seatList;
        this.show = show;
        this.amount = amount;
    }

    public String getBookingId() {
        return bookingId;
    }
    public void setBookingId(String bookingId) {
        this.bookingId = bookingId;
    }
    public User getUser() {
        return user;
    }
}
