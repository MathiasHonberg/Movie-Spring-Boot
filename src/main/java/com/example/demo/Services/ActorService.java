package com.example.demo.Services;

import com.example.demo.Models.Actor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ActorService {
    List<Actor> getActors();
    void addActor(Actor actor);
    Actor search(String s);

}
