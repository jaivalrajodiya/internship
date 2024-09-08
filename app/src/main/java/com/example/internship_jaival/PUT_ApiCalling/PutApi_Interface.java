package com.example.internship_jaival.PUT_ApiCalling;

import com.example.internship_jaival.Image_Loadder.Image_MainModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface PutApi_Interface {

    @PUT("posts/{id}")
    Call<PutModel> Putapi(@Path("id") int id, @Body PutModel putModel);

    @GET("posts")
    Call<List<Get_Model>> getData();

    @POST("posts")
    Call<Get_Model> postdata(@Body Get_Model getModel);

    @DELETE("posts/{id}")
    Call<Void> deletedata(@Path("id") int id);


}
