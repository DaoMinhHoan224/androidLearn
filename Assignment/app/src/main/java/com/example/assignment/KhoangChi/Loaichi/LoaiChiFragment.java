package com.example.assignment.KhoangChi.Loaichi;

import android.app.Dialog;
import android.content.Intent;
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

import com.example.assignment.KhoangChi.Loaichi.Adapter.adapter_loaichi;
import com.example.assignment.KhoangChi.Loaichi.DAO.LoaiChiDAO;
import com.example.assignment.KhoangChi.Loaichi.DTO.LoaiChi;
import com.example.assignment.KhoangThu.Loaithu.DAO.LoaithuDAO;
import com.example.assignment.KhoangThu.Loaithu.DTO.LoaiThu;
import com.example.assignment.KhoangThu.Loaithu.adapter.adapter_recycler;
import com.example.assignment.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link LoaiChiFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class LoaiChiFragment extends Fragment {
    RecyclerView recyclerViewLC;
    adapter_loaichi adapter_loaichii;
    LoaiChiDAO loaiChiDAO;
    FloatingActionButton floatingActionButtonLC;
    ArrayList<LoaiChi> loaiChiArrayList=new ArrayList<>();


    public LoaiChiFragment() {
        // Required empty public constructor
    }


    public static LoaiChiFragment newInstance() {
        LoaiChiFragment fragment = new LoaiChiFragment();

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
        return inflater.inflate(R.layout.fragment_loai_chi, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerViewLC=view.findViewById(R.id.id_recycleviewLC);

        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false);
        recyclerViewLC.setLayoutManager(linearLayoutManager);
        loaiChiDAO=new LoaiChiDAO(getActivity());
        loaiChiDAO.open();

        loaiChiArrayList=loaiChiDAO.getAllLC();

        adapter_loaichii=new adapter_loaichi(loaiChiArrayList,loaiChiDAO);
        adapter_loaichii.setDaTaLC(loaiChiArrayList);
        recyclerViewLC.setAdapter(adapter_loaichii);

        floatingActionButtonLC=view.findViewById(R.id.id_buttoncircleLC);
        floatingActionButtonLC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialogAdd();
            }
        });
    }

//    public void createeDataLC(){
//        loaiChiArrayList.add(new LoaiChi(1,"gkalj"));
//        loaiChiArrayList.add(new LoaiChi(2,"gkalj"));
//        loaiChiArrayList.add(new LoaiChi(3,"gkalj"));
//        loaiChiArrayList.add(new LoaiChi(4,"gkalj"));
//
//
//    }

    private void  showDialogAdd(){
        final Dialog dialog=new Dialog(getActivity(), androidx.constraintlayout.widget.R.style.Theme_AppCompat_Light_Dialog_Alert);
        dialog.setContentView(R.layout.dialog_layout);


        EditText ed_nameLT=dialog.findViewById(R.id.ed_nameclass);


        Button btnsave=dialog.findViewById(R.id.btn_saveclass);
        btnsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LoaiChi loaiChi=new LoaiChi();

                loaiChi.setName_loaichi(ed_nameLT.getText().toString());

                long res=loaiChiDAO.addLC(loaiChi);

                if (res>0){
                    loaiChiArrayList.clear();
                    loaiChiArrayList.addAll(loaiChiDAO.getAllLC());
                    adapter_loaichii.notifyDataSetChanged();


                    Toast.makeText(getActivity(), "Đã thêm mới", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(getActivity(), "Không thêm được" , Toast.LENGTH_SHORT).show();
                    dialog.dismiss();
                }
            }
        });
        Button buttonwhite=dialog.findViewById(R.id.btn_deleteLCwhite);
        buttonwhite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ed_nameLT.setText("");
            }
        });
        dialog.show();
    }
}