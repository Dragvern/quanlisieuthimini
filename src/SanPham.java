import java.util.Scanner;

/**
 * Lop SanPham voi da hinh - co the la ThucPham hoac DoChoi
 */
public class SanPham {
    // Thuoc tinh static de dem so luong san pham
    private static int soLuongSanPham = 0;
    
    protected String maSP;
    protected String tenSP;
    protected double giaBan;
    protected int soLuongTon;
    protected String loaiSP;
    
    // Constructor mac dinh
    public SanPham() {
        soLuongSanPham++;
    }
    
    // Constructor co tham so
    public SanPham(String maSP, String tenSP, double giaBan, int soLuongTon, String loaiSP) {
        this.maSP = maSP;
        this.tenSP = tenSP;
        this.giaBan = giaBan;
        this.soLuongTon = soLuongTon;
        this.loaiSP = loaiSP;
        soLuongSanPham++;
    }
    
    // Ham nhap thong tin san pham
    public void nhapThongTin() {
        Scanner sc = new Scanner(System.in);
        System.out.println("=== NHAP THONG TIN SAN PHAM ===");
        System.out.print("Nhap ma san pham: ");
        this.maSP = sc.nextLine();
        System.out.print("Nhap ten san pham: ");
        this.tenSP = sc.nextLine();
        System.out.print("Nhap gia ban: ");
        this.giaBan = sc.nextDouble();
        System.out.print("Nhap so luong ton: ");
        this.soLuongTon = sc.nextInt();
        sc.nextLine(); // Doc ky tu xuong dong
        System.out.print("Nhap loai san pham: ");
        this.loaiSP = sc.nextLine();
    }
    
    // Ham xuat thong tin san pham
    public void xuatThongTin() {
        System.out.println("=== THONG TIN SAN PHAM ===");
        System.out.println("Ma SP: " + maSP);
        System.out.println("Ten SP: " + tenSP);
        System.out.println("Gia ban: " + giaBan + " VND");
        System.out.println("So luong ton: " + soLuongTon);
        System.out.println("Loai SP: " + loaiSP);
        System.out.println("Gia sau giam: " + tinhGiaSauGiam() + " VND");
    }
    
    // Ham tinh gia sau giam (da hinh - co the override o lop con)
    public double tinhGiaSauGiam() {
        return giaBan; // Mac dinh khong giam gia
    }
    
    // Ham kiem tra het hang
    public boolean hetHang() {
        return soLuongTon <= 0;
    }
    
    // Ham cap nhat so luong
    public void capNhatSoLuong(int soLuongMoi) {
        this.soLuongTon += soLuongMoi;
    }
    
    // Getter va Setter
    public String getMaSP() { return maSP; }
    public void setMaSP(String maSP) { this.maSP = maSP; }
    
    public String getTenSP() { return tenSP; }
    public void setTenSP(String tenSP) { this.tenSP = tenSP; }
    
    public double getGiaBan() { return giaBan; }
    public void setGiaBan(double giaBan) { this.giaBan = giaBan; }
    
    public int getSoLuongTon() { return soLuongTon; }
    public void setSoLuongTon(int soLuongTon) { this.soLuongTon = soLuongTon; }
    
    public String getLoaiSP() { return loaiSP; }
    public void setLoaiSP(String loaiSP) { this.loaiSP = loaiSP; }
    
    // Ham static de lay so luong san pham
    public static int getSoLuongSanPham() { return soLuongSanPham; }
}

/**
 * Lop ThucPham ke thua tu SanPham
 */
class ThucPham extends SanPham {
    private String ngaySanXuat;
    private String hanSuDung;
    
    public ThucPham() {
        super();
        this.loaiSP = "Thuc pham";
    }
    
    public ThucPham(String maSP, String tenSP, double giaBan, int soLuongTon, 
                    String ngaySanXuat, String hanSuDung) {
        super(maSP, tenSP, giaBan, soLuongTon, "Thuc pham");
        this.ngaySanXuat = ngaySanXuat;
        this.hanSuDung = hanSuDung;
    }
    
    @Override
    public void nhapThongTin() {
        super.nhapThongTin();
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap ngay san xuat: ");
        this.ngaySanXuat = sc.nextLine();
        System.out.print("Nhap han su dung: ");
        this.hanSuDung = sc.nextLine();
    }
    
    @Override
    public void xuatThongTin() {
        super.xuatThongTin();
        System.out.println("Ngay SX: " + ngaySanXuat);
        System.out.println("Han SD: " + hanSuDung);
    }
    
    @Override
    public double tinhGiaSauGiam() {
        // Thuc pham gan het han duoc giam gia
        return giaBan * 0.8; // Giam 20%
    }
}

/**
 * Lop DoChoi ke thua tu SanPham
 */
class DoChoi extends SanPham {
    private String doTuoi;
    private String chatLieu;
    
    public DoChoi() {
        super();
        this.loaiSP = "Do choi";
    }
    
    public DoChoi(String maSP, String tenSP, double giaBan, int soLuongTon, 
                  String doTuoi, String chatLieu) {
        super(maSP, tenSP, giaBan, soLuongTon, "Do choi");
        this.doTuoi = doTuoi;
        this.chatLieu = chatLieu;
    }
    
    @Override
    public void nhapThongTin() {
        super.nhapThongTin();
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap do tuoi: ");
        this.doTuoi = sc.nextLine();
        System.out.print("Nhap chat lieu: ");
        this.chatLieu = sc.nextLine();
    }
    
    @Override
    public void xuatThongTin() {
        super.xuatThongTin();
        System.out.println("Do tuoi: " + doTuoi);
        System.out.println("Chat lieu: " + chatLieu);
    }
    
    @Override
    public double tinhGiaSauGiam() {
        // Do choi co the giam gia theo mua
        return giaBan * 0.9; // Giam 10%
    }
}