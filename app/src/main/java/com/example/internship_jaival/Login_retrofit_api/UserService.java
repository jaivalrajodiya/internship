package com.example.internship_jaival.Login_retrofit_api;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface UserService {

    @POST("users")
    Call<LoginRequest> userLogin(@Body LoginRequest loginRequest);

    @POST("users")
    Call<LoginRequest> data();

}
