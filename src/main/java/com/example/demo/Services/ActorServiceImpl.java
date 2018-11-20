package com.example.demo.Services;

import com.example.demo.Models.Actor;
import com.example.demo.Models.Repository.ActorRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActorServiceImpl implements ActorService {

    private final Logger log = LoggerFactory.getLogger(this.getClass());


    @Autowired
    ActorRepo actorRepo;

    @Override
    public List<Actor> getActors() {
        return actorRepo.getActors();
    }

    @Override
    public Actor addActor(Actor actor) {
        try {

            if (!actor.getFirstName().equals("") && !actor.getLastName().equals(""))
                return actorRepo.addActor(actor);

        } catch (Exception a) {
            log.info(String.valueOf(a));
        }
        return null;
    }

    public Actor findActor(int id) {

        return actorRepo.findActor(id);
    }

    public Actor updateActor(int id, Actor actor) {

        return actorRepo.updateActor(id, actor);
    }

    public Boolean deleteActor(int id) {

        return actorRepo.deleteActor(id);
    }

    @Override
    public Actor search(String s) {
        return null;
    }
}
