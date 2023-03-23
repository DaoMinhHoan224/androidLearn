package com.example.assignment_hoandmph27404.Adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.assignment_hoandmph27404.DTO.TBclass;
import com.example.assignment_hoandmph27404.R;

import java.util.ArrayList;

public class SpinSVAdapter extends BaseAdapter {
    ArrayList<TBclass> tBclassArrayList;

    public SpinSVAdapter(ArrayList<TBclass> tBclassArrayList) {
        this.tBclassArrayList = tBclassArrayList;
    }

    @Override
    public int getCount() {
        return tBclassArrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return tBclassArrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return tBclassArrayList.get(position).getId_cl();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view;

        if(convertView==null){
            view=View.inflate(parent.getContext(), R.layout.spinner_item,null);
        }else{
            view=convertView;
        }

        final TBclass objclass=tBclassArrayList.get(position);
        final int _index=position;

        TextView sp_id=view.findViewById(R.id.sp_id);
        TextView sp_idclass=view.findViewById(R.id.sp_idclass);
        TextView sp_name=view.findViewById(R.id.sp_name);

        sp_id.setText(objclass.getId_cl()+"");
        sp_idclass.setText(objclass.getId_class());
        sp_name.setText(objclass.getTenlop());

        return view;
    }

}
