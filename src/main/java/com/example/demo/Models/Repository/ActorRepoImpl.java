package com.example.demo.Models.Repository;

import com.example.demo.Models.Actor;
import com.example.demo.Models.Genre;
import com.example.demo.Models.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ActorRepoImpl implements ActorRepo {

    @Autowired
    JdbcTemplate jdbc;

    public List<Actor> getActors() {
        ArrayList<Actor> a = new ArrayList<>();
        String sql = "SELECT * FROM actor";


        // Fra sql til list.
        // Manuelt i stedet.
        return this.jdbc.query(sql, new ResultSetExtractor<List<Actor>>() {
            @Override
            public ArrayList<Actor> extractData(ResultSet rs) throws SQLException, DataAccessException {

                while (rs.next()) {
                    int id = rs.getInt("idactor");
                    String firstName = rs.getString("firstName");
                    String lastName = rs.getString("lastName");
                    int dob = rs.getInt("dateOfBirth");


                    Actor actor = new Actor(id, firstName, lastName, dob);

                    a.add(actor);
                }
                return a;
            }
        });
    }
    /*

     */

    public Actor findActor(int id) {
        String sql = "SELECT * FROM actor WHERE idactor = ?";

        RowMapper<Actor> rowMapper = new BeanPropertyRowMapper<>(Actor.class);
        Actor actor = jdbc.queryForObject(sql, rowMapper, id);
        return actor;
    }

    public Actor addActor(Actor actor) {

        String sql = "INSERT INTO actor values (default, ?, ?, ?)";

        jdbc.update(sql, actor.getFirstName(), actor.getLastName(), actor.getDateOfBirth());

        return actor;
    }

    /*


    public Actor addActor(Actor actor) {
        String sql = "INSERT INTO actor (idactor, firstName, lastName, dateOfBirth) values (default, ?, ?, ?)";
        jdbc.update(sql, actor.getIdactor(), actor.getFirstName(), actor.getLastName(), actor.getDateOfBirth());

        sql = "SELECT id FROM user WHERE firstName = ? and lastName=?";
        int idactor = jdbc.queryForObject(sql, Integer.class, actor.getFirstName(), actor.getLastName(), actor.getDateOfBirth());

        actor.setIdactor(idactor);
        return actor;
    }*/
    /*

     */
    public Boolean deleteActor(int actorId) {
        String sql = "DELETE FROM actor WHERE idactor=?";
        return jdbc.update(sql, actorId) >= 0;

    }

    /*

     */
    public Actor updateActor(int actorId, Actor actor) {
        String sql = "UPDATE actor SET firstname=?, lastname=?, dateofbirth=? WHERE idactor=? ";
        jdbc.update(sql, actor.getFirstName(), actor.getLastName(), actor.getDateOfBirth());
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

