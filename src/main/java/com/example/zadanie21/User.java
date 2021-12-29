package com.example.zadanie21;

public class User {
    private Long id;
    private String firstName;
    private String lastName;

    public User(String firstName, String lastName, Long id) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User() {

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
}
