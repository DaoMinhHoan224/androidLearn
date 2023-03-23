package com.example.lab6.adapter;

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

import com.example.lab6.DAO.Lab6DAO;
import com.example.lab6.DBHelper.dbhelper;
import com.example.lab6.DTO.Lab6;
import com.example.lab6.R;

import java.util.ArrayList;

public class adapter_lab6 extends RecyclerView.Adapter<adapter_lab6.UserViewHolderLab6>{
    private ArrayList<Lab6> lab6ArrayList;
    private Lab6DAO lab6DAO;
    private dbhelper dbhelper;
    private Context context;

    public adapter_lab6(Context context,ArrayList<Lab6> lab6ArrayList) {
        this.context = context;
        this.lab6ArrayList = lab6ArrayList;
    }

    public adapter_lab6(ArrayList<Lab6> lab6ArrayList, Lab6DAO lab6DAO) {
        this.lab6ArrayList = lab6ArrayList;
        this.lab6DAO = lab6DAO;
    }

    public void setDatalab6(ArrayList<Lab6> lab6ArrayList){
        this.lab6ArrayList=lab6ArrayList;
        notifyDataSetChanged();
    }


    @NonNull
    @Override
    public UserViewHolderLab6 onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_item_lab6,parent,false);
        return new UserViewHolderLab6(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolderLab6 holder, int position) {
        Lab6 lab6=lab6ArrayList.get(position);
        final int _index=position;
        if (lab6==null){
            return;
        }


        holder.name.setText(lab6.getName());
        if(lab6.getImg()==0){
            holder.img.setImageResource(R.drawable.android);
        }else if (lab6.getImg()==1){
            holder.img.setImageResource(R.drawable.apple);
        }else if (lab6.getImg()==2){
            holder.img.setImageResource(R.drawable.blogger);
        }else if (lab6.getImg()==3){
            holder.img.setImageResource(R.drawable.chrome);
        }else if (lab6.getImg()==4){
            holder.img.setImageResource(R.drawable.dell);
        }else if (lab6.getImg()==5){
            holder.img.setImageResource(R.drawable.facebook);
        }else {
            holder.img.setImageResource(R.drawable.firefox);
        }


        holder.icon_edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialogEdit(lab6,_index, v.getContext());
            }
        });

        holder.icon_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder=new  AlertDialog.Builder(v.getContext());
                builder.setTitle("Xóa sinh viên này? ");
                builder.setIcon(android.R.drawable.ic_delete);
                builder.setMessage("Có chắc chắn muốn xóa loại thu này? " + lab6.getName());

                builder.setPositiveButton("Đồng ý xóa ", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        int kq= lab6DAO.deleteLT(lab6);
                        if(kq>0){
                            lab6ArrayList.remove(_index);
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
        if(lab6ArrayList!=null)
            return lab6ArrayList.size();
        return 0;
    }



    public class UserViewHolderLab6 extends RecyclerView.ViewHolder{
        private TextView id;
        private TextView name;
        private ImageView img;
        private ImageView icon_edit;
        private ImageView icon_delete;
        public UserViewHolderLab6(@NonNull View itemView) {
            super(itemView);
            id=itemView.findViewById(R.id.id_id);
            name=itemView.findViewById(R.id.id_tvName);
            img=itemView.findViewById(R.id.id_avatar);
            icon_edit=itemView.findViewById(R.id.id_edit);
            icon_delete=itemView.findViewById(R.id.id_delete);

        }
    }

    private void  showDialogEdit(Lab6 lab6, int index, Context context){
        final Dialog dialog=new Dialog(context, androidx.constraintlayout.widget.R.style.Theme_AppCompat_Light_Dialog_Alert);
        dialog.setContentView(R.layout.dialog_update);

        EditText ed_nameLT=dialog.findViewById(R.id.ed_nameclass);
        ed_nameLT.setText(lab6.getName());

        Button btnupdate=dialog.findViewById(R.id.btn_updateclass);
        btnupdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lab6.setName(ed_nameLT.getText().toString());


                if (lab6DAO.updateLT(lab6)){
                    lab6ArrayList.set(index,lab6);
                    notifyDataSetChanged();

                    Toast.makeText(context, "Đã sửa", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(context, "Không sửa được" , Toast.LENGTH_SHORT).show();
                    dialog.dismiss();
                }
            }
        });
        dialog.show();


    }

}
