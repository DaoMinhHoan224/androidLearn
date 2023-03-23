package hoandmph27404.fpoly.lab3_p2_provide_hoandmph27404;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;

import java.util.ArrayList;

public class adapter extends BaseAdapter
{

    ArrayList<Note> listNote;

    public adapter(ArrayList<Note> listNote) {
        this.listNote = listNote;
    }

    @Override
    public int getCount() {
        return listNote.size();
    }

    @Override
    public Object getItem(int position) {
        Note objnote=listNote.get(position);
        return objnote;
    }

    @Override
    public long getItemId(int position) {
        Note objNote=listNote.get(position);
        return objNote.getId_note();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view;
        if (convertView==null){
            view=View.inflate(parent.getContext(),R.layout.listview_client,null);
        }else{
            view=convertView;
        }

        final Note objNote=listNote.get(position);

        TextView tv_id=view.findViewById(R.id.tv_id);
        TextView tv_title=view.findViewById(R.id.tv_title);

        tv_id.setText(objNote.getId_note() + "");
        tv_title.setText(objNote.getTieude());

        tv_title.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                AlertDialog.Builder builder=new AlertDialog.Builder(parent.getContext());
                builder.setTitle("Chi tiết ghi chú");
                builder.setMessage("Title " + objNote.getTieude() + "Noi dung" + objNote.getNoidung() +"ngay thang" + objNote.getNgaythang());
                AlertDialog dialog=builder.create();
                dialog.show();
                Log.d("zzz","Hien lennnn");
                return false;
            }
        });
        return view;
    }
}
