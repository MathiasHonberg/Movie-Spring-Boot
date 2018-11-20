package com.example.demo.Models;

public class Movie {

    private int idmovie;
    private String title;
    private int productionYear;
    private String duration;
    private Genre genre;
    private Actor actor;

    public Movie(int idmovie, String title, int productionYear, String duration, Genre genre, Actor actor) {
        this.idmovie = idmovie;
        this.title = title;
        this.productionYear = productionYear;
        this.duration = duration;
        this.genre = genre;
        this.actor = actor;
    }

    public Movie(int idmovie, String title, int productionYear, String duration) {
        this.idmovie = idmovie;
        this.title = title;
        this.productionYear = productionYear;
        this.duration = duration;
    }

    public Movie(String title, int productionYear, String duration) {
        this.title = title;
        this.productionYear = productionYear;
        this.duration = duration;
    }

    public Movie() {
    }

    public void addActor(Actor actor) {
        this.actor = new Actor();
    }

    public void addGenre(Genre genre) {
        this.genre = new Genre();
    }

    public int getIdmovie() {
        return idmovie;
    }

    public void setIdmovies(int idmovie) {
        this.idmovie = idmovie;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getProductionYear() {
        return productionYear;
    }

    public void setProductionYear(int productionYear) {
        this.productionYear = productionYear;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public Actor getActor() {
        return actor;
    }

    public void setActor(Actor actor) {
        this.actor = actor;
    }

    @Override
    public String toString() {
        return "Movies: " +
                "\nMovie ID: " + this.idmovie +
                "\nTitle: " + title +
                "\nProductionYear: " + productionYear +
                "\nDuration: " + duration +
                "\nGenre: " + genre.displayGenre() +
                "\nActor: " + actor.displayActor();
    }

}

