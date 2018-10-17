package com.example.demo.Services;

import com.example.demo.Models.Actor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActorServiceImpl implements ActorService{

    @Autowired
    ActorService actorService;

    @Override
    public List<Actor> findAll() {
        return null;
    }

    @Override
    public void add(Actor actor) {

    }

    @Override
    public Actor search(String s) {
        return null;
    }
}
