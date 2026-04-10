package com.example.ElevatorSystemPackage.ElevatorDispatcher;

import com.example.ElevatorSystemPackage.Controller.ElevatorController;

public class InternalDispatcher {
    ElevatorController elevatorController;

    public InternalDispatcher(ElevatorController elevatorController) {
        this.elevatorController = elevatorController;
    }

    public void submitRequest(int destinationFloor){
        elevatorController.submitRequest(destinationFloor);
    }
}
