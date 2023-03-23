package hoandmph27404.fpoly.lab3_p2_provide_hoandmph27404;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    TextView tv_id,tv_tieude;
    adapter adapternote;
    ListView lvv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Uri uri00011=Uri.parse("content://com.example.lab3_p2_hoandmph27404.Provide/tb_ghichu");
        Cursor cursor=getContentResolver().query(uri00011,null,null ,null,null);
        ArrayList<Note> listNote=new ArrayList<>();
        tv_id=findViewById(R.id.tv_id);
        tv_tieude=findViewById(R.id.tv_title);
        lvv=findViewById(R.id.lv_client);

        adapternote=new adapter(listNote);
        cursor.moveToFirst();

        while (!cursor.isAfterLast()) {
            Note objnote=new Note();
            objnote.setId_note(cursor.getInt(0) );
            objnote.setTieude(cursor.getString(1));
            objnote.setNoidung(cursor.getString(2));
            objnote.setNgaythang(cursor.getString(3));
            listNote.add(objnote);
            cursor.moveToNext();

        }
        cursor.close();
        lvv.setAdapter(adapternote);



    }
}