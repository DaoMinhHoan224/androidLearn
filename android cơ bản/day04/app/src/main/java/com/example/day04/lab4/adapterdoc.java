package com.example.day04.lab4;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.day04.R;

import java.util.ArrayList;

public class adapterdoc extends RecyclerView.Adapter<adapterdoc.UserViewHolderLab4doc> {
    private Context mmContext;
    private ArrayList<UserObjectLab4> arrayList4doc;

    public adapterdoc(Context mmContext) {
        this.mmContext = mmContext;
    }

    public void setDatalab4doc(ArrayList<UserObjectLab4> arrayList4){
        this.arrayList4doc=arrayList4;
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public UserViewHolderLab4doc onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_item_lab4doc,parent,false);
        return new UserViewHolderLab4doc(view);

    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolderLab4doc holder, int position) {
        UserObjectLab4 userObjectLab4=arrayList4doc.get(position);
        if (userObjectLab4==null){
            return;
        }
        holder.tvName.setText(userObjectLab4.getName());
        holder.img_hdh.setImageResource(userObjectLab4.getImg4());
        holder.icon_down.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mmContext, "ban da an vao tai xuong", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        if (arrayList4doc!=null)
            return arrayList4doc.size();
        return 0;
    }

    public class UserViewHolderLab4doc extends RecyclerView.ViewHolder {
        private TextView tvName;
        private ImageView img_hdh;
        private ImageView icon_down;
        public UserViewHolderLab4doc(@NonNull View itemView) {
            super(itemView);
            tvName=itemView.findViewById(R.id.id_tvNamedoc);
            img_hdh=itemView.findViewById(R.id.id_avatardoc);
            icon_down=itemView.findViewById(R.id.id_edit);

        }
    }
}
