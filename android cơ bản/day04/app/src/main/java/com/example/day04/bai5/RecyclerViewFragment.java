package com.example.day04.bai5;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.day04.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link RecyclerViewFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class RecyclerViewFragment extends Fragment {
    private RecyclerView recyclerView;
    private ArrayList<UserObject> arrayList=new ArrayList<>();
    private RecyclerViewAdapter adapter;


    public RecyclerViewFragment() {
        // Required empty public constructor
    }


    public static RecyclerViewFragment newInstance() {
        RecyclerViewFragment fragment = new RecyclerViewFragment();

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
        return inflater.inflate(R.layout.fragment_recycler_view, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView=view.findViewById(R.id.id_recycleview);
        createData();

        adapter=new RecyclerViewAdapter(getActivity());
        adapter.setData(arrayList);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adapter);


    }

    public void createData(){
        arrayList.add(new UserObject("Android",R.drawable.android));
        arrayList.add(new UserObject("Apple",R.drawable.apple));
        arrayList.add(new UserObject("Blogger",R.drawable.blogger));
        arrayList.add(new UserObject("Chrome",R.drawable.chrome));
        arrayList.add(new UserObject("Dell",R.drawable.dell));
        arrayList.add(new UserObject("Facebook",R.drawable.facebook));
        arrayList.add(new UserObject("FireFox",R.drawable.firefox));

    }
}