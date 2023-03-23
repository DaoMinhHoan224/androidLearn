package com.example.hoandmph27404_th2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.hoandmph27404_th2.Adapter.DanhbaAdapter;
import com.example.hoandmph27404_th2.DAO.DanhbaDao;
import com.example.hoandmph27404_th2.DTO.danhba;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText ed_id,ed_hoten,ed_sdt,ed_ghichu;
    DanhbaDao danhbadao;
    DanhbaAdapter danhbaadapter;
    ListView lv_danhba;
    ArrayList<danhba> arraylist;
    danhba currenobjdanhba=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    ed_hoten=findViewById(R.id.ed_name);
    ed_sdt=findViewById(R.id.ed_phone);
    ed_ghichu=findViewById(R.id.ed_note);

    danhbadao=new DanhbaDao(this);
    danhbadao.open();

    arraylist=danhbadao.GetAll();

    danhbaadapter=new DanhbaAdapter(arraylist);
    lv_danhba=findViewById(R.id.lv_tb_danhba    );
    lv_danhba.setAdapter(danhbaadapter);

    lv_danhba.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
        @Override
        public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
            currenobjdanhba=arraylist.get(position);
            ed_hoten.setText(currenobjdanhba.getHoten());
            ed_sdt.setText(currenobjdanhba.getSdt());
            ed_ghichu.setText(currenobjdanhba.getGhichu());
            return false;
        }
    });
    }
    protected void onDestroy(){
        super.onDestroy();
        danhbadao.close();
    }

    public void addRow(View view){
       danhba danhbaa=new danhba();
       danhbaa.setHoten(ed_hoten.getText().toString());
       danhbaa.setSdt(ed_sdt.getText().toString());
       danhbaa.setGhichu(ed_ghichu.getText().toString());

       long kq=danhbadao.addNew(danhbaa);
       if(kq>0){

           arraylist.clear();
          arraylist.addAll(danhbadao.GetAll());
           danhbaadapter.notifyDataSetChanged();
           Toast.makeText(this, "Thêm mới thành công ", Toast.LENGTH_SHORT).show();
       }else{
           Toast.makeText(this, "Thêm mới thất bại", Toast.LENGTH_SHORT).show();
       }

    }
    public void updateRow(View view){
//lấy tên mới sửa trên giao diện cho vào biến
        String hoten_new=ed_hoten.getText().toString();
        String sdt_new=ed_sdt.getText().toString();
        String ghichu_new=ed_ghichu.getText().toString();
//so sánh:nếu chưa set được biến hoặc không có gì thay đổi thì không lưu
        if(currenobjdanhba!=null && (!currenobjdanhba.getHoten().equalsIgnoreCase(hoten_new)     ||
                !currenobjdanhba.getSdt().equalsIgnoreCase(sdt_new) ||
                !currenobjdanhba.getGhichu().equalsIgnoreCase(ghichu_new))){
//cập nhật lại biến curren
            currenobjdanhba.setHoten(hoten_new);
            currenobjdanhba.setSdt(sdt_new);
            currenobjdanhba.setGhichu(ghichu_new);

            int res=danhbadao.update(currenobjdanhba);
            if(res>0){
                ed_hoten.setText("");
                ed_sdt.setText("");
                ed_ghichu.setText("");

                arraylist.clear();
                arraylist.addAll(danhbadao.GetAll());
                danhbaadapter.notifyDataSetChanged();
                Toast.makeText(this, "Cập nhật thành công", Toast.LENGTH_SHORT).show();
                currenobjdanhba=null;
            }else{
                Toast.makeText(this, "Cập nhật thất bại", Toast.LENGTH_SHORT).show();
            }
        }else{
            Toast.makeText(this, "Không có gì thay đổi để cập nhật", Toast.LENGTH_SHORT).show();
        }
    }
    public void deleteRow(View view){
       if (currenobjdanhba!=null){
           int res=danhbadao.delete(currenobjdanhba);

           if(res>0) {
               arraylist.clear();
               arraylist.addAll(danhbadao.GetAll());
               danhbaadapter.notifyDataSetChanged();
               ed_hoten.setText("");
               ed_sdt.setText("");
               ed_ghichu.setText("");
               Toast.makeText(this, "Đã xóa thành công: "+ currenobjdanhba.getHoten(), Toast.LENGTH_SHORT).show();
           }else{
               Toast.makeText(this, "Lỗi xóa", Toast.LENGTH_SHORT).show();
           }
       }else{
           Toast.makeText(this, "Hãy bấm và giữ  bản ghi nào đó trước khi bấm xóa", Toast.LENGTH_SHORT).show();
       }
    }

}