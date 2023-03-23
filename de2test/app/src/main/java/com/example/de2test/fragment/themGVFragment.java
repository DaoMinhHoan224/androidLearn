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
import android.widget.Button;

import com.example.de2test.DAO.testDAO;
import com.example.de2test.Object.User;
import com.example.de2test.R;
import com.example.de2test.adapter.adapter_danhsach;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link themGVFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class themGVFragment extends Fragment {
    private RecyclerView recyclerView;
    private ArrayList<User> userArrayList=new ArrayList<>();
    private com.example.de2test.adapter.adapter_danhsach adapter_danhsach;
    private com.example.de2test.DAO.testDAO testDAO;
    private Button btn_them,btn_huy;


    public themGVFragment() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static themGVFragment newInstance() {
        themGVFragment fragment = new themGVFragment();

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
        return inflater.inflate(R.layout.fragment_them_g_v, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerView=view.findViewById(R.id.id_recycleview);

        testDAO=new testDAO(getActivity());
        testDAO.open();
        userArrayList=testDAO.GetAll();
        adapter_danhsach=new adapter_danhsach(userArrayList,testDAO);
        adapter_danhsach.setData(userArrayList);

        btn_them=view.findViewById(R.id.btn_them);
        btn_huy=view.findViewById(R.id.btn_huy);
        btn_them.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adapter_danhsach.addGVV(view);
                adapter_danhsach.notifyDataSetChanged();
            }
        });

        btn_huy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adapter_danhsach.deletewhite(view);
            }
        });
    }
}