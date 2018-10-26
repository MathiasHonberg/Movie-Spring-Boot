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
    public List<Movie> getMovies() {

        return movieRepo.getMovies();
    }

    @Override
    public Movie findMovie(int id) {
        return movieRepo.findMovie(id);
    }

    @Override
    public Movie addMovie(Movie movie) {
        return movieRepo.addMovie(movie);
    }

    @Override
    public Boolean deleteMovie(int movieId) {
        return movieRepo.deleteMovie(movieId);
    }

    @Override
    public Movie updateMovie(int movieId, Movie movie) {
        return movieRepo.updateMovie(movieId, movie);
    }

    @Override
    public boolean movieDetails(String title, String duration, String genre, int releaseYear) {
        return movieRepo.movieDetails(title, duration, genre, releaseYear);
    }

    @Override
    public Movie addActorToMovie() {
        return movieRepo.addActorToMovie();
    }
}
