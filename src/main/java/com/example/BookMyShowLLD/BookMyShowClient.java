package com.example.BookMyShowLLD;

import com.example.BookMyShowLLD.Controller.BookingController;
import com.example.BookMyShowLLD.Controller.TheatreController;
import com.example.BookMyShowLLD.Entity.*;
import com.example.BookMyShowLLD.Entity.Seat.Seat;
import com.example.BookMyShowLLD.Entity.Seat.SeatType;
import com.example.BookMyShowLLD.Entity.Show.SeatStatus;
import com.example.BookMyShowLLD.Entity.Show.Show;
import com.example.BookMyShowLLD.Service.TheatreService;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class BookMyShowClient {
    public static void main(String[] args){
        //create movie
        Movie movie1 = new Movie("11", "dhrundhar1", 60);
        Movie movie2 = new Movie("22", "dhrundhar2", 70);

        //Create User
        User user1= new User("user1", "akash");
        User user2= new User("user2", "aman");

        //Crate Seat
        Seat seat1 = new Seat("1", SeatType.SILVER);
        Seat seat2 = new Seat("2", SeatType.GOLD);
        Seat seat3 = new Seat("3", SeatType.PLATINUM);

        //create Screens
        Screen screen1= new Screen("screen1");
        screen1.addSeat(seat1);
        screen1.addSeat(seat2);

        Screen screen2= new Screen("screen2");
        screen2.addSeat(seat3);

        Screen screen3= new Screen("screen3");

        //Create Show
        Show show1= new Show("show1",  LocalDateTime.of(2007, 12, 3, 15, 30), LocalDateTime.of(2007, 12, 3, 17, 30), movie1, screen1);
        show1.updateSeatStatus(seat1.getSeatId(), SeatStatus.AVAILABLE);
        show1.updateSeatStatus(seat2.getSeatId(), SeatStatus.AVAILABLE);

        Show show2= new Show("show2",  LocalDateTime.of(2007, 12, 3, 10, 30), LocalDateTime.of(2007, 12, 3, 12, 30), movie1, screen2);
        show2.updateSeatStatus(seat3.getSeatId(), SeatStatus.BOOKED);
        show2.updateSeatStatus(seat1.getSeatId(), SeatStatus.AVAILABLE);

        Show show3= new Show("show3",  LocalDateTime.of(2007, 12, 3, 5, 30), LocalDateTime.of(2007, 12, 3, 7, 30), movie2, screen1);

        //create Theatre
        Theatre theatre1= new Theatre("theatre1", "Nawada");
        theatre1.addScreen(screen1);

        Theatre theatre2= new Theatre("theatre2", "Nawada");
        theatre2.addScreen(screen2);

        TheatreController theatreController= new TheatreController();
        List<Theatre>nawadaTheatreList= theatreController.getListOfTheatre("Nawada");
        System.out.println("nawada Theatre List "+ nawadaTheatreList);

        theatreController.addTheatre(theatre1, "Nawada");
        theatreController.addTheatre(theatre2, "Nawada");
        nawadaTheatreList= theatreController.getListOfTheatre("Nawada");
        System.out.println("nawada Theatre List "+ nawadaTheatreList.getFirst().getTheatreId());

        //create Bookings
        BookingController  bookingController= new BookingController();
        List<Seat> seats = new ArrayList<>();
        seats.add(seat1);
        seats.add(seat2);
        Bookings booking1= bookingController.createBooking(user1, seats, show1);

        List<Seat> seats2 = new ArrayList<>();
        seats2.add(seat3);
        seats2.add(seat1);
        Bookings booking2= bookingController.createBooking(user2, seats2, show2);
    }
}
