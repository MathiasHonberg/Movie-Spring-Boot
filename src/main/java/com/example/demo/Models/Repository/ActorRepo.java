package com.example.demo.Models.Repository;

import com.example.demo.Models.Actor;

import java.util.List;

public interface ActorRepo {

    List<Actor> findAll();
    void add(Actor actor);
    Actor search(String s);
}
