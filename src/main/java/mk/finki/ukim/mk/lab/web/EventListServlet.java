package mk.finki.ukim.mk.lab.web;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import mk.finki.ukim.mk.lab.model.Event;
import mk.finki.ukim.mk.lab.service.EventService;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.spring6.SpringTemplateEngine;
import org.thymeleaf.web.IWebExchange;
import org.thymeleaf.web.servlet.JakartaServletWebApplication;

import java.io.IOException;
import java.util.List;

@WebServlet(name="eventListServlet", urlPatterns = "")
public class EventListServlet extends HttpServlet {
    private final SpringTemplateEngine templateEngine;
    private final EventService service;

    public EventListServlet(SpringTemplateEngine templateEngine, EventService service) {
        this.templateEngine = templateEngine;
        this.service = service;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        IWebExchange webExchange = JakartaServletWebApplication
                .buildApplication(getServletContext())
                .buildExchange(req, resp);
        WebContext webContext = new WebContext(webExchange);

        List<Event> events = service.listAll();
        String text = req.getParameter("text");
        String rating = req.getParameter("rating");

        if(text!=null && !text.isEmpty()) {
            events = service.searchEvents(text);
        }
        if(rating!=null && !rating.isEmpty()) {
            events = service.searchByRating(Double.parseDouble(rating));
        }
        session.getAttribute("name");
        webContext.setVariable("events", events);
        templateEngine.process("listEvents.html", webContext, resp.getWriter());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String eventName = (String) req.getParameter("eventName");
        String numberOfTickets= (String) req.getParameter("numberOfTickets");

        session.setAttribute("eventName", eventName);
        session.setAttribute("numberOfTickets",numberOfTickets);


        resp.sendRedirect("/eventBooking");
    }
}