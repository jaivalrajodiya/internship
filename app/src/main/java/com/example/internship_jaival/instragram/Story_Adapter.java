package com.example.internship_jaival.instragram;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.internship_jaival.R;
import com.example.internship_jaival.netbanking.Netbanking_Adapter;
import com.example.internship_jaival.netbanking.Netbanking_Model;

import java.util.ArrayList;

public class Story_Adapter extends RecyclerView.Adapter<Story_Adapter.ViewHolder> {

    Context context;
    ArrayList<Story_Model> arrayList;

    public Story_Adapter(Context context, ArrayList<Story_Model> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }
    @NonNull
    @Override
    public Story_Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.instragram_story_item,parent,false);
        ViewHolder viewHolder = new Story_Adapter.ViewHolder(v);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull Story_Adapter.ViewHolder holder, int position) {

        holder.imageView.setImageResource(arrayList.get(position).img);
        holder.username.setText(arrayList.get(position).uname);

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;

        TextView username;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.user_img);
            username = itemView.findViewById(R.id.user_name);
        }
    }
}
