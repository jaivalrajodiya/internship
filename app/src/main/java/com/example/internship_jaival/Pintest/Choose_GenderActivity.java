package com.example.internship_jaival.Pintest;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.internship_jaival.R;

public class Choose_GenderActivity extends AppCompatActivity {

    Button male,female,other;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_gender);
        male = findViewById(R.id.btnmale);
        female = findViewById(R.id.btnfemale);
        other = findViewById(R.id.btnother);

        male.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Choose_GenderActivity.this, Choose_CountryActivity.class);
                startActivity(intent);
            }
        });

        female.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Choose_GenderActivity.this, Choose_CountryActivity.class);
                startActivity(intent);
            }
        });

        other.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Choose_GenderActivity.this, Choose_CountryActivity.class);
                startActivity(intent);
            }
        });

    }
}