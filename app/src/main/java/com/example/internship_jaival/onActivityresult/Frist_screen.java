package com.example.internship_jaival.onActivityresult;

import androidx.activity.result.ActivityResult;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import com.example.internship_jaival.R;

public class Frist_screen extends AppCompatActivity {

    TextView show;
    Button btn;

    RadioButton male , female;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frist_screen);

        show = findViewById(R.id.show_msg);
        btn = findViewById(R.id.Activity_next);
        male = findViewById(R.id.male_radio);
        female = findViewById(R.id.female_radio);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Frist_screen.this,Second_screen.class);
                startActivityForResult(intent,100);
            }
        });




    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        String msg = data.getStringExtra("MSG");
        String gender = data.getStringExtra("GENDER");
        int num = Integer.parseInt(gender);
        if (num >=1 && num<=5){
            male.setChecked(true);
            female.setChecked(false);
        }else if (num >= 6 && num <=9){
            female.setChecked(true);
            male.setChecked(false);
        }
        show.setText(msg);
    }
}