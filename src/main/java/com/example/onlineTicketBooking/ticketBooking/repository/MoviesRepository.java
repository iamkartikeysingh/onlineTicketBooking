package com.example.onlineTicketBooking.ticketBooking.repository;

import com.example.onlineTicketBooking.ticketBooking.models.Movies;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MoviesRepository extends MongoRepository<Movies, String> {
}
