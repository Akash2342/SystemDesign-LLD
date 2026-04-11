package com.example.ParkingLotPackage.Entity;

public class ParkingSpot {

    private final String parkingSpotId;
    private boolean isFree=true;

    public ParkingSpot(String parkingSpotId, boolean isFree){
        this.parkingSpotId = parkingSpotId;
        this.isFree = isFree;
    }

    public String getParkingSpotId() {
        return parkingSpotId;
    }

    public boolean isFree() {
        return isFree;
    }

    public void occupySpot() {
        isFree=false;
    }

    public void releaseSpot() {
        isFree=true;
    }


}
