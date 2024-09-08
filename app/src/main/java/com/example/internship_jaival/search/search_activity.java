package com.example.internship_jaival.search;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.internship_jaival.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class search_activity extends AppCompatActivity {

    RecyclerView recyclerView;

    ArrayList<Serach_Model> arrayList = new ArrayList<>();

    SearchView searchView;

    search_adapter adapter;

    FloatingActionButton floatingActionButton;

    TextView txt;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        searchView = findViewById(R.id.serchview);
        searchView.clearFocus();
        recyclerView = findViewById(R.id.serach_rec);
        txt = findViewById(R.id.nodata);
        floatingActionButton = findViewById(R.id.btnfloat);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
              filterList(newText);
                return true;
            }
        });

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        if (arrayList.isEmpty()){
            recyclerView.setVisibility(View.GONE);
            txt.setVisibility(View.VISIBLE);
        }


        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Dialog dialog = new Dialog(search_activity.this);
                dialog.setContentView(R.layout.search_dialog);

                EditText firstname = dialog.findViewById(R.id.fname);
                EditText emailid = dialog.findViewById(R.id.email);
                EditText phoneno = dialog.findViewById(R.id.phone);
                EditText roll = dialog.findViewById(R.id.rollno);
                Button btnsubmit = dialog.findViewById(R.id.submit);

                btnsubmit.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        String name = "" , email = "" ,phone="",rollno="";

                        if (!firstname.getText().toString().equals("") &&!roll.getText().toString().equals("") && !emailid.getText().toString().equals("") && !phoneno.getText().toString().equals("")){
                            name = firstname.getText().toString();
                            email = emailid.getText().toString();
                            phone = phoneno.getText().toString();
                            rollno = roll.getText().toString();

                            arrayList.add(new Serach_Model(name,rollno,email,phone));
//                            adapter.notifyItemInserted(arrayList.size()-1);
//                            recyclerView.scrollToPosition(arrayList.size()-1);
                            adapter = new search_adapter(getApplicationContext(),arrayList);
                            recyclerView.setAdapter(adapter);
                            recyclerView.setVisibility(View.VISIBLE);
                            txt.setVisibility(View.GONE);
                            dialog.dismiss();
                        }
                        else {
                            Toast.makeText(search_activity.this, "Please enter Details", Toast.LENGTH_SHORT).show();
                        }






                    }
                });
                dialog.show();
                Window window = dialog.getWindow();
                window.setLayout(RecyclerView.LayoutParams.FILL_PARENT, RecyclerView.LayoutParams.WRAP_CONTENT);



            }
        });




    }

    private void filterList(String newText) {
    ArrayList<Serach_Model> filtedarray = new ArrayList<>();
    for (Serach_Model item : arrayList){
        if (item.getName().toLowerCase().contains(newText.toLowerCase())){
            filtedarray.add(item);
        }
    }

    if (filtedarray.isEmpty()){
        recyclerView.setVisibility(View.GONE);
        txt.setVisibility(View.VISIBLE);
    }else{
        recyclerView.setVisibility(View.VISIBLE);
        txt.setVisibility(View.GONE);
        adapter.setFiltederdlist(filtedarray);
    }
    }
}