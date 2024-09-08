package com.example.internship_jaival.retrofit_api;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {

    @GET("api/users?page=1")
    Call<MainModel> getAllData();
}
