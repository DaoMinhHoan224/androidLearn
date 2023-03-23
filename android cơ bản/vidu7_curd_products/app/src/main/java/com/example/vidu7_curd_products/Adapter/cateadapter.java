package com.example.vidu7_curd_products.Adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.vidu7_curd_products.DTO.Cat2;
import com.example.vidu7_curd_products.R;

import java.util.ArrayList;

public class cateadapter extends BaseAdapter {

    ArrayList<Cat2> list;

    public cateadapter(ArrayList<Cat2> list) {
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

        //2.ánh xạ các view
        TextView tv_id=row.findViewById(R.id.tv_id);
        TextView tv_name=row.findViewById(R.id.tv_name);
        TextView tv_price=row.findViewById(R.id.tv_price);
        TextView tv_img_res=row.findViewById(R.id.tv_imgres);
        TextView tv_id_cat=row.findViewById(R.id.tv_idcat);

        Cat2 objCat2=list.get(position);
        tv_id.setText(objCat2.getId()+"");
        tv_name.setText(objCat2.getName());
        tv_price.setText(objCat2.getPrice()+"");
        tv_img_res.setText(objCat2.getImg_res());
        tv_id_cat.setText(objCat2.getId_cat());

        return row;
    }
}
