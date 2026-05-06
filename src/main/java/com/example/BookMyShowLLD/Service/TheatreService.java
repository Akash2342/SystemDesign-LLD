package com.example.BookMyShowLLD.Service;

import com.example.BookMyShowLLD.Entity.Theatre;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TheatreService {
    HashMap<String,List<Theatre>> theatreHashMap = new HashMap<>();

    public List<Theatre> getListOfTheatre(String city) {
        return theatreHashMap.get(city);
    }

    public void addTheatre(Theatre theatre, String city){
        theatreHashMap.computeIfAbsent(city,k-> new ArrayList<Theatre>()).add(theatre);
    }

    public void removeTheatre(Theatre theatre, String city){
        theatreHashMap.get(city).remove(theatre);
    }
}
