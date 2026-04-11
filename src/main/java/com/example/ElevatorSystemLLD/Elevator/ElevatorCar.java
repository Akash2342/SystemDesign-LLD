package com.example.ElevatorSystemPackage.Elevator;

public class ElevatorCar {
    int elevatorId;
    int currentFloor;
    int nextFloor;
    ElevatorDirection direction;
    Door door;

    public ElevatorCar(int elevatorId){
        this.elevatorId = elevatorId;
        this.currentFloor = 0;
        this.nextFloor = 0;
        this.direction = ElevatorDirection.IDLE;
        this.door=Door.CLOSE_DOOR;
    }

    public void showDisplay() {
        System.out.println("elevator:" + elevatorId + " Current floor: " + currentFloor + " going: " + direction);
    }


    public void moveElevator(int destinationFloor){

        //this is dump object, so if command has come, to go particular direction and particular floor, it just move
        //no matter what its current state and floor.

        this.nextFloor = destinationFloor;
        if(this.currentFloor == destinationFloor){
            this.door=Door.OPEN_DOOR;
            return;
        }

        int startFloor = this.currentFloor;
        door=Door.CLOSE_DOOR;
        if(nextFloor > currentFloor){
            direction=ElevatorDirection.UP;

            System.out.println("nextFloor:" + nextFloor + " Current Floor: " + currentFloor + " going: " + direction);

            for(int i=startFloor+1; i<=destinationFloor; i++){
                setCurrentFloor(i);
                showDisplay();
                try{
                    Thread.sleep(5);
                }
                catch(Exception e){}
            }

        }
        else{
            direction=ElevatorDirection.DOWN;
            showDisplay();
            for(int i=startFloor-1; i>=destinationFloor; i--){
                setCurrentFloor(i);
                showDisplay();
                try{
                    Thread.sleep(5);
                }
                catch(Exception e){}
            }
        }
        door=Door.OPEN_DOOR;
    }

    private void setCurrentFloor(int currentFloor) {
        this.currentFloor = currentFloor;
    }

    public int getCurrentFloor() {
        return currentFloor;
    }
    public int getNextFloor() {
        return nextFloor;
    }
    public ElevatorDirection getDirection() {
        return direction;
    }
    public void setDirection(ElevatorDirection direction) {
        this.direction = direction;
    }
    public int getElevatorId() {
        return elevatorId;
    }


}
