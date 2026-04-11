package com.example.ElevatorSystemLLD.SelectionStrategy;

import com.example.ElevatorSystemLLD.Controller.ElevatorController;
import com.example.ElevatorSystemLLD.Elevator.ElevatorDirection;

import java.util.List;

public interface ElevatorSelectionStrategy {
    ElevatorController selectElevators(List<ElevatorController>elevatorControllerList, int floor, ElevatorDirection elevatorDirection);
}
