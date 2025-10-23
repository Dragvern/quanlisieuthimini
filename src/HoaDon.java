import java.util.ArrayList;
import java.util.List;

/**
 * Lop HoaDon - quan ly thong tin hoa don
 */
public class HoaDon {
    private String maHD;
    private String maKH;
    private String maNV;
    private String ngayTao;
    private double tongTien;
    private List<ChiTietHoaDon> chiTietHoaDon;
    
    // Constructor
    public HoaDon() {
        this.chiTietHoaDon = new ArrayList<>();
    }
    
    public HoaDon(String maHD, String maKH, String maNV, String ngayTao) {
        this.maHD = maHD;
        this.maKH = maKH;
        this.maNV = maNV;
        this.ngayTao = ngayTao;
        this.tongTien = 0;
        this.chiTietHoaDon = new ArrayList<>();
    }
    
    // Them san pham vao hoa don
    public void themSanPham(String maSP, int soLuong, double donGia) {
        ChiTietHoaDon chiTiet = new ChiTietHoaDon(maSP, soLuong, donGia);
        chiTietHoaDon.add(chiTiet);
        tinhTongTien();
    }
    
    // Tinh tong tien
    public void tinhTongTien() {
        tongTien = 0;
        for (ChiTietHoaDon chiTiet : chiTietHoaDon) {
            tongTien += chiTiet.getThanhTien();
        }
    }
    
    // Xuat thong tin hoa don
    public void xuatHoaDon() {
        System.out.println("=== HOA DON ===");
        System.out.println("Ma HD: " + maHD);
        System.out.println("Ma KH: " + maKH);
        System.out.println("Ma NV: " + maNV);
        System.out.println("Ngay tao: " + ngayTao);
        System.out.println("Chi tiet san pham:");
        
        for (ChiTietHoaDon chiTiet : chiTietHoaDon) {
            System.out.println("- Ma SP: " + chiTiet.getMaSP() + 
                             ", So luong: " + chiTiet.getSoLuong() + 
                             ", Don gia: " + chiTiet.getDonGia() + 
                             ", Thanh tien: " + chiTiet.getThanhTien());
        }
        
        System.out.println("Tong tien: " + tongTien + " VND");
    }
    
    // Getter va Setter
    public String getMaHD() { return maHD; }
    public void setMaHD(String maHD) { this.maHD = maHD; }
    
    public String getMaKH() { return maKH; }
    public void setMaKH(String maKH) { this.maKH = maKH; }
    
    public String getMaNV() { return maNV; }
    public void setMaNV(String maNV) { this.maNV = maNV; }
    
    public String getNgayTao() { return ngayTao; }
    public void setNgayTao(String ngayTao) { this.ngayTao = ngayTao; }
    
    public double getTongTien() { return tongTien; }
    public void setTongTien(double tongTien) { this.tongTien = tongTien; }
    
    public List<ChiTietHoaDon> getChiTietHoaDon() { return chiTietHoaDon; }
}

/**
 * Lop ChiTietHoaDon - chi tiet tung san pham trong hoa don
 */
class ChiTietHoaDon {
    private String maSP;
    private int soLuong;
    private double donGia;
    private double thanhTien;
    
    public ChiTietHoaDon(String maSP, int soLuong, double donGia) {
        this.maSP = maSP;
        this.soLuong = soLuong;
        this.donGia = donGia;
        this.thanhTien = soLuong * donGia;
    }
    
    // Getter va Setter
    public String getMaSP() { return maSP; }
    public void setMaSP(String maSP) { this.maSP = maSP; }
    
    public int getSoLuong() { return soLuong; }
    public void setSoLuong(int soLuong) { 
        this.soLuong = soLuong;
        this.thanhTien = soLuong * donGia;
    }
    
    public double getDonGia() { return donGia; }
    public void setDonGia(double donGia) { 
        this.donGia = donGia;
        this.thanhTien = soLuong * donGia;
    }
    
    public double getThanhTien() { return thanhTien; }
}
