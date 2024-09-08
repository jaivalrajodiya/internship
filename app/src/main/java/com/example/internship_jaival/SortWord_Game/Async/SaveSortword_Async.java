package com.example.internship_jaival.SortWord_Game.Async;



import android.app.Activity;
import android.util.Log;

import com.example.internship_jaival.SortWord_Game.Interface.SortwordInterface;
import com.example.internship_jaival.SortWord_Game.Models.SaveSortwordModel;
import com.example.internship_jaival.SortWord_Game.Models.SortWordModel;
import com.example.internship_jaival.SortWord_Game.RetrofitClient.Sortword_retrofit;
import com.example.internship_jaival.TextTyping_Game.Interface.TypingInterface;
import com.example.internship_jaival.TextTyping_Game.Models.SaveTextTypingModel;
import com.example.internship_jaival.TextTyping_Game.RetrofitClient.Typing_RetrofitCient;

import org.json.JSONObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SaveSortword_Async {


    JSONObject jsonObject;

    public static int sortwordwinpoint;

    public SaveSortword_Async(Activity activity, String user_id, String score){


        try {

            Log.d("point", "SaveText_Async: "+sortwordwinpoint);
            jsonObject = new JSONObject();
            jsonObject.put("user_id",user_id);
            jsonObject.put("score",score);
            Log.d("json", "" + jsonObject.toString());

            SortwordInterface sortwordInterface = Sortword_retrofit.getRetrofit().create(SortwordInterface.class);
            Call<SaveSortwordModel> call = sortwordInterface.saveword(jsonObject.toString());

            call.enqueue(new Callback<SaveSortwordModel>() {
                @Override
                public void onResponse(Call<SaveSortwordModel> call, Response<SaveSortwordModel> response) {
                    SaveSortwordModel model = response.body();
                }

                @Override
                public void onFailure(Call<SaveSortwordModel> call, Throwable t) {
                    Log.d("fail", "onFailure: "+t.getMessage());
                }
            });


        } catch (Exception e) {
            Log.d("error", "" + e.getMessage());
        }




    }

}
