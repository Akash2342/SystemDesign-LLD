package com.example.ParkingLotLLD.parkingLot;

import com.example.ParkingLotLLD.Entity.Vehicle;
import com.example.ParkingLotLLD.ticket.Ticket;

public class ParkingLot {

    private final ParkingBuilding parkingBuilding;
    private final ExitGate exitGate;
    private final EntryGate entryGate;

    public ParkingLot(ParkingBuilding parkingBuilding, ExitGate exitGate, EntryGate entryGate) {
        this.parkingBuilding = parkingBuilding;
        this.exitGate = exitGate;
        this.entryGate = entryGate;
    }

    public Ticket vehicleArrives(Vehicle vehicle) {
        return entryGate.enter(parkingBuilding, vehicle);
    }

    public void vehicleExits(Ticket ticket) {
        exitGate.checkOut(ticket);
    }

}

