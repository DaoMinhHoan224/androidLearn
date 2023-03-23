package com.example.assignment.KhoangThu.Loaithu.adapter;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import com.example.assignment.KhoangThu.Loaithu.DAO.LoaithuDAO;
import com.example.assignment.KhoangThu.Loaithu.DTO.LoaiThu;
import com.example.assignment.R;

import java.util.ArrayList;

public class adapter_recycler extends RecyclerView.Adapter<adapter_recycler.UserViewHolderLT > {

     private ArrayList<LoaiThu> loaiThuArrayList;
     private LoaithuDAO loaithuDAO;
     private LoaiThu objLoaiThu;




    public adapter_recycler(ArrayList<LoaiThu> loaiThuArrayList, LoaithuDAO loaithuDAO) {
        this.loaiThuArrayList=loaiThuArrayList;
        this.loaithuDAO=loaithuDAO;
    }

    public void setDataLT(ArrayList<LoaiThu> loaiThuArrayList){
         this.loaiThuArrayList=loaiThuArrayList;
         notifyDataSetChanged();
    }

    @NonNull
    @Override
    public adapter_recycler.UserViewHolderLT onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_item_loaithu,parent,false);


        return new UserViewHolderLT(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolderLT holder, int position) {
         LoaiThu loaiThu=loaiThuArrayList.get(position);
         final int _index=position;
         if (loaiThu==null){
             return;
         }
         holder.idLT.setText(loaiThu.getLTid()+"");
         holder.name_loaithu.setText(loaiThu.getName_Loaithu());
         holder.icon_edit.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 showDialogEdit(loaiThu,_index, v.getContext());
             }
         });

         holder.icon_delete.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 AlertDialog.Builder builder=new  AlertDialog.Builder(v.getContext());
                 builder.setTitle("Xóa sinh viên này? ");
                 builder.setIcon(android.R.drawable.ic_delete);
                 builder.setMessage("Có chắc chắn muốn xóa loại thu này? " + loaiThu.getName_Loaithu());

                 builder.setPositiveButton("Đồng ý xóa ", new DialogInterface.OnClickListener() {
                     @Override
                     public void onClick(DialogInterface dialog, int which) {
                         int kq= loaithuDAO.deleteLT(loaiThu);
                         if(kq>0){
                             loaiThuArrayList.remove(_index);
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
        if(loaiThuArrayList!=null)
                return loaiThuArrayList.size();
        return 0;
    }



    public class UserViewHolderLT extends RecyclerView.ViewHolder{
               private TextView idLT;
               private TextView name_loaithu;
               private ImageView icon_edit;
               private ImageView icon_delete;

           public UserViewHolderLT(@NonNull View itemView) {
               super(itemView);
               idLT=itemView.findViewById(R.id.id_idTL);
               name_loaithu=itemView.findViewById(R.id.id_tvNameloaithu);
               icon_edit=itemView.findViewById(R.id.id_editpen);
               icon_delete=itemView.findViewById(R.id.id_edittrash);


           }
       }

    private void  showDialogEdit(LoaiThu loaithu, int index,Context context){
        final Dialog dialog=new Dialog(context, androidx.constraintlayout.widget.R.style.Theme_AppCompat_Light_Dialog_Alert);
        dialog.setContentView(R.layout.dialog_updatelt);

        EditText ed_nameLT=dialog.findViewById(R.id.ed_nameclass);
        ed_nameLT.setText(loaithu.getName_Loaithu());

        Button btnupdate=dialog.findViewById(R.id.btn_updateclass);
        btnupdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loaithu.setName_Loaithu(ed_nameLT.getText().toString());

                int res=loaithuDAO.updateLT(loaithu);

                if (res>0){
                    loaiThuArrayList.set(index,loaithu);
                    notifyDataSetChanged();

                    Toast.makeText(context, "Đã sửa", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(context, "Không sửa được" + res, Toast.LENGTH_SHORT).show();
                    dialog.dismiss();
                }
            }
        });
        Button buttonwhite=dialog.findViewById(R.id.btn_deleteLTwhite);
        buttonwhite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ed_nameLT.setText("");

            }
        });
        dialog.show();


    }


}
