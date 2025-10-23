import java.io.*;
import java.util.*;

public class QuanLyCuaHang implements IFileManager {
    // Mang doi tuong
    private KhachHang[] danhSachKhachHang;
    private NhanVien[] danhSachNhanVien;
    private SanPham[] danhSachSanPham;
    private HoaDon[] danhSachHoaDon;
    
    // So luong hien tai
    private int soKhachHang;
    private int soNhanVien;
    private int soSanPham;
    private int soHoaDon;
    
    // Thuoc tinh static
    private static String tenCuaHang = "Cua hang Mini";
    private static String diaChiCuaHang = "123 Duong ABC, Quan 5, TP.HCM";
    
    // Constructor
    public QuanLyCuaHang() {
        danhSachKhachHang = new KhachHang[50];
        danhSachNhanVien = new NhanVien[50];
        danhSachSanPham = new SanPham[100];
        danhSachHoaDon = new HoaDon[200];
        soKhachHang = 0;
        soNhanVien = 0;
        soSanPham = 0;
        soHoaDon = 0;
    }
    
    // Implement interface IFileManager
    @Override
    public List<String> readFromFile(String fileName) throws IOException {
        List<String> data = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                data.add(line);
            }
        }
        return data;
    }
    
    @Override
    public void writeToFile(String fileName, List<String> data) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName))) {
            for (String line : data) {
                bw.write(line);
                bw.newLine();
            }
        }
    }
    
    // Ham thiet lap thong tin cua hang
    public static void thietLapThongTinCuaHang(String ten, String diaChi) {
        tenCuaHang = ten;
        diaChiCuaHang = diaChi;
    }
    
    // Quan ly khach hang
    public void themKhachHang(KhachHang kh) {
        if (soKhachHang < danhSachKhachHang.length) {
            danhSachKhachHang[soKhachHang] = kh;
            soKhachHang++;
            System.out.println("Da them khach hang thanh cong!");
        } else {
            System.out.println("Danh sach khach hang da day!");
        }
    }
    
    public void xuatDanhSachKhachHang() {
        System.out.println("\n=== DANH SACH KHACH HANG ===");
        for (int i = 0; i < soKhachHang; i++) {
            danhSachKhachHang[i].xuatThongTin();
            System.out.println("------------------------");
        }
    }
    
    // Quan ly nhan vien
    public void themNhanVien(NhanVien nv) {
        if (soNhanVien < danhSachNhanVien.length) {
            danhSachNhanVien[soNhanVien] = nv;
            soNhanVien++;
            System.out.println("Da them nhan vien thanh cong!");
        } else {
            System.out.println("Danh sach nhan vien da day!");
        }
    }
    
    public void xuatDanhSachNhanVien() {
        System.out.println("\n=== DANH SACH NHAN VIEN ===");
        for (int i = 0; i < soNhanVien; i++) {
            danhSachNhanVien[i].xuatThongTin();
            System.out.println("------------------------");
        }
    }
    
    // Quan ly san pham
    public void themSanPham(SanPham sp) {
        if (soSanPham < danhSachSanPham.length) {
            danhSachSanPham[soSanPham] = sp;
            soSanPham++;
            System.out.println("Da them san pham thanh cong!");
        } else {
            System.out.println("Danh sach san pham da day!");
        }
    }
    
    public void xuatDanhSachSanPham() {
        System.out.println("\n=== DANH SACH SAN PHAM ===");
        for (int i = 0; i < soSanPham; i++) {
            danhSachSanPham[i].xuatThongTin();
            System.out.println("------------------------");
        }
    }
    
    // Tim kiem khach hang theo ma
    public KhachHang timKhachHang(String maKH) {
        for (int i = 0; i < soKhachHang; i++) {
            if (danhSachKhachHang[i].getMa().equals(maKH)) {
                return danhSachKhachHang[i];
            }
        }
        return null;
    }
    
    // Tim kiem nhan vien theo ma
    public NhanVien timNhanVien(String maNV) {
        for (int i = 0; i < soNhanVien; i++) {
            if (danhSachNhanVien[i].getMa().equals(maNV)) {
                return danhSachNhanVien[i];
            }
        }
        return null;
    }
    
    // Tim kiem san pham theo ma
    public SanPham timSanPham(String maSP) {
        for (int i = 0; i < soSanPham; i++) {
            if (danhSachSanPham[i].getMaSP().equals(maSP)) {
                return danhSachSanPham[i];
            }
        }
        return null;
    }
    
    // Thong ke
    public void thongKe() {
        System.out.println("\n=== THONG KE CUA HANG ===");
        System.out.println("Ten cua hang: " + tenCuaHang);
        System.out.println("Dia chi: " + diaChiCuaHang);
        System.out.println("Tong so khach hang: " + soKhachHang);
        System.out.println("Tong so nhan vien: " + soNhanVien);
        System.out.println("Tong so san pham: " + soSanPham);
        System.out.println("Tong so nguoi trong he thong: " + Nguoi.getSoLuongNguoi());
        System.out.println("Tong so san pham trong he thong: " + SanPham.getSoLuongSanPham());
    }
    
    // Luu du lieu vao file
    public void luuDuLieu() {
        try {
            // Luu danh sach khach hang
            List<String> khData = new ArrayList<>();
            for (int i = 0; i < soKhachHang; i++) {
                KhachHang kh = danhSachKhachHang[i];
                khData.add(kh.getMa() + "," + kh.getTen() + "," + kh.getSoDienThoai() + 
                          "," + kh.getDiaChi() + "," + kh.getLoaiKhachHang());
            }
            writeToFile("khachhang.txt", khData);
            
            // Luu danh sach nhan vien
            List<String> nvData = new ArrayList<>();
            for (int i = 0; i < soNhanVien; i++) {
                NhanVien nv = danhSachNhanVien[i];
                nvData.add(nv.getMa() + "," + nv.getTen() + "," + nv.getSoDienThoai() + 
                          "," + nv.getDiaChi() + "," + nv.getChucVu() + "," + nv.getLuongCoBan() + 
                          "," + nv.getSoNgayCong());
            }
            writeToFile("nhanvien.txt", nvData);
            
            // Luu danh sach san pham
            List<String> spData = new ArrayList<>();
            for (int i = 0; i < soSanPham; i++) {
                SanPham sp = danhSachSanPham[i];
                spData.add(sp.getMaSP() + "," + sp.getTenSP() + "," + sp.getGiaBan() + 
                          "," + sp.getSoLuongTon() + "," + sp.getLoaiSP());
            }
            writeToFile("sanpham.txt", spData);
            
            System.out.println("Da luu du lieu thanh cong!");
        } catch (IOException e) {
            System.out.println("Loi khi luu du lieu: " + e.getMessage());
        }
    }
    
    // Doc du lieu tu file
    public void docDuLieu() {
        try {
            // Doc danh sach khach hang
            List<String> khData = readFromFile("khachhang.txt");
            for (String line : khData) {
                String[] parts = line.split(",");
                if (parts.length >= 5) {
                    KhachHang kh = new KhachHang(parts[0], parts[1], parts[2], parts[3], parts[4]);
                    themKhachHang(kh);
                }
            }
            
            // Doc danh sach nhan vien
            List<String> nvData = readFromFile("nhanvien.txt");
            for (String line : nvData) {
                String[] parts = line.split(",");
                if (parts.length >= 7) {
                    NhanVien nv = new NhanVien(parts[0], parts[1], parts[2], parts[3], 
                                              parts[4], Double.parseDouble(parts[5]), 
                                              Integer.parseInt(parts[6]));
                    themNhanVien(nv);
                }
            }
            
            // Doc danh sach san pham
            List<String> spData = readFromFile("sanpham.txt");
            for (String line : spData) {
                String[] parts = line.split(",");
                if (parts.length >= 5) {
                    SanPham sp = new SanPham(parts[0], parts[1], Double.parseDouble(parts[2]), 
                                           Integer.parseInt(parts[3]), parts[4]);
                    themSanPham(sp);
                }
            }
            
            System.out.println("Da doc du lieu thanh cong!");
        } catch (IOException e) {
            System.out.println("Loi khi doc du lieu: " + e.getMessage());
        }
    }
    
    // Getter va Setter
    public static String getTenCuaHang() { return tenCuaHang; }
    public static String getDiaChiCuaHang() { return diaChiCuaHang; }
    
    public int getSoKhachHang() { return soKhachHang; }
    public int getSoNhanVien() { return soNhanVien; }
    public int getSoSanPham() { return soSanPham; }
    public int getSoHoaDon() { return soHoaDon; }
    
    // ========== CHUC NANG THANH TOAN ==========
    
    // Tao hoa don moi
    public HoaDon taoHoaDon(String maHD, String maKH, String maNV, String ngayTao) {
        HoaDon hoaDon = new HoaDon(maHD, maKH, maNV, ngayTao);
        if (soHoaDon < danhSachHoaDon.length) {
            danhSachHoaDon[soHoaDon] = hoaDon;
            soHoaDon++;
            System.out.println("Da tao hoa don thanh cong!");
        } else {
            System.out.println("Danh sach hoa don da day!");
        }
        return hoaDon;
    }
    
    // Them san pham vao hoa don
    public boolean themSanPhamVaoHoaDon(String maHD, String maSP, int soLuong) {
        // Tim hoa don
        HoaDon hoaDon = timHoaDon(maHD);
        if (hoaDon == null) {
            System.out.println("Khong tim thay hoa don!");
            return false;
        }
        
        // Tim san pham
        SanPham sanPham = timSanPham(maSP);
        if (sanPham == null) {
            System.out.println("Khong tim thay san pham!");
            return false;
        }
        
        // Kiem tra so luong ton kho
        if (sanPham.getSoLuongTon() < soLuong) {
            System.out.println("Khong du hang trong kho! Chi con " + sanPham.getSoLuongTon() + " san pham");
            return false;
        }
        
        // Them vao hoa don
        hoaDon.themSanPham(maSP, soLuong, sanPham.getGiaBan());
        System.out.println("Da them san pham vao hoa don!");
        return true;
    }
    
    // Thanh toan hoa don
    public boolean thanhToanHoaDon(String maHD) {
        HoaDon hoaDon = timHoaDon(maHD);
        if (hoaDon == null) {
            System.out.println("Khong tim thay hoa don!");
            return false;
        }
        
        // Cap nhat so luong ton kho
        for (ChiTietHoaDon chiTiet : hoaDon.getChiTietHoaDon()) {
            SanPham sanPham = timSanPham(chiTiet.getMaSP());
            if (sanPham != null) {
                // Giam so luong ton kho
                sanPham.capNhatSoLuong(-chiTiet.getSoLuong());
                System.out.println("Da cap nhat ton kho cho san pham " + chiTiet.getMaSP() + 
                                 ": -" + chiTiet.getSoLuong());
            }
        }
        
        System.out.println("=== THANH TOAN THANH CONG ===");
        hoaDon.xuatHoaDon();
        return true;
    }
    
    // Tim hoa don theo ma
    public HoaDon timHoaDon(String maHD) {
        for (int i = 0; i < soHoaDon; i++) {
            if (danhSachHoaDon[i].getMaHD().equals(maHD)) {
                return danhSachHoaDon[i];
            }
        }
        return null;
    }
    
    // Xuat danh sach hoa don
    public void xuatDanhSachHoaDon() {
        System.out.println("\n=== DANH SACH HOA DON ===");
        for (int i = 0; i < soHoaDon; i++) {
            danhSachHoaDon[i].xuatHoaDon();
            System.out.println("------------------------");
        }
    }
    
    // Cap nhat thong ke
    public void capNhatThongKe() {
        System.out.println("\n=== THONG KE CAP NHAT ===");
        System.out.println("Ten cua hang: " + tenCuaHang);
        System.out.println("Dia chi: " + diaChiCuaHang);
        System.out.println("Tong so khach hang: " + soKhachHang);
        System.out.println("Tong so nhan vien: " + soNhanVien);
        System.out.println("Tong so san pham: " + soSanPham);
        System.out.println("Tong so hoa don: " + soHoaDon);
        System.out.println("Tong so nguoi trong he thong: " + Nguoi.getSoLuongNguoi());
        System.out.println("Tong so san pham trong he thong: " + SanPham.getSoLuongSanPham());
    }
}