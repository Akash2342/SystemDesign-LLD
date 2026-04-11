package com.example.ParkingLotLLD.parkingLot;

import com.example.ParkingLotLLD.Entity.Vehicle;
import com.example.ParkingLotLLD.ticket.Ticket;

public class EntryGate {

    public Ticket enter(ParkingBuilding parkingBuilding, Vehicle vehicle) {
       return parkingBuilding.allocateTicket(vehicle);
    }
}
