package com.example.assignment.SQLite;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {
    static final String DB_Name="asm_tatca";
    static final int DB_Version=1;
    SQLiteDatabase db;

    public DBHelper( Context context) {
        super(context,DB_Name,null,DB_Version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql_insert_loaithu="CREATE TABLE assignment_giaodien (LTid INTEGER NOT NULL,name_loaithu TEXT NOT NULL,PRIMARY KEY(LTid))";
        db.execSQL(sql_insert_loaithu);

        String sql_insert_loaithu1="INSERT INTO assignment_giaodien(name_loaithu) VALUES('Lãi ngân hàng')";
        db.execSQL(sql_insert_loaithu1);
        String sql_insert_loaithu2="INSERT INTO assignment_giaodien(name_loaithu) VALUES('Lương')";
        db.execSQL(sql_insert_loaithu2);
        String sql_insert_loaithu3="INSERT INTO assignment_giaodien(name_loaithu) VALUES('Bán hàng')";
        db.execSQL(sql_insert_loaithu3);
        String sql_insert_loaithu4="INSERT INTO assignment_giaodien(name_loaithu) VALUES('Đòi nợ')";
        db.execSQL(sql_insert_loaithu4);




        String sql_insert_loaichi="CREATE TABLE asm_loaichi (LCid INTEGER NOT NULL,name_loaichi TEXT NOT NULL,PRIMARY KEY(LCid))";
        db.execSQL(sql_insert_loaichi);

        String sql_insert_loaichi1="INSERT INTO asm_loaichi(name_loaichi) VALUES ('Từ thiện')";
        db.execSQL(sql_insert_loaichi1);
        String sql_insert_loaichi2="INSERT INTO asm_loaichi(name_loaichi) VALUES ('Mua đồ')";
        db.execSQL(sql_insert_loaichi2);
        String sql_insert_loaichi3="INSERT INTO asm_loaichi(name_loaichi) VALUES ('Xây nhà')";
        db.execSQL(sql_insert_loaichi3);
        String sql_insert_loaichi4="INSERT INTO asm_loaichi(name_loaichi) VALUES ('Cho vay')";
        db.execSQL(sql_insert_loaichi4);




        String sql_insert_KT="CREATE TABLE asm_giaodienkhoanthu (idKT INTEGER NOT NULL,name_KT TEXT,ngayKT INTEGER,tienKT INTEGER,PRIMARY KEY(idKT))";
        db.execSQL(sql_insert_KT);

        String sql_insert_KT1="INSERT INTO asm_giaodienkhoanthu(name_KT,ngayKT,tienKT) VALUES('Lãi ngân hàng','20/02/2022','1000000000')";
        db.execSQL(sql_insert_KT1);
        String sql_insert_KT2="INSERT INTO asm_giaodienkhoanthu(name_KT,ngayKT,tienKT) VALUES('Lương','20/07/2022','900000000')";
        db.execSQL(sql_insert_KT2);
        String sql_insert_KT3="INSERT INTO asm_giaodienkhoanthu(name_KT,ngayKT,tienKT) VALUES('Bán hàng','02/02/2022','120000000')";
        db.execSQL(sql_insert_KT3);
        String sql_insert_KT4="INSERT INTO asm_giaodienkhoanthu(name_KT,ngayKT,tienKT) VALUES('Đòi nợ','01/10/2022','40000000')";
        db.execSQL(sql_insert_KT4);




        String sql_insert_KC="CREATE TABLE asm_giaodienkhoanchi (idKC INTEGER NOT NULL,name_KC TEXT,ngayKC INTEGER,tienKC INTEGER,PRIMARY KEY(idKC))";
        db.execSQL(sql_insert_KC);

        String sql_insert_KC1="INSERT INTO asm_giaodienkhoanchi(name_KC,ngayKC,tienKC) VALUES('Từ thiện','27/07/2022','2000000000')";
        db.execSQL(sql_insert_KC1);
        String sql_insert_KC2="INSERT INTO asm_giaodienkhoanchi(name_KC,ngayKC,tienKC) VALUES('Mua đồ','10/07/2022','100000000')";
        db.execSQL(sql_insert_KC2);
        String sql_insert_KC3="INSERT INTO asm_giaodienkhoanchi(name_KC,ngayKC,tienKC) VALUES('Xây nhà','29/02/2022','12000000000')";
        db.execSQL(sql_insert_KC3);
        String sql_insert_KC4="INSERT INTO asm_giaodienkhoanchi(name_KC,ngayKC,tienKC) VALUES('Cho vay','10/10/2022','50000000')";
        db.execSQL(sql_insert_KC4);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

}
