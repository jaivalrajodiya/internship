package com.example.internship_jaival.tables;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.internship_jaival.R;

public class show_table extends AppCompatActivity {

    TextView show;
    String result;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_table);
        show = findViewById(R.id.showtable);

        Intent intent = getIntent();
        String table = intent.getStringExtra("tableno");

        int n = Integer.valueOf(table);
        result="";

        for (int i = 1; i <=10 ; i++) {

            result+=n+" "+"*"+" "+i+" "+"="+" "+n*i+"\n";
            show.setText(result);
        }



    }
}