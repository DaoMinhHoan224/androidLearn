package com.example.assigment_hoandmph27404.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.assigment_hoandmph27404.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FavoriteMusicFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FavoriteMusicFragment extends Fragment {


    public FavoriteMusicFragment() {
        // Required empty public constructor
    }


    public static FavoriteMusicFragment newInstance() {
        FavoriteMusicFragment fragment = new FavoriteMusicFragment();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_favorite_music, container, false);
    }
}