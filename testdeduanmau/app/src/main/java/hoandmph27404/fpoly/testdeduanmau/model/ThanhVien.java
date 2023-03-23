package hoandmph27404.fpoly.testdeduanmau.model;

public class ThanhVien {

    private int maTV;
    private String hoTen;
    private String namSinh;
    private String stk;

    public ThanhVien() {

    }

    public ThanhVien(int maTV, String hoTen, String namSinh, String stk) {
        this.maTV = maTV;
        this.hoTen = hoTen;
        this.namSinh = namSinh;
        this.stk = stk;
    }

    public int getMaTV() {
        return maTV;
    }

    public void setMaTV(int maTV) {
        this.maTV = maTV;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getNamSinh() {
        return namSinh;
    }

    public void setNamSinh(String namSinh) {
        this.namSinh = namSinh;
    }

    public String getStk() {
        return stk;
    }

    public void setStk(String stk) {
        this.stk = stk;
    }
}
