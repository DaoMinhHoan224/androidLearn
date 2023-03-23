package com.example.assignment.KhoangChi.Loaichi.DTO;

public class LoaiChi {

    int idLC;
    String name_loaichi;

    public LoaiChi(int idLC, String name_loaichi) {
        this.idLC = idLC;
        this.name_loaichi = name_loaichi;
    }

    public LoaiChi() {
    }

    public int getIdLC() {
        return idLC;
    }

    public void setIdLC(int idLC) {
        this.idLC = idLC;
    }

    public String getName_loaichi() {
        return name_loaichi;
    }

    public void setName_loaichi(String name_loaichi) {
        this.name_loaichi = name_loaichi;
    }

    public static final String TB_NAMELC="asm_loaichi";
    public static final String COL_NAME_IDLC="LCid";
    public static final String COL_NAME_NAMELC="name_loaichi";

}
