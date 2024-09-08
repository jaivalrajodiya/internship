package com.example.internship_jaival.gole_counter;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.internship_jaival.R;

public class plush_counter extends AppCompatActivity {
    Button a3,a5,a1,b3,b5,b1,btnreset;

    int scorea=0,scoreb=0;

    TextView txtscorea,txtscoreb,txtwin;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plush_counter);

        txtscorea = findViewById(R.id.teamascore);
        txtscoreb = findViewById(R.id.teambscore);
        txtwin = findViewById(R.id.win);
        a3 = findViewById(R.id.a3pluse);
        a5 = findViewById(R.id.a5pluse);
        a1 = findViewById(R.id.a1pluse);
        b3 = findViewById(R.id.b3pluse);
        b5 = findViewById(R.id.b5pluse);
        b1 = findViewById(R.id.b1pluse);
        btnreset = findViewById(R.id.reset);

        a3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                scorea += 3;
                checka();
                updateScoreA();

            }
        });
        a5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                scorea += 5;
                checka();
                updateScoreA();

            }
        });
        a1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                scorea += 1;
                checka();
                updateScoreA();

            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                scoreb += 3;
                checkb();
                updateScoreA();

            }
        });
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                scoreb += 5;
                checkb();
                updateScoreA();

            }
        });
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                scoreb+= 1;
                checkb();
                updateScoreA();

            }
        });

        btnreset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                scorea=0;
                scoreb=0;
                txtwin.setVisibility(View.GONE);
                updateScoreA();
                updateScoreB();
            }
        });



    }

    public void updateScoreA() {
        txtscorea.setText(String.valueOf(scorea));
    }

    public void updateScoreB() {
        txtscoreb.setText(String.valueOf(scoreb));
}

public void checka(){
    if(scorea>=30){

        scoreb=0;
        scorea=0;
        txtwin.getVisibility();
        txtwin.setText("TEAM- A IS WIN");

    }
}
    public void checkb(){
        if(scoreb>=30){
            scoreb=0;
            scorea=0;
            txtwin.setVisibility(View.VISIBLE);
            txtwin.setText("TEAM- B IS WIN");
        }
    }

}