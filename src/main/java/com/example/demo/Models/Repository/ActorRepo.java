package com.example.demo.Models.Repository;

import com.example.demo.Models.Actor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ActorRepo {

    List<Actor> findAll();
    void add(Actor actor);
    Actor search(String s);
}
