package com.example.onlineTicketBooking.ticketBooking.controller;

import com.example.onlineTicketBooking.ticketBooking.models.Movies;
import com.example.onlineTicketBooking.ticketBooking.repository.MoviesRepository;
import com.example.onlineTicketBooking.ticketBooking.repository.SRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


@RestController
public class TicketBookController {

    @Autowired
    MoviesRepository repo;

    @Autowired
    SRepository srepo;

    @ApiIgnore
    @RequestMapping(value = "/")
    public void redirect(HttpServletResponse response) throws IOException {
        response.sendRedirect("/swagger-ui.html");
    }

    @GetMapping("/tickets")
    public List<Movies> getAllTickets() {

        return repo.findAll();
    }

    @PostMapping("/tickets")
    public Movies createTicket(@RequestBody Movies ticket) {

        return repo.save(ticket);
    }

    @GetMapping("/tickets/{movie}")
    public List<Movies> getTicket(@PathVariable String movie){
        return srepo.findByName(movie);
    }

    @DeleteMapping("/tickets/{movie}")
    public String deleteTicket(@PathVariable String movie) {
        List<Movies> ticket = srepo.findByName(movie);
        repo.delete(ticket.get(0));
        return "Ticket deleted successfully";
    }

    @PutMapping("/tickets/{movie}")
    public Movies updateTicket(@PathVariable String movie, @RequestBody Movies ticket) {
        List<Movies> moviesList = srepo.findByName(movie);
        Movies movies = moviesList.get(0);
        movies.setMovie(ticket.getMovie());
        movies.setId(ticket.getId());
        movies.setTime(ticket.getTime());
        movies.setTicketPrice(ticket.getTicketPrice());

        return repo.save(movies);
    }
}
