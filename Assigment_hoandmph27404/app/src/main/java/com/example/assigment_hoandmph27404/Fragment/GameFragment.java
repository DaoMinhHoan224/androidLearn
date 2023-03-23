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
import com.example.assigment_hoandmph27404.Download.Downloadnews;
import com.example.assigment_hoandmph27404.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link GameFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class GameFragment extends Fragment {


    public GameFragment() {
        // Required empty public constructor
    }


    public static GameFragment newInstance() {
        GameFragment fragment = new GameFragment();

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
        return inflater.inflate(R.layout.fragment_game, container, false);
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        String urlRss = "https://vnexpress.net/rss/giai-tri.rss";
        if(urlRss.length() == 0){
            Toast.makeText(getActivity(), "Chưa điền thông tin", Toast.LENGTH_SHORT).show();
            return;
        }else{
            Downloadgame downloadTinTuc = new Downloadgame(GameFragment.this);
            downloadTinTuc.execute(urlRss);
        }
    }
}