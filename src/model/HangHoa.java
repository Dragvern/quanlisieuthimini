package model;

public class HangHoa {
    protected maHang;
    protected tenHang;
    protected donGia;
    protected soLuong;
    
    public HangHoa() {}

    public HangHoa(String maHang, String tenHang, double donGia, int soLuong) {
        this.maHang = maHang;
        this.tenHang = tenHang;
        this.donGia = donGia;
        this.soLuong = soLuong;
    }
    public String getMaHang() {
        return maHang;
    }
    public String getTenHang() {
        return tenHang;
    }
    public double getDonGia() {
        return donGia;
    }
    public int getSoLuong() {
        return soLuong;
    }
    public void setMaHang(String maHang) {
        this.maHang = maHang;
    }
    public void setTenHang(String tenHang) {
        this.tenHang = tenHang;
    }
    public void setDonGia(double donGia) {
        this.donGia = donGia;
    }
    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }
    @Override 
    public String toString() {
        return "HangHoa [maHang=" + maHang + ", tenHang=" + tenHang + ", donGia=" + donGia + ", soLuong=" + soLuong + "]";
    }
}
