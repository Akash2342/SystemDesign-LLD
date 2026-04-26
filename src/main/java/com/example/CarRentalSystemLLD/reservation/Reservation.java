package com.example.CarRentalSystemLLD.reservation;

import com.example.CarRentalSystemLLD.user.User;
import com.example.CarRentalSystemLLD.vehicle.Vehicle;

import java.sql.Time;
import java.time.LocalDateTime;

public class Reservation {
    String reservationId;
    LocalDateTime startTime;
    LocalDateTime endTime;
    ReservationStatus reservationStatus;
    Vehicle vehicle;
    User user;

     Reservation(String reservationId, LocalDateTime startTime, LocalDateTime endTime, Vehicle vehicle, User user) {
        this.reservationId = reservationId;
        this.startTime = startTime;
        this.endTime = endTime;
        this.reservationStatus = ReservationStatus.RESERVED;
        this.vehicle = vehicle;
        this.user = user;
    }

    public void cancelReservation() {
         this.reservationStatus = ReservationStatus.CANCELLED;
    }

    public void completeTrip() {
        this.reservationStatus=ReservationStatus.AVAILABLE;
    }

    public Boolean checkLapse(LocalDateTime actualStartTime, LocalDateTime actualEndTime) {
        return !(actualEndTime.isBefore(startTime) && actualStartTime.isAfter(endTime));
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }
}
