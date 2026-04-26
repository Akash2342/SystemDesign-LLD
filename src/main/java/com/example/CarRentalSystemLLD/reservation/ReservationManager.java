package com.example.CarRentalSystemLLD.reservation;

import com.example.CarRentalSystemLLD.user.User;
import com.example.CarRentalSystemLLD.vehicle.Vehicle;

import java.time.LocalDateTime;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

//Note we can use syncronized here directly in ReservationManager but since this will block other thread if this is in use
public class ReservationManager {

    /**
     * Stores reservations per vehicle.
     * Key   -> vehicleId
     * Value -> list of reservations for that vehicle
     *
     * Why ConcurrentHashMap?
     * - Multiple threads can read/write safely
     * - Required for concurrent booking scenarios
     */
    private final Map<String, List<Reservation>> reservationMap = new ConcurrentHashMap<>();

    /**
     * Lock map for fine-grained synchronization.
     * Key   -> vehicleId
     * Value -> lock object
     *
     * Why do we need this?
     * - Prevent double booking for SAME vehicle
     * - Allow parallel booking for DIFFERENT vehicles
     */
    private final ConcurrentHashMap<String, Object> locks = new ConcurrentHashMap<>();


    /**
     * Creates a reservation for a vehicle.
     *
     * IMPORTANT:
     * This method uses per-vehicle locking to ensure:
     * 1. Availability check + reservation creation is atomic
     * 2. No two threads can book the same vehicle at the same time
     */
    public Reservation createReservation(LocalDateTime startTime,
                                         LocalDateTime endTime,
                                         Vehicle vehicle,
                                         User user) {

        String vehicleId = vehicle.getVehicleID();

        // Get or create a lock specific to this vehicle
        Object lock = locks.computeIfAbsent(vehicleId, k -> new Object());

        /**
         * WHY THIS LOCK?
         *
         * We want:
         * 1. No double booking for SAME vehicle
         * 2. Allow parallel booking for DIFFERENT vehicles
         */
        synchronized (lock) {

            // Step 1: Validate time range
            if (startTime.isAfter(endTime)) {
                throw new IllegalArgumentException("Invalid time range");
            }

            // Step 2: Check availability
            if (!checkAvailability(vehicleId, startTime, endTime)) {
                throw new RuntimeException("Vehicle not available for given time slot");
            }

            // Step 3: Create reservation
            String reservationId = UUID.randomUUID().toString();

            Reservation reservation = new Reservation(
                    reservationId, startTime, endTime, vehicle, user
            );

            // Step 4: Store reservation
            reservationMap
                    .computeIfAbsent(vehicleId, k -> new ArrayList<>())
                    .add(reservation);

            System.out.println("Reservation created with ID: " + reservationId);

            return reservation;
        }
    }


    /**
     * Checks if a vehicle is available for the given time slot.
     *
     * Logic:
     * - Iterate over existing reservations
     * - Ignore CANCELLED reservations
     * - Check for time overlap
     *
     * Overlap condition:
     * start < existingEnd AND existingStart < end
     */
    public boolean checkAvailability(String vehicleId,
                                     LocalDateTime start,
                                     LocalDateTime end) {

        List<Reservation> reservations =
                reservationMap.getOrDefault(vehicleId, Collections.emptyList());

        for (Reservation r : reservations) {

            // Ignore cancelled reservations
            if (r.reservationStatus == ReservationStatus.CANCELLED) continue;

            // Check overlap
            boolean overlap = start.isBefore(r.getEndTime()) &&
                    r.getStartTime().isBefore(end);

            if (overlap) {
                return false; // Not available
            }
        }

        return true; // Available
    }
    /**
     * ❗ WHAT IF WE USED synchronized METHOD INSTEAD?
     *
     * Example:
     *
     * public synchronized Reservation createReservation(...) { ... }
     *
     * -----------------------------------------
     * PROBLEMS WITH METHOD-LEVEL SYNCHRONIZED:
     * -----------------------------------------
     *
     * 1. GLOBAL LOCK (on ReservationManager instance)
     *    → Only ONE thread can execute at a time
     *
     *    Example:
     *    Thread1 → booking Vehicle V1
     *    Thread2 → booking Vehicle V2
     *
     *    ❌ Thread2 must WAIT even though vehicles are different
     *
     *
     * 2. POOR SCALABILITY
     *    → System throughput decreases under load
     *    → All bookings become sequential
     *
     *
     * 3. UNNECESSARY BLOCKING
     *    → Independent operations block each other
     *
     *
     * -----------------------------------------
     * WHY LOCK MAP IS BETTER:
     * -----------------------------------------
     *
     * 1. LOCK GRANULARITY = VEHICLE LEVEL
     *
     *    Thread1 → locks V1
     *    Thread2 → locks V2
     *
     *    ✔ Both run in parallel
     *
     *
     * 2. HIGHER THROUGHPUT
     *    → More bookings per second
     *
     *
     * 3. CORRECTNESS + PERFORMANCE
     *    → Prevents double booking
     *    → Without sacrificing concurrency
     *
     *
     * -----------------------------------------
     * INTERVIEW ONE-LINER:
     * -----------------------------------------
     *
     * "Method-level synchronized causes global locking,
     *  whereas lock-map provides fine-grained locking
     *  at vehicle level, improving scalability."
     *
     */

}