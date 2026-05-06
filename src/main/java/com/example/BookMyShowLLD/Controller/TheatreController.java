package com.example.BookMyShowLLD.Controller;

import com.example.BookMyShowLLD.Entity.Theatre;
import com.example.BookMyShowLLD.Service.TheatreService;

import java.util.List;

public class TheatreController {
    TheatreService theatreService;

    public TheatreController(){
        theatreService = new TheatreService();
    }


    public List<Theatre> getListOfTheatre(String city){
        return theatreService.getListOfTheatre(city);
    }

    public void addTheatre(Theatre theatre, String city){
        theatreService.addTheatre(theatre, city);
    }
}
