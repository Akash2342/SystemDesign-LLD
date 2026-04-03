package com.example.ParkingLotPackage.pricing;

import com.example.ParkingLotPackage.ticket.Ticket;

import java.time.Duration;
import java.time.LocalDateTime;

public class PricingService {

    public double calculatePrice(Ticket ticket) {
        Duration duration = Duration.between(ticket.getEntryTime(), LocalDateTime.now());
        long hours = duration.toHours();

        return hours >= 0 ? hours * 24 : 0;
    }
}
