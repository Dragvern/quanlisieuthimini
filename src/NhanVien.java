import java.util.Scanner;

/**
 * Lop NhanVien ke thua tu Nguoi
 */
public class NhanVien extends Nguoi {
    private String chucVu;
    private double luongCoBan;
    private int soNgayCong;
    
    // Constructor mac dinh
    public NhanVien() {
        // Goi constructor lop cha (Nguoi)
        super();
        this.chucVu = "Nhan vien";
        this.luongCoBan = 0;
        this.soNgayCong = 0;
    }
    
    // Constructor co tham so
    public NhanVien(String ma, String ten, String soDienThoai, String diaChi, 
                    String chucVu, double luongCoBan, int soNgayCong) {
        super(ma, ten, soDienThoai, diaChi);
        this.chucVu = chucVu;
        this.luongCoBan = luongCoBan;
        this.soNgayCong = soNgayCong;
    }
    
    // Override ham abstract tu lop cha
    @Override
    public void nhapThongTin() {
        Scanner sc = new Scanner(System.in);
        System.out.println("=== NHAP THONG TIN NHAN VIEN ===");
        System.out.print("Nhap ma nhan vien: ");
        this.ma = sc.nextLine();
        System.out.print("Nhap ten nhan vien: ");
        this.ten = sc.nextLine();
        System.out.print("Nhap so dien thoai: ");
        this.soDienThoai = sc.nextLine();
        System.out.print("Nhap dia chi: ");
        this.diaChi = sc.nextLine();
        System.out.print("Nhap chuc vu: ");
        this.chucVu = sc.nextLine();
        System.out.print("Nhap luong co ban: ");
        this.luongCoBan = sc.nextDouble();
        System.out.print("Nhap so ngay cong: ");
        this.soNgayCong = sc.nextInt();
    }
    
    @Override
    public void xuatThongTin() {
        System.out.println("=== THONG TIN NHAN VIEN ===");
        System.out.println("Ma NV: " + ma);
        System.out.println("Ten NV: " + ten);
        System.out.println("SDT: " + soDienThoai);
        System.out.println("Dia chi: " + diaChi);
        System.out.println("Chuc vu: " + chucVu);
        System.out.println("Luong co ban: " + luongCoBan + " VND");
        System.out.println("So ngay cong: " + soNgayCong);
        System.out.println("Luong thuc linh: " + tinhTien() + " VND");
    }
    
    @Override
    public double tinhTien() {
        // Tinh luong thuc linh
        double luongThucLinh = luongCoBan * (soNgayCong / 22.0); // 22 ngay cong/thang
        
        // Thuong dua tren chuc vu
        if (chucVu.equals("Quan ly")) {
            luongThucLinh *= 1.5;
        } else if (chucVu.equals("Truong ca")) {
            luongThucLinh *= 1.3;
        }
        
        return luongThucLinh;
    }
    
    // Getter va Setter
    public String getChucVu() { return chucVu; }
    public void setChucVu(String chucVu) { this.chucVu = chucVu; }
    
    public double getLuongCoBan() { return luongCoBan; }
    public void setLuongCoBan(double luongCoBan) { this.luongCoBan = luongCoBan; }
    
    
    public int getSoNgayCong() { return soNgayCong; }
    public void setSoNgayCong(int soNgayCong) { this.soNgayCong = soNgayCong; }
    
    // Ham cap nhat ngay cong
    public void capNhatNgayCong(int ngayCongMoi) {
        this.soNgayCong += ngayCongMoi;
    }
}