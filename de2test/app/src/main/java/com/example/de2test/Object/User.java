package com.example.de2test.Object;

public class User {
    int id;
    String name_gv;
    String dateTime;
    String chuyennganh;

    public User(String name_gv, String dateTime, String chuyennganh) {
        this.name_gv = name_gv;
        this.dateTime = dateTime;
        this.chuyennganh = chuyennganh;
    }

    public User() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName_gv() {
        return name_gv;
    }

    public void setName_gv(String name_gv) {
        this.name_gv = name_gv;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public String getChuyennganh() {
        return chuyennganh;
    }

    public void setChuyennganh(String chuyennganh) {
        this.chuyennganh = chuyennganh;
    }

    public static final String COL_NAME="test2";
    public static final String COL_NAME_ID="id";
    public static final String COL_NAME_NAMEGV="namegv";
    public static final String COL_NAME_DATETIME="datatime";
    public static final String COL_NAME_CHUYENNGANH="chuyennganh";
}
