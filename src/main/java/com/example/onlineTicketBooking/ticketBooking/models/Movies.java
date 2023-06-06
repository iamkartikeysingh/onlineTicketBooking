package com.example.onlineTicketBooking.ticketBooking.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "onlineTicketBooking")
public class Movies {

    @Id
    private String id;

    private String movie;

    private int time;

    private int ticketPrice;

    public String getMovie() {
        return movie;
    }

    public void setMovie(String movie) {
        this.movie = movie;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(int ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    @Override
    public String toString() {
        return "Movies{" +
                "id='" + id + '\'' +
                ", movie='" + movie + '\'' +
                ", time=" + time +
                ", ticketPrice=" + ticketPrice +
                '}';
    }
}
