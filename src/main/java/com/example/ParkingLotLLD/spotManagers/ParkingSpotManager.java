package com.example.ParkingLotLLD.spotManagers;

import com.example.ParkingLotLLD.Entity.ParkingSpot;

import java.util.List;

public abstract class ParkingSpotManager {

    protected final List<ParkingSpot> parkingSpots;

    protected ParkingSpotManager(List<ParkingSpot> parkingSpots) {
        this.parkingSpots = parkingSpots;
    }

    public ParkingSpot park() {
        for(ParkingSpot spot : parkingSpots) {
            if(spot.isFree()) {
                return spot;
            }
        }
        return null;
    }

    public void unPark(ParkingSpot spot) {
        spot.releaseSpot();
    }

    public boolean hasFreeSpot() {
        for(ParkingSpot spot : parkingSpots) {
            if(spot.isFree()) {
                return true;
            }
        }
        return false;
    }

}
