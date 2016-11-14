package com.is.app.internetstory.models;

/**
 * Created by georg on 14-Nov-16.
 */

public class UserStory {
    private String url;
    private int unsat;
    private int sat;

    public UserStory(){

    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setUnsat(int unsat) {
        this.unsat = unsat;
    }

    public void setSat(int sat) {
        this.sat = sat;
    }

    public String getUrl() {
        return url;
    }

    public int getUnsat() {
        return unsat;
    }

    public int getSat() {
        return sat;
    }
}
