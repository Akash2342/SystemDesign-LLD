package com.example.ElevatorSystemPackage.ElevatorButton;

import com.example.ElevatorSystemPackage.Elevator.ElevatorDirection;
import com.example.ElevatorSystemPackage.ElevatorDispatcher.ExternalDispatcher;

public class ExternalButton {
    private final ExternalDispatcher externalDispatcher;
    public ExternalButton(ExternalDispatcher externalDispatcher) {
        this.externalDispatcher = externalDispatcher;
    }

    public void pressButton(int destinationFloor, ElevatorDirection elevatorDirection){
        externalDispatcher.submitRequest(destinationFloor, elevatorDirection);
    }
}
