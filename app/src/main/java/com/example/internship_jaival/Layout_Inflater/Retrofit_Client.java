package com.example.internship_jaival.Layout_Inflater;

import com.example.internship_jaival.retrofit_api.RetrofitCient;

import java.security.PublicKey;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Retrofit_Client {

    public static Retrofit retrofit;
    public static String BASE_URL= "https://cashbackzone.app/App/demouser/";



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
