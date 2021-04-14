package com.example.squashapp_test;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

public class LikedFragment extends Fragment {

    GridView gridViewLikedFragment;

    public int[] thumbNail_Icons={
            R.drawable.sample_one,R.drawable.sample_two,R.drawable.sample_three,
            R.drawable.sample_one,R.drawable.sample_two,R.drawable.sample_three
    };

    public String[] thumbNail_Titles={
            "1022","1008","989","765","1001","2112"
    };


    public LikedFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root=inflater.inflate(R.layout.fragment_liked, container, false);
        gridViewLikedFragment=root.findViewById(R.id.gridViewLikedFragment);
        gridViewLikedFragment.setAdapter(new VideosFragmentAdapter(getContext(),thumbNail_Titles,thumbNail_Icons));
        gridViewLikedFragment.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent playerIntent=new Intent(getActivity(),PlayerActivity.class);
                playerIntent.putExtra("POSITION",position);
                getActivity().startActivity(playerIntent);
            }
        });
        return root;
    }
}