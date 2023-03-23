package com.example.baitestgiaodienandroid.adapter;

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
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.baitestgiaodienandroid.DAO.testDAO;
import com.example.baitestgiaodienandroid.R;
import com.example.baitestgiaodienandroid.object.User;

import java.util.ArrayList;

public class adapter_danhsach extends RecyclerView.Adapter<adapter_danhsach.UserViewHolder> {
     private ArrayList<User> userArrayList;
     private Context mContext;
     private testDAO testdao;

    public adapter_danhsach(ArrayList<User> userArrayList, Context mContext) {
        this.userArrayList = userArrayList;
        this.mContext = mContext;
    }

    public adapter_danhsach(ArrayList<User> userArrayList, testDAO testdao) {
        this.userArrayList = userArrayList;
        this.testdao = testdao;
    }

    public adapter_danhsach(FragmentActivity activity) {
    }

    public void setData(ArrayList<User> userArrayList){
        this.userArrayList=userArrayList;
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_item_recycleview,parent,false);
        return new UserViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
          User user= userArrayList.get(position);
          final int _index=position;
          if (user==null)
              return;

          holder.tvContent.setText(user.getContent());
          holder.tvDatetime.setText(user.getDataTime());
          holder.imgDelete.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View v) {
                  AlertDialog.Builder builder=new AlertDialog.Builder(v.getContext());
                  builder.setTitle("Xóa ghi chú này? ");
                  builder.setIcon(android.R.drawable.ic_delete);
                  builder.setMessage("Có chắc chắn muốn xóa ghi chú này? " + user.getContent());

                  builder.setPositiveButton("Đồng ý xóa", new DialogInterface.OnClickListener() {
                      @Override
                      public void onClick(DialogInterface dialog, int which) {
                          int kq=testdao.delete(user);
                          if (kq>0){
                              userArrayList.remove(_index);
                              notifyDataSetChanged();
                              Toast.makeText(v.getContext(), "Da xoa", Toast.LENGTH_SHORT).show();
                          }else{
                              Toast.makeText(v.getContext(), "Khong xoa duoc", Toast.LENGTH_SHORT).show();
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
                  AlertDialog dialog=builder.create();
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
       private TextView tvContent,tvDatetime;
       private Button btn_them;
       private ImageView imgDelete;

        public UserViewHolder(@NonNull View itemView) {
            super(itemView);

            tvContent=itemView.findViewById(R.id.id_content);
            tvDatetime=itemView.findViewById(R.id.id_datetime);
            btn_them=itemView.findViewById(R.id.btn_them);
            imgDelete=itemView.findViewById(R.id.imgDelete);
        }
    }

    public void addgc(View view){
        EditText ed_content=view.findViewById(R.id.ed_content);
        EditText ed_datetime=view.findViewById(R.id.ed_datetime);

        User user=new User();
        user.setContent(ed_content.getText().toString());
        user.setDataTime(ed_datetime.getText().toString());

        long kq=testdao.addT(user);
        if (kq>0){
            userArrayList.clear();
            userArrayList.addAll(testdao.GetAll());
            notifyDataSetChanged();
            Toast.makeText(view.getContext(), "Them moi thanh cong", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(view.getContext(), "them moi that bai", Toast.LENGTH_SHORT).show();
        }
    }
}
