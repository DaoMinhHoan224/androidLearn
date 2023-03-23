package com.example.testlan4.Fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.testlan4.Adapter.adapter_DanhSachh;
import com.example.testlan4.DAO.testDAO;
import com.example.testlan4.Object.User;
import com.example.testlan4.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link themgvFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class themgvFragment extends Fragment {
    private RecyclerView recyclerView;
    private adapter_DanhSachh adapter_danhSachh;
    private testDAO testdao;
    private ArrayList<User> userArrayList=new ArrayList<>();
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


        testdao=new testDAO(getActivity());
        testdao.open();
        userArrayList=testdao.Getall();
        adapter_danhSachh=new adapter_DanhSachh(userArrayList,testdao);
        adapter_danhSachh.setdata(userArrayList);

        btnthem=view.findViewById(R.id.btn_them);
        btnhuy=view.findViewById(R.id.btn_huy);
        btnthem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adapter_danhSachh.add(view);
            }
        });
        btnhuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adapter_danhSachh.deletewhite(view);
            }
        });
    }
}