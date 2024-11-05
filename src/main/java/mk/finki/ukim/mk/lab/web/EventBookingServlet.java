package mk.finki.ukim.mk.lab.web;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import mk.finki.ukim.mk.lab.model.EventBooking;
import mk.finki.ukim.mk.lab.service.EventBookingService;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.spring6.SpringTemplateEngine;
import org.thymeleaf.web.IWebExchange;
import org.thymeleaf.web.servlet.JakartaServletWebApplication;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "EventBookingServlet", urlPatterns = "/eventBooking")
public class EventBookingServlet extends HttpServlet {

    private final SpringTemplateEngine springTemplateEngine;
    private final EventBookingService eventBookingService;

    public EventBookingServlet(SpringTemplateEngine springTemplateEngine, EventBookingService eventBookingService) {
        this.springTemplateEngine = springTemplateEngine;
        this.eventBookingService = eventBookingService;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        IWebExchange webExchange = JakartaServletWebApplication.buildApplication(getServletContext())
                .buildExchange(req, resp);

        WebContext context = new WebContext(webExchange);
        HttpSession session = req.getSession();
        String eventName = (String) session.getAttribute("eventName");
        String attendeeName = (String) session.getAttribute("name");
        String attendeeAddress = (String) session.getAttribute("attendeeAddress");
        String numberOfTickets = (String) session.getAttribute("numberOfTickets");

        Long numTickets =Long.parseLong(numberOfTickets);

        String ipAddr = req.getRemoteAddr();
        System.out.println(attendeeName);
        context.setVariable("attendeeName", attendeeName);
        context.setVariable("eventName", eventName);
        context.setVariable("numTickets", numTickets);
        context.setVariable("ipAddress", ipAddr);
        eventBookingService.placeBooking(eventName, attendeeName, attendeeAddress, numTickets);
        List<EventBooking> bookingList = eventBookingService.filterByUser(attendeeName);
        context.setVariable("bookingList",bookingList);
        springTemplateEngine.process("bookingConfirmation.html", context,resp.getWriter());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}

