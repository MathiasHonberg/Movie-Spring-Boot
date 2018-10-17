package com.example.demo.Services;

import com.example.demo.Models.Movie;
import com.example.demo.Models.Repository.MovieRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieServiceImpl implements MovieService{

    @Autowired
    MovieRepo movieRepo;

    @Override
    public List<Movie> findAll() {
        return null;
    }

    @Override
    public void add(Movie movie) {

    }

    @Override
    public Movie search(String s) {
        return null;
    }
}
