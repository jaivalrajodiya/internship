package com.example.internship_jaival.Layout_Inflater;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.internship_jaival.R;

import java.util.ArrayList;

public class QuickTaskAdapter extends RecyclerView.Adapter<QuickTaskAdapter.ViewHolder> {
    Context context;
    ArrayList<Layout_DataModel> arrayList;

    public QuickTaskAdapter(Context context, ArrayList<Layout_DataModel> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public QuickTaskAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.layout_infalate_quicktask_item,parent,false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull QuickTaskAdapter.ViewHolder holder, int position) {
        Glide.with(context).load(arrayList.get(position).getIcon()).into(holder.imageView);
        holder.title.setText(arrayList.get(position).getTitle());
        holder.dec.setText(arrayList.get(position).getDescription());
        holder.point.setText(arrayList.get(position).getPoints());


    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView point,title,dec;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.quicktask_img);
            dec = itemView.findViewById(R.id.quicktask_desc);
            point = itemView.findViewById(R.id.quicktask_point);
            title = itemView.findViewById(R.id.quicktask_title);
        }
    }
}
