package com.example.thithu2.DTO;

public class VatPham {
      int id;
      String naem;
      double money;

      public static final String TB_NAME="tbl_vatpham";
      public static final String COL_NAME_ID="id";
      public static final String COL_NAME_TENSP="tensp";
      public static final String COL_NAME_Money="money";

    public VatPham() {
    }

    public VatPham(int id, String naem, double money) {
        this.id = id;
        this.naem = naem;
        this.money = money;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNaem() {
        return naem;
    }

    public void setNaem(String naem) {
        this.naem = naem;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }
}
