package com.example.ParkingLotLLD;

import com.example.ParkingLotLLD.Entity.ParkingSpot;
import com.example.ParkingLotLLD.Entity.Vehicle;

import com.example.ParkingLotLLD.Enum.VehicleType;
import com.example.ParkingLotLLD.parkingLot.ParkingBuilding;
import com.example.ParkingLotLLD.parkingLot.ParkingLevel;
import com.example.ParkingLotLLD.spotManagers.FourWheelerSpotManager;
import com.example.ParkingLotLLD.spotManagers.ParkingSpotManager;
import com.example.ParkingLotLLD.spotManagers.TwoWheelerSpotManager;
import com.example.ParkingLotLLD.ticket.Ticket;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParkingLotClient {

    public static void main(String[] args) {

        // ----------- Create Parking Spots ------------
        List<ParkingSpot> twoWheelerSpots = new ArrayList<>();
        for (int i = 1; i <= 5; i++) {
            twoWheelerSpots.add(new ParkingSpot("TW-" + i, true));
        }

        List<ParkingSpot> fourWheelerSpots = new ArrayList<>();
        for (int i = 1; i <= 5; i++) {
            fourWheelerSpots.add(new ParkingSpot("FW-" + i, true));
        }

        // ----------- Create Vehicles ------------
        Vehicle bike1 = new Vehicle("BIKE-123", VehicleType.TWO_WHEELER);
        Vehicle car1 = new Vehicle("CAR-456", VehicleType.FOUR_WHEELER);

        // Create ParkingSpotManager
        ParkingSpotManager twoWheeleerManager = new TwoWheelerSpotManager(twoWheelerSpots);
        ParkingSpotManager fourWheelerManager = new FourWheelerSpotManager(fourWheelerSpots);

        //Create ParkingLevel
        Map<VehicleType, ParkingSpotManager> parkingSpotMap = new HashMap<>();
        parkingSpotMap.put(VehicleType.TWO_WHEELER, twoWheeleerManager );
        parkingSpotMap.put(VehicleType.FOUR_WHEELER, fourWheelerManager);

        ParkingLevel parkingLevel = new ParkingLevel(1,parkingSpotMap);
        // You can add more levels if needed
        List<ParkingLevel> levels = new ArrayList<>();
        levels.add(parkingLevel);

        //Create ParkingBuilding
        ParkingBuilding building = new ParkingBuilding(1, levels);

        // Entry Flow
        System.out.println("Entry Flow");
        Ticket bikeTicket = building.allocateTicket(bike1);
        System.out.println("Bike parked at spot" + bikeTicket);

        Ticket carTicket = building.allocateTicket(car1);
        System.out.println("Car parked at spot" + carTicket);

        //ExitFlow
        System.out.println("ExitFlow" + parkingLevel);
        building.releaseTicket(bikeTicket);
        System.out.println("Bike exited from Spot" + bikeTicket.getParkingSpot().getParkingSpotId());



    }
}
