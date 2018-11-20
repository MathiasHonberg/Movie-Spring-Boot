package com.example.demo.Services;

import com.example.demo.Models.Actor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ActorService {
    List<Actor> getActors();

    Actor addActor(Actor actor);

    Actor findActor(int id);

    Actor updateActor(int id, Actor actor);

    Boolean deleteActor(int id);

    List<Actor> search(String searching);

}
