package com.example.BookMyShowLLD.Entity;

import java.util.ArrayList;
import java.util.List;

public class Theatre {
    String theatreId;
    String city;
    List<Screen>screenList;

    public Theatre(String theatreId, String city) {
        this.theatreId = theatreId;
        this.city = city;
        screenList=new ArrayList<Screen>();
    }

    public String getTheatreId() {
        return theatreId;
    }

    public void setScreenList(List<Screen> screenList) {
        this.screenList = screenList;
    }

    public List<Screen> getScreenList() {
        return screenList;
    }

    public void addScreen(Screen screen){
        screenList.add(screen);
    }

    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }

    public void removeScreen(Screen screen){
        screenList.remove(screen);
    }
}
