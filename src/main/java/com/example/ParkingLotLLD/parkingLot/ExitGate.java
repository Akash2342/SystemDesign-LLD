package com.example.ParkingLotPackage.parkingLot;

import com.example.ParkingLotPackage.pricing.PricingService;
import com.example.ParkingLotPackage.ticket.Ticket;

public class ExitGate {

    private final PricingService pricingService;

    public ExitGate(PricingService pricingService) {
        this.pricingService = pricingService;
    }

    public void checkOut(Ticket ticket) {

        double amount = pricingService.calculatePrice(ticket);
        ticket.getParkingLevel().unpark(ticket.getVehicle().getType(), ticket.getParkingSpot());

    }
}
