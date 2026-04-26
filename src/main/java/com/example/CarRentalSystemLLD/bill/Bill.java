package com.example.CarRentalSystemLLD.bill;

import com.example.CarRentalSystemLLD.reservation.Reservation;
import com.example.CarRentalSystemLLD.user.User;

public class Bill {
    String BillId;
    User user;
    Reservation reservation;
    int totalAmount;
    Boolean isPaid;

    public Bill(String BillId, User user, Reservation reservation) {
        this.BillId = BillId;
        this.user = user;
        this.reservation = reservation;
        this.isPaid = false;
    }

    public String getBillId() {
        return BillId;
    }

    public Boolean getIsPaid() {
        return isPaid;
    }

    public void billIsPaid() {
        this.isPaid = true;
    }

//    public double generateBill(Reservation reservation) {
//       double hourlyPrice=reservation.getVehicle().getHourlyPrice();
//       int hours=reservation.getEndTime().compareTo(reservation.getStartTime());
//
//       return hourlyPrice*hours;
//    }
}

