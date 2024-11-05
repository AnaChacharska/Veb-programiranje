package mk.finki.ukim.mk.lab.bootstrap;

import jakarta.annotation.PostConstruct;
import mk.finki.ukim.mk.lab.model.Event;
import mk.finki.ukim.mk.lab.model.EventBooking;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DataHolder {
    public static List<Event> events;
    public static List<EventBooking> bookings;

    @PostConstruct
    public void init() {
        events = new ArrayList<>();
        events.add(new Event("Concert", "Music concert in the town", 4.5));
        events.add(new Event("Theater", "Play in the city theater.", 3.8));
        events.add(new Event("Exhibition", "Exhibition of contemporary art.", 4.2));
        events.add(new Event("Sports Event", "Football match between local teams.", 4.0));
        events.add(new Event("Festival", "Cultural festival with various activities.", 4.7));
        events.add(new Event("Workshop", "Creative writing workshop.", 3.5));
        events.add(new Event("Seminar", "Seminar on new technologies.", 4.1));
        events.add(new Event("Cinema", "Screening of new films.", 4.3));
        events.add(new Event("Conference", "International business conference.", 4.6));
        events.add(new Event("Rehearsal", "Rehearsal of a new theater play.", 3.9));

        bookings = new ArrayList<>();
    }
}
