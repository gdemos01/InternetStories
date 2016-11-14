package com.is.app.internetstory.models;

/**
 * Created by georg on 14-Nov-16.
 */

public class User {
    private String username;
    private String password;
    private int logged_in;

    public User(){

    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public int getLogged_in() {
        return logged_in;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setLogged_in(int logged_in) {
        this.logged_in = logged_in;
    }
}
