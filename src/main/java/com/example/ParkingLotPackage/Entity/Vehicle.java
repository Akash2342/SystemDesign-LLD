package com.example.ParkingLotPackage.Entity;

import com.example.Enum.VehicleType;

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
