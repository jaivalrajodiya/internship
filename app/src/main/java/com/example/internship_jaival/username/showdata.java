package com.example.internship_jaival.username;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.internship_jaival.R;

public class showdata extends AppCompatActivity {

    TextView name,username,mobileno,point;

    Button logout;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_showdata);

        name = findViewById(R.id.username_name);
        username = findViewById(R.id.username_usname);
        mobileno = findViewById(R.id.username_phoneno);
        point = findViewById(R.id.username_bounspoint);
        logout = findViewById(R.id.username_logout);


        SharedPreferences sharedPreferences = getSharedPreferences("store",MODE_PRIVATE);
        Boolean valid = sharedPreferences.getBoolean("fristtime",false);
        String fname = sharedPreferences.getString("fname",null);
        String lname = sharedPreferences.getString("lname",null);
        String uname = sharedPreferences.getString("usname",null);
        String phone = sharedPreferences.getString("mobile",null);
        String pointno = sharedPreferences.getString("point","0");

        name.setText(fname+" "+lname);
        username.setText(uname);
        mobileno.setText(phone);
        point.setText(pointno);



        if (!valid){
            showdialog();
        }

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sharedPreferences = getSharedPreferences("store",MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putBoolean("fristtime",true);
                editor.putBoolean("check",false);
                editor.apply();
                Intent intent = new Intent(showdata.this,username_login.class);
                startActivity(intent);

            }
        });



    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finishAffinity();
    }
    public void showdialog(){
        Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.bottomsheet_layout2);
        ImageView accept = dialog.findViewById(R.id.cancle2);
        Button done = dialog.findViewById(R.id.btndone);

        accept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                point.setText("100");
                SharedPreferences sharedPreferences = getSharedPreferences("store",MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putBoolean("fristtime",true);
                editor.apply();
                dialog.dismiss();

            }
        });

        done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                point.setText("100");
                SharedPreferences sharedPreferences = getSharedPreferences("store",MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putBoolean("fristtime",true);
                editor.putString("point","100");
                editor.apply();
                dialog.dismiss();

            }
        });
        dialog.show();
        dialog.setCancelable(false);
        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;
        dialog.getWindow().setGravity(Gravity.BOTTOM);
    }
}