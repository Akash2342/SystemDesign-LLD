package com.example.ElevatorSystemPackage.ElevatorDispatcher;

import com.example.ElevatorSystemPackage.Controller.ElevatorController;
import com.example.ElevatorSystemPackage.Controller.ElevatorScheduler;
import com.example.ElevatorSystemPackage.Elevator.ElevatorDirection;

public class ExternalDispatcher {
    ElevatorScheduler scheduler;

    public ExternalDispatcher(ElevatorScheduler scheduler) {
        this.scheduler = scheduler;
    }

    public void submitRequest(int floor, ElevatorDirection elevatorDirection){

        ElevatorController elevatorController=scheduler.assignElevator(floor, elevatorDirection);
        elevatorController.submitRequest(floor);
    }
}
