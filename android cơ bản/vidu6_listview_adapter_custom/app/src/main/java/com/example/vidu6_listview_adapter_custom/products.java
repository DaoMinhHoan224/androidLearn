package com.example.vidu6_listview_adapter_custom;

public class products {
    int id;
    String name;//ten san pham
    double price;//gia tien
    int img_res;//id hinh anh trong thu muc drawable
    //tạo hàm khởi tạo


    public products(int id, String name, double price, int img_res) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.img_res = img_res;
    }

    public products() {

    }


}
