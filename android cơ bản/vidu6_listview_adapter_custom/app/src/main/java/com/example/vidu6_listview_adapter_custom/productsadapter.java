package com.example.vidu6_listview_adapter_custom;

import android.content.ClipData;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class productsadapter extends BaseAdapter {
    private ArrayList<products> listProducts;

    //tạo hàm constructor
    public productsadapter(ArrayList<products> listProducts){
        this.listProducts=listProducts;
    }

    @Override
    public int getCount() { //trả về số lượng phần tử trong danh sách

        return listProducts.size();
    }

    @Override
    public Object getItem(int i) { //Trả về phần tử hiện tại tại vị trí thứ i
        products objproducts= listProducts.get(i);
        return objproducts;// trả về phần tử thay cho null
    }

    @Override
    public long getItemId(int i) {
        products objproducts=listProducts.get(i);
        return objproducts.id;//Trả về ID dạng số của phần tử hiện tại
    }

    @Override
    public View getView(int i, View convertView, ViewGroup parent) {
        //hàm này dùng để tùy chỉnh cách hiển thị dữ liệu lên danh sách
        //tạo 1 biến view để tùy chỉnh
        View item_view;
        if(convertView == null){
            item_view=View.inflate(parent.getContext(),R.layout.item_row_listview,null);
        }else{
            item_view= convertView;
        }
        //lấy sản phẩm để làm việc
        products objproducts=listProducts.get(i);
        //ánh xạ các view của dòng
        TextView tv_name=item_view.findViewById(R.id.tv_name);
        TextView tv_price= item_view.findViewById(R.id.tv_price);
        ImageView img=item_view.findViewById(R.id.img_product);

        //gán dữ liệu
        tv_name.setText(objproducts.name);
        tv_price.setText(objproducts.price+"");
        img.setImageResource(objproducts.img_res);
        return item_view;//thay thế null bằng item_view
    }


}
