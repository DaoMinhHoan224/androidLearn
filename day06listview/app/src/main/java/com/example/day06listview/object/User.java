package com.example.day06listview.object;

public class User {
//    int id;
    private String name;
    private int age;
    private int img_res;

    public User( String name, int age, int img_res) {
//        this.id = id;
        this.name = name;
        this.age = age;
        this.img_res = img_res;
    }

//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getImg_res() {
        return img_res;
    }

    public void setImg_res(int img_res) {
        this.img_res = img_res;
    }
}
