package com.example.internship_jaival.SortWord_Game.Adapter;

import static com.example.internship_jaival.SortWord_Game.Async.SortWord_Async.examplearray;
import static com.example.internship_jaival.SortWord_Game.Async.SortWord_Async.status;
import static com.example.internship_jaival.SortWord_Game.sortword_activity.maincontitn;
import static com.example.internship_jaival.SortWord_Game.sortword_activity.maintimer;
import static com.example.internship_jaival.SortWord_Game.sortword_activity.recyclerView;
import static com.example.internship_jaival.SortWord_Game.sortword_activity.rematchcountdown;
import static com.example.internship_jaival.SortWord_Game.sortword_activity.rematchtime;
import static com.example.internship_jaival.SortWord_Game.sortword_activity.rematchtimer;
import static com.example.internship_jaival.SortWord_Game.sortword_activity.showrematchtimer;
import static com.example.internship_jaival.SortWord_Game.sortword_activity.softwordcountDownTimer;
import static com.example.internship_jaival.SortWord_Game.sortword_activity.startlayout;
import static com.example.internship_jaival.SortWord_Game.sortword_activity.timer;
import static com.example.internship_jaival.SortWord_Game.sortword_activity.u_id;
import static com.example.internship_jaival.TextTyping_Game.Async.SaveText_Async.winpoint;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.os.CountDownTimer;
import android.provider.CalendarContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.internship_jaival.Layout_Inflater.Layout_DataModel;
import com.example.internship_jaival.R;
import com.example.internship_jaival.SortWord_Game.Async.SaveSortword_Async;
import com.example.internship_jaival.SortWord_Game.Async.SortWord_Async;
import com.example.internship_jaival.SortWord_Game.Models.SortWordModel;
import com.example.internship_jaival.SortWord_Game.sortword_activity;
import com.example.internship_jaival.oneto20game.Game_FristActivity;

import java.util.ArrayList;

public class SortwordAdapter extends RecyclerView.Adapter<SortwordAdapter.ViewHolder>{
    Activity context;
    ArrayList<String> arrayList;

    boolean check;

    public static int reentry = 0;
    
    
    public SortwordAdapter(Activity context, ArrayList<String> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public SortwordAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.sortword_rcv_item,parent,false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull SortwordAdapter.ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.textView.setText(arrayList.get(position));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                
                if (arrayList.get(position).toString().equals(examplearray.get(0).toString())){
                    Toast.makeText(context, "right", Toast.LENGTH_SHORT).show();
                    examplearray.remove(0);

                    holder.linearLayout.setBackgroundColor(Color.parseColor("#FF000000"));
                    holder.textView.setTextColor(Color.parseColor("#FFFFFFFF"));

                    if (examplearray.isEmpty()){
                        rematchtimer.setVisibility(View.VISIBLE);
                        timer.setText("00:00:00");
                        maintimer.cancel();

                        reentry =1;
                        if (status.equals("0")){

                        }else {
                            Dialog dialog = new Dialog(context);
                            dialog.setContentView(R.layout.game_dialog);
                            ImageView game_true = dialog.findViewById(R.id.game_true);
                            Button btnsubmit = dialog.findViewById(R.id.game_btn);

                            game_true.setVisibility(View.VISIBLE);

                            btnsubmit.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    maintimer.cancel();
                                    maintimer.onFinish();
                                    dialog.dismiss();
                                    rematchtimer.setVisibility(View.VISIBLE);

                                    rematchcountdown = new CountDownTimer(rematchtime,1000) {
                                        @Override
                                        public void onTick(long millisUntilFinished) {
                                            showrematchtimer.setText("00:00:"+millisUntilFinished / 1000);
                                            for (int i = 0; i < recyclerView.getChildCount(); i++) {
                                                View child = recyclerView.getChildAt(i);
                                                child.setOnClickListener(null);

                                            }


                                        }

                                        @Override
                                        public void onFinish() {
                                            rematchtimer.setVisibility(View.GONE);
                                            startlayout.setVisibility(View.VISIBLE);
                                            new SortWord_Async(context,u_id);
                                            softwordcountDownTimer.start();

                                        }
                                    }.start();

                                }
                            });
                            dialog.setCancelable(false);
                            dialog.show();
                        }

                    }

                }else {
                    Toast.makeText(context, "worage", Toast.LENGTH_SHORT).show();
                    timer.setText("00:00:00");
                    maintimer.cancel();

                    reentry =1;

                    if (status.equals("0")){

                    }else {
                        Dialog dialog = new Dialog(context);
                        dialog.setContentView(R.layout.game_dialog);
                        ImageView game_true = dialog.findViewById(R.id.game_lose);
                        TextView game_text = dialog.findViewById(R.id.game_text);
                        Button btnsubmit = dialog.findViewById(R.id.game_btn);

                        game_true.setVisibility(View.VISIBLE);
                        game_text.setText("You are Fail");

                        btnsubmit.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                maintimer.cancel();
                                maintimer.onFinish();
                                dialog.dismiss();
                                rematchtimer.setVisibility(View.VISIBLE);
                                rematchcountdown = new CountDownTimer(rematchtime,1000) {
                                    @Override
                                    public void onTick(long millisUntilFinished) {
                                        showrematchtimer.setText("00:00:"+millisUntilFinished / 1000);
                                        for (int i = 0; i < recyclerView.getChildCount(); i++) {
                                            View child = recyclerView.getChildAt(i);
                                            child.setOnClickListener(null);

                                        }

                                    }

                                    @Override
                                    public void onFinish() {
                                        rematchtimer.setVisibility(View.GONE);
                                        startlayout.setVisibility(View.VISIBLE);
                                        new SortWord_Async(context,u_id);
                                        softwordcountDownTimer.start();

                                    }
                                }.start();


                            }
                        });
                        dialog.setCancelable(false);
                        dialog.show();

                    }


                }
                
            }
        });
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView textView;

        LinearLayout linearLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.sortword_rcv_text);
            linearLayout = itemView.findViewById(R.id.liner);
        }
    }
}
