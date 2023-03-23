package com.example.de2test.adapter;

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

import com.example.de2test.DAO.testDAO;
import com.example.de2test.Object.User;
import com.example.de2test.R;

import java.util.ArrayList;

public class adapter_danhsach extends RecyclerView.Adapter<adapter_danhsach.UserViewHolder> {
    private ArrayList<User> userArrayList;
    private Context mContext;
    private testDAO testDao;

    public adapter_danhsach(ArrayList<User> userArrayList, Context mContext) {
        this.userArrayList = userArrayList;
        this.mContext = mContext;
    }

    public adapter_danhsach(ArrayList<User> userArrayList, testDAO testDao) {
        this.userArrayList = userArrayList;
        this.testDao = testDao;
    }

    public adapter_danhsach() {
    }

    public void setData(ArrayList<User> userArrayList){
        this.userArrayList=userArrayList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_item,parent,false);

        return new UserViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        User user=userArrayList.get(position);
        final int _index=position;
        if (user==null)
            return;

        holder.tvName.setText(user.getName_gv());
        holder.tvChuyennganh.setText(user.getChuyennganh());
        holder.tvDateTime.setText(user.getDateTime());
        holder.imgDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder=new AlertDialog.Builder(v.getContext());
                builder.setTitle("Xóa giáo viên này?");
                builder.setIcon(android.R.drawable.ic_delete);
                builder.setMessage("Có chắc chắn muốn xóa giáo viên này? " + user.getName_gv());
                builder.setPositiveButton("Đồng ý xóa", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        int kq=testDao.delete(user);

                        if (kq>0){
                            userArrayList.remove(_index);
                            notifyDataSetChanged();
                            Toast.makeText(v.getContext(), "Xóa thành công", Toast.LENGTH_SHORT).show();
                        }else{
                            Toast.makeText(v.getContext(), "Không xóa được", Toast.LENGTH_SHORT).show();
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

    public class UserViewHolder extends RecyclerView.ViewHolder{
        private TextView tvName,tvChuyennganh,tvDateTime;
        private ImageView imgEdit,imgDelete;
        public UserViewHolder(@NonNull View itemView) {
            super(itemView);

            tvName=itemView.findViewById(R.id.id_name);
            tvChuyennganh=itemView.findViewById(R.id.id_chuyennganh);
            tvDateTime=itemView.findViewById(R.id.id_datetime);
            imgEdit=itemView.findViewById(R.id.imgEdit);
            imgDelete=itemView.findViewById(R.id.imgDelete);
        }
    }

    public void addGVV(View view){
        EditText ed_name=view.findViewById(R.id.ed_name);
        EditText ed_dateTime=view.findViewById(R.id.ed_ngay);
        EditText ed_chuyennganh=view.findViewById(R.id.ed_chuyennganh);

        User user=new User();
        user.setName_gv(ed_name.getText().toString());
        user.setDateTime(ed_dateTime.getText().toString());
        user.setChuyennganh(ed_chuyennganh.getText().toString());

        long kq=testDao.addGV(user);
        if (kq>0){
            userArrayList.clear();
            userArrayList.addAll(testDao.GetAll());
            notifyDataSetChanged();
            Toast.makeText(view.getContext(), "Them moi thanh cong", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(view.getContext(), "Them moi that bai", Toast.LENGTH_SHORT).show();
        }
    }

    public void deletewhite(View view){
        EditText ed_name=view.findViewById(R.id.ed_name);
        EditText ed_dateTime=view.findViewById(R.id.ed_ngay);
        EditText ed_chuyennganh=view.findViewById(R.id.ed_chuyennganh);

        User user=new User();
        user.setName_gv(ed_name.getText().toString());
        user.setDateTime(ed_dateTime.getText().toString());
        user.setChuyennganh(ed_chuyennganh.getText().toString());

        ed_name.setText("");
        ed_dateTime.setText("");
        ed_chuyennganh.setText("");
    }


}
