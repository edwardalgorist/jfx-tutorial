package com.coderscratchpad.javafxtutorial.rest;

/**
 * Code of the tutorial described on
 * <a href="https://coderscratchpad.com/javafx-and-restful-web-services-integration/">coderscratchpad.com</a>
 */
public class Post {

    private int userId;
    private int id;
    private String title;
    private String body;

    public int getUserId() {
        return userId;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }

}