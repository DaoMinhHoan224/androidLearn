package com.example.day04.bai4.spinner.object;

public class nationality {
    private int img_national;
    private String name_national;

    public nationality() {
    }

    public nationality(int img_national, String name_national) {
        this.img_national = img_national;
        this.name_national = name_national;
    }

    public int getImg_national() {
        return img_national;
    }

    public void setImg_national(int img_national) {
        this.img_national = img_national;
    }

    public String getName_national() {
        return name_national;
    }

    public void setName_national(String name_national) {
        this.name_national = name_national;
    }
}
