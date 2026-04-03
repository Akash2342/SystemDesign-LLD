package com.example.ParkingLotPackage.parkingLot;

import com.example.ParkingLotPackage.Entity.Vehicle;
import com.example.ParkingLotPackage.ticket.Ticket;

public class EntryGate {

    public Ticket enter(ParkingBuilding parkingBuilding, Vehicle vehicle) {
       return parkingBuilding.allocateTicket(vehicle);
    }
}
