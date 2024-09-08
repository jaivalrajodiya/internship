package com.example.internship_jaival.uidesign;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import com.example.internship_jaival.R;

import java.util.ArrayList;

public class ex_uidesign_1 extends AppCompatActivity {

    Adapter adapter;

    FoodAdapter foodAdapter;
    ArrayList<Model> arrayList = new ArrayList<>();
    ArrayList<FoodModel> foodarray = new ArrayList<>();

    RecyclerView recyclerView;
    RecyclerView foodrcv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ex_uidesign1);
        recyclerView = findViewById(R.id.uidesign_rcv);
        foodrcv = findViewById(R.id.uidesign_rcv_1);

        LinearLayoutManager layoutManager = new LinearLayoutManager(ex_uidesign_1.this,LinearLayoutManager.HORIZONTAL,false);
        recyclerView.setLayoutManager(layoutManager);
        LinearLayoutManager layoutManager1 = new LinearLayoutManager(ex_uidesign_1.this,LinearLayoutManager.HORIZONTAL,false);
        foodrcv.setLayoutManager(layoutManager1);


        arrayList.add(new Model(R.drawable.burger,"Burger"));
        arrayList.add(new Model(R.drawable.pizza,"Pizza"));
        arrayList.add(new Model(R.drawable.frenchfries,"Potato"));
        arrayList.add(new Model(R.drawable.soda,"Coca Cola"));

        foodarray.add(new FoodModel(R.drawable.bigburger,"Royal","Spcial Burger","$10.99"));
        foodarray.add(new FoodModel(R.drawable.bigburger,"Royal","Spcial Burger","$10.99"));
        foodarray.add(new FoodModel(R.drawable.bigburger,"Royal","Spcial Burger","$10.99"));
        foodarray.add(new FoodModel(R.drawable.bigburger,"Royal","Spcial Burger","$10.99"));
        foodarray.add(new FoodModel(R.drawable.bigburger,"Royal","Spcial Burger","$10.99"));

        adapter = new Adapter(ex_uidesign_1.this,arrayList);
        recyclerView.setAdapter(adapter);

        foodAdapter = new FoodAdapter(ex_uidesign_1.this,foodarray);
        foodrcv.setAdapter(foodAdapter);
    }
}