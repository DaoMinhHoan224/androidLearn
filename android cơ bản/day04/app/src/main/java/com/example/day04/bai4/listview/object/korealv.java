package com.example.day04.bai4.listview.object;

public class korealv {
    private int img_korea;
    private String name_korea;
    private int age;

    public korealv(int img_korea, String name_korea, int age) {
        this.img_korea = img_korea;
        this.name_korea = name_korea;
        this.age = age;
    }



    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getImg_korea() {
        return img_korea;
    }

    public void setImg_korea(int img_korea) {
        this.img_korea = img_korea;
    }

    public String getName_korea() {
        return name_korea;
    }

    public void setName_korea(String name_korea) {
        this.name_korea = name_korea;
    }
}

