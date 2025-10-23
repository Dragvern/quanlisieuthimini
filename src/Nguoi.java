import java.util.Scanner;

/**
 * Lop abstract Nguoi - lop cha cho KhachHang va NhanVien
 */
public abstract class Nguoi {
    // Thuoc tinh static de dem so luong nguoi
    private static int soLuongNguoi = 0;
    
    // Thuoc tinh instance
    protected String ma;
    protected String ten;
    protected String soDienThoai;
    protected String diaChi;
    
    // Constructor mac dinh
    public Nguoi() {
        soLuongNguoi++;
    }
    
    // Constructor co tham so
    public Nguoi(String ma, String ten, String soDienThoai, String diaChi) {
        this.ma = ma;
        this.ten = ten;
        this.soDienThoai = soDienThoai;
        this.diaChi = diaChi;
        soLuongNguoi++;
    }
    
    // Ham abstract - phai duoc override o lop con
    public abstract void nhapThongTin();
    public abstract void xuatThongTin();
    public abstract double tinhTien();
    
    // Getter va Setter
    public String getMa() { return ma; }
    public void setMa(String ma) { this.ma = ma; }
    
    public String getTen() { return ten; }
    public void setTen(String ten) { this.ten = ten; }
    
    public String getSoDienThoai() { return soDienThoai; }
    public void setSoDienThoai(String soDienThoai) { this.soDienThoai = soDienThoai; }
    
    public String getDiaChi() { return diaChi; }
    public void setDiaChi(String diaChi) { this.diaChi = diaChi; }
    
    // Ham static de lay so luong nguoi
    public static int getSoLuongNguoi() { return soLuongNguoi; }
    
    // Ham thiet lap thong tin co ban
    public void thietLapThongTinCoBan(String ma, String ten, String soDienThoai, String diaChi) {
        this.ma = ma;
        this.ten = ten;
        this.soDienThoai = soDienThoai;
        this.diaChi = diaChi;
    }
}