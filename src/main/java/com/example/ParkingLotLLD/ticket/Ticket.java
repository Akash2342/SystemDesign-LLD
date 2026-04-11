package com.example.ParkingLotPackage.ticket;

import com.example.ParkingLotPackage.Entity.ParkingSpot;
import com.example.ParkingLotPackage.Entity.Vehicle;
import com.example.ParkingLotPackage.parkingLot.ParkingLevel;

import java.time.LocalDateTime;
import java.util.UUID;

public class Ticket {

    private final String ticketId;
    private final Vehicle  vehicle;
    private final ParkingSpot parkingSpot;
    private final ParkingLevel parkingLevel;
    private final LocalDateTime dateTime;

    public Ticket(Vehicle vehicle, ParkingSpot parkingSpot, ParkingLevel parkingLevel) {
        this.ticketId = UUID.randomUUID().toString();
        this.vehicle = vehicle;
        this.parkingSpot = parkingSpot;
        this.parkingLevel = parkingLevel;
        this.dateTime = LocalDateTime.now();
    }

    public String getTicketId() {
        return ticketId;
    }
    public Vehicle getVehicle() {
        return vehicle;
    }
    public ParkingSpot getParkingSpot() {
        return parkingSpot;
    }
    public ParkingLevel getParkingLevel() {
        return parkingLevel;
    }
    public LocalDateTime getEntryTime() {
        return dateTime;
    }

}
