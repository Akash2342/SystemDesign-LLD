package com.example.CarRentalSystemLLD.user;

public class User {
    String userId;
    String name;
    String licenceID;

    public User(String id, String name, String licenceID) {
        this.userId = id;
        this.name = name;
        this.licenceID = licenceID;
    }
}
