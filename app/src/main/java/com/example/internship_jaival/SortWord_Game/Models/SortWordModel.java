package com.example.internship_jaival.SortWord_Game.Models;

import java.util.ArrayList;

public class SortWordModel {

    int timer;
    int remainLimit;
    int limit;

    ArrayList<String> AnSortWord;
    ArrayList<String> SortWord;

    int winpoint;
    String main_timer;
    String message;
    String status;

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

    public ArrayList<String> getAnSortWord() {
        return AnSortWord;
    }

    public void setAnSortWord(ArrayList<String> anSortWord) {
        AnSortWord = anSortWord;
    }

    public ArrayList<String> getSortWord() {
        return SortWord;
    }

    public void setSortWord(ArrayList<String> sortWord) {
        SortWord = sortWord;
    }

    public int getWinpoint() {
        return winpoint;
    }

    public void setWinpoint(int winpoint) {
        this.winpoint = winpoint;
    }

    public String getMain_timer() {
        return main_timer;
    }

    public void setMain_timer(String main_timer) {
        this.main_timer = main_timer;
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
}
