package com.example.internship_jaival.uidesign;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.internship_jaival.R;

import java.util.ArrayList;

public class FoodAdapter extends RecyclerView.Adapter<FoodAdapter.ViewHolder> {

    Context context;
    ArrayList<FoodModel> arrayList;

    public FoodAdapter(Context context, ArrayList<FoodModel> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public FoodAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.uidesign_rcv_item1, parent, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull FoodAdapter.ViewHolder holder, int position) {


        holder.linearLayout.setImageResource(arrayList.get(position).img);
        holder.txt1.setText(arrayList.get(position).txt1);
        holder.txt2.setText(arrayList.get(position).txt2);
        holder.price.setText(arrayList.get(position).price);
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView linearLayout;

        TextView txt1,txt2,price;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            linearLayout = itemView.findViewById(R.id.foodimg);
            txt1 = itemView.findViewById(R.id.foodtxt);
            txt2 = itemView.findViewById(R.id.txt1);
            price = itemView.findViewById(R.id.price);
        }
    }
}
