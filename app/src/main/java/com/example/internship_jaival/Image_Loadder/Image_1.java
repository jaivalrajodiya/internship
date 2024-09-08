package com.example.internship_jaival.Image_Loadder;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;

import com.example.internship_jaival.R;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Image_1 extends AppCompatActivity {

    RecyclerView recyclerView;

    ImageAdapter adapter;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image1);

        recyclerView = findViewById(R.id.image_lodder_rcv);
        recyclerView.setLayoutManager(new LinearLayoutManager(Image_1.this));

        Image_Interface imageInterface = Image_ApiClient.getRetrofit().create(Image_Interface.class);
       Call<Image_MainModel> call = imageInterface.Imageshow();

       call.enqueue(new Callback<Image_MainModel>() {
           @Override
           public void onResponse(Call<Image_MainModel> call, Response<Image_MainModel> response) {
              ArrayList<Image_Model> imageModels = response.body().getData();
              adapter = new ImageAdapter(Image_1.this,imageModels);
              recyclerView.setAdapter(adapter);
               for (int i = 0; i < imageModels.size(); i++) {
                   Log.d("TAG", "onResponse: "+imageModels.get(i).displayImage);
               }
           }

           @Override
           public void onFailure(Call<Image_MainModel> call, Throwable t) {

           }
       });

    }
}