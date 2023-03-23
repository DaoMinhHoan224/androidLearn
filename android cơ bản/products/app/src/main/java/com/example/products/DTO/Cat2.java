package com.example.products.DTO;

public class Cat2 {
    int id;
    String name;
    double price;
    String img_res;
    String id_cat;

    public Cat2() {
    }

    public Cat2(int id, String name, double price, String img_res, String id_cat) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.img_res = img_res;
        this.id_cat = id_cat;
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getImg_res() {
        return img_res;
    }

    public void setImg_res(String img_res) {
        this.img_res = img_res;
    }

    public String getId_cat() {
        return id_cat;
    }

    public void setId_cat(String id_cat) {
        this.id_cat = id_cat;
    }
}

