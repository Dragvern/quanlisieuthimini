// /**
//  * Demo chuc nang thanh toan va cap nhat ton kho
//  */
// public class DemoThanhToan {
//     public static void main(String[] args) {
//         System.out.println("=== DEMO CHUC NANG THANH TOAN ===");
        
//         // Tao doi tuong quan ly
//         QuanLyCuaHang ql = new QuanLyCuaHang();
        
//         // Thiet lap thong tin cua hang
//         QuanLyCuaHang.thietLapThongTinCuaHang("Cua hang Mini", "123 Duong ABC, Quan 5, TP.HCM");
        
//         System.out.println("\n1. KHOI TAO DU LIEU:");
//         System.out.println("====================");
        
//         // Them khach hang
//         KhachHang kh1 = new KhachHang("KH001", "Nguyen Van A", "0123456789", "123 Duong A", "VIP");
//         KhachHang kh2 = new KhachHang("KH002", "Tran Thi B", "0987654321", "456 Duong B", "Thuong");
//         ql.themKhachHang(kh1);
//         ql.themKhachHang(kh2);
        
//         // Them nhan vien
//         NhanVien nv1 = new NhanVien("NV001", "Le Van C", "0111222333", "789 Duong C", "Nhan vien", 5000000.0, 22);
//         ql.themNhanVien(nv1);
        
//         // Them san pham
//         SanPham sp1 = new SanPham("SP001", "Banh mi", 15000, 100, "Thuc pham");
//         SanPham sp2 = new SanPham("SP002", "Nuoc ngot", 10000, 50, "Do uong");
//         SanPham sp3 = new SanPham("SP003", "Keo", 5000, 200, "Do an vat");
//         ql.themSanPham(sp1);
//         ql.themSanPham(sp2);
//         ql.themSanPham(sp3);
        
//         System.out.println("Da khoi tao du lieu thanh cong!");
        
//         System.out.println("\n2. TON KHO BAN DAU:");
//         System.out.println("===================");
//         ql.xuatDanhSachSanPham();
        
//         System.out.println("\n3. TAO HOA DON:");
//         System.out.println("================");
//         HoaDon hd1 = ql.taoHoaDon("HD001", "KH001", "NV001", "23/10/2024");
        
//         System.out.println("\n4. THEM SAN PHAM VAO HOA DON:");
//         System.out.println("==============================");
//         ql.themSanPhamVaoHoaDon("HD001", "SP001", 5);  // 5 banh mi
//         ql.themSanPhamVaoHoaDon("HD001", "SP002", 3);  // 3 nuoc ngot
//         ql.themSanPhamVaoHoaDon("HD001", "SP003", 10); // 10 keo
        
//         System.out.println("\n5. TON KHO TRUOC KHI THANH TOAN:");
//         System.out.println("=================================");
//         ql.xuatDanhSachSanPham();
        
//         System.out.println("\n6. THANH TOAN HOA DON:");
//         System.out.println("======================");
//         ql.thanhToanHoaDon("HD001");
        
//         System.out.println("\n7. TON KHO SAU KHI THANH TOAN:");
//         System.out.println("===============================");
//         ql.xuatDanhSachSanPham();
        
//         System.out.println("\n8. DEMO HOA DON KHAC:");
//         System.out.println("=====================");
//         HoaDon hd2 = ql.taoHoaDon("HD002", "KH002", "NV001", "23/10/2024");
//         ql.themSanPhamVaoHoaDon("HD002", "SP001", 2);  // 2 banh mi
//         ql.themSanPhamVaoHoaDon("HD002", "SP003", 5);  // 5 keo
//         ql.thanhToanHoaDon("HD002");
        
//         System.out.println("\n9. TON KHO CUOI CUNG:");
//         System.out.println("======================");
//         ql.xuatDanhSachSanPham();
        
//         System.out.println("\n10. DANH SACH HOA DON:");
//         System.out.println("======================");
//         ql.xuatDanhSachHoaDon();
        
//         System.out.println("\n11. THONG KE CUOI CUNG:");
//         System.out.println("========================");
//         ql.capNhatThongKe();
        
//         System.out.println("\n=== KET THUC DEMO THANH TOAN ===");
//         System.out.println("Chuc nang thanh toan da hoat dong thanh cong!");
//         System.out.println("✓ Tao hoa don");
//         System.out.println("✓ Them san pham vao hoa don");
//         System.out.println("✓ Kiem tra ton kho");
//         System.out.println("✓ Thanh toan va cap nhat ton kho");
//         System.out.println("✓ Quan ly danh sach hoa don");
//     }
// }

