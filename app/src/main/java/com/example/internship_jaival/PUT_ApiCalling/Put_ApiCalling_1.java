package com.example.internship_jaival.PUT_ApiCalling;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.internship_jaival.R;
import com.example.internship_jaival.search.Serach_Model;
import com.example.internship_jaival.search.search_activity;
import com.example.internship_jaival.search.search_adapter;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Put_ApiCalling_1 extends AppCompatActivity {
    PutApi_Interface putApiInterface;

    GetDataAdapter adapter;

    RecyclerView recyclerView;

    FloatingActionButton floatingActionButton;
    List<Get_Model> list;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_put_api_calling1);
        recyclerView = findViewById(R.id.getapi_rcv);
        floatingActionButton = findViewById(R.id.getdata_btnfloat);

        recyclerView.setLayoutManager(new LinearLayoutManager(Put_ApiCalling_1.this));

         putApiInterface = PutApi_ApiClient.getRetrofit().create(PutApi_Interface.class);
         updatedata();
         getdata();



         floatingActionButton.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 Dialog dialog = new Dialog(Put_ApiCalling_1.this);
                 dialog.setContentView(R.layout.getdata_dialog);
                 dialog.setCancelable(false);

                 EditText firstname = dialog.findViewById(R.id.user_id);
                 EditText emailid = dialog.findViewById(R.id.Id);
                 EditText phoneno = dialog.findViewById(R.id.title);
                 EditText roll = dialog.findViewById(R.id.body);
                 Button btnsubmit = dialog.findViewById(R.id.getData_submit);
                 ImageView close = dialog.findViewById(R.id.getdata_close);

                 close.setOnClickListener(new View.OnClickListener() {
                     @Override
                     public void onClick(View v) {
                         dialog.dismiss();
                     }
                 });

                 btnsubmit.setOnClickListener(new View.OnClickListener() {
                     @Override
                     public void onClick(View v) {
                         String userid = "" , id = "" ,title="",body="";

                         if (!firstname.getText().toString().equals("") &&!roll.getText().toString().equals("") && !emailid.getText().toString().equals("") && !phoneno.getText().toString().equals("")){
                             userid = firstname.getText().toString();
                             id = emailid.getText().toString();
                             title = phoneno.getText().toString();
                             body = roll.getText().toString();

                          postdata(userid,id,title,body);
                             dialog.dismiss();
                         }
                         else {
                             Toast.makeText(Put_ApiCalling_1.this, "Please enter Details", Toast.LENGTH_SHORT).show();
                         }

                     }
                 });
                 dialog.show();
                 Window window = dialog.getWindow();
                 window.setLayout(RecyclerView.LayoutParams.FILL_PARENT, RecyclerView.LayoutParams.WRAP_CONTENT);

             }
         });

    }

    public void getdata(){
        Call<List<Get_Model>> call = putApiInterface.getData();
        call.enqueue(new Callback<List<Get_Model>>() {
            @Override
            public void onResponse(Call<List<Get_Model>> call, Response<List<Get_Model>> response) {


                list = response.body();

                adapter = new GetDataAdapter(Put_ApiCalling_1.this,list);
                recyclerView.setAdapter(adapter);

             //   Log.d("getdata", "onResponse: "+list.get(0).getTitle());


            }

            @Override
            public void onFailure(Call<List<Get_Model>> call, Throwable t) {

//                Toast.makeText(Put_ApiCalling_1.this, "data show error"+t.getMessage(), Toast.LENGTH_SHORT).show();
                Log.d("fail", "onFailure: "+t.getMessage());
            }
        });
    }
    public void updatedata(){
        PutModel putModel = new PutModel(5,"data","hiii");
        Call<PutModel> call = putApiInterface.Putapi(5,putModel);
        call.enqueue(new Callback<PutModel>() {
            @Override
            public void onResponse(Call<PutModel> call, Response<PutModel> response) {
                PutModel putModel1 = response.body();
//                Log.d("response", "onResponse: "+" userid:- " +putModel1.getUserId()+" title:- "  +putModel1.getTitle()+" body:- " +putModel1.getBody());
//                Log.d("TAG", "onResponse: "+response.body());

            }

            @Override
            public void onFailure(Call<PutModel> call, Throwable t) {
                Log.d("fail", "onFailure: "+t.getMessage());
            }
        });
    }

    public void postdata(String userid,String id,String title,String body){
        Get_Model model = new Get_Model(Integer.valueOf(userid),Integer.valueOf(id),title,body);
        Call<Get_Model> call = putApiInterface.postdata(model);

        call.enqueue(new Callback<Get_Model>() {
            @Override
            public void onResponse(Call<Get_Model> call, Response<Get_Model> response) {

                Get_Model model1 = response.body();
                list.add(model1);
                adapter.notifyDataSetChanged();
//                Log.d("postdata", "onResponse: "+model1.getUserId()+model1.getId()+model1.getTitle()+model1.getBody());

//                Log.d("postdata", "onResponse: "+response.body());
            }

            @Override
            public void onFailure(Call<Get_Model> call, Throwable t) {

            }
        });
    }

}