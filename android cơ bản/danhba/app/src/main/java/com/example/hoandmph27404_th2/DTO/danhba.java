package com.example.hoandmph27404_th2.DTO;

public class danhba {
    int id;
    String hoten;
    String sdt;
    String ghichu;

    public danhba() {
    }

    public danhba(int id, String hoten, String sdt, String ghichu) {
        this.id = id;
        this.hoten = hoten;
        this.sdt = sdt;
        this.ghichu = ghichu;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHoten() {
        return hoten;
    }

    public void setHoten(String hoten) {
        this.hoten = hoten;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getGhichu() {
        return ghichu;
    }

    public void setGhichu(String ghichu) {
        this.ghichu = ghichu;
    }

    public static final String TB_NAME="quanlydanhba";
    public static final String COL_NAME_ID="id";
    public static final String COL_NAME_HO_TEN="hoten";
    public static final String COL_NAME_SDT="sdt";
    public static final String COL_NAME_GHI_CHU="ghichu";
}
