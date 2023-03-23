package com.example.assignment_tkgd.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.SimpleAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;


import com.example.assignment_tkgd.R;
import com.example.assignment_tkgd.dao.ThuChiDAO;
import com.example.assignment_tkgd.model.KhoanThuChi;

import java.util.ArrayList;
import java.util.HashMap;

public class KhoanThuAdapter extends BaseAdapter {
    private ArrayList<KhoanThuChi> list;
    private Context context;
    private ThuChiDAO thuChiDAO;
    private ArrayList<HashMap<String, Object>> listSpinner;

    public KhoanThuAdapter(ArrayList<KhoanThuChi> list, Context context, ThuChiDAO thuChiDAO, ArrayList<HashMap<String, Object>> listSpinner) {
        this.list = list;
        this.context = context;
        this.thuChiDAO = thuChiDAO;
        this.listSpinner = listSpinner;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    public static class ViewOfItem{
        TextView txtTen, txtTien;
        ImageView ivSua, ivXoa;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = ((Activity)context).getLayoutInflater();
        ViewOfItem viewOfItem;

        if(view == null){
            viewOfItem = new ViewOfItem();
            view = inflater.inflate(R.layout.item_khoanthu, null);
            viewOfItem.txtTen = view.findViewById(R.id.txtTen);
            viewOfItem.txtTien = view.findViewById(R.id.txtTien);
            viewOfItem.ivSua = view.findViewById(R.id.ivSua);
            viewOfItem.ivXoa = view.findViewById(R.id.ivXoa);
            view.setTag(viewOfItem);
        }else {
            viewOfItem = (ViewOfItem) view.getTag();
        }

        viewOfItem.txtTen.setText(list.get(i).getTenloai());
        viewOfItem.txtTien.setText(String.valueOf(list.get(i).getTien()));

        viewOfItem.ivSua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDialogSuaKhoanThuChi(list.get(i));
            }
        });

        viewOfItem.ivXoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int makhoan = list.get(i).getMakhoan();
                if(thuChiDAO.xoaKhoanThuChi(makhoan)){
                    Toast.makeText(context, "Xoá thàh công", Toast.LENGTH_SHORT).show();
                    reLoadData();
                }else {
                    Toast.makeText(context, "Không thành công", Toast.LENGTH_SHORT).show();
                }
            }
        });

        return view;
    }

    private void showDialogSuaKhoanThuChi(KhoanThuChi khoanThuChi){
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        LayoutInflater inflater = ((Activity)context).getLayoutInflater();
        View view = inflater.inflate(R.layout.dialog_suakhoanthu, null);
        Spinner spnLoaiThu = view.findViewById(R.id.spnLoaiThu);
        EditText edtTien = view.findViewById(R.id.edtTien);
        builder.setView(view);

        SimpleAdapter adapter = new SimpleAdapter(
                context,
                listSpinner,
                android.R.layout.simple_list_item_1,
                new String[]{"tenloai"},
                new int[]{android.R.id.text1}
        );
        spnLoaiThu.setAdapter(adapter);

        int index = 0;
        int position = -1;
        for(HashMap<String, Object> item : listSpinner){
            if((int) item.get("maloai") == khoanThuChi.getMaloai()){
                position = index;
            }
            index++;
        }
        spnLoaiThu.setSelection(position);

        edtTien.setText(String.valueOf(khoanThuChi.getTien()));

        builder.setPositiveButton("Cập nhật", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                String tien = edtTien.getText().toString();
                HashMap<String, Object> selected = (HashMap<String, Object>) spnLoaiThu.getSelectedItem();
                int maloai = (int) selected.get("maloai");
                khoanThuChi.setMaloai(maloai);
                khoanThuChi.setTien(Integer.parseInt(tien));
                if(thuChiDAO.capNhatKhoanThuChi(khoanThuChi)){
                    Toast.makeText(context, "Cập nhật thành công", Toast.LENGTH_SHORT).show();
                    reLoadData();
                }else {
                    Toast.makeText(context, "Cập nhật thất bại", Toast.LENGTH_SHORT).show();
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

    private void reLoadData(){
        list.clear();
        list = thuChiDAO.getDSKhoanThuChi("thu");
        notifyDataSetChanged();
    }
}
