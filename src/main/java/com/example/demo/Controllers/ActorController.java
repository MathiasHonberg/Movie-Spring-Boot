package com.example.demo.Controllers;

import com.example.demo.Models.Actor;
import com.example.demo.Models.Movie;
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
    public String overviewActors(Model model)
    {
        return "actor_index";
    }

    @GetMapping("/read_actor")
    public String detailsActor(@RequestParam("memberId") int actorid, Model model)
    {
        return "read_actor";
    }

    /*
    Create Methods
     */
    @GetMapping("/create_actor")
    public String createActor(Model model)
    {

        return "create_actor";
    }

    @PostMapping("/create_actor")
    public String createActor(@ModelAttribute Actor actor)
    {
        return "redirect:/actor_index";
    }

    /*
    Edit Methods
     */
    @GetMapping("/edit_actor")
    public String editActor(@RequestParam("actorid") int id, Model model)
    {
        return "edit_actor";
    }

    @PostMapping("/edit_actor")
    public String editActor(@ModelAttribute  Actor actor)
    {
        return "redirect:/actor_edit";
    }


    /*
    Delete Methods
     */
    @GetMapping("/delete_actor")
    public String deleteActor(@RequestParam("actorid") int actorid, Model model)
    {
        return "delete_actor";
    }

    @PostMapping("/delete_actor")
    public String deleteActor(@RequestParam("actorid") int actorid)
    {
        return "redirect:/actor_index";
    }
}
