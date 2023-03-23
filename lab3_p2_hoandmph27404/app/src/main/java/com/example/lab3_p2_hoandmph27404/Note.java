package com.example.lab3_p2_hoandmph27404;

public class Note {
    int id_note;
    String tieude;
    String noidung;
    String ngaythang;

    public static final String TB_NAME="tb_ghichu";
    public static final String COL_IDNOTE="id";
    public static final String COL_TIEUDE="tieude";
    public static final String COL_NOIDUNG="noidung";
    public static final String COL_NGAYTHANG="ngaythang";



    public int getId_note() {
        return id_note;
    }

    public void setId_note(int id_note) {
        this.id_note = id_note;
    }

    public String getTieude() {
        return tieude;
    }

    public void setTieude(String tieude) {
        this.tieude = tieude;
    }

    public String getNoidung() {
        return noidung;
    }

    public void setNoidung(String noidung) {
        this.noidung = noidung;
    }

    public String getNgaythang() {
        return ngaythang;
    }

    public void setNgaythang(String ngaythang) {
        this.ngaythang = ngaythang;
    }
}
