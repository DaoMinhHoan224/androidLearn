package hoandmph27404.fpoly.testdeduanmau.model;


import android.text.format.Time;

import java.util.Date;

public class PhieuMuon {
    private int maPM;
    private String maTT;
    private int maTV;
    private int maSach;
    private String tieude;
    private int tienThue;
    private int traSach;
    private Date ngay;
    private Date giomuahang;

    public PhieuMuon() {

    }

    public PhieuMuon(int maPM, String maTT, int maTV, int maSach,String tieude, int tienThue, int traSach, Date ngay,Date giomuahang) {
        this.maPM = maPM;
        this.maTT = maTT;
        this.maTV = maTV;
        this.maSach = maSach;
        this.tieude=tieude;
        this.tienThue = tienThue;
        this.traSach = traSach;
        this.ngay = ngay;
        this.giomuahang=giomuahang;
    }

    public int getMaPM() {
        return maPM;
    }

    public void setMaPM(int maPM) {
        this.maPM = maPM;
    }

    public String getMaTT() {
        return maTT;
    }

    public void setMaTT(String maTT) {
        this.maTT = maTT;
    }

    public int getMaTV() {
        return maTV;
    }

    public void setMaTV(int maTV) {
        this.maTV = maTV;
    }

    public int getMaSach() {
        return maSach;
    }

    public void setMaSach(int maSach) {
        this.maSach = maSach;
    }

    public String getTieude() {
        return tieude;
    }

    public void setTieude(String tieude) {
        this.tieude = tieude;
    }

    public int getTienThue() {
        return tienThue;
    }

    public void setTienThue(int tienThue) {
        this.tienThue = tienThue;
    }

    public int getTraSach() {
        return traSach;
    }

    public void setTraSach(int traSach) {
        this.traSach = traSach;
    }

    public Date getNgay() {
        return ngay;
    }

    public void setNgay(Date ngay) {
        this.ngay = ngay;
    }

    public Date getGiomuahang() {
        return giomuahang;
    }

    public void setGiomuahang(Date giomuahang) {
        this.giomuahang = giomuahang;
    }
}
