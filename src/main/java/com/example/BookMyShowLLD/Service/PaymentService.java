package com.example.BookMyShowLLD.Service;

import com.example.BookMyShowLLD.Entity.Payment.Payment;
import com.example.BookMyShowLLD.Entity.User;

public class PaymentService {
    public void processPayment(User user, double amount) {
        Payment payment = new Payment("ds2", 123, user);
    }
}
