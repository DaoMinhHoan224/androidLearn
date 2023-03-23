package com.example.day04.bai4.listview.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.day04.R;
import com.example.day04.bai4.listview.object.korealv;

import java.util.ArrayList;

public class adapter_listview extends BaseAdapter {
    private ArrayList<korealv> dataListkorea;
    private Context context;
    private int layoutList;

    public adapter_listview(ArrayList<korealv> dataListkorea, Context context, int layoutList) {
        this.dataListkorea = dataListkorea;
        this.context = context;
        this.layoutList = layoutList;
    }

    @Override
    public int getCount() {
        return dataListkorea.size();
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
        UserViewHolderList userViewHolderList;
        if (convertView==null){
            userViewHolderList=new UserViewHolderList();
            LayoutInflater inflater=(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView=inflater.inflate(layoutList,null);
            userViewHolderList.tvNamekorea=convertView.findViewById(R.id.id_tvNamekorea);
            userViewHolderList.tvAge=convertView.findViewById(R.id.id_tvAgekorea);
            userViewHolderList.imgKorea=convertView.findViewById(R.id.id_imgList);
            convertView.setTag(userViewHolderList);
        }else{
            userViewHolderList=(UserViewHolderList) convertView.getTag();
        }
        userViewHolderList.tvNamekorea.setText(dataListkorea.get(position).getName_korea());
        userViewHolderList.tvAge.setText(dataListkorea.get(position).getAge());
        userViewHolderList.imgKorea.setImageResource(dataListkorea.get(position).getImg_korea());
        return convertView;
    }

    public static class UserViewHolderList{
        private TextView tvNamekorea;
        private TextView tvAge;
        private ImageView imgKorea;

    }
}
