package com.example.internship_jaival.Ui_Design.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.internship_jaival.R;
import com.example.internship_jaival.Ui_Design.TvShow_Model;

import java.util.ArrayList;

public class Tvshow_Adapter extends RecyclerView.Adapter<Tvshow_Adapter.ViewHolder> {
    Context context;
    ArrayList<TvShow_Model> arrayList;

    public Tvshow_Adapter(Context context, ArrayList<TvShow_Model> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public Tvshow_Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.tvshow_rcv_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull Tvshow_Adapter.ViewHolder holder, int position) {
        holder.imageView.setImageResource(arrayList.get(position).getImag());
        holder.textView.setText(arrayList.get(position).getTitle());


    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView textView;
        ImageView imageView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.t_image);

            textView = itemView.findViewById(R.id.t_textview);
        }
    }
}
