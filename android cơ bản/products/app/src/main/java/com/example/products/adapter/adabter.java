package com.example.products.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.products.DTO.Cat2;
import com.example.products.R;

import java.util.ArrayList;

public class adabter extends BaseAdapter {
    ArrayList<Cat2>list;

    public adabter(ArrayList<Cat2> list) {
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        Cat2 objcat=new Cat2();
        return objcat;
    }

    @Override
    public long getItemId(int position) {
        Cat2 objcat=list.get(position);
        return objcat.getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View row;
        if(convertView==null){
           row=View.inflate(parent.getContext(), R.layout.dong_the_loai_2,null);
        }else{
            row=convertView;
        }

        TextView tv_id=row.findViewById(R.id.tv_id);
        TextView tv_name=row.findViewById(R.id.tv_name);
        TextView tv_price=row.findViewById(R.id.tv_price);
        TextView tv_img_res=row.findViewById(R.id.tv_imgres);
        TextView tv_id_cat=row.findViewById(R.id.tv_idcat);

        Cat2 objcat=list.get(position);
        tv_id.setText(objcat.getId());
        tv_name.setText(objcat.getName());
        tv_price.setText(objcat.getPrice()+"");
        tv_img_res.setText(objcat.getImg_res());
        tv_id_cat.setText(objcat.getId_cat());

        return row;
    }
}
