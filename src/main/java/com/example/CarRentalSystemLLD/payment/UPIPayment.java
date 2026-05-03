package com.example.CarRentalSystemLLD.payment;

import java.time.LocalTime;

public class UPIPayment extends Payment {
    String upiId;

    UPIPayment(String upiId, String billId){
        super(PaymentType.UPI_PAYMENT,billId);
        this.upiId = upiId;
    }

    @Override
    public void makePayment(int amount) {
        System.out.println("UPI Payment " + this.upiId + " of" + amount);
        this.paymentStatus= PaymentStatus.SUCCESS;
        System.out.println("Payment Successfull" + this.upiId + " of" + amount);
        this.totalAmount = amount;
    }
}
