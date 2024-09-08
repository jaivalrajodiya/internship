package com.example.internship_jaival.uidesign;

import android.content.Context;
import android.graphics.Color;
import android.view.ContentInfo;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.internship_jaival.R;
import com.example.internship_jaival.Ui_Design.Adapter.Movie_Adapter;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    Context context;
    ArrayList<Model> arrayList;

    public Adapter(Context context, ArrayList<Model> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.uidesign_rcv_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter.ViewHolder holder, int position) {

        if (position == 0){
            holder.cardView.setBackgroundColor(Color.parseColor("#ffceb4"));
        }


        if (position == 1){
            holder.cardView.setBackgroundColor(Color.parseColor("#d5ea7c"));
        }


        if (position == 2){
            holder.cardView.setBackgroundColor(Color.parseColor("#b7e4ff"));
        }


        if (position == 3){
            holder.cardView.setBackgroundColor(Color.parseColor("#d6d3f4"));
        }

        holder.imageView.setImageResource(arrayList.get(position).getImg());
        holder.textView.setText(arrayList.get(position).getName());

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        LinearLayout cardView;
        ImageView imageView;
        TextView textView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            cardView = itemView.findViewById(R.id.cardview);
            imageView = itemView.findViewById(R.id.img);
            textView = itemView.findViewById(R.id.name);

        }
    }
}
