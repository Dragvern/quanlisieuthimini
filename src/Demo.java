// /**
//  * Demo chuong trinh quan ly cua hang mini
//  */
// public class Demo {
//     public static void main(String[] args) {
//         System.out.println("=== DEMO CHUONG TRINH QUAN LY CUA HANG MINI ===");
//         // 
//         // Tao doi tuong quan ly
//         QuanLyCuaHang ql = new QuanLyCuaHang();
        
//         // Thiet lap thong tin cua hang
//         QuanLyCuaHang.thietLapThongTinCuaHang("Cua hang Mini ABC", "123 Duong ABC, Quan 1, TP.HCM");
        
//         System.out.println("\n1. DEMO DA HINH VOI NGUOI:");
//         System.out.println("================================");
        
//         // Tao mang Nguoi de demo da hinh
//         Nguoi[] danhSachNguoi = new Nguoi[4];
        
//         // Tao khach hang va nhan vien
//         danhSachNguoi[0] = new KhachHang("KH001", "Nguyen Van A", "0123456789", "123 Duong A", "VIP");
//         danhSachNguoi[1] = new KhachHang("KH002", "Tran Thi B", "0987654321", "456 Duong B", "Thuong");
//         danhSachNguoi[2] = new NhanVien("NV001", "Le Van C", "0111222333", "789 Duong C", "Quan ly", 8000000.0, 22);
//         danhSachNguoi[3] = new NhanVien("NV002", "Pham Thi D", "0444555666", "321 Duong D", "Nhan vien", 5000000.0, 20);
        
//         // Demo da hinh - goi ham tinhTien()
//         for (int i = 0; i < danhSachNguoi.length; i++) {
//             System.out.println("Nguoi thu " + (i + 1) + ":");
//             danhSachNguoi[i].xuatThongTin();
//             System.out.println("So tien: " + danhSachNguoi[i].tinhTien() + " VND");
//             System.out.println("------------------------");
//         }
        
//         System.out.println("\n2. DEMO DA HINH VOI SAN PHAM:");
//         System.out.println("================================");
        
//         // Demo da hinh voi san pham
//         SanPham[] danhSachSP = new SanPham[3];
//         danhSachSP[0] = new SanPham("SP001", "San pham thuong", 100000, 50, "Thuong");
//         danhSachSP[1] = new ThucPham("SP002", "Banh mi", 15000, 100, "01/01/2024", "07/01/2024");
//         danhSachSP[2] = new DoChoi("SP003", "Xe do choi", 200000, 20, "3-6 tuoi", "Nhua");
        
//         for (int i = 0; i < danhSachSP.length; i++) {
//             System.out.println("San pham thu " + (i + 1) + ":");
//             danhSachSP[i].xuatThongTin();
//             System.out.println("------------------------");
//         }
        
//         System.out.println("\n3. DEMO QUAN LY MANG DOI TUONG:");
//         System.out.println("================================");
        
//         // Them vao he thong quan ly
//         for (int i = 0; i < 2; i++) {
//             ql.themKhachHang((KhachHang) danhSachNguoi[i]);
//         }
//         for (int i = 2; i < 4; i++) {
//             ql.themNhanVien((NhanVien) danhSachNguoi[i]);
//         }
//         for (int i = 0; i < 3; i++) {
//             ql.themSanPham(danhSachSP[i]);
//         }
        
//         // Xuat danh sach
//         ql.xuatDanhSachKhachHang();
//         ql.xuatDanhSachNhanVien();
//         ql.xuatDanhSachSanPham();
        
//         System.out.println("\n4. DEMO THONG KE:");
//         System.out.println("================================");
//         ql.thongKe();
        
//         System.out.println("\n5. DEMO THUOC TINH STATIC:");
//         System.out.println("================================");
//         System.out.println("Tong so nguoi trong he thong: " + Nguoi.getSoLuongNguoi());
//         System.out.println("Tong so san pham trong he thong: " + SanPham.getSoLuongSanPham());
//         System.out.println("Ten cua hang: " + QuanLyCuaHang.getTenCuaHang());
//         System.out.println("Dia chi cua hang: " + QuanLyCuaHang.getDiaChiCuaHang());
        
//         System.out.println("\n6. DEMO TIM KIEM:");
//         System.out.println("================================");
//         KhachHang khTim = ql.timKhachHang("KH001");
//         if (khTim != null) {
//             System.out.println("Tim thay khach hang:");
//             khTim.xuatThongTin();
//         }
        
//         NhanVien nvTim = ql.timNhanVien("NV001");
//         if (nvTim != null) {
//             System.out.println("Tim thay nhan vien:");
//             nvTim.xuatThongTin();
//         }
        
//         SanPham spTim = ql.timSanPham("SP001");
//         if (spTim != null) {
//             System.out.println("Tim thay san pham:");
//             spTim.xuatThongTin();
//         }
        
//         System.out.println("\n7. DEMO LUU/DOC FILE:");
//         System.out.println("================================");
//         ql.luuDuLieu();
        
//         System.out.println("\n=== KET THUC DEMO ===");
//         System.out.println("Chuong trinh da chay thanh cong!");
//         System.out.println("Tat ca cac yeu cau OOP da duoc thuc hien:");
//         System.out.println("✓ 3 lop doi tuong: KhachHang, NhanVien, SanPham");
//         System.out.println("✓ Doc/ghi file: Interface IFileManager");
//         System.out.println("✓ Interface: IFileManager");
//         System.out.println("✓ Da hinh: Mang Nguoi[] va SanPham[]");
//         System.out.println("✓ Ke thua: KhachHang, NhanVien ke thua tu Nguoi");
//         System.out.println("✓ Ham thiet lap: thietLapThongTinCoBan(), thietLapThongTinCuaHang()");
//         System.out.println("✓ Ham abstract: nhapThongTin(), xuatThongTin(), tinhTien()");
//         System.out.println("✓ Lop mang doi tuong: QuanLyCuaHang");
//         System.out.println("✓ Thuoc tinh static: soLuongNguoi, soLuongSanPham, tenCuaHang, diaChiCuaHang");
//     }
// }
