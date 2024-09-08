package com.example.internship_jaival.TextTyping_Game.Interface;

import com.example.internship_jaival.TextTyping_Game.Models.SaveTextTypingModel;
import com.example.internship_jaival.TextTyping_Game.Models.TypingModel;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface TypingInterface {

    @FormUrlEncoded
    @POST("GetRandomtext")
    Call<TypingModel> gettext(@Field("details") String details);

    @FormUrlEncoded
    @POST("SaveRandomtext")
    Call<SaveTextTypingModel> savetext(@Field("details") String details);
}
