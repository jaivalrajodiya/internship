package com.example.internship_jaival.SortWord_Game.RetrofitClient;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Sortword_retrofit {

    public static Retrofit retrofit;

    public static String BASE_URL = "https://bonusbuddy.in/APINamra/";

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
