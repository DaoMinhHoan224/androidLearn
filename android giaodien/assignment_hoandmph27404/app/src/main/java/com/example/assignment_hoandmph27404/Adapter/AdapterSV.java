package com.example.assignment_hoandmph27404.Adapter;


import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;

import com.example.assignment_hoandmph27404.DAO.SVDao;
import com.example.assignment_hoandmph27404.DTO.TBsv;
import com.example.assignment_hoandmph27404.R;

import java.util.ArrayList;

public class AdapterSV extends BaseAdapter {
    final ArrayList<TBsv> tbsvArrayList;
    SVDao svDao;

    public AdapterSV(ArrayList<TBsv> tbsvArrayList, SVDao svDao) {
        this.tbsvArrayList = tbsvArrayList;
        this.svDao = svDao;
    }


    @Override
    public int getCount() {
        return tbsvArrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return tbsvArrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return tbsvArrayList.get(position).getStt();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

         View view;
         if(convertView==null){
             view=View.inflate(parent.getContext(), R.layout.dulieusinhvien,null);
         }else{
             view=convertView;
         }

         final TBsv objsv=tbsvArrayList.get(position);

        final int _index=position;

        TextView tv_stt=view.findViewById(R.id.tv_svSTT);
        TextView tv_class=view.findViewById(R.id.tv_class);
        TextView tv_namesv=view.findViewById(R.id.tv_namesv);
        TextView tv_date=view.findViewById(R.id.tv_date);
        TextView tv_sdt=view.findViewById(R.id.tv_sdt);

        TextView tv_del=view.findViewById(R.id.tv_del);


        tv_stt.setText(objsv.getStt()+"");
        tv_class.setText(objsv.getLop());
        tv_namesv.setText(objsv.getTensv());
        tv_date.setText(objsv.getNgaysinh());
        tv_sdt.setText(objsv.getSdt());

        tv_del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              AlertDialog.Builder builder=new  AlertDialog.Builder(parent.getContext());
              builder.setTitle("Xóa sinh viên này? ");
              builder.setIcon(android.R.drawable.ic_delete);
              builder.setMessage("Có chắc chắn muốn xóa sinh viên này? " + objsv.getTensv());

              builder.setPositiveButton("Đồng ý xóa ", new DialogInterface.OnClickListener() {
                  @Override
                  public void onClick(DialogInterface dialog, int which) {
                    int kq= svDao.deleteSV(objsv);
                    if(kq>0){
                        tbsvArrayList.remove(_index);
                        notifyDataSetChanged();
                        Toast.makeText(parent.getContext(), "Đã xóa", Toast.LENGTH_SHORT).show();
                    }else{
                        Toast.makeText(parent.getContext(), "Không xóa được" + kq, Toast.LENGTH_SHORT).show();
                    }

                    dialog.dismiss();
                  }
              });

              builder.setNegativeButton("Không xóa", new DialogInterface.OnClickListener() {
                  @Override
                  public void onClick(DialogInterface dialog, int which) {
                      dialog.dismiss();
                  }
              });

              AlertDialog dialog=builder.create();
              dialog.show();
            }
        });




        return view;
    }

}
