package com.example.demo.Controllers;

import com.example.demo.Models.Movie;
import com.example.demo.Models.Repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

@Controller
public class MovieController {

    private final Logger log = Logger.getLogger(MovieController.class.getName());

    @Autowired
    private MovieRepository movieRepository;

    @GetMapping("/")
    public String index(Model model){
        List<Movie> movies = movieRepository.findAll();

        model.addAttribute("movies", movies);
        return "index";
    }

    @GetMapping("/create")
    public String create(Model model){

        log.info("create action called...");
        model.addAttribute("movie", new Movie());


        return "create";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute Movie movie, Model model){


        movieRepository.addMovie(movie);
        model.addAttribute("movie", movieRepository.findAll());


        return "redirect:/";

    }

    @GetMapping("/search")
    public String search(Model model, @ModelAttribute("mov") Movie mov, BindingResult result){

        Movie m = this.movieRepository.searchMovie(mov.getTitle());
        model.addAttribute("movie", m);

        return "search";
    }
}
