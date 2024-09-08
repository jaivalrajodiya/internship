package com.example.internship_jaival.Bottom_Navigation;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.app.Activity;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.internship_jaival.Bottom_Navigation.fragment.AboutmeFragment;
import com.example.internship_jaival.Bottom_Navigation.fragment.HomeFragment;
import com.example.internship_jaival.Bottom_Navigation.fragment.TaskFragment;
import com.example.internship_jaival.R;
import com.example.internship_jaival.databinding.ActivityFirstBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.google.android.material.navigation.NavigationView;

public class firstActivity extends AppCompatActivity {


    DrawerLayout drawerLayout;
    NavigationView navigationView;

    BottomNavigationView bottomNavigationView;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);


        drawerLayout = findViewById(R.id.drawerlayout);
        navigationView = findViewById(R.id.navigaton_view);
        toolbar = findViewById(R.id.toolbar);
        bottomNavigationView = findViewById(R.id.bottomNavigationView);

        setSupportActionBar(toolbar);


        ActionBarDrawerToggle toggle =new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.openDrawer,R.string.closeDrawer);

        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        loadfragment(new HomeFragment());
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();

                if (id == R.id.home){
                    loadfragment(new HomeFragment());
                } else if (id == R.id.Task) {
                    loadfragment(new TaskFragment());
                }else if (id == R.id.aboutme) {
                    loadfragment(new AboutmeFragment());
                }

                drawerLayout.closeDrawer(GravityCompat.START);

                return true;

            }
        });

        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();

                if (id == R.id.home){
                    loadfragment(new HomeFragment());
                } else if (id == R.id.Task) {
                    loadfragment(new TaskFragment());
                }else if (id == R.id.aboutme) {
                    loadfragment(new AboutmeFragment());
                }

                drawerLayout.closeDrawer(GravityCompat.START);

                return true;


            }
        });


    }
    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }else{
            super.onBackPressed();
        }
    }

    private void loadfragment(Fragment fragment) {


        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();

        ft.replace(R.id.container,fragment);
        ft.commit();

    }


}