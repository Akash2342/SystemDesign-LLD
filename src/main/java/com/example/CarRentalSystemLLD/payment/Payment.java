package com.example.CarRentalSystemLLD.payment;

import java.time.LocalTime;
import java.util.UUID;

public abstract class Payment {
    String paymentId;
    LocalTime paymentDate;
    PaymentType paymentType;
    PaymentStatus paymentStatus;

    Payment(PaymentType paymentType) {
        this.paymentId= UUID.randomUUID().toString();
        this.paymentDate = LocalTime.now();
        this.paymentType = paymentType;
    }

    public abstract void makePayment(int amount);
}
