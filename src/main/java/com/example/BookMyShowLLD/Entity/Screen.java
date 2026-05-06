package com.example.BookMyShowLLD.Entity;

import com.example.BookMyShowLLD.Entity.Seat.Seat;
import com.example.BookMyShowLLD.Entity.Show.Show;

import java.util.ArrayList;
import java.util.List;

public class Screen {
    private String screenId;
    List<Seat> seatList;
    //Here instead of storing show List we can add reference of screen in show entity, see below reason in buttom
   // List<Show> showList;

    public Screen(String screenId) {
        this.screenId = screenId;
        seatList = new ArrayList<>();
       // showList = new ArrayList<>();
    }

    public String getScreenId() {
        return screenId;
    }

    public List<Seat> getSeatList() {
        return seatList;
    }

    public void addSeat(Seat seat){
        seatList.add(seat);
    }

    public void removeSeat(Seat seat){
        seatList.remove(seat);
    }
}

/*
🧠 1. Your Two Designs
✅ Design A (Show → Screen reference)
class Screen {
    String screenId;
    List<Seat> seats;
}

class Show {
    String showId;
    Movie movie;
    Screen screen;
    Date startTime;
    Map<String, ShowSeat> seats;
}
✅ Design B (Screen → Shows reference)
class Screen {
    String screenId;
    List<Seat> seats;
    List<Show> shows;
}

class Show {
    String showId;
    Movie movie;
    Date startTime;
    Map<String, ShowSeat> seats;
}
🔍 2. Core Difference (Ownership)
👉 Design A → Show owns Screen reference
Show knows which screen it belongs to
Screen is passive (no knowledge of shows)
👉 Design B → Screen owns Shows
Screen manages all its shows
Show does NOT know which screen it belongs to
⚡ 3. Real-World Mapping

In real systems:

👉 A Show cannot exist without a Screen

So logically:

A show is scheduled on a screen
Screen is more like a container
⚖️ 4. Comparison
🔹 Design A (Recommended)

✔ Loose coupling
✔ Better for querying (DB style)
✔ Easier scaling
✔ Matches real-world DB schema

Example:

SHOW (show_id, screen_id, movie_id)

👉 You can easily:

Fetch screen from show
Store in DB cleanly (foreign key)
🔹 Design B

✔ Easy navigation from screen → shows
❌ Tight coupling
❌ Data duplication risk
❌ Harder to scale

Problem:

What if shows are huge? Screen object becomes heavy
Updating shows requires modifying screen object
🚨 5. Key Problem in Design B

👉 Where is the source of truth?

If:

Show is updated
Screen still holds old reference

➡️ You get inconsistency

🔥 6. Interview Answer (Best Way to Say It)

If interviewer asks:

👉 You should say:

“I prefer Design A where Show holds reference to Screen because in real systems shows are independent entities stored separately (like DB rows). This avoids tight coupling and makes scaling easier.

If needed, we can always fetch all shows for a screen via query instead of storing them inside Screen.”

🧩 7. Best Practice (Hybrid Approach)

In production systems:

class Screen {
    String screenId;
    List<Seat> seats;
    // No shows stored here
}

class Show {
    String showId;
    String screenId; // not full object (better)
    Movie movie;
}

👉 Then use a ShowService:

List<Show> getShowsByScreen(String screenId);
💡 8. When Design B might be OK
Small system (in-memory)
No DB
No scaling concerns
Simple prototype
*/
