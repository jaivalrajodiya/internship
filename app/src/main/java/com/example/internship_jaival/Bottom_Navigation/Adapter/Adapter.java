package com.example.internship_jaival.Bottom_Navigation.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.internship_jaival.Bottom_Navigation.model.Model;
import com.example.internship_jaival.R;
import com.smarteist.autoimageslider.SliderViewAdapter;

import java.util.ArrayList;
import java.util.List;

public class Adapter extends SliderViewAdapter<Adapter.AdapterViewHolder> {
    Context context;
    ArrayList<Model> mSliderItems;

    public Adapter(Context context, ArrayList<Model> mSliderItems) {
        this.context = context;
        this.mSliderItems = mSliderItems;
    }

    @Override
    public AdapterViewHolder onCreateViewHolder(ViewGroup parent) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.image_silder_item, null);
        return new AdapterViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(AdapterViewHolder viewHolder, int position) {

        Model model = mSliderItems.get(position);


        Glide.with(viewHolder.itemView)
                .load(model.getImgUrl())
                .fitCenter()
                .into(viewHolder.imageViewBackground);

    }

    @Override
    public int getCount() {
        return mSliderItems.size();
    }

    public class AdapterViewHolder extends ViewHolder {
        View itemView;
        ImageView imageViewBackground;

        public AdapterViewHolder(View itemView) {
            super(itemView);
                imageViewBackground = itemView.findViewById(R.id.myimage);
                this.itemView = itemView;

        }
    }
}
