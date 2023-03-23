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
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.baitestgiaodienandroid.DAO.testDAO;
import com.example.baitestgiaodienandroid.R;
import com.example.baitestgiaodienandroid.adapter.adapter_danhsach;
import com.example.baitestgiaodienandroid.object.User;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link themghichuFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class themghichuFragment extends Fragment {
    private RecyclerView recyclerVieww;
    private testDAO testDao;
    private adapter_danhsach adapter_danhsach;
    private Button btn_them;
    private ArrayList<User> userArrayList=new ArrayList<>();
    public themghichuFragment() {
        // Required empty public constructor
    }

    public static themghichuFragment newInstance() {
        themghichuFragment fragment = new themghichuFragment();

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
        return inflater.inflate(R.layout.fragment_themghichu, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerVieww=view.findViewById(R.id.id_recycleview);

        testDao=new testDAO(getActivity());
        testDao.open();
        userArrayList=testDao.GetAll();
        adapter_danhsach=new adapter_danhsach(userArrayList,testDao);
        adapter_danhsach.setData(userArrayList);


        btn_them=view.findViewById(R.id.btn_them);
        btn_them.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adapter_danhsach.addgc(view);
            }
        });
    }


}