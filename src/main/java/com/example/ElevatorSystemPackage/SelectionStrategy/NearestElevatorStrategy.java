package com.example.ElevatorSystemPackage.SelectionStrategy;

import com.example.ElevatorSystemPackage.Controller.ElevatorController;
import com.example.ElevatorSystemPackage.Elevator.ElevatorDirection;

import java.util.List;

public class NearestElevatorStrategy implements ElevatorSelectionStrategy{

    @Override
    public ElevatorController selectElevators(List<ElevatorController> elevatorControllerList, int requestFloor, ElevatorDirection elevatorDirection) {
        ElevatorController best = null;
        int minDistance = Integer.MAX_VALUE;

        //1. Pick the one which is going in same direction and minimum distance from the destination
        for (ElevatorController controller : elevatorControllerList) {
            int nextFloorStoppage = controller.getElevatorCar().getNextFloor();

            // Good candidate if moving same direction & not passed requested floor
            boolean isSameDirectionCandidate =
                    controller.getElevatorCar().getDirection() == elevatorDirection &&
                            ((elevatorDirection == ElevatorDirection.UP && nextFloorStoppage <= requestFloor) ||
                                    (elevatorDirection == ElevatorDirection.DOWN && nextFloorStoppage >= requestFloor));

            int dist = Math.abs(nextFloorStoppage - requestFloor);

            if (isSameDirectionCandidate && dist < minDistance) {
                minDistance = dist;
                best = controller;
            }
        }

        // fallback: if not able to choose, pick the idle one
        if (best == null) {
            for (ElevatorController controller : elevatorControllerList) {
                if(controller.getElevatorCar().getDirection() == ElevatorDirection.IDLE) {
                    best = controller;
                    break;
                }
            }

            //reached here means, no list is going in same direction and no lift is IDLE too, then pick any lift
            if(best == null) {
                best = elevatorControllerList.get(0);
            }
        }
        return best;

    }
}
