package com.example.demo.Controllers;

import com.example.demo.Models.Movie;
import com.example.demo.Models.Repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

@Controller
public class MovieController {


    @Autowired
    private MovieRepository movieRepository;
    Logger log = Logger.getLogger(MovieController.class.getName());


    @RequestMapping(value="/", method = RequestMethod.GET)
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
    public String create(@ModelAttribute MovieRepository movies, Model model){

        log.info("create post action called...");

        //userService.save(Movie);
        //model.addAttribute("movies", userService.fetchAll());
        return "redirect:/";
    }
}
