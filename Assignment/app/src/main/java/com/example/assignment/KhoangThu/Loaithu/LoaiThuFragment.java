package com.example.assignment.KhoangThu.Loaithu;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.assignment.KhoangThu.Loaithu.DAO.LoaithuDAO;
import com.example.assignment.KhoangThu.Loaithu.DTO.LoaiThu;
import com.example.assignment.KhoangThu.Loaithu.adapter.adapter_recycler;
import com.example.assignment.R;
import com.example.assignment.SQLite.DBHelper;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link LoaiThuFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class LoaiThuFragment extends Fragment {
   RecyclerView recyclerViewLT;
     ArrayList<LoaiThu> loaiThuArrayList=new ArrayList<>();
     adapter_recycler adapter_recyclerr;
     LoaithuDAO loaithuDAO;
     DBHelper dbHelper;
     FloatingActionButton floatbutton;
     ImageView img_update;


    public LoaiThuFragment() {
        // Required empty public constructor
    }


    public static LoaiThuFragment newInstance() {
        LoaiThuFragment fragment = new LoaiThuFragment();

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

        return inflater.inflate(R.layout.fragment_loai_thu, container, false);
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerViewLT=view.findViewById(R.id.id_recycleviewLT);

        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false);
        recyclerViewLT.setLayoutManager(linearLayoutManager);
        loaithuDAO=new LoaithuDAO(getActivity());
        loaithuDAO.open();

        loaiThuArrayList=loaithuDAO.getAll();

        adapter_recyclerr=new adapter_recycler(loaiThuArrayList,loaithuDAO);
        adapter_recyclerr.setDataLT(loaiThuArrayList);
        recyclerViewLT.setAdapter(adapter_recyclerr);

        floatbutton=view.findViewById(R.id.id_buttoncircle);
        floatbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialogAdd();
            }
        });

    }

//    public void createeData(){
//        loaiThuArrayList.add(new LoaiThu(1,"rqwrqr"));
//        loaiThuArrayList.add(new LoaiThu(2,"rqrqr"));
//        loaiThuArrayList.add(new LoaiThu(3,"rqwrr"));
//        loaiThuArrayList.add(new LoaiThu(4,"qwrqr"));
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
                LoaiThu loaithu=new LoaiThu();

                loaithu.setName_Loaithu(ed_nameLT.getText().toString());

                long res=loaithuDAO.addLT(loaithu);

                if (res>0){
                    loaiThuArrayList.clear();
                    loaiThuArrayList.addAll(loaithuDAO.getAll());
                     adapter_recyclerr.notifyDataSetChanged();


                    Toast.makeText(getActivity(), "Đã thêm mới", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(getActivity(), "Không thêm được" , Toast.LENGTH_SHORT).show();
                    dialog.dismiss();
                }
            }
        });
        Button buttonwhite=dialog.findViewById(R.id.btn_deleteLTwhite);
        buttonwhite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ed_nameLT.setText("");

            }
        });
        dialog.show();
    }


}
