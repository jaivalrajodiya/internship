package com.example.internship_jaival.Layout_Inflater;

import retrofit2.Call;
import retrofit2.http.POST;

public interface ApiInterface {

    @POST("HomeData")
    Call<Layout_MainModel> getAllData();
}
