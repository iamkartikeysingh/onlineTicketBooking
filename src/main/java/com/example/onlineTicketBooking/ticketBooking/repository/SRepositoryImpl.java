package com.example.onlineTicketBooking.ticketBooking.repository;
import java.util.ArrayList;
import java.util.Arrays;

import com.example.onlineTicketBooking.ticketBooking.models.Movies;
import org.bson.Document;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import java.util.List;

import com.mongodb.client.AggregateIterable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.convert.MongoConverter;
import org.springframework.stereotype.Component;

@Component
public class SRepositoryImpl implements SRepository {

    @Autowired
    MongoClient client;

    @Autowired
    MongoConverter converter;


    @Override
    public List<Movies> findByName(String movie) {
        final List<Movies> movies = new ArrayList<>();
        MongoDatabase database = client.getDatabase("onlineTicketBooking");
        MongoCollection<Document> collection = database.getCollection("onlineTicketBooking");
        AggregateIterable<Document> result = collection.aggregate(Arrays.asList(new Document("$search",
                new Document("index", "index0")
                        .append("text",
                                new Document("query", movie)
                                        .append("path", "movie")))));

        result.forEach(doc -> movies.add(converter.read(Movies.class,doc)));

        return movies;
    }
}
