package com.example.day04.bai5;

public class UserObject {
    private String name;
    private int img;
    private int editBtn;

    public UserObject(String name, int img) {
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

    public int getEditBtn() {
        return editBtn;
    }

    public void setEditBtn(int editBtn) {
        this.editBtn = editBtn;
    }
}
