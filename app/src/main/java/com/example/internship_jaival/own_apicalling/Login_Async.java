package com.example.internship_jaival.own_apicalling;

import android.app.Activity;
import android.util.Log;
import android.widget.Toast;


import org.json.JSONObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Login_Async {

    public static JSONObject jsonObject;

    public Login_Async(Activity activity) {

        try {
            jsonObject = new JSONObject();
            jsonObject.put("firstname", "123");
            jsonObject.put("lastname","123");
            jsonObject.put("email", "123");
            jsonObject.put("reffercode", "123");
            jsonObject.put("photo", "123");


            Log.d("json", "" + jsonObject.toString());
            ApiInterface apiInterface = RetrofitCient.getRetrofit().create(ApiInterface.class);
            Call<MainModel_ownapi> call = apiInterface.insertdata(jsonObject.toString());

            call.enqueue(new Callback<MainModel_ownapi>() {
                @Override
                public void onResponse(Call<MainModel_ownapi> call, Response<MainModel_ownapi> response) {
                    Log.e("status", "onResponse: "+response.body().getStatus());
                    Log.e("status", "onResponse: "+response.body().getMessage());

                    Toast.makeText(activity, response.body().getStatus(), Toast.LENGTH_SHORT).show();
                    Toast.makeText(activity, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                }

                @Override
                public void onFailure(Call<MainModel_ownapi> call, Throwable t) {

                }
            });

        } catch (Exception e) {

        }
    }

}
