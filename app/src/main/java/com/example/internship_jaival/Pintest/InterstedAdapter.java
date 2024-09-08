package com.example.internship_jaival.Pintest;

import static com.example.internship_jaival.Pintest.InterestedActivity.cardView;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.internship_jaival.R;

import java.util.ArrayList;

public class InterstedAdapter extends RecyclerView.Adapter<InterstedAdapter.ViewHolder> {

    Context context;
    ArrayList<InterestedModel> arrayList;


    private SparseBooleanArray selectedItems = new SparseBooleanArray();


    public InterstedAdapter(Context context, ArrayList<InterestedModel> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }


    @NonNull
    @Override
    public InterstedAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.interested_rcv_item,parent,false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull InterstedAdapter.ViewHolder holder, @SuppressLint("RecyclerView") int position) {

        holder.txtname.setText(arrayList.get(position).getName());
        Glide.with(context).load(arrayList.get(position).getImg()).into(holder.img);

        if (isSelected(position)) {

            holder.linearLayout.setBackgroundResource(R.drawable.curv);
        } else {
            holder.linearLayout.setBackgroundColor(Color.TRANSPARENT);

        }






    }

    private void toggleSelection(int position) {
        if (selectedItems.get(position, false)) {
            selectedItems.delete(position);
        } else {
            selectedItems.put(position, true);
        }
        notifyItemChanged(position);
    }

    private boolean isSelected(int position) {
        return selectedItems.get(position, false);
    }

    // Get the count of selected items
    private int getSelectedItemCount() {
        int count = 0;
        for (int i = 0; i < selectedItems.size(); i++) {
            if (selectedItems.valueAt(i)) {
                count++;
            }
        }
        return count;
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView img;

        LinearLayout linearLayout;
        TextView txtname;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtname = itemView.findViewById(R.id.interset_name);
            img = itemView.findViewById(R.id.interset_imag);
            linearLayout = itemView.findViewById(R.id.background);

            linearLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    if (position != RecyclerView.NO_POSITION) {
                        toggleSelection(position);
                    }

                }
            });



        }
    }
}
