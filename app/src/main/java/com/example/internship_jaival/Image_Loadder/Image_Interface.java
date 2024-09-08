package com.example.internship_jaival.Image_Loadder;

import com.example.internship_jaival.Login_retrofit_api.LoginRequest;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface Image_Interface {

    @POST("Interview")
    Call<Image_MainModel> Imageshow();



}
