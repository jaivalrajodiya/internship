package com.example.internship_jaival.onActivityresult;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.internship_jaival.R;

public class Second_screen extends AppCompatActivity {

    EditText enter,gender;

    Button subbtn;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_screen);

        enter = findViewById(R.id.enter_msg);
        subbtn = findViewById(R.id.submit_msg);
        gender = findViewById(R.id.enter_gender);

        subbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra("MSG",enter.getText().toString());
                intent.putExtra("GENDER",gender.getText().toString());
                setResult(100,intent);
                finish();
            }
        });
    }
}