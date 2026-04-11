package com.example.ElevatorSystemLLD.ElevatorDispatcher;

import com.example.ElevatorSystemLLD.Controller.ElevatorController;

public class InternalDispatcher {
    ElevatorController elevatorController;

    public InternalDispatcher(ElevatorController elevatorController) {
        this.elevatorController = elevatorController;
    }

    public void submitRequest(int destinationFloor){
        elevatorController.submitRequest(destinationFloor);
    }
}
