package com.example.internship_jaival.Ui_Design;



import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.internship_jaival.R;
import com.example.internship_jaival.Ui_Design.Adapter.Movie_Adapter;

import java.util.ArrayList;

public class ui_design_2 extends AppCompatActivity {

    RecyclerView movie_rcv;
    Movie_Adapter movieAdapter;
    ArrayList<Movie_Model> movieArrayList = new ArrayList<>();

    ImageView back;

    TextView title;



    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ui_design2);
        movie_rcv = findViewById(R.id.latestmovie_rcv);
        back = findViewById(R.id.back_imag);
        title = findViewById(R.id.hungama_titile);

        Intent intent = getIntent();
        String tit = intent.getStringExtra("title");

        title.setText(tit);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        movie_rcv.setLayoutManager(new GridLayoutManager(ui_design_2.this, 2));

        movieArrayList.add(new Movie_Model(R.drawable.movie2, "MovieName"));
        movieArrayList.add(new Movie_Model(R.drawable.movie2, "MovieName"));
        movieArrayList.add(new Movie_Model(R.drawable.movie2, "MovieName"));
        movieArrayList.add(new Movie_Model(R.drawable.movie2, "MovieName"));
        movieArrayList.add(new Movie_Model(R.drawable.movie2, "MovieName"));
        movieArrayList.add(new Movie_Model(R.drawable.movie2, "MovieName"));
        movieArrayList.add(new Movie_Model(R.drawable.movie2, "MovieName"));

        movieAdapter = new Movie_Adapter(ui_design_2.this, movieArrayList);
        movie_rcv.setAdapter(movieAdapter);

    }


}