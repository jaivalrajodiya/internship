package com.example.internship_jaival.SortWord_Game.Interface;

import com.example.internship_jaival.SortWord_Game.Models.SaveSortwordModel;
import com.example.internship_jaival.SortWord_Game.Models.SortWordModel;
import com.example.internship_jaival.TextTyping_Game.Models.SaveTextTypingModel;
import com.example.internship_jaival.TextTyping_Game.Models.TypingModel;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface SortwordInterface {

    @FormUrlEncoded
    @POST("GetSortWord")
    Call<SortWordModel> getword(@Field("details") String details);

    @FormUrlEncoded
    @POST("SaveSortWord")
    Call<SaveSortwordModel> saveword(@Field("details") String details);
}
