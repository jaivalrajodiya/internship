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

import java.util.ArrayList;

public class FollowersFragment extends Fragment {

    FragmentFollowersBinding binding;

    ArrayList<TabModel> arrayList = new ArrayList<>();

    FollowAdapter adapter;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentFollowersBinding.inflate(inflater,container,false);

        binding.followersRcv.setLayoutManager(new LinearLayoutManager(getContext()));

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
         binding.followersRcv.setAdapter(adapter);


        return binding.getRoot();
    }


}