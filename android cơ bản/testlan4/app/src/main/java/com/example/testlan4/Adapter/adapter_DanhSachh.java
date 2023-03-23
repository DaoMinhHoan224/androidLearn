package com.example.testlan4.Adapter;

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

import com.example.testlan4.DAO.testDAO;
import com.example.testlan4.Object.User;
import com.example.testlan4.R;

import java.util.ArrayList;

public class adapter_DanhSachh extends RecyclerView.Adapter<adapter_DanhSachh.UserViewHolder>{
    private ArrayList<User> userArrayList=new ArrayList<>();
    private Context context;
    private testDAO testdao;

    public adapter_DanhSachh(ArrayList<User> userArrayList, testDAO testdao) {
        this.userArrayList = userArrayList;
        this.testdao = testdao;
    }

    public adapter_DanhSachh(ArrayList<User> userArrayList, Context context) {
        this.userArrayList = userArrayList;
        this.context = context;
    }

    public void setdata(ArrayList<User> userArrayList){
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
        holder.tvChuyennganh.setText(user.getChuyennganhgv());
        holder.imgdelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder=new AlertDialog.Builder(v.getContext());
                builder.setTitle("Xoa giao vien nay?");
                builder.setIcon(android.R.drawable.ic_delete);
                builder.setMessage("Co chac chan muon xoa giao vien nay");
                builder.setPositiveButton("Dong y xoa", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        int kq=testdao.delete(user);
                        if (kq>0){
                            userArrayList.remove(_index);
                            notifyDataSetChanged();
                            Toast.makeText(v.getContext(), "Xoa thanh cong", Toast.LENGTH_SHORT).show();
                        }else{
                            Toast.makeText(v.getContext(), "Xoa that bai", Toast.LENGTH_SHORT).show();
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
            return  userArrayList.size();
        return 0;
    }

    public class UserViewHolder extends RecyclerView.ViewHolder {
        private TextView tvName,tvNgay,tvChuyennganh;
        private ImageView imgedit,imgdelete;
        public UserViewHolder(@NonNull View itemView) {
            super(itemView);

            tvName=itemView.findViewById(R.id.id_name);
            tvNgay=itemView.findViewById(R.id.id_datetime);
            tvChuyennganh=itemView.findViewById(R.id.id_chuyennganh);
            imgedit=itemView.findViewById(R.id.imgEdit);
            imgdelete=itemView.findViewById(R.id.imgDelete);
        }
    }

    public void add(View view){
        EditText ed_name=view.findViewById(R.id.ed_name);
        EditText ed_ngay=view.findViewById(R.id.ed_ngay);
        EditText ed_chuyennganh=view.findViewById(R.id.ed_chuyennganh);

        User user=new User();
        user.setNamegv(ed_name.getText().toString());
        user.setNgaygv(ed_ngay.getText().toString());
        user.setChuyennganhgv(ed_chuyennganh.getText().toString());

        long kq=testdao.addGV(user);
        if (kq>0){
            userArrayList.clear();
            userArrayList.addAll(testdao.Getall());
            notifyDataSetChanged();
            Toast.makeText(view.getContext(), "Them moi thanh cong", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(view.getContext(), "Them moi that bai", Toast.LENGTH_SHORT).show();
        }
    }

    public void deletewhite(View view){
        EditText ed_name=view.findViewById(R.id.ed_name);
        EditText ed_ngay=view.findViewById(R.id.ed_ngay);
        EditText ed_chuyennganh=view.findViewById(R.id.ed_chuyennganh);

        User user=new User();
        user.setNamegv(ed_name.getText().toString());
        user.setNgaygv(ed_ngay.getText().toString());
        user.setChuyennganhgv(ed_chuyennganh.getText().toString());

        ed_name.setText("");
        ed_ngay.setText("");
        ed_chuyennganh.setText("");
    }
}
