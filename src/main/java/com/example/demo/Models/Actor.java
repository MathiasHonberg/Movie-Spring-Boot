package com.example.demo.Models;

public class Actor {
    private int idactor;
    private String firstName;
    private String lastName;
    private int dateOfBirth;

    public Actor(int idactor, String firstName, String lastName, int dateOfBirth) {
        this.idactor = idactor;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
    }

    public Actor() {

    }

    public Actor(String firstName, String lastName, int dateOfBirth) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
    }

    public Actor(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public int getIdactor() {
        return idactor;
    }

    public void setIdactor(int idactor) {
        this.idactor = idactor;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(int dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    @Override
    public String toString() {
        return "Actor{" +
                "idactor=" + idactor +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                '}';
    }
}

