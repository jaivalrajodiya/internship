package com.example.internship_jaival.Ui_Design;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;

import com.example.internship_jaival.R;
import com.example.internship_jaival.Ui_Design.Adapter.Movie_Adapter;
import com.example.internship_jaival.Ui_Design.Adapter.Music_Adapter;
import com.example.internship_jaival.Ui_Design.Adapter.Tvshow_Adapter;
import com.example.internship_jaival.Ui_Design.Adapter.Video_Adapter;

import java.util.ArrayList;

public class ui_design_1 extends AppCompatActivity {
    RecyclerView list_rcv,video_rcv,tv_rcv,movie_rcv;

    Music_Adapter adapter;

    Video_Adapter videoAdapter;

    Tvshow_Adapter tvshowAdapter;

    Movie_Adapter movieAdapter;


    ArrayList<String> arrayList = new ArrayList<>();
    ArrayList<Integer> videoarraylist = new ArrayList<>();
    ArrayList<TvShow_Model> tvshowarraylist = new ArrayList<>();
    ArrayList<Movie_Model> movieArrayList = new ArrayList<>();


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ui_design1);

        list_rcv = findViewById(R.id.list_rcv);
        video_rcv = findViewById(R.id.hasratein_rcv);
        tv_rcv = findViewById(R.id.tvshow_rcv);
        movie_rcv = findViewById(R.id.movie_rcv);

        LinearLayoutManager layoutManager = new LinearLayoutManager(ui_design_1.this,LinearLayoutManager.HORIZONTAL,false);
        LinearLayoutManager layoutManager1 = new LinearLayoutManager(ui_design_1.this,LinearLayoutManager.HORIZONTAL,false);
        LinearLayoutManager layoutManager2 = new LinearLayoutManager(ui_design_1.this,LinearLayoutManager.HORIZONTAL,false);
        LinearLayoutManager layoutManager3 = new LinearLayoutManager(ui_design_1.this,LinearLayoutManager.HORIZONTAL,false);
        list_rcv.setLayoutManager(layoutManager);
        video_rcv.setLayoutManager(layoutManager1);
        tv_rcv.setLayoutManager(layoutManager2);
        movie_rcv.setLayoutManager(layoutManager3);

       arrayList.add("All");
       arrayList.add("Movies");
       arrayList.add("Shows");
       arrayList.add("Original");
       arrayList.add("Real");

       videoarraylist.add(R.drawable.h1);
       videoarraylist.add(R.drawable.h1);
       videoarraylist.add(R.drawable.h1);
       videoarraylist.add(R.drawable.h1);
       videoarraylist.add(R.drawable.h1);
       videoarraylist.add(R.drawable.h1);
       videoarraylist.add(R.drawable.h1);


       tvshowarraylist.add(new TvShow_Model(R.drawable.tv1,"SWAANNG"));
       tvshowarraylist.add(new TvShow_Model(R.drawable.tv1,"SWAANNG"));
       tvshowarraylist.add(new TvShow_Model(R.drawable.tv1,"SWAANNG"));
       tvshowarraylist.add(new TvShow_Model(R.drawable.tv1,"SWAANNG"));
       tvshowarraylist.add(new TvShow_Model(R.drawable.tv1,"SWAANNG"));
       tvshowarraylist.add(new TvShow_Model(R.drawable.tv1,"SWAANNG"));
       tvshowarraylist.add(new TvShow_Model(R.drawable.tv1,"SWAANNG"));
       tvshowarraylist.add(new TvShow_Model(R.drawable.tv1,"SWAANNG"));


       movieArrayList.add(new Movie_Model(R.drawable.movie2,"MovieName"));
       movieArrayList.add(new Movie_Model(R.drawable.movie2,"MovieName"));
       movieArrayList.add(new Movie_Model(R.drawable.movie2,"MovieName"));
       movieArrayList.add(new Movie_Model(R.drawable.movie2,"MovieName"));
       movieArrayList.add(new Movie_Model(R.drawable.movie2,"MovieName"));
       movieArrayList.add(new Movie_Model(R.drawable.movie2,"MovieName"));
       movieArrayList.add(new Movie_Model(R.drawable.movie2,"MovieName"));


       adapter = new Music_Adapter(ui_design_1.this,arrayList);
       list_rcv.setAdapter(adapter);

        videoAdapter = new Video_Adapter(ui_design_1.this,videoarraylist);
        video_rcv.setAdapter(videoAdapter);

        tvshowAdapter = new Tvshow_Adapter(ui_design_1.this,tvshowarraylist);
        tv_rcv.setAdapter(tvshowAdapter);

        movieAdapter= new Movie_Adapter(ui_design_1.this,movieArrayList);
        movie_rcv.setAdapter(movieAdapter);

    }



    }
