package com.example.assignment.KhoangChi.Khoanchi.DTO;

public class KhoanChi {
    int idKC;
    String name_khoanchi;
    String ngayKC;
    String tienKC;

    public KhoanChi(int idKC, String name_khoanchi, String ngayKC, String tienKC) {
        this.idKC = idKC;
        this.name_khoanchi = name_khoanchi;
        this.ngayKC = ngayKC;
        this.tienKC = tienKC;
    }

    public KhoanChi() {
    }

    public int getIdKC() {
        return idKC;
    }

    public void setIdKC(int idKC) {
        this.idKC = idKC;
    }

    public String getName_khoanchi() {
        return name_khoanchi;
    }

    public void setName_khoanchi(String name_khoanchi) {
        this.name_khoanchi = name_khoanchi;
    }

    public String getNgayKC() {
        return ngayKC;
    }

    public void setNgayKC(String ngayKC) {
        this.ngayKC = ngayKC;
    }

    public String getTienKC() {
        return tienKC;
    }

    public void setTienKC(String tienKC) {
        this.tienKC = tienKC;
    }

    public static final String TB_NameKC="asm_giaodienkhoanchi";
    public static final String COL_NAME_IDKC="idKC";
    public static final String COL_NAME_NAMEKC="name_KC";
    public static final String COL_NAME_DATEKC="ngayKC";
    public static final String COL_NAME_MONEYKC="tienKC";
}
