package com.is.app.internetstory.models;

/**
 * Created by georg on 14-Nov-16.
 */


public class Category {
    private String username;
    private int meme;
    private int funny;
    private int news;
    private int cheerful;
    private int romantic;

    public Category(){

    }

    public String getUsername() {
        return username;
    }

    public int getMeme() {
        return meme;
    }

    public int getFunny() {
        return funny;
    }

    public int getNews() {
        return news;
    }

    public int getCheerful() {
        return cheerful;
    }

    public int getRomantic() {
        return romantic;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setMeme(int meme) {
        this.meme = meme;
    }

    public void setFunny(int funny) {
        this.funny = funny;
    }

    public void setNews(int news) {
        this.news = news;
    }

    public void setCheerful(int cheerful) {
        this.cheerful = cheerful;
    }

    public void setRomantic(int romantic) {
        this.romantic = romantic;
    }
}
