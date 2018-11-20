package com.example.demo.Models;

public class Genre {

    private int idgenre;
    private String genre;

    public Genre(int idgenre, String genre) {
        this.idgenre = idgenre;
        this.genre = genre;
    }

    public Genre(String genre) {
        this.genre = genre;
    }

    public Genre() {

    }

    public int getIdgenre() {
        return idgenre;
    }

    public void setIdgenre(int idgenre) {
        this.idgenre = idgenre;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String displayGenre() {

        return "Genre: " +
                "\nGenre ID: " + idgenre +
                "\nGenre: " + genre;
    }

    @Override
    public String toString() {

        return "" + this.getGenre();
    }
}
