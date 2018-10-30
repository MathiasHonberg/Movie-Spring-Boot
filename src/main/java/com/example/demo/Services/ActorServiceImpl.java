package com.example.demo.Services;

import com.example.demo.Models.Actor;
import com.example.demo.Models.Repository.ActorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActorServiceImpl implements ActorService{

    @Autowired
    ActorRepo actorRepo;

    @Override
    public List<Actor> getActors() {
        return actorRepo.getActors();
    }

    @Override
    public void addActor(Actor actor) {

    }

    @Override
    public Actor search(String s) {
        return null;
    }
}
