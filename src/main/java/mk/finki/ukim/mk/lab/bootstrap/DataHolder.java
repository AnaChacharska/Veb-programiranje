package mk.finki.ukim.mk.lab.bootstrap;

import jakarta.annotation.PostConstruct;
import mk.finki.ukim.mk.lab.model.Event;
import mk.finki.ukim.mk.lab.model.EventBooking;
import mk.finki.ukim.mk.lab.model.Location;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DataHolder {
    public static List<Event> events = null;
    public static List<EventBooking> eventBookings = null;
    public static List<Location> locations = null;

    @PostConstruct
    public void init() {
        locations = new ArrayList<>();
        locations.add(new Location("Central Park", "59th to 110th Street, New York, NY", "50000", "A large public park in New York City"));
        locations.add(new Location("Madison Square Garden", "4 Pennsylvania Plaza, New York, NY", "20000", "A multi-purpose indoor arena in New York City"));
        locations.add(new Location("Staples Center", "1111 S Figueroa St, Los Angeles, CA", "21000", "A multi-purpose arena in Downtown Los Angeles"));
        locations.add(new Location("Golden Gate Park", "501 Stanyan St, San Francisco, CA", "75000", "A large urban park in San Francisco, California"));
        locations.add(new Location("Disneyland Park", "1313 Disneyland Dr, Anaheim, CA", "85000", "A theme park in Anaheim, California"));

        events = new ArrayList<>();
        events.add(new Event("Summer Music Festival", "A weekend-long music festival with multiple stages and artists.", 4.6, locations.get(0)));
        events.add(new Event("NBA Finals", "The championship series of the National Basketball Association.", 4.8, locations.get(1)));
        events.add(new Event("Grammy Awards", "An annual awards ceremony recognizing achievements in the music industry.", 4.9, locations.get(2)));
        events.add(new Event("San Francisco Marathon", "An annual marathon race held in San Francisco, California.", 4.3, locations.get(3)));
        events.add(new Event("Disneyland Halloween Party", "A Halloween-themed event held at Disneyland Park.", 4.7, locations.get(4)));
        events.add(new Event("Food and Wine Festival", "A celebration of culinary arts and fine wines.", 4.4, locations.get(0)));
        events.add(new Event("Concert in the Park", "A live concert featuring popular bands and artists.", 4.2, locations.get(1)));
        events.add(new Event("Tech Conference", "A conference showcasing the latest innovations in technology.", 4.5, locations.get(2)));
        events.add(new Event("Art Exhibition", "An exhibition featuring works from renowned artists.", 4.1, locations.get(3)));
        events.add(new Event("Holiday Parade", "A festive parade celebrating the holiday season.", 4.8, locations.get(4)));

        eventBookings = new ArrayList<>();
        eventBookings.add(new EventBooking("Event1test", "Attendee1", "Address1", 3L));
    }
}
