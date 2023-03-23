package com.example.assignment.KhoangThu.Khoanthu.adapter;

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

import com.example.assignment.KhoangThu.Khoanthu.DAO.KhoanthuDAO;
import com.example.assignment.KhoangThu.Khoanthu.DTO.KhoanThu;
import com.example.assignment.KhoangThu.Loaithu.DAO.LoaithuDAO;
import com.example.assignment.KhoangThu.Loaithu.DTO.LoaiThu;
import com.example.assignment.R;

import java.util.ArrayList;

public class adapter_khoanthu extends RecyclerView.Adapter<adapter_khoanthu.UserViewHolderKT>{
    private ArrayList<KhoanThu> khoanThuArrayList;
    private KhoanthuDAO khoanthuDAO;

    public adapter_khoanthu(ArrayList<KhoanThu> khoanThuArrayList, KhoanthuDAO khoanthuDAO) {
        this.khoanThuArrayList = khoanThuArrayList;
        this.khoanthuDAO = khoanthuDAO;
    }

    public void setDaTaKT(ArrayList<KhoanThu> khoanThuArrayList){
        this.khoanThuArrayList=khoanThuArrayList;
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public UserViewHolderKT onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_item_khoanthu,parent,false);
        return new UserViewHolderKT(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolderKT holder, int position) {
        KhoanThu khoanThu=khoanThuArrayList.get(position);
        final int _index=position;
        if (khoanThu==null){
            return;
        }
        holder.idKT.setText(khoanThu.getIdKT()+"");
        holder.name_khoanthu.setText(khoanThu.getName_khoanthu());
        holder.ngay.setText(khoanThu.getNgay());
        holder.tien.setText(khoanThu.getTien());
        holder.icon_editKT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialogEdit(khoanThu,_index, v.getContext());
            }
        });

        holder.icon_deleteKT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder=new  AlertDialog.Builder(v.getContext());
                builder.setTitle("Xóa lọai thu này? ");
                builder.setIcon(android.R.drawable.ic_delete);
                builder.setMessage("Có chắc chắn muốn xóa loại thu này? " + khoanThu.getName_khoanthu());

                builder.setPositiveButton("Đồng ý xóa ", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        int kq= khoanthuDAO.deleteKT(khoanThu);
                        if(kq>0){
                            khoanThuArrayList.remove(_index);
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
        if (khoanThuArrayList!=null)
            return khoanThuArrayList.size();
        return 0;
    }

    public class UserViewHolderKT extends RecyclerView.ViewHolder {
        private TextView idKT;
        private TextView name_khoanthu;
        private TextView ngay;
        private TextView tien;
        private ImageView icon_editKT;
        private ImageView icon_deleteKT;
        public UserViewHolderKT(@NonNull View itemView) {
            super(itemView);

            idKT=itemView.findViewById(R.id.id_idTKC);
            name_khoanthu=itemView.findViewById(R.id.id_nameKT);
            ngay=itemView.findViewById(R.id.id_ngayKT);
            tien=itemView.findViewById(R.id.id_tienKT);
            icon_editKT=itemView.findViewById(R.id.id_editpenKT);
            icon_deleteKT=itemView.findViewById(R.id.id_edittrashKT);
        }
    }

    private void  showDialogEdit(KhoanThu khoanthu, int index, Context context){
        final Dialog dialog=new Dialog(context, androidx.constraintlayout.widget.R.style.Theme_AppCompat_Light_Dialog_Alert);
        dialog.setContentView(R.layout.dialog_updatekt);

        EditText ed_nameKT=dialog.findViewById(R.id.ed_nameKTclass);
        EditText ed_dateKT=dialog.findViewById(R.id.ed_dateclass);
        EditText ed_moneyKT=dialog.findViewById(R.id.ed_moneyclass);

        ed_nameKT.setText(khoanthu.getName_khoanthu());
        ed_dateKT.setText(khoanthu.getNgay());
        ed_moneyKT.setText(khoanthu.getTien());

        Button btnupdateKT=dialog.findViewById(R.id.btn_updateKTclass);
        btnupdateKT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                khoanthu.setName_khoanthu(ed_nameKT.getText().toString());
                khoanthu.setNgay(ed_dateKT.getText().toString());
                khoanthu.setTien(ed_moneyKT.getText().toString());

                int res=khoanthuDAO.updateKT(khoanthu);

                if (res>0){
                    khoanThuArrayList.set(index,khoanthu);
                    notifyDataSetChanged();

                    Toast.makeText(context, "Đã sửa", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(context, "Không sửa được" + res, Toast.LENGTH_SHORT).show();
                    dialog.dismiss();
                }
            }
        });
        Button buttonwhite=dialog.findViewById(R.id.btn_deleteKTwhite);
        buttonwhite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ed_nameKT.setText("");
                ed_dateKT.setText("");
                ed_moneyKT.setText("");
            }
        });
        dialog.show();


    }
}
