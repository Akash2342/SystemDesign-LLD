package com.example.ElevatorSystemPackage.SelectionStrategy;

import com.example.ElevatorSystemPackage.Controller.ElevatorController;
import com.example.ElevatorSystemPackage.Elevator.ElevatorDirection;

import java.util.List;

public class LeastBusyStrategy implements ElevatorSelectionStrategy{
    @Override
    public ElevatorController selectElevators(List<ElevatorController> elevatorControllerList, int requestFloor, ElevatorDirection direction) {
        ElevatorController best = null;
        int minLoad = Integer.MAX_VALUE;

        for (ElevatorController controller : elevatorControllerList) {
            int load = controller.getPqUp().size() +
                    controller.getPqDown().size();

            if (load < minLoad) {
                minLoad = load;
                best = controller;
            }
        }
        return best;

    }
}
