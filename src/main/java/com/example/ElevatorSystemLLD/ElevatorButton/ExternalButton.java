package com.example.ElevatorSystemLLD.ElevatorButton;

import com.example.ElevatorSystemLLD.Elevator.ElevatorDirection;
import com.example.ElevatorSystemLLD.ElevatorDispatcher.ExternalDispatcher;

public class ExternalButton {
    private final ExternalDispatcher externalDispatcher;
    public ExternalButton(ExternalDispatcher externalDispatcher) {
        this.externalDispatcher = externalDispatcher;
    }

    public void pressButton(int destinationFloor, ElevatorDirection elevatorDirection){
        externalDispatcher.submitRequest(destinationFloor, elevatorDirection);
    }
}
