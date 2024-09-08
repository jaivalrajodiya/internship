package com.example.internship_jaival.Layout_Inflater;

import static com.example.internship_jaival.Layout_Inflater.check_Type.TYPE_EARNGRID;
import static com.example.internship_jaival.Layout_Inflater.check_Type.TYPE_QUICKTASK;
import static com.example.internship_jaival.Layout_Inflater.check_Type.TYPE_SCAN;
import static com.example.internship_jaival.Layout_Inflater.check_Type.TYPE_SINGLESLIDER;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.internship_jaival.R;
import com.example.internship_jaival.retrofit_api.DataModel;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class layout_infalate_1 extends AppCompatActivity {



    LinearLayout layout;



    View quickstart,earning,withdraw,coin;

    ImageView reward,task,addperson,person;
    ArrayList<Layout_DataModel> datalist = new ArrayList<>();
    ArrayList<Layout_DataModel> singlesiderarray = new ArrayList<>();


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layout_infalate1);
        layout = findViewById(R.id.layout_infalate);
        task = findViewById(R.id.task);
        person = findViewById(R.id.person);


        ApiInterface apiInterface = Retrofit_Client.getRetrofit().create(ApiInterface.class);
        Call<Layout_MainModel> call = apiInterface.getAllData();

        if (layout != null){
            layout.removeAllViews();
        }

        call.enqueue(new Callback<Layout_MainModel>() {
            @Override
            public void onResponse(Call<Layout_MainModel> call, Response<Layout_MainModel> response) {
                ArrayList<Layout_HomeDataModel> homeDatalist= response.body().getHomeDataList();
               try {
                   for (int i = 0; i <= homeDatalist.size(); i++) {
                       if (homeDatalist.get(i).getType().equals(TYPE_SINGLESLIDER)){
                           singlesiderarray.addAll(homeDatalist.get(i).getData());

                       }

                   }
               }catch (Exception e){

               }

                try {
                    for (int i = 0; i <= homeDatalist.size(); i++) {
                        datalist.addAll(homeDatalist.get(i).getData());

                        Log.d("data", "onResponse: "+homeDatalist.get(i).getType());
                        switch (homeDatalist.get(i).getType()){
                            case TYPE_SINGLESLIDER:
                                    ArrayList<Layout_DataModel> silder = homeDatalist.get(i).getData();
                                    coin = getLayoutInflater().inflate(R.layout.layout_infalarat_4, layout, false);
                                    RecyclerView coin_recyclerView = coin.findViewById(R.id.coin_recyclerview);
                                    coin_recyclerView.setLayoutManager(new LinearLayoutManager(layout_infalate_1.this));
                                    coinAdapter coin_adapter = new coinAdapter(layout_infalate_1.this, silder);
                                    coin_recyclerView.setAdapter(coin_adapter);
                                    layout.addView(coin);
                                    break;



                            case  TYPE_SCAN:
                                   ArrayList<Layout_DataModel> scanarray = homeDatalist.get(i).getData();
                                    withdraw = getLayoutInflater().inflate(R.layout.layout_infalate_3,layout,false);
                                    RecyclerView recyclerView = withdraw.findViewById(R.id.withdrawrecyclerview);
                                    recyclerView.setLayoutManager(new LinearLayoutManager(layout_infalate_1.this));
                                    WithdrawAdapter adapter = new WithdrawAdapter(layout_infalate_1.this,scanarray);
                                    recyclerView.setAdapter(adapter);
                                    layout.addView(withdraw);
                                    break;




                            case TYPE_QUICKTASK:

                                    ArrayList<Layout_DataModel> quicktaskarray = homeDatalist.get(i).getData();
                                    quickstart = getLayoutInflater().inflate(R.layout.layout_infalate_item, layout, false);
                                    RecyclerView quicktask_recyclerView = quickstart.findViewById(R.id.quicktask_recyclerview);
                                    quicktask_recyclerView.setLayoutManager(new LinearLayoutManager(layout_infalate_1.this));
                                    QuickTaskAdapter quickTaskAdapter = new QuickTaskAdapter(layout_infalate_1.this, quicktaskarray);
                                    quicktask_recyclerView.setAdapter(quickTaskAdapter);
                                    layout.addView(quickstart);
                                    break;

                            case TYPE_EARNGRID:

                                    ArrayList<Layout_DataModel> earngridarray = homeDatalist.get(i).getData();
                                    earning = getLayoutInflater().inflate(R.layout.layout_inflate_item_2, layout, false);
                                    RecyclerView earngrid_recyclerView = earning.findViewById(R.id.earngrid_recyclerview);
                                    earngrid_recyclerView.setLayoutManager(new GridLayoutManager(layout_infalate_1.this, 2));
                                    EarnGridAdapter earnGridAdapter = new EarnGridAdapter(layout_infalate_1.this, earngridarray);
                                    earngrid_recyclerView.setAdapter(earnGridAdapter);
                                    layout.addView(earning);
                                    break;

                            default:
                                break;


                        }
                    }

                }catch (Exception e){

                }



//                withdraw = getLayoutInflater().inflate(R.layout.layout_infalate_3,layout);
//                withdraw1 = withdraw.findViewById(R.id.withdraw1);
//                withdraw2 = withdraw.findViewById(R.id.withdraw2);
//                withdraw3 = withdraw.findViewById(R.id.withdraw3);
//                ArrayList<Layout_DataModel> pay = response.body().homeDataList.get(3).getData();
//                Glide.with(layout_infalate_1.this).load(pay.get(0).getImage()).into(withdraw1);
//                Glide.with(layout_infalate_1.this).load(pay.get(1).getImage()).into(withdraw2);
//                Glide.with(layout_infalate_1.this).load(pay.get(2).getImage()).into(withdraw3);




//                //scan type
//                withdraw = getLayoutInflater().inflate(R.layout.layout_infalate_3,layout,false);
//                RecyclerView recyclerView = withdraw.findViewById(R.id.withdrawrecyclerview);
//                recyclerView.setLayoutManager(new LinearLayoutManager(layout_infalate_1.this));
//                WithdrawAdapter adapter = new WithdrawAdapter(layout_infalate_1.this,datalist);
//                recyclerView.setAdapter(adapter);
//                layout.addView(withdraw);






//                coin = getLayoutInflater().inflate(R.layout.layout_infalarat_4, layout);
//                coinim = coin.findViewById(R.id.coin);
//                ArrayList<Layout_DataModel> coine = response.body().homeDataList.get(4).getData();
//                Glide.with(layout_infalate_1.this).load(coine.get(0).getImage()).into(coinim);
//                //singleslider
//                coin = getLayoutInflater().inflate(R.layout.layout_infalarat_4,layout,false);
//                RecyclerView coin_recyclerView = coin.findViewById(R.id.coin_recyclerview);
//                coin_recyclerView.setLayoutManager(new LinearLayoutManager(layout_infalate_1.this));
//                coinAdapter coin_adapter = new coinAdapter(layout_infalate_1.this,datalist);
//                coin_recyclerView.setAdapter(coin_adapter);
//                layout.addView(coin);


//                quickstart = getLayoutInflater().inflate(R.layout.layout_infalate_item,layout);
//                 first= quickstart.findViewById(R.id.img1);
//                sec= quickstart.findViewById(R.id.img2);
//                titlef = quickstart.findViewById(R.id.title1);
//                titles = quickstart.findViewById(R.id.title2);
//                pointf = quickstart.findViewById(R.id.point1);
//                points = quickstart.findViewById(R.id.point2);
//                descf = quickstart.findViewById(R.id.desc1);
//                descs = quickstart.findViewById(R.id.desc2);
//                ArrayList<Layout_DataModel> arrayList = response.body().homeDataList.get(6).getData();
//                Glide.with(layout_infalate_1.this).load(arrayList.get(0).getIcon()).into(first);
//                Glide.with(layout_infalate_1.this).load(arrayList.get(1).getIcon()).into(sec);
//                titlef.setText(arrayList.get(0).getTitle());
//                titles.setText(arrayList.get(1).getTitle());
//                pointf.setText(arrayList.get(0).getPoints());
//                points.setText(arrayList.get(1).getPoints());
//                descf.setText(arrayList.get(0).getDescription());
//                descf.setText(arrayList.get(1).getDescription());
//                //quicktask
//                quickstart = getLayoutInflater().inflate(R.layout.layout_infalate_item,layout,false);
//                RecyclerView quicktask_recyclerView = quickstart.findViewById(R.id.quicktask_recyclerview);
//                quicktask_recyclerView.setLayoutManager(new LinearLayoutManager(layout_infalate_1.this));
//                QuickTaskAdapter quickTaskAdapter = new QuickTaskAdapter(layout_infalate_1.this,datalist);
//                quicktask_recyclerView.setAdapter(quickTaskAdapter);
//                layout.addView(quickstart);



//                earning = getLayoutInflater().inflate(R.layout.layout_inflate_item_2,layout);
//
//                earn1 = earning.findViewById(R.id.earn1);
//                earn2 = earning.findViewById(R.id.earn2);
//                earn3 = earning.findViewById(R.id.earn3);
//                earn4 = earning.findViewById(R.id.earn4);
//
//                ArrayList<Layout_DataModel> arrayList1 = response.body().homeDataList.get(7).getData();
//                Glide.with(layout_infalate_1.this).load(arrayList1.get(0).getImage()).into(earn1);
//                Glide.with(layout_infalate_1.this).load(arrayList1.get(1).getImage()).into(earn2);
//                Glide.with(layout_infalate_1.this).load(arrayList1.get(2).getImage()).into(earn3);
//                Glide.with(layout_infalate_1.this).load(arrayList1.get(3).getImage()).into(earn4);


//                //earngrid type
//                earning = getLayoutInflater().inflate(R.layout.layout_inflate_item_2,layout,false);
//                RecyclerView earngrid_recyclerView = earning.findViewById(R.id.earngrid_recyclerview);
//                earngrid_recyclerView.setLayoutManager(new GridLayoutManager(layout_infalate_1.this,2));
//                EarnGridAdapter earnGridAdapter = new EarnGridAdapter(layout_infalate_1.this,datalist);
//                earngrid_recyclerView.setAdapter(earnGridAdapter);
//                layout.addView(earning);



            }

            @Override
            public void onFailure(Call<Layout_MainModel> call, Throwable t) {
                Toast.makeText(layout_infalate_1.this, "fail", Toast.LENGTH_SHORT).show();
            }
        });





        task.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(layout_infalate_1.this , rewardActivity.class);
                startActivity(intent);
            }
        });




        person.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(layout_infalate_1.this , rewardActivity.class);
                startActivity(intent);
            }
     });

    }
}