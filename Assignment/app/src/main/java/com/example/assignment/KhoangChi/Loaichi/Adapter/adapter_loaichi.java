package com.example.assignment.KhoangChi.Loaichi.Adapter;

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

import com.example.assignment.KhoangChi.Loaichi.DAO.LoaiChiDAO;
import com.example.assignment.KhoangChi.Loaichi.DTO.LoaiChi;
import com.example.assignment.KhoangThu.Loaithu.DTO.LoaiThu;
import com.example.assignment.R;

import java.util.ArrayList;

public class adapter_loaichi extends RecyclerView.Adapter<adapter_loaichi.UserViewHolderLC>{
    private ArrayList<LoaiChi> loaiChiArrayList;
    private LoaiChiDAO loaichiDAO;

    public adapter_loaichi(ArrayList<LoaiChi> loaiChiArrayList, LoaiChiDAO loaichiDAO) {
        this.loaiChiArrayList = loaiChiArrayList;
        this.loaichiDAO = loaichiDAO;
    }

    public void setDaTaLC( ArrayList<LoaiChi> loaiChiArrayList){
        this.loaiChiArrayList=loaiChiArrayList;
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public UserViewHolderLC onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_item_loaithu,parent,false);
        return new UserViewHolderLC(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolderLC holder, int position) {
        LoaiChi loaiChi=loaiChiArrayList.get(position);
        final int _index=position;
        if (loaiChi==null){
            return;
        }
        holder.idLC.setText(loaiChi.getIdLC()+"");
        holder.name_loaichi.setText(loaiChi.getName_loaichi());
        holder.icon_editLC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialogEdit(loaiChi,_index, v.getContext());
            }
        });

        holder.icon_deleteLC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder=new  AlertDialog.Builder(v.getContext());
                builder.setTitle("Xóa sinh viên này? ");
                builder.setIcon(android.R.drawable.ic_delete);
                builder.setMessage("Có chắc chắn muốn xóa loại thu này? " + loaiChi.getName_loaichi());

                builder.setPositiveButton("Đồng ý xóa ", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        int kq= loaichiDAO.deleteLT(loaiChi);
                        if(kq>0){
                            loaiChiArrayList.remove(_index);
                            notifyDataSetChanged();
                            Toast.makeText(v.getContext(), "Đã xóa", Toast.LENGTH_SHORT).show();
                        }else{
                            Toast.makeText(v.getContext(), "Không xóa được" + kq, Toast.LENGTH_SHORT).show();
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

    }

    @Override
    public int getItemCount() {
        if(loaiChiArrayList!=null)
            return loaiChiArrayList.size();
        return 0;
    }

    public class UserViewHolderLC extends RecyclerView.ViewHolder {
        private TextView idLC;
        private TextView name_loaichi;
        private ImageView icon_editLC;
        private ImageView icon_deleteLC;
        public UserViewHolderLC(@NonNull View itemView) {
            super(itemView);
            idLC=itemView.findViewById(R.id.id_idTL);
            name_loaichi=itemView.findViewById(R.id.id_tvNameloaithu);
            icon_editLC=itemView.findViewById(R.id.id_editpen);
            icon_deleteLC=itemView.findViewById(R.id.id_edittrash);
        }
    }

    private void  showDialogEdit(LoaiChi loaichi, int index, Context context){
        final Dialog dialog=new Dialog(context, androidx.constraintlayout.widget.R.style.Theme_AppCompat_Light_Dialog_Alert);
        dialog.setContentView(R.layout.dialog_updatelt);

        EditText ed_nameLT=dialog.findViewById(R.id.ed_nameclass);
        ed_nameLT.setText(loaichi.getName_loaichi());

        Button btnupdate=dialog.findViewById(R.id.btn_updateclass);
        btnupdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loaichi.setName_loaichi(ed_nameLT.getText().toString());

                int res=loaichiDAO.updateLT(loaichi);

                if (res>0){
                    loaiChiArrayList.set(index,loaichi);
                    notifyDataSetChanged();

                    Toast.makeText(context, "Đã sửa", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(context, "Không sửa được" + res, Toast.LENGTH_SHORT).show();
                    dialog.dismiss();
                }
            }
        });
        Button buttonwhite=dialog.findViewById(R.id.btn_deleteLCwhite);
        buttonwhite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ed_nameLT.setText("");
            }
        });
        dialog.show();


    }

}
