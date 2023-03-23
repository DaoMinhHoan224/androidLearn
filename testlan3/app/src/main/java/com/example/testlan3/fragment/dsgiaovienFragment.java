package com.example.testlan3.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.testlan3.Adapter.adapter_DanhSach;
import com.example.testlan3.DAO.testDAO;
import com.example.testlan3.Object.User;
import com.example.testlan3.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link dsgiaovienFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class dsgiaovienFragment extends Fragment implements SwipeRefreshLayout.OnRefreshListener{
     private RecyclerView recyclerView;
     private testDAO testdao;
     private adapter_DanhSach adapter_danhSach;
     private ArrayList<User> userArrayList=new ArrayList<>();
     private SwipeRefreshLayout swipeRefreshLayout;

    public dsgiaovienFragment() {
        // Required empty public constructor
    }

    public static dsgiaovienFragment newInstance() {
        dsgiaovienFragment fragment = new dsgiaovienFragment();

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
        return inflater.inflate(R.layout.fragment_dsgiaovien, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        swipeRefreshLayout=view.findViewById(R.id.id_refresh);
        recyclerView=view.findViewById(R.id.id_recyclevieww);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(linearLayoutManager);
        testdao=new testDAO(getActivity());
        testdao.open();
        userArrayList=testdao.getALL();
        adapter_danhSach=new adapter_DanhSach(userArrayList,testdao);
        adapter_danhSach.setData(userArrayList);
        recyclerView.setAdapter(adapter_danhSach);
        swipeRefreshLayout.setOnRefreshListener(this);


    }

    @Override
    public void onRefresh() {
        adapter_danhSach.setData(userArrayList);
        Handler handler=new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                testdao=new testDAO(getActivity());
                testdao.open();
                userArrayList=testdao.getALL();
                adapter_danhSach=new adapter_DanhSach(userArrayList,testdao);

                recyclerView.setAdapter(adapter_danhSach);
                swipeRefreshLayout.setRefreshing(false);
            }
        },500);
    }
}