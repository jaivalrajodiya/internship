package com.example.internship_jaival.TextTyping_Game;




import static com.example.internship_jaival.TextTyping_Game.Async.SaveText_Async.winpoint;
import static com.example.internship_jaival.TextTyping_Game.Async.Typing_Async.textshow;



import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.internship_jaival.R;
import com.example.internship_jaival.TextTyping_Game.Async.SaveText_Async;
import com.example.internship_jaival.TextTyping_Game.Async.Typing_Async;
import com.example.internship_jaival.TextTyping_Game.Models.TypingModel;

public class typing_game_1 extends AppCompatActivity {

    public static TextView limit,reminder_limit,text,timer,show_maintimer;
    EditText typetext;

    Button submit;


    int check = 0;

    public static int timersecond;

    public static  int maintimersec;





   public static  CountDownTimer countDownTimer,countDownTimer1;

   public static LinearLayout maintimer , startgame;

    String user_id = "32";

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_typing_game1);

        limit = findViewById(R.id.texttyping_limit);
        reminder_limit = findViewById(R.id.texttyping_reminderlimt);
        text = findViewById(R.id.texttyping_text);
        timer = findViewById(R.id.texttyping_timer);
        typetext = findViewById(R.id.texttyping_checktext);
        submit = findViewById(R.id.texttyping_submit);
        maintimer = findViewById(R.id.typing_maintimer);
        startgame = findViewById(R.id.typing_stargame);
        show_maintimer = findViewById(R.id.typing_showmaintimer);



        new Typing_Async(typing_game_1.this,user_id);








        typetext.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (check == 0){
                    check = 1;
                    countDownTimer = new  CountDownTimer(timersecond,1000){
                        @Override
                        public void onTick(long millisUntilFinished) {

                            timer.setText("00:00:"+millisUntilFinished / 1000);

                            submit.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    if (!typetext.getText().toString().isEmpty()){

                                        String checktext = typetext.getText().toString();


                                        if (checktext.equals(textshow)){
                                            Toast.makeText(typing_game_1.this, "Winner", Toast.LENGTH_SHORT).show();
                                            Toast.makeText(typing_game_1.this, ""+textshow, Toast.LENGTH_SHORT).show();
                                            countDownTimer.cancel();
                                            onFinish();
                                        }else {
                                            Toast.makeText(typing_game_1.this, "BettterLuckNestTime", Toast.LENGTH_SHORT).show();
                                            countDownTimer.cancel();
                                            onFinish();
                                        }

                                    }else {
                                        Toast.makeText(typing_game_1.this, "Please enter text", Toast.LENGTH_SHORT).show();
                                    }
                                }
                            });


                        }

                        @Override
                        public void onFinish() {
                            typetext.setText("");
                            submit.setEnabled(false);
                            typetext.setEnabled(false);
                            maintimer.setVisibility(View.VISIBLE);
                            new SaveText_Async(typing_game_1.this,user_id,String.valueOf(winpoint));
                            new Typing_Async(typing_game_1.this,user_id);
                            countDownTimer1 =  new CountDownTimer(maintimersec,1000) {
                                @Override
                                public void onTick(long millisUntilFinished) {
                                    show_maintimer.setText("00:00:"+millisUntilFinished / 1000);
                                }

                                @Override
                                public void onFinish() {
                                        submit.setEnabled(true);
                                        typetext.setEnabled(true);
                                        maintimer.setVisibility(View.GONE);
                                        typetext.setText("");
                                        timer.setText("00:00:15");
                                        new Typing_Async(typing_game_1.this,user_id);
                                        check =0;


                                }
                            }.start();


                        }
                    }.start();

                }
            }
        });



    }






}