package com.example.demo.Controllers;

import com.example.demo.Models.Actor;
import com.example.demo.Services.ActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.logging.Logger;

@Controller
public class ActorController {

    Logger log = Logger.getLogger(ActorController.class.getName());

    @Autowired
    ActorService actorService;

    @GetMapping("/actor_index")
    public String actor_index(Model model) {
        List<Actor> actors = actorService.getActors();

        model.addAttribute("actors", actors);
        return "/actor_index";
    }

    @GetMapping("/read_actor")
    public String detailsActor(@RequestParam("memberId") int actorid, Model model)
    {
        return "read_actor";
    }


//CREATE METHODS

    @GetMapping("/create_actor")
    public String createActor(Model model)
    {
        log.info("create actor action called...");
        model.addAttribute("actor", new Actor());
        return "create_actor";
    }

    @PostMapping("/create_actor")
    public String createActor(@ModelAttribute Actor actor, Model model)
    {
        actorService.addActor(actor);

            model.addAttribute("actor", actorService.getActors());

            return "redirect:/actor_index";
    }


//Edit Methods

    @GetMapping("/edit_actor")
    public String editActor(@RequestParam("actorid") int id, Model model){

        return "/actor_index";
    }

    @PostMapping("/edit_actor")
    public String editActor(@ModelAttribute  Actor actor){

        return "redirect:/actor_edit";
    }

//Delete Methods

    @GetMapping("/delete_actor")
    public String deleteActor(@RequestParam("actorid") int actorid, Model model){

        return "delete_actor";
    }

    @PostMapping("/delete_actor")
    public String deleteActor(@RequestParam("actorid") int actorid){

        return "redirect:/actor_index";
    }
}
