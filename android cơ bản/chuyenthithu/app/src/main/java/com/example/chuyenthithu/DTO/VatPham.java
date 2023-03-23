package com.example.chuyenthithu.DTO;

public class VatPham {
    int id;
    String name;
    double money;

    public VatPham() {
    }

    public VatPham(int id, String name, double money) {
        this.id = id;
        this.name = name;
        this.money = money;
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

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public static final String TB_NAME="tb_vatpham ";
    public static final String COL_NAME_ID="id";
    public static final String COL_NAME_TENSP="tensp";
    public static final String COL_NAME_MONEY="money";
}
