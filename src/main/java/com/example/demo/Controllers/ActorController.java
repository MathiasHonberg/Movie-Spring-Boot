package com.example.demo.Controllers;

import com.example.demo.Models.Actor;
import com.example.demo.Models.Movie;
import com.example.demo.Models.Repository.ActorRepoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.logging.Logger;

@Controller
public class ActorController {

    Logger log = Logger.getLogger(ActorController.class.getName());

    @Autowired
    ActorRepoImpl actorRepo;

    @GetMapping("/actor")
    public String actors(Model model){

        List<Actor> actors = actorRepo.findAll();
        Movie hej = new Movie("Hej", 2, "Tobias", "Kurland");

        model.addAttribute("movies", hej);

        return "actor";

    }
    @GetMapping("/createactor")
    public String createactor(Model model){

        log.info("create actor action called...");
        model.addAttribute("actor", new Actor());


        return "createactor";
    }

    @PostMapping("/createactor")
    public String createactor(@ModelAttribute Actor actor, Model model){


        actorRepo.add(actor);
        model.addAttribute("actor", actorRepo.findAll());


        return "redirect:/actorlist";

    }
}
