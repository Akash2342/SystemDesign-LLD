package com.example.ElevatorSystemLLD.ElevatorDispatcher;

import com.example.ElevatorSystemLLD.Controller.ElevatorController;
import com.example.ElevatorSystemLLD.Controller.ElevatorScheduler;
import com.example.ElevatorSystemLLD.Elevator.ElevatorDirection;

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
