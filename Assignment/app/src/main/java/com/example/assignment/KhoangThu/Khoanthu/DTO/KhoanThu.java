package com.example.assignment.KhoangThu.Khoanthu.DTO;

public class KhoanThu {
    int idKT;
    String name_khoanthu;
    String ngay;
    String tien;

    public KhoanThu(int idKT, String name_khoanthu, String ngay, String tien) {
        this.idKT = idKT;
        this.name_khoanthu = name_khoanthu;
        this.ngay = ngay;
        this.tien = tien;
    }

    public KhoanThu() {
    }

    public int getIdKT() {
        return idKT;
    }

    public void setIdKT(int idKT) {
        this.idKT = idKT;
    }

    public String getName_khoanthu() {
        return name_khoanthu;
    }

    public void setName_khoanthu(String name_khoanthu) {
        this.name_khoanthu = name_khoanthu;
    }

    public String getNgay() {
        return ngay;
    }

    public void setNgay(String ngay) {
        this.ngay = ngay;
    }

    public String getTien() {
        return tien;
    }

    public void setTien(String tien) {
        this.tien = tien;
    }

    public static final String TB_NameKTC="asm_giaodienkhoanthu";
    public static final String COL_NAME_IDKTC="idKT";
    public static final String COL_NAME_NAMEKTC="name_KT";
    public static final String COL_NAME_DATE="ngayKT";
    public static final String COL_NAME_MONEY="tienKT";
}
