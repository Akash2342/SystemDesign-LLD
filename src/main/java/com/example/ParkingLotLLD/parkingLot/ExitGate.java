package com.example.ParkingLotLLD.parkingLot;

import com.example.ParkingLotLLD.pricing.PricingService;
import com.example.ParkingLotLLD.ticket.Ticket;

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
