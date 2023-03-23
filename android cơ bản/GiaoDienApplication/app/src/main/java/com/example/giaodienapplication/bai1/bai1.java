package com.example.giaodienapplication.bai1;

import android.graphics.Typeface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.ToggleButton;

import com.example.giaodienapplication.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link bai1#newInstance} factory method to
 * create an instance of this fragment.
 */
public class bai1 extends Fragment {



    public bai1() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static bai1 newInstance() {
        bai1 fragment = new bai1();

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
        return inflater.inflate(R.layout.fragment_bai1, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        TextView tvName = view.findViewById(R.id.tv_nameb1);
        ToggleButton toggleButton = view.findViewById(R.id.id_toggle);
        toggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean b) {
                if(b){
                    Typeface typeface = Typeface.createFromAsset(getActivity().getAssets(),"blazed.ttf");
                    tvName.setTypeface(typeface);
                }else{
                    tvName.setTypeface(null);
                }
            }
        });
    }
}