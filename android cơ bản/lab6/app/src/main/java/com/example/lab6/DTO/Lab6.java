package com.example.lab6.DTO;

public class Lab6 {
    private int id;
    private String name;
    private int img;
    private int btnedit;
    private int btndelete;

    public Lab6(int id, String name, int img) {
        this.id = id;
        this.name = name;
        this.img = img;
    }

    public Lab6() {
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public int getBtnedit() {
        return btnedit;
    }

    public void setBtnedit(int btnedit) {
        this.btnedit = btnedit;
    }

    public int getBtndelete() {
        return btndelete;
    }

    public void setBtndelete(int btndelete) {
        this.btndelete = btndelete;
    }

    public static final String TB_NAMELAB6="lab6";
    public static final String COL_ID="id";
    public static final String COL_NAME="name";
    public static final String COL_IMG="img";
}
