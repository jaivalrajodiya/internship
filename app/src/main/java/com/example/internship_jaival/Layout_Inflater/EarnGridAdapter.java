package com.example.internship_jaival.Layout_Inflater;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.internship_jaival.R;

import java.util.ArrayList;

public class EarnGridAdapter extends RecyclerView.Adapter<EarnGridAdapter.ViewHolder> {
    Context context;
    ArrayList<Layout_DataModel> arrayList;

    public EarnGridAdapter(Context context, ArrayList<Layout_DataModel> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public EarnGridAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.layout_infalate_earngrid_item,parent,false);
       ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull EarnGridAdapter.ViewHolder holder, int position) {
        Glide.with(context).load(arrayList.get(position).getImage()).into(holder.imageView);

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.earngrid_image);
        }
    }
}
