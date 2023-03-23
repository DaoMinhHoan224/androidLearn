package com.example.lab3_p2_hoandmph27404.adapter;

import android.content.DialogInterface;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;

import com.example.lab3_p2_hoandmph27404.DAO.GhiChuDAO;
import com.example.lab3_p2_hoandmph27404.Note;
import com.example.lab3_p2_hoandmph27404.R;

import java.util.ArrayList;

public class adapter_note extends BaseAdapter {
    ArrayList<Note> listNode;
    GhiChuDAO ghiChuDAO;

    public adapter_note(ArrayList<Note> listNode, GhiChuDAO ghiChuDAO) {
        this.listNode = listNode;
        this.ghiChuDAO = ghiChuDAO;
    }



    @Override
    public int getCount() {
        return listNode.size();
    }

    @Override
    public Object getItem(int position) {
        Note objNote=listNode.get(position);
        return objNote;
    }

    @Override
    public long getItemId(int position) {
        Note objNote=listNode.get(position);
        return objNote.getId_note();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View itemView;
        if (convertView==null){
            itemView=View.inflate(parent.getContext(), R.layout.listview_note,null);
        }else{
            itemView=convertView;
        }

        final Note objNote=listNode.get(position);

        final int _index=position;

        TextView tv_id=itemView.findViewById(R.id.tv_id);
        TextView tv_title=itemView.findViewById(R.id.tv_title);
        TextView tv_delete=itemView.findViewById(R.id.tv_delete);
        TextView tv_update=itemView.findViewById(R.id.tv_update);

        tv_id.setText(objNote.getId_note() + "");
        tv_title.setText(objNote.getTieude());

        tv_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder=new AlertDialog.Builder(parent.getContext());
                builder.setTitle("Xóa sinh viên này? ");
                builder.setIcon(android.R.drawable.ic_delete);
                builder.setMessage("Có chắc chắn muốn xóa ghi chú này? " + objNote.getTieude());

                builder.setPositiveButton("Đồng ý xóa ", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        int kq=ghiChuDAO.delete(objNote);
                        if (kq>0){
                            listNode.remove(_index);
                            notifyDataSetChanged();

                            Toast.makeText(parent.getContext(), "Đã xóa", Toast.LENGTH_SHORT).show();
                        }else{
                            Toast.makeText(parent.getContext(), "Không xóa được", Toast.LENGTH_SHORT).show();
                        }
                        dialog.dismiss();
                    }
                });

                builder.setNegativeButton("Không xóa ", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                AlertDialog dialog= builder.create();
                dialog.show();

            }
        });

        return itemView;
    }
}
