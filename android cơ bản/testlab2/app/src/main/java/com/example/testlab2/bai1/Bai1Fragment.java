package com.example.testlab2.bai1;

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

import com.example.testlab2.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Bai1Fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Bai1Fragment extends Fragment {



    public Bai1Fragment() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static Bai1Fragment newInstance() {
        Bai1Fragment fragment = new Bai1Fragment();

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

        TextView tvname=view.findViewById(R.id.tvnameee);
        ToggleButton toggleButton=view.findViewById(R.id.idtoggle);
        toggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    Typeface typeface=Typeface.createFromAsset(getActivity().getAssets(),"Blazed.ttf");
                    tvname.setTypeface(typeface);
                }else{
                    tvname.setTypeface(null);
                }
            }
        });
    }
}