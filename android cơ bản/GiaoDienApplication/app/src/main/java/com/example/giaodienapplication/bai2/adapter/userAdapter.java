package com.example.giaodienapplication.bai2.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.giaodienapplication.R;
import com.example.giaodienapplication.bai2.object.User;

import java.util.ArrayList;

public class userAdapter extends BaseAdapter {
    private ArrayList<User> data;
    private Context context;
    private int Layout;

    public userAdapter(ArrayList<User> data, Context context, int layout) {
        this.data = data;
        this.context = context;
        this.Layout = layout;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        UserViewHolder userViewHolder = null;
        if(convertView == null){
            userViewHolder = new UserViewHolder();
            // LayoutInflater inflater = ((Activity)context).getLayoutInflater();

            LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(Layout,null);
            userViewHolder.tvAge = convertView.findViewById(R.id.tv_age);
            userViewHolder.tvName = convertView.findViewById(R.id.tv_name);
            userViewHolder.img = convertView.findViewById(R.id.id_img);
            convertView.setTag(userViewHolder);
        }else {
            userViewHolder = (UserViewHolder) convertView.getTag();
        }
        userViewHolder.tvName.setText(data.get(position).getName());
        userViewHolder.tvAge.setText(data.get(position).getOld());
        userViewHolder.img.setImageResource(data.get(position).getImg());
        return convertView;
    }
    public static class UserViewHolder{
        private TextView tvName;
        private TextView tvAge;
        private ImageView img;
    }
}
