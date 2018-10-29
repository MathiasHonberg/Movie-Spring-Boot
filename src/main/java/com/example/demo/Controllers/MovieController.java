package com.example.demo.Controllers;

import com.example.demo.Models.Movie;
import com.example.demo.Services.MovieService;
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
    MovieService movieService;


    @GetMapping("/")
    public String index(Model model){
        List<Movie> movies = movieService.getMovies();

        model.addAttribute("movies", movies);
        return "index";
    }

//CREATE
    @GetMapping("/create")
    public String create(Model model){

        log.info("create action called...");
        model.addAttribute("movie", new Movie());


        return "create";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute Movie movie, Model model){


        movieService.addMovie(movie);
        model.addAttribute("movie", movieService.getMovies());


        return "redirect:/";
    }

//SEARCH
    @GetMapping("/search")
    public String search(Model model, @ModelAttribute("mov") Movie mov, @RequestParam("movieid") int id){

        Movie m = this.movieService.findMovie(id);
        model.addAttribute("movie", mov);

        return "search";
    }

//EDIT
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {
        log.info("edit action called...");

        model.addAttribute("movie", movieService.findMovie(id));
        return "edit";
    }

    @PutMapping("/edit")
    public String edit(@ModelAttribute Movie movie, Model model) {
        log.info("edit post action called...");

        movieService.updateMovie(movie.getIdmovie(), movie);

        model.addAttribute("movies", movieService.getMovies());
        return "redirect:/";
    }

//DELETE
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") int id, Model model) {
    log.info("delete  action called...");

    model.addAttribute("movie", movieService.findMovie(id));

    return "delete";
}

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Integer id, Model model) {
        log.info("delete post action called...");

        movieService.deleteMovie(id);


        model.addAttribute("movies", movieService.getMovies());
        return "redirect:/";
    }

//DETAILS
    @GetMapping("/read/{id}")
    public String details(@PathVariable("id") int id, Model model) {
    log.info("details action called...");


    model.addAttribute("movie", movieService.findMovie(id));
    return "read";
    }

}
