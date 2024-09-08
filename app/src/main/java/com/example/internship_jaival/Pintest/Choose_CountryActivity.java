package com.example.internship_jaival.Pintest;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.internship_jaival.R;

import java.util.ArrayList;
import java.util.Locale;

public class Choose_CountryActivity extends AppCompatActivity {

    LinearLayout choose;

    TextView show;
    Button next;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_country);
        choose = findViewById(R.id.choose_contry);
        show = findViewById(R.id.show_country_name);
        next = findViewById(R.id.printerst_next1);

        choose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Choose_CountryActivity.this,CountrylistActivity.class);
                startActivity(intent);
            }
        });

        Intent intent = getIntent();

        String name = intent.getStringExtra("c_name");
        if (name != null){
            show.setText(name);
        }

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Choose_CountryActivity.this,InterestedActivity.class);
                startActivity(intent);
            }
        });




    }
}