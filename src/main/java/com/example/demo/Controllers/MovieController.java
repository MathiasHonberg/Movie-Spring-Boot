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
        List<Movie> movies = movieService.findAll();

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


        movieService.add(movie);
        model.addAttribute("movie", movieService.findAll());


        return "redirect:/";

    }

    @GetMapping("/search")
    public String search(Model model, @ModelAttribute("mov") Movie mov, BindingResult result){

        Movie m = this.movieService.search(mov.getTitle());
        model.addAttribute("movie", mov);

        return "search";
    }

    @GetMapping("/edit")
    public String edit(@RequestParam("actorid") int id, Model model)
    {
        return "edit";
    }

    @PostMapping("/edit")
    public String edit(@ModelAttribute  Movie movie)
    {
        return "redirect:/index";
    }
    /*
    delete methods
     */

    @GetMapping("/delete")
    public String delete(@RequestParam("movieid") int movieid, Model model)
    {
        return "delete";
    }

    @PostMapping("/")
    public String deleteMovie(@RequestParam("movieid") int movieid)
    {
        return "redirect:/index";
    }

}
