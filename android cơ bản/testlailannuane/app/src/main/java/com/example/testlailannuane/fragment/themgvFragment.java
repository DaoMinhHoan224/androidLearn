package com.example.testlailannuane.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.testlailannuane.Adapter.adapter_danhsach;
import com.example.testlailannuane.DAO.testDAO;
import com.example.testlailannuane.Object.User;
import com.example.testlailannuane.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link themgvFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class themgvFragment extends Fragment {
    private RecyclerView recyclerView;
    private ArrayList<User> userArrayList=new ArrayList<>();
    private adapter_danhsach adapter_danhsach;
    private com.example.testlailannuane.DAO.testDAO testDao;
    private Button btnthem,btnhuy;

    public themgvFragment() {
        // Required empty public constructor
    }


    public static themgvFragment newInstance() {
        themgvFragment fragment = new themgvFragment();

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
        return inflater.inflate(R.layout.fragment_themgv, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerView=view.findViewById(R.id.id_recycleview);

        testDao=new testDAO(getActivity());
        testDao.open();
        userArrayList=testDao.GetAll();
        adapter_danhsach=new adapter_danhsach(userArrayList,testDao);
        adapter_danhsach.setDaTa(userArrayList);

        btnthem=view.findViewById(R.id.btn_them);
        btnhuy=view.findViewById(R.id.btn_huy);
        btnthem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adapter_danhsach.addGVV(view);
                adapter_danhsach.notifyDataSetChanged();
            }
        });


        btnhuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adapter_danhsach.deletewhite(view);
            }
        });
    }
}