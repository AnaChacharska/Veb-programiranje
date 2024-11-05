package mk.finki.ukim.mk.lab.service;

import mk.finki.ukim.mk.lab.model.EventBooking;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EventBookingService {
    EventBooking placeBooking(String eventName, String attendeeName, String attendeeAddress, Long numberOfTickets);
    List<EventBooking> listAll();

    List<EventBooking> filterByUser(String attendeeName);
}
