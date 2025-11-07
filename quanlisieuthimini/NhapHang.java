public class NhapHang {
    private String maPN;
    private String maNV;
    private String chiTiet; // danh sach san pham nhap, vi du: "Banh quy x10; Nuoc ngot x5;"
    private int tongSoLuong;
    private String ngay;

    public NhapHang() {}

    public NhapHang(String maPN, String maNV, String chiTiet, int tongSoLuong, String ngay) {
        this.maPN = maPN;
        this.maNV = maNV;
        this.chiTiet = chiTiet;
        this.tongSoLuong = tongSoLuong;
        this.ngay = ngay;
    }

    public String getMaPN() { return maPN; }
    public void setMaPN(String maPN) { this.maPN = maPN; }

    public String getMaNV() { return maNV; }
    public void setMaNV(String maNV) { this.maNV = maNV; }

    public String getChiTiet() { return chiTiet; }
    public void setChiTiet(String chiTiet) { this.chiTiet = chiTiet; }

    public int getTongSoLuong() { return tongSoLuong; }
    public void setTongSoLuong(int tongSoLuong) { this.tongSoLuong = tongSoLuong; }

    public String getNgay() { return ngay; }
    public void setNgay(String ngay) { this.ngay = ngay; }

    @Override
    public String toString() {
        return String.format("Phieu nhap: %s | Ma NV: %s | Ngay: %s | Tong so luong: %d\nChi tiet: %s",
                maPN, maNV, ngay, tongSoLuong, chiTiet);
    }

    public String toFileString() {
        return String.format("%s;%s;%s;%d;%s", maPN, maNV, chiTiet, tongSoLuong, ngay);
    }
}
