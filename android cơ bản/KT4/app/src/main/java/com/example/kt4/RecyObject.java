package com.example.kt4;

public class RecyObject {
    private String name;
    private int img;
    private int edbtn;

    public RecyObject() {
    }

    public RecyObject(String name, int img) {
        this.name = name;
        this.img = img;
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

    public int getEdbtn() {
        return edbtn;
    }

    public void setEdbtn(int edbtn) {
        this.edbtn = edbtn;
    }
}
