package com.example.lap3_2_hoanglvph27345.Adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lap3_2_hoanglvph27345.DAO.NoteDAO;
import com.example.lap3_2_hoanglvph27345.Note;
import com.example.lap3_2_hoanglvph27345.R;

import java.util.ArrayList;

public class AdapterNote extends BaseAdapter {
    ArrayList<Note>listNote ;


    public AdapterNote(ArrayList<Note> listNote ) {
        this.listNote = listNote;

    }

    @Override
    public int getCount() {

        return  listNote.size();
    }

    @Override
    public Object getItem(int position) {
        Note objNote =listNote.get(position);
        return objNote;
    }

    @Override
    public long getItemId(int position) {
        Note objNote =listNote.get(position);
        return objNote.getId_note();
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View itemView;
        if(view == null){
            itemView = View.inflate(viewGroup.getContext(), R.layout.listview_item,null);

        }else{
            itemView = view;
        }

        final Note objNote = listNote.get(i);

        TextView tv_id = itemView.findViewById(R.id.tv_id);
        TextView tv_title = itemView.findViewById(R.id.tv_title);
        TextView tv_delete = itemView.findViewById(R.id.tv_delete);
        TextView tv_edit = itemView.findViewById(R.id.tv_edit);

        tv_id.setText(objNote.getId_note() +"");
        tv_title.setText(objNote.getTitle());
//        tv_edit.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                EditText ed_title = viewGroup.findViewById(R.id.ed_title);
//                EditText ed_noidung = viewGroup.findViewById(R.id.ed_noidung);
//                EditText ed_ngaythang = viewGroup.findViewById(R.id.ed_ngaythang)
//                ed_title.setText(objNote.getTitle());
//                ed_noidung.setText(objNote.getNoidung());
//                ed_ngaythang.setText(objNote.getNgaythang());
//                Button btn_save = itemView.findViewById(R.id.btn_save);
//                btn_save.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        objNote.setTitle(ed_title.getText().toString());
//                        objNote.setNoidung(ed_noidung.getText().toString());
//                        objNote.setNgaythang(ed_ngaythang.getText().toString());
//                        int res = noteDAO.updateRow(objNote);
//                        if(res > 0){
//                                listNote.set(i,objNote);
//                                notifyDataSetChanged();
//                            Toast.makeText(viewGroup.getContext(), "Sửa thành công", Toast.LENGTH_SHORT).show();
//                        }else{
//                            Toast.makeText(viewGroup.getContext(), "sửa kông được", Toast.LENGTH_SHORT).show();
//                        }
//                    }
//                });
//            }
//        });
        return itemView;
    }

}
