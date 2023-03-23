package com.example.testlan3.fragment;

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

import com.example.testlan3.Adapter.adapter_DanhSach;
import com.example.testlan3.DAO.testDAO;
import com.example.testlan3.Object.User;
import com.example.testlan3.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link themgiaovienFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class themgiaovienFragment extends Fragment {
    private RecyclerView recyclerView;
    private testDAO testdao;
    private adapter_DanhSach adapter_danhSach;
    private ArrayList<User> userArrayList=new ArrayList<>();
    private Button btnthem,btnhuy;

    public themgiaovienFragment() {
        // Required empty public constructor
    }


    public static themgiaovienFragment newInstance() {
        themgiaovienFragment fragment = new themgiaovienFragment();

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
        return inflater.inflate(R.layout.fragment_themgiaovien, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        testdao=new testDAO(getActivity());
        testdao.open();
        userArrayList=testdao.getALL();
        adapter_danhSach=new adapter_DanhSach(userArrayList,testdao);
        adapter_danhSach.setData(userArrayList);
        btnthem=view.findViewById(R.id.btn_them);
        btnhuy=view.findViewById(R.id.btn_huy);

        btnthem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adapter_danhSach.add(view);
                adapter_danhSach.notifyDataSetChanged();
            }
        });
        btnhuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adapter_danhSach.deletewhite(view);
            }
        });
    }
}