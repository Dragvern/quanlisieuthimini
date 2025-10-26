import java.util.Scanner;

public class SanPham {
    protected String maSP;
    protected String tenSP;
    protected double giaBan;
    protected double giaNhap;
    protected int soLuong;
    protected String loaiSP;

    public SanPham() {}

    public SanPham(String maSP, String tenSP, double giaNhap, double giaBan, int soLuong, String loaiSP) {
        this.maSP = maSP;
        this.tenSP = tenSP;
        this.giaNhap = giaNhap;
        this.giaBan = giaBan;
        this.soLuong = soLuong;
        this.loaiSP = loaiSP;
    }

    @SuppressWarnings("resource")
    public void nhapThongTin() {
        Scanner sc = new Scanner(System.in);
            System.out.print("Nhap ma san pham: ");
        maSP = sc.nextLine();
            System.out.print("Nhap ten san pham: ");
        tenSP = sc.nextLine();
            System.out.print("Nhap gia nhap (gia mua): ");
        giaNhap = Double.parseDouble(sc.nextLine());
            System.out.print("Nhap gia ban: ");
        giaBan = Double.parseDouble(sc.nextLine());
            System.out.print("Nhap so luong: ");
        soLuong = Integer.parseInt(sc.nextLine());
    }

    public void xuatThongTin() {
        System.out.printf("%-10s %-20s %-15s %-15s %-10d %-10s\n", maSP, tenSP, fmtVND(giaNhap), fmtVND(giaBan), soLuong, loaiSP);
    }

    @Override
    public String toString() {
        return String.format("%-10s %-20s %-15s %-15s %-10d %-10s", maSP, tenSP, fmtVND(giaNhap), fmtVND(giaBan), soLuong, loaiSP);
    }

    // Getter / Setter
    public String getMaSP() { return maSP; }
    public String getTenSP() { return tenSP; }
    public double getGiaBan() { return giaBan; }
    public double getGiaNhap() { return giaNhap; }
    public int getSoLuong() { return soLuong; }
    public String getLoaiSP() { return loaiSP; }

    public void setSoLuong(int soLuong) { this.soLuong = soLuong; }
    public void setGiaBan(double giaBan) { this.giaBan = giaBan; }
    public void setGiaNhap(double giaNhap) { this.giaNhap = giaNhap; }
    public void setTenSP(String tenSP) { this.tenSP = tenSP; }
    public void setMaSP(String maSP) { this.maSP = maSP; }
    public void setLoaiSP(String loaiSP) { this.loaiSP = loaiSP; }

    public String toFileString() {
        return String.format("%s;%s;%f;%f;%d;%s", maSP, tenSP, giaNhap, giaBan, soLuong, loaiSP);
    }

    // Format number as VND (grouping, no decimals)
    private static String fmtVND(double v) {
        return String.format("%,.0f VND", v);
    }
}

// ===== LOP CON: ThucPham =====
class ThucPham extends SanPham {
    public ThucPham() {
        super();
        this.loaiSP = "Thuc pham";
    }

    public ThucPham(String maSP, String tenSP, double giaNhap, double giaBan, int soLuong) {
        super(maSP, tenSP, giaNhap, giaBan, soLuong, "Thuc pham");
    }

    @Override
    public void nhapThongTin() {
        super.nhapThongTin();
        this.loaiSP = "Thuc pham";
    }
}

// ===== LOP CON: DoChoi =====
class DoChoi extends SanPham {
    public DoChoi() {
        super();
        this.loaiSP = "Do choi";
    }

    public DoChoi(String maSP, String tenSP, double giaNhap, double giaBan, int soLuong) {
        super(maSP, tenSP, giaNhap, giaBan, soLuong, "Do choi");
    }

    @Override
    public void nhapThongTin() {
        super.nhapThongTin();
        this.loaiSP = "Do choi";
    }
}
