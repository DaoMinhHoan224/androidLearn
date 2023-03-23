package com.example.day04.bai4.spinner.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.day04.R;
import com.example.day04.bai4.spinner.object.nationality;

import java.util.ArrayList;

public class spinner_adapter extends BaseAdapter {
    private ArrayList<nationality> listNationality;
    private Context context;
    private int layoutSpinner;

    public spinner_adapter(ArrayList<nationality> listNationality, Context context, int layoutSpinner) {
        this.listNationality = listNationality;
        this.context = context;
        this.layoutSpinner = layoutSpinner;
    }

    @Override
    public int getCount() {
        return listNationality.size();
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
        UserViewHolderSpinner userViewHolderSpinner;
        if (convertView==null){
            userViewHolderSpinner=new UserViewHolderSpinner();
            LayoutInflater inflater=(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView=inflater.inflate(layoutSpinner,null);
            userViewHolderSpinner.tvNameNational=convertView.findViewById(R.id.id_tvnameNation);
            userViewHolderSpinner.img_national=convertView.findViewById(R.id.id_imgnationl);
            convertView.setTag(userViewHolderSpinner);
        }else{
            userViewHolderSpinner=(UserViewHolderSpinner) convertView.getTag();
        }
        userViewHolderSpinner.tvNameNational.setText(listNationality.get(position).getName_national());
        userViewHolderSpinner.img_national.setImageResource(listNationality.get(position).getImg_national());
        return convertView;
    }

    public static class UserViewHolderSpinner{
        private ImageView img_national;
        private TextView tvNameNational;
    }
}
