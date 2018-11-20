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
public class MovieRepoImpl implements MovieRepo {


    @Autowired
    JdbcTemplate jdbc;

    /*
    this method contacts our database to get all movies
     */
    public List<Movie> getMovies() {


        ArrayList<Movie> m = new ArrayList<>();

        String sql = "SELECT idmovie, title, productionYear, duration, genre.genre," +
                " actor.firstName, actor.lastName FROM movies " +
                "INNER JOIN genre ON movies.idgenre = genre.idgenre " +
                "INNER JOIN actor ON movies.idactor = actor.idactor " +
                "ORDER BY title";


        // Fra sql til list.
        // Manuelt i stedet.
        return this.jdbc.query(sql, new ResultSetExtractor<List<Movie>>() {
            @Override
            public List<Movie> extractData(ResultSet rs) throws SQLException, DataAccessException {

                while (rs.next()) {
                    int id = rs.getInt("idmovie");
                    String title = rs.getString("title");
                    int py = rs.getInt("productionYear");
                    String duration = rs.getString("duration");
                    Genre g = new Genre(rs.getString("genre"));
                    Actor a = new Actor(rs.getString("firstName"), rs.getString("lastName"));


                    Movie movie = new Movie(id, title, py, duration, g, a);

                    m.add(movie);
                }
                return m;
            }
        });

    }

    /*
    this method contacts our database to find a specific movie
     */
    public Movie findMovie(int id) {
        //this string is our message to our mysql database
        String sql = "SELECT idmovie, title, productionYear, duration, genre.genre," +
                " actor.firstName, actor.lastName FROM movies " +
                "INNER JOIN genre ON movies.idgenre = genre.idgenre " +
                "INNER JOIN actor ON movies.idactor = actor.idactor " +
                "WHERE idmovie=? ";

        RowMapper<Movie> rowMapper = new BeanPropertyRowMapper<>(Movie.class);
        Movie movie = jdbc.queryForObject(sql, rowMapper, id);
        return movie;

    }

    /*
    this method contacts our database to add a new movie to the database
     */
    public Movie addMovie(Movie movie) {


        String sql = "INSERT INTO movies values (default, ?, ?, ?, ?, ?)";
        jdbc.update(sql, movie.getTitle(), movie.getProductionYear(), movie.getDuration(), movie.getGenre().getIdgenre(), movie.getActor().getIdactor());

        return movie;
    }

    /*
    this method contacts our database to deletes a specific movie
     */
    public void deleteMovie(int movieId) {
        //
        String sql = "DELETE FROM movies WHERE idmovie=?";
        jdbc.update(sql);

    }

    /*
    this method contacts our database to update a specific movie
     */
    public Movie updateMovie(int movieId, Movie movie) {
        //
        String sql = "UPDATE movies SET title=?, productionYear=?, duration=?, idgenre=?, idactor=? WHERE idmovie=?";
        jdbc.update(sql, movie.getTitle(), movie.getProductionYear(), movie.getDuration(), movie.getGenre().getIdgenre(), movie.getActor().getIdactor());
        return null;
    }

    /*
    this method contacts our database to showcase a specific movie
     */
    public List<Movie> search(String searching) {

        String t = "'%" + searching + "%'";

        ArrayList<Movie> m = new ArrayList<>();
        String sql = "SELECT idmovie, title, productionYear, duration, genre.genre, " +
                "actor.firstName, actor.lastName FROM movies " +
                "INNER JOIN genre ON movies.idgenre = genre.idgenre " +
                "INNER JOIN actor ON movies.idactor = actor.idactor " +
                "WHERE title LIKE " + t + " ORDER BY title ";


        return this.jdbc.query(sql, new ResultSetExtractor<List<Movie>>() {
            @Override
            public List<Movie> extractData(ResultSet rs) throws SQLException, DataAccessException {

                while (rs.next()) {
                    int id = rs.getInt("idmovie");
                    String title = rs.getString("title");
                    int py = rs.getInt("productionYear");
                    String duration = rs.getString("duration");
                    Genre g = new Genre(rs.getString("genre"));
                    Actor a = new Actor(rs.getString("firstName"), rs.getString("lastName"));


                    Movie movie = new Movie(id, title, py, duration, g, a);

                    m.add(movie);
                }
                return m;
            }
        });

    }

    public Movie addActorToMovie() {
        return addActorToMovie();
    }
}

