package com.example.demo.Models.Repository;

import com.example.demo.Models.Actor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ActorRepoImpl implements ActorRepo {

    private ArrayList<Actor> actors = new ArrayList<Actor>();

    public ActorRepoImpl() {

        actors.add(new Actor("Mathias", "Hønberg", 24081994));
        actors.add(new Actor("Tobias", "Kurland", 22081995));
    }

    public List<Actor> findAll() {

        return actors;
    }

    public void add(Actor actor) {

        actors.add(actor);

    }

    public Actor search(String title) {

        for (int i = 0; i < actors.size(); i++) {
            if (actors.get(i).getFirstName().equals(title)) {

                return actors.get(i);
            }

        }
        return null;

    }
}

