package com.example.hoandmph27404_th2.Adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.hoandmph27404_th2.DTO.danhba;
import com.example.hoandmph27404_th2.R;

import java.util.ArrayList;

public class DanhbaAdapter extends BaseAdapter {

    final ArrayList<danhba> danhbaArrayList;

    public DanhbaAdapter(ArrayList<danhba> danhbaArrayList) {
        this.danhbaArrayList = danhbaArrayList;
    }

    @Override
    public int getCount() {
        return danhbaArrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return danhbaArrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return danhbaArrayList.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View view;
        if(convertView==null){
            view=View.inflate(parent.getContext(), R.layout.custom_list_item_lop,null);
        }else{
            view=convertView;
        }
        //gán dữ liệu cho phần tử trên view
        //lấy thông tin phần tử hiện tại trong danh sách
        danhba danhbaa=(danhba) danhbaArrayList.get(position);

        TextView tv_id_danhba=view.findViewById(R.id.tv_id_danhba);
        TextView tv_name_danhba=view.findViewById(R.id.tv_name_danhba);
        TextView tv_phone_danhba=view.findViewById(R.id.tv_phone_danhba);
        TextView tv_ghichu_danhba=view.findViewById(R.id.tv_ghichu_danhba);

        tv_id_danhba.setText(String.valueOf(danhbaa.getId()));
        tv_name_danhba.setText(danhbaa.getHoten());
        tv_phone_danhba.setText(danhbaa.getSdt());
        tv_ghichu_danhba.setText(danhbaa.getGhichu());

        return view;
    }
}
