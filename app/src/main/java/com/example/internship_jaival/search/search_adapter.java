package com.example.internship_jaival.search;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.internship_jaival.R;

import java.util.ArrayList;

public class search_adapter extends RecyclerView.Adapter<search_adapter.ViewHolder> {

    Context context;
    ArrayList<Serach_Model> arrayList;

    public search_adapter(Context context, ArrayList<Serach_Model> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    public void setFiltederdlist(ArrayList<Serach_Model> filtederdlist){
        this.arrayList = filtederdlist;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public search_adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.search_item,parent,false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull search_adapter.ViewHolder holder, int position) {

        holder.txtname.setText(arrayList.get(position).getName());
        holder.txtemail.setText(arrayList.get(position).getEmail());
        holder.txtroll.setText(arrayList.get(position).getRollno());
        holder.txtphone.setText(arrayList.get(position).getPhoneno());

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView txtname,txtroll,txtphone,txtemail;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtname = itemView.findViewById(R.id.txtName);
            txtemail = itemView.findViewById(R.id.txtemail);
            txtroll = itemView.findViewById(R.id.roll_no);
            txtphone = itemView.findViewById(R.id.phone_num);
        }
    }
}
