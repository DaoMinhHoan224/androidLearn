package com.example.thithu2.Adapter;

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

import com.example.thithu2.DAO.VatphamDAO;
import com.example.thithu2.DTO.VatPham;
import com.example.thithu2.R;

import java.util.ArrayList;

public class AdapterVP extends BaseAdapter{
    ArrayList<VatPham> listVP;
    VatphamDAO vatphamDAO;

    public AdapterVP(ArrayList<VatPham> listVP, VatphamDAO vatphamDAO) {
        this.listVP = listVP;
        this.vatphamDAO = vatphamDAO;
    }

    @Override
    public int getCount() {
        return listVP.size();
    }

    @Override
    public Object getItem(int position) {
        return listVP.get(position);
    }

    @Override
    public long getItemId(int position) {
        return listVP.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View view;

        if (convertView==null){
            view=View.inflate(parent.getContext(),R.layout.listview,null);
        }else{
            view=convertView;
        }

        final VatPham objvatpham=listVP.get(position);
        final  int _index=position;

        TextView tv_idvp=view.findViewById(R.id.tv_stt);
        TextView tv_name=view.findViewById(R.id.tv_name);
        TextView tv_money=view.findViewById(R.id.tv_money);
        TextView tv_del=view.findViewById(R.id.tv_del);
        TextView tv_edit=view.findViewById(R.id.tv_edit);

        tv_idvp.setText(objvatpham.getId()+"");
        tv_name.setText(objvatpham.getNaem());
        tv_money.setText(objvatpham.getMoney()+"");

        tv_del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder=new AlertDialog.Builder(parent.getContext());
                builder.setTitle("Xoa vat pham");
                builder.setIcon(android.R.drawable.ic_delete);
                builder.setMessage("Co muon xoa hay khong" +objvatpham.getNaem());
                builder.setPositiveButton("Dong y xoa", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        int kq=vatphamDAO.deleteNew(objvatpham);
                        if (kq>0){
                            listVP.remove(_index);
                            notifyDataSetChanged();
                            Toast.makeText(parent.getContext(), "Da xoa", Toast.LENGTH_SHORT).show();
                        }else{
                            Toast.makeText(parent.getContext(), "Khong xoa duoc", Toast.LENGTH_SHORT).show();
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
                AlertDialog dialog=builder.create();
                dialog.show();
            }
        });
        tv_edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showedit(objvatpham,_index, parent.getContext());
            }
        });


        return view;
    }

    public void showadd(Context context){
        final  Dialog dialog=new Dialog(context, androidx.appcompat.R.style.Theme_AppCompat_Light_Dialog_Alert);
        dialog.setContentView(R.layout.activity_them);

        EditText ed_name=dialog.findViewById(R.id.ed_name);
        EditText ed_money=dialog.findViewById(R.id.ed_money);

        Button btnsave=dialog.findViewById(R.id.btnsave);
        btnsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                VatPham vatpham=new VatPham();
                vatpham.setNaem(ed_name.getText().toString());
                vatpham.setMoney(Double.parseDouble(ed_money.getText().toString()));

                long res=vatphamDAO.Addnew(vatpham);
                if (res>0){
                    listVP.clear();
                    listVP.addAll(vatphamDAO.GetAll());
                    notifyDataSetChanged();
                    Toast.makeText(context, "Da them", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(context, "khong them duoc", Toast.LENGTH_SHORT).show();
                    dialog.dismiss();
                }
            }
        });
        dialog.show();
    }

    public void showedit(VatPham vatpham,int index,Context context){
        final  Dialog dialog=new Dialog(context, androidx.appcompat.R.style.Theme_AppCompat_Light_Dialog_Alert);
        dialog.setContentView(R.layout.activity_them);

        EditText ed_name=dialog.findViewById(R.id.ed_name);
        EditText ed_money=dialog.findViewById(R.id.ed_money);

        ed_name.setText(vatpham.getNaem());
        ed_money.setText(vatpham.getMoney()+"");

        Button btnsave=dialog.findViewById(R.id.btnsave);
        btnsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vatpham.setNaem(ed_name.getText().toString());
                vatpham.setMoney(Double.parseDouble(ed_money.getText().toString()));

                long res=vatphamDAO.updateNew(vatpham);
                if (res>0){
                    listVP.set(index,vatpham);
                    notifyDataSetChanged();
                    Toast.makeText(context, "Da sua", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(context, "khong sua duoc", Toast.LENGTH_SHORT).show();
                    dialog.dismiss();
                }
            }
        });
        dialog.show();
    }
}
