package com.example.ElevatorSystemPackage.ElevatorButton;

import com.example.ElevatorSystemPackage.Controller.ElevatorController;
import com.example.ElevatorSystemPackage.Elevator.ElevatorDirection;
import com.example.ElevatorSystemPackage.ElevatorDispatcher.InternalDispatcher;

public class InternalButton {
    ElevatorController controller;
    public InternalButton(ElevatorController elevatorController){
        this.controller = elevatorController;
    }

    public void pressButton(int destinationFloor){
        controller.submitRequest(destinationFloor);
    }
}
