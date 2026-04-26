package com.example.CarRentalSystemLLD;

import com.example.CarRentalSystemLLD.reservation.Reservation;
import com.example.CarRentalSystemLLD.reservation.ReservationManager;
import com.example.CarRentalSystemLLD.store.Store;
import com.example.CarRentalSystemLLD.user.User;
import com.example.CarRentalSystemLLD.vehicle.Car;
import com.example.CarRentalSystemLLD.vehicle.Vehicle;

import javax.xml.stream.Location;
import java.sql.Time;
import java.time.LocalDateTime;

public class RentalSystemClient {
    public static void main(String[] args) {
        Vehicle ertiga = new Car("v1", "ertiga", 5);
        Vehicle bmw = new Car("v2", "bmw", 10);

        User customer1 = new User("u1", "aman", "JHOPK2282N");

        ReservationManager reservationManager = new ReservationManager();

        LocalDateTime start1 = LocalDateTime.of(2026, 4, 25, 10, 30);
        LocalDateTime end1 = LocalDateTime.of(2026, 4, 25, 12, 30);

        LocalDateTime start2 = LocalDateTime.of(2026, 4, 26, 10, 30);
        LocalDateTime end2 = LocalDateTime.of(2026, 4, 26, 12, 30);

        Reservation reservation1 = reservationManager.createReservation(start1, end1, ertiga, customer1);
        Reservation reservation2 = reservationManager.createReservation(start2, end2, ertiga, customer1);

        Store store1 = new Store("nawada", "SanjayStore", reservationManager);

        // Try overlapping booking
        LocalDateTime start3 = LocalDateTime.of(2026, 4, 25, 11, 0);
        LocalDateTime end3 = LocalDateTime.of(2026, 4, 25, 12, 0);

        try {
            Reservation reservation3 = reservationManager.createReservation(start3, end3, ertiga, customer1);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Booking failed");
        }
    }
}
