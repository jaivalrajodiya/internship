package com.example.internship_jaival.instragram;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.internship_jaival.Bottom_Navigation.fragment.AboutmeFragment;
import com.example.internship_jaival.Bottom_Navigation.fragment.HomeFragment;
import com.example.internship_jaival.Bottom_Navigation.fragment.TaskFragment;
import com.example.internship_jaival.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class bottom extends AppCompatActivity {


    BottomNavigationView bottomNavigationView;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom);

        bottomNavigationView = findViewById(R.id.insta_bottomNavigationView);

        loadfragment(new insta_home_fragment());

        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();

                if (id == R.id.insta_home){
                    loadfragment(new insta_home_fragment());
                } else if (id == R.id.insta_profile) {
                    loadfragment(new insta_profile_fragment());


                }


                return true;


            }
        });


    }

    private void loadfragment(Fragment fragment) {


        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();

        ft.replace(R.id.insta_container,fragment);
        ft.commit();

    }
}