package com.example.BookMyShowLLD.Controller;

import com.example.BookMyShowLLD.Entity.User;
import com.example.BookMyShowLLD.Service.PaymentService;

import java.awt.print.Book;

public class PaymentController {
    PaymentService paymentService= new  PaymentService();

    public void processPayment(User user, double amount){
        paymentService.processPayment(user, amount);
    }
}
