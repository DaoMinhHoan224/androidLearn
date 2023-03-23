package com.example.de2test.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.de2test.DAO.testDAO;
import com.example.de2test.Object.User;
import com.example.de2test.R;
import com.example.de2test.adapter.adapter_danhsach;

import java.util.ArrayList;


public class dsGiaovienFragment extends Fragment {
    private RecyclerView recyclerView;
    private ArrayList<User> userArrayList=new ArrayList<>();
    private com.example.de2test.adapter.adapter_danhsach adapter_danhsach;
    private com.example.de2test.DAO.testDAO testDAO;
    public dsGiaovienFragment() {
        // Required empty public constructor
    }

    public static dsGiaovienFragment newInstance() {
        dsGiaovienFragment fragment = new dsGiaovienFragment();

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
        return inflater.inflate(R.layout.fragment_ds_giaovien, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerView=view.findViewById(R.id.id_recycleview);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(linearLayoutManager);
        testDAO=new testDAO(getActivity());
        testDAO.open();
        userArrayList=testDAO.GetAll();
        adapter_danhsach=new adapter_danhsach(userArrayList,testDAO);
        adapter_danhsach.setData(userArrayList);
        recyclerView.setAdapter(adapter_danhsach);
    }
}