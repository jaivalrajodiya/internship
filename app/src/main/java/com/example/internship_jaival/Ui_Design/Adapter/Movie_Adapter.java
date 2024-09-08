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
import com.example.internship_jaival.Ui_Design.Movie_Model;
import com.example.internship_jaival.Ui_Design.TvShow_Model;

import java.util.ArrayList;

public class Movie_Adapter extends RecyclerView.Adapter<Movie_Adapter.ViewHolder> {
    Context context;
    ArrayList<Movie_Model> arrayList;

    public Movie_Adapter(Context context, ArrayList<Movie_Model> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public Movie_Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.movies_rcv_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull Movie_Adapter.ViewHolder holder, int position) {
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
            imageView = itemView.findViewById(R.id.mo_image);

            textView = itemView.findViewById(R.id.mo_textview);
        }
    }
}
