package com.example.vidu7_curd_products.Adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.vidu7_curd_products.DTO.Cat;
import com.example.vidu7_curd_products.R;

import java.util.ArrayList;

public class CategoryAdapter extends BaseAdapter {

    ArrayList<Cat> listCat;

    public CategoryAdapter(ArrayList<Cat> listCat) {
        this.listCat = listCat;
    }

    @Override
    public int getCount() {
        return listCat.size();
    }

    @Override
    public Object getItem(int position) {
        Cat objCat=listCat.get(position);
        return objCat;
    }

    @Override
    public long getItemId(int position) {
        Cat objCat=listCat.get(position);
        return objCat.getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //1. Tạo view dòng mới
        View row;
         if(convertView==null){
             row=View.inflate(parent.getContext(), R.layout.dong_the_loai,null);
         }else{
             row=convertView;//convertview là tham số của hàm getView
         }
         //2.ánh xạ các view con trong dòng
        TextView tv_id=row.findViewById(R.id.tv_id);
         TextView tv_name=row.findViewById(R.id.tv_name);
         TextView tv_edit=row.findViewById(R.id.tv_edit);
         TextView tv_delete=row.findViewById(R.id.tv_delete);

         //3.gán dữ liệu
        Cat objCat=listCat.get(position);
        tv_id.setText(objCat.getId()+"");
        tv_name.setText(objCat.getName());


        return row;
    }
}
