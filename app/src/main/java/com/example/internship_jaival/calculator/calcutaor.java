package com.example.internship_jaival.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.internship_jaival.R;

public class calcutaor extends AppCompatActivity {

    EditText e1 ,e2;

    TextView show;

    Button sum,sub,div,multi,cle;




    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calcutaor);

        e1 = findViewById(R.id.firstno);
        e2 = findViewById(R.id.secondno);
        show = findViewById(R.id.result);
        cle = findViewById(R.id.clear);

        sub = findViewById(R.id.sub);
        sum = findViewById(R.id.sum);
        multi = findViewById(R.id.multi);
        div = findViewById(R.id.div);



        sum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (check()){


                    String s1 = e1.getText().toString();
                    String s2 = e2.getText().toString();


                    double a = Double.valueOf(s1);
                    double b = Double.valueOf(s2);
                    double result = a+b;

                    show.setText(String.valueOf(result));
                }

            }
        });

        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (check()){


                    String s1 = e1.getText().toString();
                    String s2 = e2.getText().toString();


                    double a = Double.valueOf(s1);
                    double b = Double.valueOf(s2);
                    double result = a-b;

                    show.setText(String.valueOf(result));
                }

            }
        });
        multi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (check()){


                    String s1 = e1.getText().toString();
                    String s2 = e2.getText().toString();


                    double a = Double.valueOf(s1);
                    double b = Double.valueOf(s2);
                    double result = a*b;

                    show.setText(String.valueOf(result));
                }

            }
        });
        div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (check()){


                    String s1 = e1.getText().toString();
                    String s2 = e2.getText().toString();

                    double a = Double.valueOf(s1);
                    double b = Double.valueOf(s2);
                    double result = a/b;

                    show.setText(String.valueOf(result));
                }

            }
        });

        cle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                e1.setText("");
                e2.setText("");
                show.setText("");
            }
        });










    }

    public boolean check(){
        if (e1.length() == 0){
            Toast.makeText(this, "please enter frist number", Toast.LENGTH_SHORT).show();

            return false;
        }
        if (e2.length() == 0){
            Toast.makeText(this, "please enter second number", Toast.LENGTH_SHORT).show();

            return false;
        }

        return true;
    }
}