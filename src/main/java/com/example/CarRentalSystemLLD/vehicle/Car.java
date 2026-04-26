package com.example.CarRentalSystemLLD.vehicle;

public class Car extends Vehicle {
    public Car(String vehicleId, String name,double hourlyPrice) {
        super(vehicleId, name, VehicleType.CAR, hourlyPrice);
    }
}
