package com.example.demo.Models.Repository;

import com.example.demo.Models.Movie;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepo {

    List<Movie> getMovies();

    Movie findMovie(int id);

    Movie addMovie(Movie movie);

    void deleteMovie(int movieId);

    Movie updateMovie(int movieId, Movie movie);

    List<Movie> search(String searching);

    Movie addActorToMovie();
}
