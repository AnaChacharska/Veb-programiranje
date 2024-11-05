package mk.finki.ukim.mk.lab.service.impl;

import mk.finki.ukim.mk.lab.model.EventBooking;
import mk.finki.ukim.mk.lab.repository.EventBookingRepository;
import mk.finki.ukim.mk.lab.repository.EventRepository;
import mk.finki.ukim.mk.lab.service.EventBookingService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventBookingServiceImpl implements EventBookingService {
    public EventBookingRepository eventBookingRepository;

    public EventBookingServiceImpl(EventBookingRepository eventBookingRepository) {
        this.eventBookingRepository = eventBookingRepository;
    }

    @Override
    public EventBooking placeBooking(String eventName, String attendeeName, String attendeeAddress, Long numberOfTickets) {
        if(eventName.isEmpty() || attendeeName.isBlank()){
            throw new IllegalArgumentException("Argument is missing");
        }
        return eventBookingRepository.create(eventName, attendeeName, attendeeAddress, numberOfTickets);
    }

    @Override
    public List<EventBooking> listAll() {
        return eventBookingRepository.listAll();
    }

    @Override
    public List<EventBooking> filterByUser(String attendeeName) {
        return eventBookingRepository.filterByUser(attendeeName);
    }
}
