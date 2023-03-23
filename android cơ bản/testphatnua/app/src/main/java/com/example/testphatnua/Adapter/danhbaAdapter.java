package com.example.testphatnua.Adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.testphatnua.DTO.danhBa;
import com.example.testphatnua.R;

import java.util.ArrayList;

public class danhbaAdapter extends BaseAdapter {
    final ArrayList<danhBa> danhBaArrayList;

    public danhbaAdapter(ArrayList<danhBa> danhBaArrayList) {
        this.danhBaArrayList = danhBaArrayList;
    }

    @Override
    public int getCount() {
        return danhBaArrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return danhBaArrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return danhBaArrayList.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view;
        if(convertView==null){
            view=View.inflate(parent.getContext(), R.layout.custom_list_item_lop,null);
        }else{
            view=convertView;
        }
        danhBa danhba=danhBaArrayList.get(position);

        TextView tv_id=view.findViewById(R.id.tv_id_danhba);
        TextView tv_hoten=view.findViewById(R.id.tv_name_danhba);
        TextView tv_sdt=view.findViewById(R.id.tv_phone_danhba);
        TextView tv_ghichu=view.findViewById(R.id.tv_ghichu_danhba);

        tv_id.setText(String.valueOf(danhba.getId()));
        tv_hoten.setText(danhba.getHoten());
        tv_sdt.setText(danhba.getSdt());
        tv_ghichu.setText(danhba.getGhichu());


        return view;
    }


}
