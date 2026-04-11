package com.example.ElevatorSystemLLD.Controller;

import com.example.ElevatorSystemLLD.Elevator.ElevatorDirection;
import com.example.ElevatorSystemLLD.SelectionStrategy.ElevatorSelectionStrategy;

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
