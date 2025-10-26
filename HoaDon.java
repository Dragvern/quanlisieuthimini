import java.io.Serializable;

public class HoaDon implements Serializable {
    private String maHD;
    private String maKH;
    private String maNV;
    private String chiTiet;   // Danh sach san pham mua, vi du: "Banh quy x2; Nuoc ngot x1;"
    private double tongTien;

    public HoaDon() {}

    public HoaDon(String maHD, String maKH, String maNV, String chiTiet, double tongTien) {
        this.maHD = maHD;
        this.maKH = maKH;
        this.maNV = maNV;
        this.chiTiet = chiTiet;
        this.tongTien = tongTien;
    }

    public String getMaHD() {
        return maHD;
    }

    public void setMaHD(String maHD) {
        this.maHD = maHD;
    }

    public String getMaKH() {
        return maKH;
    }

    public void setMaKH(String maKH) {
        this.maKH = maKH;
    }

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public String getChiTiet() {
        return chiTiet;
    }

    public void setChiTiet(String chiTiet) {
        this.chiTiet = chiTiet;
    }

    public double getTongTien() {
        return tongTien;
    }

    public void setTongTien(double tongTien) {
        this.tongTien = tongTien;
    }

    @Override
    public String toString() {
        return String.format(
            "Hoa don: %s | Ma KH: %s | Ma NV: %s | Tong tien: %.2f\nChi tiet: %s",
            maHD, maKH, maNV, tongTien, chiTiet
        );
    }
}
