package com.example.internship_jaival.Image_Loadder;



import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Image_ApiClient {

    public static Retrofit retrofit;

    public static String BASE_URL = "https://rewardpe.app/App/api100/";
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
