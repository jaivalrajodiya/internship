package com.example.internship_jaival.instragram;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.internship_jaival.R;
import com.example.internship_jaival.databinding.FragmentInstaHomeFragmentBinding;
import com.example.internship_jaival.databinding.FragmentInstaProfileFragmentBinding;

public class insta_profile_fragment extends Fragment {

    FragmentInstaProfileFragmentBinding binding;




    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentInstaProfileFragmentBinding.inflate(inflater, container, false);

        Tab_Adapter adapter = new Tab_Adapter(getChildFragmentManager());
        binding.viewpager.setAdapter(adapter);

        binding.tabLayout.setupWithViewPager(binding.viewpager);





        return binding.getRoot();
    }
}