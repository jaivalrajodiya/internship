package com.example.internship_jaival.instragram;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.internship_jaival.R;

import java.util.ArrayList;

public class Post_Adapter extends RecyclerView.Adapter<Post_Adapter.ViewHolder> {
    Context context;
    ArrayList<Post_Model> arrayList;

    boolean check = true;

    public Post_Adapter(Context context, ArrayList<Post_Model> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public Post_Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.insta_post_item,parent,false);
        ViewHolder viewHolder = new ViewHolder(v);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull Post_Adapter.ViewHolder holder, int position) {
        holder.imageView.setImageResource(arrayList.get(position).post_img);
        holder.username.setText(arrayList.get(position).dec);

        holder.like.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (check){
                    holder.like.setImageResource(R.drawable.like_red);
                    check= false;
                }else {
                    holder.like.setImageResource(R.drawable.like);
                    check= true;
                }

            }
        });



    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView,like,comment,share;

        TextView username;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.post_img);
            like = itemView.findViewById(R.id.like);
            comment = itemView.findViewById(R.id.comment);
            share = itemView.findViewById(R.id.share);
            username = itemView.findViewById(R.id.post_txt);
        }
    }
}
