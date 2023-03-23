package com.example.assignment_hoandmph27404.DTO;

public class TBsv {
    int Stt;
    String lop;
    String Tensv;
    String Ngaysinh;
    String sdt;
    int id_cl;

    public TBsv() {
    }

    public TBsv(int stt, String lop, String tensv, String ngaysinh, String sdt, int id_cl) {
        Stt = stt;
        this.lop = lop;
        Tensv = tensv;
        Ngaysinh = ngaysinh;
        this.sdt = sdt;
        this.id_cl = id_cl;
    }

    public int getId_cl() {
        return id_cl;
    }

    public void setId_cl(int id_cl) {
        this.id_cl = id_cl;
    }

    public int getStt() {
        return Stt;
    }

    public void setStt(int Stt) {
        this.Stt = Stt;
    }

    public String getLop() {
        return lop;
    }

    public void setLop(String lop) {
        this.lop = lop;
    }

    public String getTensv() {
        return Tensv;
    }

    public void setTensv(String Tensv) {
        this.Tensv = Tensv;
    }

    public String getNgaysinh() {
        return Ngaysinh;
    }

    public void setNgaysinh(String Ngaysinh) {
        this.Ngaysinh = Ngaysinh;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public static final String TB_NameSV="assignmentsv";
    public static final String COL_NAME_STT="Stt";
    public static final String COL_NAME_LOP="Lop";
    public static final String COL_NAME_Tensv="Tensv";
    public static final String COL_NAME_NGAY_SINH="Ngaysinh";
    public static final String COL_NAME_SDT="sdt";
    public static final String COL_NAME_ID_SV="id_cl";

}
