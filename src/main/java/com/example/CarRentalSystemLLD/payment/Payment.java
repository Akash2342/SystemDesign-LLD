package com.example.CarRentalSystemLLD.payment;

import java.time.LocalTime;
import java.util.UUID;

public abstract class Payment {
    String paymentId;
    LocalTime paymentDate;
    PaymentType paymentType;
    PaymentStatus paymentStatus;
    String billId;
    double totalAmount;

    Payment(PaymentType paymentType, String billId) {
        this.paymentId= UUID.randomUUID().toString();
        this.paymentDate = LocalTime.now();
        this.paymentType = paymentType;
        this.billId = billId;
    }

    public abstract void makePayment(int amount);
}
