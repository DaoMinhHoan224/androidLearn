package com.example.hoandmph27404.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.hoandmph27404.R;
import com.example.hoandmph27404.adapter.DanhSachAdapter;
import com.example.hoandmph27404.database.UserDatabase;
import com.example.hoandmph27404.object.User;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link danhsachFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class danhsachFragment extends Fragment {
    private RecyclerView recyclerView;
    private DanhSachAdapter danhSachAdapter;
    private ArrayList<User> userArrayList=new ArrayList<>();

    public danhsachFragment() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static danhsachFragment newInstance() {
        danhsachFragment fragment = new danhsachFragment();

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
        return inflater.inflate(R.layout.fragment_danhsach, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerView=view.findViewById(R.id.id_recycleView);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(linearLayoutManager);
        danhSachAdapter=new DanhSachAdapter(getActivity());
//        userArrayList.add(new User("dithiajshfas","7h15"));
        User user=new User("đi học đi","9H20");
        UserDatabase.getInstance(getActivity()).userDAO().insert(user);
        userArrayList=(ArrayList<User>) UserDatabase.getInstance(getActivity()).userDAO().GetAll();
        danhSachAdapter.setData(userArrayList);
        recyclerView.setAdapter(danhSachAdapter);
    }
}