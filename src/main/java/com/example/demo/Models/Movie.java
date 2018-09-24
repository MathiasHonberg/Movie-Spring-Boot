package com.example.demo.Models;

public class Movie {

    private String title, duration, genre;
    private int year;

    public Movie() {
    }

    public Movie(String title, int year, String duration, String genre) {
        this.title = title;
        this.duration = duration;
        this.genre = genre;
        this.year = year;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "title='" + title + '\'' +
                ", duration='" + duration + '\'' +
                ", genre='" + genre + '\'' +
                ", year=" + year +
                '}';
    }
}

