package com.is.app.internetstory.db;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.is.app.internetstory.models.Category;
import com.is.app.internetstory.models.Story;
import com.is.app.internetstory.models.User;
import com.is.app.internetstory.models.UserStory;

import java.util.ArrayList;

/**
 * Created by georg on 14-Nov-16.
 */

public class DatabaseHelper extends SQLiteOpenHelper {

    // Database
    public static final String DATABASE_NAME = "stories.db";

    /***
     * Database Tables along with their columns
      */
    // User Table
    public static final String USER_TABLE = "user_table";
    public static final String USERNAME_COL = "username";
    public static final String PASSWORD_COL = "password";
    public static final String LOGGEDIN_COL = "logged_in";

    // Categories
    public static final String CATEGORIES_TABLE = "categories_table";
    public static final String MEME_COL = "meme";
    public static final String FUNNY_COL = "funny";
    public static final String NEWS_COL = "news";
    public static final String CHEERFUL_COL = "cheerful";
    public static final String ROMANTIC_COL = "romantic";

    // Stories
    public static final String STORIES_TABLE = "stories_table";
    public static final String ID_COL = "id";
    public static final String URL_COL = "url";
    public static final String UNSAT_COL = "unsat";
    public static final String SAT_COL = "sat";

    // User Stories
    public static final String USER_STORIES_TABLE = "user_stories_table";
    public static final String US_URL_COL = "url";
    public static final String US_UNSAT_COL = "unsat";
    public static final String US_SAT_COL = "sat";

    //TABLE CREATION QUERIES
    private static final String CREATE_USER =
            "CREATE TABLE " + USER_TABLE + " (" + USERNAME_COL + " TEXT PRIMARY KEY NOT NULL, "
            + PASSWORD_COL + " TEXT NOT NULL, " + LOGGEDIN_COL + " INT NOT NULL  )";

    private static final String CREATE_CATEGORIES =
            "CREATE TABLE "+ CATEGORIES_TABLE + " (" + USERNAME_COL + "TEXT PRIMARY KEY NOT NULL ,"
            + MEME_COL + " INT NOT NULL ," + FUNNY_COL + " INT NOT NULL ," + NEWS_COL +" INT NOT NULL ,"
            + CHEERFUL_COL + " INT NOT NULL ," + ROMANTIC_COL + " INT NOT NULL )";

    private static final String CREATE_STORIES =
            "CREATE TABLE "+ STORIES_TABLE + " ("+ID_COL+" INT PRIMARY KEY NOT NULL, "+ URL_COL
            + " TEXT NOT NULL, "+ UNSAT_COL + " INT NOT NULL, "+SAT_COL+" INT NOT NULL )";

    private static final String CREATE_USER_STORIES =
            "CREATE TABLE "+ USER_STORIES_TABLE + " ("+US_URL_COL + " TEXT PRIMARY KEY NOT NULL, "
                    + US_UNSAT_COL + " INT NOT NULL, "+US_SAT_COL+" INT NOT NULL )";


    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_USER);
        db.execSQL(CREATE_CATEGORIES);
        db.execSQL(CREATE_STORIES);
        db.execSQL(CREATE_USER_STORIES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + USER_TABLE);
        db.execSQL("DROP TABLE IF EXISTS " + CATEGORIES_TABLE);
        db.execSQL("DROP TABLE IF EXISTS " + STORIES_TABLE);
        db.execSQL("DROP TABLE IF EXISTS " + USER_STORIES_TABLE);
        onCreate(db);
    }

    /**
     * Add a new user to the local database
     *
     * @param u
     */
    public void addUser(User u) {
        SQLiteDatabase db = this.getWritableDatabase();
        String sql =
                "INSERT or replace INTO user_table (username, password, logged_in) VALUES('"
                        + u.getUsername() + "','" + u.getPassword() + "', " + u.getLogged_in() +")";
        db.execSQL(sql);
    }

    public void addCategory(Category c){
        SQLiteDatabase db = this.getWritableDatabase();
        String sql =
                "INSERT or replace INTO categories_table (username, meme, funny, news,cheerful,romantic)" +
                        " VALUES('"
                        + c.getUsername() + "'," + c.getMeme() + ", " + c.getFunny()+", "+
                        + c.getNews() + ", "+c.getCheerful()+", "+c.getRomantic()
                        +")";
        db.execSQL(sql);
    }

    public void addStory(Story s){
        SQLiteDatabase db = this.getWritableDatabase();
        String sql =
                "INSERT or replace INTO stories_table (id, url, unsat,sat) VALUES("
                        + s.getId()+ ",'" + s.getUrl() + "', " + s.getUnsat() +", "
                        + s.getSat()
                        +")";
        db.execSQL(sql);
    }

    public void addUserStory(UserStory us){
        SQLiteDatabase db = this.getWritableDatabase();
        String sql =
                "INSERT or replace INTO user_stories_table (url, unsat,sat) VALUES('"
                        + us.getUrl() + "', " + us.getUnsat() +", "
                        + us.getSat()
                        +")";
        db.execSQL(sql);
    }

    /**
     * Get current user from the local database.
     *
     * @return User
     */
    public User getUser() {

        SQLiteDatabase db = this.getReadableDatabase();
        String sql = "SELECT * FROM `user_table`";

        Cursor c = null;
        c = db.rawQuery(sql, null);

        c.moveToFirst();

        User user = new User();
        user.setUsername(c.getString(0));
        user.setPassword(c.getString(1));
        user.setLogged_in(c.getInt(2));
        c.moveToNext();

        c.close();

        return user;
    }

    public Story getStory(int id){
        SQLiteDatabase db = this.getReadableDatabase();
        String sql = "SELECT * FROM 'stories_table' WHERE id = "+id;
        Cursor c = null;
        c = db.rawQuery(sql,null);
        c.moveToFirst();
        Story story = new Story();
        story.setId(c.getInt(0));
        story.setUrl(c.getString(1));
        story.setUnsat(c.getInt(2));
        story.setSat(c.getInt(3));

        c.moveToNext();
        c.close();
        return story;
    }

    public ArrayList<UserStory> getUserStories(){
        ArrayList<UserStory> userStories = new ArrayList<>();

        SQLiteDatabase db = this.getReadableDatabase();
        String sql = "SELECT * FROM 'user_stories_table'";
        Cursor c = null;
        c = db.rawQuery(sql,null);

        c.moveToFirst();
        while (!c.isAfterLast()){
            UserStory u = new UserStory();
            u.setUrl(c.getString(0));
            u.setUnsat(c.getInt(1));
            u.setSat(c.getInt(2));
            userStories.add(u);
            c.moveToNext();
        }

        return userStories;
    }

    public Category getCategories(String username){
        SQLiteDatabase db = this.getReadableDatabase();
        String sql = "SELECT * FROM 'categories_table'";
        Cursor c = null;
        c = db.rawQuery(sql,null);
        c.moveToFirst();
        Category cat = new Category();
        cat.setUsername(c.getString(0));
        cat.setMeme(c.getInt(1));
        cat.setFunny(c.getInt(2));
        cat.setNews(c.getInt(3));
        cat.setCheerful(c.getInt(4));
        cat.setRomantic(c.getInt(5));
        c.moveToNext();
        c.close();
        return cat;
    }
}
