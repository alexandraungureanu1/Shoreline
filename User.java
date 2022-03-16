package com.company;

/**
 * A class for storing the information of a user.
 */

public class User {

    /**
     * I used a static variable for associating
     * a unique id to every user in the network.
     */
    private String name;
    private static int numberOfUsers = 0;
    private int id;

    public User(String name) {
        this.name = name;
        numberOfUsers++;
        id = numberOfUsers;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }
}
