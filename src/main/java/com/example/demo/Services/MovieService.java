package com.example.demo.Services;

import com.example.demo.Models.Movie;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MovieService {

    List<Movie> getMovies();

    Movie findMovie(int id);

    Movie addMovie(Movie movie);

    void deleteMovie(int movieId);

    Movie updateMovie(int movieId, Movie movie);

    List<Movie> search(String searching);

    Movie addActorToMovie();
}
