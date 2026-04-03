package com.example.parkingLot;

import com.example.Entity.Vehicle;
import com.example.ticket.Ticket;

public class EntryGate {

    public Ticket enter(ParkingBuilding parkingBuilding, Vehicle vehicle) {
       return parkingBuilding.allocateTicket(vehicle);
    }
}
