package com.example.assignment_tkgd.fragment;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

import com.example.assignment_tkgd.R;
import com.example.assignment_tkgd.adapter.KhoanThuAdapter;
import com.example.assignment_tkgd.dao.ThuChiDAO;
import com.example.assignment_tkgd.model.KhoanThuChi;
import com.example.assignment_tkgd.model.Loai;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.HashMap;

public class KhoanThuFragment extends Fragment {
    ListView listViewKhoanThu;
    ThuChiDAO thuChiDAO;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.khoanthu_fragment, container, false);

        //giao diện item
        listViewKhoanThu = view.findViewById(R.id.listViewKhoanThu);
        FloatingActionButton floatAdd = view.findViewById(R.id.floatAdd);

        //data
        thuChiDAO = new ThuChiDAO(getContext());
        loadData();

        floatAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDialogThemKhoanThu();
            }
        });

        return view;
    }

    private void loadData() {
        ArrayList<KhoanThuChi> list = thuChiDAO.getDSKhoanThuChi("thu");

        //adapter
        KhoanThuAdapter adapter = new KhoanThuAdapter(list, getContext(), thuChiDAO, getListSpinner());
        listViewKhoanThu.setAdapter(adapter);
    }

    private ArrayList<HashMap<String, Object>> getListSpinner() {
        ArrayList<HashMap<String, Object>> listSpinner = new ArrayList<>();
        ArrayList<Loai> listLoai = thuChiDAO.getDSLoaiThuChi("thu");
        for (Loai loai : listLoai) {
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put("maloai", loai.getMaloai());
            hashMap.put("tenloai", loai.getTenloai());
            listSpinner.add(hashMap);
        }
        return listSpinner;
    }

    private void showDialogThemKhoanThu() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        LayoutInflater inflater = getLayoutInflater();
        View view = inflater.inflate(R.layout.dialog_themkhoanthu, null);
        Spinner spnLoaiThu = view.findViewById(R.id.spnLoaiThu);
        EditText edtTien = view.findViewById(R.id.edtTien);
        builder.setView(view);

        SimpleAdapter simpleAdapter = new SimpleAdapter(
                getContext(),
                getListSpinner(),
                android.R.layout.simple_list_item_1,
                new String[]{"tenloai"},
                new int[]{android.R.id.text1}
        );
        spnLoaiThu.setAdapter(simpleAdapter);

        builder.setPositiveButton("Thêm", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                String tien = edtTien.getText().toString();
                HashMap<String, Object> selected = (HashMap<String, Object>) spnLoaiThu.getSelectedItem();
                int maloai = (int) selected.get("maloai");
                KhoanThuChi khoanThuChi = new KhoanThuChi(Integer.parseInt(tien), maloai);
                if(thuChiDAO.themMoiKhoanThuChi(khoanThuChi)){
                    Toast.makeText(getContext(), "Thêm thành công", Toast.LENGTH_SHORT).show();
                    loadData();
                }else {
                    Toast.makeText(getContext(), "Không thành công", Toast.LENGTH_SHORT).show();
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
