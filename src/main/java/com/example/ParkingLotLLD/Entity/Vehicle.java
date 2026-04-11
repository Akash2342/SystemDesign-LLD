package com.example.ParkingLotLLD.Entity;


import com.example.ParkingLotLLD.Enum.VehicleType;

public class Vehicle {

    String licenceNo;
    VehicleType type;

    public Vehicle(String licenceNo, VehicleType type) {
        this.licenceNo = licenceNo;
        this.type = type;
    }

    public String getLicenceNo() {
        return licenceNo;
    }

    public void setLicenceNo(String licenceNo) {
        this.licenceNo = licenceNo;
    }

    public VehicleType getType() {
        return type;
    }
}
