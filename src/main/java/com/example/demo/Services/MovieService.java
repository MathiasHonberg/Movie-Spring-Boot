package com.example.demo.Services;

import com.example.demo.Models.Movie;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MovieService {

    List<Movie> getMovies();
    Movie findMovie(int id);
    Movie addMovie(Movie movie);
    Boolean deleteMovie(int movieId);
    Movie updateMovie(int movieId, Movie movie);
    boolean movieDetails(String title, String duration, String genre, int releaseYear);
    Movie addActorToMovie();
}
