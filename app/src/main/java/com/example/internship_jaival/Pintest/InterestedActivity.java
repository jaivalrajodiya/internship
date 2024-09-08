package com.example.internship_jaival.Pintest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.internship_jaival.R;

import java.util.ArrayList;

public class InterestedActivity extends AppCompatActivity {

    RecyclerView recyclerView;

    ArrayList<InterestedModel> arrayList = new ArrayList<>();

   public static CardView cardView;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interested);


        cardView = findViewById(R.id.btncardview);
        recyclerView = findViewById(R.id.intersted_rcv);

        recyclerView.setLayoutManager(new GridLayoutManager(this,3));
        arrayList.add(new InterestedModel(R.drawable.bigburger,"wallpaper"));
        arrayList.add(new InterestedModel(R.drawable.bigburger,"wallpaper"));
        arrayList.add(new InterestedModel(R.drawable.bigburger,"wallpaper"));
        arrayList.add(new InterestedModel(R.drawable.bigburger,"wallpaper"));
        arrayList.add(new InterestedModel(R.drawable.bigburger,"wallpaper"));
        arrayList.add(new InterestedModel(R.drawable.bigburger,"wallpaper"));
        arrayList.add(new InterestedModel(R.drawable.bigburger,"wallpaper"));
        arrayList.add(new InterestedModel(R.drawable.bigburger,"wallpaper"));
        arrayList.add(new InterestedModel(R.drawable.bigburger,"wallpaper"));
        arrayList.add(new InterestedModel(R.drawable.bigburger,"wallpaper"));
        arrayList.add(new InterestedModel(R.drawable.bigburger,"wallpaper"));
        arrayList.add(new InterestedModel(R.drawable.bigburger,"wallpaper"));
        arrayList.add(new InterestedModel(R.drawable.bigburger,"wallpaper"));
        arrayList.add(new InterestedModel(R.drawable.bigburger,"wallpaper"));
        arrayList.add(new InterestedModel(R.drawable.bigburger,"wallpaper"));
        arrayList.add(new InterestedModel(R.drawable.bigburger,"wallpaper"));
        arrayList.add(new InterestedModel(R.drawable.bigburger,"wallpaper"));
        arrayList.add(new InterestedModel(R.drawable.bigburger,"wallpaper"));

        InterstedAdapter adapter = new InterstedAdapter(this,arrayList);
        recyclerView.setAdapter(adapter);

        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(InterestedActivity.this, "click", Toast.LENGTH_SHORT).show();
            }
        });

    }
}