package com.example.demo.Models.Repository;

import com.example.demo.Models.Movie;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepo {

    List<Movie> findAll();
    void add(Movie movie);
    Movie search(String s);
}
