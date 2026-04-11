package com.example.ElevatorSystemLLD.SelectionStrategy;

import com.example.ElevatorSystemLLD.Controller.ElevatorController;
import com.example.ElevatorSystemLLD.Elevator.ElevatorDirection;

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
