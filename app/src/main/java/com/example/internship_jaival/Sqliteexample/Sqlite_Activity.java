package com.example.internship_jaival.Sqliteexample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.internship_jaival.R;
import com.example.internship_jaival.search.search_activity;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class Sqlite_Activity extends AppCompatActivity {

    RecyclerView recyclerView;
    TruthAdapter adapter;
    MyDBHelper myDBHelper;

    FloatingActionButton floatingActionButton;

  public static TextView nodatafound;
    ImageView back;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sqlite);
        floatingActionButton = findViewById(R.id.btntruthfloat);
        nodatafound = findViewById(R.id.truth_nodatafound);

        back = findViewById(R.id.back_truth);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });



        myDBHelper = new MyDBHelper(Sqlite_Activity.this);
        ArrayList<StudentDataModel> arrayList = myDBHelper.fetchStudentData();
//        myDBHelper.addstudent_data("truth");
//        myDBHelper.addstudent_data("tru");



        recyclerView = findViewById(R.id.truthanddarercv);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        adapter = new TruthAdapter(Sqlite_Activity.this,arrayList);

        recyclerView.setAdapter(adapter);

        if(adapter.getItemCount() == 0){

            nodatafound.setVisibility(View.VISIBLE);

        }else {
            nodatafound.setVisibility(View.GONE);

        }


        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dialog dialog = new Dialog(Sqlite_Activity.this);
                dialog.setContentView(R.layout.truthdare_dialog);

                EditText title = dialog.findViewById(R.id.enter_title);
                Button btnsubmit = dialog.findViewById(R.id.truthdare_submit);
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
                            adapter = new TruthAdapter(Sqlite_Activity.this,arrayList1);
                            adapter.notifyDataSetChanged();
                            recyclerView.setAdapter(adapter);
                            if(adapter.getItemCount() == 0){

                                nodatafound.setVisibility(View.VISIBLE);

                            }else {
                                nodatafound.setVisibility(View.GONE);

                            }

                            dialog.dismiss();
                        }else {
                            Toast.makeText(Sqlite_Activity.this, "Please enter Detail", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
                dialog.show();
                Window window = dialog.getWindow();
                window.setLayout(RecyclerView.LayoutParams.FILL_PARENT, RecyclerView.LayoutParams.WRAP_CONTENT);



            }
        });


//        StudentDataModel model = new StudentDataModel();
//        model.id = 1;
//        model.name = "jainik";
//        model.roll_no = "101";
//        model.phone_no = "99999999";
//        myDBHelper.updatestudentdata(model);

//        myDBHelper.deleteStudentData(1);

//        myDBHelper.addstudent_data("jaival","1","1234567890");
//        myDBHelper.addstudent_data("jaiva","2","123456789");
//        myDBHelper.addstudent_data("jaiv","3","12345678");
//        myDBHelper.addstudent_data("jai","4","1234567");

//        ArrayList<StudentDataModel> arrayList = myDBHelper.fetchStudentData();
//
//        for (int i = 0; i < arrayList.size(); i++) {
//            Log.d("StudentData", "id:-"+arrayList.get(i).id + "name:-"+arrayList.get(i).name + "Roll_no:-" + arrayList.get(i).roll_no+ "Phone_no:-" + arrayList.get(i).phone_no );
//        }

    }

}