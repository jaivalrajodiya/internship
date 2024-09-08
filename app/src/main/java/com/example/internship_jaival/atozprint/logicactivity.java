package com.example.internship_jaival.atozprint;

import androidx.activity.result.ActivityResult;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.internship_jaival.Bottom_Navigation.Adapter.Adapter;
import com.example.internship_jaival.R;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class logicactivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ArrayList<Character> arrayList = new ArrayList<>();
    TextView textView, txtwin;

    Button btn;
    adapter adapters;

    CountDownTimer countDownTimer;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logicactivity);

        recyclerView = findViewById(R.id.atozrecyclerview);
        btn = findViewById(R.id.btnreset);
        textView = findViewById(R.id.text);
        txtwin = findViewById(R.id.winner);


        recyclerView.setLayoutManager(new GridLayoutManager(this, 4));
        for (char c = 'A'; c <= 'Z'; c++) {
            arrayList.add(c);
        }

        Collections.shuffle(arrayList);


        adapters = new adapter(getApplicationContext(), arrayList);
        recyclerView.setAdapter(adapters);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                txtwin.setText(" ");
                adapters.check = true;
                adapters.notifyDataSetChanged();


                Log.d("check", String.valueOf(adapters.check));
                countDownTimer = new CountDownTimer(30000, 1000) {


                    public void onTick(long millisUntilFinished) {


                        btn.setVisibility(View.GONE);
                        textView.setText("00:00:" + millisUntilFinished / 1000);

                        if (adapters.example.isEmpty()) {
                            countDownTimer.cancel();
                            onFinish();

                        }

                        if (adapters.finish) {
                            countDownTimer.cancel();
                            onFinish();
                            adapters.finish = false;
                            adapters.notifyDataSetChanged();

                        }

                        ActivityResult.resultCodeToString(100);

                    }

                    public void onFinish() {
                        btn.setVisibility(View.VISIBLE);
                        textView.setText("00:00:00");


                        if (adapters.example.isEmpty()) {

                            txtwin.setText("Winner");

                            adapters.check = false;
                            for (char c = 'A'; c <= 'Z'; c++) {
                                adapters.example.add(c);
                                adapters.notifyDataSetChanged();
                            }

                            Collections.shuffle(arrayList);
                            recyclerView.setAdapter(adapters);


                        } else {

                            if (adapters.finish) {
                                txtwin.setText("Wrong click");
                            } else {
                                txtwin.setText("Game Over");
                            }
                            adapters.check = false;
                            adapters.example.clear();
                            for (char c = 'A'; c <= 'Z'; c++) {
                                adapters.example.add(c);
                                adapters.notifyDataSetChanged();
                            }
                            Collections.shuffle(arrayList);
                            recyclerView.setAdapter(adapters);

                        }

                    }
                }.start();


            }
        });


    }


}
