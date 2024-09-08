package com.example.internship_jaival.SortWord_Game.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SaveSortwordModel {
    @SerializedName("message")
    @Expose
    String message;
    @SerializedName("status")
    @Expose
    String status;

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
