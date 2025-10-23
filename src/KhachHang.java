import java.util.Scanner;

public class KhachHang extends Nguoi {
    private String loaiKhachHang;
    
    public KhachHang() {
        super();
        this.loaiKhachHang = "Thuong";
    }
    
    public KhachHang(String ma, String ten, String soDienThoai, String diaChi, String loaiKhachHang) {
        super(ma, ten, soDienThoai, diaChi);
        this.loaiKhachHang = loaiKhachHang;
    }
    
    @Override
    public void nhapThongTin() {
        Scanner sc = new Scanner(System.in);
        System.out.println("=== NHAP THONG TIN KHACH HANG ===");
        System.out.print("Nhap ma khach hang: ");
        this.ma = sc.nextLine();
        System.out.print("Nhap ten khach hang: ");
        this.ten = sc.nextLine();
        System.out.print("Nhap so dien thoai: ");
        this.soDienThoai = sc.nextLine();
        System.out.print("Nhap dia chi: ");
        this.diaChi = sc.nextLine();
        System.out.print("Nhap loai khach hang (VIP/Thuong): ");
        this.loaiKhachHang = sc.nextLine();
    }
    
    @Override
    public void xuatThongTin() {
        System.out.println("=== THONG TIN KHACH HANG ===");
        System.out.println("Ma KH: " + ma);
        System.out.println("Ten KH: " + ten);
        System.out.println("SDT: " + soDienThoai);
        System.out.println("Dia chi: " + diaChi);
        System.out.println("Loai KH: " + loaiKhachHang);
        System.out.println("Tong tien: " + tinhTien() + " VND");
    }
    
    @Override
    public double tinhTien() {
        double tongTienMacDinh = 0;
        double giamGia = 0;
        if ("VIP".equals(loaiKhachHang)) {
            giamGia = 0.15;
        }
        return tongTienMacDinh * (1 - giamGia);
    }
    
    public String getLoaiKhachHang() {
        return loaiKhachHang;
    }
    
    public void setLoaiKhachHang(String loaiKhachHang) {
        this.loaiKhachHang = loaiKhachHang;
    }
}
