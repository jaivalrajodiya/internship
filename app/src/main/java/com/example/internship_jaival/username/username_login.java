package com.example.internship_jaival.username;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.internship_jaival.R;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class username_login extends AppCompatActivity {

    EditText username,phoneno,name;
    Button submit;

    LinearLayout siginup;

    ArrayList<String> storeusername = new ArrayList<>();
    ArrayList<String> storenumber  = new ArrayList<>();

    int check =0;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_username_login);

        username = findViewById(R.id.username_login_username);
        phoneno = findViewById(R.id.username_login_mobileno);
        submit = findViewById(R.id.username_login_submit);
        siginup = findViewById(R.id.username_siginup);


        siginup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(username_login.this,Username_Activity.class);
                startActivity(intent);
            }
        });



        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String uname = username.getText().toString();
                String mobile = phoneno.getText().toString();

                SharedPreferences getshare = getSharedPreferences("store",MODE_PRIVATE);
                Gson gson1 = new Gson();
                String json1 = getshare.getString("list",null);
                String getphonejson = getshare.getString("listnumber",null);
                Type type = new TypeToken<ArrayList<String>>(){}.getType();
                storeusername = gson1.fromJson(json1,type);
                storenumber = gson1.fromJson(getphonejson,type);

                if (uname.isEmpty() || mobile.isEmpty()){
                    Toast.makeText(username_login.this, "Please Enter Details", Toast.LENGTH_SHORT).show();
                }else {

                    for (int i = 0; i < storeusername.size(); i++) {

                        if (storeusername.get(i).toString().equals(uname) && storenumber.get(i).toString().equals(mobile)){
                            check =1;
                            break;
                        }else {
                            check = 0;
                        }
                    }


                    if (check == 1){

                        SharedPreferences sharedPreferences = getSharedPreferences("store",MODE_PRIVATE);
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.putBoolean("fristtime",true);
                        editor.putBoolean("check",true);
                        editor.apply();
                        Intent intent = new Intent(username_login.this,showdata.class);
                        startActivity(intent);

                    }else {
                        Toast.makeText(username_login.this, "Please Enter Correct Details", Toast.LENGTH_SHORT).show();
                    }

                }
            }
        });

    }
}