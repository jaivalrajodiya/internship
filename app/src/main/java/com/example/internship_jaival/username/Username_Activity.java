package com.example.internship_jaival.username;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.internship_jaival.R;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.lang.reflect.Array;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Pattern;

public class Username_Activity extends AppCompatActivity {

    EditText fristname,lastname,username,phoneno;
    LinearLayout login;
    Button submit;
    int check =0;

    ArrayList<String> storeusername;
    ArrayList<String> storenumber;
//    ArrayList<String> storename;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_username);

        fristname = findViewById(R.id.username_fristname);
        lastname = findViewById(R.id.username_lastname);
        username = findViewById(R.id.username_username);
        phoneno = findViewById(R.id.username_mobileno);
        submit = findViewById(R.id.username_submit);
        login = findViewById(R.id.username_login);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Username_Activity.this,username_login.class);
                startActivity(intent);
            }
        });

        SharedPreferences sharedPreferences = getSharedPreferences("store",MODE_PRIVATE);
        Boolean vaild = sharedPreferences.getBoolean("check",false);

        if (vaild){
            Intent intent = new Intent(Username_Activity.this,showdata.class);
            startActivity(intent);
        }

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String usname = username.getText().toString();
                String fname = fristname.getText().toString();
                String lname = lastname.getText().toString();
                String mobile = phoneno.getText().toString();

                Pattern regex = Pattern.compile("[$&+,:;=\\\\?@#|/'<>.^*()%!-' ']");
                Pattern regex1 = Pattern.compile("[A-Z]");
                Pattern regex2 = Pattern.compile("[0-9]");

                if (usname.isEmpty() || fname.isEmpty() || lname.isEmpty() || mobile.isEmpty()) {
                    Toast.makeText(Username_Activity.this, "Please enter detail", Toast.LENGTH_SHORT).show();
                } else if (regex2.matcher(fname).find() || regex2.matcher(lname).find() ) {
                    Toast.makeText(Username_Activity.this, "Number are not allowed", Toast.LENGTH_SHORT).show();
                } else {

                    if (mobile.length() < 10){
                        Toast.makeText(Username_Activity.this, "Please enter 10 Digit Number", Toast.LENGTH_SHORT).show();

                    }else {
                        if (regex.matcher(usname).find()) {
                            Toast.makeText(Username_Activity.this, "Special Character and Space are not allowed", Toast.LENGTH_SHORT).show();
                        } else if (regex1.matcher(usname).find()) {
                            Toast.makeText(Username_Activity.this, "please enter lowercase", Toast.LENGTH_SHORT).show();
                        } else {
                            SharedPreferences getshare = getSharedPreferences("store",MODE_PRIVATE);
                            Gson gson1 = new Gson();
                            String json1 = getshare.getString("list",null);
                            String getphonejson = getshare.getString("listnumber",null);
//                            String getnamejson = getshare.getString("listname",null);
                            Type type = new TypeToken<ArrayList<String>>(){}.getType();
                            storeusername = gson1.fromJson(json1,type);
                            storenumber = gson1.fromJson(getphonejson,type);
//                            storename = gson1.fromJson(getnamejson,type);

                            if (storeusername == null ){
                                storeusername = new ArrayList<>();
                            }

                            if (storenumber == null){
                                storenumber = new ArrayList<>();

                            }

                            for (int i = 0; i < storeusername.size(); i++) {
                                if (storeusername.get(i).toString().equals(usname)) {
                                    check = 1;
                                    Toast.makeText(Username_Activity.this, "Username already are use", Toast.LENGTH_SHORT).show();
                                    break;
                                }else {
                                    check = 0;
                                }
                            }

                            for (int i = 0; i < storenumber.size(); i++) {
                                if (storenumber.get(i).toString().equals(mobile)) {
                                    check = 1;
                                    Toast.makeText(Username_Activity.this, "PhoneNo already are use", Toast.LENGTH_SHORT).show();
                                    break;
                                }
                            }

                            if (check == 0){
                                Intent intent = new Intent(Username_Activity.this, showdata.class);
                                startActivity(intent);
                                storeusername.add(usname);
                                storenumber.add(mobile);
//                                storename.add(fname+" "+lname);
                                SharedPreferences sharedPreferences = getSharedPreferences("store",MODE_PRIVATE);
                                SharedPreferences.Editor editor = sharedPreferences.edit();
                                Gson gson = new Gson();
                                String json = gson.toJson(storeusername);
                                String phonjson = gson.toJson(storenumber);
//                                String namejson = gson.toJson(storename);
                                editor.putString("list",json);
                                editor.putString("listnumber",phonjson);
//                                editor.putString("listname",namejson);
                                editor.putString("fname",fname);
                                editor.putString("lname",lname);
                                editor.putString("usname",usname);
                                editor.putString("mobile",mobile);
                                editor.putBoolean("fristtime",false);
                                editor.putBoolean("check",true);
                                editor.apply();
                            }
                        }
                    }



                    }


                }



        });

    }

    @Override
    protected void onRestart() {
        super.onRestart();
        username.setText("");
        fristname.setText("");
        lastname.setText("");
        phoneno.setText("");
    }
}