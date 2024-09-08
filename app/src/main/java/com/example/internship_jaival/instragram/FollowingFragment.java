package com.example.internship_jaival.instragram;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.internship_jaival.R;
import com.example.internship_jaival.databinding.FragmentFollowersBinding;
import com.example.internship_jaival.databinding.FragmentFollowingBinding;

import java.util.ArrayList;

public class FollowingFragment extends Fragment {

    FragmentFollowingBinding binding;

    ArrayList<TabModel> arrayList = new ArrayList<>();

    FollowAdapter adapter;



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentFollowingBinding.inflate(inflater,container,false);

        binding.followingRcv.setLayoutManager(new LinearLayoutManager(getContext()));

        arrayList.add(new TabModel(R.drawable.user,"jaival"));
        arrayList.add(new TabModel(R.drawable.user,"jaival"));
        arrayList.add(new TabModel(R.drawable.user,"jaival"));
        arrayList.add(new TabModel(R.drawable.user,"jaival"));
        arrayList.add(new TabModel(R.drawable.user,"jaival"));
        arrayList.add(new TabModel(R.drawable.user,"jaival"));
        arrayList.add(new TabModel(R.drawable.user,"jaival"));
        arrayList.add(new TabModel(R.drawable.user,"jaival"));
        arrayList.add(new TabModel(R.drawable.user,"jaival"));
        arrayList.add(new TabModel(R.drawable.user,"jaival"));

         adapter = new FollowAdapter(getActivity(),arrayList);
        binding.followingRcv.setAdapter(adapter);

        return binding.getRoot();
    }


}