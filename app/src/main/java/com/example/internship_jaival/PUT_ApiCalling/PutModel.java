package com.example.internship_jaival.PUT_ApiCalling;

public class PutModel {

    int userId;
    String title;

    String body;

    public PutModel(int userId, String title, String body) {
        this.userId = userId;
        this.title = title;
        this.body = body;
    }


    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
