package com.example.assignment.KhoangThu.Khoanthu;

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

import com.example.assignment.KhoangThu.Khoanthu.DAO.KhoanthuDAO;
import com.example.assignment.KhoangThu.Khoanthu.DTO.KhoanThu;
import com.example.assignment.KhoangThu.Khoanthu.adapter.adapter_khoanthu;
import com.example.assignment.KhoangThu.Loaithu.DAO.LoaithuDAO;
import com.example.assignment.KhoangThu.Loaithu.DTO.LoaiThu;
import com.example.assignment.KhoangThu.Loaithu.adapter.adapter_recycler;
import com.example.assignment.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link KhoanThuFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class KhoanThuFragment extends Fragment {
    RecyclerView recyclerViewKT;
    adapter_khoanthu adapter_khoanthuu;
    ArrayList<KhoanThu> khoanThuArrayList=new ArrayList<>();
    KhoanthuDAO khoanthuDAO;
    FloatingActionButton floatingActionButtonKT;


    public KhoanThuFragment() {
        // Required empty public constructor
    }


    public static KhoanThuFragment newInstance() {
        KhoanThuFragment fragment = new KhoanThuFragment();

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
        return inflater.inflate(R.layout.fragment_khoan_thu, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerViewKT=view.findViewById(R.id.id_recycleviewKT);

        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false);
        recyclerViewKT.setLayoutManager(linearLayoutManager);
        khoanthuDAO=new KhoanthuDAO(getActivity());
        khoanthuDAO.open();

        khoanThuArrayList=khoanthuDAO.getAllKT();

        adapter_khoanthuu=new adapter_khoanthu(khoanThuArrayList,khoanthuDAO);
        adapter_khoanthuu.setDaTaKT(khoanThuArrayList);
        recyclerViewKT.setAdapter(adapter_khoanthuu);

        floatingActionButtonKT=view.findViewById(R.id.id_buttoncircleKT);
        floatingActionButtonKT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialogAdd();
            }
        });
    }

//    public void createeDataKT(){
//        khoanThuArrayList.add(new KhoanThu(1,"gqtq","22/1/2022","213412421421"));
//        khoanThuArrayList.add(new KhoanThu(2,"gqtq","22/1/2022","213412421421"));
//        khoanThuArrayList.add(new KhoanThu(3,"gqtq","22/1/2022","213412421421"));
//        khoanThuArrayList.add(new KhoanThu(4,"gqtq","22/1/2022","213412421421"));
//
//    }

    private void  showDialogAdd(){
        final Dialog dialog=new Dialog(getActivity(), androidx.constraintlayout.widget.R.style.Theme_AppCompat_Light_Dialog_Alert);
        dialog.setContentView(R.layout.dialog_addkt);


        EditText ed_nameKT=dialog.findViewById(R.id.ed_nameKTclass);
        EditText ed_dateKT=dialog.findViewById(R.id.ed_dateclass);
        EditText ed_moneyKT=dialog.findViewById(R.id.ed_moneyclass);


        Button btnsave=dialog.findViewById(R.id.btn_saveKTclass);
        btnsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                KhoanThu khoanthu=new KhoanThu();

                khoanthu.setName_khoanthu(ed_nameKT.getText().toString());
                khoanthu.setNgay(ed_dateKT.getText().toString());
                khoanthu.setTien(ed_moneyKT.getText().toString());

                long res=khoanthuDAO.addKT(khoanthu);

                if (res>0){

                    khoanThuArrayList.addAll(khoanthuDAO.getAllKT());
                    adapter_khoanthuu.notifyDataSetChanged();


                    Toast.makeText(getActivity(), "Đã thêm mới", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(getActivity(), "Không thêm được" , Toast.LENGTH_SHORT).show();
                    dialog.dismiss();
                }
            }
        });
        Button buttonwhite=dialog.findViewById(R.id.btn_deleteKTwhite);
        buttonwhite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ed_nameKT.setText("");
                ed_dateKT.setText("");
                ed_moneyKT.setText("");
            }
        });
        dialog.show();
    }
}