package com.dinhnt.asmtutor.fragment;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

import com.dinhnt.asmtutor.R;
import com.dinhnt.asmtutor.adapter.LoaiThuAdapter;
import com.dinhnt.asmtutor.dao.ThuChiDAO;
import com.dinhnt.asmtutor.model.Loai;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class LoaiThuFragment extends Fragment {

    ThuChiDAO thuChiDAO;
    ListView listViewLoaiThu;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.loaithu_fragment, container, false);

        //giao diện item
        listViewLoaiThu = view.findViewById(R.id.listViewLoaiThu);
        FloatingActionButton floatAdd = view.findViewById(R.id.floatAdd);

        //data
        thuChiDAO = new ThuChiDAO(getActivity());
        loadData();

        floatAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //show dialog
                showDialogThem();
            }
        });

        return view;
    }

    private void loadData(){
        ArrayList<Loai> list = thuChiDAO.getDSLoaiThuChi("thu");

        //adapter
        LoaiThuAdapter adapter = new LoaiThuAdapter(list, getActivity(), thuChiDAO);
        listViewLoaiThu.setAdapter(adapter);
    }

    private void showDialogThem(){
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getLayoutInflater();
        View view = inflater.inflate(R.layout.dialog_themloaithu, null);
        EditText edtTen = view.findViewById(R.id.edtTen);
        builder.setView(view);

        builder.setPositiveButton("Thêm", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                String tenloai = edtTen.getText().toString();
                Loai loai = new Loai(tenloai, "thu");
                if(thuChiDAO.themMoiLoaiThuChi(loai)){
                    Toast.makeText(getContext(), "Thêm thành công", Toast.LENGTH_SHORT).show();
                    loadData();
                }else {
                    Toast.makeText(getContext(), "Thêm thất bại", Toast.LENGTH_SHORT).show();
                }
            }
        });

        builder.setNegativeButton("Huỷ", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });

        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }
}
