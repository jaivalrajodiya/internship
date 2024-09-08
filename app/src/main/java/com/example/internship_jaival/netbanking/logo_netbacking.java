package com.example.internship_jaival.netbanking;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.internship_jaival.R;

import java.util.ArrayList;

public class logo_netbacking extends AppCompatActivity {

    RecyclerView recyclerView;

    ArrayList<Netbanking_Model> arrayList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logo_netbacking);

        recyclerView = findViewById(R.id.netbanking_rcv);

        recyclerView.setLayoutManager(new GridLayoutManager(this,2));

        arrayList.add(new Netbanking_Model(R.drawable.bank_1,"https://retail.onlinesbi.sbi/retail/login.htm"));
        arrayList.add(new Netbanking_Model(R.drawable.bank_2,"https://www.hdfcbank.com/"));
        arrayList.add(new Netbanking_Model(R.drawable.bank_3,"https://www.kotak.com/en/home.html"));
        arrayList.add(new Netbanking_Model(R.drawable.bank_4,"https://infinity.icicibank.com/corp/AuthenticationController?FORMSGROUP_ID__=AuthenticationFG&__START_TRAN_FLAG__=Y&FG_BUTTONS__=LOAD&ACTION.LOAD=Y&AuthenticationFG.LOGIN_FLAG=1&BANK_ID=ICI"));
        arrayList.add(new Netbanking_Model(R.drawable.bank_5,"https://www.pnbindia.in/"));
        arrayList.add(new Netbanking_Model(R.drawable.bank_6,"https://www.indusind.com/in/en/personal.html#"));
        arrayList.add(new Netbanking_Model(R.drawable.bank_7,"https://www.saraswatbank.com/"));
        arrayList.add(new Netbanking_Model(R.drawable.bank_8,"https://www.suratnationalbank.com/"));
        arrayList.add(new Netbanking_Model(R.drawable.bank_9,"https://www.bankofbaroda.in/"));
        arrayList.add(new Netbanking_Model(R.drawable.bank_10,"https://canarabank.com/net-banking"));

        Netbanking_Adapter adapter = new Netbanking_Adapter(this,arrayList);
        recyclerView.setAdapter(adapter);

    }
}