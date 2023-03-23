package com.example.assignment_hoandmph27404.DTO;

public class TBclass {
    int id_cl;
    String id_class;
    String Tenlop;

    public TBclass() {
    }

    public TBclass(int id_cl, String id_class, String tenlop) {
        this.id_cl = id_cl;
        this.id_class = id_class;
        Tenlop = tenlop;
    }

    public int getId_cl() {
        return id_cl;
    }

    public void setId_cl(int id_cl) {
        this.id_cl = id_cl;
    }

    public String getId_class() {
        return id_class;
    }

    public void setId_class(String id_class) {
        this.id_class = id_class;
    }

    public String getTenlop() {
        return Tenlop;
    }

    public void setTenlop(String tenlop) {
        Tenlop = tenlop;
    }

    public static final String TB_NameClass="assignmentclassss ";
    public static final String COL_NAME_ID="id_cl";
    public static final String COL_NAME_ID_CLASS="ID_Class";
    public static final String COL_NAME_TEN_LOP="Tenlop";
}
