package com.example.ElevatorSystemLLD.Controller;

import com.example.ElevatorSystemLLD.Elevator.ElevatorCar;
import com.example.ElevatorSystemLLD.Elevator.ElevatorDirection;

import java.util.Collections;
import java.util.concurrent.PriorityBlockingQueue;

public class ElevatorController implements Runnable {
    ElevatorCar elevatorCar;
    PriorityBlockingQueue<Integer> pqUp;    // PriorityQueue + Thread safe
    PriorityBlockingQueue<Integer> pqDown;

    private final Object monitor = new Object();

    public ElevatorController(ElevatorCar elevatorCar) {
        this.elevatorCar = elevatorCar;
        pqUp = new PriorityBlockingQueue<>();
        pqDown = new PriorityBlockingQueue<>(11, Collections.reverseOrder());
    }

    public void submitRequest(int destinationFloor){

        System.out.println("Requesting Elevator from floor: " + destinationFloor);
         int currentFloor=elevatorCar.getCurrentFloor();
        ElevatorDirection elevatorDirection=elevatorCar.getDirection();

        if(destinationFloor==elevatorCar.getNextFloor() || destinationFloor==currentFloor){
            System.out.println("Destination Floor and Current Floor is the same, destination Floor is: "+ destinationFloor+ " current Floor is: "+ currentFloor + " elevator next floor: "+elevatorCar.getNextFloor() +" having Elevator No:"+ elevatorCar.getElevatorId());
            return;
        }

        if(elevatorDirection==ElevatorDirection.UP){
            if(destinationFloor>currentFloor){
                pqUp.add(destinationFloor);
            }
            else {
                pqDown.add(destinationFloor);
            }
        }
        else {
            if(destinationFloor<currentFloor){
                pqDown.add(destinationFloor);
            }
            else {
                pqUp.add(destinationFloor);
            }
        }

        synchronized (monitor) {
            monitor.notify();   // wake elevator thread
        }

    }

    @Override
    public void run() {
        controlElevator();
    }

    private void controlElevator() {
        while (true) {
            synchronized (monitor) {
                while (pqUp.isEmpty() && pqDown.isEmpty()) {
                    try {
                        System.out.println("Elevator " +elevatorCar.getElevatorId() +" is IDLE"+ elevatorCar.getCurrentFloor());
                        elevatorCar.setDirection(ElevatorDirection.IDLE);
                        monitor.wait();
                    } catch (InterruptedException e) {}
                }
            }

            while(!pqUp.isEmpty()){
                int floor = pqUp.poll();
                System.out.println("Elevator is moving Up to "+floor);
                elevatorCar.moveElevator(floor);
            }
            while(!pqDown.isEmpty()){
                int floor = pqDown.poll();
                System.out.println("Elevator is moving Down to "+floor);
                elevatorCar.moveElevator(floor);
            }
        }
    }

    public ElevatorCar getElevatorCar() {
        return elevatorCar;
    }
    public PriorityBlockingQueue<?> getPqUp() {
        return pqUp;
    }
    public PriorityBlockingQueue<?> getPqDown() {
        return pqDown;
    }
}
