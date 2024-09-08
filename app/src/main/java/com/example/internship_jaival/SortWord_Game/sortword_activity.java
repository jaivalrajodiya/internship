package com.example.internship_jaival.SortWord_Game;

import static com.example.internship_jaival.SortWord_Game.Adapter.SortwordAdapter.reentry;
import static com.example.internship_jaival.SortWord_Game.Async.SaveSortword_Async.sortwordwinpoint;
import static com.example.internship_jaival.SortWord_Game.Async.SortWord_Async.status;
import static com.example.internship_jaival.TextTyping_Game.Async.SaveText_Async.winpoint;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.internship_jaival.R;
import com.example.internship_jaival.SortWord_Game.Adapter.SortwordAdapter;
import com.example.internship_jaival.SortWord_Game.Async.SaveSortword_Async;
import com.example.internship_jaival.SortWord_Game.Async.SortWord_Async;

public class sortword_activity extends AppCompatActivity {

   public static RecyclerView recyclerView;

   public static TextView timer,limit,remiderlimt,starttimer,showrematchtimer;

  public static CountDownTimer softwordcountDownTimer,maintimer,rematchcountdown;

  public static LinearLayout startlayout,rematchtimer,maincontitn;

   public static int settimer,rematchtime;

  public static String u_id = "34";


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sortword);
        recyclerView = findViewById(R.id.sortword_rcv);
        timer = findViewById(R.id.sortword_timer);
        limit = findViewById(R.id.sortword_limit);
        remiderlimt = findViewById(R.id.sortword_reminderlimit);
        starttimer = findViewById(R.id.sortword_starttimer);
        startlayout = findViewById(R.id.sortword_start);
        rematchtimer = findViewById(R.id.sortword_maintimer);
        showrematchtimer = findViewById(R.id.sortword_showrematchtimer);
        maincontitn = findViewById(R.id.sortword_maincontint);


        recyclerView.setLayoutManager(new GridLayoutManager(sortword_activity.this,2));

        new SortWord_Async(sortword_activity.this,u_id);

        softwordcountDownTimer = new CountDownTimer(5000,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                starttimer.setText(""+millisUntilFinished / 1000);
                recyclerView.setVisibility(View.GONE);
            }

            @Override
            public void onFinish() {
                startlayout.setVisibility(View.GONE);
                recyclerView.setVisibility(View.VISIBLE);

                maintimer = new CountDownTimer(settimer,1000) {
                    @Override
                    public void onTick(long millisUntilFinished) {
                        timer.setText("00:00:"+millisUntilFinished / 1000);
                    }

                    @Override
                    public void onFinish() {
                        if (reentry == 0){

                            timer.setText("00:00:30");

                            new SaveSortword_Async(sortword_activity.this,u_id,String.valueOf(sortwordwinpoint));
                            new SortWord_Async(sortword_activity.this,u_id);

                            if (status.equals("0")){

                            }else {
                                Dialog dialog = new Dialog(sortword_activity.this);
                                dialog.setContentView(R.layout.game_dialog);
                                ImageView game_true = dialog.findViewById(R.id.game_lose);
                                TextView game_text = dialog.findViewById(R.id.game_text);
                                Button btnsubmit = dialog.findViewById(R.id.game_btn);

                                game_true.setVisibility(View.VISIBLE);
                                game_text.setText("You are Time Out");

                                btnsubmit.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        dialog.dismiss();
                                        rematchtimer.setVisibility(View.VISIBLE);

                                        rematchcountdown = new CountDownTimer(rematchtime,1000) {
                                            @Override
                                            public void onTick(long millisUntilFinished) {
                                                showrematchtimer.setText("00:00:"+millisUntilFinished / 1000);
                                                for (int i = 0; i < recyclerView.getChildCount(); i++) {
                                                    View child = recyclerView.getChildAt(i);
                                                    child.setOnClickListener(null);

                                                }
                                            }

                                            @Override
                                            public void onFinish() {
                                                rematchtimer.setVisibility(View.GONE);
                                                startlayout.setVisibility(View.VISIBLE);
                                                new SortWord_Async(sortword_activity.this,u_id);
                                                softwordcountDownTimer.start();

                                            }
                                        }.start();


                                    }
                                });
                                dialog.setCancelable(false);
                                dialog.show();
                            }



                        }else {
                            timer.setText("00:00:30");
                            new SaveSortword_Async(sortword_activity.this,u_id,String.valueOf(sortwordwinpoint));
                            new SortWord_Async(sortword_activity.this,u_id);
                            reentry = 0;
                        }
                    }
                }.start();

            }
        }.start();

    }
}