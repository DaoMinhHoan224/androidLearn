package com.example.assigment_hoandmph27404.DTO;

public class User {
    private String idUser;
    private String hoTen;
    private String matKhau;


    public User() {
    }

    public User(String idUser, String hoTen, String matKhau) {
        this.idUser = idUser;
        this.hoTen = hoTen;
        this.matKhau = matKhau;
    }

    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }
}
