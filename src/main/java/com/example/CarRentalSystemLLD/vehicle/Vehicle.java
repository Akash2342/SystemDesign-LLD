package com.example.CarRentalSystemLLD.vehicle;

public abstract class Vehicle {
    String vehicleID;
    String vehicleName;
    VehicleType vehicleType;
    double hourlyPrice;

    public Vehicle(String vehicleId, String name, VehicleType vehicleType, double hourlyPrice) {
        this.vehicleID = vehicleId;
        this.vehicleName = name;
        this.vehicleType = vehicleType;
        this.hourlyPrice = hourlyPrice;
    }

    public String getVehicleID() {
        return vehicleID;
    }

    public double getHourlyPrice() {
        return hourlyPrice;
    }
}
