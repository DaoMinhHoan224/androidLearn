package com.example.testlan3.Adapter;

import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import com.example.testlan3.DAO.testDAO;
import com.example.testlan3.Object.User;
import com.example.testlan3.R;

import java.util.ArrayList;

public class adapter_DanhSach extends RecyclerView.Adapter<adapter_DanhSach.UserViewHolder>{
    private ArrayList<User> userArrayList;
    private adapter_DanhSach adapter_danhSach;
    private testDAO testdao;
    private Context mcontext;

    public adapter_DanhSach(ArrayList<User> userArrayList, Context mcontext) {
        this.userArrayList = userArrayList;
        this.mcontext = mcontext;
    }

    public adapter_DanhSach(ArrayList<User> userArrayList, testDAO testdao) {
        this.userArrayList = userArrayList;
        this.testdao = testdao;
    }

    public void setData(ArrayList<User> userArrayList){
        this.userArrayList=userArrayList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_item_gv,parent,false);
        return new UserViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
         User user=userArrayList.get(position);
         final int _index=position;

         holder.tvName.setText(user.getNamegv());
         holder.tvNgay.setText(user.getNgaygv());
         holder.tvChuyennganh.setText(user.getChuyennganh());
         holder.imgDelete.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 AlertDialog.Builder builder= new AlertDialog.Builder(v.getContext());
                 builder.setTitle("Xoa giao vien?");
                 builder.setIcon(android.R.drawable.ic_delete);
                 builder.setMessage("Co chac chan muon xoa giao vien nay? " +user.getNamegv());
                 builder.setPositiveButton("Dong y xoa", new DialogInterface.OnClickListener() {
                     @Override
                     public void onClick(DialogInterface dialog, int which) {
                         int kq=testdao.delete(user);
                         if (kq>0){
                             userArrayList.remove(_index);
                             notifyDataSetChanged();
                             Toast.makeText(v.getContext(), "Xoa thanh cong", Toast.LENGTH_SHORT).show();
                         }else{
                             Toast.makeText(v.getContext(), "Xoa khong duoc", Toast.LENGTH_SHORT).show();
                         }
                         dialog.dismiss();
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
    }

    @Override
    public int getItemCount() {
        if (userArrayList!=null)
            return userArrayList.size();
        return 0;
    }

    public class UserViewHolder extends RecyclerView.ViewHolder {
        private TextView tvName,tvNgay,tvChuyennganh;
        private ImageView imgDelete,imgEdit;
        public UserViewHolder(@NonNull View itemView) {
            super(itemView);

            tvName=itemView.findViewById(R.id.id_name);
            tvNgay=itemView.findViewById(R.id.id_datetime);
            tvChuyennganh=itemView.findViewById(R.id.id_chuyennganh);
            imgEdit=itemView.findViewById(R.id.imgEdit);
            imgDelete=itemView.findViewById(R.id.imgDelete);
        }
    }

    public void add(View view){
        EditText ed_name=view.findViewById(R.id.ed_name);
        EditText ed_ngay=view.findViewById(R.id.ed_ngay);
        EditText ed_chuyennganh=view.findViewById(R.id.ed_chuyennganh);

        User user=new User();
        user.setNamegv(ed_name.getText().toString());
        user.setNgaygv(ed_ngay.getText().toString());
        user.setChuyennganh(ed_chuyennganh.getText().toString());

        long kq=testdao.addgv(user);
        if (kq>0){

            userArrayList.addAll(testdao.getALL());
            notifyDataSetChanged();
            Toast.makeText(view.getContext(), "Them moi thanh cong", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(view.getContext(), "them moi that bai", Toast.LENGTH_SHORT).show();
        }
    }

    public void deletewhite(View view){
        EditText ed_name=view.findViewById(R.id.ed_name);
        EditText ed_ngay=view.findViewById(R.id.ed_ngay);
        EditText ed_chuyennganh=view.findViewById(R.id.ed_chuyennganh);

        User user=new User();
        user.setNamegv(ed_name.getText().toString());
        user.setNgaygv(ed_ngay.getText().toString());
        user.setChuyennganh(ed_chuyennganh.getText().toString());

        ed_name.setText("");
        ed_ngay.setText("");
        ed_chuyennganh.setText("");
    }
}
