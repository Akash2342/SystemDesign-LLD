package com.example.ElevatorSystemLLD.ElevatorButton;

import com.example.ElevatorSystemLLD.Controller.ElevatorController;

public class InternalButton {
    ElevatorController controller;
    public InternalButton(ElevatorController elevatorController){
        this.controller = elevatorController;
    }

    public void pressButton(int destinationFloor){
        controller.submitRequest(destinationFloor);
    }
}
