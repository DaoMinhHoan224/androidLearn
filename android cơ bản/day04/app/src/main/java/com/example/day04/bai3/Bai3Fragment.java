package com.example.day04.bai3;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.day04.R;
import com.example.day04.bai3.adapter.adapter_view;
import com.example.day04.bai3.object.User;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Bai3Fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Bai3Fragment extends Fragment {
    private ListView listView;
    private adapter_view adapter;
    private ArrayList<User> list;

    public Bai3Fragment() {
        // Required empty public constructor
    }


    public static Bai3Fragment newInstance() {
        Bai3Fragment fragment = new Bai3Fragment();

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
        return inflater.inflate(R.layout.fragment_bai3, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        listView=view.findViewById(R.id.id_listview);
        adapter=new adapter_view(getData(),getActivity(),R.layout.item_layout);
        listView.setAdapter(adapter);
    }

    public ArrayList<User> getData(){
        list=new ArrayList<>();
        list.add(new User("tung","5",R.drawable.ic_launcher_background));
        list.add(new User("tunghoang","6",R.drawable.ic_launcher_background));
        list.add(new User("thung","5",R.drawable.ic_launcher_background));
        list.add(new User("thanh","5",R.drawable.ic_launcher_background));
        list.add(new User("quynh","5",R.drawable.ic_launcher_background));
        list.add(new User("long","7",R.drawable.ic_launcher_background));
        list.add(new User("long","7",R.drawable.ic_launcher_background));
        list.add(new User("long","7",R.drawable.ic_launcher_background));
        list.add(new User("long","7",R.drawable.ic_launcher_background));
        list.add(new User("long","7",R.drawable.ic_launcher_background));

        return  list;
    }
}