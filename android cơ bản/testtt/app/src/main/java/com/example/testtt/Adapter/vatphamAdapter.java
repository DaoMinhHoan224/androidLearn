package com.example.testtt.Adapter;

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

import com.example.testtt.DAO.vatphamDAO;
import com.example.testtt.DTO.vatPham;
import com.example.testtt.R;

import java.util.ArrayList;

public class vatphamAdapter extends BaseAdapter {
    ArrayList<vatPham> listVP;
    vatphamDAO vatphamdao;

    public vatphamAdapter(ArrayList<vatPham> listVP, vatphamDAO vatphamdao) {
        this.listVP = listVP;
        this.vatphamdao = vatphamdao;
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

        if (convertView == null) {
            view = View.inflate(parent.getContext(), R.layout.item_listview, null);
        } else {
            view = convertView;
        }

        final vatPham objvatpham = (vatPham) listVP.get(position);
        final int _index = position;

        TextView tv_id = view.findViewById(R.id.tv_stt);
        TextView tv_name = view.findViewById(R.id.tv_name);
        TextView tv_money = view.findViewById(R.id.tv_money);
        TextView tv_del = view.findViewById(R.id.tv_del);
        TextView tv_edit = view.findViewById(R.id.tv_edit);

        tv_id.setText(objvatpham.getId() + "");
        tv_name.setText(objvatpham.getTensp());
        tv_money.setText(objvatpham.getMoney() + "");

        tv_del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(parent.getContext());
                builder.setTitle("Xoá vật phẩm");
                builder.setIcon(android.R.drawable.ic_delete);
                builder.setMessage("Có chắc chắn xóa: " + objvatpham.getTensp());

                builder.setPositiveButton("Đồng ý xóa", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        int kq = vatphamdao.deleteVP(objvatpham);
                        if (kq > 0) {
                            listVP.remove(_index);
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

                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });
        tv_edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialogEdit(objvatpham,_index, parent.getContext());
            }
        });

        return view;
    }

    public void showDialogAdd(Context context){
        final Dialog dialog=new Dialog(context, androidx.constraintlayout.widget.R.style.Theme_AppCompat_Light_Dialog_Alert);

        dialog.setContentView(R.layout.activity_them);

        EditText ed_name=dialog.findViewById(R.id.ed_name);
        EditText ed_money=dialog.findViewById(R.id.ed_tien);

        Button btn_save=dialog.findViewById(R.id.btn_save);
        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vatPham objvatpham=new vatPham();
                objvatpham.setTensp(ed_name.getText().toString());
                objvatpham.setMoney(Double.parseDouble(ed_money.getText().toString()));

                long res=vatphamdao.insertVP(objvatpham);
                if(res > 0){
                    listVP.clear();
                    listVP.addAll(vatphamdao.GetAll());
                    notifyDataSetChanged();
                    Toast.makeText(context, "Đã thêm mới", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(context, "Không thêm được", Toast.LENGTH_SHORT).show();
                    dialog.dismiss();
                }
            }
        });
        dialog.show();

    }

    public void showDialogEdit(vatPham objvatpham, int index, Context context) {

        final Dialog dialog = new Dialog(context, androidx.appcompat.R.style.Theme_AppCompat_Light_Dialog_Alert);

        dialog.setContentView(R.layout.activity_them);

        EditText ed_name = dialog.findViewById(R.id.ed_name);
        ed_name.setText(objvatpham.getTensp());

        EditText ed_money = dialog.findViewById(R.id.ed_tien);
        ed_money.setText(objvatpham.getMoney() + "");

        Button btn_save = dialog.findViewById(R.id.btn_save);
        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                objvatpham.setTensp(ed_name.getText().toString());
                objvatpham.setMoney(Double.parseDouble(ed_money.getText().toString()));

                int res = vatphamdao.updateVP(objvatpham);
                if (res > 0) {
                    listVP.set(index, objvatpham);
                    notifyDataSetChanged();

                    Toast.makeText(context, "Đã sửa", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(context, "Không sửa được", Toast.LENGTH_SHORT).show();
                    dialog.dismiss();
                }
            }
        });
        dialog.show();
    }
}
