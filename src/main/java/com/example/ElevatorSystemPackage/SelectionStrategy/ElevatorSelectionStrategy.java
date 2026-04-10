package com.example.ElevatorSystemPackage.SelectionStrategy;

import com.example.ElevatorSystemPackage.Controller.ElevatorController;
import com.example.ElevatorSystemPackage.Elevator.ElevatorDirection;

import java.util.List;

public interface ElevatorSelectionStrategy {
    ElevatorController selectElevators(List<ElevatorController>elevatorControllerList, int floor, ElevatorDirection elevatorDirection);
}
