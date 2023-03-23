package com.example.day04.bai2;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.day04.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Bai2Fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Bai2Fragment extends Fragment {



    public Bai2Fragment() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static Bai2Fragment newInstance() {
        Bai2Fragment fragment = new Bai2Fragment();

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
        return inflater.inflate(R.layout.fragment_bai2, container, false);
    }
}