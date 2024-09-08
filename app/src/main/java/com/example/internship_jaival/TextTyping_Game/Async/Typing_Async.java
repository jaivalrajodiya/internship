package com.example.internship_jaival.TextTyping_Game.Async;

import static com.example.internship_jaival.TextTyping_Game.Async.SaveText_Async.winpoint;
import static com.example.internship_jaival.TextTyping_Game.typing_game_1.countDownTimer1;
import static com.example.internship_jaival.TextTyping_Game.typing_game_1.limit;
import static com.example.internship_jaival.TextTyping_Game.typing_game_1.maintimer;
import static com.example.internship_jaival.TextTyping_Game.typing_game_1.maintimersec;

import static com.example.internship_jaival.TextTyping_Game.typing_game_1.reminder_limit;
import static com.example.internship_jaival.TextTyping_Game.typing_game_1.show_maintimer;
import static com.example.internship_jaival.TextTyping_Game.typing_game_1.startgame;
import static com.example.internship_jaival.TextTyping_Game.typing_game_1.text;
import static com.example.internship_jaival.TextTyping_Game.typing_game_1.timersecond;


import android.app.Activity;
import android.util.Log;
import android.view.View;

import com.example.internship_jaival.TextTyping_Game.Interface.TypingInterface;
import com.example.internship_jaival.TextTyping_Game.Models.TypingModel;
import com.example.internship_jaival.TextTyping_Game.RetrofitClient.Typing_RetrofitCient;
import com.example.internship_jaival.TextTyping_Game.typing_game_1;

import org.json.JSONObject;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Typing_Async {
    public static JSONObject jsonObject;

    public static String textshow;







    public Typing_Async(Activity activity,String user_id){

        try {
            jsonObject = new JSONObject();
            jsonObject.put("user_id",user_id);
            Log.d("json", "" + jsonObject.toString());

            TypingInterface typingInterface = Typing_RetrofitCient.getRetrofit().create(TypingInterface.class);
            Call<TypingModel> call = typingInterface.gettext(jsonObject.toString());

            call.enqueue(new Callback<TypingModel>() {
                @Override
                public void onResponse(Call<TypingModel> call, Response<TypingModel> response) {
                   TypingModel model = response.body();


                    textshow = model.getText();
                    text.setText(model.getText());
                    reminder_limit.setText(String.valueOf(model.getRemainLimit()));
                    limit.setText(String.valueOf(model.getLimit()));
                    int second = model.getTimer();
                    String timer = String.valueOf(second)+"000";
                    int finalsecond = Integer.valueOf(timer);

                    if (model.getMain_timer()!=null){
                        int mtimer = Integer.valueOf(model.getMain_timer());
                        maintimersec = mtimer * 60000;
                    }



                    String remainder = model.getStatus();

                    if (remainder.equals("0")){
                        startgame.setVisibility(View.GONE);
                        maintimer.setVisibility(View.VISIBLE);
                        show_maintimer.setText("Your Toady Limit is Over. Please Try Tomorrow");
                        if (countDownTimer1 !=null){
                            countDownTimer1.cancel();
                        }

                    }

                    Log.d("data", "onResponse: "+model.getWinponint());
                    Log.d("data", "onResponse: "+model.getMessage());

                    int winingpoint = model.getWinponint();


                    timersecond = finalsecond;
                    winpoint = winingpoint;
                    Log.d("winpoinrt", "onResponse: "+winpoint);
                    Log.d("data", "onResponse: "+model.getText());

                }

                @Override
                public void onFailure(Call<TypingModel> call, Throwable t) {
                    Log.e("data", "onResponse: "+t.getMessage());

                }
            });


        }catch (Exception e){
            Log.e("error", "onResponse: "+e.getMessage());
        }

    }
}
