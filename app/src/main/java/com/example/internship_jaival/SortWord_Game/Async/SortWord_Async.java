package com.example.internship_jaival.SortWord_Game.Async;


import static com.example.internship_jaival.SortWord_Game.Async.SaveSortword_Async.sortwordwinpoint;
import static com.example.internship_jaival.SortWord_Game.sortword_activity.limit;
import static com.example.internship_jaival.SortWord_Game.sortword_activity.maincontitn;
import static com.example.internship_jaival.SortWord_Game.sortword_activity.recyclerView;
import static com.example.internship_jaival.SortWord_Game.sortword_activity.rematchcountdown;
import static com.example.internship_jaival.SortWord_Game.sortword_activity.rematchtime;
import static com.example.internship_jaival.SortWord_Game.sortword_activity.rematchtimer;
import static com.example.internship_jaival.SortWord_Game.sortword_activity.remiderlimt;
import static com.example.internship_jaival.SortWord_Game.sortword_activity.settimer;
import static com.example.internship_jaival.SortWord_Game.sortword_activity.showrematchtimer;
import static com.example.internship_jaival.SortWord_Game.sortword_activity.softwordcountDownTimer;
import static com.example.internship_jaival.SortWord_Game.sortword_activity.startlayout;
import static com.example.internship_jaival.TextTyping_Game.typing_game_1.maintimersec;


import android.app.Activity;
import android.util.Log;
import android.view.View;


import com.example.internship_jaival.SortWord_Game.Adapter.SortwordAdapter;
import com.example.internship_jaival.SortWord_Game.Interface.SortwordInterface;
import com.example.internship_jaival.SortWord_Game.Models.SortWordModel;
import com.example.internship_jaival.SortWord_Game.RetrofitClient.Sortword_retrofit;

import org.json.JSONObject;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SortWord_Async {
    public static JSONObject jsonObject;

   public static ArrayList<String> examplearray = new ArrayList<>();

    public static  String status;
    public SortWord_Async(Activity activity, String user_id){

        try {
            jsonObject = new JSONObject();
            jsonObject.put("user_id",user_id);
            Log.d("json", "" + jsonObject.toString());

            SortwordInterface sortwordInterface = Sortword_retrofit.getRetrofit().create(SortwordInterface.class);
            Call<SortWordModel> call = sortwordInterface.getword(jsonObject.toString());


            call.enqueue(new Callback<SortWordModel>() {
                @Override
                public void onResponse(Call<SortWordModel> call, Response<SortWordModel> response) {

                    SortWordModel model = response.body();

                    limit.setText(String.valueOf(model.getRemainLimit()));
                    remiderlimt.setText(String.valueOf(model.getLimit()));


                    int timer = model.getTimer();
                    String maintimer = String.valueOf(timer) + "000";
                    int finaltimer = Integer.valueOf(maintimer);
                    settimer = finaltimer;

                    examplearray = model.getSortWord();

                    ArrayList<String> arrayList = model.getAnSortWord();
                    SortwordAdapter adapter = new SortwordAdapter(activity,arrayList);
                    recyclerView.setAdapter(adapter);

                    int win = model.getWinpoint();
                    sortwordwinpoint = model.getWinpoint();


                    if (model.getMain_timer()!=null){
                        int mtimer = Integer.valueOf(model.getMain_timer());
                        rematchtime = mtimer * 60000;
                    }


                   status = model.getStatus();

                    if (status.equals("0")){
                        maincontitn.setVisibility(View.GONE);
                        startlayout.setVisibility(View.GONE);
                        rematchtimer.setVisibility(View.VISIBLE);
                        showrematchtimer.setText("Your Toady Limit is Over. Please Try Tomorrow");
                        if (rematchcountdown!=null){
                            rematchcountdown.cancel();
                        }
                        if (softwordcountDownTimer!=null){
                            softwordcountDownTimer.cancel();
                        }
                    }



//                    for (int i = 0; i <arrayList.size() ; i++) {
//                        Log.d("response", "onResponse: "+examplearray.get(i).toString());
//                    }

                }

                @Override
                public void onFailure(Call<SortWordModel> call, Throwable t) {
                    Log.e("data", "onResponse: "+t.getMessage());

                }
            });


        }catch (Exception e){

            Log.e("error", "onResponse: "+e.getMessage());
        }

    }





}
