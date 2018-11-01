package com.example.demo.Models.Repository;

import com.example.demo.Models.Actor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ActorRepo {

    List<Actor> getActors();
    Actor findActor(int id);
    Actor addActor(Actor actor);
    Actor updateActor(int id, Actor actor);
    Boolean deleteActor(int id);
    boolean actorDetails(String firstName, int lastName, int dateofbirth);

}
