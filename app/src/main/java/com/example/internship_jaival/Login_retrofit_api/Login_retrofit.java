package com.example.internship_jaival.Login_retrofit_api;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.internship_jaival.MainActivity;
import com.example.internship_jaival.R;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Login_retrofit extends AppCompatActivity {

    EditText username, password;
    Button btnLogin,btnshow;

    TextView text;



    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_retrofit);

        username = findViewById(R.id.Login_api_email);
        password = findViewById(R.id.Login_api_Password);
        btnLogin = findViewById(R.id.Login_api_submit);
        btnshow = findViewById(R.id.Login_api_show);
        text = findViewById(R.id.api_response_showdata);
        text.setText("");

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(TextUtils.isEmpty(username.getText().toString()) || TextUtils.isEmpty(password.getText().toString())){
                    Toast.makeText(Login_retrofit.this,"name / job Required", Toast.LENGTH_LONG).show();
                }else{
                    //proceed to login
                    login(username.getText().toString(),password.getText().toString());
                }
            }
        });

        btnshow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Login_retrofit.this,DashboardActivity.class);
                startActivity(intent);
            }
        });
    }

    private void login(String name , String job) {

        UserService userService = ApiClient.getRetrofit().create(UserService.class);
        LoginRequest loginRequest = new LoginRequest(name,job);

        Call<LoginRequest> call = userService.userLogin(loginRequest);

        call.enqueue(new Callback<LoginRequest>() {
            @Override
            public void onResponse(Call<LoginRequest> call, Response<LoginRequest> response) {
                if (response.isSuccessful()){
                    Toast.makeText(Login_retrofit.this, "Add data Successfully", Toast.LENGTH_SHORT).show();




                    Intent intent = new Intent(Login_retrofit.this, DashboardActivity.class);
                    intent.putExtra("name",response.body().getName());
                    intent.putExtra("Job",response.body().getJob());
                    startActivity(intent);
//                   text.append("Name:-"+response.body().getName()+"\n Job :- "+response.body().getJob()+"\n\n");
//
                }
            }

            @Override
            public void onFailure(Call<LoginRequest> call, Throwable t) {
                Toast.makeText(Login_retrofit.this, t.getMessage(), Toast.LENGTH_SHORT).show();
                Log.e("fail",t.getMessage());
            }
        });

//        Call<LoginRequest> call = userService.userLogin(loginRequest);
//        call.enqueue(new Callback<LoginRequest>() {
//            @Override
//            public void onResponse(Call<LoginRequest> call, Response<LoginRequest> response) {
//                if (response.isSuccessful()){
//                    Toast.makeText(Login_retrofit.this, "Add data Successfully", Toast.LENGTH_SHORT).show();
//                    LoginRequest responseApi = response.body();
//
//                }
//            }
//
//            @Override
//            public void onFailure(Call<LoginRequest> call, Throwable t) {
//
//            }
//        });

    }
}