package com.example.day04.bai4.gridview.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.day04.R;
import com.example.day04.bai4.gridview.object.Logo;

import java.util.ArrayList;

public class LogoGrid extends BaseAdapter {
    private ArrayList<Logo> dataGridLogo;
    private Context context;
    private int layoutgrid;

    public LogoGrid(ArrayList<Logo> dataGridLogo, Context context, int layoutgrid) {
        this.dataGridLogo = dataGridLogo;
        this.context = context;
        this.layoutgrid = layoutgrid;
    }

    @Override
    public int getCount() {
        return dataGridLogo.size();
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
        UserViewHolderGrid userViewHolderGrid=null;
         if (convertView==null){
             userViewHolderGrid=new UserViewHolderGrid();
             LayoutInflater inflater=(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
             convertView=inflater.inflate(layoutgrid,null);
             userViewHolderGrid.tvNamelogo=convertView.findViewById(R.id.tv_namelogoGrid);
             userViewHolderGrid.imgLogo=convertView.findViewById(R.id.img_productGrid);
             convertView.setTag(userViewHolderGrid);
         }else{
             userViewHolderGrid=(UserViewHolderGrid) convertView.getTag();
         }
         userViewHolderGrid.tvNamelogo.setText(dataGridLogo.get(position).getTv_namelogo());
         userViewHolderGrid.imgLogo.setImageResource(dataGridLogo.get(position).getImage_id());
        return convertView;
    }

    public static class UserViewHolderGrid{
        private TextView tvNamelogo;
        private ImageView imgLogo;
    }
}
