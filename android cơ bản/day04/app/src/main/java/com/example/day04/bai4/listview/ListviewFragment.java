package com.example.day04.bai4.listview;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.day04.R;
import com.example.day04.bai4.listview.adapter.adapter_listview;
import com.example.day04.bai4.listview.object.korealv;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ListviewFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ListviewFragment extends Fragment {
     private ListView listView;
     private adapter_listview adapter_listview;
     private ArrayList<korealv> listkorealv;


    public ListviewFragment() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static ListviewFragment newInstance() {
        ListviewFragment fragment = new ListviewFragment();

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
        return inflater.inflate(R.layout.fragment_listview, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        listView=view.findViewById(R.id.id_lvKorea);
        adapter_listview=new adapter_listview(getDatakorea(),getActivity(),R.layout.listkorea_layout);
        listView.setAdapter(adapter_listview);
    }

    public ArrayList<korealv> getDatakorea(){
        listkorealv=new ArrayList<>();
        listkorealv.add(new korealv(R.drawable.kimtaehee,"Kim Tae Hee",10));
        listkorealv.add(new korealv(R.drawable.kimsoeun,"Kim So Eun",1));
        listkorealv.add(new korealv(R.drawable.kimnamjoo,"Kim Nam Joo",1));
        listkorealv.add(new korealv(R.drawable.kimheesun,"Kim Hee Sun",2));
        listkorealv.add(new korealv(R.drawable.kimchi,"Kimchi",3));
        listkorealv.add(new korealv(R.drawable.shank,"Shank",5));
        listkorealv.add(new korealv(R.drawable.hancock,"Hancock",7));
        listkorealv.add(new korealv(R.drawable.one65,"One65",3));
        listkorealv.add(new korealv(R.drawable.kimbap,"KimBap",9));
        return listkorealv;
    }
}