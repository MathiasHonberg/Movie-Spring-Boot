package com.example.demo.Models.Repository;

import com.example.demo.Models.Movie;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class MovieRepository {

    private ArrayList<Movie> movies = new ArrayList<Movie>();

    public MovieRepository(){

        movies.add(new Movie("Terminator", 1985, "1:45", "Action"));
        movies.add(new Movie("Terminator 2", 1990, "1:50", "Action"));
        movies.add(new Movie("Terminator 3", 1995, "1:55", "Action"));
        movies.add(new Movie("Titanic", 1997, "2:45", "Drama"));
        movies.add(new Movie("Frozen", 2013, "1:59", "Romance"));

    }

    public List<Movie> findAll(){

        return movies;
    }

    public void addMovie(){


    }

    public void searchMovie(){


    }
}

