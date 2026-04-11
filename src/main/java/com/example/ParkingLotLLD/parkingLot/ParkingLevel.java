package com.example.ParkingLotLLD.parkingLot;

import com.example.ParkingLotLLD.Entity.ParkingSpot;

import com.example.ParkingLotLLD.Enum.VehicleType;
import com.example.ParkingLotLLD.spotManagers.ParkingSpotManager;

import java.util.Map;

public class ParkingLevel {

    int levelNumber;
    Map<VehicleType, ParkingSpotManager> mapParkingSpotManager;

    public ParkingLevel(int levelNumber, Map<VehicleType, ParkingSpotManager> mapParkingSpotManager) {
        this.levelNumber = levelNumber;
        this.mapParkingSpotManager = mapParkingSpotManager;
    }

    public int getLevelNumber() {
        return levelNumber;
    }

    public Map<VehicleType, ParkingSpotManager> getMapParkingSpotManager() {
        return mapParkingSpotManager;
    }

    public boolean hasAvailableSpot(VehicleType vehicleType) {
        ParkingSpotManager manager = mapParkingSpotManager.get(vehicleType);
        return manager != null && manager.hasFreeSpot();
    }

    public ParkingSpot park(VehicleType vehicleType) {
        return mapParkingSpotManager.get(vehicleType).park();
    }

    public void unpark(VehicleType vehicleType,  ParkingSpot parkingSpot) {
        ParkingSpotManager manager = mapParkingSpotManager.get(vehicleType);
        if (manager != null) {
            manager.unPark(parkingSpot);
        }
    }
}
