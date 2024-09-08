package com.example.internship_jaival.Sqliteexample;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.internship_jaival.R;

public class option_select extends AppCompatActivity {

    Button truth,dare;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_option_select);
        truth = findViewById(R.id.btntruth);
        dare = findViewById(R.id.btndare);

        truth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(option_select.this, Sqlite_Activity.class);
                startActivity(intent);
            }
        });

        dare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(option_select.this, dare.class);
                startActivity(intent);
            }
        });
    }
}