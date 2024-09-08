package com.example.internship_jaival.PUT_ApiCalling;



import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PutApi_ApiClient {

    public static Retrofit retrofit;

    public static String BASE_URL = "https://jsonplaceholder.typicode.com/";
    public static Retrofit getRetrofit() {

        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();


        }

        return retrofit;
    }


}
