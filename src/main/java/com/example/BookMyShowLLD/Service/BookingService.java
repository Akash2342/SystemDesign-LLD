package com.example.BookMyShowLLD.Service;

import com.example.BookMyShowLLD.Entity.Bookings;
import com.example.BookMyShowLLD.Entity.Seat.Seat;
import com.example.BookMyShowLLD.Entity.Show.SeatStatus;
import com.example.BookMyShowLLD.Entity.Show.Show;
import com.example.BookMyShowLLD.Entity.User;

import java.util.List;
import java.util.UUID;

public class BookingService {

    public Bookings createBooking(User user,
                                  List<Seat> seatList,
                                  Show show) {

        // lock entire show
        synchronized (show) {

            // -----------------------------
            // Phase 1 : Validate ALL seats
            // -----------------------------
            for (Seat seat : seatList) {

                SeatStatus status =
                        show.getSeatStatus(seat.getSeatId());

                if (status != SeatStatus.AVAILABLE) {

                    throw new RuntimeException(
                            "Seat already booked: "
                                    + seat.getSeatId()
                    );
                }
            }

            // -----------------------------
            // Phase 2 : Update ALL seats
            // -----------------------------
            for (Seat seat : seatList) {

                show.updateSeatStatus(
                        seat.getSeatId(),
                        SeatStatus.BOOKED
                );
            }

            // -----------------------------
            // Phase 3 : Create Booking
            // -----------------------------
            return new Bookings(
                    UUID.randomUUID().toString(),
                    user,
                    seatList,
                    show,
                    100
            );
        }
    }
}

//Instead of locking whole show we can use seat level locking approach but we need to take care of deadlocking case
//🚀 Booking Service With Seat-Level Locking
/*
import java.util.Comparator;
import java.util.List;
import java.util.UUID;

public class BookingService {

    public Bookings createBooking(User user,
                                  List<Seat> seatList,
                                  Show show) {

        // -----------------------------------
        // Step 1: Sort seats to avoid deadlock
        // -----------------------------------
        seatList.sort(
                Comparator.comparing(Seat::getSeatId)
        );

        // -----------------------------------
        // Step 2: Acquire locks recursively
        // -----------------------------------
        return lockSeatsAndBook(
                user,
                seatList,
                show,
                0
        );
    }

    private Bookings lockSeatsAndBook(User user,
                                      List<Seat> seatList,
                                      Show show,
                                      int index) {

        // base case
        if (index == seatList.size()) {

            // ----------------------------
            // Validate ALL seats
            // ----------------------------
            for (Seat seat : seatList) {

                if (show.getSeatStatus(seat.getSeatId())
                        != SeatStatus.AVAILABLE) {

                    throw new RuntimeException(
                            "Seat already booked: "
                                    + seat.getSeatId()
                    );
                }
            }

            // ----------------------------
            // Update ALL seats
            // ----------------------------
            for (Seat seat : seatList) {

                show.updateSeatStatus(
                        seat.getSeatId(),
                        SeatStatus.BOOKED
                );
            }

            return new Bookings(
                    UUID.randomUUID().toString(),
                    user,
                    seatList,
                    show,
                    100
            );
        }

        // lock current seat
        synchronized (seatList.get(index).getLock()) {

            return lockSeatsAndBook(
                    user,
                    seatList,
                    show,
                    index + 1
            );
        }
    }
}
*/