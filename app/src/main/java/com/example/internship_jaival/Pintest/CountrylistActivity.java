package com.example.internship_jaival.Pintest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.internship_jaival.R;

import java.util.ArrayList;
import java.util.Locale;

public class CountrylistActivity extends AppCompatActivity {

    RecyclerView recyclerView;

    Countrylist_Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_countrylist);

        recyclerView = findViewById(R.id.show_country_name_rcv);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        Locale[] locales = Locale.getAvailableLocales();
        ArrayList<String> countries = new ArrayList<String>();
        for (Locale locale : locales) {
            String country = locale.getDisplayCountry();
            if (country.trim().length()>0 && !countries.contains(country)) {
                countries.add(country);
            }
        }

        adapter = new Countrylist_Adapter(this,countries);
        recyclerView.setAdapter(adapter);
    }
}