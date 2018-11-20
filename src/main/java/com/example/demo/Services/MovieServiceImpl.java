package com.example.demo.Services;

import com.example.demo.Models.Movie;
import com.example.demo.Models.Repository.MovieRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieServiceImpl implements MovieService {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

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
        try {
            if (!movie.getTitle().equals("") && movie.getProductionYear() >= 999 && !movie.getDuration().equals("")) {
                return movieRepo.addMovie(movie);
            }
        } catch (Exception e) {
            log.info(String.valueOf(e));
        }
        return null;
    }


    @Override
    public void deleteMovie(int movieId) {
        movieRepo.deleteMovie(movieId);
    }

    @Override
    public Movie updateMovie(int movieId, Movie movie) {
        return movieRepo.updateMovie(movieId, movie);
    }

    @Override
    public List<Movie> search(String searching) {
        if (!searching.equals("") && searching instanceof String) {
            return movieRepo.search(searching);
        }
        return null;
    }

    @Override
    public Movie addActorToMovie() {
        return movieRepo.addActorToMovie();
    }
}
