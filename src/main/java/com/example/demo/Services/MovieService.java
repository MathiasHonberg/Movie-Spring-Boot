package com.example.demo.Services;

import com.example.demo.Models.Movie;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MovieService {

    List<Movie> findAll();
    void add(Movie movie);
    Movie search(String s);
}
