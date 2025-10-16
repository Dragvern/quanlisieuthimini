package model;

public class NhapHang extends HangHoa {
    private String ngayNhap;

    public NhapHang() {
        super();
    }
    public NhapHang(String maHang, String tenHang, double donGia, int soLuong, String ngayNhap, String nhaCungCap) {
        super(maHang, tenHang, donGia, soLuong);
        this.ngayNhap = ngayNhap;
        this.nhaCungCap = nhaCungCap;
    }
    public String getNgayNhap() {
        return ngayNhap;
    }
    public void setNgayNhap(String ngayNhap) {
        this.ngayNhap = ngayNhap;
    }
    @Override
    public String toString() {
        return "NhapHang [ngayNhap=" + ngayNhap +  ", maHang=" + maHang + ", tenHang=" + tenHang + ", donGia=" + donGia + ", soLuong=" + soLuong + "]";
    }
    
}
