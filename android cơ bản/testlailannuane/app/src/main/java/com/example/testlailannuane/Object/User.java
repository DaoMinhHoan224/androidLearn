package com.example.testlailannuane.Object;

public class User {
    int id;
    String namegv;
    String datetime;
    String chuyennganh;

    public User(String namegv, String datetime, String chuyennganh) {
        this.namegv = namegv;
        this.datetime = datetime;
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

    public String getNamegv() {
        return namegv;
    }

    public void setNamegv(String namegv) {
        this.namegv = namegv;
    }

    public String getDatetime() {
        return datetime;
    }

    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }

    public String getChuyennganh() {
        return chuyennganh;
    }

    public void setChuyennganh(String chuyennganh) {
        this.chuyennganh = chuyennganh;
    }

    public static final String COL_NAME="test2";
    public static final String COL_NAME_ID="id";
    public static final String COL_NAME_GV="namegv";
    public static final String COL_NAME_DATETIME="datatime";
    public static final String COL_NAME_CHUYENNGANH="chuyennganh";
}
