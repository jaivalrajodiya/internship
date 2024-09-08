package com.example.internship_jaival.atozprint;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.internship_jaival.MainActivity;
import com.example.internship_jaival.R;

import java.util.ArrayList;
import java.util.Collections;

public class adapter extends RecyclerView.Adapter<adapter.ViewHolder> {

    Context context;
    ArrayList<Character> arrayList;

    ArrayList<Character> example = new ArrayList<>();


    boolean check;

    boolean finish;

    public adapter(Context context, ArrayList<Character> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(context).inflate(R.layout.atoz_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull adapter.ViewHolder holder, @SuppressLint("RecyclerView") int position) {

        holder.textView.setText(String.valueOf(arrayList.get(position)));

        for (char c = 'A'; c <= 'Z'; c++) {
            example.add(c);
        }

        Log.d("checkv", String.valueOf(check));


        if (check) {
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (arrayList.get(position).toString().equals(example.get(0).toString())) {
                        example.remove(0);
                        holder.itemView.setVisibility(View.INVISIBLE);


                        if (example.size() == 1326) {
                            example.clear();
                        }
                    } else {

                        finish = true;

                    }
                }
            });


        }


    }


    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView textView;
        CardView cardView;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.textViewA);
            cardView = itemView.findViewById(R.id.cardview);

        }
    }
}
