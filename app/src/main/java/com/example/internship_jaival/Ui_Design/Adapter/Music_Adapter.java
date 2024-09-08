package com.example.internship_jaival.Ui_Design.Adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.internship_jaival.R;
import com.example.internship_jaival.Ui_Design.ui_design_1;
import com.example.internship_jaival.Ui_Design.ui_design_2;
import com.example.internship_jaival.atozprint.adapter;

import java.util.ArrayList;

public class Music_Adapter extends RecyclerView.Adapter<Music_Adapter.ViewHolder> {

    Context context;

    ArrayList<String> arrayList;

    Integer select = 0;


    public Music_Adapter(Context context, ArrayList<String> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public Music_Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.music_rcv_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull Music_Adapter.ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.textView.setText(arrayList.get(position));
        if (select == position){
            holder.textView.setBackgroundDrawable(ContextCompat.getDrawable(context, R.drawable.textview_curv));
            holder.textView.setTextColor(Color.parseColor("#000000"));
        }

        holder.textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (arrayList.get(position).equals("Movies  ")){
                    Intent intent = new Intent(context, ui_design_2.class);
                    intent.putExtra("title",arrayList.get(position));
                    context.startActivity(intent);
                }
            }
        });
//        holder.textView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
////                holder.textView.setBackgroundResource();
////                holder.textView.setBackground(Drawable.createFromPath("R.drawable.textview_curv"));
//
//               holder.textView.setBackgroundDrawable(ContextCompat.getDrawable(context, R.drawable.textview_curv));
//
//            }
//        });
//        holder.textView.setBackgroundColor(Color.parseColor("#504F4F"));
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView textView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            textView = itemView.findViewById(R.id.m_textview);
        }
    }
}
