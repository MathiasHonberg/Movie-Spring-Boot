package com.example.demo.Models.Repository;

import com.example.demo.Models.Actor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ActorRepoImpl implements ActorRepo {

    @Autowired
    JdbcTemplate jdbc;

    public List<Actor> getActors() {
        String sql = "SELECT * FROM actor";
        RowMapper<Actor> rowMapper = new BeanPropertyRowMapper<>(Actor.class);
        return this.jdbc.query(sql, rowMapper);
    }
    /*

     */

    public Actor findActor(int actorId) {
        String sql = "SELECT * FROM actor WHERE id = ?";
        RowMapper<Actor> rowMapper = new BeanPropertyRowMapper<>(Actor.class);
        Actor actor = jdbc.queryForObject(sql, rowMapper, actorId);
        return actor;
    }
    /*

     */
    public Actor addActor(Actor actor) {
        String sql = "INSERT INTO movie (id, name, email) values (?, ?, ?)";
        jdbc.update(sql, actor.getIdactor(), actor.getFirstName(), actor.getLastName(), actor.getDateOfBirth());

        sql = "SELECT id FROM user WHERE name = ? and email=?";
        int idactor = jdbc.queryForObject(sql, Integer.class, actor.getFirstName(), actor.getLastName(), actor.getDateOfBirth());

        actor.setIdactor( idactor);
        return actor;
    }
    /*

     */
    public Boolean deleteActor(int actorId) {
        String sql = "DELETE FROM movie WHERE id=?";
        return jdbc.update(sql, actorId) >= 0;

    }
    /*

     */
    public Actor updateActor(int actorId, Actor actor) {
        String sql = "UPDATE movie SET firstname=?, lastname=?, dateofbirth=? WHERE id=?";
        jdbc.update(sql, actor.getFirstName(), actor.getLastName(), actor.getDateOfBirth(), actor.getIdactor());
        return findActor(actorId);
    }
    /*

     */
    public boolean actorDetails(String firstName, int lastName, int dateofbirth) {
        String sql = "SELECT count(*) FROM actor WHERE firstname=? and lastname=? and dateofbirth=? ";
        int count = jdbc.queryForObject(sql, Integer.class, firstName, lastName, dateofbirth);
        if (count == 0) {
            return false;
        } else {
            return true;
        }
    }
}

