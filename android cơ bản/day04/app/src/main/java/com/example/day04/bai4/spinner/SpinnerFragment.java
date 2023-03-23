package com.example.day04.bai4.spinner;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Spinner;

import com.example.day04.R;
import com.example.day04.bai4.spinner.adapter.spinner_adapter;
import com.example.day04.bai4.spinner.object.nationality;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SpinnerFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SpinnerFragment extends Fragment {
      private ArrayList<nationality> listNationality;
      private Spinner spinner;
      private spinner_adapter spinner_aDapter;


    public SpinnerFragment() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static SpinnerFragment newInstance() {
        SpinnerFragment fragment = new SpinnerFragment();

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
        return inflater.inflate(R.layout.fragment_spinner, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        spinner=view.findViewById(R.id.id_spinnerNational);
        spinner_aDapter=new spinner_adapter(getDataSpin(),getActivity(),R.layout.spinner_layout);
        spinner.setAdapter(spinner_aDapter);
    }

    public ArrayList<nationality> getDataSpin(){
        listNationality=new ArrayList<>();
        listNationality.add(new nationality(R.drawable.vietnam,"Việt Nam"));
        listNationality.add(new nationality(R.drawable.usa,"Hoa Kỳ"));
        listNationality.add(new nationality(R.drawable.canada,"Canada"));
        listNationality.add(new nationality(R.drawable.germany,"Germany"));
        return listNationality;
    }
}