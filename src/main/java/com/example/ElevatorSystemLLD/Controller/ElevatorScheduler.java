package com.example.ElevatorSystemPackage.Controller;

import com.example.ElevatorSystemPackage.Elevator.ElevatorDirection;
import com.example.ElevatorSystemPackage.SelectionStrategy.ElevatorSelectionStrategy;

import java.util.ArrayList;
import java.util.List;

public class ElevatorScheduler {
    List<ElevatorController> elevatorControllerList;
    ElevatorSelectionStrategy elevatorSelectionStrategy;

    public ElevatorScheduler(List<ElevatorController> elevatorControllerList, ElevatorSelectionStrategy selectionStrategy) {
        this.elevatorControllerList = elevatorControllerList;
        this.elevatorSelectionStrategy = selectionStrategy;
    }

    public ElevatorController assignElevator(int floor, ElevatorDirection elevatorDirection) {
        return elevatorSelectionStrategy.selectElevators(elevatorControllerList, floor, elevatorDirection);
    }

    public void setSelectionStrategy(ElevatorSelectionStrategy selectionStrategy) {
        this.elevatorSelectionStrategy = selectionStrategy;
    }
}
