package com.example.internship_jaival.retrofit_api;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

import com.example.internship_jaival.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class retrofit_screen extends AppCompatActivity {


    RecyclerView recyclerView;
    Adapter adapter;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrofit_screen);
        recyclerView = findViewById(R.id.retro_rcv);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        ApiInterface apiInterface = RetrofitCient.getRetrofit().create(ApiInterface.class);
        Call<MainModel> call = apiInterface.getAllData();
        call.enqueue(new Callback<MainModel>() {
            @Override

            public void onResponse(Call<MainModel> call, Response<MainModel> response) {

                if (response.isSuccessful()){
                    ArrayList<DataModel> data = response.body().getData();
                    adapter = new Adapter(retrofit_screen.this,data);
                    recyclerView.setAdapter(adapter);
                }

            }

            @Override
            public void onFailure(Call<MainModel> call, Throwable t) {

            }
        });

    }
}