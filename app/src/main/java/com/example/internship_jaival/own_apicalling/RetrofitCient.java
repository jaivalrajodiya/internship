package com.example.internship_jaival.own_apicalling;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitCient {

    public static Retrofit retrofit;

    public static String BASE_URL = "https://learnapiforfree.000webhostapp.com/";

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
