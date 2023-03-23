package com.example.hoandmph27404.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hoandmph27404.R;
import com.example.hoandmph27404.object.User;

import java.util.ArrayList;

public class DanhSachAdapter extends RecyclerView.Adapter<DanhSachAdapter.UserViewHolder>{
    private ArrayList<User> userArrayList;
    private Context mContext;

    public DanhSachAdapter(ArrayList<User> userArrayList, Context mContext) {
        this.userArrayList = userArrayList;
        this.mContext = mContext;
    }

    public DanhSachAdapter(FragmentActivity activity) {
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
           User user=userArrayList.get(position);
           if (user==null)
               return;
           holder.tvContent.setText(user.getContent());
           holder.tvDateTime.setText(user.getDateTime());
           holder.imgDelete.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {

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
        private TextView tvContent,tvDateTime;
        private ImageView imgDelete;
        public UserViewHolder(@NonNull View itemView) {
            super(itemView);
            tvContent=itemView.findViewById(R.id.tvContent);
            tvDateTime=itemView.findViewById(R.id.tvDateTime);
            imgDelete=itemView.findViewById(R.id.imgDelete);
        }
    }
}
