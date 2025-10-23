import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        QuanLyCuaHang ql = new QuanLyCuaHang();
        
        // Thiet lap thong tin cua hang
        QuanLyCuaHang.thietLapThongTinCuaHang("Cua hang Mini ABC", "123 Duong ABC, Quan 1, TP.HCM");
        
        int choice;
        do {
            System.out.println("\n=== HE THONG QUAN LY CUA HANG MINI ===");
            System.out.println("1. Quan ly khach hang");
            System.out.println("2. Quan ly nhan vien");
            System.out.println("3. Quan ly san pham");
            System.out.println("4. Thong ke");
            System.out.println("5. Luu du lieu");
            System.out.println("6. Doc du lieu");
            System.out.println("7. Demo da hinh");
            System.out.println("8. Thanh toan");
            System.out.println("0. Thoat");
            System.out.print("Chon chuc nang: ");
            choice = sc.nextInt();
            
            switch (choice) {
                case 1:
                    quanLyKhachHang(ql, sc);
                    break;
                case 2:
                    quanLyNhanVien(ql, sc);
                    break;
                case 3:
                    quanLySanPham(ql, sc);
                    break;
                case 4:
                    ql.thongKe();
                    break;
                case 5:
                    ql.luuDuLieu();
                    break;
                case 6:
                    ql.docDuLieu();
                    break;
                case 7:
                    demoDaHinh(ql, sc);
                    break;
                case 8:
                    quanLyThanhToan(ql, sc);
                    break;
                case 0:
                    System.out.println("Cam on ban da su dung chuong trinh!");
                    break;
                default:
                    System.out.println("Lua chon khong hop le!");
            }
        } while (choice != 0);
        
        sc.close();
    }
    
    // Quan ly khach hang
    public static void quanLyKhachHang(QuanLyCuaHang ql, Scanner sc) {
        int choice;
        do {
            System.out.println("\n=== QUAN LY KHACH HANG ===");
            System.out.println("1. Them khach hang");
            System.out.println("2. Xem danh sach khach hang");
            System.out.println("3. Tim khach hang");
            System.out.println("0. Quay lai");
            System.out.print("Chon: ");
            choice = sc.nextInt();
            
            switch (choice) {
                case 1:
                    KhachHang kh = new KhachHang();
                    kh.nhapThongTin();
                    ql.themKhachHang(kh);
                    break;
                case 2:
                    ql.xuatDanhSachKhachHang();
                    break;
                case 3:
                    System.out.print("Nhap ma khach hang can tim: ");
                    sc.nextLine();
                    String maKH = sc.nextLine();
                    KhachHang khTim = ql.timKhachHang(maKH);
                    if (khTim != null) {
                        khTim.xuatThongTin();
                    } else {
                        System.out.println("Khong tim thay khach hang!");
                    }
                    break;
            }
        } while (choice != 0);
    }
    
    // Quan ly nhan vien
    public static void quanLyNhanVien(QuanLyCuaHang ql, Scanner sc) {
        int choice;
        do {
            System.out.println("\n=== QUAN LY NHAN VIEN ===");
            System.out.println("1. Them nhan vien");
            System.out.println("2. Xem danh sach nhan vien");
            System.out.println("3. Tim nhan vien");
            System.out.println("0. Quay lai");
            System.out.print("Chon: ");
            choice = sc.nextInt();
            
            switch (choice) {
                case 1:
                    NhanVien nv = new NhanVien();
                    nv.nhapThongTin();
                    ql.themNhanVien(nv);
                    break;
                case 2:
                    ql.xuatDanhSachNhanVien();
                    break;
                case 3:
                    System.out.print("Nhap ma nhan vien can tim: ");
                    sc.nextLine();
                    String maNV = sc.nextLine();
                    NhanVien nvTim = ql.timNhanVien(maNV);
                    if (nvTim != null) {
                        nvTim.xuatThongTin();
                    } else {
                        System.out.println("Khong tim thay nhan vien!");
                    }
                    break;
            }
        } while (choice != 0);
    }
    
    // Quan ly san pham
    public static void quanLySanPham(QuanLyCuaHang ql, Scanner sc) {
        int choice;
        do {
            System.out.println("\n=== QUAN LY SAN PHAM ===");
            System.out.println("1. Them san pham");
            System.out.println("2. Xem danh sach san pham");
            System.out.println("3. Tim san pham");
            System.out.println("0. Quay lai");
            System.out.print("Chon: ");
            choice = sc.nextInt();
            
            switch (choice) {
                case 1:
                    System.out.println("Chon loai san pham:");
                    System.out.println("1. Thuc pham");
                    System.out.println("2. Do choi");
                    System.out.println("3. San pham thuong");
                    System.out.print("Chon: ");
                    int loai = sc.nextInt();
                    
                    SanPham sp;
                    switch (loai) {
                        case 1:
                            sp = new ThucPham();
                            break;
                        case 2:
                            sp = new DoChoi();
                            break;
                        default:
                            sp = new SanPham();
                    }
                    sp.nhapThongTin();
                    ql.themSanPham(sp);
                    break;
                case 2:
                    ql.xuatDanhSachSanPham();
                    break;
                case 3:
                    System.out.print("Nhap ma san pham can tim: ");
                    sc.nextLine();
                    String maSP = sc.nextLine();
                    SanPham spTim = ql.timSanPham(maSP);
                    if (spTim != null) {
                        spTim.xuatThongTin();
                    } else {
                        System.out.println("Khong tim thay san pham!");
                    }
                    break;
            }
        } while (choice != 0);
    }
    
    // Demo da hinh
    public static void demoDaHinh(QuanLyCuaHang ql, Scanner sc) {
        System.out.println("\n=== DEMO DA HINH ===");
        
        // Tao mang Nguoi de demo da hinh
        Nguoi[] danhSachNguoi = new Nguoi[4];
        
        // Tao khach hang va nhan vien
        danhSachNguoi[0] = new KhachHang("KH001", "Nguyen Van A", "0123456789", "123 Duong A", "VIP");
        danhSachNguoi[1] = new KhachHang("KH002", "Tran Thi B", "0987654321", "456 Duong B", "Thuong");
        danhSachNguoi[2] = new NhanVien("NV001", "Le Van C", "0111222333", "789 Duong C", "Quan ly", 8000000.0, 22);
        danhSachNguoi[3] = new NhanVien("NV002", "Pham Thi D", "0444555666", "321 Duong D", "Nhan vien", 5000000.0, 20);
        
        System.out.println("=== DEMO DA HINH - TINH TIEN ===");
        for (int i = 0; i < danhSachNguoi.length; i++) {
            System.out.println("Nguoi thu " + (i + 1) + ":");
            danhSachNguoi[i].xuatThongTin();
            System.out.println("So tien: " + danhSachNguoi[i].tinhTien() + " VND");
            System.out.println("------------------------");
        }
        
        // Demo da hinh voi san pham
        System.out.println("\n=== DEMO DA HINH - SAN PHAM ===");
        SanPham[] danhSachSP = new SanPham[3];
        danhSachSP[0] = new SanPham("SP001", "San pham thuong", 100000, 50, "Thuong");
        danhSachSP[1] = new ThucPham("SP002", "Banh mi", 15000, 100, "01/01/2024", "07/01/2024");
        danhSachSP[2] = new DoChoi("SP003", "Xe do choi", 200000, 20, "3-6 tuoi", "Nhua");
        
        for (int i = 0; i < danhSachSP.length; i++) {
            System.out.println("San pham thu " + (i + 1) + ":");
            danhSachSP[i].xuatThongTin();
            System.out.println("------------------------");
        }
        
        System.out.println("\n=== THONG TIN STATIC ===");
        System.out.println("Tong so nguoi trong he thong: " + Nguoi.getSoLuongNguoi());
        System.out.println("Tong so san pham trong he thong: " + SanPham.getSoLuongSanPham());
        System.out.println("Ten cua hang: " + QuanLyCuaHang.getTenCuaHang());
        System.out.println("Dia chi cua hang: " + QuanLyCuaHang.getDiaChiCuaHang());
    }
    
    // Quan ly thanh toan
    public static void quanLyThanhToan(QuanLyCuaHang ql, Scanner sc) {
        int choice;
        do {
            System.out.println("\n=== QUAN LY THANH TOAN ===");
            System.out.println("1. Tao hoa don moi");
            System.out.println("2. Them san pham vao hoa don");
            System.out.println("3. Thanh toan hoa don");
            System.out.println("4. Xem danh sach hoa don");
            System.out.println("5. Xem ton kho hien tai");
            System.out.println("6. Tim kiem ton kho theo ma SP");
            System.out.println("0. Quay lai");
            System.out.print("Chon: ");
            choice = sc.nextInt();
            
            switch (choice) {
                case 1:
                    System.out.print("Nhap ma hoa don: ");
                    sc.nextLine();
                    String maHD = sc.nextLine();
                    System.out.print("Nhap ma khach hang: ");
                    String maKH = sc.nextLine();
                    System.out.print("Nhap ma nhan vien: ");
                    String maNV = sc.nextLine();
                    System.out.print("Nhap ngay tao (dd/mm/yyyy): ");
                    String ngayTao = sc.nextLine();
                    ql.taoHoaDon(maHD, maKH, maNV, ngayTao);
                    break;
                    
                case 2:
                    System.out.print("Nhap ma hoa don: ");
                    sc.nextLine();
                    String maHD2 = sc.nextLine();
                    System.out.print("Nhap ma san pham: ");
                    String maSP = sc.nextLine();
                    System.out.print("Nhap so luong: ");
                    int soLuong = sc.nextInt();
                    ql.themSanPhamVaoHoaDon(maHD2, maSP, soLuong);
                    break;
                    
                case 3:
                    System.out.print("Nhap ma hoa don can thanh toan: ");
                    sc.nextLine();
                    String maHD3 = sc.nextLine();
                    ql.thanhToanHoaDon(maHD3);
                    break;
                    
                case 4:
                    ql.xuatDanhSachHoaDon();
                    break;
                    
                case 5:
                    System.out.println("\n=== TON KHO HIEN TAI ===");
                    ql.xuatDanhSachSanPham();
                    break;
                    
                case 6:
                    System.out.print("Nhap ma san pham can tim: ");
                    sc.nextLine();
                    String maSPTim = sc.nextLine();
                    SanPham spTim = ql.timSanPham(maSPTim);
                    if (spTim != null) {
                        System.out.println("\n=== THONG TIN TON KHO ===");
                        spTim.xuatThongTin();
                        if (spTim.hetHang()) {
                            System.out.println("⚠️  CANH BAO: San pham da het hang!");
                        } else if (spTim.getSoLuongTon() < 10) {
                            System.out.println("⚠️  CANH BAO: San pham sap het hang! Chi con " + spTim.getSoLuongTon() + " san pham");
                        } else {
                            System.out.println("✅ San pham con du hang trong kho");
                        }
                    } else {
                        System.out.println("Khong tim thay san pham voi ma: " + maSPTim);
                    }
                    break;
            }
        } while (choice != 0);
    }
}