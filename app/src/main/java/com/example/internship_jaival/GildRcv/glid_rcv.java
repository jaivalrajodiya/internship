package com.example.internship_jaival.GildRcv;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;

import com.example.internship_jaival.R;

import java.util.ArrayList;

public class glid_rcv extends AppCompatActivity {

    RecyclerView recyclerView;

    ArrayList<String> arrayList = new ArrayList<>();

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_glid_rcv);
        recyclerView = findViewById(R.id.glid_rcv);

        for (int i = 0; i <=50 ; i++) {
            arrayList.add(String.valueOf(i));
        }

        GridLayoutManager gridLayoutManager = new GridLayoutManager(this,2);

        gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                if ((position+1) % 5 * 2 == 0){
                    return 2;
                }else {
                    return 1;
                }
            }
        });

        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setAdapter(new Gild_Adapter(arrayList));

    }
}