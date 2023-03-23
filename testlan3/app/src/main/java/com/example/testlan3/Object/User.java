package com.example.testlan3.Object;

public class User {
    int id;
    String namegv;
    String ngaygv;
    String chuyennganh;

    public User(String namegv, String ngaygv, String chuyennganh) {
        this.namegv = namegv;
        this.ngaygv = ngaygv;
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

    public String getNgaygv() {
        return ngaygv;
    }

    public void setNgaygv(String ngaygv) {
        this.ngaygv = ngaygv;
    }

    public String getChuyennganh() {
        return chuyennganh;
    }

    public void setChuyennganh(String chuyennganh) {
        this.chuyennganh = chuyennganh;
    }

    public static final String COL_NAMEE="detestlai2";
    public static final String COL_NAME_ID="idgv";
    public static final String COL_NAME_NAMEGV="namegv";
    public static final String COL_NAME_CHUYENNGANH="chuyennganhgv";
    public static final String COL_NAME_NGAYGV="ngaygv";
}
