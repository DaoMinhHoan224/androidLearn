package com.example.day04.bai3.object;

public class User {
    private String name;
    private String old;
    private int img;



    public User(String name, String old, int img) {
        this.name = name;
        this.old = old;
        this.img = img;
    }
    public User() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOld() {
        return old;
    }

    public void setOld(String old) {
        this.old = old;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }
}
