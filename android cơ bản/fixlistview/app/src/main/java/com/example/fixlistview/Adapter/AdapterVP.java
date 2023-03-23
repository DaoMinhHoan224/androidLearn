package com.example.fixlistview.Adapter;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;

import com.example.fixlistview.DAO.VatphamDAO;
import com.example.fixlistview.DTO.VatPham;
import com.example.fixlistview.R;

import java.util.ArrayList;

public class AdapterVP extends BaseAdapter {
    ArrayList<VatPham> listvp;
    VatphamDAO vatphamDAO;

    public AdapterVP(ArrayList<VatPham> listvp, VatphamDAO vatphamDAO) {
        this.listvp = listvp;
        this.vatphamDAO = vatphamDAO;
    }

    @Override
    public int getCount() {
        return listvp.size();
    }

    @Override
    public Object getItem(int position) {
        return listvp.get(position);
    }

    @Override
    public long getItemId(int position) {
        return listvp.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view;

        if(convertView==null){
            view=View.inflate(parent.getContext(), R.layout.listview,null);
        }else{
            view=convertView;
        }

        final VatPham objVatPham= listvp.get(position);
        final int _index=position;

        TextView tv_idvp=view.findViewById(R.id.tv_stt);
        TextView tv_name=view.findViewById(R.id.tv_name);
        TextView tv_money=view.findViewById(R.id.tv_money);
        TextView tv_del=view.findViewById(R.id.tv_del);
        TextView tv_edit=view.findViewById(R.id.tv_edit);


        tv_idvp.setText(objVatPham.getId()+"");
        tv_name.setText(objVatPham.getName());
        tv_money.setText(objVatPham.getMoney()+"");

        tv_del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder=new AlertDialog.Builder(parent.getContext());
                builder.setTitle("Xoaa vat pham");
                builder.setIcon(android.R.drawable.ic_delete);
                builder.setMessage("Co chac chan xoa " + objVatPham.getName());

                builder.setPositiveButton("dong y xoas", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        int kq=vatphamDAO.deleteNew(objVatPham);

                        if(kq>0){
                            listvp.remove(_index);
                            notifyDataSetChanged();
                            Toast.makeText(parent.getContext(), "Da xoa", Toast.LENGTH_SHORT).show();
                        }else{
                            Toast.makeText(parent.getContext(), "Khong xoa dc", Toast.LENGTH_SHORT).show();
                            dialog.dismiss();
                        }
                    }
                });

                builder.setNegativeButton("Khong xoa", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                AlertDialog dialog= builder.create();
                dialog.show();
            }
        });
        tv_edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showedit(objVatPham,_index, parent.getContext());
            }
        });
        return view;
    }

    public void showadd(Context context){
        final Dialog dialog=new Dialog(context, androidx.appcompat.R.style.Theme_AppCompat_Light_Dialog_Alert);
        dialog.setContentView(R.layout.activity_them);

        EditText ed_name=dialog.findViewById(R.id.ed_name);
        EditText ed_money=dialog.findViewById(R.id.ed_tien);

        Button btnsave=dialog.findViewById(R.id.btn_save);
        btnsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                VatPham vatPham = new VatPham();
                vatPham.setName(ed_name.getText().toString());
                vatPham.setMoney(Double.parseDouble(ed_money.getText().toString()));

                long res=vatphamDAO.addNew(vatPham);
                if(res>0){
                    listvp.clear();
                    listvp.addAll(vatphamDAO.GetAll());
                    notifyDataSetChanged();
                    Toast.makeText(context, "DDax them moi", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(context, "Khong them duoc", Toast.LENGTH_SHORT).show();
                    dialog.dismiss();
                }
            }
        });
        dialog.show();
    }

    public void showedit(VatPham vatpham,int index,Context context){
        final Dialog dialog=new Dialog(context, androidx.appcompat.R.style.Theme_AppCompat_Light_Dialog_Alert);
        dialog.setContentView(R.layout.activity_them);

        EditText ed_name=dialog.findViewById(R.id.ed_name);
        EditText ed_tien=dialog.findViewById(R.id.ed_tien);

        ed_name.setText(vatpham.getName());
        ed_tien.setText(vatpham.getMoney()+"");

        Button btnsave=dialog.findViewById(R.id.btn_save);
        btnsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vatpham.setName(ed_name.getText().toString());
                vatpham.setMoney(Double.parseDouble(ed_tien.getText().toString()));

                int res=vatphamDAO.updateNew(vatpham);
                if(res>0){
                    listvp.set(index,vatpham);
                    notifyDataSetChanged();
                    Toast.makeText(context, "da sua", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(context, "sua khong duoc", Toast.LENGTH_SHORT).show();
                    dialog.dismiss();
                }
            }
        });
        dialog.show();
    }
}
