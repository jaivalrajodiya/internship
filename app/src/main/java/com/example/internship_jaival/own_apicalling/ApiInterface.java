package com.example.internship_jaival.own_apicalling;

import com.example.internship_jaival.retrofit_api.MainModel;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiInterface {

    @FormUrlEncoded
    @POST("register.php")
    Call<MainModel_ownapi> insertdata(@Field("details") String details);
}
