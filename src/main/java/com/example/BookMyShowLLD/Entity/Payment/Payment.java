package com.example.BookMyShowLLD.Entity.Payment;

import com.example.BookMyShowLLD.Entity.Bookings;
import com.example.BookMyShowLLD.Entity.User;

public class Payment {
    String paymentId;
    PaymentStatus paymentStatus;
    User user;
    double amount;

    public Payment(String paymentId, double amount, User user){
        this.paymentId = paymentId;
        this.paymentStatus= PaymentStatus.SUCCESS;
        this.user = user;
        this.amount = amount;
    }

}
