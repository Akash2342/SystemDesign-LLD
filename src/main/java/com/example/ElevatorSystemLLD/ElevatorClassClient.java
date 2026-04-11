package com.example.ElevatorSystemLLD;

import com.example.ElevatorSystemLLD.Controller.ElevatorController;
import com.example.ElevatorSystemLLD.Controller.ElevatorScheduler;
import com.example.ElevatorSystemLLD.Elevator.ElevatorCar;
import com.example.ElevatorSystemLLD.ElevatorButton.ExternalButton;
import com.example.ElevatorSystemLLD.ElevatorButton.InternalButton;
import com.example.ElevatorSystemLLD.ElevatorDispatcher.ExternalDispatcher;
import com.example.ElevatorSystemLLD.ElevatorDispatcher.InternalDispatcher;
import com.example.ElevatorSystemLLD.SelectionStrategy.ElevatorSelectionStrategy;
import com.example.ElevatorSystemLLD.SelectionStrategy.NearestElevatorStrategy;

import java.util.ArrayList;
import java.util.List;

public class ElevatorClassClient {
    public static void main(String[] args) throws InterruptedException {
        //Create ElevatorCar Object
        ElevatorCar elevatorCar1=new ElevatorCar(1);
        ElevatorCar elevatorCar2=new ElevatorCar(2);

        //Create ElevatorController
        ElevatorController elevatorController1=new ElevatorController(elevatorCar1);
        ElevatorController elevatorController2=new ElevatorController(elevatorCar2);

        //Create SelectionStrategy
        ElevatorSelectionStrategy nearestElevatorStrategy= new NearestElevatorStrategy();

        //Create ElevatorScheduler
        List<ElevatorController> elevatorControllerList=new ArrayList<>();
        elevatorControllerList.add(elevatorController1);
        elevatorControllerList.add(elevatorController2);
        ElevatorScheduler elevatorScheduler= new ElevatorScheduler(elevatorControllerList, nearestElevatorStrategy);

        //Create ExternalDispatcher
        ExternalDispatcher externalDispatcher= new ExternalDispatcher(elevatorScheduler);

        //Create InternalDispatcher
        InternalDispatcher internalDispatcher= new InternalDispatcher(elevatorController1);

        //Create Button
        ExternalButton externalButton= new ExternalButton(externalDispatcher);
        InternalButton internalButton1= new InternalButton(elevatorController1);
        InternalButton internalButton2= new InternalButton(elevatorController2);

        //Create Building
        Building building= new Building(8,externalDispatcher);

        //  Start all the elevator controllers threads
        new Thread(elevatorController1, "Elevator-1").start();
        new Thread(elevatorController2, "Elevator-2").start();

       building.getFloor(3).pressUpButton();
       Thread.sleep(10);

       building.getFloor(8).pressDownButton();
       Thread.sleep(2);

       building.getFloor(6).pressUpButton();
       Thread.sleep(2);

       internalButton1.pressButton(3);


    }
}
