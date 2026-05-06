package com.example.BookMyShowLLD.Controller;

import com.example.BookMyShowLLD.Entity.*;
import com.example.BookMyShowLLD.Entity.Seat.Seat;
import com.example.BookMyShowLLD.Entity.Show.SeatStatus;
import com.example.BookMyShowLLD.Entity.Show.Show;
import com.example.BookMyShowLLD.Service.BookingService;

import javax.annotation.processing.Messager;
import java.util.List;

public class BookingController {
    BookingService bookingService = new BookingService();

    public Bookings createBooking(User user, List<Seat> seatList, Show show) {
       return bookingService.createBooking(user, seatList, show);
    }
}

//Problem:
//
//Two users selecting same seat
//
//Solution options:
//        ✅ 1. Synchronized (basic LLD)
//synchronized(show) { }
//        ✅ 2. DB Locking (real-world)
//Optimistic Locking (version)
//Pessimistic Locking (row lock)
//✅ 3. Redis Lock (scalable)
//Distributed locking