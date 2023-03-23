package com.example.assignment.KhoangChi.Khoanchi.Adapter;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;


import com.example.assignment.KhoangChi.Khoanchi.DAO.KhoanchiDAO;
import com.example.assignment.KhoangChi.Khoanchi.DTO.KhoanChi;
import com.example.assignment.R;

import java.util.ArrayList;

public class adapter_khoanchi extends RecyclerView.Adapter<adapter_khoanchi.UserViewHolderKC> {
    private ArrayList<KhoanChi> khoanChiArrayList;
    private KhoanchiDAO khoanchiDAO;

    public adapter_khoanchi(ArrayList<KhoanChi> khoanChiArrayList, KhoanchiDAO khoanchiDAO) {
        this.khoanChiArrayList = khoanChiArrayList;
        this.khoanchiDAO = khoanchiDAO;
    }

    public void setDataKC(ArrayList<KhoanChi> khoanChiArrayList){
        this.khoanChiArrayList=khoanChiArrayList;
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public UserViewHolderKC onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_item_khoanchi,parent,false);
        return new UserViewHolderKC(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolderKC holder, int position) {
         KhoanChi khoanchi=khoanChiArrayList.get(position);
        final int _index=position;
        if (khoanchi==null){
            return;
        }
        holder.idKC.setText(khoanchi.getIdKC()+"");
        holder.name_khoanchi.setText(khoanchi.getName_khoanchi());
        holder.ngayKC.setText(khoanchi.getNgayKC());
        holder.tienKC.setText(khoanchi.getTienKC());
        holder.icon_editKC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialogEdit(khoanchi,_index,v.getContext());
            }
        });
        holder.icon_deleteKC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder=new AlertDialog.Builder(v.getContext());
                builder.setTitle("Xóa khoản chi này? ");
                builder.setIcon(android.R.drawable.ic_delete);
                builder.setMessage("Có chắc chắn muốn xóa khoản chi này? " + khoanchi.getName_khoanchi());
                builder.setPositiveButton("Đồng ý xóa", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        int kq=khoanchiDAO.deleteKT(khoanchi);

                        if (kq>0){
                            khoanChiArrayList.remove(_index);
                            notifyDataSetChanged();
                            Toast.makeText(v.getContext(), "Đã xóa thành công", Toast.LENGTH_SHORT).show();
                        }else{
                            Toast.makeText(v.getContext(), "Không xóa được", Toast.LENGTH_SHORT).show();
                        }
                        dialog.dismiss();
                    }
                });
                builder.setNegativeButton("Không xóa", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                AlertDialog dialog= builder.create();
                dialog.show();
            }
        });
    }

    @Override
    public int getItemCount() {
        if (khoanChiArrayList!=null)
            return khoanChiArrayList.size();
        return 0;
    }


    public class UserViewHolderKC extends RecyclerView.ViewHolder {
        private TextView idKC;
        private TextView name_khoanchi;
        private TextView ngayKC;
        private TextView tienKC;
        private ImageView icon_editKC;
        private ImageView icon_deleteKC;
        public UserViewHolderKC(@NonNull View itemView) {
            super(itemView);

            idKC=itemView.findViewById(R.id.id_idKC);
            name_khoanchi=itemView.findViewById(R.id.id_nameKC);
            ngayKC=itemView.findViewById(R.id.id_ngayKC);
            tienKC=itemView.findViewById(R.id.id_tienKC);
            icon_editKC=itemView.findViewById(R.id.id_editpenKC);
            icon_deleteKC=itemView.findViewById(R.id.id_edittrashKC);
        }
    }

    private void  showDialogEdit(KhoanChi khoanchi, int index, Context context){
        final Dialog dialog=new Dialog(context, androidx.constraintlayout.widget.R.style.Theme_AppCompat_Light_Dialog_Alert);
        dialog.setContentView(R.layout.dialog_updatekc);

        EditText ed_nameKC=dialog.findViewById(R.id.ed_nameKCclass);
        EditText ed_dateKC=dialog.findViewById(R.id.ed_dateKCclass);
        EditText ed_moneyKC=dialog.findViewById(R.id.ed_moneyKCclass);

        ed_nameKC.setText(khoanchi.getName_khoanchi());
        ed_dateKC.setText(khoanchi.getNgayKC());
        ed_moneyKC.setText(khoanchi.getTienKC());

        Button btnupdateKC=dialog.findViewById(R.id.btn_updateKCclass);
        btnupdateKC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                khoanchi.setName_khoanchi(ed_nameKC.getText().toString());
                khoanchi.setNgayKC(ed_dateKC.getText().toString());
                khoanchi.setTienKC(ed_moneyKC.getText().toString());

                int res=khoanchiDAO.updateKT(khoanchi);

                if (res>0){
                    khoanChiArrayList.set(index,khoanchi);
                    notifyDataSetChanged();

                    Toast.makeText(context, "Đã sửa", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(context, "Không sửa được" + res, Toast.LENGTH_SHORT).show();
                    dialog.dismiss();
                }
            }
        });
        Button buttonwhite=dialog.findViewById(R.id.btn_deleteKCwhite);
        buttonwhite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ed_nameKC.setText("");
                ed_dateKC.setText("");
                ed_moneyKC.setText("");
            }
        });
        dialog.show();


    }
}
