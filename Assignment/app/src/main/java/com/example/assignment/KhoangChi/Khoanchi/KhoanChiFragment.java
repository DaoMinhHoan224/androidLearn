package com.example.assignment.KhoangChi.Khoanchi;

import android.app.Dialog;
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

import com.example.assignment.KhoangChi.Khoanchi.Adapter.adapter_khoanchi;
import com.example.assignment.KhoangChi.Khoanchi.DAO.KhoanchiDAO;
import com.example.assignment.KhoangChi.Khoanchi.DTO.KhoanChi;
import com.example.assignment.KhoangThu.Khoanthu.DAO.KhoanthuDAO;
import com.example.assignment.KhoangThu.Khoanthu.DTO.KhoanThu;
import com.example.assignment.KhoangThu.Khoanthu.KhoanThuFragment;
import com.example.assignment.KhoangThu.Khoanthu.adapter.adapter_khoanthu;
import com.example.assignment.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link KhoanChiFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class KhoanChiFragment extends Fragment {
    RecyclerView recyclerViewKC;
    adapter_khoanchi adapter_khoanchii;
    ArrayList<KhoanChi> khoanChiArrayList=new ArrayList<>();
    KhoanchiDAO khoanchiDAO;
    FloatingActionButton floatingActionButtonKC;


    public KhoanChiFragment() {
        // Required empty public constructor
    }


    public static KhoanChiFragment newInstance() {
        KhoanChiFragment fragment=new KhoanChiFragment();

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
        return inflater.inflate(R.layout.fragment_khoan_chi, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerViewKC=view.findViewById(R.id.id_recycleviewKC);

        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false);
        recyclerViewKC.setLayoutManager(linearLayoutManager);
        khoanchiDAO=new KhoanchiDAO(getActivity());
        khoanchiDAO.open();

        khoanChiArrayList=khoanchiDAO.getAllKC();


        adapter_khoanchii=new adapter_khoanchi(khoanChiArrayList,khoanchiDAO);
        adapter_khoanchii.setDataKC(khoanChiArrayList);
        recyclerViewKC.setAdapter(adapter_khoanchii);

        floatingActionButtonKC=view.findViewById(R.id.id_buttoncircleKC);
        floatingActionButtonKC.setOnClickListener(new View.OnClickListener() {
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
        dialog.setContentView(R.layout.dialog_addkc);


        EditText ed_nameKC=dialog.findViewById(R.id.ed_nameKCclass);
        EditText ed_dateKC=dialog.findViewById(R.id.ed_dateKCclass);
        EditText ed_moneyKC=dialog.findViewById(R.id.ed_moneyKCclass);


        Button btnsave=dialog.findViewById(R.id.btn_saveKCclass);
        btnsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                KhoanChi khoanchi=new KhoanChi();

                khoanchi.setName_khoanchi(ed_nameKC.getText().toString());
                khoanchi.setNgayKC(ed_dateKC.getText().toString());
                khoanchi.setTienKC(ed_moneyKC.getText().toString());

                long res=khoanchiDAO.addKT(khoanchi);

                if (res>0){

                    khoanChiArrayList.addAll(khoanchiDAO.getAllKC());
                    adapter_khoanchii.notifyDataSetChanged();


                    Toast.makeText(getActivity(), "Đã thêm mới", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(getActivity(), "Không thêm được" , Toast.LENGTH_SHORT).show();
                    dialog.dismiss();
                }
            }
        });
        Button buttonwhite=dialog.findViewById(R.id.btn_deleteKCwhite);
        buttonwhite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ed_nameKC.setText("");
                ed_dateKC.setText("");
                ed_moneyKC.setText("");
            }
        });
        dialog.show();
    }
}