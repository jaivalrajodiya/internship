package com.example.internship_jaival.own_apicalling;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.internship_jaival.R;

public class own_Api_Calling extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_own_api_calling);

        new Login_Async(own_Api_Calling.this);
    }
}