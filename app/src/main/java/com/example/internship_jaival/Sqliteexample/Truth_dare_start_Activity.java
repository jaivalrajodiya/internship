package com.example.internship_jaival.Sqliteexample;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.internship_jaival.R;

public class Truth_dare_start_Activity extends AppCompatActivity {

    Button btnstart;

    ImageView imageView;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_truth_dare_start);

        btnstart = findViewById(R.id.truth_dare_start);
        imageView = findViewById(R.id.truth_dare_icon);

        Glide.with(Truth_dare_start_Activity.this).load("https://drive.google.com/uc?id=1VzRA65Va1yv6sihqkzt7gB9PnyJnQMYk").into(imageView);



        btnstart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Truth_dare_start_Activity.this,option_select.class);
                startActivity(intent);
            }
        });
    }
}