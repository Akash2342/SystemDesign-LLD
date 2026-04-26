package com.example.CarRentalSystemLLD.store;

import com.example.CarRentalSystemLLD.reservation.Reservation;
import com.example.CarRentalSystemLLD.reservation.ReservationManager;
import com.example.CarRentalSystemLLD.user.User;
import com.example.CarRentalSystemLLD.vehicle.Vehicle;

import javax.xml.stream.Location;
import java.sql.Time;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

public class Store {
    String storeId;
    String location;
    String name;
    //VehicleId-> Vehicle
    HashMap<String,Vehicle> mapVehicleList;
    ReservationManager reservationManager;

    public Store(String location, String name, ReservationManager reservationManager) {
        this.storeId = UUID.randomUUID().toString();
        this.location = location;
        this.name = name;
        this.mapVehicleList = new HashMap<>();
        this.reservationManager= reservationManager;
    }

    public void addVehicle(Vehicle vehicle) {
        mapVehicleList.put(vehicle.getVehicleID(), vehicle);
    }

    public void removeVehicle(Vehicle vehicle) {
        mapVehicleList.remove(vehicle.getVehicleID());
    }

    public boolean checkAvailability(Vehicle vehicle, LocalDateTime start, LocalDateTime end) {
        return reservationManager.checkAvailability(vehicle.getVehicleID(), start, end);
    }

    public List<Vehicle> getVehicleList() {
       return new ArrayList<>(mapVehicleList.values());
    }

    public void cancelReservation(Reservation reservation) {
        reservation.cancelReservation();
    }

    public void completeTrip(Reservation reservation) {
        reservation.completeTrip();
    }
}
