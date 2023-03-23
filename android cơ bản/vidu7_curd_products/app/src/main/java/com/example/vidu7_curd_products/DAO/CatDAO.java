package com.example.vidu7_curd_products.DAO;

import android.content.ContentQueryMap;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.vidu7_curd_products.DTO.Cat;
import com.example.vidu7_curd_products.dBhELPER.mydbhelper;

import java.util.ArrayList;

public class CatDAO {
    SQLiteDatabase db;
    mydbhelper dbhelper;
    //viết hàm khởi tạo

    public CatDAO(Context context){
        dbhelper=new mydbhelper(context);
        db=dbhelper.getWritableDatabase();
    }
   //--viết hàm lấy danh sách dữ liệu

   public ArrayList<Cat> selectAll(){
        //khai báo danh sách rỗng
       ArrayList<Cat> listcat=new ArrayList<Cat>();
       //viết lệnh lấy dữ liệu trong csdl

       String sql_select="SELECT * FROM tb_cat";
       Cursor c=db.rawQuery(sql_select,null);
       //kiểm tra có dữ liệu hay không
       if (c.moveToFirst()){
           //có dữ liệu
           while (!c.isAfterLast()){
               //tạo đối tượng ghi dữ liệu
               Cat objCat=new Cat();
               objCat.setId(c.getInt(0));
               objCat.setName(c.getString(1));
               listcat.add(objCat);//đưa đối tượng vào danh sách
               c.moveToNext();//phải chuyển con trỏ sang dòng tiếp theo.
           }
       }

       return listcat;
   }

   //------------------------------
    public long insertRow(Cat objCat){
        //sử dụng ContendValue để chèn dữ liệu
        ContentValues objContent=new ContentValues();
        objContent.put("name",objCat.getName());
        ///thực hiện lệnh insert
        return db.insert("tb_cat",null,objContent);
        //hàm trả về id của dòng mới nhất
    }
    //hàm sửa dữ liệu:đầu vào và objCat phải gắn thêm id dòng muốn sửa

    public int updateRow(Cat objCat){
        ContentValues objContent=new ContentValues();
        objContent.put("name",objCat.getName());
        //tạo ra mảng điều kiện để trúng tuyển vào tham số
        String[] dieu_kien=new String[]{objCat.getId() + ""};
        //thực hiện lệnh cập nhật
        return db.update("tb_cat",objContent,"id= ?",dieu_kien);
        //hàm trả vê số lượng dòng bị xóa

    }
    //hàm xóa:đầu vào là objCat
    public int deleteRow(Cat objCat){
        //tạo mảng điều kiện
        String[] dieu_kien=new String[]{objCat.getId() + ""};
        //thực hiện lệnh cập nhật
        return db.delete("tb_cat","id= ?",dieu_kien);
    }
    //hàm lấy ra 1 dòng ==> trả về 1 cái objCat và đầu vào là id của dòng

    public Cat selectOne(int id){
        Cat objCat=null;//tạo đối tượng rỗng tránh lỗi return

        String[] dieu_kien=new String[]{id + ""};
        // câu lệnh sql
        String sql="SELECT id,name FROM tb_cat WHERE id= ?";

        Cursor c=db.rawQuery(sql,dieu_kien);
        if(c.moveToFirst()){
            //có dữ liệu
            objCat=new Cat();
            objCat.setId(c.getInt(0));
            objCat.setName(c.getString(1));
        }
        return objCat;
    }
}
