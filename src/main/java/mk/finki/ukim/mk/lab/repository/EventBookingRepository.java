package mk.finki.ukim.mk.lab.repository;

import mk.finki.ukim.mk.lab.bootstrap.DataHolder;
import mk.finki.ukim.mk.lab.model.EventBooking;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class EventBookingRepository {
    public EventBooking create(String name, String attendee, String address, Long tickets){
        DataHolder.bookings
                .removeIf(eventBooking -> {
                    return eventBooking.getEventName().equals(name)
                            && eventBooking.getAttendeeName().equals(attendee)
                            && eventBooking.getAttendeeAddress().equals(address)
                            && eventBooking.getNumberOfTickets().equals(tickets);
                });
        EventBooking eventBooking = new EventBooking(name, attendee, address, tickets);
        DataHolder.bookings.add(eventBooking);
        return eventBooking;
    }
    public void delete(String name){
        if(name==null){
            return;
        }
        DataHolder.bookings.removeIf(b->b.getEventName().equals(name));
    }
    public List<EventBooking> listAll(){

        return DataHolder.bookings;
    }

    public List<EventBooking> filterByUser(String attendeeName) {
        return DataHolder.bookings.stream().filter(r->r.getAttendeeName().equals(attendeeName)).toList();
    }
}
