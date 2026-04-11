package com.example.ElevatorSystemLLD;

import com.example.ElevatorSystemLLD.Elevator.ElevatorDirection;
import com.example.ElevatorSystemLLD.ElevatorButton.ExternalButton;
import com.example.ElevatorSystemLLD.ElevatorDispatcher.ExternalDispatcher;

public class Floor {
    int floorNumber;
    ExternalButton upButton;
    ExternalButton downButton;

    public Floor(int floorNumber, ExternalDispatcher externalDispatcher) {
        this.floorNumber=floorNumber;
        this.upButton=new ExternalButton(externalDispatcher);
        this.downButton=new ExternalButton(externalDispatcher);
    }

    public void pressUpButton(){
        upButton.pressButton(floorNumber, ElevatorDirection.UP);
    }

    public void pressDownButton(){
        downButton.pressButton(floorNumber, ElevatorDirection.DOWN);
    }

}
