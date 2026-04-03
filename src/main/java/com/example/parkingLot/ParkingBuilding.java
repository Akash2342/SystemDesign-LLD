package com.example.parkingLot;

import com.example.Entity.ParkingSpot;
import com.example.Entity.Vehicle;
import com.example.ticket.Ticket;

import java.util.List;

public class ParkingBuilding {

    int buildingNumber;
    List<ParkingLevel>  parkingLevels;

    public ParkingBuilding(int buildingNumber, List<ParkingLevel> parkingLevels) {
        this.buildingNumber = buildingNumber;
        this.parkingLevels = parkingLevels;
    }

    public Ticket allocateTicket(Vehicle vehicle) {
        for (ParkingLevel parkingLevel : parkingLevels) {

            if (!parkingLevel.hasAvailableSpot(vehicle.getType())) {
                continue;
            }

            ParkingSpot spot= parkingLevel.park(vehicle.getType());
            if(spot != null){
                return new Ticket(vehicle, spot, parkingLevel);
            }
        }
        throw new  RuntimeException("Parking Level Not Found");
    }

    public void releaseTicket(Ticket ticket) {
        ticket.getParkingLevel().unpark(ticket.getVehicle().getType(), ticket.getParkingSpot());
    }

}
