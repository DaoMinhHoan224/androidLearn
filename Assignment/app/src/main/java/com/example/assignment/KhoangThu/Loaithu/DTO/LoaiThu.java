package com.example.assignment.KhoangThu.Loaithu.DTO;

public class LoaiThu {
    int LTid;
    String name_Loaithu;

    public LoaiThu(int LTid, String name_Loaithu) {
        this.LTid = LTid;
        this.name_Loaithu = name_Loaithu;
    }


    public LoaiThu() {

    }


    public int getLTid() {
        return LTid;
    }

    public void setLTid(int LTid) {
        this.LTid = LTid;
    }

    public String getName_Loaithu() {
        return name_Loaithu;
    }

    public void setName_Loaithu(String name_Loaithu) {
        this.name_Loaithu = name_Loaithu;
    }

    public static final String TB_Namegiaodien="assignment_giaodien";
    public static final String COL_NAME_ID="LTid";
    public static final String COL_NAME_TEN_LOAI_THU="name_loaithu";

}
