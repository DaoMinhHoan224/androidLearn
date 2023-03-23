package com.example.day06listview.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.day06listview.R;
import com.example.day06listview.object.User;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class adapter_view extends BaseAdapter {
    private ArrayList<User> productsArrayList;
    private Context context;
    private int layout_item;

    public adapter_view(ArrayList<User> productsArrayList) {
        this.productsArrayList=productsArrayList;
    }


    @Override
    public int getCount() {
        return productsArrayList.size();
    }

    @Override
    public Object getItem(int position) {
        User user=productsArrayList.get(position);
        return user;
    }

    @Override
    public long getItemId(int position) {

        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        UserViewHolder viewHolder=null;
        if (convertView==null){
            viewHolder=new UserViewHolder();
            LayoutInflater inflater=(LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            convertView=inflater.inflate(layout_item,null);
             viewHolder.tvName=convertView.findViewById(R.id.id_name);
             viewHolder.tvAge=convertView.findViewById(R.id.id_age);
             viewHolder.imgView=convertView.findViewById(R.id.img_product);
             convertView.setTag(viewHolder);
        }else{
            viewHolder=(UserViewHolder) convertView.getTag();
        }
        viewHolder.tvName.setText(productsArrayList.get(position).getName());
        viewHolder.tvAge.setText(productsArrayList.get(position).getAge());
        viewHolder.imgView.setImageResource(productsArrayList.get(position).getImg_res());
        return convertView;
    }

    public static class UserViewHolder{
        private TextView tvName;
        private TextView tvAge;
        private ImageView imgView;
    }
}
