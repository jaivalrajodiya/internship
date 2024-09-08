package com.example.internship_jaival.TextTyping_Game.Async;



import android.app.Activity;
import android.util.Log;

import com.example.internship_jaival.TextTyping_Game.Interface.TypingInterface;
import com.example.internship_jaival.TextTyping_Game.Models.SaveTextTypingModel;
import com.example.internship_jaival.TextTyping_Game.Models.TypingModel;
import com.example.internship_jaival.TextTyping_Game.RetrofitClient.Typing_RetrofitCient;
import com.google.gson.JsonObject;

import org.json.JSONException;
import org.json.JSONObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SaveText_Async {


    JSONObject jsonObject;

    public static int winpoint;

    public SaveText_Async(Activity activity, String user_id, String score){


        try {

            Log.d("point", "SaveText_Async: "+winpoint);
            jsonObject = new JSONObject();
            jsonObject.put("user_id",user_id);
            jsonObject.put("score",score);
            Log.d("json", "" + jsonObject.toString());

            TypingInterface typingInterface = Typing_RetrofitCient.getRetrofit().create(TypingInterface.class);
            Call<SaveTextTypingModel> call = typingInterface.savetext(jsonObject.toString());

            call.enqueue(new Callback<SaveTextTypingModel>() {
                @Override
                public void onResponse(Call<SaveTextTypingModel> call, Response<SaveTextTypingModel> response) {
                    SaveTextTypingModel model = response.body();

                    Log.d("savetext", "onResponse: "+model.getStatus());
                }

                @Override
                public void onFailure(Call<SaveTextTypingModel> call, Throwable t) {

                    Log.d("fail", "onFailure: "+t.getMessage());

                }
            });



        } catch (Exception e) {
            Log.d("error", "" + e.getMessage());
        }


    }

}
