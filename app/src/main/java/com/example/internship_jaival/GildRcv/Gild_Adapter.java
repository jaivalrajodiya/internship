package com.example.internship_jaival.GildRcv;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.internship_jaival.R;

import java.util.ArrayList;

public class Gild_Adapter extends RecyclerView.Adapter<Gild_Adapter.ViewHolder> {

    ArrayList<String> arrayList;

    public Gild_Adapter(ArrayList<String> arrayList) {
        this.arrayList = arrayList;
    }


    public int getItemViewType(int position){
        if ((position + 1) % 5 * 2 == 0){
            return 2;
        }else {
            return 1;
        }
    }


    @NonNull
    @Override
    public Gild_Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;

        if (viewType == 2){
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.gild_rcv_item,parent,false);
        }else {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.linerlayout_rcv_item,parent,false);
        }

        return new ViewHolder(view);


}

    @Override
    public void onBindViewHolder(@NonNull Gild_Adapter.ViewHolder holder, int position) {
        holder.textView.setText(arrayList.get(position));
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView textView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.txt);
        }
    }
}
