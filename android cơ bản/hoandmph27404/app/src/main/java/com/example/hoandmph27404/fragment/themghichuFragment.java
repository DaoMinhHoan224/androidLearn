package com.example.hoandmph27404.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.hoandmph27404.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link themghichuFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class themghichuFragment extends Fragment {



    public themghichuFragment() {
        // Required empty public constructor
    }


    public static themghichuFragment newInstance() {
        themghichuFragment fragment = new themghichuFragment();
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
        return inflater.inflate(R.layout.fragment_themghichu, container, false);
    }
}