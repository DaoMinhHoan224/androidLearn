package com.example.testtt.DTO;

public class vatPham {
    int id;
    String tensp;
    double money;

    public vatPham() {
    }

    public vatPham(int id, String tensp, double money) {
        this.id = id;
        this.tensp = tensp;
        this.money = money;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTensp() {
        return tensp;
    }

    public void setTensp(String tensp) {
        this.tensp = tensp;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public static final String TB_NAME="table_vatpham";
    public static final String COL_NAME_ID="id";
    public static final String COL_NAME_NAME="tensp";
    public static final String COL_NAME_MONEY="money";
}
