package com.example.internship_jaival.retrofit_api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitCient {

    public static Retrofit retrofit;

    public static String BASE_URL = "https://reqres.in/";

    public static Retrofit getRetrofit(){
      if (retrofit==null){
          retrofit = new Retrofit.Builder()
                  .baseUrl(BASE_URL)
                  .addConverterFactory(GsonConverterFactory.create())
                  .build();
      }

      return retrofit;
    }

}
