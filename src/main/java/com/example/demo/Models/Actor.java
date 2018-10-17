package com.example.demo.Models;

public class Actor {

    private String firstName;
    private String lastName;
    private int dateOfBirth;

    public Actor(String firstName, String lastName, int date) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = date;
    }

    public Actor() {

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

    public int getDate() {
        return dateOfBirth;
    }

    public void setDate(int date) {
        this.dateOfBirth = date;
    }

    @Override
    public String toString() {
        return "Actor: " +
                "\nFirst Name: " + firstName +
                "\nLast Name: " + lastName +
                "\nDate: " + dateOfBirth;
    }
}

