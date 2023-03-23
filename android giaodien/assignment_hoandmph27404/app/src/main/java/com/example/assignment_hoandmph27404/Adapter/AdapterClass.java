package com.example.assignment_hoandmph27404.Adapter;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;

import com.example.assignment_hoandmph27404.DAO.LOPDao;
import com.example.assignment_hoandmph27404.DTO.TBclass;
import com.example.assignment_hoandmph27404.R;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;

public class AdapterClass extends BaseAdapter {
     ArrayList<TBclass> tbclassArrayList;
     LOPDao lopdao;

    public AdapterClass(ArrayList<TBclass> tbclassArrayList, LOPDao lopdao) {
        this.tbclassArrayList = tbclassArrayList;
        this.lopdao = lopdao;
    }

    @Override
    public int getCount() {
        return tbclassArrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return tbclassArrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return tbclassArrayList.get(position).getId_cl();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view;

        if(convertView==null){
            view=View.inflate(parent.getContext(), R.layout.dulieulop,null);
        }else{
            view=convertView;
        }

        final TBclass objtbclass = tbclassArrayList.get(position);

        final int _index=position;

        TextView tv_idcl=view.findViewById(R.id.tv_id_Class);
        TextView tv_idclass=view.findViewById(R.id.tv_idclass);
        TextView tv_nameclass=view.findViewById(R.id.tv_nameclass);
        TextView tv_delclass=view.findViewById(R.id.tv_del);

        tv_idcl.setText(objtbclass.getId_cl()+"");
        tv_idclass.setText(objtbclass.getId_class());
        tv_nameclass.setText(objtbclass.getTenlop());

//Viết sự kiện bấm nút
        tv_idclass.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                AlertDialog.Builder builder=new AlertDialog.Builder(parent.getContext());
                builder.setTitle("ID class");
                builder.setMessage("ID: " + objtbclass.getId_class() + "\nName: " +objtbclass.getTenlop());
                AlertDialog dialog=builder.create();
                dialog.show();
                return false;
            }
        });

        tv_nameclass.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                AlertDialog.Builder builder=new AlertDialog.Builder(parent.getContext());
                builder.setTitle("Name class");
                builder.setMessage("Name: " + objtbclass.getTenlop());
                AlertDialog dialog=builder.create();
                dialog.show();

                return false;
            }
        });

        tv_delclass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //--Hiển thị dialog hỏi
                AlertDialog.Builder builder = new AlertDialog.Builder(parent.getContext());
                builder.setTitle("Xóa lớp?");
                builder.setIcon(android.R.drawable.ic_delete);
                builder.setMessage("Có chắc chắn xóa nhóm: " + objtbclass.getTenlop());

                builder.setPositiveButton("Đồng ý xóa", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {


                            int kq = lopdao.deleteClass(objtbclass);
                            if (kq > 0) {

                                notifyDataSetChanged();
                                Toast.makeText(parent.getContext(), "Đã xóa", Toast.LENGTH_SHORT).show();
                            } else {
                                Toast.makeText(parent.getContext(), "Không xóa được " + kq, Toast.LENGTH_SHORT).show();
                                dialog.dismiss();
                            }
                        }

                });
                builder.setNegativeButton("Không xóa", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                AlertDialog dialog= builder.create();
                dialog.show();
            }
        });
        return view;
    }

    public void showDialogAdd(Context context){
        final Dialog dialog=new Dialog(context, androidx.constraintlayout.widget.R.style.Theme_AppCompat_Light_Dialog_Alert);
        dialog.setContentView(R.layout.class_layout);
        dialog.setTitle("Thêm mới lớp");

        EditText ed_idclass=dialog.findViewById(R.id.ed_idclass);
        EditText ed_nameclass=dialog.findViewById(R.id.ed_nameclass);

        Button btnsave=dialog.findViewById(R.id.btn_saveclass);
        btnsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 TBclass objclass=new TBclass();
                 objclass.setId_class(ed_idclass.getText().toString());
                 objclass.setTenlop(ed_nameclass.getText().toString());

                 long res=lopdao.addClass(objclass);

                 if (res>0){
                     tbclassArrayList.clear();
                     tbclassArrayList.addAll(lopdao.GetAll());
                      notifyDataSetChanged();
                     Toast.makeText(context, "Đã thêm mới", Toast.LENGTH_SHORT).show();
                 }else{
                     Toast.makeText(context, "Không thêm được", Toast.LENGTH_SHORT).show();
                     dialog.dismiss();
                 }
            }
        });
        Button btndeletewhite=dialog.findViewById(R.id.btn_deletewhite);
        btndeletewhite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ed_idclass.setText("");
                ed_nameclass.setText("");
            }
        });
        dialog.show();
    }
}
