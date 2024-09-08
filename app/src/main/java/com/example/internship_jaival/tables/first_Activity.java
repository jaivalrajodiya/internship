package com.example.internship_jaival.tables;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.internship_jaival.R;

public class first_Activity extends AppCompatActivity {
    EditText table;
    Button btn;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first2);
        btn = findViewById(R.id.btnstart);
        table = findViewById(R.id.tableno);
        
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (table.length()==0){
                    Toast.makeText(first_Activity.this, "Please Enter The Number", Toast.LENGTH_SHORT).show();
                }else {
                    String multi = table.getText().toString();
                    int i = Integer.valueOf(multi);
                    if (i<=20){
                        Intent intent = new Intent(first_Activity.this,show_table.class);
                        intent.putExtra("tableno",multi);
                        startActivity(intent);

                    }else {
                        Toast.makeText(first_Activity.this, "please Enter number between 1 to 20", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });
    }
}