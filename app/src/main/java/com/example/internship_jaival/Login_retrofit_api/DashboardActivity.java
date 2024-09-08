package com.example.internship_jaival.Login_retrofit_api;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.internship_jaival.R;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DashboardActivity extends AppCompatActivity {

//    TextView email,passwoed;

    TextView text;

    LoginRequest loginRequest;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        text = findViewById(R.id.api_response_show);

//        email = findViewById(R.id.api_response_email);
//        passwoed = findViewById(R.id.api_response_password);
//
        Intent intent = getIntent();
        String em = intent.getStringExtra("name");
        String pass = intent.getStringExtra("Job");



        text.append("Name:-"+em+"\n Job :- "+pass+"\n\n");






//
//        email.setText(em);
//        passwoed.setText(pass);

//        UserService userService = ApiClient.getRetrofit().create(UserService.class);
//       Call<LoginRequest> call = userService.data();
//
//       call.enqueue(new Callback<LoginRequest>() {
//           @Override
//           public void onResponse(Call<LoginRequest> call, Response<LoginRequest> response) {
//               Log.e("show",""+response.body().getName());
//
//                   text.append("Name:-"+response.body().getName()+"\n Job :- "+response.body().getJob()+"\n\n\n");
//
//
//
//
//           }
//
//           @Override
//           public void onFailure(Call<LoginRequest> call, Throwable t) {
//               Log.e("fail",t.getMessage());
//           }
//       });


    }

}