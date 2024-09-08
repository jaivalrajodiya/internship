package com.example.internship_jaival.Sqliteexample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.internship_jaival.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class dare extends AppCompatActivity {

    RecyclerView recyclerView;
    DareAdapter adapter;
    MyDBHelper1 myDBHelper;

    FloatingActionButton floatingActionButton;

    ImageView back;
    public static TextView dare_nodatafound;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dare);

        floatingActionButton = findViewById(R.id.btndarefloat);
        dare_nodatafound = findViewById(R.id.dare_nodatafound);
        back = findViewById(R.id.back_dare);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });


        myDBHelper = new MyDBHelper1(dare.this);
        ArrayList<StudentDataModel> arrayList = myDBHelper.fetchStudentData();
//        myDBHelper.addstudent_data("hii");

        recyclerView = findViewById(R.id.darercv);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        adapter = new DareAdapter(dare.this,arrayList);

        recyclerView.setAdapter(adapter);

        if(adapter.getItemCount() == 0){

            dare_nodatafound.setVisibility(View.VISIBLE);

        }else {
            dare_nodatafound.setVisibility(View.GONE);

        }


        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dialog dialog = new Dialog(dare.this);
                dialog.setContentView(R.layout.truthdare_dialog);

                EditText title = dialog.findViewById(R.id.enter_title);
                Button btnsubmit = dialog.findViewById(R.id.truthdare_submit);
                TextView textView = dialog.findViewById(R.id.dare_text);
                textView.setText("Enter the Dare");
                ImageView close = dialog.findViewById(R.id.close_img);
                dialog.setCancelable(false);

                close.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });

                btnsubmit.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (!title.getText().toString().isEmpty()){


                            myDBHelper.addstudent_data(title.getText().toString());
                            ArrayList<StudentDataModel> arrayList1 = myDBHelper.fetchStudentData();
                            adapter = new DareAdapter(dare.this,arrayList1);
                            adapter.notifyDataSetChanged();
                            recyclerView.setAdapter(adapter);
                            if(adapter.getItemCount() == 0){

                                dare_nodatafound.setVisibility(View.VISIBLE);

                            }else {
                                dare_nodatafound.setVisibility(View.GONE);

                            }
                            dialog.dismiss();
                        }else {
                            Toast.makeText(dare.this, "Please enter Detail", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
                dialog.show();
                Window window = dialog.getWindow();
                window.setLayout(RecyclerView.LayoutParams.FILL_PARENT, RecyclerView.LayoutParams.WRAP_CONTENT);



            }
        });


    }
}