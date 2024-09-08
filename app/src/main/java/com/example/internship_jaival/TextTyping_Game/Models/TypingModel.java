package com.example.internship_jaival.TextTyping_Game.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TypingModel {

    @SerializedName("timer")
    @Expose
    int timer;

    @SerializedName("remainLimit")
    @Expose
    int remainLimit;
    @SerializedName("limit")
    @Expose
    int limit;
    @SerializedName("text")
    @Expose
    String text;
    @SerializedName("main_timer")
    @Expose
    String main_timer;

    @SerializedName("winpoint")
    @Expose
    int winpoint;
    @SerializedName("message")
    @Expose
    String message;
    @SerializedName("status")
    @Expose
    String status;




    public String getMain_timer() {
        return main_timer;
    }

    public void setMain_timer(String main_timer) {
        this.main_timer = main_timer;
    }

    public int getWinponint() {
        return winpoint;
    }

    public void setWinponint(int winponint) {
        this.winpoint = winponint;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getTimer() {
        return timer;
    }

    public void setTimer(int timer) {
        this.timer = timer;
    }

    public int getRemainLimit() {
        return remainLimit;
    }

    public void setRemainLimit(int remainLimit) {
        this.remainLimit = remainLimit;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
