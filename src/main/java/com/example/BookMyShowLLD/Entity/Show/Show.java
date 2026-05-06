package com.example.BookMyShowLLD.Entity.Show;

import com.example.BookMyShowLLD.Entity.Movie;
import com.example.BookMyShowLLD.Entity.Screen;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class Show {
    String showId;
    LocalDateTime showStartTime;
    LocalDateTime showEndTime;
    Movie movie;
    //mapping seatId-> seatStatus
    Map<String, SeatStatus> showStatusMap= new HashMap<>();

    //Good Pratice to add screen reference here
    Screen screen;

    public Show(String showId, LocalDateTime showStartTime, LocalDateTime showEndTime , Movie movie, Screen screen) {
        this.showId = showId;
        this.showStartTime = showStartTime;
        this.showEndTime = showEndTime;
        this.screen = screen;
    }

    public void updateSeatStatus(String seatId, SeatStatus seatStatus){
        showStatusMap.put(seatId, seatStatus);
    }

    public SeatStatus getSeatStatus(String seatId){
        return showStatusMap.get(seatId);
    }
}


