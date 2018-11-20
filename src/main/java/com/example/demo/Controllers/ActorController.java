package com.example.demo.Controllers;

import com.example.demo.Models.Actor;
import com.example.demo.Services.ActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

//READ METHODS

    @GetMapping("/read_actor/{id}")
    public String detailsActor(@PathVariable Integer id, Model model) {

        model.addAttribute("actor", actorService.findActor(id));
        return "read_actor";
    }


//CREATE METHODS

    @GetMapping("/create_actor")
    public String createActor(Model model) {
        log.info("create actor action called...");

        model.addAttribute("actor", new Actor());
        return "create_actor";
    }

    @PostMapping("/create_actor")
    public String createActor(@ModelAttribute Actor actor, Model model) {
        actorService.addActor(actor);

        model.addAttribute("actor", actorService.getActors());

        return "redirect:/actor_index";
    }

    //SEARCH
    @GetMapping("/search_actor")
    public String search() {
        log.info("Search action called...");
        return "search_actor";
    }

    @PostMapping("/search_actor")
    public String search(@RequestParam(defaultValue = "") String searching, Model model) {
        log.info("Simon Smith is delicious");

        List<Actor> a = actorService.search(searching);
        model.addAttribute("sactor", a);

        return "/search_actor";
    }

//Edit Methods

    @GetMapping("/edit_actor/{id}")
    public String editActor(@PathVariable Integer id, Model model) {
        log.info("edit actor action called");

        model.addAttribute("actor", actorService.findActor(id));
        return "edit_actor";
    }

    @PutMapping("/edit_actor")
    public String editActor(@ModelAttribute Actor actor, Model model) {
        log.info("edit actor Post action called");

        actorService.updateActor(actor.getIdactor(), actor);

        model.addAttribute("movies", actorService.getActors());

        return "redirect:/actor_index";
    }

//Delete Methods

    @GetMapping("/delete_actor/{id}")
    public String deleteActor(@PathVariable Integer id, Model model) {

        model.addAttribute("actor", actorService.findActor(id));
        return "delete_actor";
    }

    @PostMapping("/delete_actor")
    public String deleteActor(@PathVariable Integer id) {

        actorService.deleteActor(id);

        return "redirect:/actor_index";
    }
}
