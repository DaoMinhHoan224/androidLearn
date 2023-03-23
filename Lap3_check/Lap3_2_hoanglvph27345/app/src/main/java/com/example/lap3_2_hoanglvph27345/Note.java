package com.example.lap3_2_hoanglvph27345;

public class Note {
    int id_note;
    String title;
    String noidung;
    String ngaythang;

    public static final String TB_NAME = "tb_mynote";
    public static final String COL_ID = "id_note";
    public static final String COL_TITLE = "title";
    public static final String COL_NOIDUNG = "noidung";
    public static final String COL_NGAYTHANg = "ngaythang";




    public int getId_note() {
        return id_note;
    }

    public void setId_note(int id_note) {
        this.id_note = id_note;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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
