package com.example.baitestgiaodienandroid.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.baitestgiaodienandroid.DAO.testDAO;
import com.example.baitestgiaodienandroid.R;
import com.example.baitestgiaodienandroid.adapter.adapter_danhsach;
import com.example.baitestgiaodienandroid.object.User;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link danhsachFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class danhsachFragment extends Fragment {
    private RecyclerView recyclerView;
    private com.example.baitestgiaodienandroid.adapter.adapter_danhsach adapter_danhsach;
    private ArrayList<User> userArrayList=new ArrayList<>();
    private com.example.baitestgiaodienandroid.DAO.testDAO testdao;

    public danhsachFragment() {
        // Required empty public constructor
    }


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

        recyclerView=view.findViewById(R.id.id_recycleview);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(linearLayoutManager);
        testdao=new testDAO(getActivity());
        testdao.open();
        userArrayList=testdao.GetAll();
        adapter_danhsach=new adapter_danhsach(userArrayList,testdao);
        adapter_danhsach.setData(userArrayList);
        recyclerView.setAdapter(adapter_danhsach);
    }
}