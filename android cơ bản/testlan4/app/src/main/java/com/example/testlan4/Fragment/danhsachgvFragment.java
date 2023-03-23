package com.example.testlan4.Fragment;

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

import com.example.testlan4.Adapter.adapter_DanhSachh;
import com.example.testlan4.DAO.testDAO;
import com.example.testlan4.Object.User;
import com.example.testlan4.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link danhsachgvFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class danhsachgvFragment extends Fragment implements SwipeRefreshLayout.OnRefreshListener {
    private RecyclerView recyclerView;
    private adapter_DanhSachh adapter_danhSachh;
    private testDAO testdao;
    private ArrayList<User> userArrayList=new ArrayList<>();
    private SwipeRefreshLayout swipeRefreshLayout;

    public danhsachgvFragment() {
        // Required empty public constructor
    }


    public static danhsachgvFragment newInstance(String param1, String param2) {
        danhsachgvFragment fragment = new danhsachgvFragment();

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
        return inflater.inflate(R.layout.fragment_danhsachgv, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerView=view.findViewById(R.id.id_recylceview);
        swipeRefreshLayout=view.findViewById(R.id.id_swiperefresh);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(linearLayoutManager);
        testdao=new testDAO(getActivity());
        testdao.open();
        userArrayList=testdao.Getall();
        adapter_danhSachh=new adapter_DanhSachh(userArrayList,testdao);
        adapter_danhSachh.setdata(userArrayList);
        recyclerView.setAdapter(adapter_danhSachh);
        swipeRefreshLayout.setOnRefreshListener(this);

    }

    @Override
    public void onRefresh() {
        adapter_danhSachh.setdata(userArrayList);
        Handler handler=new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                testdao=new testDAO(getActivity());
                testdao.open();
                userArrayList=testdao.Getall();
                adapter_danhSachh=new adapter_DanhSachh(userArrayList,testdao);
                recyclerView.setAdapter(adapter_danhSachh);
                swipeRefreshLayout.setRefreshing(false);
            }
        },500);
    }
}