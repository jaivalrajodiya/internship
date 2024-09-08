package com.example.internship_jaival.Bottom_Navigation.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.internship_jaival.Bottom_Navigation.Adapter.Adapter;
import com.example.internship_jaival.Bottom_Navigation.model.Model;
import com.example.internship_jaival.R;
import com.example.internship_jaival.databinding.FragmentHomeBinding;
import com.smarteist.autoimageslider.SliderView;

import java.util.ArrayList;


public class HomeFragment extends Fragment {

FragmentHomeBinding binding;
    String url1 = "https://www.geeksforgeeks.org/wp-content/uploads/gfg_200X200-1.png";
    String url2 = "https://www.geeksforgeeks.org/wp-content/uploads/gfg_200X200-1.png";
    String url3 = "https://www.geeksforgeeks.org/wp-content/uploads/gfg_200X200-1.png";

    ArrayList<Model> sliderDataArrayList = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentHomeBinding.inflate(inflater, container, false);



        sliderDataArrayList.add(new Model(url1));
        sliderDataArrayList.add(new Model(url2));
        sliderDataArrayList.add(new Model(url3));


        Adapter adapter = new Adapter(getContext(), sliderDataArrayList);


       binding.slider.setAutoCycleDirection(SliderView.LAYOUT_DIRECTION_LTR);

        binding.slider.setSliderAdapter(adapter);

        binding.slider.setScrollTimeInSec(3);


        binding.slider.setAutoCycle(true);


        binding.slider.startAutoCycle();

        return binding.getRoot();




    }

}