package com.example.ElevatorSystemPackage;

import com.example.ElevatorSystemPackage.ElevatorDispatcher.ExternalDispatcher;

import java.util.ArrayList;
import java.util.List;

public class Building {
    List<Floor> floors=new ArrayList<Floor>();

    public Building(int totalFloors, ExternalDispatcher externalDispatcher){
        for(int i=0;i<=totalFloors;i++){
            floors.add(new Floor(i,externalDispatcher));
        }
    }

    public Floor getFloor(int floorNumber){
        return floors.get(floorNumber);
    }
}
