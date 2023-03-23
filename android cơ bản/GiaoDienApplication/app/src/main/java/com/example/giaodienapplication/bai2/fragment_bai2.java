package com.example.giaodienapplication.bai2;

import android.graphics.Typeface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.CompoundButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.ToggleButton;

import com.example.giaodienapplication.R;
import com.example.giaodienapplication.bai2.adapter.userAdapter;
import com.example.giaodienapplication.bai2.object.User;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link fragment_bai2#newInstance} factory method to
 * create an instance of this fragment.
 */
public class fragment_bai2 extends Fragment {
    private ListView listView;
    private userAdapter adapter;
    private ArrayList<User> list;



    public fragment_bai2() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static fragment_bai2 newInstance() {
        fragment_bai2 fragment = new fragment_bai2();

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

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
       listView = view.findViewById(R.id.id_listview);
       adapter = new userAdapter(getData(), getActivity(),R.layout.user_item);
       listView.setAdapter(adapter);
    }
    public ArrayList<User> getData(){
        list = new ArrayList<>();
        list.add(new User("tung","5",R.drawable.ic_launcher_foreground));
        list.add(new User("hao","5",R.drawable.ic_launcher_foreground));
        list.add(new User("thanh","5",R.drawable.ic_launcher_foreground));
        list.add(new User("hang","5",R.drawable.ic_launcher_foreground));
        list.add(new User("trang","5",R.drawable.ic_launcher_foreground));
        return list;
    }
}