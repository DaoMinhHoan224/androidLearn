package com.example.assigment_hoandmph27404.Fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.assigment_hoandmph27404.Download.Downloadgame;
import com.example.assigment_hoandmph27404.Download.Downloadweather;
import com.example.assigment_hoandmph27404.R;
import com.example.assigment_hoandmph27404.WebViewNews;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link WeatherFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class WeatherFragment extends Fragment {

    public WeatherFragment() {
        // Required empty public constructor
    }


    public static WeatherFragment newInstance() {
        WeatherFragment fragment = new WeatherFragment();

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
        return inflater.inflate(R.layout.fragment_weather, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        String urlRss = "https://vnexpress.net/rss/khoa-hoc.rss";
        if(urlRss.length() == 0){
            Toast.makeText(getActivity(), "Chưa điền thông tin", Toast.LENGTH_SHORT).show();
            return;
        }else{
            Downloadweather downloadTinTuc = new Downloadweather(WeatherFragment.this);
            downloadTinTuc.execute(urlRss);
        }
    }
}