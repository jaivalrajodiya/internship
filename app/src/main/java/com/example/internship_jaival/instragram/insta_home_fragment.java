package com.example.internship_jaival.instragram;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.internship_jaival.R;
import com.example.internship_jaival.databinding.FragmentHomeBinding;
import com.example.internship_jaival.databinding.FragmentInstaHomeFragmentBinding;

import java.util.ArrayList;

public class insta_home_fragment extends Fragment {

    FragmentInstaHomeFragmentBinding binding;


    ArrayList<Story_Model> storyList = new ArrayList<>();
    ArrayList<Post_Model> postList = new ArrayList<>();

    Story_Adapter storyadapter;

    Post_Adapter postAdapter;




    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentInstaHomeFragmentBinding.inflate(inflater, container, false);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false);

        binding.storyRec.setLayoutManager(layoutManager);
        binding.postRec.setLayoutManager(new LinearLayoutManager(getContext()));
        storyList.add(new Story_Model(R.drawable.user,"jaival"));
        storyList.add(new Story_Model(R.drawable.user,"jaiva"));
        storyList.add(new Story_Model(R.drawable.user,"jaiv"));
        storyList.add(new Story_Model(R.drawable.user,"jai"));
        storyList.add(new Story_Model(R.drawable.user,"ja"));
        storyList.add(new Story_Model(R.drawable.user,"j"));

        storyadapter = new Story_Adapter(getContext(),storyList);
        binding.storyRec.setAdapter(storyadapter);


        postList.add(new Post_Model(R.drawable.bank_1,"hiiiiiiiiiiiiii"));
        postList.add(new Post_Model(R.drawable.bank_2,"hiiiiiiiiiiiiii"));
        postList.add(new Post_Model(R.drawable.bank_3,"hiiiiiiiiiiiiii"));
        postList.add(new Post_Model(R.drawable.bank_4,"hiiiiiiiiiiiiii"));
        postList.add(new Post_Model(R.drawable.bank_5,"hiiiiiiiiiiiiii"));
        postList.add(new Post_Model(R.drawable.bank_6,"hiiiiiiiiiiiiii"));

        postAdapter = new Post_Adapter(getContext(),postList);
        binding.postRec.setAdapter(postAdapter);
        return binding.getRoot();
    }
}