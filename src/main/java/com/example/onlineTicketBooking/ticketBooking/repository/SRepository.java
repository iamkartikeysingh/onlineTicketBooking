package com.example.onlineTicketBooking.ticketBooking.repository;

import com.example.onlineTicketBooking.ticketBooking.models.Movies;

import java.util.List;


public interface SRepository {
    List<Movies> findByName(String movie);
}
