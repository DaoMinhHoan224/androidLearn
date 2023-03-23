package com.example.testlan4.Object;

public class User {
    int id;
    String namegv;
    String ngaygv;
    String chuyennganhgv;

    public User(String namegv, String ngaygv, String chuyennganhgv) {
        this.namegv = namegv;
        this.ngaygv = ngaygv;
        this.chuyennganhgv = chuyennganhgv;
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

    public String getChuyennganhgv() {
        return chuyennganhgv;
    }

    public void setChuyennganhgv(String chuyennganhgv) {
        this.chuyennganhgv = chuyennganhgv;
    }

    public static final String COL_NAME_TB="detestlai2";
    public static final String COL_NAME_ID="idgv";
    public static final String COL_NAME_NAMEGV="namegv";
    public static final String COL_NAME_CHUYENNGANH="chuyennganhgv";
    public static final String COL_NAME_NGAYGV="ngaygv";
}
