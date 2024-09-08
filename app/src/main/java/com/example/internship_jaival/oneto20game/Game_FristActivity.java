package com.example.internship_jaival.oneto20game;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.internship_jaival.MainActivity;
import com.example.internship_jaival.R;
import com.example.internship_jaival.search.search_activity;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Game_FristActivity extends AppCompatActivity {

    TextView startTime;

    RecyclerView recyclerView;

    ArrayList<String> arrayList = new ArrayList<>();
    GameAdapter gameAdapter;

    EditText etnumber;
    Dialog dialog;

    Button btnsub;
    TextView countdown_timer;
    String randomnumber;

    int getradomnumber;

    int status = 0;

    CountDownTimer countDownTimer,countDownTimer1;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_frist);
        startTime = findViewById(R.id.start_time_text);
        recyclerView = findViewById(R.id.oneto20recyclerview);
        countdown_timer = findViewById(R.id.countdown_time);
        etnumber = findViewById(R.id.enternumber);
        btnsub = findViewById(R.id.game_submit);

        recyclerView.setLayoutManager(new GridLayoutManager(this, 4));



        random();

        startGame();
    }

    public void startGame(){
     countDownTimer1 =  new CountDownTimer(4000, 1000) {

            public void onTick(long millisUntilFinished) {

                recyclerView.setVisibility(View.GONE);
                etnumber.setVisibility(View.GONE);
                btnsub.setVisibility(View.GONE);
                startTime.setVisibility(View.VISIBLE);
                if (millisUntilFinished / 1000==0){
                    startTime.setText("Start");
                    countdown_timer.setText("00:00:00");
                }else {
                    startTime.setText(""+millisUntilFinished / 1000);
                    countdown_timer.setText("00:00:00");
                }


            }

            public void onFinish() {

              gameAdapter = new GameAdapter(Game_FristActivity.this,arrayList);
              recyclerView.setVisibility(View.VISIBLE);
              etnumber.setVisibility(View.VISIBLE);
              btnsub.setVisibility(View.VISIBLE);
              recyclerView.setAdapter(gameAdapter);
              startTime.setVisibility(View.GONE);

           countDownTimer =   new CountDownTimer(30000,1000){

                  @Override
                  public void onTick(long millisUntilFinished) {
                      countdown_timer.setText("00:00:"+millisUntilFinished / 1000);
                      btnsub.setOnClickListener(new View.OnClickListener() {
                          @Override
                          public void onClick(View v) {
                              String getnumber = etnumber.getText().toString();
                              countDownTimer.cancel();
                              if (!etnumber.getText().toString().isEmpty()){

                                  if (getnumber.equals(randomnumber)){
                                      dialog = new Dialog(Game_FristActivity.this);
                                      dialog.setContentView(R.layout.game_dialog);
                                      ImageView game_true = dialog.findViewById(R.id.game_true);
                                      Button btnsubmit = dialog.findViewById(R.id.game_btn);

                                      status =1;
                                      game_true.setVisibility(View.VISIBLE);

                                      btnsubmit.setOnClickListener(new View.OnClickListener() {
                                          @Override
                                          public void onClick(View v) {
                                              countDownTimer.cancel();
                                              onFinish();
                                              dialog.dismiss();
                                              status =0;
                                          }
                                      });
                                      dialog.setCancelable(false);
                                      dialog.show();



                                  }else {
                                      dialog = new Dialog(Game_FristActivity.this);
                                      dialog.setContentView(R.layout.game_dialog);
                                      ImageView game_true = dialog.findViewById(R.id.game_lose);
                                      TextView game_text = dialog.findViewById(R.id.game_text);
                                      Button btnsubmit = dialog.findViewById(R.id.game_btn);

                                      status =1;
                                      game_true.setVisibility(View.VISIBLE);
                                      game_text.setText("You are Fail");

                                      btnsubmit.setOnClickListener(new View.OnClickListener() {
                                          @Override
                                          public void onClick(View v) {
                                              countDownTimer.cancel();
                                              onFinish();
                                              dialog.dismiss();
                                              status =0;
                                          }
                                      });
                                      dialog.setCancelable(false);
                                      dialog.show();

                                  }
                              }else {
                                  Toast.makeText(Game_FristActivity.this, "Enter the Number", Toast.LENGTH_SHORT).show();
                              }
                          }
                      });
                  }

                  @Override
                  public void onFinish() {

                      if (status==1){
                          countDownTimer1.onTick(4000);
                          countDownTimer1.start();
                          etnumber.setText("");
                          arrayList.removeAll(arrayList);
                          random();
                          gameAdapter = new GameAdapter(Game_FristActivity.this,arrayList);
                          recyclerView.setAdapter(gameAdapter);
                      }else {
                          dialog = new Dialog(Game_FristActivity.this);
                          dialog.setContentView(R.layout.game_dialog);
                          ImageView game_true = dialog.findViewById(R.id.game_lose);
                          TextView game_text = dialog.findViewById(R.id.game_text);
                          Button btnsubmit = dialog.findViewById(R.id.game_btn);

                          game_true.setVisibility(View.VISIBLE);
                          game_true.setImageResource(R.drawable.timeout);

                          status =1;
                          game_text.setText("You Time Out");

                          btnsubmit.setOnClickListener(new View.OnClickListener() {
                              @Override
                              public void onClick(View v) {
                                  countDownTimer.cancel();
                                  onFinish();
                                  dialog.dismiss();
                                  status =0;
                              }
                          });

                          dialog.setCancelable(false);
                          dialog.show();

                      }

                  }
              }.start();

            }

        }.start();

    }
    public void random(){
        for (int i = 1; i <=20 ; i++) {
            arrayList.add(String.valueOf(i));
        }

        Random random = new Random();
        getradomnumber = random.nextInt(arrayList.size());
        String ren = String.valueOf(getradomnumber);

        for (int i = 0; i <arrayList.size(); i++) {
            if (arrayList.get(i).equals(ren)) {
                randomnumber = arrayList.get(i).toString();
                Log.d("TAG", "onCreate: "+arrayList.get(i).toString());
                arrayList.remove(i);
                arrayList.add(" ");
                Collections.shuffle(arrayList);
            }
        }

    }

    @Override
    protected void onRestart() {
        super.onRestart();
        status =1;
        dialog.dismiss();
        countDownTimer.cancel();
        countDownTimer.onFinish();
        status =0;


    }
}