package com.example.demo.Models.Repository;

import com.example.demo.Models.Movie;

import java.util.List;

public interface MovieRepo {

    List<Movie> findAll();
    void add(Movie movie);
    Movie search(String s);
}
