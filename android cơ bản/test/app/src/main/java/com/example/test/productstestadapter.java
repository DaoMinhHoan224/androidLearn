package com.example.test;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class productstestadapter extends BaseAdapter {

    ArrayList<productstest> list;

    public productstestadapter( ArrayList<productstest> list){
        this.list=list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
productstest objProductstest=list.get(i);
        return objProductstest;
    }

    @Override
    public long getItemId(int i) {
        productstest objProductstest=list.get(i);
        return objProductstest.id;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup parent) {

        View item_view;
        if(convertView == null){
            item_view=View.inflate(parent.getContext(),R.layout.linearlayoutadapter,null);

        }else{
            item_view=convertView;
        }
        productstest objProductstest=list.get(i);
        TextView tv_name=item_view.findViewById(R.id.tv_name);
        TextView tv_price=item_view.findViewById(R.id.tv_price);
        ImageView img=item_view.findViewById(R.id.img_product);

        tv_name.setText(objProductstest.name);
        tv_price.setText(objProductstest.price+"");
        img.setImageResource(objProductstest.img_res);
        return item_view;
    }
}
